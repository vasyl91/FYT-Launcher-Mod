package org.apache.xmlbeans.impl.soap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface Node extends org.w3c.dom.Node {
    void detachNode();

    SOAPElement getParentElement();

    String getValue();

    void recycleNode();

    void setParentElement(SOAPElement sOAPElement) throws SOAPException;

    void setValue(String str);
}
