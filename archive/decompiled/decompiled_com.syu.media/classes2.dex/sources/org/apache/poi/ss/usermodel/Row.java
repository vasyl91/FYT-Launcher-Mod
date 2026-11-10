package org.apache.poi.ss.usermodel;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Row extends Iterable<Cell> {

    public enum MissingCellPolicy {
        RETURN_NULL_AND_BLANK,
        RETURN_BLANK_AS_NULL,
        CREATE_NULL_AS_BLANK
    }

    Iterator<Cell> cellIterator();

    Cell createCell(int i);

    Cell createCell(int i, int i2);

    Cell createCell(int i, CellType cellType);

    Cell getCell(int i);

    Cell getCell(int i, MissingCellPolicy missingCellPolicy);

    short getFirstCellNum();

    short getHeight();

    float getHeightInPoints();

    short getLastCellNum();

    int getOutlineLevel();

    int getPhysicalNumberOfCells();

    int getRowNum();

    CellStyle getRowStyle();

    Sheet getSheet();

    boolean getZeroHeight();

    boolean isFormatted();

    void removeCell(Cell cell);

    void setHeight(short s);

    void setHeightInPoints(float f);

    void setRowNum(int i);

    void setRowStyle(CellStyle cellStyle);

    void setZeroHeight(boolean z);
}
