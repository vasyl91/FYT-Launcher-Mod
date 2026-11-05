package org.apache.poi.ss.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PaneInformation {
    public static final byte PANE_LOWER_LEFT = 2;
    public static final byte PANE_LOWER_RIGHT = 0;
    public static final byte PANE_UPPER_LEFT = 3;
    public static final byte PANE_UPPER_RIGHT = 1;
    private final byte activePane;
    private final boolean frozen;
    private final short leftColumn;
    private final short topRow;
    private final short x;
    private final short y;

    public PaneInformation(short s, short s2, short s3, short s4, byte b, boolean z) {
        this.x = s;
        this.y = s2;
        this.topRow = s3;
        this.leftColumn = s4;
        this.activePane = b;
        this.frozen = z;
    }

    public short getVerticalSplitPosition() {
        return this.x;
    }

    public short getHorizontalSplitPosition() {
        return this.y;
    }

    public short getHorizontalSplitTopRow() {
        return this.topRow;
    }

    public short getVerticalSplitLeftColumn() {
        return this.leftColumn;
    }

    public byte getActivePane() {
        return this.activePane;
    }

    public boolean isFreezePane() {
        return this.frozen;
    }
}
