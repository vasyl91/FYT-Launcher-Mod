package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.animation.MotionSpec;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
interface MotionStrategy {
    void addAnimationListener(Animator.AnimatorListener animatorListener);

    AnimatorSet createAnimator();

    MotionSpec getCurrentMotionSpec();

    int getDefaultMotionSpecResource();

    List<Animator.AnimatorListener> getListeners();

    MotionSpec getMotionSpec();

    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationStart(Animator animator);

    void onChange(ExtendedFloatingActionButton.OnChangedCallback onChangedCallback);

    void performNow();

    void removeAnimationListener(Animator.AnimatorListener animatorListener);

    void setMotionSpec(MotionSpec motionSpec);

    boolean shouldCancel();
}
