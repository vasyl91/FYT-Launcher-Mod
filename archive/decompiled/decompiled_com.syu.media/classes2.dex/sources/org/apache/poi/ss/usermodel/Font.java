package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Font {
    public static final byte ANSI_CHARSET = 0;
    public static final short COLOR_NORMAL = Short.MAX_VALUE;
    public static final short COLOR_RED = 10;
    public static final byte DEFAULT_CHARSET = 1;
    public static final short SS_NONE = 0;
    public static final short SS_SUB = 2;
    public static final short SS_SUPER = 1;
    public static final byte SYMBOL_CHARSET = 2;
    public static final byte U_DOUBLE = 2;
    public static final byte U_DOUBLE_ACCOUNTING = 34;
    public static final byte U_NONE = 0;
    public static final byte U_SINGLE = 1;
    public static final byte U_SINGLE_ACCOUNTING = 33;

    boolean getBold();

    int getCharSet();

    short getColor();

    short getFontHeight();

    short getFontHeightInPoints();

    String getFontName();

    short getIndex();

    boolean getItalic();

    boolean getStrikeout();

    short getTypeOffset();

    byte getUnderline();

    void setBold(boolean z);

    void setCharSet(byte b);

    void setCharSet(int i);

    void setColor(short s);

    void setFontHeight(short s);

    void setFontHeightInPoints(short s);

    void setFontName(String str);

    void setItalic(boolean z);

    void setStrikeout(boolean z);

    void setTypeOffset(short s);

    void setUnderline(byte b);
}
