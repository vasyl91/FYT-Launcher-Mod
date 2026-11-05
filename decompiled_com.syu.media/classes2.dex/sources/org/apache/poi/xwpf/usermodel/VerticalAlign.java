package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum VerticalAlign {
    BASELINE(1),
    SUPERSCRIPT(2),
    SUBSCRIPT(3);

    private static Map<Integer, VerticalAlign> imap = new HashMap();
    private final int value;

    static {
        for (VerticalAlign verticalAlign : values()) {
            imap.put(Integer.valueOf(verticalAlign.getValue()), verticalAlign);
        }
    }

    VerticalAlign(int i) {
        this.value = i;
    }

    public static VerticalAlign valueOf(int i) {
        VerticalAlign verticalAlign = imap.get(Integer.valueOf(i));
        if (verticalAlign != null) {
            return verticalAlign;
        }
        throw new IllegalArgumentException("Unknown vertical alignment: " + i);
    }

    public int getValue() {
        return this.value;
    }
}
