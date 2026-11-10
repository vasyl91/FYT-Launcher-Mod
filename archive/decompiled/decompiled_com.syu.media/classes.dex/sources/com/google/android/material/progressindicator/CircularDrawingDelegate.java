package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private float adjustedRadius;
    private int arcDirectionFactor;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    public CircularDrawingDelegate(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.arcDirectionFactor = 1;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(Canvas canvas, float f) {
        float f2 = (((CircularProgressIndicatorSpec) this.spec).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
        canvas.translate(f2, f2);
        canvas.rotate(-90.0f);
        float f3 = -f2;
        canvas.clipRect(f3, f3, f2, f2);
        this.arcDirectionFactor = ((CircularProgressIndicatorSpec) this.spec).indicatorDirection == 0 ? 1 : -1;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) this.spec).trackThickness * f;
        this.displayedCornerRadius = ((CircularProgressIndicatorSpec) this.spec).trackCornerRadius * f;
        this.adjustedRadius = (((CircularProgressIndicatorSpec) this.spec).indicatorSize - ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
            this.adjustedRadius += ((1.0f - f) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        } else if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            this.adjustedRadius -= ((1.0f - f) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillIndicator(Canvas canvas, Paint paint, float f, float f2, int i) {
        if (f == f2) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(this.displayedTrackThickness);
        int i2 = this.arcDirectionFactor;
        float f3 = f * 360.0f * i2;
        float f4 = (f2 >= f ? f2 - f : (f2 + 1.0f) - f) * 360.0f * i2;
        float f5 = this.adjustedRadius;
        canvas.drawArc(new RectF(-f5, -f5, f5, f5), f3, f4, false, paint);
        if (this.displayedCornerRadius <= 0.0f || Math.abs(f4) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        float f6 = this.displayedCornerRadius;
        RectF rectF = new RectF(-f6, -f6, f6, f6);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f3, true, rectF);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f3 + f4, false, rectF);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(Canvas canvas, Paint paint) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(iCompositeARGBWithAlpha);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f = this.adjustedRadius;
        canvas.drawArc(new RectF(-f, -f, f, f), 0.0f, 360.0f, false, paint);
    }

    private int getSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize + (((CircularProgressIndicatorSpec) this.spec).indicatorInset * 2);
    }

    private void drawRoundedEnd(Canvas canvas, Paint paint, float f, float f2, float f3, boolean z, RectF rectF) {
        float f4 = z ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f3);
        float f5 = f / 2.0f;
        float f6 = f4 * f2;
        canvas.drawRect((this.adjustedRadius - f5) + f2, Math.min(0.0f, this.arcDirectionFactor * f6), (this.adjustedRadius + f5) - f2, Math.max(0.0f, f6 * this.arcDirectionFactor), paint);
        canvas.translate((this.adjustedRadius - f5) + f2, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f4) * 90.0f * this.arcDirectionFactor, true, paint);
        canvas.translate(f - (f2 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f4 * 90.0f * this.arcDirectionFactor, true, paint);
        canvas.restore();
    }
}
