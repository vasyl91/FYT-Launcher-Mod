package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STPlaceholderSize$Enum extends StringEnumAbstractBase {
    static final int INT_FULL = 1;
    static final int INT_HALF = 2;
    static final int INT_QUARTER = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STPlaceholderSize$Enum[]{new STPlaceholderSize$Enum("full", 1), new STPlaceholderSize$Enum("half", 2), new STPlaceholderSize$Enum("quarter", 3)});

    private STPlaceholderSize$Enum(String str, int i) {
        super(str, i);
    }

    public static STPlaceholderSize$Enum forInt(int i) {
        return (STPlaceholderSize$Enum) table.forInt(i);
    }

    public static STPlaceholderSize$Enum forString(String str) {
        return (STPlaceholderSize$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
