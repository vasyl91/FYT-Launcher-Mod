package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.internal.FastBlur;
import jp.wasabeef.glide.transformations.internal.RSBlur;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class BlurTransformation extends BitmapTransformation {
    private static final int DEFAULT_DOWN_SAMPLING = 1;
    private static final String ID = "jp.wasabeef.glide.transformations.BlurTransformation.1";
    private static final int MAX_RADIUS = 25;
    private static final int VERSION = 1;
    private final int radius;
    private final int sampling;

    public BlurTransformation() {
        this(25, 1);
    }

    public BlurTransformation(int radius) {
        this(radius, 1);
    }

    public BlurTransformation(int radius, int sampling) {
        this.radius = radius;
        this.sampling = sampling;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        int i = this.sampling;
        Bitmap bitmap = pool.get(width / i, height / i, Bitmap.Config.ARGB_8888);
        setCanvasBitmapDensity(toTransform, bitmap);
        Canvas canvas = new Canvas(bitmap);
        int i2 = this.sampling;
        canvas.scale(1.0f / i2, 1.0f / i2);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        try {
            return RSBlur.blur(context, bitmap, this.radius);
        } catch (RSRuntimeException unused) {
            return FastBlur.blur(bitmap, this.radius, true);
        }
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.radius + ", sampling=" + this.sampling + ")";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        if (o instanceof BlurTransformation) {
            BlurTransformation blurTransformation = (BlurTransformation) o;
            if (blurTransformation.radius == this.radius && blurTransformation.sampling == this.sampling) {
                return true;
            }
        }
        return false;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return 737513610 + (this.radius * 1000) + (this.sampling * 10);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius + this.sampling).getBytes(CHARSET));
    }
}
