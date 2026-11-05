package org.apache.poi.wp.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum HeaderFooterType {
    DEFAULT(2),
    EVEN(1),
    FIRST(3);

    private final int code;

    HeaderFooterType(int i) {
        this.code = i;
    }

    public int toInt() {
        return this.code;
    }

    public static HeaderFooterType forInt(int i) {
        for (HeaderFooterType headerFooterType : values()) {
            if (headerFooterType.code == i) {
                return headerFooterType;
            }
        }
        throw new IllegalArgumentException("Invalid HeaderFooterType code: " + i);
    }
}
