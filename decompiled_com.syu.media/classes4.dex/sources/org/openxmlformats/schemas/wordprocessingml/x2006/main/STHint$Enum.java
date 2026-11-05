package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public final class STHint$Enum extends StringEnumAbstractBase {
    static final int INT_CS = 3;
    static final int INT_DEFAULT = 1;
    static final int INT_EAST_ASIA = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STHint$Enum[]{new STHint$Enum("default", 1), new STHint$Enum("eastAsia", 2), new STHint$Enum("cs", 3)});

    private STHint$Enum(String str, int i) {
        super(str, i);
    }

    public static STHint$Enum forInt(int i) {
        return (STHint$Enum) table.forInt(i);
    }

    public static STHint$Enum forString(String str) {
        return (STHint$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
