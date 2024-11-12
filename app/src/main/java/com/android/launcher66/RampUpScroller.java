package com.android.launcher66;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
class RampUpScroller {
    private long mDeltaTime;
    private int mDeltaX;
    private int mDeltaY;
    private final Interpolator mInterpolator = new AccelerateInterpolator();
    private final long mRampUpTime;
    private long mStartTime;
    private float mTargetVelocityX;
    private float mTargetVelocityY;

    public RampUpScroller(long rampUpTime) {
        this.mRampUpTime = rampUpTime;
    }

    public void start() {
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDeltaTime = this.mStartTime;
    }

    public void computeScrollDelta() {
        float scale;
        long currentTime = AnimationUtils.currentAnimationTimeMillis();
        long elapsedSinceStart = currentTime - this.mStartTime;
        if (elapsedSinceStart < this.mRampUpTime) {
            scale = this.mInterpolator.getInterpolation(((float) elapsedSinceStart) / ((float) this.mRampUpTime));
        } else {
            scale = 1.0f;
        }
        long elapsedSinceDelta = currentTime - this.mDeltaTime;
        this.mDeltaTime = currentTime;
        this.mDeltaX = (int) (((float) elapsedSinceDelta) * scale * this.mTargetVelocityX);
        this.mDeltaY = (int) (((float) elapsedSinceDelta) * scale * this.mTargetVelocityY);
    }

    public void setTargetVelocity(float x, float y) {
        this.mTargetVelocityX = x;
        this.mTargetVelocityY = y;
    }

    public float getTargetVelocityX() {
        return this.mTargetVelocityX;
    }

    public float getTargetVelocityY() {
        return this.mTargetVelocityY;
    }

    public int getDeltaX() {
        return this.mDeltaX;
    }

    public int getDeltaY() {
        return this.mDeltaY;
    }
}
