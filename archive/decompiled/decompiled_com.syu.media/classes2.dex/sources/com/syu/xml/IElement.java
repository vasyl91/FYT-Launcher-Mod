package com.syu.xml;

import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface IElement {
    void addElement(Element element);

    Element findChildByTag(String str);

    String getAttribute(String str);

    void nodes(List<Element> list);

    void setAttribute(String str, String str2);
}
