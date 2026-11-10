package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.internal.Utils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CropCircleWithBorderTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation.1";
    private static final int VERSION = 1;
    private final int borderColor;
    private final int borderSize;

    public CropCircleWithBorderTransformation() {
        this.borderSize = Utils.toDp(4);
        this.borderColor = -16777216;
    }

    public CropCircleWithBorderTransformation(int borderSize, int borderColor) {
        this.borderSize = borderSize;
        this.borderColor = borderColor;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap bitmapCircleCrop = TransformationUtils.circleCrop(pool, toTransform, outWidth, outHeight);
        setCanvasBitmapDensity(toTransform, bitmapCircleCrop);
        Paint paint = new Paint();
        paint.setColor(this.borderColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.borderSize);
        paint.setAntiAlias(true);
        new Canvas(bitmapCircleCrop).drawCircle(outWidth / 2.0f, outHeight / 2.0f, (Math.max(outWidth, outHeight) / 2.0f) - (this.borderSize / 2.0f), paint);
        return bitmapCircleCrop;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.borderSize + this.borderColor).getBytes(CHARSET));
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        if (o instanceof CropCircleWithBorderTransformation) {
            CropCircleWithBorderTransformation cropCircleWithBorderTransformation = (CropCircleWithBorderTransformation) o;
            if (cropCircleWithBorderTransformation.borderSize == this.borderSize && cropCircleWithBorderTransformation.borderColor == this.borderColor) {
                return true;
            }
        }
        return false;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return 882652245 + (this.borderSize * 100) + this.borderColor + 10;
    }
}
