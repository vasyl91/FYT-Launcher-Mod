package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum LineSpacingRule {
    AUTO(1),
    EXACT(2),
    AT_LEAST(3);

    private static Map<Integer, LineSpacingRule> imap = new HashMap();
    private final int value;

    static {
        for (LineSpacingRule lineSpacingRule : values()) {
            imap.put(Integer.valueOf(lineSpacingRule.getValue()), lineSpacingRule);
        }
    }

    LineSpacingRule(int i) {
        this.value = i;
    }

    public static LineSpacingRule valueOf(int i) {
        LineSpacingRule lineSpacingRule = imap.get(Integer.valueOf(i));
        if (lineSpacingRule != null) {
            return lineSpacingRule;
        }
        throw new IllegalArgumentException("Unknown line type: " + i);
    }

    public int getValue() {
        return this.value;
    }
}
