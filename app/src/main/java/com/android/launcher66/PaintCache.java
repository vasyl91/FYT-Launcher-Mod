package com.android.launcher66;

import android.graphics.Paint;

/* compiled from: WidgetPreviewLoader.java */
/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
class PaintCache extends SoftReferenceThreadLocal<Paint> {
    PaintCache() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.launcher66.SoftReferenceThreadLocal
    public Paint initialValue() {
        return null;
    }
}
