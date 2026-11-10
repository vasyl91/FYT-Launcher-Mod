package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNormalizedString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlNormalizedStringImpl extends JavaStringHolderEx implements XmlNormalizedString {
    public XmlNormalizedStringImpl() {
        super(XmlNormalizedString.type, false);
    }

    public XmlNormalizedStringImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
