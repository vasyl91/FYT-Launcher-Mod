package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.platform.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final List<VisibilityAnimatorProvider> additionalAnimatorProviders = new ArrayList();
    private final P primaryAnimatorProvider;
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    int getDurationThemeAttrResId(boolean z) {
        return 0;
    }

    int getEasingThemeAttrResId(boolean z) {
        return 0;
    }

    protected MaterialVisibility(P p, VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.primaryAnimatorProvider = p;
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    public void setSecondaryAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    public void addAdditionalAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.additionalAnimatorProviders.add(visibilityAnimatorProvider);
    }

    public boolean removeAdditionalAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return this.additionalAnimatorProviders.remove(visibilityAnimatorProvider);
    }

    public void clearAdditionalAnimatorProvider() {
        this.additionalAnimatorProviders.clear();
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, false);
    }

    private Animator createAnimator(ViewGroup viewGroup, View view, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        addAnimatorIfNeeded(arrayList, this.primaryAnimatorProvider, viewGroup, view, z);
        addAnimatorIfNeeded(arrayList, this.secondaryAnimatorProvider, viewGroup, view, z);
        Iterator<VisibilityAnimatorProvider> it = this.additionalAnimatorProviders.iterator();
        while (it.hasNext()) {
            addAnimatorIfNeeded(arrayList, it.next(), viewGroup, view, z);
        }
        maybeApplyThemeValues(viewGroup.getContext(), z);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private static void addAnimatorIfNeeded(List<Animator> list, VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z) {
        Animator animatorCreateDisappear;
        if (visibilityAnimatorProvider == null) {
            return;
        }
        if (z) {
            animatorCreateDisappear = visibilityAnimatorProvider.createAppear(viewGroup, view);
        } else {
            animatorCreateDisappear = visibilityAnimatorProvider.createDisappear(viewGroup, view);
        }
        if (animatorCreateDisappear != null) {
            list.add(animatorCreateDisappear);
        }
    }

    private void maybeApplyThemeValues(Context context, boolean z) {
        TransitionUtils.maybeApplyThemeDuration(this, context, getDurationThemeAttrResId(z));
        TransitionUtils.maybeApplyThemeInterpolator(this, context, getEasingThemeAttrResId(z), getDefaultEasingInterpolator(z));
    }

    TimeInterpolator getDefaultEasingInterpolator(boolean z) {
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }
}
