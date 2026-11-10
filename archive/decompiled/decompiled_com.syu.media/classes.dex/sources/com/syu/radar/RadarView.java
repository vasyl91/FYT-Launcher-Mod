package com.syu.radar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class RadarView extends View {
    public static final int END_COLOR = -16711936;
    public static final int HORIZONTAL = 0;
    public static final int IDLE_COLOR = Color.parseColor("#77BEBEBE");
    public static final int START_COLOR = -65536;
    public static final int VERTICAL = 1;
    public int a;
    public Path b;
    public final Paint c;
    public final DrawUtils d;
    public final SparseArray e;
    public final RectF f;
    public RectF g;
    public Drawable h;
    public float i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;

    public RadarView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.c.setFlags(5);
        setup(0, this.o - 2, -1);
        setup(1, this.o, -1);
        setup(2, this.o, -1);
        setup(3, this.o - 2, -1);
        setup(4, this.o - 2, -1);
        setup(5, this.o, -1);
        setup(6, this.o, -1);
        setup(7, this.o - 2, -1);
        setup(8, this.o - 4, -1);
        setup(9, this.o - 4, -1);
        setup(10, this.o - 4, -1);
        setup(11, this.o - 4, -1);
        setup(12, this.o - 4, -1);
        setup(13, this.o - 4, -1);
        setup(14, this.o - 4, -1);
        setup(15, this.o - 4, -1);
    }

    public Path drawArc(Canvas canvas, RectF rectF, int i, float f, float f2, Paint paint) {
        Path path = new Path();
        path.addArc(rectF, -f, f2);
        float f3 = -i;
        rectF.inset(f3, f3);
        path.arcTo(rectF, f2 - f, -f2);
        path.close();
        canvas.drawPath(path, paint);
        return path;
    }

    public void drawPath(Canvas canvas, int i, int i2, int i3, int i4, Paint paint, Path path) {
        int drawingColor = getDrawingColor(getDrawingColor(i3, i4, i), i2, isDrawing(i3, i4), isDrawSpace(i3, i4));
        if (drawingColor != Integer.MIN_VALUE) {
            paint.setColor(drawingColor);
            canvas.drawPath(path, paint);
        }
    }

    public void drawRectf(Canvas canvas, RectF rectF, int i, int i2, Paint paint) {
        Path path = new Path();
        path.addRect(rectF, Path.Direction.CW);
        rectF.set(rectF.left - i, rectF.top, rectF.right + i2, rectF.bottom);
        path.addRect(rectF, Path.Direction.CCW);
        path.close();
        canvas.drawPath(path, paint);
    }

    public void enableRadar(int i, boolean z) {
        Radar radar = (Radar) this.e.get(i, null);
        if (radar != null) {
            radar.setEnable(z);
        }
    }

    public RectF getCarModelRect() {
        if (this.f != null) {
            return new RectF(this.f);
        }
        return null;
    }

    public Path getDrawArc(RectF rectF, int i, float f, float f2) {
        Path path = new Path();
        path.addArc(rectF, -f, f2);
        float f3 = -i;
        rectF.inset(f3, f3);
        path.arcTo(rectF, f2 - f, -f2);
        path.close();
        return path;
    }

    public Path getDrawRectf(RectF rectF, float f, float f2) {
        Path path = new Path();
        path.addRect(rectF, Path.Direction.CW);
        rectF.set(rectF.left - f, rectF.top, rectF.right + f2, rectF.bottom);
        path.addRect(rectF, Path.Direction.CCW);
        path.close();
        return path;
    }

    public Path getDrawRectfH(RectF rectF, float f, float f2) {
        Path path = new Path();
        path.addRect(rectF, Path.Direction.CW);
        rectF.set(rectF.left, rectF.top - f, rectF.right, rectF.bottom + f2);
        path.addRect(rectF, Path.Direction.CCW);
        path.close();
        return path;
    }

    public int getDrawingColor(int i, int i2, int i3) {
        Radar radar = (Radar) this.e.get(i, null);
        return radar != null && i2 >= 0 && i2 < radar.getMax() && radar.isSelfColor() ? this.d.blendj(radar.getStartColor(), radar.getEndColor(), i2, this.o) : i3;
    }

    public int getDrawingColor(int i, int i2, boolean z, boolean z2) {
        if (z) {
            return i;
        }
        if (z2) {
            return i2;
        }
        return Integer.MIN_VALUE;
    }

    public int getRadarIntensity(int i) {
        Radar radar = (Radar) this.e.get(i, null);
        if (radar != null) {
            return radar.getIntensity();
        }
        return -1;
    }

    public int getRadarMax(int i) {
        Radar radar = (Radar) this.e.get(i, null);
        if (radar != null) {
            return radar.getMax();
        }
        return -1;
    }

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
        RectF rectF4 = new RectF(f + 1.5f, f2, (f + fHeight) - 1.5f, f4);
        float f6 = rectF4.right - (fHeight / 2.0f);
        RectF rectF5 = new RectF(f6 + 3.0f, rectF4.top, ((f6 + 2.0f) - 1.5f) + f5, rectF4.bottom);
        RectF rectF6 = new RectF(rectF5);
        float f7 = rectF5.right + 3.0f;
        RectF rectF7 = new RectF(f7, rectF5.top, (f7 - 3.0f) + f5, rectF5.bottom);
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
            Matrix matrix = new Matrix();
            Path drawArc = getDrawArc(rectF4, this.m, 269.7f, 39.4f);
            this.b = drawArc;
            int i3 = i;
            drawPath(canvas, iBlendj, this.l, 8, i, this.c, drawArc);
            float f10 = this.m;
            rectF4.inset(f10, f10);
            Path drawArc2 = getDrawArc(rectF4, this.m, 229.7f, 24.4f);
            this.b = drawArc2;
            RectF rectF10 = rectF8;
            drawPath(canvas, iBlendj, this.l, 0, i3, this.c, drawArc2);
            matrix.setRotate(25.0f, rectF4.centerX(), rectF4.centerY());
            this.b.transform(matrix);
            drawPath(canvas, iBlendj, this.l, 1, i3, this.c, this.b);
            this.b.transform(matrix);
            drawPath(canvas, iBlendj, this.l, 2, i3, this.c, this.b);
            this.b.transform(matrix);
            drawPath(canvas, iBlendj, this.l, 3, i3, this.c, this.b);
            float f11 = this.m;
            rectF4.inset(f11, f11);
            Path drawArc3 = getDrawArc(rectF4, this.m, 129.7f, 39.4f);
            this.b = drawArc3;
            drawPath(canvas, iBlendj, this.l, 12, i3, this.c, drawArc3);
            float f12 = -this.n;
            rectF4.inset(f12, f12);
            Matrix matrix2 = new Matrix();
            Path drawArc4 = getDrawArc(rectF9, this.m, 89.7f, 39.4f);
            this.b = drawArc4;
            drawPath(canvas, iBlendj, this.l, 15, i3, this.c, drawArc4);
            float f13 = this.m;
            rectF9.inset(f13, f13);
            Path drawArc5 = getDrawArc(rectF9, this.m, 49.7f, 24.4f);
            this.b = drawArc5;
            drawPath(canvas, iBlendj, this.l, 7, i3, this.c, drawArc5);
            matrix2.setRotate(25.0f, rectF9.centerX(), rectF9.centerY());
            this.b.transform(matrix2);
            drawPath(canvas, iBlendj, this.l, 6, i3, this.c, this.b);
            this.b.transform(matrix2);
            drawPath(canvas, iBlendj, this.l, 5, i3, this.c, this.b);
            this.b.transform(matrix2);
            drawPath(canvas, iBlendj, this.l, 4, i3, this.c, this.b);
            float f14 = this.m;
            rectF9.inset(f14, f14);
            Path drawArc6 = getDrawArc(rectF9, this.m, 309.7f, 39.4f);
            this.b = drawArc6;
            drawPath(canvas, iBlendj, this.l, 11, i3, this.c, drawArc6);
            float f15 = -this.n;
            rectF9.inset(f15, f15);
            Path drawRectfH = getDrawRectfH(rectF5, 0.0f, this.m);
            this.b = drawRectfH;
            drawPath(canvas, iBlendj, this.l, 9, i3, this.c, drawRectfH);
            rectF5.inset(0.0f, -this.n);
            Path drawRectfH2 = getDrawRectfH(rectF6, this.m, 0.0f);
            this.b = drawRectfH2;
            drawPath(canvas, iBlendj, this.l, 13, i3, this.c, drawRectfH2);
            rectF6.inset(0.0f, -this.n);
            Path drawRectfH3 = getDrawRectfH(rectF7, 0.0f, this.m);
            this.b = drawRectfH3;
            drawPath(canvas, iBlendj, this.l, 10, i3, this.c, drawRectfH3);
            rectF7.inset(0.0f, -this.n);
            Path drawRectfH4 = getDrawRectfH(rectF10, this.m, 0.0f);
            this.b = drawRectfH4;
            drawPath(canvas, iBlendj, this.l, 14, i3, this.c, drawRectfH4);
            rectF10.inset(0.0f, -this.n);
            i = i3 + 1;
            rectF8 = rectF10;
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            RectF rectF11 = this.f;
            drawable2.setBounds(new Rect((int) rectF11.left, (int) rectF11.top, (int) rectF11.right, (int) rectF11.bottom));
            this.h.draw(canvas);
        }
    }

    public boolean isDrawSpace(int i, int i2) {
        Radar radar = (Radar) this.e.get(i, null);
        return radar != null && radar.isEnable() && i2 < radar.getMax();
    }

    public boolean isDrawing(int i, int i2) {
        Radar radar = (Radar) this.e.get(i, null);
        int intensity = radar.getIntensity();
        return radar.isEnable() && intensity >= 0 && i2 < radar.getMax() && i2 >= intensity;
    }

    public boolean isHorizontal() {
        return this.p == 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isHorizontal()) {
            horizontalDrawing(canvas);
        } else {
            verticalDrawing(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setCarImage(Drawable drawable, float f) {
        this.h = drawable;
        this.i = f;
    }

    public void setDrawColor(int i, int i2, int i3) {
        this.j = i;
        this.k = i2;
        this.l = i3;
        postInvalidate();
    }

    public void setDrawRect(int i, int i2, int i3, int i4) {
        RectF rectF = this.g;
        if (rectF == null) {
            this.g = new RectF(i, i2, i3, i4);
        } else {
            float f = i;
            if (rectF.left == f && rectF.top == i2 && rectF.right == i3 && rectF.bottom == i4) {
                return;
            } else {
                rectF.set(f, i2, i3, i4);
            }
        }
        postInvalidate();
    }

    public void setOrientation(int i) {
        this.p = i;
    }

    public void setOutsize(int i) {
        this.a = i;
    }

    public void setRadar(int i, int i2) {
        Radar radar = (Radar) this.e.get(i, null);
        if (radar != null) {
            radar.setIntensity(i2);
        }
        postInvalidate();
    }

    public void setSignalLine(int i, int i2) {
        this.m = i;
    }

    public void setup(int i, int i2, int i3) {
        setup(i, i2, i3, -1, -1, false);
    }

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
        float f7 = (rectF4.bottom - (fWidth / 2.0f)) + 1.0f;
        RectF rectF5 = new RectF(f6, f7, rectF4.right, (f7 - 1.0f) + f5);
        RectF rectF6 = new RectF(rectF5);
        float f8 = rectF5.left;
        float f9 = rectF5.bottom + 2.0f;
        RectF rectF7 = new RectF(f8, f9, rectF5.right, (f9 - 2.0f) + f5);
        RectF rectF8 = new RectF(rectF7);
        RectF rectF9 = new RectF(f, (f4 - fWidth) + 1.0f, f3, f4);
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
            Matrix matrix = new Matrix();
            Path drawArc = getDrawArc(rectF4, this.m, 179.7f, 39.4f);
            this.b = drawArc;
            RectF rectF10 = rectF8;
            RectF rectF11 = rectF9;
            drawPath(canvas, iBlendj, this.l, 8, i, this.c, drawArc);
            float f12 = this.m;
            rectF4.inset(f12, f12);
            Path drawArc2 = getDrawArc(rectF4, this.m, 139.7f, 24.4f);
            this.b = drawArc2;
            RectF rectF12 = rectF7;
            drawPath(canvas, iBlendj, this.l, 0, i, this.c, drawArc2);
            matrix.setRotate(25.0f, rectF4.centerX(), rectF4.centerY());
            this.b.transform(matrix);
            int i3 = i;
            drawPath(canvas, iBlendj, this.l, 1, i3, this.c, this.b);
            this.b.transform(matrix);
            drawPath(canvas, iBlendj, this.l, 2, i3, this.c, this.b);
            this.b.transform(matrix);
            drawPath(canvas, iBlendj, this.l, 3, i3, this.c, this.b);
            float f13 = this.m;
            rectF4.inset(f13, f13);
            Path drawArc3 = getDrawArc(rectF4, this.m, 39.7f, 39.4f);
            this.b = drawArc3;
            drawPath(canvas, iBlendj, this.l, 12, i3, this.c, drawArc3);
            float f14 = -this.n;
            rectF4.inset(f14, f14);
            Matrix matrix2 = new Matrix();
            Path drawArc4 = getDrawArc(rectF11, this.m, -0.3f, 39.4f);
            this.b = drawArc4;
            drawPath(canvas, iBlendj, this.l, 15, i3, this.c, drawArc4);
            float f15 = this.m;
            rectF11.inset(f15, f15);
            Path drawArc5 = getDrawArc(rectF11, this.m, -40.3f, 24.4f);
            this.b = drawArc5;
            drawPath(canvas, iBlendj, this.l, 7, i3, this.c, drawArc5);
            matrix2.setRotate(25.0f, rectF11.centerX(), rectF11.centerY());
            this.b.transform(matrix2);
            drawPath(canvas, iBlendj, this.l, 6, i3, this.c, this.b);
            this.b.transform(matrix2);
            drawPath(canvas, iBlendj, this.l, 5, i3, this.c, this.b);
            this.b.transform(matrix2);
            drawPath(canvas, iBlendj, this.l, 4, i3, this.c, this.b);
            float f16 = this.m;
            rectF11.inset(f16, f16);
            Path drawArc6 = getDrawArc(rectF11, this.m, -140.3f, 39.4f);
            this.b = drawArc6;
            drawPath(canvas, iBlendj, this.l, 11, i3, this.c, drawArc6);
            float f17 = -this.n;
            rectF11.inset(f17, f17);
            Path drawRectf = getDrawRectf(rectF5, this.m, 0.0f);
            this.b = drawRectf;
            drawPath(canvas, iBlendj, this.l, 9, i3, this.c, drawRectf);
            rectF5.inset(-this.n, 0.0f);
            Path drawRectf2 = getDrawRectf(rectF6, 0.0f, this.m);
            this.b = drawRectf2;
            drawPath(canvas, iBlendj, this.l, 13, i3, this.c, drawRectf2);
            rectF6.inset(-this.n, 0.0f);
            Path drawRectf3 = getDrawRectf(rectF12, this.m, 0.0f);
            this.b = drawRectf3;
            drawPath(canvas, iBlendj, this.l, 10, i3, this.c, drawRectf3);
            rectF12.inset(-this.n, 0.0f);
            Path drawRectf4 = getDrawRectf(rectF10, 0.0f, this.m);
            this.b = drawRectf4;
            drawPath(canvas, iBlendj, this.l, 14, i3, this.c, drawRectf4);
            rectF10.inset(-this.n, 0.0f);
            i++;
            rectF9 = rectF11;
            rectF8 = rectF10;
            rectF7 = rectF12;
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            RectF rectF13 = this.f;
            drawable2.setBounds(new Rect((int) rectF13.left, (int) rectF13.top, (int) rectF13.right, (int) rectF13.bottom));
            this.h.draw(canvas);
        }
    }

    public RadarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setDrawRect(Rect rect) {
        if (rect != null) {
            setDrawRect(rect.left, rect.top, rect.right, rect.bottom);
        } else {
            this.g = null;
            postInvalidate();
        }
    }

    public void setup(int i, int i2, int i3, int i4, int i5, boolean z) {
        Radar radar = (Radar) this.e.get(i, null);
        if (this.o < i2) {
            this.o = i2;
        }
        if (radar == null) {
            this.e.put(i, new Radar(i, i2, i3, i4, i5, z, true));
        } else {
            radar.setMax(i2);
            radar.setIntensity(i3);
            radar.setColor(i4, i5);
            radar.setEnable(true);
        }
    }

    public RadarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 8;
        this.b = new Path();
        this.c = new Paint();
        this.d = new DrawUtils();
        this.e = new SparseArray();
        this.f = new RectF();
        this.g = null;
        this.h = null;
        this.i = 1.0f;
        this.j = -65536;
        this.k = END_COLOR;
        this.l = IDLE_COLOR;
        this.m = 10;
        this.n = 2;
        this.o = 10;
        this.p = 1;
        a();
    }
}
