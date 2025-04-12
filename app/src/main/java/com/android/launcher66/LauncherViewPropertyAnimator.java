package com.android.launcher66;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;

import java.util.ArrayList;
import java.util.EnumSet;

public class LauncherViewPropertyAnimator extends Animator implements Animator.AnimatorListener {
    float mAlpha;
    long mDuration;
    FirstFrameAnimatorHelper mFirstFrameHelper;
    TimeInterpolator mInterpolator;
    float mRotationY;
    float mScaleX;
    float mScaleY;
    long mStartDelay;
    View mTarget;
    float mTranslationX;
    float mTranslationY;
    ViewPropertyAnimator mViewPropertyAnimator;
    EnumSet<Properties> mPropertiesToSet = EnumSet.noneOf(Properties.class);
    boolean mRunning = false;
    ArrayList<Animator.AnimatorListener> mListeners = new ArrayList<>();

    enum Properties {
        TRANSLATION_X,
        TRANSLATION_Y,
        SCALE_X,
        SCALE_Y,
        ROTATION_Y,
        ALPHA,
        START_DELAY,
        DURATION,
        INTERPOLATOR,
        WITH_LAYER;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Properties[] valuesCustom() {
            Properties[] valuesCustom = values();
            int length = valuesCustom.length;
            Properties[] propertiesArr = new Properties[length];
            System.arraycopy(valuesCustom, 0, propertiesArr, 0, length);
            return propertiesArr;
        }
    }

    public LauncherViewPropertyAnimator(View target) {
        this.mTarget = target;
    }

    @Override
    public void addListener(Animator.AnimatorListener listener) {
        this.mListeners.add(listener);
    }

    @Override
    public void cancel() {
        if (this.mViewPropertyAnimator != null) {
            this.mViewPropertyAnimator.cancel();
        }
    }

    @Override
    public Animator clone() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void end() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public long getDuration() {
        return this.mDuration;
    }

    @Override
    public ArrayList<Animator.AnimatorListener> getListeners() {
        return this.mListeners;
    }

    @Override
    public long getStartDelay() {
        return this.mStartDelay;
    }

    @Override
    public void onAnimationCancel(Animator animation) {
        for (int i = 0; i < this.mListeners.size(); i++) {
            Animator.AnimatorListener listener = this.mListeners.get(i);
            listener.onAnimationCancel(this);
        }
        this.mRunning = false;
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        for (int i = 0; i < this.mListeners.size(); i++) {
            Animator.AnimatorListener listener = this.mListeners.get(i);
            listener.onAnimationEnd(this);
        }
        this.mRunning = false;
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
        for (int i = 0; i < this.mListeners.size(); i++) {
            Animator.AnimatorListener listener = this.mListeners.get(i);
            listener.onAnimationRepeat(this);
        }
    }

    @Override
    public void onAnimationStart(Animator animation) {
        this.mFirstFrameHelper.onAnimationStart(animation);
        for (int i = 0; i < this.mListeners.size(); i++) {
            Animator.AnimatorListener listener = this.mListeners.get(i);
            listener.onAnimationStart(this);
        }
        this.mRunning = true;
    }

    @Override
    public boolean isRunning() {
        return this.mRunning;
    }

    @Override
    public boolean isStarted() {
        return this.mViewPropertyAnimator != null;
    }

    @Override
    public void removeAllListeners() {
        this.mListeners.clear();
    }

    @Override
    public void removeListener(Animator.AnimatorListener listener) {
        this.mListeners.remove(listener);
    }

    @Override
    public Animator setDuration(long duration) {
        this.mPropertiesToSet.add(Properties.DURATION);
        this.mDuration = duration;
        return this;
    }

    @Override
    public void setInterpolator(TimeInterpolator value) {
        this.mPropertiesToSet.add(Properties.INTERPOLATOR);
        this.mInterpolator = value;
    }

    @Override
    public void setStartDelay(long startDelay) {
        this.mPropertiesToSet.add(Properties.START_DELAY);
        this.mStartDelay = startDelay;
    }

    @Override
    public void setTarget(Object target) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setupEndValues() {
    }

    @Override
    public void setupStartValues() {
    }

    @Override
    public void start() {
        this.mViewPropertyAnimator = this.mTarget.animate();
        this.mFirstFrameHelper = new FirstFrameAnimatorHelper(this.mViewPropertyAnimator, this.mTarget);
        if (this.mPropertiesToSet.contains(Properties.TRANSLATION_X)) {
            this.mViewPropertyAnimator.translationX(this.mTranslationX);
        }
        if (this.mPropertiesToSet.contains(Properties.TRANSLATION_Y)) {
            this.mViewPropertyAnimator.translationY(this.mTranslationY);
        }
        if (this.mPropertiesToSet.contains(Properties.SCALE_X)) {
            this.mViewPropertyAnimator.scaleX(this.mScaleX);
        }
        if (this.mPropertiesToSet.contains(Properties.ROTATION_Y)) {
            this.mViewPropertyAnimator.rotationY(this.mRotationY);
        }
        if (this.mPropertiesToSet.contains(Properties.SCALE_Y)) {
            this.mViewPropertyAnimator.scaleY(this.mScaleY);
        }
        if (this.mPropertiesToSet.contains(Properties.ALPHA)) {
            this.mViewPropertyAnimator.alpha(this.mAlpha);
        }
        if (this.mPropertiesToSet.contains(Properties.START_DELAY)) {
            this.mViewPropertyAnimator.setStartDelay(this.mStartDelay);
        }
        if (this.mPropertiesToSet.contains(Properties.DURATION)) {
            this.mViewPropertyAnimator.setDuration(this.mDuration);
        }
        if (this.mPropertiesToSet.contains(Properties.INTERPOLATOR)) {
            this.mViewPropertyAnimator.setInterpolator(this.mInterpolator);
        }
        if (this.mPropertiesToSet.contains(Properties.WITH_LAYER)) {
            this.mViewPropertyAnimator.withLayer();
        }
        this.mViewPropertyAnimator.setListener(this);
        this.mViewPropertyAnimator.start();
        LauncherAnimUtils.cancelOnDestroyActivity(this);
    }

    public LauncherViewPropertyAnimator translationX(float value) {
        this.mPropertiesToSet.add(Properties.TRANSLATION_X);
        this.mTranslationX = value;
        return this;
    }

    public LauncherViewPropertyAnimator translationY(float value) {
        this.mPropertiesToSet.add(Properties.TRANSLATION_Y);
        this.mTranslationY = value;
        return this;
    }

    public LauncherViewPropertyAnimator scaleX(float value) {
        this.mPropertiesToSet.add(Properties.SCALE_X);
        this.mScaleX = value;
        return this;
    }

    public LauncherViewPropertyAnimator scaleY(float value) {
        this.mPropertiesToSet.add(Properties.SCALE_Y);
        this.mScaleY = value;
        return this;
    }

    public LauncherViewPropertyAnimator rotationY(float value) {
        this.mPropertiesToSet.add(Properties.ROTATION_Y);
        this.mRotationY = value;
        return this;
    }

    public LauncherViewPropertyAnimator alpha(float value) {
        this.mPropertiesToSet.add(Properties.ALPHA);
        this.mAlpha = value;
        return this;
    }

    public LauncherViewPropertyAnimator withLayer() {
        this.mPropertiesToSet.add(Properties.WITH_LAYER);
        return this;
    }
}
