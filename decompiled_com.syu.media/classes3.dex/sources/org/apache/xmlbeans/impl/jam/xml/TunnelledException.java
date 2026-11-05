package org.apache.xmlbeans.impl.jam.xml;

import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class TunnelledException extends RuntimeException {
    private XMLStreamException mXSE;

    public TunnelledException(XMLStreamException xMLStreamException) {
        this.mXSE = xMLStreamException;
    }

    public XMLStreamException getXMLStreamException() {
        return this.mXSE;
    }
}
