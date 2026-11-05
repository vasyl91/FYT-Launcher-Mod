package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum PrintCellComments {
    NONE(1),
    AS_DISPLAYED(2),
    AT_END(3);

    private static PrintCellComments[] _table = new PrintCellComments[4];
    private int comments;

    static {
        for (PrintCellComments printCellComments : values()) {
            _table[printCellComments.getValue()] = printCellComments;
        }
    }

    PrintCellComments(int i) {
        this.comments = i;
    }

    public int getValue() {
        return this.comments;
    }

    public static PrintCellComments valueOf(int i) {
        return _table[i];
    }
}
