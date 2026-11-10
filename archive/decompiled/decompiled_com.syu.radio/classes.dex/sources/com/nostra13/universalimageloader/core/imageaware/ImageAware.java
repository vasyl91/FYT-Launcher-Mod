package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface ImageAware {
    int getHeight();

    int getId();

    ViewScaleType getScaleType();

    int getWidth();

    View getWrappedView();

    boolean isCollected();

    boolean setImageBitmap(Bitmap bitmap);

    boolean setImageDrawable(Drawable drawable);
}
