package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STDvAspect$Enum extends StringEnumAbstractBase {
    static final int INT_DVASPECT_CONTENT = 1;
    static final int INT_DVASPECT_ICON = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STDvAspect$Enum[]{new STDvAspect$Enum("DVASPECT_CONTENT", 1), new STDvAspect$Enum("DVASPECT_ICON", 2)});

    private STDvAspect$Enum(String str, int i) {
        super(str, i);
    }

    public static STDvAspect$Enum forInt(int i) {
        return (STDvAspect$Enum) table.forInt(i);
    }

    public static STDvAspect$Enum forString(String str) {
        return (STDvAspect$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
