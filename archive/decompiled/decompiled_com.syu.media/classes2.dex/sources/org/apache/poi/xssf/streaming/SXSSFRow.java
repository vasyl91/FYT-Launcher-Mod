package org.apache.poi.xssf.streaming;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SXSSFRow implements Row, Comparable<SXSSFRow> {
    private static final Boolean UNDEFINED = null;
    private Boolean _collapsed;
    private Boolean _hidden;
    private final SXSSFSheet _sheet;
    private final SortedMap<Integer, SXSSFCell> _cells = new TreeMap();
    private short _style = -1;
    private short _height = -1;
    private boolean _zHeight = false;
    private int _outlineLevel = 0;

    public SXSSFRow(SXSSFSheet sXSSFSheet) {
        Boolean bool = UNDEFINED;
        this._hidden = bool;
        this._collapsed = bool;
        this._sheet = sXSSFSheet;
    }

    public Iterator<Cell> allCellsIterator() {
        return new CellIterator();
    }

    public boolean hasCustomHeight() {
        return this._height != -1;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getOutlineLevel() {
        return this._outlineLevel;
    }

    void setOutlineLevel(int i) {
        this._outlineLevel = i;
    }

    public Boolean getHidden() {
        return this._hidden;
    }

    public void setHidden(Boolean bool) {
        this._hidden = bool;
    }

    public Boolean getCollapsed() {
        return this._collapsed;
    }

    public void setCollapsed(Boolean bool) {
        this._collapsed = bool;
    }

    @Override // java.lang.Iterable
    public Iterator<Cell> iterator() {
        return new FilledCellIterator();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFCell createCell(int i) {
        return createCell(i, CellType.BLANK);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFCell createCell(int i, int i2) {
        return createCell(i, CellType.forInt(i2));
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFCell createCell(int i, CellType cellType) {
        checkBounds(i);
        SXSSFCell sXSSFCell = new SXSSFCell(this, cellType);
        this._cells.put(Integer.valueOf(i), sXSSFCell);
        return sXSSFCell;
    }

    private static void checkBounds(int i) {
        SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL2007;
        int lastColumnIndex = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();
        if (i < 0 || i > lastColumnIndex) {
            throw new IllegalArgumentException("Invalid column index (" + i + ").  Allowable column range for " + spreadsheetVersion.name() + " is (0.." + lastColumnIndex + ") or ('A'..'" + spreadsheetVersion.getLastColumnName() + "')");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void removeCell(Cell cell) {
        this._cells.remove(Integer.valueOf(getCellIndex((SXSSFCell) cell)));
    }

    int getCellIndex(SXSSFCell sXSSFCell) {
        for (Map.Entry<Integer, SXSSFCell> entry : this._cells.entrySet()) {
            if (entry.getValue() == sXSSFCell) {
                return entry.getKey().intValue();
            }
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowNum(int i) {
        this._sheet.changeRowNum(this, i);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getRowNum() {
        return this._sheet.getRowNum(this);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFCell getCell(int i) {
        return getCell(i, this._sheet.getWorkbook().getMissingCellPolicy());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFCell getCell(int i, Row.MissingCellPolicy missingCellPolicy) {
        checkBounds(i);
        SXSSFCell sXSSFCell = this._cells.get(Integer.valueOf(i));
        int i2 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[missingCellPolicy.ordinal()];
        if (i2 == 1) {
            return sXSSFCell;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                return sXSSFCell == null ? createCell(i, CellType.BLANK) : sXSSFCell;
            }
            throw new IllegalArgumentException("Illegal policy " + missingCellPolicy);
        }
        if (sXSSFCell != null && sXSSFCell.getCellTypeEnum() == CellType.BLANK) {
            return null;
        }
        return sXSSFCell;
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.streaming.SXSSFRow$1, reason: invalid class name */
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
    public short getFirstCellNum() {
        try {
            return this._cells.firstKey().shortValue();
        } catch (NoSuchElementException unused) {
            return (short) -1;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getLastCellNum() {
        if (this._cells.isEmpty()) {
            return (short) -1;
        }
        return (short) (this._cells.lastKey().intValue() + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getPhysicalNumberOfCells() {
        return this._cells.size();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeight(short s) {
        this._height = s;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setZeroHeight(boolean z) {
        this._zHeight = z;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean getZeroHeight() {
        return this._zHeight;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeightInPoints(float f) {
        if (f == -1.0f) {
            this._height = (short) -1;
        } else {
            this._height = (short) (f * 20.0f);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getHeight() {
        short s = this._height;
        return (short) (s == -1 ? getSheet().getDefaultRowHeightInPoints() * 20.0f : s);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public float getHeightInPoints() {
        short s = this._height;
        return (float) (s == -1 ? getSheet().getDefaultRowHeightInPoints() : ((double) s) / 20.0d);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean isFormatted() {
        return this._style > -1;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public CellStyle getRowStyle() {
        if (isFormatted()) {
            return getSheet().getWorkbook().getCellStyleAt(this._style);
        }
        return null;
    }

    @Internal
    int getRowStyleIndex() {
        return this._style;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowStyle(CellStyle cellStyle) {
        if (cellStyle == null) {
            this._style = (short) -1;
        } else {
            this._style = cellStyle.getIndex();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Iterator<Cell> cellIterator() {
        return iterator();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFSheet getSheet() {
        return this._sheet;
    }

    public class FilledCellIterator implements Iterator<Cell> {
        private final Iterator<SXSSFCell> iter;

        public FilledCellIterator() {
            this.iter = SXSSFRow.this._cells.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public Cell next() throws NoSuchElementException {
            return this.iter.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class CellIterator implements Iterator<Cell> {
        final int maxColumn;
        int pos = 0;

        public CellIterator() {
            this.maxColumn = SXSSFRow.this.getLastCellNum();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos < this.maxColumn;
        }

        @Override // java.util.Iterator
        public Cell next() throws NoSuchElementException {
            if (hasNext()) {
                SortedMap sortedMap = SXSSFRow.this._cells;
                int i = this.pos;
                this.pos = i + 1;
                return (Cell) sortedMap.get(Integer.valueOf(i));
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(SXSSFRow sXSSFRow) {
        if (getSheet() != sXSSFRow.getSheet()) {
            throw new IllegalArgumentException("The compared rows must belong to the same sheet");
        }
        return Integer.valueOf(getRowNum()).compareTo(Integer.valueOf(sXSSFRow.getRowNum()));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SXSSFRow)) {
            return false;
        }
        SXSSFRow sXSSFRow = (SXSSFRow) obj;
        return getRowNum() == sXSSFRow.getRowNum() && getSheet() == sXSSFRow.getSheet();
    }

    public int hashCode() {
        return this._cells.hashCode();
    }
}
