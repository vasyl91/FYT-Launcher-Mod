package org.apache.poi.xssf.usermodel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.model.CalculationChain;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFRow implements Row, Comparable<XSSFRow> {
    private final TreeMap<Integer, XSSFCell> _cells = new TreeMap<>();
    private final CTRow _row;
    private final XSSFSheet _sheet;

    protected XSSFRow(CTRow cTRow, XSSFSheet xSSFSheet) {
        this._row = cTRow;
        this._sheet = xSSFSheet;
        for (CTCell cTCell : cTRow.getCArray()) {
            XSSFCell xSSFCell = new XSSFCell(this, cTCell);
            this._cells.put(new Integer(xSSFCell.getColumnIndex()), xSSFCell);
            xSSFSheet.onReadCell(xSSFCell);
        }
        if (cTRow.isSetR()) {
            return;
        }
        int lastRowNum = xSSFSheet.getLastRowNum() + 2;
        if (lastRowNum == 2 && xSSFSheet.getPhysicalNumberOfRows() == 0) {
            lastRowNum = 1;
        }
        cTRow.setR(lastRowNum);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFSheet getSheet() {
        return this._sheet;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Iterator<Cell> cellIterator() {
        return this._cells.values().iterator();
    }

    @Override // java.lang.Iterable
    public Iterator<Cell> iterator() {
        return cellIterator();
    }

    @Override // java.lang.Comparable
    public int compareTo(XSSFRow xSSFRow) {
        if (getSheet() != xSSFRow.getSheet()) {
            throw new IllegalArgumentException("The compared rows must belong to the same sheet");
        }
        return Integer.valueOf(getRowNum()).compareTo(Integer.valueOf(xSSFRow.getRowNum()));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XSSFRow)) {
            return false;
        }
        XSSFRow xSSFRow = (XSSFRow) obj;
        return getRowNum() == xSSFRow.getRowNum() && getSheet() == xSSFRow.getSheet();
    }

    public int hashCode() {
        return this._row.hashCode();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell createCell(int i) {
        return createCell(i, CellType.BLANK);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell createCell(int i, int i2) {
        return createCell(i, CellType.forInt(i2));
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell createCell(int i, CellType cellType) {
        CTCell cTCellAddNewC;
        Integer num = new Integer(i);
        XSSFCell xSSFCell = this._cells.get(num);
        if (xSSFCell != null) {
            cTCellAddNewC = xSSFCell.getCTCell();
            cTCellAddNewC.set(CTCell.Factory.newInstance());
        } else {
            cTCellAddNewC = this._row.addNewC();
        }
        XSSFCell xSSFCell2 = new XSSFCell(this, cTCellAddNewC);
        xSSFCell2.setCellNum(i);
        if (cellType != CellType.BLANK) {
            xSSFCell2.setCellType(cellType);
        }
        this._cells.put(num, xSSFCell2);
        return xSSFCell2;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell getCell(int i) {
        return getCell(i, this._sheet.getWorkbook().getMissingCellPolicy());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell getCell(int i, Row.MissingCellPolicy missingCellPolicy) {
        if (i < 0) {
            throw new IllegalArgumentException("Cell index must be >= 0");
        }
        XSSFCell xSSFCell = this._cells.get(new Integer(i));
        int i2 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[missingCellPolicy.ordinal()];
        if (i2 == 1) {
            return xSSFCell;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                return xSSFCell == null ? createCell(i, CellType.BLANK) : xSSFCell;
            }
            throw new IllegalArgumentException("Illegal policy " + missingCellPolicy);
        }
        if (xSSFCell != null && xSSFCell.getCellTypeEnum() == CellType.BLANK) {
            return null;
        }
        return xSSFCell;
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFRow$1, reason: invalid class name */
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
        return (short) (this._cells.size() == 0 ? -1 : this._cells.firstKey().intValue());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getLastCellNum() {
        return (short) (this._cells.size() == 0 ? -1 : this._cells.lastKey().intValue() + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getHeight() {
        return (short) (getHeightInPoints() * 20.0f);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public float getHeightInPoints() {
        if (this._row.isSetHt()) {
            return (float) this._row.getHt();
        }
        return this._sheet.getDefaultRowHeightInPoints();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeight(short s) {
        if (s == -1) {
            if (this._row.isSetHt()) {
                this._row.unsetHt();
            }
            if (this._row.isSetCustomHeight()) {
                this._row.unsetCustomHeight();
                return;
            }
            return;
        }
        this._row.setHt(((double) s) / 20.0d);
        this._row.setCustomHeight(true);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeightInPoints(float f) {
        setHeight((short) (f != -1.0f ? 20.0f * f : -1.0f));
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getPhysicalNumberOfCells() {
        return this._cells.size();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getRowNum() {
        return (int) (this._row.getR() - 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowNum(int i) {
        int lastRowIndex = SpreadsheetVersion.EXCEL2007.getLastRowIndex();
        if (i < 0 || i > lastRowIndex) {
            throw new IllegalArgumentException("Invalid row number (" + i + ") outside allowable range (0.." + lastRowIndex + ")");
        }
        this._row.setR(i + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean getZeroHeight() {
        return this._row.getHidden();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setZeroHeight(boolean z) {
        this._row.setHidden(z);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean isFormatted() {
        return this._row.isSetS();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCellStyle getRowStyle() {
        if (!isFormatted()) {
            return null;
        }
        StylesTable stylesSource = getSheet().getWorkbook().getStylesSource();
        if (stylesSource.getNumCellStyles() > 0) {
            return stylesSource.getStyleAt((int) this._row.getS());
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowStyle(CellStyle cellStyle) {
        if (cellStyle == null) {
            if (this._row.isSetS()) {
                this._row.unsetS();
                this._row.unsetCustomFormat();
                return;
            }
            return;
        }
        StylesTable stylesSource = getSheet().getWorkbook().getStylesSource();
        XSSFCellStyle xSSFCellStyle = (XSSFCellStyle) cellStyle;
        xSSFCellStyle.verifyBelongsToStylesSource(stylesSource);
        this._row.setS(stylesSource.putStyle(xSSFCellStyle));
        this._row.setCustomFormat(true);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void removeCell(Cell cell) {
        if (cell.getRow() != this) {
            throw new IllegalArgumentException("Specified cell does not belong to this row");
        }
        XSSFCell xSSFCell = (XSSFCell) cell;
        if (xSSFCell.isPartOfArrayFormulaGroup()) {
            xSSFCell.notifyArrayFormulaChanging();
        }
        if (cell.getCellTypeEnum() == CellType.FORMULA) {
            this._sheet.getWorkbook().onDeleteFormula(xSSFCell);
        }
        this._cells.remove(new Integer(cell.getColumnIndex()));
    }

    @Internal
    public CTRow getCTRow() {
        return this._row;
    }

    protected void onDocumentWrite() {
        boolean z;
        CTCell[] cArray = this._row.getCArray();
        int i = 0;
        if (cArray.length != this._cells.size()) {
            z = false;
            break;
        }
        Iterator<XSSFCell> it = this._cells.values().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            CTCell cTCell = it.next().getCTCell();
            int i3 = i2 + 1;
            CTCell cTCell2 = cArray[i2];
            String r = cTCell.getR();
            String r2 = cTCell2.getR();
            if (r == null) {
                if (r2 != null) {
                    z = false;
                    break;
                }
                i2 = i3;
            } else {
                if (!r.equals(r2)) {
                    z = false;
                    break;
                }
                i2 = i3;
            }
        }
        if (z) {
            return;
        }
        CTCell[] cTCellArr = new CTCell[this._cells.size()];
        for (XSSFCell xSSFCell : this._cells.values()) {
            CTCell cTCell3 = (CTCell) xSSFCell.getCTCell().copy();
            cTCellArr[i] = cTCell3;
            xSSFCell.setCTCell(cTCell3);
            i++;
        }
        this._row.setCArray(cTCellArr);
    }

    public String toString() {
        return this._row.toString();
    }

    protected void shift(int i) {
        int rowNum = getRowNum() + i;
        CalculationChain calculationChain = this._sheet.getWorkbook().getCalculationChain();
        int sheetId = (int) this._sheet.sheet.getSheetId();
        String str = "Row[rownum=" + getRowNum() + "] contains cell(s) included in a multi-cell array formula. You cannot change part of an array.";
        Iterator<Cell> it = iterator();
        while (it.hasNext()) {
            XSSFCell xSSFCell = (XSSFCell) it.next();
            if (xSSFCell.isPartOfArrayFormulaGroup()) {
                xSSFCell.notifyArrayFormulaChanging(str);
            }
            if (calculationChain != null) {
                calculationChain.removeItem(sheetId, xSSFCell.getReference());
            }
            xSSFCell.getCTCell().setR(new CellReference(rowNum, xSSFCell.getColumnIndex()).formatAsString());
        }
        setRowNum(rowNum);
    }

    public void copyRowFrom(Row row, CellCopyPolicy cellCopyPolicy) {
        if (row == null) {
            Iterator<Cell> it = iterator();
            while (it.hasNext()) {
                ((XSSFCell) it.next()).copyCellFrom(null, cellCopyPolicy);
            }
            if (cellCopyPolicy.isCopyMergedRegions()) {
                int rowNum = getRowNum();
                HashSet hashSet = new HashSet();
                int i = 0;
                for (CellRangeAddress cellRangeAddress : getSheet().getMergedRegions()) {
                    if (rowNum == cellRangeAddress.getFirstRow() && rowNum == cellRangeAddress.getLastRow()) {
                        hashSet.add(Integer.valueOf(i));
                    }
                    i++;
                }
                getSheet().removeMergedRegions(hashSet);
            }
            if (cellCopyPolicy.isCopyRowHeight()) {
                setHeight((short) -1);
                return;
            }
            return;
        }
        Iterator<Cell> it2 = row.iterator();
        while (it2.hasNext()) {
            XSSFCell xSSFCell = (XSSFCell) it2.next();
            createCell(xSSFCell.getColumnIndex(), xSSFCell.getCellTypeEnum()).copyCellFrom(xSSFCell, cellCopyPolicy);
        }
        XSSFRowShifter xSSFRowShifter = new XSSFRowShifter(this._sheet);
        int sheetIndex = this._sheet.getWorkbook().getSheetIndex(this._sheet);
        String sheetName = this._sheet.getWorkbook().getSheetName(sheetIndex);
        int rowNum2 = row.getRowNum();
        int rowNum3 = getRowNum();
        xSSFRowShifter.updateRowFormulas(this, FormulaShifter.createForRowCopy(sheetIndex, sheetName, rowNum2, rowNum2, rowNum3 - rowNum2, SpreadsheetVersion.EXCEL2007));
        if (cellCopyPolicy.isCopyMergedRegions()) {
            for (CellRangeAddress cellRangeAddress2 : row.getSheet().getMergedRegions()) {
                if (rowNum2 == cellRangeAddress2.getFirstRow() && rowNum2 == cellRangeAddress2.getLastRow()) {
                    CellRangeAddress cellRangeAddressCopy = cellRangeAddress2.copy();
                    cellRangeAddressCopy.setFirstRow(rowNum3);
                    cellRangeAddressCopy.setLastRow(rowNum3);
                    getSheet().addMergedRegion(cellRangeAddressCopy);
                }
            }
        }
        if (cellCopyPolicy.isCopyRowHeight()) {
            setHeight(row.getHeight());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getOutlineLevel() {
        return this._row.getOutlineLevel();
    }
}
