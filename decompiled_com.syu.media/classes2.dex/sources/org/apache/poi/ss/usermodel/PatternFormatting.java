package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface PatternFormatting {
    public static final short ALT_BARS = 3;
    public static final short BIG_SPOTS = 9;
    public static final short BRICKS = 10;
    public static final short DIAMONDS = 16;
    public static final short FINE_DOTS = 2;
    public static final short LEAST_DOTS = 18;
    public static final short LESS_DOTS = 17;
    public static final short NO_FILL = 0;
    public static final short SOLID_FOREGROUND = 1;
    public static final short SPARSE_DOTS = 4;
    public static final short SQUARES = 15;
    public static final short THICK_BACKWARD_DIAG = 7;
    public static final short THICK_FORWARD_DIAG = 8;
    public static final short THICK_HORZ_BANDS = 5;
    public static final short THICK_VERT_BANDS = 6;
    public static final short THIN_BACKWARD_DIAG = 13;
    public static final short THIN_FORWARD_DIAG = 14;
    public static final short THIN_HORZ_BANDS = 11;
    public static final short THIN_VERT_BANDS = 12;

    short getFillBackgroundColor();

    Color getFillBackgroundColorColor();

    short getFillForegroundColor();

    Color getFillForegroundColorColor();

    short getFillPattern();

    void setFillBackgroundColor(Color color);

    void setFillBackgroundColor(short s);

    void setFillForegroundColor(Color color);

    void setFillForegroundColor(short s);

    void setFillPattern(short s);
}
