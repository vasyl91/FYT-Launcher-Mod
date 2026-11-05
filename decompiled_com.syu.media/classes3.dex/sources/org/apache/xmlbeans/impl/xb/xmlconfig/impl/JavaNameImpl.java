package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.apache.xmlbeans.impl.xb.xmlconfig.JavaName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JavaNameImpl extends JavaStringHolderEx implements JavaName {
    private static final long serialVersionUID = 1;

    public JavaNameImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    protected JavaNameImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
