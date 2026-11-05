package com.microsoft.schemas.vml;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class STShadowType$Enum extends StringEnumAbstractBase {
    static final int INT_DOUBLE = 2;
    static final int INT_EMBOSS = 3;
    static final int INT_PERSPECTIVE = 4;
    static final int INT_SINGLE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STShadowType$Enum[]{new STShadowType$Enum("single", 1), new STShadowType$Enum("double", 2), new STShadowType$Enum("emboss", 3), new STShadowType$Enum("perspective", 4)});

    private STShadowType$Enum(String str, int i) {
        super(str, i);
    }

    public static STShadowType$Enum forInt(int i) {
        return (STShadowType$Enum) table.forInt(i);
    }

    public static STShadowType$Enum forString(String str) {
        return (STShadowType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
