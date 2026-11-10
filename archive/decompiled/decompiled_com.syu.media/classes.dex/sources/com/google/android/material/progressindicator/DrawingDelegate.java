package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    protected DrawableWithAnimatedVisibilityChange drawable;
    S spec;

    abstract void adjustCanvas(Canvas canvas, float f);

    abstract void fillIndicator(Canvas canvas, Paint paint, float f, float f2, int i);

    abstract void fillTrack(Canvas canvas, Paint paint);

    abstract int getPreferredHeight();

    abstract int getPreferredWidth();

    public DrawingDelegate(S s) {
        this.spec = s;
    }

    protected void registerDrawable(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
        this.drawable = drawableWithAnimatedVisibilityChange;
    }

    void validateSpecAndAdjustCanvas(Canvas canvas, float f) {
        this.spec.validateSpec();
        adjustCanvas(canvas, f);
    }
}
