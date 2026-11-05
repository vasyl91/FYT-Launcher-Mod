package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum BreakClear {
    NONE(1),
    LEFT(2),
    RIGHT(3),
    ALL(4);

    private static Map<Integer, BreakClear> imap = new HashMap();
    private final int value;

    static {
        for (BreakClear breakClear : values()) {
            imap.put(Integer.valueOf(breakClear.getValue()), breakClear);
        }
    }

    BreakClear(int i) {
        this.value = i;
    }

    public static BreakClear valueOf(int i) {
        BreakClear breakClear = imap.get(Integer.valueOf(i));
        if (breakClear != null) {
            return breakClear;
        }
        throw new IllegalArgumentException("Unknown break clear type: " + i);
    }

    public int getValue() {
        return this.value;
    }
}
