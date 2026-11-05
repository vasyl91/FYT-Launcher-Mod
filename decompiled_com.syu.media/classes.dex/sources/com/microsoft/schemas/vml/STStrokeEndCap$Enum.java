package com.microsoft.schemas.vml;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class STStrokeEndCap$Enum extends StringEnumAbstractBase {
    static final int INT_FLAT = 1;
    static final int INT_ROUND = 3;
    static final int INT_SQUARE = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STStrokeEndCap$Enum[]{new STStrokeEndCap$Enum("flat", 1), new STStrokeEndCap$Enum("square", 2), new STStrokeEndCap$Enum("round", 3)});

    private STStrokeEndCap$Enum(String str, int i) {
        super(str, i);
    }

    public static STStrokeEndCap$Enum forInt(int i) {
        return (STStrokeEndCap$Enum) table.forInt(i);
    }

    public static STStrokeEndCap$Enum forString(String str) {
        return (STStrokeEndCap$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
