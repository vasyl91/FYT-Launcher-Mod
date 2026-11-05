package org.apache.poi.hssf.util;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFRegionUtil {
    private HSSFRegionUtil() {
    }

    public static void setBorderLeft(int i, CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setBorderLeft(i, cellRangeAddress, hSSFSheet);
    }

    public static void setLeftBorderColor(int i, CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setLeftBorderColor(i, cellRangeAddress, hSSFSheet);
    }

    public static void setBorderRight(int i, CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setBorderRight(i, cellRangeAddress, hSSFSheet);
    }

    public static void setRightBorderColor(int i, CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setRightBorderColor(i, cellRangeAddress, hSSFSheet);
    }

    public static void setBorderBottom(int i, CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setBorderBottom(i, cellRangeAddress, hSSFSheet);
    }

    public static void setBottomBorderColor(int i, CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setBottomBorderColor(i, cellRangeAddress, hSSFSheet);
    }

    public static void setBorderTop(int i, CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setBorderTop(i, cellRangeAddress, hSSFSheet);
    }

    public static void setTopBorderColor(int i, CellRangeAddress cellRangeAddress, HSSFSheet hSSFSheet, HSSFWorkbook hSSFWorkbook) {
        RegionUtil.setTopBorderColor(i, cellRangeAddress, hSSFSheet);
    }
}
