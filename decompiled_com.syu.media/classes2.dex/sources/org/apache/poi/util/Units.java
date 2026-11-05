package org.apache.poi.util;

import org.apache.poi.hpsf.Variant;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Units {
    public static final float DEFAULT_CHARACTER_WIDTH = 7.0017f;
    public static final int EMU_PER_CENTIMETER = 360000;
    public static final int EMU_PER_CHARACTER = 66691;
    public static final int EMU_PER_PIXEL = 9525;
    public static final int EMU_PER_POINT = 12700;
    public static final int MASTER_DPI = 576;
    public static final int PIXEL_DPI = 96;
    public static final int POINT_DPI = 72;

    public static int TwipsToEMU(short s) {
        return (int) ((((double) s) / 20.0d) * 12700.0d);
    }

    public static int charactersToEMU(double d) {
        return ((int) d) * EMU_PER_CHARACTER;
    }

    public static double fixedPointToDouble(int i) {
        return ((double) (i >> 16)) + (((double) (i & Variant.VT_ILLEGAL)) / 65536.0d);
    }

    public static double masterToPoints(int i) {
        return (((double) i) * 72.0d) / 576.0d;
    }

    public static int pixelToEMU(int i) {
        return i * 9525;
    }

    public static double pixelToPoints(int i) {
        return (((double) i) * 72.0d) / 96.0d;
    }

    public static double toPoints(long j) {
        return j / 12700.0d;
    }

    public static int toEMU(double d) {
        return (int) Math.rint(d * 12700.0d);
    }

    public static int doubleToFixedPoint(double d) {
        double d2 = d % 1.0d;
        return (((int) Math.floor(d - d2)) << 16) | (((int) Math.rint(d2 * 65536.0d)) & Variant.VT_ILLEGAL);
    }

    public static int pointsToMaster(double d) {
        return (int) Math.rint((d * 576.0d) / 72.0d);
    }

    public static int pointsToPixel(double d) {
        return (int) Math.rint((d * 96.0d) / 72.0d);
    }

    public static int columnWidthToEMU(int i) {
        return charactersToEMU(((double) i) / 256.0d);
    }
}
