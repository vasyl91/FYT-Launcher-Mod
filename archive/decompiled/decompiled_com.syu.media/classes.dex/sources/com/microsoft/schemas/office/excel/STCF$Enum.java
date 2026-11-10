package com.microsoft.schemas.office.excel;

import com.bumptech.glide.Registry;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class STCF$Enum extends StringEnumAbstractBase {
    static final int INT_BITMAP = 3;
    static final int INT_PICT = 2;
    static final int INT_PICT_OLD = 1;
    static final int INT_PICT_PRINT = 4;
    static final int INT_PICT_SCREEN = 5;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STCF$Enum[]{new STCF$Enum("PictOld", 1), new STCF$Enum("Pict", 2), new STCF$Enum(Registry.BUCKET_BITMAP, 3), new STCF$Enum("PictPrint", 4), new STCF$Enum("PictScreen", 5)});

    private STCF$Enum(String str, int i) {
        super(str, i);
    }

    public static STCF$Enum forInt(int i) {
        return (STCF$Enum) table.forInt(i);
    }

    public static STCF$Enum forString(String str) {
        return (STCF$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
