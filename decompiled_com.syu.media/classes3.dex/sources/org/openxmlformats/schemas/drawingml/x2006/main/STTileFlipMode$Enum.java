package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STTileFlipMode$Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 1;
    static final int INT_X = 2;
    static final int INT_XY = 4;
    static final int INT_Y = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTileFlipMode$Enum[]{new STTileFlipMode$Enum("none", 1), new STTileFlipMode$Enum("x", 2), new STTileFlipMode$Enum("y", 3), new STTileFlipMode$Enum("xy", 4)});

    private STTileFlipMode$Enum(String str, int i) {
        super(str, i);
    }

    public static STTileFlipMode$Enum forInt(int i) {
        return (STTileFlipMode$Enum) table.forInt(i);
    }

    public static STTileFlipMode$Enum forString(String str) {
        return (STTileFlipMode$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
