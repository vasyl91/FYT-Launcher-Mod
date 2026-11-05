package org.apache.poi.hssf.usermodel;

import java.util.HashSet;
import java.util.Iterator;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFOptimiser {
    public static void optimiseFonts(HSSFWorkbook hSSFWorkbook) {
        int numberOfFontRecords = hSSFWorkbook.getWorkbook().getNumberOfFontRecords() + 1;
        short[] sArr = new short[numberOfFontRecords];
        boolean[] zArr = new boolean[numberOfFontRecords];
        for (int i = 0; i < numberOfFontRecords; i++) {
            sArr[i] = (short) i;
            zArr[i] = false;
        }
        FontRecord[] fontRecordArr = new FontRecord[numberOfFontRecords];
        for (int i2 = 0; i2 < numberOfFontRecords; i2++) {
            if (i2 != 4) {
                fontRecordArr[i2] = hSSFWorkbook.getWorkbook().getFontRecordAt(i2);
            }
        }
        for (int i3 = 5; i3 < numberOfFontRecords; i3++) {
            int i4 = -1;
            for (int i5 = 0; i5 < i3 && i4 == -1; i5++) {
                if (i5 != 4 && hSSFWorkbook.getWorkbook().getFontRecordAt(i5).sameProperties(fontRecordArr[i3])) {
                    i4 = i5;
                }
            }
            if (i4 != -1) {
                sArr[i3] = (short) i4;
                zArr[i3] = true;
            }
        }
        for (int i6 = 5; i6 < numberOfFontRecords; i6++) {
            short s = sArr[i6];
            short s2 = s;
            for (int i7 = 0; i7 < s; i7++) {
                if (zArr[i7]) {
                    s2 = (short) (s2 - 1);
                }
            }
            sArr[i6] = s2;
        }
        for (int i8 = 5; i8 < numberOfFontRecords; i8++) {
            if (zArr[i8]) {
                hSSFWorkbook.getWorkbook().removeFontRecord(fontRecordArr[i8]);
            }
        }
        hSSFWorkbook.resetFontCache();
        for (int i9 = 0; i9 < hSSFWorkbook.getWorkbook().getNumExFormats(); i9++) {
            ExtendedFormatRecord exFormatAt = hSSFWorkbook.getWorkbook().getExFormatAt(i9);
            exFormatAt.setFontIndex(sArr[exFormatAt.getFontIndex()]);
        }
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < hSSFWorkbook.getNumberOfSheets(); i10++) {
            Iterator<Row> it = hSSFWorkbook.getSheetAt(i10).iterator();
            while (it.hasNext()) {
                for (Cell cell : it.next()) {
                    if (cell.getCellTypeEnum() == CellType.STRING) {
                        UnicodeString rawUnicodeString = ((HSSFRichTextString) cell.getRichStringCellValue()).getRawUnicodeString();
                        if (!hashSet.contains(rawUnicodeString)) {
                            for (short s3 = 5; s3 < numberOfFontRecords; s3 = (short) (s3 + 1)) {
                                short s4 = sArr[s3];
                                if (s3 != s4) {
                                    rawUnicodeString.swapFontUse(s3, s4);
                                }
                            }
                            hashSet.add(rawUnicodeString);
                        }
                    }
                }
            }
        }
    }

    public static void optimiseCellStyles(HSSFWorkbook hSSFWorkbook) {
        int numExFormats = hSSFWorkbook.getWorkbook().getNumExFormats();
        short[] sArr = new short[numExFormats];
        boolean[] zArr = new boolean[numExFormats];
        boolean[] zArr2 = new boolean[numExFormats];
        for (int i = 0; i < numExFormats; i++) {
            zArr[i] = false;
            sArr[i] = (short) i;
            zArr2[i] = false;
        }
        ExtendedFormatRecord[] extendedFormatRecordArr = new ExtendedFormatRecord[numExFormats];
        for (int i2 = 0; i2 < numExFormats; i2++) {
            extendedFormatRecordArr[i2] = hSSFWorkbook.getWorkbook().getExFormatAt(i2);
        }
        int i3 = 21;
        for (int i4 = 21; i4 < numExFormats; i4++) {
            int i5 = -1;
            for (int i6 = 0; i6 < i4 && i5 == -1; i6++) {
                if (hSSFWorkbook.getWorkbook().getExFormatAt(i6).equals(extendedFormatRecordArr[i4])) {
                    i5 = i6;
                }
            }
            if (i5 != -1) {
                sArr[i4] = (short) i5;
                zArr2[i4] = true;
            }
            if (i5 != -1) {
                zArr[i5] = true;
            }
        }
        for (int i7 = 0; i7 < hSSFWorkbook.getNumberOfSheets(); i7++) {
            Iterator<Row> it = hSSFWorkbook.getSheetAt(i7).iterator();
            while (it.hasNext()) {
                Iterator<Cell> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    zArr[((HSSFCell) it2.next()).getCellValueRecord().getXFIndex()] = true;
                }
            }
        }
        for (int i8 = 21; i8 < numExFormats; i8++) {
            if (!zArr[i8]) {
                zArr2[i8] = true;
                sArr[i8] = 0;
            }
        }
        for (int i9 = 21; i9 < numExFormats; i9++) {
            short s = sArr[i9];
            short s2 = s;
            for (int i10 = 0; i10 < s; i10++) {
                if (zArr2[i10]) {
                    s2 = (short) (s2 - 1);
                }
            }
            sArr[i9] = s2;
        }
        int i11 = 0;
        while (i3 < numExFormats) {
            if (zArr2[i3 + i11]) {
                hSSFWorkbook.getWorkbook().removeExFormatRecord(i3);
                i3--;
                numExFormats--;
                i11++;
            }
            i3++;
        }
        for (int i12 = 0; i12 < hSSFWorkbook.getNumberOfSheets(); i12++) {
            Iterator<Row> it3 = hSSFWorkbook.getSheetAt(i12).iterator();
            while (it3.hasNext()) {
                for (HSSFCell hSSFCell : it3.next()) {
                    hSSFCell.setCellStyle(hSSFWorkbook.getCellStyleAt((int) sArr[hSSFCell.getCellValueRecord().getXFIndex()]));
                }
            }
        }
    }
}
