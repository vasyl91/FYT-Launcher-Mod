package org.apache.poi.common.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum HyperlinkType {
    NONE(-1),
    URL(1),
    DOCUMENT(2),
    EMAIL(3),
    FILE(4);

    private static final Map<Integer, HyperlinkType> map = new HashMap();

    @Internal(since = "3.15 beta 3")
    @Deprecated
    private final int code;

    static {
        for (HyperlinkType hyperlinkType : values()) {
            map.put(Integer.valueOf(hyperlinkType.getCode()), hyperlinkType);
        }
    }

    @Internal(since = "3.15 beta 3")
    @Deprecated
    HyperlinkType(int i) {
        this.code = i;
    }

    @Internal(since = "3.15 beta 3")
    @Deprecated
    public int getCode() {
        return this.code;
    }

    @Internal(since = "3.15 beta 3")
    @Deprecated
    public static HyperlinkType forInt(int i) {
        HyperlinkType hyperlinkType = map.get(Integer.valueOf(i));
        if (hyperlinkType != null) {
            return hyperlinkType;
        }
        throw new IllegalArgumentException("Invalid type: " + i);
    }
}
