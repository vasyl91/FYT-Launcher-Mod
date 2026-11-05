package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum FontScheme {
    NONE(1),
    MAJOR(2),
    MINOR(3);

    private static FontScheme[] _table = new FontScheme[4];
    private int value;

    static {
        for (FontScheme fontScheme : values()) {
            _table[fontScheme.getValue()] = fontScheme;
        }
    }

    FontScheme(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static FontScheme valueOf(int i) {
        return _table[i];
    }
}
