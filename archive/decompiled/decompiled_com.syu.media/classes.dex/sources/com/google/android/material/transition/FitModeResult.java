package com.google.android.material.transition;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class FitModeResult {
    final float currentEndHeight;
    final float currentEndWidth;
    final float currentStartHeight;
    final float currentStartWidth;
    final float endScale;
    final float startScale;

    FitModeResult(float f, float f2, float f3, float f4, float f5, float f6) {
        this.startScale = f;
        this.endScale = f2;
        this.currentStartWidth = f3;
        this.currentStartHeight = f4;
        this.currentEndWidth = f5;
        this.currentEndHeight = f6;
    }
}
