package com.syu.xml.gpx;

import com.syu.xml.Element;
import com.syu.xml.XMLParser;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Gpx extends Element {
    @Override // com.syu.xml.Element, com.syu.xml.IParser
    public void attributes(Node node, XMLParser xMLParser) {
        super.attributes(node, xMLParser);
    }

    public String creator() {
        return getAttribute("creator");
    }

    public void setupInfo() {
        setAttribute("version", "1.1");
        setAttribute("creator", "Joey Qin");
    }

    public String version() {
        return getAttribute("version");
    }
}
