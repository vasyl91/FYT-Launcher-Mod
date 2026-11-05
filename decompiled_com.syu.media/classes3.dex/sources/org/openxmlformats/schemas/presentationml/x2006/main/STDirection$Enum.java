package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STDirection$Enum extends StringEnumAbstractBase {
    static final int INT_HORZ = 1;
    static final int INT_VERT = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STDirection$Enum[]{new STDirection$Enum("horz", 1), new STDirection$Enum("vert", 2)});

    private STDirection$Enum(String str, int i) {
        super(str, i);
    }

    public static STDirection$Enum forInt(int i) {
        return (STDirection$Enum) table.forInt(i);
    }

    public static STDirection$Enum forString(String str) {
        return (STDirection$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
