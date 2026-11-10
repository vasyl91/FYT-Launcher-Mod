package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public final class STHeightRule$Enum extends StringEnumAbstractBase {
    static final int INT_AT_LEAST = 3;
    static final int INT_AUTO = 1;
    static final int INT_EXACT = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STHeightRule$Enum[]{new STHeightRule$Enum("auto", 1), new STHeightRule$Enum("exact", 2), new STHeightRule$Enum("atLeast", 3)});

    private STHeightRule$Enum(String str, int i) {
        super(str, i);
    }

    public static STHeightRule$Enum forInt(int i) {
        return (STHeightRule$Enum) table.forInt(i);
    }

    public static STHeightRule$Enum forString(String str) {
        return (STHeightRule$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
