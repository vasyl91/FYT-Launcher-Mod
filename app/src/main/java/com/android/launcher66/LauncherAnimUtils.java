package com.android.launcher66;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.HashSet;
import java.util.Iterator;

public class LauncherAnimUtils {
    private static ViewTreeObserver.OnDrawListener onDrawListener;
    static HashSet<Animator> sAnimators = new HashSet<>();
    static Animator.AnimatorListener sEndAnimListener = new Animator.AnimatorListener() { 
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
        a.addListener(sEndAnimListener);
    }

    public static void startAnimationAfterNextDraw(final Animator animator, final View view) {
        onDrawListener = new ViewTreeObserver.OnDrawListener() { 
            private boolean mStarted = false;

            @Override
            public void onDraw() {
                if (!this.mStarted) {
                    this.mStarted = true;
                    if (animator.getDuration() != 0) {
                        animator.start();
                        View view2 = view;
                        final View view3 = view;
                        view2.post(new Runnable() { 
                            @Override
                            public void run() {
                                view3.getViewTreeObserver().removeOnDrawListener(onDrawListener);
                            }
                        });
                    }
                }
            }
        };
        view.getViewTreeObserver().addOnDrawListener(onDrawListener);
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
