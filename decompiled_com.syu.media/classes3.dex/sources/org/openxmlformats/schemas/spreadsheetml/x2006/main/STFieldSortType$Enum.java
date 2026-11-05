package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STFieldSortType$Enum extends StringEnumAbstractBase {
    static final int INT_ASCENDING = 2;
    static final int INT_DESCENDING = 3;
    static final int INT_MANUAL = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STFieldSortType$Enum[]{new STFieldSortType$Enum("manual", 1), new STFieldSortType$Enum("ascending", 2), new STFieldSortType$Enum("descending", 3)});

    private STFieldSortType$Enum(String str, int i) {
        super(str, i);
    }

    public static STFieldSortType$Enum forInt(int i) {
        return (STFieldSortType$Enum) table.forInt(i);
    }

    public static STFieldSortType$Enum forString(String str) {
        return (STFieldSortType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
