package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum CellType {
    _NONE(-1),
    NUMERIC(0),
    STRING(1),
    FORMULA(2),
    BLANK(3),
    BOOLEAN(4),
    ERROR(5);

    private final int code;

    CellType(int i) {
        this.code = i;
    }

    public static CellType forInt(int i) {
        for (CellType cellType : values()) {
            if (cellType.code == i) {
                return cellType;
            }
        }
        throw new IllegalArgumentException("Invalid CellType code: " + i);
    }

    public int getCode() {
        return this.code;
    }
}
