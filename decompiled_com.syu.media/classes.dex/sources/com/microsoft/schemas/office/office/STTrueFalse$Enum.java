package com.microsoft.schemas.office.office;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class STTrueFalse$Enum extends StringEnumAbstractBase {
    static final int INT_F = 2;
    static final int INT_FALSE = 4;
    static final int INT_T = 1;
    static final int INT_TRUE = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTrueFalse$Enum[]{new STTrueFalse$Enum("t", 1), new STTrueFalse$Enum("f", 2), new STTrueFalse$Enum("true", 3), new STTrueFalse$Enum("false", 4)});

    private STTrueFalse$Enum(String str, int i) {
        super(str, i);
    }

    public static STTrueFalse$Enum forInt(int i) {
        return (STTrueFalse$Enum) table.forInt(i);
    }

    public static STTrueFalse$Enum forString(String str) {
        return (STTrueFalse$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
