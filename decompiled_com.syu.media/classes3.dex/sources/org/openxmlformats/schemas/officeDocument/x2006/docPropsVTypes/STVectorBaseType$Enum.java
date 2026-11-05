package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STVectorBaseType$Enum extends StringEnumAbstractBase {
    static final int INT_BOOL = 17;
    static final int INT_BSTR = 14;
    static final int INT_CF = 21;
    static final int INT_CLSID = 20;
    static final int INT_CY = 18;
    static final int INT_DATE = 15;
    static final int INT_ERROR = 19;
    static final int INT_FILETIME = 16;
    static final int INT_I_1 = 2;
    static final int INT_I_2 = 3;
    static final int INT_I_4 = 4;
    static final int INT_I_8 = 5;
    static final int INT_LPSTR = 12;
    static final int INT_LPWSTR = 13;
    static final int INT_R_4 = 10;
    static final int INT_R_8 = 11;
    static final int INT_UI_1 = 6;
    static final int INT_UI_2 = 7;
    static final int INT_UI_4 = 8;
    static final int INT_UI_8 = 9;
    static final int INT_VARIANT = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STVectorBaseType$Enum[]{new STVectorBaseType$Enum("variant", 1), new STVectorBaseType$Enum("i1", 2), new STVectorBaseType$Enum("i2", 3), new STVectorBaseType$Enum("i4", 4), new STVectorBaseType$Enum("i8", 5), new STVectorBaseType$Enum("ui1", 6), new STVectorBaseType$Enum("ui2", 7), new STVectorBaseType$Enum("ui4", 8), new STVectorBaseType$Enum("ui8", 9), new STVectorBaseType$Enum("r4", 10), new STVectorBaseType$Enum("r8", 11), new STVectorBaseType$Enum("lpstr", 12), new STVectorBaseType$Enum("lpwstr", 13), new STVectorBaseType$Enum("bstr", 14), new STVectorBaseType$Enum("date", 15), new STVectorBaseType$Enum("filetime", 16), new STVectorBaseType$Enum("bool", 17), new STVectorBaseType$Enum("cy", 18), new STVectorBaseType$Enum("error", 19), new STVectorBaseType$Enum("clsid", 20), new STVectorBaseType$Enum("cf", 21)});

    private STVectorBaseType$Enum(String str, int i) {
        super(str, i);
    }

    public static STVectorBaseType$Enum forInt(int i) {
        return (STVectorBaseType$Enum) table.forInt(i);
    }

    public static STVectorBaseType$Enum forString(String str) {
        return (STVectorBaseType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
