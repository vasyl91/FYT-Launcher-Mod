package org.apache.poi.ss.util.cellwalk;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CellWalk {
    private CellRangeAddress range;
    private Sheet sheet;
    private boolean traverseEmptyCells = false;

    public CellWalk(Sheet sheet, CellRangeAddress cellRangeAddress) {
        this.sheet = sheet;
        this.range = cellRangeAddress;
    }

    public boolean isTraverseEmptyCells() {
        return this.traverseEmptyCells;
    }

    public void setTraverseEmptyCells(boolean z) {
        this.traverseEmptyCells = z;
    }

    public void traverse(CellHandler cellHandler) {
        int firstRow = this.range.getFirstRow();
        int lastRow = this.range.getLastRow();
        int firstColumn = this.range.getFirstColumn();
        int lastColumn = this.range.getLastColumn();
        int i = (lastColumn - firstColumn) + 1;
        SimpleCellWalkContext simpleCellWalkContext = new SimpleCellWalkContext();
        simpleCellWalkContext.rowNumber = firstRow;
        while (simpleCellWalkContext.rowNumber <= lastRow) {
            Row row = this.sheet.getRow(simpleCellWalkContext.rowNumber);
            if (row != null) {
                simpleCellWalkContext.colNumber = firstColumn;
                while (simpleCellWalkContext.colNumber <= lastColumn) {
                    Cell cell = row.getCell(simpleCellWalkContext.colNumber);
                    if (cell != null && (!isEmpty(cell) || this.traverseEmptyCells)) {
                        simpleCellWalkContext.ordinalNumber = ((simpleCellWalkContext.rowNumber - firstRow) * i) + (simpleCellWalkContext.colNumber - firstColumn) + 1;
                        cellHandler.onCell(cell, simpleCellWalkContext);
                    }
                    simpleCellWalkContext.colNumber++;
                }
            }
            simpleCellWalkContext.rowNumber++;
        }
    }

    private boolean isEmpty(Cell cell) {
        return cell.getCellTypeEnum() == CellType.BLANK;
    }

    private static class SimpleCellWalkContext implements CellWalkContext {
        public int colNumber;
        public long ordinalNumber;
        public int rowNumber;

        private SimpleCellWalkContext() {
            this.ordinalNumber = 0L;
            this.rowNumber = 0;
            this.colNumber = 0;
        }

        @Override // org.apache.poi.ss.util.cellwalk.CellWalkContext
        public long getOrdinalNumber() {
            return this.ordinalNumber;
        }

        @Override // org.apache.poi.ss.util.cellwalk.CellWalkContext
        public int getRowNumber() {
            return this.rowNumber;
        }

        @Override // org.apache.poi.ss.util.cellwalk.CellWalkContext
        public int getColumnNumber() {
            return this.colNumber;
        }
    }
}
