package com.microsoft.schemas.vml;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class STStrokeLineStyle$Enum extends StringEnumAbstractBase {
    static final int INT_SINGLE = 1;
    static final int INT_THICK_BETWEEN_THIN = 5;
    static final int INT_THICK_THIN = 4;
    static final int INT_THIN_THICK = 3;
    static final int INT_THIN_THIN = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STStrokeLineStyle$Enum[]{new STStrokeLineStyle$Enum("single", 1), new STStrokeLineStyle$Enum("thinThin", 2), new STStrokeLineStyle$Enum("thinThick", 3), new STStrokeLineStyle$Enum("thickThin", 4), new STStrokeLineStyle$Enum("thickBetweenThin", 5)});

    private STStrokeLineStyle$Enum(String str, int i) {
        super(str, i);
    }

    public static STStrokeLineStyle$Enum forInt(int i) {
        return (STStrokeLineStyle$Enum) table.forInt(i);
    }

    public static STStrokeLineStyle$Enum forString(String str) {
        return (STStrokeLineStyle$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
