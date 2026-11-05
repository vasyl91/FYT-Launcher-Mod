package com.syu.back;

import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class Module {
    public double k;
    public int a = 2800;
    public int b = 1800;
    public int c = 800;
    public int d = 750;
    public float e = 2.1293018f;
    public float f = 0.9773844f;
    public int g = 0;
    public int h = 0;
    public final float i = 1028.0f;
    public final float j = 720.0f;
    public float l = 600.0f;
    public float m = -2.1474836E9f;
    public float n = -2.1474836E9f;

    public static class Circle {
        public final Point a;
        public final float b;

        public Circle(float f, float f2, float f3) {
            this.a = new Point(f, f2);
            this.b = f3;
        }

        public String toString() {
            return String.format(Locale.US, "Circle center: (%.2f, %.2f), radius: %.2f", Float.valueOf(this.a.a), Float.valueOf(this.a.b), Float.valueOf(this.b));
        }
    }

    public static class Point {
        public float a;
        public float b;

        public Point() {
            this.a = 0.0f;
            this.b = 0.0f;
        }

        public String toString() {
            return String.format(Locale.US, "Point: (%.2f, %.2f)", Float.valueOf(this.a), Float.valueOf(this.b));
        }

        public void transform(float f, float f2) {
            this.a += f;
            this.b += f2;
        }

        public Point(float f, float f2) {
            this.a = f;
            this.b = f2;
        }
    }

    public enum Track {
        BENZ,
        AUDI;

        Track() {
        }
    }

    public final float[] a(Circle circle, boolean z) {
        double d = circle.b;
        double d2 = (float) ((((double) 0.0f) * 0.017453292519943295d) + ((double) (1 * ((float) ((360.0d / (6.283185307179586d * d)) * ((double) (4600 / 24)) * 0.017453292519943295d)))));
        float[] fArr = new float[48];
        int i = z ? -1 : 1;
        double d3 = i;
        float fAsin = (float) (((3.141592653589793d * d3) / 2.0d) - (Math.asin((((double) this.l) + 50.0d) / d) * d3));
        for (int i2 = 0; i2 < 24; i2++) {
            double d4 = (float) (((double) fAsin) - (((double) (i * i2)) * d2));
            Point point = new Point();
            point.a = (float) (((double) circle.a.a) - (Math.sin(d4) * ((double) circle.b)));
            float fCos = (float) (((double) circle.a.b) - (Math.cos(d4) * ((double) circle.b)));
            point.b = fCos;
            int i3 = i2 * 2;
            fArr[i3] = point.a;
            fArr[i3 + 1] = fCos;
        }
        float[] fArr2 = new float[48];
        for (int i4 = 0; i4 < 24; i4++) {
            int i5 = i4 * 2;
            int i6 = i5 + 1;
            Point pointA = a(fArr[i5], fArr[i6]);
            fArr2[i5] = pointA.a;
            fArr2[i6] = pointA.b;
        }
        return fArr2;
    }

    public float getCameraAngle() {
        return this.e;
    }

    public int getCameraHeight() {
        return this.d;
    }

    public float getChcAngle() {
        return this.f;
    }

    public float getMinDis() {
        return this.l;
    }

    public float getOffsetX() {
        return this.m;
    }

    public float getOffsetY() {
        return this.n;
    }

    public int getTailLen() {
        return this.c;
    }

    public int getTrack() {
        return this.b;
    }

    public int getWheelBase() {
        return this.a;
    }

    public void setCameraAngle(float f) {
        this.e = (float) (((double) f) * 0.017453292519943295d);
    }

    public void setCameraHeight(int i) {
        this.d = i;
    }

    public void setChcAngle(float f) {
        this.f = (float) (((double) f) * 0.017453292519943295d);
    }

    public void setMinDis(float f) {
        this.l = f;
    }

    public void setOffsetX(float f) {
        this.m = f;
    }

    public void setOffsetY(float f) {
        this.n = f;
    }

    public void setTailLen(int i) {
        this.c = i;
    }

    public void setTrack(int i) {
        this.b = i;
    }

    public void setWheelBase(int i) {
        this.a = i;
    }

    public String toString() {
        return String.format("previewWidth: %d \npreviewHeight: %d\n wheelBase: %d \nTrack: %d \ntailLen: %d \nCAM Height: %d \nCAM ANGLE: %.2f \nCAM PLACE: %.2f \nSAFETY LINE: %f", Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Double.valueOf(((double) this.e) / 0.017453292519943295d), Double.valueOf(((double) this.f) / 0.017453292519943295d), Float.valueOf(this.l));
    }

    public final Circle[] a(Circle circle) {
        Point point = circle.a;
        float f = point.a;
        float f2 = point.b;
        float f3 = circle.b;
        Point point2 = circle.a;
        return new Circle[]{new Circle(f, f2, (this.b / 2.0f) + f3), new Circle(point2.a, point2.b, circle.b - (this.b / 2.0f))};
    }

    public final Point a(float f, float f2) {
        Point point = new Point();
        double d = ((double) this.e) / 2.0d;
        double dAtan = Math.atan(this.d / Math.abs(f2));
        double d2 = this.f;
        double d3 = dAtan - d2;
        double dSin = Math.sin(this.f) * ((((double) this.d) / Math.tan(d2)) - ((double) Math.abs(f2)));
        float fAbs = (float) (this.k / (Math.abs(Math.tan(d) * (Math.cos(d3) * (((double) this.d) / Math.sin(dAtan)))) * 2.0d));
        float f3 = (this.h * fAbs) / this.d;
        float f4 = (this.g / this.i) * fAbs;
        point.b = (int) ((((double) f3) * dSin) + ((double) ((dSin < 0.0d ? -1 : 1) * 0.5f)));
        point.a = (int) (((f >= 0.0f ? 1 : -1) * 0.5f) + (f4 * f));
        return point;
    }
}
