package org.apache.xmlbeans;

import org.apache.xmlbeans.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XMLStreamValidationException extends XMLStreamException {
    private XmlError _xmlError;

    public XMLStreamValidationException(XmlError xmlError) {
        super(xmlError.toString());
        this._xmlError = xmlError;
    }

    public XmlError getXmlError() {
        return this._xmlError;
    }
}
