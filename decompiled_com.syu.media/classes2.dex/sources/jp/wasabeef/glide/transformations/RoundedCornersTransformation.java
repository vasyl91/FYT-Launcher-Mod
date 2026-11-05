package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RoundedCornersTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.RoundedCornersTransformation.1";
    private static final int VERSION = 1;
    private final CornerType cornerType;
    private final int diameter;
    private final int margin;
    private final int radius;

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCornersTransformation(int radius, int margin) {
        this(radius, margin, CornerType.ALL);
    }

    public RoundedCornersTransformation(int radius, int margin, CornerType cornerType) {
        this.radius = radius;
        this.diameter = radius * 2;
        this.margin = margin;
        this.cornerType = cornerType;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        Bitmap bitmap = pool.get(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setHasAlpha(true);
        setCanvasBitmapDensity(toTransform, bitmap);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(toTransform, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        drawRoundRect(canvas, paint, width, height);
        return bitmap;
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float width, float height) {
        int i = this.margin;
        float f = width - i;
        float f2 = height - i;
        switch (AnonymousClass1.$SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[this.cornerType.ordinal()]) {
            case 1:
                int i2 = this.margin;
                RectF rectF = new RectF(i2, i2, f, f2);
                int i3 = this.radius;
                canvas.drawRoundRect(rectF, i3, i3, paint);
                break;
            case 2:
                drawTopLeftRoundRect(canvas, paint, f, f2);
                break;
            case 3:
                drawTopRightRoundRect(canvas, paint, f, f2);
                break;
            case 4:
                drawBottomLeftRoundRect(canvas, paint, f, f2);
                break;
            case 5:
                drawBottomRightRoundRect(canvas, paint, f, f2);
                break;
            case 6:
                drawTopRoundRect(canvas, paint, f, f2);
                break;
            case 7:
                drawBottomRoundRect(canvas, paint, f, f2);
                break;
            case 8:
                drawLeftRoundRect(canvas, paint, f, f2);
                break;
            case 9:
                drawRightRoundRect(canvas, paint, f, f2);
                break;
            case 10:
                drawOtherTopLeftRoundRect(canvas, paint, f, f2);
                break;
            case 11:
                drawOtherTopRightRoundRect(canvas, paint, f, f2);
                break;
            case 12:
                drawOtherBottomLeftRoundRect(canvas, paint, f, f2);
                break;
            case 13:
                drawOtherBottomRightRoundRect(canvas, paint, f, f2);
                break;
            case 14:
                drawDiagonalFromTopLeftRoundRect(canvas, paint, f, f2);
                break;
            case 15:
                drawDiagonalFromTopRightRoundRect(canvas, paint, f, f2);
                break;
            default:
                int i4 = this.margin;
                RectF rectF2 = new RectF(i4, i4, f, f2);
                int i5 = this.radius;
                canvas.drawRoundRect(rectF2, i5, i5, paint);
                break;
        }
    }

    /* JADX INFO: renamed from: jp.wasabeef.glide.transformations.RoundedCornersTransformation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType;

        static {
            int[] iArr = new int[CornerType.values().length];
            $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$jp$wasabeef$glide$transformations$RoundedCornersTransformation$CornerType[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    private void drawTopLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.margin;
        int i2 = this.diameter;
        RectF rectF = new RectF(i, i, i + i2, i + i2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF(i4, i4 + i5, i4 + i5, bottom), paint);
        int i6 = this.margin;
        canvas.drawRect(new RectF(this.radius + i6, i6, right, bottom), paint);
    }

    private void drawTopRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.diameter;
        int i2 = this.margin;
        RectF rectF = new RectF(right - i, i2, right, i2 + i);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.margin;
        canvas.drawRect(new RectF(i4, i4, right - this.radius, bottom), paint);
        int i5 = this.radius;
        canvas.drawRect(new RectF(right - i5, this.margin + i5, right, bottom), paint);
    }

    private void drawBottomLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.margin;
        int i2 = this.diameter;
        RectF rectF = new RectF(i, bottom - i2, i + i2, bottom);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.margin;
        canvas.drawRect(new RectF(i4, i4, i4 + this.diameter, bottom - this.radius), paint);
        int i5 = this.margin;
        canvas.drawRect(new RectF(this.radius + i5, i5, right, bottom), paint);
    }

    private void drawBottomRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.diameter;
        RectF rectF = new RectF(right - i, bottom - i, right, bottom);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF(i3, i3, right - this.radius, bottom), paint);
        int i4 = this.radius;
        canvas.drawRect(new RectF(right - i4, this.margin, right, bottom - i4), paint);
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.margin;
        RectF rectF = new RectF(i, i, right, i + this.diameter);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF(i3, i3 + this.radius, right, bottom), paint);
    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF(this.margin, bottom - this.diameter, right, bottom);
        int i = this.radius;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.margin;
        canvas.drawRect(new RectF(i2, i2, right, bottom - this.radius), paint);
    }

    private void drawLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.margin;
        RectF rectF = new RectF(i, i, i + this.diameter, bottom);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.margin;
        canvas.drawRect(new RectF(this.radius + i3, i3, right, bottom), paint);
    }

    private void drawRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF(right - this.diameter, this.margin, right, bottom);
        int i = this.radius;
        canvas.drawRoundRect(rectF, i, i, paint);
        int i2 = this.margin;
        canvas.drawRect(new RectF(i2, i2, right - this.radius, bottom), paint);
    }

    private void drawOtherTopLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF(this.margin, bottom - this.diameter, right, bottom);
        int i = this.radius;
        canvas.drawRoundRect(rectF, i, i, paint);
        RectF rectF2 = new RectF(right - this.diameter, this.margin, right, bottom);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF2, i2, i2, paint);
        int i3 = this.margin;
        int i4 = this.radius;
        canvas.drawRect(new RectF(i3, i3, right - i4, bottom - i4), paint);
    }

    private void drawOtherTopRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.margin;
        RectF rectF = new RectF(i, i, i + this.diameter, bottom);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(this.margin, bottom - this.diameter, right, bottom);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF(i4 + i5, i4, right, bottom - i5), paint);
    }

    private void drawOtherBottomLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.margin;
        RectF rectF = new RectF(i, i, right, i + this.diameter);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(right - this.diameter, this.margin, right, bottom);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        int i4 = this.margin;
        int i5 = this.radius;
        canvas.drawRect(new RectF(i4, i4 + i5, right - i5, bottom), paint);
    }

    private void drawOtherBottomRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.margin;
        RectF rectF = new RectF(i, i, right, i + this.diameter);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.margin;
        RectF rectF2 = new RectF(i3, i3, i3 + this.diameter, bottom);
        int i4 = this.radius;
        canvas.drawRoundRect(rectF2, i4, i4, paint);
        int i5 = this.margin;
        int i6 = this.radius;
        canvas.drawRect(new RectF(i5 + i6, i5 + i6, right, bottom), paint);
    }

    private void drawDiagonalFromTopLeftRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.margin;
        int i2 = this.diameter;
        RectF rectF = new RectF(i, i, i + i2, i + i2);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.diameter;
        RectF rectF2 = new RectF(right - i4, bottom - i4, right, bottom);
        int i5 = this.radius;
        canvas.drawRoundRect(rectF2, i5, i5, paint);
        int i6 = this.margin;
        int i7 = this.radius;
        canvas.drawRect(new RectF(i6, i6 + i7, right - i7, bottom), paint);
        int i8 = this.margin;
        int i9 = this.radius;
        canvas.drawRect(new RectF(i8 + i9, i8, right, bottom - i9), paint);
    }

    private void drawDiagonalFromTopRightRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        int i = this.diameter;
        int i2 = this.margin;
        RectF rectF = new RectF(right - i, i2, right, i2 + i);
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.margin;
        int i5 = this.diameter;
        RectF rectF2 = new RectF(i4, bottom - i5, i4 + i5, bottom);
        int i6 = this.radius;
        canvas.drawRoundRect(rectF2, i6, i6, paint);
        int i7 = this.margin;
        int i8 = this.radius;
        canvas.drawRect(new RectF(i7, i7, right - i8, bottom - i8), paint);
        int i9 = this.margin;
        int i10 = this.radius;
        canvas.drawRect(new RectF(i9 + i10, i9 + i10, right, bottom), paint);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.radius + ", margin=" + this.margin + ", diameter=" + this.diameter + ", cornerType=" + this.cornerType.name() + ")";
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        if (o instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) o;
            if (roundedCornersTransformation.radius == this.radius && roundedCornersTransformation.diameter == this.diameter && roundedCornersTransformation.margin == this.margin && roundedCornersTransformation.cornerType == this.cornerType) {
                return true;
            }
        }
        return false;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return 425235636 + (this.radius * 10000) + (this.diameter * 1000) + (this.margin * 100) + (this.cornerType.ordinal() * 10);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius + this.diameter + this.margin + this.cornerType).getBytes(CHARSET));
    }
}
