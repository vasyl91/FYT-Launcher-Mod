package com.graphbuilder.geom;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class PointFactory {

    static class Point2D implements Point2d {
        double[] pts;

        public Point2D(double d, double d2) {
            this.pts = new double[]{d, d2};
        }

        @Override // com.graphbuilder.geom.Point2d
        public double getX() {
            return this.pts[0];
        }

        @Override // com.graphbuilder.geom.Point2d
        public double getY() {
            return this.pts[1];
        }

        @Override // com.graphbuilder.curve.Point
        public void setLocation(double[] dArr) {
            double[] dArr2 = this.pts;
            dArr2[0] = dArr[0];
            dArr2[1] = dArr[1];
        }

        @Override // com.graphbuilder.geom.Point2d
        public void setLocation(double d, double d2) {
            double[] dArr = this.pts;
            dArr[0] = d;
            dArr[1] = d2;
        }

        @Override // com.graphbuilder.curve.Point
        public double[] getLocation() {
            return this.pts;
        }
    }

    public static Point2d create(double d, double d2) {
        return new Point2D(d, d2);
    }
}
