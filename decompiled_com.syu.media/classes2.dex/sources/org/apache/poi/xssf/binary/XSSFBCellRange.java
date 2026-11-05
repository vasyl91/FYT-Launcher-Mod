package org.apache.poi.xssf.binary;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class XSSFBCellRange {
    public static final int length = 16;
    int firstCol;
    int firstRow;
    int lastCol;
    int lastRow;

    XSSFBCellRange() {
    }

    public static XSSFBCellRange parse(byte[] bArr, int i, XSSFBCellRange xSSFBCellRange) {
        if (xSSFBCellRange == null) {
            xSSFBCellRange = new XSSFBCellRange();
        }
        xSSFBCellRange.firstRow = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, i));
        int i2 = i + 4;
        xSSFBCellRange.lastRow = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, i2));
        int i3 = i2 + 4;
        xSSFBCellRange.firstCol = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, i3));
        xSSFBCellRange.lastCol = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, i3 + 4));
        return xSSFBCellRange;
    }
}
