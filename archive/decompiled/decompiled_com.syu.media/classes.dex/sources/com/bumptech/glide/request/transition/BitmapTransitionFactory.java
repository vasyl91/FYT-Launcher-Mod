package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class BitmapTransitionFactory extends BitmapContainerTransitionFactory<Bitmap> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.transition.BitmapContainerTransitionFactory
    public Bitmap getBitmap(Bitmap bitmap) {
        return bitmap;
    }

    public BitmapTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        super(transitionFactory);
    }
}
