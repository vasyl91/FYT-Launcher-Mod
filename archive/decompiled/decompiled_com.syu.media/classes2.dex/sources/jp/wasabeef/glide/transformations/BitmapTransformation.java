package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    public abstract boolean equals(Object o);

    public abstract int hashCode();

    protected abstract Bitmap transform(Context context, BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight);

    public abstract void updateDiskCacheKey(MessageDigest messageDigest);

    public final Resource<Bitmap> transform(Context context, Resource<Bitmap> resource, int outWidth, int outHeight) {
        if (!Util.isValidDimensions(outWidth, outHeight)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + outWidth + " or height: " + outHeight + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
        Bitmap bitmap = (Bitmap) resource.get();
        if (outWidth == Integer.MIN_VALUE) {
            outWidth = bitmap.getWidth();
        }
        int i = outWidth;
        if (outHeight == Integer.MIN_VALUE) {
            outHeight = bitmap.getHeight();
        }
        Bitmap bitmapTransform = transform(context.getApplicationContext(), bitmapPool, bitmap, i, outHeight);
        return bitmap.equals(bitmapTransform) ? resource : BitmapResource.obtain(bitmapTransform, bitmapPool);
    }

    void setCanvasBitmapDensity(Bitmap toTransform, Bitmap canvasBitmap) {
        canvasBitmap.setDensity(toTransform.getDensity());
    }
}
