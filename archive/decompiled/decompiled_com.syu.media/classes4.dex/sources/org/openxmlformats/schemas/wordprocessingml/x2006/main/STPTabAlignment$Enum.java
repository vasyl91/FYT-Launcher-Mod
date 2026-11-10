package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public final class STPTabAlignment$Enum extends StringEnumAbstractBase {
    static final int INT_CENTER = 2;
    static final int INT_LEFT = 1;
    static final int INT_RIGHT = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STPTabAlignment$Enum[]{new STPTabAlignment$Enum("left", 1), new STPTabAlignment$Enum("center", 2), new STPTabAlignment$Enum("right", 3)});

    private STPTabAlignment$Enum(String str, int i) {
        super(str, i);
    }

    public static STPTabAlignment$Enum forInt(int i) {
        return (STPTabAlignment$Enum) table.forInt(i);
    }

    public static STPTabAlignment$Enum forString(String str) {
        return (STPTabAlignment$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
