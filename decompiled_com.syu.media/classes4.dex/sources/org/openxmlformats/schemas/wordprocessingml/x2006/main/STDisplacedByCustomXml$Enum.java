package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public final class STDisplacedByCustomXml$Enum extends StringEnumAbstractBase {
    static final int INT_NEXT = 1;
    static final int INT_PREV = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STDisplacedByCustomXml$Enum[]{new STDisplacedByCustomXml$Enum("next", 1), new STDisplacedByCustomXml$Enum("prev", 2)});

    private STDisplacedByCustomXml$Enum(String str, int i) {
        super(str, i);
    }

    public static STDisplacedByCustomXml$Enum forInt(int i) {
        return (STDisplacedByCustomXml$Enum) table.forInt(i);
    }

    public static STDisplacedByCustomXml$Enum forString(String str) {
        return (STDisplacedByCustomXml$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
