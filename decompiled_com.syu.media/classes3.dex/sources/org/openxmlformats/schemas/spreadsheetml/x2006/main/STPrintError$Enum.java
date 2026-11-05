package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STPrintError$Enum extends StringEnumAbstractBase {
    static final int INT_BLANK = 2;
    static final int INT_DASH = 3;
    static final int INT_DISPLAYED = 1;
    static final int INT_NA = 4;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STPrintError$Enum[]{new STPrintError$Enum("displayed", 1), new STPrintError$Enum("blank", 2), new STPrintError$Enum("dash", 3), new STPrintError$Enum("NA", 4)});

    private STPrintError$Enum(String str, int i) {
        super(str, i);
    }

    public static STPrintError$Enum forInt(int i) {
        return (STPrintError$Enum) table.forInt(i);
    }

    public static STPrintError$Enum forString(String str) {
        return (STPrintError$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
