package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {
    private ViewPropertyTransition<R> animation;
    private final ViewPropertyTransition.Animator animator;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator animator) {
        this.animator = animator;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.get();
        }
        if (this.animation == null) {
            this.animation = new ViewPropertyTransition<>(this.animator);
        }
        return this.animation;
    }
}
