package com.android.launcher66;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public class LauncherAnimUtils {

    // UWAGA: nie przywracaj pola typu:
    //     private static ViewTreeObserver.OnDrawListener onDrawListener;
    // Anonimowa klasa OnDrawListener trzyma przechwycony View przez syntetyczne pole val$view,
    // a View trzyma mContext == Activity. Statyczne pole = referencja żyjąca tak długo jak
    // proces => wyciek całego Launchera przy każdym obrocie/odtworzeniu Activity.

    static final HashSet<Animator> sAnimators = new HashSet<>();

    static final Animator.AnimatorListener sEndAnimListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
            LauncherAnimUtils.sAnimators.add(animation);
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            LauncherAnimUtils.sAnimators.remove(animation);
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            LauncherAnimUtils.sAnimators.remove(animation);
        }
    };

    public static void cancelOnDestroyActivity(Animator a) {
        if (a != null) {
            a.addListener(sEndAnimListener);
        }
    }

    public static void startAnimationAfterNextDraw(final Animator animator, final View view) {
        if (animator == null || view == null) {
            return;
        }

        final ViewTreeObserver registeredOn = view.getViewTreeObserver();
        if (registeredOn == null || !registeredOn.isAlive()) {
            return;
        }

        // View trzymany słabo: jeśli Activity zginie przed kolejnym rysowaniem,
        // nic tutaj nie przedłuża mu życia.
        final WeakReference<View> viewRef = new WeakReference<>(view);

        // Jednoelementowa tablica pozwala anonimowej klasie wyrejestrować samą siebie
        // z zagnieżdżonego Runnable (zamiast statycznego pola, które było źródłem wycieku).
        final ViewTreeObserver.OnDrawListener[] self = new ViewTreeObserver.OnDrawListener[1];

        self[0] = new ViewTreeObserver.OnDrawListener() {
            private boolean mStarted = false;

            @Override
            public void onDraw() {
                if (this.mStarted) {
                    return;
                }
                this.mStarted = true;

                final View target = viewRef.get();
                final ViewTreeObserver.OnDrawListener listener = self[0];
                self[0] = null;

                // Wyrejestrowanie BEZWARUNKOWE. Stary kod robił to tylko gdy
                // getDuration() != 0, więc anulowana (0 ms) animacja zostawiała
                // listener podpięty na zawsze. removeOnDrawListener() nie może być
                // wołane w trakcie dispatchu onDraw(), stąd post().
                if (target != null) {
                    target.post(new Runnable() {
                        @Override
                        public void run() {
                            detach(target, registeredOn, listener);
                        }
                    });
                } else {
                    detach(null, registeredOn, listener);
                }

                // getDuration() == 0 jest umownym sygnałem "animacja anulowana".
                if (target != null && animator.getDuration() != 0) {
                    animator.start();
                }
            }
        };

        registeredOn.addOnDrawListener(self[0]);
    }

    /**
     * Zdejmuje listener z aktualnego obserwatora View (po attach/detach ViewTreeObserver
     * jest podmieniany przez merge()), a w razie potrzeby z tego, na którym rejestrowaliśmy.
     */
    private static void detach(View view, ViewTreeObserver registeredOn,
                               ViewTreeObserver.OnDrawListener listener) {
        if (listener == null) {
            return;
        }
        ViewTreeObserver current = (view != null) ? view.getViewTreeObserver() : null;
        if (current != null && current.isAlive()) {
            try {
                current.removeOnDrawListener(listener);
            } catch (IllegalStateException ignored) {
            }
        }
        if (registeredOn != null && registeredOn != current && registeredOn.isAlive()) {
            try {
                registeredOn.removeOnDrawListener(listener);
            } catch (IllegalStateException ignored) {
            }
        }
    }

    public static void onDestroyActivity() {
        HashSet<Animator> animators = new HashSet<>(sAnimators);
        Iterator<Animator> it = animators.iterator();
        while (it.hasNext()) {
            Animator a = it.next();
            if (a.isRunning()) {
                a.cancel();
            } else {
                sAnimators.remove(a);
            }
        }
        // cancel() powinien zdjąć animator przez sEndAnimListener, ale jeśli któryś
        // nie wyśle callbacku, statyczny set trzymałby jego target View => Activity.
        sAnimators.clear();
    }

    public static AnimatorSet createAnimatorSet() {
        AnimatorSet anim = new AnimatorSet();
        cancelOnDestroyActivity(anim);
        return anim;
    }

    public static ValueAnimator ofFloat(View target, float... values) {
        ValueAnimator anim = new ValueAnimator();
        anim.setFloatValues(values);
        cancelOnDestroyActivity(anim);
        return anim;
    }

    public static ObjectAnimator ofFloat(View target, String propertyName, float... values) {
        ObjectAnimator anim = new ObjectAnimator();
        anim.setTarget(target);
        anim.setPropertyName(propertyName);
        anim.setFloatValues(values);
        cancelOnDestroyActivity(anim);
        new FirstFrameAnimatorHelper(anim, target);
        return anim;
    }

    public static ObjectAnimator ofPropertyValuesHolder(View target, PropertyValuesHolder... values) {
        ObjectAnimator anim = new ObjectAnimator();
        anim.setTarget(target);
        anim.setValues(values);
        cancelOnDestroyActivity(anim);
        new FirstFrameAnimatorHelper(anim, target);
        return anim;
    }

    public static ObjectAnimator ofPropertyValuesHolder(Object target, View view, PropertyValuesHolder... values) {
        ObjectAnimator anim = new ObjectAnimator();
        anim.setTarget(target);
        anim.setValues(values);
        cancelOnDestroyActivity(anim);
        new FirstFrameAnimatorHelper(anim, view);
        return anim;
    }
}
