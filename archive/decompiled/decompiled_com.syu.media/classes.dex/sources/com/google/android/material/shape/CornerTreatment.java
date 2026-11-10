package com.google.android.material.shape;

import android.graphics.RectF;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f, float f2, ShapePath shapePath) {
    }

    public void getCornerPath(ShapePath shapePath, float f, float f2, float f3) {
        getCornerPath(f, f2, shapePath);
    }

    public void getCornerPath(ShapePath shapePath, float f, float f2, RectF rectF, CornerSize cornerSize) {
        getCornerPath(shapePath, f, f2, cornerSize.getCornerSize(rectF));
    }
}
