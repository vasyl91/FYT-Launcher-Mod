package com.syu.xml.gpx;

import com.syu.xml.Element;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Pt extends Element {
    public double a = Double.MIN_VALUE;
    public double b = Double.MIN_VALUE;

    @Override // com.syu.xml.Element, com.syu.xml.IElement
    public void addElement(Element element) {
        super.addElement(element);
        if (element instanceof Ele) {
            double d = ((Ele) element).a;
        } else if (element instanceof Time) {
        }
    }

    public double latitude() {
        String attribute;
        if (this.a == Double.MIN_VALUE && ((attribute = getAttribute("lat")) == null || attribute.isEmpty())) {
            try {
                this.a = Double.valueOf(attribute).doubleValue();
            } catch (Exception unused) {
            }
        }
        return this.a;
    }

    public double longitude() {
        String attribute;
        if (this.b == Double.MIN_VALUE && ((attribute = getAttribute("lon")) == null || attribute.isEmpty())) {
            try {
                this.b = Double.valueOf(attribute).doubleValue();
            } catch (Exception unused) {
            }
        }
        return this.b;
    }
}
