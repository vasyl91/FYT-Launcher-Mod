package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STVisibility$Enum extends StringEnumAbstractBase {
    static final int INT_HIDDEN = 2;
    static final int INT_VERY_HIDDEN = 3;
    static final int INT_VISIBLE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STVisibility$Enum[]{new STVisibility$Enum("visible", 1), new STVisibility$Enum("hidden", 2), new STVisibility$Enum("veryHidden", 3)});

    private STVisibility$Enum(String str, int i) {
        super(str, i);
    }

    public static STVisibility$Enum forInt(int i) {
        return (STVisibility$Enum) table.forInt(i);
    }

    public static STVisibility$Enum forString(String str) {
        return (STVisibility$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
