package org.apache.poi.hssf.usermodel;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.poi.hpsf.Variant;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.Configurator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFRow implements Row, Comparable<HSSFRow> {
    public static final int INITIAL_CAPACITY = Configurator.getIntValue("HSSFRow.ColInitialCapacity", 5);
    private final HSSFWorkbook book;
    private HSSFCell[] cells;
    private final RowRecord row;
    private int rowNum;
    private final HSSFSheet sheet;

    HSSFRow(HSSFWorkbook hSSFWorkbook, HSSFSheet hSSFSheet, int i) {
        this(hSSFWorkbook, hSSFSheet, new RowRecord(i));
    }

    HSSFRow(HSSFWorkbook hSSFWorkbook, HSSFSheet hSSFSheet, RowRecord rowRecord) {
        this.book = hSSFWorkbook;
        this.sheet = hSSFSheet;
        this.row = rowRecord;
        setRowNum(rowRecord.getRowNumber());
        this.cells = new HSSFCell[rowRecord.getLastCol() + INITIAL_CAPACITY];
        rowRecord.setEmpty();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCell createCell(int i) {
        return createCell(i, CellType.BLANK);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCell createCell(int i, int i2) {
        return createCell(i, CellType.forInt(i2));
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCell createCell(int i, CellType cellType) {
        short s = (short) i;
        if (i > 32767) {
            s = (short) (Variant.VT_ILLEGAL - i);
        }
        HSSFCell hSSFCell = new HSSFCell(this.book, this.sheet, getRowNum(), s, cellType);
        addCell(hSSFCell);
        this.sheet.getSheet().addValueRecord(getRowNum(), hSSFCell.getCellValueRecord());
        return hSSFCell;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void removeCell(Cell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("cell must not be null");
        }
        removeCell((HSSFCell) cell, true);
    }

    private void removeCell(HSSFCell hSSFCell, boolean z) {
        int columnIndex = hSSFCell.getColumnIndex();
        if (columnIndex < 0) {
            throw new RuntimeException("Negative cell indexes not allowed");
        }
        HSSFCell[] hSSFCellArr = this.cells;
        if (columnIndex >= hSSFCellArr.length || hSSFCell != hSSFCellArr[columnIndex]) {
            throw new RuntimeException("Specified cell is not from this row");
        }
        if (hSSFCell.isPartOfArrayFormulaGroup()) {
            hSSFCell.notifyArrayFormulaChanging();
        }
        this.cells[columnIndex] = null;
        if (z) {
            this.sheet.getSheet().removeValueRecord(getRowNum(), hSSFCell.getCellValueRecord());
        }
        if (hSSFCell.getColumnIndex() + 1 == this.row.getLastCol()) {
            RowRecord rowRecord = this.row;
            rowRecord.setLastCol(calculateNewLastCellPlusOne(rowRecord.getLastCol()));
        }
        if (hSSFCell.getColumnIndex() == this.row.getFirstCol()) {
            RowRecord rowRecord2 = this.row;
            rowRecord2.setFirstCol(calculateNewFirstCell(rowRecord2.getFirstCol()));
        }
    }

    protected void removeAllCells() {
        for (HSSFCell hSSFCell : this.cells) {
            if (hSSFCell != null) {
                removeCell(hSSFCell, true);
            }
        }
        this.cells = new HSSFCell[INITIAL_CAPACITY];
    }

    HSSFCell createCellFromRecord(CellValueRecordInterface cellValueRecordInterface) {
        HSSFCell hSSFCell = new HSSFCell(this.book, this.sheet, cellValueRecordInterface);
        addCell(hSSFCell);
        short column = cellValueRecordInterface.getColumn();
        if (this.row.isEmpty()) {
            this.row.setFirstCol(column);
            this.row.setLastCol(column + 1);
        } else if (column < this.row.getFirstCol()) {
            this.row.setFirstCol(column);
        } else if (column > this.row.getLastCol()) {
            this.row.setLastCol(column + 1);
        }
        return hSSFCell;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowNum(int i) {
        int lastRowIndex = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        if (i < 0 || i > lastRowIndex) {
            throw new IllegalArgumentException("Invalid row number (" + i + ") outside allowable range (0.." + lastRowIndex + ")");
        }
        this.rowNum = i;
        RowRecord rowRecord = this.row;
        if (rowRecord != null) {
            rowRecord.setRowNumber(i);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getRowNum() {
        return this.rowNum;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFSheet getSheet() {
        return this.sheet;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getOutlineLevel() {
        return this.row.getOutlineLevel();
    }

    public void moveCell(HSSFCell hSSFCell, short s) {
        HSSFCell[] hSSFCellArr = this.cells;
        if (hSSFCellArr.length > s && hSSFCellArr[s] != null) {
            throw new IllegalArgumentException("Asked to move cell to column " + ((int) s) + " but there's already a cell there");
        }
        if (!hSSFCellArr[hSSFCell.getColumnIndex()].equals(hSSFCell)) {
            throw new IllegalArgumentException("Asked to move a cell, but it didn't belong to our row");
        }
        removeCell(hSSFCell, false);
        hSSFCell.updateCellNum(s);
        addCell(hSSFCell);
    }

    private void addCell(HSSFCell hSSFCell) {
        int columnIndex = hSSFCell.getColumnIndex();
        HSSFCell[] hSSFCellArr = this.cells;
        if (columnIndex >= hSSFCellArr.length) {
            int length = ((hSSFCellArr.length * 3) / 2) + 1;
            if (length < columnIndex + 1) {
                length = INITIAL_CAPACITY + columnIndex;
            }
            HSSFCell[] hSSFCellArr2 = new HSSFCell[length];
            this.cells = hSSFCellArr2;
            System.arraycopy(hSSFCellArr, 0, hSSFCellArr2, 0, hSSFCellArr.length);
        }
        this.cells[columnIndex] = hSSFCell;
        if (this.row.isEmpty() || columnIndex < this.row.getFirstCol()) {
            this.row.setFirstCol((short) columnIndex);
        }
        if (this.row.isEmpty() || columnIndex >= this.row.getLastCol()) {
            this.row.setLastCol((short) (columnIndex + 1));
        }
    }

    private HSSFCell retrieveCell(int i) {
        if (i < 0) {
            return null;
        }
        HSSFCell[] hSSFCellArr = this.cells;
        if (i >= hSSFCellArr.length) {
            return null;
        }
        return hSSFCellArr[i];
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCell getCell(int i) {
        return getCell(i, this.book.getMissingCellPolicy());
    }

    /* JADX INFO: renamed from: org.apache.poi.hssf.usermodel.HSSFRow$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy;

        static {
            int[] iArr = new int[Row.MissingCellPolicy.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy = iArr;
            try {
                iArr[Row.MissingCellPolicy.RETURN_NULL_AND_BLANK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[Row.MissingCellPolicy.RETURN_BLANK_AS_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[Row.MissingCellPolicy.CREATE_NULL_AS_BLANK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCell getCell(int i, Row.MissingCellPolicy missingCellPolicy) {
        HSSFCell hSSFCellRetrieveCell = retrieveCell(i);
        int i2 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[missingCellPolicy.ordinal()];
        if (i2 == 1) {
            return hSSFCellRetrieveCell;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                return hSSFCellRetrieveCell == null ? createCell(i, CellType.BLANK) : hSSFCellRetrieveCell;
            }
            throw new IllegalArgumentException("Illegal policy " + missingCellPolicy);
        }
        if (hSSFCellRetrieveCell != null && hSSFCellRetrieveCell.getCellTypeEnum() == CellType.BLANK) {
            return null;
        }
        return hSSFCellRetrieveCell;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getFirstCellNum() {
        if (this.row.isEmpty()) {
            return (short) -1;
        }
        return (short) this.row.getFirstCol();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getLastCellNum() {
        if (this.row.isEmpty()) {
            return (short) -1;
        }
        return (short) this.row.getLastCol();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getPhysicalNumberOfCells() {
        int i = 0;
        for (HSSFCell hSSFCell : this.cells) {
            if (hSSFCell != null) {
                i++;
            }
        }
        return i;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeight(short s) {
        if (s == -1) {
            this.row.setHeight((short) -32513);
            this.row.setBadFontHeight(false);
        } else {
            this.row.setBadFontHeight(true);
            this.row.setHeight(s);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setZeroHeight(boolean z) {
        this.row.setZeroHeight(z);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean getZeroHeight() {
        return this.row.getZeroHeight();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeightInPoints(float f) {
        if (f == -1.0f) {
            this.row.setHeight((short) -32513);
            this.row.setBadFontHeight(false);
        } else {
            this.row.setBadFontHeight(true);
            this.row.setHeight((short) (f * 20.0f));
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getHeight() {
        short height = this.row.getHeight();
        return (Short.MIN_VALUE & height) != 0 ? this.sheet.getSheet().getDefaultRowHeight() : (short) (height & Short.MAX_VALUE);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public float getHeightInPoints() {
        return getHeight() / 20.0f;
    }

    protected RowRecord getRowRecord() {
        return this.row;
    }

    private int calculateNewLastCellPlusOne(int i) {
        int i2 = i - 1;
        HSSFCell hSSFCellRetrieveCell = retrieveCell(i2);
        while (hSSFCellRetrieveCell == null) {
            if (i2 < 0) {
                return 0;
            }
            i2--;
            hSSFCellRetrieveCell = retrieveCell(i2);
        }
        return i2 + 1;
    }

    private int calculateNewFirstCell(int i) {
        int i2 = i + 1;
        HSSFCell hSSFCellRetrieveCell = retrieveCell(i2);
        while (hSSFCellRetrieveCell == null) {
            if (i2 <= this.cells.length) {
                return 0;
            }
            i2++;
            hSSFCellRetrieveCell = retrieveCell(i2);
        }
        return i2;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean isFormatted() {
        return this.row.getFormatted();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCellStyle getRowStyle() {
        if (!isFormatted()) {
            return null;
        }
        short xFIndex = this.row.getXFIndex();
        return new HSSFCellStyle(xFIndex, this.book.getWorkbook().getExFormatAt(xFIndex), this.book);
    }

    public void setRowStyle(HSSFCellStyle hSSFCellStyle) {
        this.row.setFormatted(true);
        this.row.setXFIndex(hSSFCellStyle.getIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowStyle(CellStyle cellStyle) {
        setRowStyle((HSSFCellStyle) cellStyle);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Iterator<Cell> cellIterator() {
        return new CellIterator();
    }

    @Override // java.lang.Iterable
    public Iterator<Cell> iterator() {
        return cellIterator();
    }

    private class CellIterator implements Iterator<Cell> {
        int thisId = -1;
        int nextId = -1;

        public CellIterator() {
            findNext();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextId < HSSFRow.this.cells.length;
        }

        @Override // java.util.Iterator
        public Cell next() {
            if (hasNext()) {
                HSSFCell[] hSSFCellArr = HSSFRow.this.cells;
                int i = this.nextId;
                HSSFCell hSSFCell = hSSFCellArr[i];
                this.thisId = i;
                findNext();
                return hSSFCell;
            }
            throw new NoSuchElementException("At last element");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.thisId != -1) {
                HSSFRow.this.cells[this.thisId] = null;
                return;
            }
            throw new IllegalStateException("remove() called before next()");
        }

        private void findNext() {
            int i = this.nextId;
            do {
                i++;
                if (i >= HSSFRow.this.cells.length) {
                    break;
                }
            } while (HSSFRow.this.cells[i] == null);
            this.nextId = i;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(HSSFRow hSSFRow) {
        if (getSheet() != hSSFRow.getSheet()) {
            throw new IllegalArgumentException("The compared rows must belong to the same sheet");
        }
        return Integer.valueOf(getRowNum()).compareTo(Integer.valueOf(hSSFRow.getRowNum()));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HSSFRow)) {
            return false;
        }
        HSSFRow hSSFRow = (HSSFRow) obj;
        return getRowNum() == hSSFRow.getRowNum() && getSheet() == hSSFRow.getSheet();
    }

    public int hashCode() {
        return this.row.hashCode();
    }
}
