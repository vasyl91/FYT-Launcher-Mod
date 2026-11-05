package com.microsoft.schemas.vml;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class STEditAs$Enum extends StringEnumAbstractBase {
    static final int INT_BULLSEYE = 7;
    static final int INT_CANVAS = 1;
    static final int INT_CYCLE = 4;
    static final int INT_ORGCHART = 2;
    static final int INT_RADIAL = 3;
    static final int INT_STACKED = 5;
    static final int INT_VENN = 6;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STEditAs$Enum[]{new STEditAs$Enum("canvas", 1), new STEditAs$Enum("orgchart", 2), new STEditAs$Enum("radial", 3), new STEditAs$Enum("cycle", 4), new STEditAs$Enum("stacked", 5), new STEditAs$Enum("venn", 6), new STEditAs$Enum("bullseye", 7)});

    private STEditAs$Enum(String str, int i) {
        super(str, i);
    }

    public static STEditAs$Enum forInt(int i) {
        return (STEditAs$Enum) table.forInt(i);
    }

    public static STEditAs$Enum forString(String str) {
        return (STEditAs$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
