package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlNameImpl extends JavaStringHolderEx implements XmlName {
    public XmlNameImpl() {
        super(XmlName.type, false);
    }

    public XmlNameImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
