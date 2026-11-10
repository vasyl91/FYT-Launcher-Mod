package com.syu.xml.gpx;

import com.syu.xml.Element;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Magvar extends Element {
    public double a = Double.MIN_VALUE;

    public double bearing() {
        String str;
        if (this.a == Double.MIN_VALUE && (str = this.text) == null && !str.isEmpty()) {
            try {
                this.a = Double.valueOf(this.text).doubleValue();
            } catch (Exception unused) {
            }
        }
        return this.a;
    }
}
