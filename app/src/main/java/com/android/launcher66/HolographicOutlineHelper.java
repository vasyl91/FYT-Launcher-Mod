package com.android.launcher66;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.core.view.ViewCompat;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class HolographicOutlineHelper {
    private static final int EXTRA_THICK = 2;
    static HolographicOutlineHelper INSTANCE = null;
    private static final int MEDIUM = 1;
    private static final int THICK = 0;
    private BlurMaskFilter mExtraThickInnerBlurMaskFilter;
    private BlurMaskFilter mExtraThickOuterBlurMaskFilter;
    public int mMaxOuterBlurRadius;
    private BlurMaskFilter mMediumInnerBlurMaskFilter;
    private BlurMaskFilter mMediumOuterBlurMaskFilter;
    public int mMinOuterBlurRadius;
    private BlurMaskFilter mThickInnerBlurMaskFilter;
    private BlurMaskFilter mThickOuterBlurMaskFilter;
    private BlurMaskFilter mThinOuterBlurMaskFilter;
    private final Paint mHolographicPaint = new Paint();
    private final Paint mBlurPaint = new Paint();
    private final Paint mErasePaint = new Paint();

    private HolographicOutlineHelper(Context context) {
        float scale = LauncherAppState.getInstance().getScreenDensity();
        this.mMinOuterBlurRadius = (int) (scale * 1.0f);
        this.mMaxOuterBlurRadius = (int) (scale * 12.0f);
        this.mExtraThickOuterBlurMaskFilter = new BlurMaskFilter(12.0f * scale, BlurMaskFilter.Blur.OUTER);
        this.mThickOuterBlurMaskFilter = new BlurMaskFilter(scale * 6.0f, BlurMaskFilter.Blur.OUTER);
        this.mMediumOuterBlurMaskFilter = new BlurMaskFilter(scale * 2.0f, BlurMaskFilter.Blur.OUTER);
        this.mThinOuterBlurMaskFilter = new BlurMaskFilter(scale * 1.0f, BlurMaskFilter.Blur.OUTER);
        this.mExtraThickInnerBlurMaskFilter = new BlurMaskFilter(scale * 6.0f, BlurMaskFilter.Blur.NORMAL);
        this.mThickInnerBlurMaskFilter = new BlurMaskFilter(4.0f * scale, BlurMaskFilter.Blur.NORMAL);
        this.mMediumInnerBlurMaskFilter = new BlurMaskFilter(scale * 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.mHolographicPaint.setFilterBitmap(true);
        this.mHolographicPaint.setAntiAlias(true);
        this.mBlurPaint.setFilterBitmap(true);
        this.mBlurPaint.setAntiAlias(true);
        this.mErasePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mErasePaint.setFilterBitmap(true);
        this.mErasePaint.setAntiAlias(true);
    }

    public static HolographicOutlineHelper obtain(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new HolographicOutlineHelper(context);
        }
        return INSTANCE;
    }

    public static float highlightAlphaInterpolator(float r) {
        return (float) Math.pow((1.0f - r) * 0.6f, 1.5d);
    }

    public static float viewAlphaInterpolator(float r) {
        if (r < 0.95f) {
            return (float) Math.pow(r / 0.95f, 1.5d);
        }
        return 1.0f;
    }

    void applyExpensiveOutlineWithBlur(Bitmap srcDst, Canvas srcDstCanvas, int color, int outlineColor, int thickness) {
        applyExpensiveOutlineWithBlur(srcDst, srcDstCanvas, color, outlineColor, true, thickness);
    }

    void applyExpensiveOutlineWithBlur(Bitmap srcDst, Canvas srcDstCanvas, int color, int outlineColor, boolean clipAlpha, int thickness) {
        BlurMaskFilter outerBlurMaskFilter;
        BlurMaskFilter innerBlurMaskFilter;
        if (clipAlpha) {
            int[] srcBuffer = new int[srcDst.getWidth() * srcDst.getHeight()];
            srcDst.getPixels(srcBuffer, 0, srcDst.getWidth(), 0, 0, srcDst.getWidth(), srcDst.getHeight());
            for (int i = 0; i < srcBuffer.length; i++) {
                int alpha = srcBuffer[i] >>> 24;
                if (alpha < 188) {
                    srcBuffer[i] = 0;
                }
            }
            srcDst.setPixels(srcBuffer, 0, srcDst.getWidth(), 0, 0, srcDst.getWidth(), srcDst.getHeight());
        }
        Bitmap glowShape = srcDst.extractAlpha();
        switch (thickness) {
            case 0:
                outerBlurMaskFilter = this.mThickOuterBlurMaskFilter;
                break;
            case 1:
                outerBlurMaskFilter = this.mMediumOuterBlurMaskFilter;
                break;
            case 2:
                outerBlurMaskFilter = this.mExtraThickOuterBlurMaskFilter;
                break;
            default:
                throw new RuntimeException("Invalid blur thickness");
        }
        this.mBlurPaint.setMaskFilter(outerBlurMaskFilter);
        int[] outerBlurOffset = new int[2];
        Bitmap thickOuterBlur = glowShape.extractAlpha(this.mBlurPaint, outerBlurOffset);
        if (thickness == 2) {
            this.mBlurPaint.setMaskFilter(this.mMediumOuterBlurMaskFilter);
        } else {
            this.mBlurPaint.setMaskFilter(this.mThinOuterBlurMaskFilter);
        }
        int[] brightOutlineOffset = new int[2];
        Bitmap brightOutline = glowShape.extractAlpha(this.mBlurPaint, brightOutlineOffset);
        srcDstCanvas.setBitmap(glowShape);
        srcDstCanvas.drawColor(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_OUT);
        switch (thickness) {
            case 0:
                innerBlurMaskFilter = this.mThickInnerBlurMaskFilter;
                break;
            case 1:
                innerBlurMaskFilter = this.mMediumInnerBlurMaskFilter;
                break;
            case 2:
                innerBlurMaskFilter = this.mExtraThickInnerBlurMaskFilter;
                break;
            default:
                throw new RuntimeException("Invalid blur thickness");
        }
        this.mBlurPaint.setMaskFilter(innerBlurMaskFilter);
        int[] thickInnerBlurOffset = new int[2];
        Bitmap thickInnerBlur = glowShape.extractAlpha(this.mBlurPaint, thickInnerBlurOffset);
        srcDstCanvas.setBitmap(thickInnerBlur);
        srcDstCanvas.drawBitmap(glowShape, -thickInnerBlurOffset[0], -thickInnerBlurOffset[1], this.mErasePaint);
        srcDstCanvas.drawRect(0.0f, 0.0f, -thickInnerBlurOffset[0], thickInnerBlur.getHeight(), this.mErasePaint);
        srcDstCanvas.drawRect(0.0f, 0.0f, thickInnerBlur.getWidth(), -thickInnerBlurOffset[1], this.mErasePaint);
        srcDstCanvas.setBitmap(srcDst);
        srcDstCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.mHolographicPaint.setColor(color);
        srcDstCanvas.drawBitmap(thickInnerBlur, thickInnerBlurOffset[0], thickInnerBlurOffset[1], this.mHolographicPaint);
        srcDstCanvas.drawBitmap(thickOuterBlur, outerBlurOffset[0], outerBlurOffset[1], this.mHolographicPaint);
        this.mHolographicPaint.setColor(outlineColor);
        srcDstCanvas.drawBitmap(brightOutline, brightOutlineOffset[0], brightOutlineOffset[1], this.mHolographicPaint);
        srcDstCanvas.setBitmap(null);
        brightOutline.recycle();
        thickOuterBlur.recycle();
        thickInnerBlur.recycle();
        glowShape.recycle();
    }

    void applyExtraThickExpensiveOutlineWithBlur(Bitmap srcDst, Canvas srcDstCanvas, int color, int outlineColor) {
        applyExpensiveOutlineWithBlur(srcDst, srcDstCanvas, color, outlineColor, 2);
    }

    void applyThickExpensiveOutlineWithBlur(Bitmap srcDst, Canvas srcDstCanvas, int color, int outlineColor) {
        applyExpensiveOutlineWithBlur(srcDst, srcDstCanvas, color, outlineColor, 0);
    }

    void applyMediumExpensiveOutlineWithBlur(Bitmap srcDst, Canvas srcDstCanvas, int color, int outlineColor, boolean clipAlpha) {
        applyExpensiveOutlineWithBlur(srcDst, srcDstCanvas, color, outlineColor, clipAlpha, 1);
    }

    void applyMediumExpensiveOutlineWithBlur(Bitmap srcDst, Canvas srcDstCanvas, int color, int outlineColor) {
        applyExpensiveOutlineWithBlur(srcDst, srcDstCanvas, color, outlineColor, 1);
    }
}
