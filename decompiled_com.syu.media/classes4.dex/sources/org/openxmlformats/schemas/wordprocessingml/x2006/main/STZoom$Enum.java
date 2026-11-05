package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public final class STZoom$Enum extends StringEnumAbstractBase {
    static final int INT_BEST_FIT = 3;
    static final int INT_FULL_PAGE = 2;
    static final int INT_NONE = 1;
    static final int INT_TEXT_FIT = 4;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STZoom$Enum[]{new STZoom$Enum("none", 1), new STZoom$Enum("fullPage", 2), new STZoom$Enum("bestFit", 3), new STZoom$Enum("textFit", 4)});

    private STZoom$Enum(String str, int i) {
        super(str, i);
    }

    public static STZoom$Enum forInt(int i) {
        return (STZoom$Enum) table.forInt(i);
    }

    public static STZoom$Enum forString(String str) {
        return (STZoom$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
