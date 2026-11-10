package com.microsoft.schemas.vml;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class STImageAspect$Enum extends StringEnumAbstractBase {
    static final int INT_AT_LEAST = 3;
    static final int INT_AT_MOST = 2;
    static final int INT_IGNORE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STImageAspect$Enum[]{new STImageAspect$Enum("ignore", 1), new STImageAspect$Enum("atMost", 2), new STImageAspect$Enum("atLeast", 3)});

    private STImageAspect$Enum(String str, int i) {
        super(str, i);
    }

    public static STImageAspect$Enum forInt(int i) {
        return (STImageAspect$Enum) table.forInt(i);
    }

    public static STImageAspect$Enum forString(String str) {
        return (STImageAspect$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
