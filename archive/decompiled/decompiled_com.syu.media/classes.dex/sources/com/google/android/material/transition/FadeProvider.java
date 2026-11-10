package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class FadeProvider implements VisibilityAnimatorProvider {
    private float incomingEndThreshold = 1.0f;

    public float getIncomingEndThreshold() {
        return this.incomingEndThreshold;
    }

    public void setIncomingEndThreshold(float f) {
        this.incomingEndThreshold = f;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator createAppear(ViewGroup viewGroup, View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeAnimator(view, 0.0f, alpha, 0.0f, this.incomingEndThreshold, alpha);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator createDisappear(ViewGroup viewGroup, View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeAnimator(view, alpha, 0.0f, 0.0f, 1.0f, alpha);
    }

    private static Animator createFadeAnimator(final View view, final float f, final float f2, final float f3, final float f4, final float f5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transition.FadeProvider.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(TransitionUtils.lerp(f, f2, f3, f4, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.FadeProvider.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setAlpha(f5);
            }
        });
        return valueAnimatorOfFloat;
    }
}
