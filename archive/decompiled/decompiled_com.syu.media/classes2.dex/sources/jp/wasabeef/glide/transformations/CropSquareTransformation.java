package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CropSquareTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropSquareTransformation.1";
    private static final int VERSION = 1;
    private int size;

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        int iMax = Math.max(outWidth, outHeight);
        this.size = iMax;
        return TransformationUtils.centerCrop(pool, toTransform, iMax, iMax);
    }

    public String toString() {
        return "CropSquareTransformation(size=" + this.size + ")";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        return (o instanceof CropSquareTransformation) && ((CropSquareTransformation) o).size == this.size;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return (-789843280) + (this.size * 10);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.size).getBytes(CHARSET));
    }
}
