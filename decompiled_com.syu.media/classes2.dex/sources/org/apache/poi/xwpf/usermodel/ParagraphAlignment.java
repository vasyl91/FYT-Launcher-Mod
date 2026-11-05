package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum ParagraphAlignment {
    LEFT(1),
    CENTER(2),
    RIGHT(3),
    BOTH(4),
    MEDIUM_KASHIDA(5),
    DISTRIBUTE(6),
    NUM_TAB(7),
    HIGH_KASHIDA(8),
    LOW_KASHIDA(9),
    THAI_DISTRIBUTE(10);

    private static Map<Integer, ParagraphAlignment> imap = new HashMap();
    private final int value;

    static {
        for (ParagraphAlignment paragraphAlignment : values()) {
            imap.put(Integer.valueOf(paragraphAlignment.getValue()), paragraphAlignment);
        }
    }

    ParagraphAlignment(int i) {
        this.value = i;
    }

    public static ParagraphAlignment valueOf(int i) {
        ParagraphAlignment paragraphAlignment = imap.get(Integer.valueOf(i));
        if (paragraphAlignment != null) {
            return paragraphAlignment;
        }
        throw new IllegalArgumentException("Unknown paragraph alignment: " + i);
    }

    public int getValue() {
        return this.value;
    }
}
