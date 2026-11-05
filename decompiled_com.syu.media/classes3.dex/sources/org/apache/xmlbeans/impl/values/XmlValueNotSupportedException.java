package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.XmlError;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlValueNotSupportedException extends XmlValueOutOfRangeException {
    public XmlValueNotSupportedException() {
    }

    public XmlValueNotSupportedException(String str) {
        super(str);
    }

    public XmlValueNotSupportedException(String str, Object[] objArr) {
        super(XmlError.formattedMessage(str, objArr));
    }
}
