package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum BreakType {
    PAGE(1),
    COLUMN(2),
    TEXT_WRAPPING(3);

    private static Map<Integer, BreakType> imap = new HashMap();
    private final int value;

    static {
        for (BreakType breakType : values()) {
            imap.put(Integer.valueOf(breakType.getValue()), breakType);
        }
    }

    BreakType(int i) {
        this.value = i;
    }

    public static BreakType valueOf(int i) {
        BreakType breakType = imap.get(Integer.valueOf(i));
        if (breakType != null) {
            return breakType;
        }
        throw new IllegalArgumentException("Unknown break type: " + i);
    }

    public int getValue() {
        return this.value;
    }
}
