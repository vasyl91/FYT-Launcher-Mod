package com.android.launcher66;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;

public class InterruptibleInOutAnimator {
    private static final int IN = 1;
    private static final int OUT = 2;
    private static final int STOPPED = 0;
    private ValueAnimator mAnimator;
    private long mOriginalDuration;
    private float mOriginalFromValue;
    private float mOriginalToValue;
    private boolean mFirstRun = true;
    private Object mTag = null;
    private int mDirection = 0;

    public InterruptibleInOutAnimator(View view, long duration, float fromValue, float toValue) {
        this.mAnimator = LauncherAnimUtils.ofFloat(view, fromValue, toValue).setDuration(duration);
        this.mOriginalDuration = duration;
        this.mOriginalFromValue = fromValue;
        this.mOriginalToValue = toValue;
        this.mAnimator.addListener(new AnimatorListenerAdapter() { 
            @Override
            public void onAnimationEnd(Animator animation) {
                InterruptibleInOutAnimator.this.mDirection = 0;
            }
        });
    }

    private void animate(int direction) {
        long currentPlayTime = this.mAnimator.getCurrentPlayTime();
        float toValue = direction == 1 ? this.mOriginalToValue : this.mOriginalFromValue;
        float startValue = this.mFirstRun ? this.mOriginalFromValue : ((Float) this.mAnimator.getAnimatedValue()).floatValue();
        cancel();
        this.mDirection = direction;
        long duration = this.mOriginalDuration - currentPlayTime;
        this.mAnimator.setDuration(Math.max(0L, Math.min(duration, this.mOriginalDuration)));
        this.mAnimator.setFloatValues(startValue, toValue);
        this.mAnimator.start();
        this.mFirstRun = false;
    }

    public void cancel() {
        this.mAnimator.cancel();
        this.mDirection = 0;
    }

    public void end() {
        this.mAnimator.end();
        this.mDirection = 0;
    }

    public boolean isStopped() {
        return this.mDirection == 0;
    }

    public void animateIn() {
        animate(1);
    }

    public void animateOut() {
        animate(2);
    }

    public void setTag(Object tag) {
        this.mTag = tag;
    }

    public Object getTag() {
        return this.mTag;
    }

    public ValueAnimator getAnimator() {
        return this.mAnimator;
    }
}
