package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum HorizontalAlignment {
    GENERAL,
    LEFT,
    CENTER,
    RIGHT,
    FILL,
    JUSTIFY,
    CENTER_SELECTION,
    DISTRIBUTED;

    public short getCode() {
        return (short) ordinal();
    }

    public static HorizontalAlignment forInt(int i) {
        if (i < 0 || i >= values().length) {
            throw new IllegalArgumentException("Invalid HorizontalAlignment code: " + i);
        }
        return values()[i];
    }
}
