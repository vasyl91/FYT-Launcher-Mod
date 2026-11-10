package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.BitmapTransitionFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class BitmapTransitionOptions extends TransitionOptions<BitmapTransitionOptions, Bitmap> {
    public static BitmapTransitionOptions withCrossFade() {
        return new BitmapTransitionOptions().crossFade();
    }

    public static BitmapTransitionOptions withCrossFade(int i) {
        return new BitmapTransitionOptions().crossFade(i);
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new BitmapTransitionOptions().crossFade(drawableCrossFadeFactory);
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory.Builder builder) {
        return new BitmapTransitionOptions().crossFade(builder);
    }

    public static BitmapTransitionOptions withWrapped(TransitionFactory<Drawable> transitionFactory) {
        return new BitmapTransitionOptions().transitionUsing(transitionFactory);
    }

    public static BitmapTransitionOptions with(TransitionFactory<Bitmap> transitionFactory) {
        return new BitmapTransitionOptions().transition(transitionFactory);
    }

    public BitmapTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.Builder());
    }

    public BitmapTransitionOptions crossFade(int i) {
        return crossFade(new DrawableCrossFadeFactory.Builder(i));
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return transitionUsing(drawableCrossFadeFactory);
    }

    public BitmapTransitionOptions transitionUsing(TransitionFactory<Drawable> transitionFactory) {
        return transition(new BitmapTransitionFactory(transitionFactory));
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory.Builder builder) {
        return transitionUsing(builder.build());
    }

    @Override // com.bumptech.glide.TransitionOptions
    public boolean equals(Object obj) {
        return (obj instanceof BitmapTransitionOptions) && super.equals(obj);
    }

    @Override // com.bumptech.glide.TransitionOptions
    public int hashCode() {
        return super.hashCode();
    }
}
