package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface FontFormatting {
    public static final short SS_NONE = 0;
    public static final short SS_SUB = 2;
    public static final short SS_SUPER = 1;
    public static final byte U_DOUBLE = 2;
    public static final byte U_DOUBLE_ACCOUNTING = 34;
    public static final byte U_NONE = 0;
    public static final byte U_SINGLE = 1;
    public static final byte U_SINGLE_ACCOUNTING = 33;

    short getEscapementType();

    Color getFontColor();

    short getFontColorIndex();

    int getFontHeight();

    short getUnderlineType();

    boolean isBold();

    boolean isItalic();

    boolean isStruckout();

    void resetFontStyle();

    void setEscapementType(short s);

    void setFontColor(Color color);

    void setFontColorIndex(short s);

    void setFontHeight(int i);

    void setFontStyle(boolean z, boolean z2);

    void setUnderlineType(short s);
}
