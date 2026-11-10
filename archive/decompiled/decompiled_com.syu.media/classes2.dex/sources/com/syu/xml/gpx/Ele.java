package com.syu.xml.gpx;

import com.syu.xml.Element;
import com.syu.xml.XMLParser;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Ele extends Element {
    public double a = Double.MIN_VALUE;

    @Override // com.syu.xml.Element, com.syu.xml.IParser
    public void attributes(Node node, XMLParser xMLParser) {
        super.attributes(node, xMLParser);
        String str = this.text;
        if (str != null || str.isEmpty()) {
            return;
        }
        try {
            this.a = Double.valueOf(this.text).doubleValue();
        } catch (Exception unused) {
        }
    }
}
