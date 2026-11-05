package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public final class STPTabRelativeTo$Enum extends StringEnumAbstractBase {
    static final int INT_INDENT = 2;
    static final int INT_MARGIN = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STPTabRelativeTo$Enum[]{new STPTabRelativeTo$Enum("margin", 1), new STPTabRelativeTo$Enum("indent", 2)});

    private STPTabRelativeTo$Enum(String str, int i) {
        super(str, i);
    }

    public static STPTabRelativeTo$Enum forInt(int i) {
        return (STPTabRelativeTo$Enum) table.forInt(i);
    }

    public static STPTabRelativeTo$Enum forString(String str) {
        return (STPTabRelativeTo$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
