package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CropTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropTransformation.1";
    private static final int VERSION = 1;
    private CropType cropType;
    private int height;
    private int width;

    public enum CropType {
        TOP,
        CENTER,
        BOTTOM
    }

    public CropTransformation(int width, int height) {
        this(width, height, CropType.CENTER);
    }

    public CropTransformation(int width, int height, CropType cropType) {
        CropType cropType2 = CropType.CENTER;
        this.width = width;
        this.height = height;
        this.cropType = cropType;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        int width = this.width;
        if (width == 0) {
            width = toTransform.getWidth();
        }
        this.width = width;
        int height = this.height;
        if (height == 0) {
            height = toTransform.getHeight();
        }
        this.height = height;
        Bitmap bitmap = pool.get(this.width, this.height, toTransform.getConfig() != null ? toTransform.getConfig() : Bitmap.Config.ARGB_8888);
        bitmap.setHasAlpha(true);
        float fMax = Math.max(this.width / toTransform.getWidth(), this.height / toTransform.getHeight());
        float width2 = toTransform.getWidth() * fMax;
        float height2 = fMax * toTransform.getHeight();
        float f = (this.width - width2) / 2.0f;
        float top = getTop(height2);
        RectF rectF = new RectF(f, top, width2 + f, height2 + top);
        setCanvasBitmapDensity(toTransform, bitmap);
        new Canvas(bitmap).drawBitmap(toTransform, (Rect) null, rectF, (Paint) null);
        return bitmap;
    }

    /* JADX INFO: renamed from: jp.wasabeef.glide.transformations.CropTransformation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType;

        static {
            int[] iArr = new int[CropType.values().length];
            $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType = iArr;
            try {
                iArr[CropType.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType[CropType.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType[CropType.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private float getTop(float scaledHeight) {
        int i = AnonymousClass1.$SwitchMap$jp$wasabeef$glide$transformations$CropTransformation$CropType[this.cropType.ordinal()];
        if (i == 2) {
            return (this.height - scaledHeight) / 2.0f;
        }
        if (i != 3) {
            return 0.0f;
        }
        return this.height - scaledHeight;
    }

    public String toString() {
        return "CropTransformation(width=" + this.width + ", height=" + this.height + ", cropType=" + this.cropType + ")";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        if (o instanceof CropTransformation) {
            CropTransformation cropTransformation = (CropTransformation) o;
            if (cropTransformation.width == this.width && cropTransformation.height == this.height && cropTransformation.cropType == this.cropType) {
                return true;
            }
        }
        return false;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return (-1462327117) + (this.width * 100000) + (this.height * 1000) + (this.cropType.ordinal() * 10);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.width + this.height + this.cropType).getBytes(CHARSET));
    }
}
