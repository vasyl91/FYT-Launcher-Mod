package org.apache.poi.xssf.binary;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class XSSFBCellHeader {
    public static int length = 8;
    private int colNum;
    private int rowNum;
    private boolean showPhonetic;
    private int styleIdx;

    XSSFBCellHeader() {
    }

    public static void parse(byte[] bArr, int i, int i2, XSSFBCellHeader xSSFBCellHeader) {
        xSSFBCellHeader.reset(i2, XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, i)), XSSFBUtils.get24BitInt(bArr, i + 4), false);
    }

    public void reset(int i, int i2, int i3, boolean z) {
        this.rowNum = i;
        this.colNum = i2;
        this.styleIdx = i3;
        this.showPhonetic = z;
    }

    int getColNum() {
        return this.colNum;
    }

    int getStyleIdx() {
        return this.styleIdx;
    }
}
