package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum PrintOrientation {
    DEFAULT(1),
    PORTRAIT(2),
    LANDSCAPE(3);

    private static PrintOrientation[] _table = new PrintOrientation[4];
    private int orientation;

    static {
        for (PrintOrientation printOrientation : values()) {
            _table[printOrientation.getValue()] = printOrientation;
        }
    }

    PrintOrientation(int i) {
        this.orientation = i;
    }

    public int getValue() {
        return this.orientation;
    }

    public static PrintOrientation valueOf(int i) {
        return _table[i];
    }
}
