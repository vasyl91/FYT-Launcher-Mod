package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.XmlError;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlValueOutOfRangeException extends IllegalArgumentException {
    public XmlValueOutOfRangeException() {
    }

    public XmlValueOutOfRangeException(String str) {
        super(str);
    }

    public XmlValueOutOfRangeException(String str, Object[] objArr) {
        super(XmlError.formattedMessage(str, objArr));
    }
}
