package com.syu.back;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import com.syu.radar.RadarView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class TrackView extends View implements ViewTreeObserver.OnGlobalLayoutListener {
    public float a;
    public int b;
    public int c;
    public Paint d;
    public Paint e;
    public final Module f;
    public OnLoadingListener g;
    public boolean h;
    public boolean i;
    public Module.Track j;

    public interface OnLoadingListener {
        void onLoaded(TrackView trackView);
    }

    public TrackView(Context context) {
        super(context);
        this.a = 0.61086524f;
        this.f = new Module();
        this.g = null;
        this.h = false;
        this.i = false;
        this.j = Module.Track.BENZ;
    }

    public final void a(Canvas canvas, float[] fArr, float[] fArr2, int i, int i2, int i3) {
        Path path = new Path();
        int i4 = i * 2;
        path.moveTo(fArr[i4], fArr[i4 + 1]);
        for (int i5 = i + 1; i5 <= i2; i5++) {
            int i6 = i5 * 2;
            path.lineTo(fArr[i6], fArr[i6 + 1]);
        }
        int i7 = i2 * 2;
        path.lineTo(fArr2[i7], fArr2[i7 + 1]);
        while (i2 >= i) {
            int i8 = i2 * 2;
            path.lineTo(fArr2[i8], fArr2[i8 + 1]);
            i2--;
        }
        path.close();
        this.e.setARGB((i3 >> 24) & 255, (i3 >> 16) & 255, (i3 >> 8) & 255, i3 & 255);
        this.e.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, this.e);
    }

    public float getCameraAngle() {
        return (float) (((double) this.f.e) / 0.017453292519943295d);
    }

    public int getCameraHeight() {
        return this.f.d;
    }

    public float getChcAngle() {
        return (float) (((double) this.f.f) / 0.017453292519943295d);
    }

    public float getMinDis() {
        return this.f.l;
    }

    public float getOffsetX() {
        return this.f.m;
    }

    public int getTailLen() {
        return this.f.c;
    }

    public int getTrack() {
        return this.f.b;
    }

    public Module.Track getType() {
        return this.j;
    }

    public int getWheelBase() {
        return this.f.a;
    }

    public boolean isCalibrating() {
        return this.i;
    }

    public boolean isStatic() {
        return this.h;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b == 0 || this.c == 0) {
            return;
        }
        if (this.d == null) {
            Paint paint = new Paint(5);
            this.d = paint;
            paint.setAntiAlias(true);
            this.d.setStyle(Paint.Style.STROKE);
            this.d.setColor(InputDeviceCompat.SOURCE_ANY);
            this.d.setStrokeWidth(5.0f);
            this.d.setFlags(1);
            this.d.setFilterBitmap(true);
            Paint paint2 = new Paint(5);
            this.e = paint2;
            paint2.setAntiAlias(true);
            this.e.setStrokeWidth(0.5f);
            this.e.setFilterBitmap(true);
        }
        Module module = this.f;
        float fTan = (float) (((double) (module.c + module.a)) / Math.tan((float) (((double) this.a) * 0.017453292519943295d)));
        Module.Circle circle = new Module.Circle(fTan, 0.0f, Math.abs(fTan));
        canvas.save();
        Module module2 = this.f;
        canvas.translate(module2.m, module2.n);
        if (this.i) {
            float f = this.f.b / 2.0f;
            Path path = new Path();
            float f2 = (-f) - 0.5f;
            Module.Point pointA = this.f.a(f2, -0.001f);
            path.moveTo(pointA.a, pointA.b);
            Module.Point pointA2 = this.f.a(f2, -5100.0f);
            path.lineTo(pointA2.a, pointA2.b);
            float f3 = f + 0.5f;
            Module.Point pointA3 = this.f.a(f3, -5100.0f);
            path.lineTo(pointA3.a, pointA3.b);
            Module.Point pointA4 = this.f.a(f3, -0.001f);
            path.lineTo(pointA4.a, pointA4.b);
            path.close();
            this.e.setColor(Color.parseColor("#550101FF"));
            this.e.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawPath(path, this.e);
        }
        Module.Track track = this.j;
        if (track == Module.Track.BENZ) {
            Module.Circle[] circleArrA = this.f.a(circle);
            float[] fArrA = this.f.a(circleArrA[0], this.a < 0.0f);
            a(fArrA, canvas, this.d);
            float[] fArrA2 = this.f.a(circleArrA[1], this.a < 0.0f);
            a(fArrA2, canvas, this.d);
            canvas.drawLines(new float[]{fArrA[10], fArrA[11], fArrA2[10], fArrA2[11]}, this.d);
            this.d.setColor(-65536);
            canvas.drawLines(new float[]{fArrA[0], fArrA[1], fArrA2[0], fArrA2[1]}, this.d);
            this.d.setColor(InputDeviceCompat.SOURCE_ANY);
            this.d.setStrokeWidth(2.5f);
            a(canvas, circleArrA[1], 100, 200);
            a(canvas, circleArrA[0], -100, -200);
            this.d.setStrokeWidth(5.0f);
            this.d.setColor(InputDeviceCompat.SOURCE_ANY);
            canvas.drawLine(fArrA[46], fArrA[47], fArrA2[46], fArrA2[47], this.d);
        } else if (track == Module.Track.AUDI) {
            Module.Circle[] circleArrA2 = this.f.a(circle);
            float[] fArrA3 = this.f.a(circleArrA2[0], this.a < 0.0f);
            float[] fArrA4 = this.f.a(circleArrA2[1], this.a < 0.0f);
            a(canvas, fArrA3, fArrA4, 0, 5, 855704063);
            a(canvas, fArrA3, fArrA4, 5, 12, 1426129407);
            a(canvas, fArrA3, fArrA4, 12, 23, 1996554751);
            a(fArrA3, canvas, this.d);
            a(fArrA4, canvas, this.d);
            this.d.setStrokeWidth(2.5f);
            a(canvas, circleArrA2[1], 100, 100);
            a(canvas, circleArrA2[0], -100, -100);
            this.d.setStrokeWidth(5.0f);
            this.d.setColor(InputDeviceCompat.SOURCE_ANY);
        }
        canvas.restore();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        this.b = getWidth();
        int height = getHeight();
        this.c = height;
        Module module = this.f;
        int i = this.b;
        module.g = i;
        module.h = height;
        if (module.m == -2.1474836E9f) {
            module.m = i / 2.0f;
        }
        if (module.n == -2.1474836E9f) {
            module.n = height;
        }
        module.k = Math.sqrt(Math.pow(module.j, 2.0d) + Math.pow(module.i, 2.0d));
        float fAbs = Math.abs((float) (Math.tan((float) (1.5707963267948966d - ((double) ((module.e / 2.0f) + module.f)))) * ((double) module.d)));
        if (fAbs > module.l) {
            module.l = fAbs;
        }
        OnLoadingListener onLoadingListener = this.g;
        if (onLoadingListener != null) {
            onLoadingListener.onLoaded(this);
        }
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setLayerType(2, null);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void onfix() {
        Log.e("TT", "---- >> module:" + this.f.toString());
        Module module = this.f;
        module.k = Math.sqrt(Math.pow(module.j, 2.0d) + Math.pow(module.i, 2.0d));
        Module module2 = this.f;
        float fAbs = Math.abs((float) (Math.tan((float) (1.5707963267948966d - ((double) ((module2.e / 2.0f) + module2.f)))) * ((double) module2.d)));
        if (fAbs > module2.l) {
            module2.l = fAbs;
        }
        invalidate();
    }

    public void setAngle(float f) {
        if (this.h) {
            f = 0.001f;
        }
        if (this.a == f) {
            return;
        }
        this.a = (float) (f == 0.0f ? 0.001d : f);
        invalidate();
    }

    public void setCalibrating(boolean z) {
        this.i = z;
    }

    public void setCameraAngle(float f) {
        this.f.setCameraAngle(f);
    }

    public void setCameraHeight(int i) {
        this.f.setCameraHeight(i);
    }

    public void setChcAngle(float f) {
        this.f.setChcAngle(f);
    }

    public void setMinDis(float f) {
        this.f.setMinDis(f);
    }

    public void setOffsetX(float f) {
        this.f.setOffsetX(f);
    }

    public void setStatic(boolean z) {
        this.h = z;
    }

    public void setTailLen(int i) {
        this.f.setTailLen(i);
    }

    public void setTrack(int i) {
        this.f.setTrack(i);
    }

    public void setType(Module.Track track) {
        if (this.j == track) {
            return;
        }
        this.j = track;
        invalidate();
    }

    public void setWheelBase(int i) {
        this.f.setWheelBase(i);
    }

    public void setmLoadingListener(OnLoadingListener onLoadingListener) {
        this.g = onLoadingListener;
        if (onLoadingListener != null) {
            onLoadingListener.onLoaded(this);
        }
    }

    public TrackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.61086524f;
        this.f = new Module();
        this.g = null;
        this.h = false;
        this.i = false;
        this.j = Module.Track.BENZ;
    }

    public static void a(float[] fArr, Canvas canvas, Paint paint) {
        int length = fArr.length >> 1;
        if (length <= 0) {
            return;
        }
        Paint.Style style = paint.getStyle();
        Paint.Style style2 = Paint.Style.STROKE;
        if (style != style2) {
            paint.setStyle(style2);
        }
        Path path = new Path();
        path.moveTo(fArr[0], fArr[1]);
        for (int i = 1; i < length; i++) {
            int i2 = i * 2;
            path.lineTo(fArr[i2], fArr[i2 + 1]);
        }
        canvas.drawPath(path, paint);
        if (style != Paint.Style.STROKE) {
            paint.setStyle(style);
        }
    }

    public TrackView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.61086524f;
        this.f = new Module();
        this.g = null;
        this.h = false;
        this.i = false;
        this.j = Module.Track.BENZ;
    }

    public final void a(Canvas canvas, Module.Circle circle, int i, int i2) {
        Paint paint;
        int i3;
        Module.Point point = circle.a;
        float f = i;
        float[] fArrA = this.f.a(new Module.Circle(point.a, point.b, circle.b + f), this.a < 0.0f);
        Module.Point point2 = circle.a;
        float[] fArrA2 = this.f.a(new Module.Circle(point2.a, point2.b, circle.b + f + i2), this.a < 0.0f);
        for (int i4 = 1; i4 < 22; i4++) {
            if (i4 < 5) {
                paint = this.d;
                i3 = -65536;
            } else if (i4 <= 12) {
                paint = this.d;
                i3 = InputDeviceCompat.SOURCE_ANY;
            } else {
                paint = this.d;
                i3 = RadarView.END_COLOR;
            }
            paint.setColor(i3);
            int i5 = i4 * 2;
            int i6 = i5 + 1;
            canvas.drawLine(fArrA[i5], fArrA[i6], fArrA2[i5], fArrA2[i6], this.d);
        }
    }
}
