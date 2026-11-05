package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STRefMode$Enum extends StringEnumAbstractBase {
    static final int INT_A_1 = 1;
    static final int INT_R_1_C_1 = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STRefMode$Enum[]{new STRefMode$Enum("A1", 1), new STRefMode$Enum("R1C1", 2)});

    private STRefMode$Enum(String str, int i) {
        super(str, i);
    }

    public static STRefMode$Enum forInt(int i) {
        return (STRefMode$Enum) table.forInt(i);
    }

    public static STRefMode$Enum forString(String str) {
        return (STRefMode$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
