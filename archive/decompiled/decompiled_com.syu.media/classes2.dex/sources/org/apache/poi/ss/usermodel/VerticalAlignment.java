package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum VerticalAlignment {
    TOP,
    CENTER,
    BOTTOM,
    JUSTIFY,
    DISTRIBUTED;

    public short getCode() {
        return (short) ordinal();
    }

    public static VerticalAlignment forInt(int i) {
        if (i < 0 || i >= values().length) {
            throw new IllegalArgumentException("Invalid VerticalAlignment code: " + i);
        }
        return values()[i];
    }
}
