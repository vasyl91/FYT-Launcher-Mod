package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class GrayscaleTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.GrayscaleTransformation.1";
    private static final int VERSION = 1;

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return -1580689316;
    }

    public String toString() {
        return "GrayscaleTransformation()";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap bitmap = pool.get(toTransform.getWidth(), toTransform.getHeight(), toTransform.getConfig() != null ? toTransform.getConfig() : Bitmap.Config.ARGB_8888);
        setCanvasBitmapDensity(toTransform, bitmap);
        Canvas canvas = new Canvas(bitmap);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        return bitmap;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        return o instanceof GrayscaleTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID.getBytes(CHARSET));
    }
}
