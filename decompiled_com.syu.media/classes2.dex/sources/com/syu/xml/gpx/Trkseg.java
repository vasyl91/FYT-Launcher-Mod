package com.syu.xml.gpx;

import com.syu.xml.Element;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Trkseg extends Element {
    protected List<Trkpt> mTrkpts = new LinkedList();

    @Override // com.syu.xml.Element, com.syu.xml.IElement
    public void addElement(Element element) {
        super.addElement(element);
        if (element instanceof Pt) {
            this.mTrkpts.add((Trkpt) element);
        }
    }
}
