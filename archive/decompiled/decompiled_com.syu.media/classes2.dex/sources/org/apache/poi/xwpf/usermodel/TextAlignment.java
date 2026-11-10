package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum TextAlignment {
    TOP(1),
    CENTER(2),
    BASELINE(3),
    BOTTOM(4),
    AUTO(5);

    private static Map<Integer, TextAlignment> imap = new HashMap();
    private final int value;

    static {
        for (TextAlignment textAlignment : values()) {
            imap.put(Integer.valueOf(textAlignment.getValue()), textAlignment);
        }
    }

    TextAlignment(int i) {
        this.value = i;
    }

    public static TextAlignment valueOf(int i) {
        TextAlignment textAlignment = imap.get(Integer.valueOf(i));
        if (textAlignment != null) {
            return textAlignment;
        }
        throw new IllegalArgumentException("Unknown text alignment: " + i);
    }

    public int getValue() {
        return this.value;
    }
}
