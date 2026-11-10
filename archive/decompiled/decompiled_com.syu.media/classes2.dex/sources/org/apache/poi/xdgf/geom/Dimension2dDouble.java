package org.apache.poi.xdgf.geom;

import java.awt.geom.Dimension2D;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Dimension2dDouble extends Dimension2D {
    double height;
    double width;

    public Dimension2dDouble() {
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public Dimension2dDouble(double d, double d2) {
        this.width = d;
        this.height = d2;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setSize(double d, double d2) {
        this.width = d;
        this.height = d2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dimension2dDouble)) {
            return false;
        }
        Dimension2dDouble dimension2dDouble = (Dimension2dDouble) obj;
        return this.width == dimension2dDouble.width && this.height == dimension2dDouble.height;
    }

    public int hashCode() {
        double d = this.width;
        double d2 = this.height + d;
        return (int) Math.ceil(((d2 * (1.0d + d2)) / 2.0d) + d);
    }

    public String toString() {
        return "Dimension2dDouble[" + this.width + ", " + this.height + "]";
    }
}
