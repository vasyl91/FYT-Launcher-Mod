package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STSheetViewType$Enum extends StringEnumAbstractBase {
    static final int INT_NORMAL = 1;
    static final int INT_PAGE_BREAK_PREVIEW = 2;
    static final int INT_PAGE_LAYOUT = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STSheetViewType$Enum[]{new STSheetViewType$Enum("normal", 1), new STSheetViewType$Enum("pageBreakPreview", 2), new STSheetViewType$Enum("pageLayout", 3)});

    private STSheetViewType$Enum(String str, int i) {
        super(str, i);
    }

    public static STSheetViewType$Enum forInt(int i) {
        return (STSheetViewType$Enum) table.forInt(i);
    }

    public static STSheetViewType$Enum forString(String str) {
        return (STSheetViewType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
