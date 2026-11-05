package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ColorFilterTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.ColorFilterTransformation.1";
    private static final int VERSION = 1;
    private final int color;

    public ColorFilterTransformation(int color) {
        this.color = color;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap bitmap = pool.get(toTransform.getWidth(), toTransform.getHeight(), toTransform.getConfig() != null ? toTransform.getConfig() : Bitmap.Config.ARGB_8888);
        setCanvasBitmapDensity(toTransform, bitmap);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(new PorterDuffColorFilter(this.color, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        return bitmap;
    }

    public String toString() {
        return "ColorFilterTransformation(color=" + this.color + ")";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        return (o instanceof ColorFilterTransformation) && ((ColorFilterTransformation) o).color == this.color;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return 705373712 + (this.color * 10);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.color).getBytes(CHARSET));
    }
}
