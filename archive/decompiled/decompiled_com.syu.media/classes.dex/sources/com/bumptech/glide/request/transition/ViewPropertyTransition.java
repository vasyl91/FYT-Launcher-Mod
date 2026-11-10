package com.bumptech.glide.request.transition;

import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ViewPropertyTransition<R> implements Transition<R> {
    private final Animator animator;

    public interface Animator {
        void animate(View view);
    }

    public ViewPropertyTransition(Animator animator) {
        this.animator = animator;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
        if (viewAdapter.getView() == null) {
            return false;
        }
        this.animator.animate(viewAdapter.getView());
        return false;
    }
}
