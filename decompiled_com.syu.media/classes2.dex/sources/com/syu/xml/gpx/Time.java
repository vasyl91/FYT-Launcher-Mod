package com.syu.xml.gpx;

import com.syu.xml.Element;
import com.syu.xml.XMLParser;
import java.text.SimpleDateFormat;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Time extends Element {
    static {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    }

    @Override // com.syu.xml.Element, com.syu.xml.IParser
    public void attributes(Node node, XMLParser xMLParser) {
        super.attributes(node, xMLParser);
    }
}
