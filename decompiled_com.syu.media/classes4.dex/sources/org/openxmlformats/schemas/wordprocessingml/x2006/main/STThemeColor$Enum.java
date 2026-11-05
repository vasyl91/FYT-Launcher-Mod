package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public final class STThemeColor$Enum extends StringEnumAbstractBase {
    static final int INT_ACCENT_1 = 5;
    static final int INT_ACCENT_2 = 6;
    static final int INT_ACCENT_3 = 7;
    static final int INT_ACCENT_4 = 8;
    static final int INT_ACCENT_5 = 9;
    static final int INT_ACCENT_6 = 10;
    static final int INT_BACKGROUND_1 = 14;
    static final int INT_BACKGROUND_2 = 16;
    static final int INT_DARK_1 = 1;
    static final int INT_DARK_2 = 3;
    static final int INT_FOLLOWED_HYPERLINK = 12;
    static final int INT_HYPERLINK = 11;
    static final int INT_LIGHT_1 = 2;
    static final int INT_LIGHT_2 = 4;
    static final int INT_NONE = 13;
    static final int INT_TEXT_1 = 15;
    static final int INT_TEXT_2 = 17;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STThemeColor$Enum[]{new STThemeColor$Enum("dark1", 1), new STThemeColor$Enum("light1", 2), new STThemeColor$Enum("dark2", 3), new STThemeColor$Enum("light2", 4), new STThemeColor$Enum("accent1", 5), new STThemeColor$Enum("accent2", 6), new STThemeColor$Enum("accent3", 7), new STThemeColor$Enum("accent4", 8), new STThemeColor$Enum("accent5", 9), new STThemeColor$Enum("accent6", 10), new STThemeColor$Enum("hyperlink", 11), new STThemeColor$Enum("followedHyperlink", 12), new STThemeColor$Enum("none", 13), new STThemeColor$Enum("background1", 14), new STThemeColor$Enum("text1", 15), new STThemeColor$Enum("background2", 16), new STThemeColor$Enum("text2", 17)});

    private STThemeColor$Enum(String str, int i) {
        super(str, i);
    }

    public static STThemeColor$Enum forInt(int i) {
        return (STThemeColor$Enum) table.forInt(i);
    }

    public static STThemeColor$Enum forString(String str) {
        return (STThemeColor$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
