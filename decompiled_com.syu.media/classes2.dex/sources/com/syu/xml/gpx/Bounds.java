package com.syu.xml.gpx;

import com.syu.xml.Element;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Bounds extends Element {
    public double a = Double.MIN_VALUE;
    public double b = Double.MIN_VALUE;
    public double c = Double.MIN_VALUE;
    public double d = Double.MIN_VALUE;

    public double maxlat() {
        String attribute;
        if (this.b == Double.MIN_VALUE && ((attribute = getAttribute("maxlat")) == null || attribute.isEmpty())) {
            try {
                this.b = Double.valueOf(attribute).doubleValue();
            } catch (Exception unused) {
            }
        }
        return this.b;
    }

    public double maxlon() {
        String attribute;
        if (this.d == Double.MIN_VALUE && ((attribute = getAttribute("maxlon")) == null || attribute.isEmpty())) {
            try {
                this.d = Double.valueOf(attribute).doubleValue();
            } catch (Exception unused) {
            }
        }
        return this.d;
    }

    public double minlat() {
        String attribute;
        if (this.a == Double.MIN_VALUE && ((attribute = getAttribute("minlat")) == null || attribute.isEmpty())) {
            try {
                this.a = Double.valueOf(attribute).doubleValue();
            } catch (Exception unused) {
            }
        }
        return this.a;
    }

    public double minlon() {
        String attribute;
        if (this.c == Double.MIN_VALUE && ((attribute = getAttribute("minlon")) == null || attribute.isEmpty())) {
            try {
                this.c = Double.valueOf(attribute).doubleValue();
            } catch (Exception unused) {
            }
        }
        return this.c;
    }
}
