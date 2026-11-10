package com.syu.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ>\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJF\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\tJ&\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J&\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019¨\u0006\u001f"}, d2 = {"Lcom/syu/utils/Graphics;", "", "Landroid/graphics/Canvas;", "canvas", "", "cx", "cy", "radius", "thick", "Landroid/graphics/Paint;", "paint", "", "drawRing", "Landroid/graphics/RectF;", "rect", "startAngle", "sweepAngle", "angle", "drawTickMarkOfCircle", "", "inter", "", "mark", "Landroid/graphics/PointF;", "pointOfCircleAt", "", "start", "end", "index", "count", "blendColor", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class Graphics {
    public static final Graphics INSTANCE = new Graphics();

    public final int blendColor(int start, int end, int index, int count) {
        int i = (int) ((index * 256) / count);
        int i2 = 255 - i;
        return (((((start & 255) * i2) + ((end & 255) * i)) / 256) & 255) | (((((((start >> 24) & 255) * i2) + (((end >> 24) & 255) * i)) / 256) & 255) << 24) | (((((((start >> 16) & 255) * i2) + (((end >> 16) & 255) * i)) / 256) & 255) << 16) | (((((((start >> 8) & 255) * i2) + (((end >> 8) & 255) * i)) / 256) & 255) << 8);
    }

    public final void drawRing(Canvas canvas, float cx, float cy, float radius, float thick, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Path path = new Path();
        path.addCircle(cx, cy, radius, Path.Direction.CW);
        path.addCircle(cx, cy, radius + thick, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }

    public final void drawTickMarkOfCircle(Canvas canvas, float cx, float cy, float radius, float angle, float thick, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        double d = ((double) (angle % 360.0f)) * 0.017453292519943295d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f = (radius * fCos) + cx;
        float f2 = (radius * fSin) + cy;
        float f3 = radius + thick;
        canvas.drawLine(f, f2, (fCos * f3) + cx, (f3 * fSin) + cy, paint);
    }

    public final PointF pointOfCircleAt(float cx, float cy, float radius, float angle) {
        double d = ((double) (angle % 360.0f)) * 0.017453292519943295d;
        return new PointF((((float) Math.cos(d)) * radius) + cx, (radius * ((float) Math.sin(d))) + cy);
    }

    public final void drawRing(Canvas canvas, RectF rect, float thick, float startAngle, float sweepAngle, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Path path = new Path();
        path.addArc(rect, startAngle, sweepAngle);
        float f = -thick;
        rect.inset(f, f);
        path.arcTo(rect, startAngle + sweepAngle, -sweepAngle);
        path.close();
        canvas.drawPath(path, paint);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007a  */
    /* JADX WARN: Code duplicated, block: B:29:0x007c A[PHI: r3 r10
  0x007c: PHI (r3v23 float) = (r3v14 float), (r3v17 float), (r3v24 float) binds: [B:52:0x00b8, B:47:0x00a8, B:28:0x007b] A[DONT_GENERATE, DONT_INLINE]
  0x007c: PHI (r10v4 int) = (r10v3 int), (r10v3 int), (r10v5 int) binds: [B:52:0x00b8, B:47:0x00a8, B:28:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
    public final void drawTickMarkOfCircle(Canvas canvas, float cx, float cy, float radius, float angle, boolean inter, String mark, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(mark, "mark");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float f = angle % 360.0f;
        if (f < 0.0f) {
            f += 360.0f;
        }
        paint.setColor((f > 135.0f ? 1 : (f == 135.0f ? 0 : -1)) == 0 ? -65536 : -1);
        double d = ((double) f) * 0.017453292519943295d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f2 = (fCos * radius) + cx;
        float f3 = (radius * fSin) + cy;
        Rect rect = new Rect();
        float fMeasureText = paint.measureText(mark);
        paint.getTextBounds(mark, 0, mark.length(), rect);
        int iHeight = rect.height();
        if (f == 0.0f) {
            if (inter) {
                f2 -= fMeasureText;
            }
            iHeight /= 2;
            f3 += iHeight;
        } else {
            if (f == 180.0f) {
                if (!inter) {
                    f2 -= fMeasureText;
                }
                iHeight /= 2;
                f3 += iHeight;
            } else {
                if (f <= 0.0f || f > 90.0f) {
                    if (f <= 90.0f || f >= 180.0f) {
                        if (f <= 180.0f || f > 270.0f) {
                            f2 = inter ? (f2 - fMeasureText) - ((fMeasureText / 2) * fSin) : ((fMeasureText / 2) * fSin) + f2;
                            if (inter) {
                                f3 += iHeight;
                            }
                        } else {
                            f2 += (fMeasureText / 2) * fSin;
                            if (inter) {
                                f3 += iHeight;
                            }
                        }
                    } else if (!inter) {
                    }
                } else if (inter) {
                    f2 -= fMeasureText;
                }
                f2 += (fMeasureText / 2) * fSin;
            }
        }
        canvas.drawText(mark, f2, f3, paint);
    }
}
