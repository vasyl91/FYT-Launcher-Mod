package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STTotalsRowFunction$Enum extends StringEnumAbstractBase {
    static final int INT_AVERAGE = 5;
    static final int INT_COUNT = 6;
    static final int INT_COUNT_NUMS = 7;
    static final int INT_CUSTOM = 10;
    static final int INT_MAX = 4;
    static final int INT_MIN = 3;
    static final int INT_NONE = 1;
    static final int INT_STD_DEV = 8;
    static final int INT_SUM = 2;
    static final int INT_VAR = 9;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTotalsRowFunction$Enum[]{new STTotalsRowFunction$Enum("none", 1), new STTotalsRowFunction$Enum("sum", 2), new STTotalsRowFunction$Enum("min", 3), new STTotalsRowFunction$Enum("max", 4), new STTotalsRowFunction$Enum("average", 5), new STTotalsRowFunction$Enum("count", 6), new STTotalsRowFunction$Enum("countNums", 7), new STTotalsRowFunction$Enum("stdDev", 8), new STTotalsRowFunction$Enum("var", 9), new STTotalsRowFunction$Enum("custom", 10)});

    private STTotalsRowFunction$Enum(String str, int i) {
        super(str, i);
    }

    public static STTotalsRowFunction$Enum forInt(int i) {
        return (STTotalsRowFunction$Enum) table.forInt(i);
    }

    public static STTotalsRowFunction$Enum forString(String str) {
        return (STTotalsRowFunction$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
