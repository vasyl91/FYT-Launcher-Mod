package com.android.launcher66;

import android.graphics.Rect;

/* compiled from: WidgetPreviewLoader.java */
/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
class RectCache extends SoftReferenceThreadLocal<Rect> {
    RectCache() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.launcher66.SoftReferenceThreadLocal
    public Rect initialValue() {
        return new Rect();
    }
}
