package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STUpdateLinks$Enum extends StringEnumAbstractBase {
    static final int INT_ALWAYS = 3;
    static final int INT_NEVER = 2;
    static final int INT_USER_SET = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STUpdateLinks$Enum[]{new STUpdateLinks$Enum("userSet", 1), new STUpdateLinks$Enum("never", 2), new STUpdateLinks$Enum("always", 3)});

    private STUpdateLinks$Enum(String str, int i) {
        super(str, i);
    }

    public static STUpdateLinks$Enum forInt(int i) {
        return (STUpdateLinks$Enum) table.forInt(i);
    }

    public static STUpdateLinks$Enum forString(String str) {
        return (STUpdateLinks$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
