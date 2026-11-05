package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlToken;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlTokenImpl extends JavaStringHolderEx implements XmlToken {
    public XmlTokenImpl() {
        super(XmlToken.type, false);
    }

    public XmlTokenImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
