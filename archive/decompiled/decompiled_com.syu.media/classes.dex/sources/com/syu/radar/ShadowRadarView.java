package com.syu.radar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ShadowRadarView extends RadarView {
    public ShadowRadarView(Context context) {
        super(context);
    }

    public final void a(Canvas canvas, RectF rectF, int i, int i2, float f, float f2, int i3) {
        boolean zIsDrawing = isDrawing(i2, i);
        int i4 = this.m;
        int i5 = zIsDrawing ? i4 * 6 : i4;
        Path drawArc = getDrawArc(rectF, i5, f, f2);
        this.b = drawArc;
        drawPath(canvas, i3, this.l, i2, i, this.c, drawArc, rectF);
        float f3 = i5;
        rectF.inset(f3, f3);
        this.c.setShader(null);
        this.b = getDrawArc(rectF, 3, f, f2);
        this.c.setShadowLayer(5.0f, -1.0f, -1.0f, i3);
        drawPath(canvas, -1, -1, i2, i, this.c, this.b);
        rectF.inset(3.0f, 3.0f);
        this.c.clearShadowLayer();
    }

    public final void b(Canvas canvas, RectF rectF, int i, int i2, int i3, boolean z) {
        boolean zIsDrawing = isDrawing(i2, i);
        if (z) {
            this.b = getDrawRectf(rectF, 1.5f, 0.0f);
            rectF.set(rectF.left - 1.5f, rectF.top, rectF.right, rectF.bottom);
        } else {
            this.b = getDrawRectf(rectF, 0.0f, 1.5f);
            rectF.set(rectF.left, rectF.top, rectF.right + 1.5f, rectF.bottom);
        }
        int i4 = this.m;
        int i5 = i4 * 6;
        if (zIsDrawing) {
            i4 = i5;
        }
        drawRectPath2(canvas, i3, this.l, i2, i, this.c, z ? getDrawRectf(rectF, i4, 0, true) : getDrawRectf(rectF, 0, i4, false), rectF, z);
        this.c.setShader(null);
        this.c.setShadowLayer(5.0f, -1.0f, -1.0f, i3);
        drawPath(canvas, -1, -1, i2, i, this.c, this.b);
        this.c.clearShadowLayer();
        rectF.inset(3.0f, 0.0f);
    }

    @Override // com.syu.radar.RadarView
    public void drawPath(Canvas canvas, int i, int i2, int i3, int i4, Paint paint, Path path) {
        int drawingColor = getDrawingColor(getDrawingColor(i3, i4, i), i2, isDrawing(i3, i4), false);
        if (drawingColor != Integer.MIN_VALUE) {
            paint.setColor(drawingColor);
            canvas.drawPath(path, paint);
        }
    }

    public void drawRectPath(Canvas canvas, int i, int i2, int i3, int i4, Paint paint, RectF rectF, RectF rectF2, boolean z) {
        int drawingColor = getDrawingColor(getDrawingColor(i3, i4, i), i2, isDrawing(i3, i4), false);
        if (drawingColor != Integer.MIN_VALUE) {
            float f = (rectF2.left + rectF2.right) / 2.0f;
            float f2 = rectF2.top;
            float f3 = rectF2.bottom;
            paint.setShader(new LinearGradient(f, (f2 + f3) / 2.0f, f, z ? f2 : f3, drawingColor & (-1325400065), drawingColor & 16777215, Shader.TileMode.CLAMP));
            canvas.drawRect(rectF, paint);
            canvas.drawRect(rectF, paint);
        }
    }

    public void drawRectPath2(Canvas canvas, int i, int i2, int i3, int i4, Paint paint, RectF rectF, RectF rectF2, boolean z) {
        int drawingColor = getDrawingColor(getDrawingColor(i3, i4, i), i2, isDrawing(i3, i4), false);
        if (drawingColor != Integer.MIN_VALUE) {
            float f = rectF2.left;
            float f2 = rectF2.right;
            float f3 = (f + f2) / 2.0f;
            float f4 = (rectF2.top + rectF2.bottom) / 2.0f;
            paint.setShader(new LinearGradient(f3, f4, z ? f : f2, f4, drawingColor & (-1325400065), drawingColor & 16777215, Shader.TileMode.CLAMP));
            canvas.drawRect(rectF, paint);
            canvas.drawRect(rectF, paint);
        }
    }

    @Override // com.syu.radar.RadarView
    public Path getDrawArc(RectF rectF, int i, float f, float f2) {
        return super.getDrawArc(rectF, i, f, f2);
    }

    @Override // com.syu.radar.RadarView
    public Path getDrawRectf(RectF rectF, float f, float f2) {
        return super.getDrawRectf(rectF, f, f2);
    }

    @Override // com.syu.radar.RadarView
    public Path getDrawRectfH(RectF rectF, float f, float f2) {
        return super.getDrawRectfH(rectF, f, f2);
    }

    @Override // com.syu.radar.RadarView
    public int getDrawingColor(int i, int i2, boolean z, boolean z2) {
        if (z) {
            return i;
        }
        if (z2) {
            return i2;
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.syu.radar.RadarView
    public void horizontalDrawing(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        RectF rectF = this.g;
        if (rectF == null && this.h == null) {
            return;
        }
        if (rectF == null || rectF.width() <= 0.0f || this.g.height() <= 0.0f) {
            Drawable drawable = this.h;
            if (drawable != null) {
                int intrinsicWidth = (int) ((drawable.getIntrinsicWidth() * this.i) + 0.5f);
                int intrinsicHeight = (int) ((this.h.getIntrinsicHeight() * this.i) + 0.5f);
                RectF rectF2 = this.f;
                rectF2.left = (width - intrinsicWidth) / 2;
                rectF2.top = (height - intrinsicHeight) / 2;
                rectF2.right = (width + intrinsicWidth) / 2;
                rectF2.bottom = (height + intrinsicHeight) / 2;
            }
        } else {
            this.f.set(this.g);
        }
        if (this.f.width() <= 0.0f || this.f.height() <= 0.0f) {
            return;
        }
        float fHeight = this.f.height();
        RectF rectF3 = this.f;
        float f = rectF3.left;
        float f2 = rectF3.top;
        float f3 = rectF3.right;
        float f4 = rectF3.bottom;
        float f5 = ((f3 - f) - fHeight) / 2.0f;
        RectF rectF4 = new RectF(f, f2, f + fHeight, f4);
        float f6 = rectF4.right - (fHeight / 2.0f);
        RectF rectF5 = new RectF(f6, rectF4.top, f6 + f5, rectF4.bottom);
        RectF rectF6 = new RectF(rectF5);
        float f7 = rectF5.right;
        RectF rectF7 = new RectF(f7, rectF5.top, f5 + f7, rectF5.bottom);
        RectF rectF8 = new RectF(rectF7);
        RectF rectF9 = new RectF(f3 - fHeight, f2, f3, f4);
        float f8 = this.a;
        float f9 = -f8;
        rectF4.inset(f9, f9);
        rectF5.set(rectF5.left, rectF5.top, rectF5.right, rectF5.bottom + f8);
        rectF6.set(rectF6.left, rectF6.top - f8, rectF6.right, rectF6.bottom);
        rectF7.set(rectF7.left, rectF7.top, rectF7.right, rectF7.bottom + f8);
        rectF8.set(rectF8.left, rectF8.top - f8, rectF8.right, rectF8.bottom);
        rectF9.inset(f9, f9);
        int i = 0;
        while (true) {
            int i2 = this.o;
            if (i >= i2) {
                break;
            }
            int iBlendj = this.d.blendj(this.j, this.k, i, i2);
            int i3 = i;
            a(canvas, rectF4, i3, 8, 270.0f, 40.0f, iBlendj);
            a(canvas, rectF4, i3, 0, 230.0f, 25.0f, iBlendj);
            a(canvas, rectF4, i3, 1, 205.0f, 25.0f, iBlendj);
            a(canvas, rectF4, i3, 2, 180.0f, 25.0f, iBlendj);
            a(canvas, rectF4, i3, 3, 155.0f, 25.0f, iBlendj);
            a(canvas, rectF4, i3, 12, 130.0f, 40.0f, iBlendj);
            float f10 = -this.m;
            rectF4.inset(f10, f10);
            a(canvas, rectF9, i3, 15, 90.0f, 40.0f, iBlendj);
            a(canvas, rectF9, i3, 7, 50.0f, 25.0f, iBlendj);
            a(canvas, rectF9, i3, 6, 25.0f, 25.0f, iBlendj);
            a(canvas, rectF9, i3, 5, 0.0f, 25.0f, iBlendj);
            a(canvas, rectF9, i3, 4, -25.0f, 25.0f, iBlendj);
            a(canvas, rectF9, i3, 11, 310.0f, 40.0f, iBlendj);
            float f11 = -this.m;
            rectF9.inset(f11, f11);
            a(canvas, rectF5, i3, 9, iBlendj, false);
            a(canvas, rectF6, i3, 13, iBlendj, true);
            a(canvas, rectF7, i3, 10, iBlendj, false);
            a(canvas, rectF8, i3, 14, iBlendj, true);
            i++;
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            RectF rectF10 = this.f;
            drawable2.setBounds(new Rect((int) rectF10.left, (int) rectF10.top, (int) rectF10.right, (int) rectF10.bottom));
            this.h.draw(canvas);
        }
    }

    @Override // com.syu.radar.RadarView
    public boolean isDrawing(int i, int i2) {
        Radar radar = (Radar) this.e.get(i, null);
        int intensity = radar.getIntensity();
        return radar.isEnable() && intensity >= 0 && i2 < radar.getMax() && i2 == intensity;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.n = 0;
    }

    @Override // com.syu.radar.RadarView
    public void verticalDrawing(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        RectF rectF = this.g;
        if (rectF == null && this.h == null) {
            return;
        }
        if (rectF == null || rectF.width() <= 0.0f || this.g.height() <= 0.0f) {
            Drawable drawable = this.h;
            if (drawable != null) {
                int intrinsicWidth = (int) ((drawable.getIntrinsicWidth() * this.i) + 0.5f);
                int intrinsicHeight = (int) ((this.h.getIntrinsicHeight() * this.i) + 0.5f);
                RectF rectF2 = this.f;
                rectF2.left = (width - intrinsicWidth) / 2;
                rectF2.top = (height - intrinsicHeight) / 2;
                rectF2.right = (width + intrinsicWidth) / 2;
                rectF2.bottom = (height + intrinsicHeight) / 2;
            }
        } else {
            this.f.set(this.g);
        }
        if (this.f.width() <= 0.0f || this.f.height() <= 0.0f) {
            return;
        }
        float fWidth = this.f.width();
        RectF rectF3 = this.f;
        float f = rectF3.left;
        float f2 = rectF3.top;
        float f3 = rectF3.right;
        float f4 = rectF3.bottom;
        float f5 = ((f4 - f2) - fWidth) / 2.0f;
        RectF rectF4 = new RectF(f, f2, f3, f2 + fWidth);
        float f6 = rectF4.left;
        float f7 = rectF4.bottom - (fWidth / 2.0f);
        RectF rectF5 = new RectF(f6, f7, rectF4.right, f7 + f5);
        RectF rectF6 = new RectF(rectF5);
        float f8 = rectF5.left;
        float f9 = rectF5.bottom;
        RectF rectF7 = new RectF(f8, f9, rectF5.right, f5 + f9);
        RectF rectF8 = new RectF(rectF7);
        RectF rectF9 = new RectF(f, f4 - fWidth, f3, f4);
        float f10 = this.a;
        float f11 = -f10;
        rectF4.inset(f11, f11);
        rectF5.set(rectF5.left - f10, rectF5.top, rectF5.right, rectF5.bottom);
        rectF6.set(rectF6.left, rectF6.top, rectF6.right + f10, rectF6.bottom);
        rectF7.set(rectF7.left - f10, rectF7.top, rectF7.right, rectF7.bottom);
        rectF8.set(rectF8.left, rectF8.top, rectF8.right + f10, rectF8.bottom);
        rectF9.inset(f11, f11);
        int i = 0;
        while (true) {
            int i2 = this.o;
            if (i >= i2) {
                break;
            }
            int iBlendj = this.d.blendj(this.j, this.k, i, i2);
            int i3 = i;
            a(canvas, rectF4, i3, 8, 180.0f, 40.0f, iBlendj);
            a(canvas, rectF4, i3, 0, 140.0f, 25.0f, iBlendj);
            a(canvas, rectF4, i3, 1, 115.0f, 25.0f, iBlendj);
            a(canvas, rectF4, i3, 2, 90.0f, 25.0f, iBlendj);
            a(canvas, rectF4, i3, 3, 65.0f, 25.0f, iBlendj);
            a(canvas, rectF4, i3, 12, 40.0f, 40.0f, iBlendj);
            float f12 = -this.m;
            rectF4.inset(f12, f12);
            a(canvas, rectF9, i3, 15, 0.0f, 40.0f, iBlendj);
            a(canvas, rectF9, i3, 7, -40.0f, 25.0f, iBlendj);
            a(canvas, rectF9, i3, 6, -65.0f, 25.0f, iBlendj);
            a(canvas, rectF9, i3, 5, -90.0f, 25.0f, iBlendj);
            a(canvas, rectF9, i3, 4, -115.0f, 25.0f, iBlendj);
            a(canvas, rectF9, i3, 11, 220.0f, 40.0f, iBlendj);
            float f13 = -this.m;
            rectF9.inset(f13, f13);
            b(canvas, rectF5, i3, 9, iBlendj, true);
            b(canvas, rectF6, i3, 13, iBlendj, false);
            b(canvas, rectF7, i3, 10, iBlendj, true);
            b(canvas, rectF8, i3, 14, iBlendj, false);
            i++;
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            RectF rectF10 = this.f;
            drawable2.setBounds(new Rect((int) rectF10.left, (int) rectF10.top, (int) rectF10.right, (int) rectF10.bottom));
            this.h.draw(canvas);
        }
    }

    public ShadowRadarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(Canvas canvas, RectF rectF, int i, int i2, int i3, boolean z) {
        boolean zIsDrawing = isDrawing(i2, i);
        if (z) {
            this.b = getDrawRectfH(rectF, 1.5f, 0.0f);
            rectF.set(rectF.left, rectF.top - 1.5f, rectF.right, rectF.bottom);
        } else {
            this.b = getDrawRectfH(rectF, 0.0f, 1.5f);
            rectF.set(rectF.left, rectF.top, rectF.right, rectF.bottom + 1.5f);
        }
        int i4 = this.m;
        int i5 = i4 * 6;
        if (zIsDrawing) {
            i4 = i5;
        }
        drawRectPath(canvas, i3, this.l, i2, i, this.c, z ? getDrawRectfH(rectF, i4, 0, true) : getDrawRectfH(rectF, 0, i4, false), rectF, z);
        this.c.setShader(null);
        this.c.setShadowLayer(5.0f, -1.0f, -1.0f, i3);
        drawPath(canvas, -1, -1, i2, i, this.c, this.b);
        this.c.clearShadowLayer();
        rectF.inset(0.0f, 3.0f);
    }

    public void drawPath(Canvas canvas, int i, int i2, int i3, int i4, Paint paint, Path path, RectF rectF) {
        int drawingColor = getDrawingColor(getDrawingColor(i3, i4, i), i2, isDrawing(i3, i4), false);
        if (drawingColor != Integer.MIN_VALUE) {
            this.c.setShader(new RadialGradient((rectF.left + rectF.right) / 2.0f, (rectF.top + rectF.bottom) / 2.0f, rectF.width() / 2.0f, drawingColor, drawingColor & 16777215, Shader.TileMode.CLAMP));
            canvas.drawPath(path, paint);
            canvas.drawPath(path, paint);
        }
    }

    public RectF getDrawRectf(RectF rectF, int i, int i2, boolean z) {
        float f = rectF.left;
        float f2 = rectF.right;
        float f3 = f - i;
        float f4 = i2 + f2;
        rectF.set(f3, rectF.top, f4, rectF.bottom);
        RectF rectF2 = new RectF();
        if (z) {
            rectF2.left = f3;
            rectF2.right = f;
        } else {
            rectF2.left = f2;
            rectF2.right = f4;
        }
        rectF2.top = rectF.top;
        rectF2.bottom = rectF.bottom;
        return rectF2;
    }

    public RectF getDrawRectfH(RectF rectF, int i, int i2, boolean z) {
        float f = rectF.top;
        float f2 = rectF.bottom;
        float f3 = f - i;
        float f4 = i2 + f2;
        rectF.set(rectF.left, f3, rectF.right, f4);
        RectF rectF2 = new RectF();
        if (z) {
            rectF2.top = f3;
            rectF2.bottom = f;
        } else {
            rectF2.top = f2;
            rectF2.bottom = f4;
        }
        rectF2.left = rectF.left;
        rectF2.right = rectF.right;
        return rectF2;
    }

    public ShadowRadarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
