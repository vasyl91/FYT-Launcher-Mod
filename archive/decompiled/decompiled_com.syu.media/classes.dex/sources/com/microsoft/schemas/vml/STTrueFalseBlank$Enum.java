package com.microsoft.schemas.vml;

import chip.FinalChip;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class STTrueFalseBlank$Enum extends StringEnumAbstractBase {
    static final int INT_F = 2;
    static final int INT_FALSE = 4;
    static final int INT_T = 1;
    static final int INT_TRUE = 3;
    static final int INT_X = 5;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTrueFalseBlank$Enum[]{new STTrueFalseBlank$Enum("t", 1), new STTrueFalseBlank$Enum("f", 2), new STTrueFalseBlank$Enum("true", 3), new STTrueFalseBlank$Enum("false", 4), new STTrueFalseBlank$Enum(FinalChip.BSP_PLATFORM_Null, 5)});

    private STTrueFalseBlank$Enum(String str, int i) {
        super(str, i);
    }

    public static STTrueFalseBlank$Enum forInt(int i) {
        return (STTrueFalseBlank$Enum) table.forInt(i);
    }

    public static STTrueFalseBlank$Enum forString(String str) {
        return (STTrueFalseBlank$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
