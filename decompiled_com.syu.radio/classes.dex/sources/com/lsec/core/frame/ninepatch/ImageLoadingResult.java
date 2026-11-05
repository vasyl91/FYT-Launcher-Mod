package com.lsec.core.frame.ninepatch;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ImageLoadingResult {
    public final Bitmap bitmap;
    public final NinePatchChunk chunk;

    protected ImageLoadingResult(Bitmap bitmap, NinePatchChunk chunk) {
        this.bitmap = bitmap;
        this.chunk = chunk;
    }

    public NinePatchDrawable getNinePatchDrawable(Resources resources, String strName) {
        if (this.bitmap == null) {
            return null;
        }
        if (this.chunk == null) {
            return new NinePatchDrawable(resources, this.bitmap, null, new Rect(), strName);
        }
        return new NinePatchDrawable(resources, this.bitmap, this.chunk.toBytes(), this.chunk.padding, strName);
    }
}
