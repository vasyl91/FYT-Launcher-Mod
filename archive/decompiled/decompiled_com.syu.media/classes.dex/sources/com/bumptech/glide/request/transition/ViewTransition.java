package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ViewTransition<R> implements Transition<R> {
    private final ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    interface ViewTransitionAnimationFactory {
        Animation build(Context context);
    }

    ViewTransition(ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.viewTransitionAnimationFactory = viewTransitionAnimationFactory;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
        View view = viewAdapter.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.viewTransitionAnimationFactory.build(view.getContext()));
        return false;
    }
}
