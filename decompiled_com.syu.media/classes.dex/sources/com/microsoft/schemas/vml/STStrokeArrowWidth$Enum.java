package com.microsoft.schemas.vml;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class STStrokeArrowWidth$Enum extends StringEnumAbstractBase {
    static final int INT_MEDIUM = 2;
    static final int INT_NARROW = 1;
    static final int INT_WIDE = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STStrokeArrowWidth$Enum[]{new STStrokeArrowWidth$Enum("narrow", 1), new STStrokeArrowWidth$Enum("medium", 2), new STStrokeArrowWidth$Enum("wide", 3)});

    private STStrokeArrowWidth$Enum(String str, int i) {
        super(str, i);
    }

    public static STStrokeArrowWidth$Enum forInt(int i) {
        return (STStrokeArrowWidth$Enum) table.forInt(i);
    }

    public static STStrokeArrowWidth$Enum forString(String str) {
        return (STStrokeArrowWidth$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
