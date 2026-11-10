package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FadeInBitmapDisplayer implements BitmapDisplayer {
    private final boolean animateFromDisc;
    private final boolean animateFromMemory;
    private final boolean animateFromNetwork;
    private final int durationMillis;

    public FadeInBitmapDisplayer(int durationMillis) {
        this(durationMillis, true, true, true);
    }

    public FadeInBitmapDisplayer(int durationMillis, boolean animateFromNetwork, boolean animateFromDisc, boolean animateFromMemory) {
        this.durationMillis = durationMillis;
        this.animateFromNetwork = animateFromNetwork;
        this.animateFromDisc = animateFromDisc;
        this.animateFromMemory = animateFromMemory;
    }

    @Override // com.nostra13.universalimageloader.core.display.BitmapDisplayer
    public Bitmap display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        imageAware.setImageBitmap(bitmap);
        if ((this.animateFromNetwork && loadedFrom == LoadedFrom.NETWORK) || ((this.animateFromDisc && loadedFrom == LoadedFrom.DISC_CACHE) || (this.animateFromMemory && loadedFrom == LoadedFrom.MEMORY_CACHE))) {
            animate(imageAware.getWrappedView(), this.durationMillis);
        }
        return bitmap;
    }

    public static void animate(View imageView, int durationMillis) {
        if (imageView != null) {
            AlphaAnimation fadeImage = new AlphaAnimation(0.0f, 1.0f);
            fadeImage.setDuration(durationMillis);
            fadeImage.setInterpolator(new DecelerateInterpolator());
            imageView.startAnimation(fadeImage);
        }
    }
}
