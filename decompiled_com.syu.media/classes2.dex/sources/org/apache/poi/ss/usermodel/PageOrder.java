package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum PageOrder {
    DOWN_THEN_OVER(1),
    OVER_THEN_DOWN(2);

    private static PageOrder[] _table = new PageOrder[3];
    private final int order;

    static {
        for (PageOrder pageOrder : values()) {
            _table[pageOrder.getValue()] = pageOrder;
        }
    }

    PageOrder(int i) {
        this.order = i;
    }

    public int getValue() {
        return this.order;
    }

    public static PageOrder valueOf(int i) {
        return _table[i];
    }
}
