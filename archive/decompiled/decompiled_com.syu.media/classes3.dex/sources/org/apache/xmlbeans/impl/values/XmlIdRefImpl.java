package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlIDREF;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlIdRefImpl extends JavaStringHolderEx implements XmlIDREF {
    public XmlIdRefImpl() {
        super(XmlIDREF.type, false);
    }

    public XmlIdRefImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
