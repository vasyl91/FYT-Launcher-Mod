package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlID;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlIdImpl extends JavaStringHolderEx implements XmlID {
    public XmlIdImpl() {
        super(XmlID.type, false);
    }

    public XmlIdImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
