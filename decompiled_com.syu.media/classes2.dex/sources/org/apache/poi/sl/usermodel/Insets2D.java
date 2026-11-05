package org.apache.poi.sl.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Insets2D implements Cloneable {
    public double bottom;
    public double left;
    public double right;
    public double top;

    public Insets2D(double d, double d2, double d3, double d4) {
        this.top = d;
        this.left = d2;
        this.bottom = d3;
        this.right = d4;
    }

    public void set(double d, double d2, double d3, double d4) {
        this.top = d;
        this.left = d2;
        this.bottom = d3;
        this.right = d4;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Insets2D)) {
            return false;
        }
        Insets2D insets2D = (Insets2D) obj;
        return this.top == insets2D.top && this.left == insets2D.left && this.bottom == insets2D.bottom && this.right == insets2D.right;
    }

    public int hashCode() {
        double d = this.left;
        double d2 = this.bottom + d;
        double d3 = this.right;
        double d4 = this.top;
        double d5 = d3 + d4;
        double d6 = ((d5 * (d5 + 1.0d)) / 2.0d) + d4;
        double d7 = ((d2 * (d2 + 1.0d)) / 2.0d) + d + d6;
        return (int) (((d7 * (1.0d + d7)) / 2.0d) + d6);
    }

    public String toString() {
        return getClass().getName() + "[top=" + this.top + ",left=" + this.left + ",bottom=" + this.bottom + ",right=" + this.right + "]";
    }

    public Insets2D clone() {
        return new Insets2D(this.top, this.left, this.bottom, this.right);
    }
}
