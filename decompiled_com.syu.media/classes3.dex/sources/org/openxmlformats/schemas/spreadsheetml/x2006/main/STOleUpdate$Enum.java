package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STOleUpdate$Enum extends StringEnumAbstractBase {
    static final int INT_OLEUPDATE_ALWAYS = 1;
    static final int INT_OLEUPDATE_ONCALL = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STOleUpdate$Enum[]{new STOleUpdate$Enum("OLEUPDATE_ALWAYS", 1), new STOleUpdate$Enum("OLEUPDATE_ONCALL", 2)});

    private STOleUpdate$Enum(String str, int i) {
        super(str, i);
    }

    public static STOleUpdate$Enum forInt(int i) {
        return (STOleUpdate$Enum) table.forInt(i);
    }

    public static STOleUpdate$Enum forString(String str) {
        return (STOleUpdate$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
