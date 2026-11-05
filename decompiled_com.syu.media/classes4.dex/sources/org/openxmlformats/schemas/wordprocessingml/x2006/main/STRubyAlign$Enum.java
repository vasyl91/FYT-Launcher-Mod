package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public final class STRubyAlign$Enum extends StringEnumAbstractBase {
    static final int INT_CENTER = 1;
    static final int INT_DISTRIBUTE_LETTER = 2;
    static final int INT_DISTRIBUTE_SPACE = 3;
    static final int INT_LEFT = 4;
    static final int INT_RIGHT = 5;
    static final int INT_RIGHT_VERTICAL = 6;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STRubyAlign$Enum[]{new STRubyAlign$Enum("center", 1), new STRubyAlign$Enum("distributeLetter", 2), new STRubyAlign$Enum("distributeSpace", 3), new STRubyAlign$Enum("left", 4), new STRubyAlign$Enum("right", 5), new STRubyAlign$Enum("rightVertical", 6)});

    private STRubyAlign$Enum(String str, int i) {
        super(str, i);
    }

    public static STRubyAlign$Enum forInt(int i) {
        return (STRubyAlign$Enum) table.forInt(i);
    }

    public static STRubyAlign$Enum forString(String str) {
        return (STRubyAlign$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
