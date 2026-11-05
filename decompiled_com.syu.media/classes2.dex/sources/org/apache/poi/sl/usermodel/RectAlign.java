package org.apache.poi.sl.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum RectAlign {
    TOP_LEFT("tl"),
    TOP("t"),
    TOP_RIGHT("tr"),
    LEFT("l"),
    CENTER("ctr"),
    RIGHT("r"),
    BOTTOM_LEFT("bl"),
    BOTTOM("b"),
    BOTTOM_RIGHT("br");

    private final String dir;

    RectAlign(String str) {
        this.dir = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.dir;
    }
}
