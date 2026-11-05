package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class MaskTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.MaskTransformation.1";
    private static final int VERSION = 1;
    private static final Paint paint;
    private final int maskId;

    static {
        Paint paint2 = new Paint();
        paint = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public MaskTransformation(int maskId) {
        this.maskId = maskId;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        Bitmap bitmap = pool.get(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setHasAlpha(true);
        Drawable drawable = context.getDrawable(this.maskId);
        setCanvasBitmapDensity(toTransform, bitmap);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        return bitmap;
    }

    public String toString() {
        return "MaskTransformation(maskId=" + this.maskId + ")";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        return (o instanceof MaskTransformation) && ((MaskTransformation) o).maskId == this.maskId;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return (-1949385457) + (this.maskId * 10);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.maskId).getBytes(CHARSET));
    }
}
