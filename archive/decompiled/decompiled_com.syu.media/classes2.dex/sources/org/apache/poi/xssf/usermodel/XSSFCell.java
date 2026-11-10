package org.apache.poi.xssf.usermodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.SharedFormula;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFCell implements Cell {
    private static final String FALSE = "FALSE";
    private static final String FALSE_AS_STRING = "0";
    private static final String TRUE = "TRUE";
    private static final String TRUE_AS_STRING = "1";
    private CTCell _cell;
    private int _cellNum;
    private final XSSFRow _row;
    private SharedStringsTable _sharedStringSource;
    private StylesTable _stylesSource;

    protected XSSFCell(XSSFRow xSSFRow, CTCell cTCell) {
        this._cell = cTCell;
        this._row = xSSFRow;
        if (cTCell.getR() != null) {
            this._cellNum = new CellReference(cTCell.getR()).getCol();
        } else {
            short lastCellNum = xSSFRow.getLastCellNum();
            if (lastCellNum != -1) {
                this._cellNum = xSSFRow.getCell(lastCellNum - 1, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK).getColumnIndex() + 1;
            }
        }
        this._sharedStringSource = xSSFRow.getSheet().getWorkbook().getSharedStringSource();
        this._stylesSource = xSSFRow.getSheet().getWorkbook().getStylesSource();
    }

    @Internal
    public void copyCellFrom(Cell cell, CellCopyPolicy cellCopyPolicy) {
        if (cellCopyPolicy.isCopyCellValue()) {
            if (cell != null) {
                CellType cellTypeEnum = cell.getCellTypeEnum();
                if (cellTypeEnum == CellType.FORMULA && !cellCopyPolicy.isCopyCellFormula()) {
                    cellTypeEnum = cell.getCachedFormulaResultTypeEnum();
                }
                switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()]) {
                    case 1:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            setCellValue(cell.getDateCellValue());
                        } else {
                            setCellValue(cell.getNumericCellValue());
                        }
                        break;
                    case 2:
                        setCellValue(cell.getStringCellValue());
                        break;
                    case 3:
                        setCellFormula(cell.getCellFormula());
                        break;
                    case 4:
                        setBlank();
                        break;
                    case 5:
                        setCellValue(cell.getBooleanCellValue());
                        break;
                    case 6:
                        setCellErrorValue(cell.getErrorCellValue());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid cell type " + cell.getCellTypeEnum());
                }
            } else {
                setBlank();
            }
        }
        if (cellCopyPolicy.isCopyCellStyle()) {
            setCellStyle(cell == null ? null : cell.getCellStyle());
        }
        Hyperlink hyperlink = cell == null ? null : cell.getHyperlink();
        if (cellCopyPolicy.isMergeHyperlink()) {
            if (hyperlink != null) {
                setHyperlink(new XSSFHyperlink(hyperlink));
            }
        } else if (cellCopyPolicy.isCopyHyperlink()) {
            setHyperlink(hyperlink != null ? new XSSFHyperlink(hyperlink) : null);
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFCell$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    protected SharedStringsTable getSharedStringSource() {
        return this._sharedStringSource;
    }

    protected StylesTable getStylesSource() {
        return this._stylesSource;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFSheet getSheet() {
        return getRow().getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFRow getRow() {
        return this._row;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean getBooleanCellValue() {
        CellType cellTypeEnum = getCellTypeEnum();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()];
        if (i == 3) {
            return this._cell.isSetV() && TRUE_AS_STRING.equals(this._cell.getV());
        }
        if (i == 4) {
            return false;
        }
        if (i == 5) {
            return this._cell.isSetV() && TRUE_AS_STRING.equals(this._cell.getV());
        }
        throw typeMismatch(CellType.BOOLEAN, cellTypeEnum, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(boolean z) {
        this._cell.setT(STCellType.B);
        this._cell.setV(z ? TRUE_AS_STRING : FALSE_AS_STRING);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public double getNumericCellValue() {
        CellType cellTypeEnum = getCellTypeEnum();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()];
        if (i != 1 && i != 3) {
            if (i == 4) {
                return 0.0d;
            }
            throw typeMismatch(CellType.NUMERIC, cellTypeEnum, false);
        }
        if (!this._cell.isSetV()) {
            return 0.0d;
        }
        String v = this._cell.getV();
        if (v.isEmpty()) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(v);
        } catch (NumberFormatException unused) {
            throw typeMismatch(CellType.NUMERIC, CellType.STRING, false);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(double d) {
        if (Double.isInfinite(d)) {
            this._cell.setT(STCellType.E);
            this._cell.setV(FormulaError.DIV0.getString());
        } else if (Double.isNaN(d)) {
            this._cell.setT(STCellType.E);
            this._cell.setV(FormulaError.NUM.getString());
        } else {
            this._cell.setT(STCellType.N);
            this._cell.setV(String.valueOf(d));
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getStringCellValue() {
        return getRichStringCellValue().getString();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFRichTextString getRichStringCellValue() {
        XSSFRichTextString xSSFRichTextString;
        CellType cellTypeEnum = getCellTypeEnum();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()];
        if (i != 2) {
            if (i == 3) {
                checkFormulaCachedValueType(CellType.STRING, getBaseCellType(false));
                xSSFRichTextString = new XSSFRichTextString(this._cell.isSetV() ? this._cell.getV() : "");
            } else if (i == 4) {
                xSSFRichTextString = new XSSFRichTextString("");
            } else {
                throw typeMismatch(CellType.STRING, cellTypeEnum, false);
            }
        } else if (this._cell.getT() == STCellType.INLINE_STR) {
            if (this._cell.isSetIs()) {
                xSSFRichTextString = new XSSFRichTextString(this._cell.getIs());
            } else if (this._cell.isSetV()) {
                xSSFRichTextString = new XSSFRichTextString(this._cell.getV());
            } else {
                xSSFRichTextString = new XSSFRichTextString("");
            }
        } else if (this._cell.getT() == STCellType.STR) {
            xSSFRichTextString = new XSSFRichTextString(this._cell.isSetV() ? this._cell.getV() : "");
        } else if (this._cell.isSetV()) {
            xSSFRichTextString = new XSSFRichTextString(this._sharedStringSource.getEntryAt(Integer.parseInt(this._cell.getV())));
        } else {
            xSSFRichTextString = new XSSFRichTextString("");
        }
        xSSFRichTextString.setStylesTableReference(this._stylesSource);
        return xSSFRichTextString;
    }

    private static void checkFormulaCachedValueType(CellType cellType, CellType cellType2) {
        if (cellType2 != cellType) {
            throw typeMismatch(cellType, cellType2, true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(String str) {
        setCellValue(str == null ? null : new XSSFRichTextString(str));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(RichTextString richTextString) {
        if (richTextString == null || richTextString.getString() == null) {
            setCellType(CellType.BLANK);
            return;
        }
        if (richTextString.length() > SpreadsheetVersion.EXCEL2007.getMaxTextLength()) {
            throw new IllegalArgumentException("The maximum length of cell contents (text) is 32,767 characters");
        }
        if (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCellTypeEnum().ordinal()] == 3) {
            this._cell.setV(richTextString.getString());
            this._cell.setT(STCellType.STR);
        } else {
            if (this._cell.getT() == STCellType.INLINE_STR) {
                this._cell.setV(richTextString.getString());
                return;
            }
            this._cell.setT(STCellType.S);
            XSSFRichTextString xSSFRichTextString = (XSSFRichTextString) richTextString;
            xSSFRichTextString.setStylesTableReference(this._stylesSource);
            this._cell.setV(Integer.toString(this._sharedStringSource.addEntry(xSSFRichTextString.getCTRst())));
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getCellFormula() {
        return getCellFormula(null);
    }

    protected String getCellFormula(XSSFEvaluationWorkbook xSSFEvaluationWorkbook) {
        CellType cellTypeEnum = getCellTypeEnum();
        if (cellTypeEnum != CellType.FORMULA) {
            throw typeMismatch(CellType.FORMULA, cellTypeEnum, false);
        }
        CTCellFormula f = this._cell.getF();
        if (isPartOfArrayFormulaGroup() && f == null) {
            return getSheet().getFirstCellInArrayFormula(this).getCellFormula(xSSFEvaluationWorkbook);
        }
        if (f.getT() == STCellFormulaType.SHARED) {
            int si = (int) f.getSi();
            if (xSSFEvaluationWorkbook == null) {
                xSSFEvaluationWorkbook = XSSFEvaluationWorkbook.create(getSheet().getWorkbook());
            }
            return convertSharedFormula(si, xSSFEvaluationWorkbook);
        }
        return f.getStringValue();
    }

    private String convertSharedFormula(int i, XSSFEvaluationWorkbook xSSFEvaluationWorkbook) {
        XSSFSheet sheet = getSheet();
        CTCellFormula sharedFormula = sheet.getSharedFormula(i);
        if (sharedFormula == null) {
            throw new IllegalStateException("Master cell of a shared formula with sid=" + i + " was not found");
        }
        String stringValue = sharedFormula.getStringValue();
        CellRangeAddress cellRangeAddressValueOf = CellRangeAddress.valueOf(sharedFormula.getRef());
        return FormulaRenderer.toFormulaString(xSSFEvaluationWorkbook, new SharedFormula(SpreadsheetVersion.EXCEL2007).convertSharedFormulas(FormulaParser.parse(stringValue, xSSFEvaluationWorkbook, FormulaType.CELL, sheet.getWorkbook().getSheetIndex(sheet), getRowIndex()), getRowIndex() - cellRangeAddressValueOf.getFirstRow(), getColumnIndex() - cellRangeAddressValueOf.getFirstColumn()));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellFormula(String str) {
        if (isPartOfArrayFormulaGroup()) {
            notifyArrayFormulaChanging();
        }
        setFormula(str, FormulaType.CELL);
    }

    void setCellArrayFormula(String str, CellRangeAddress cellRangeAddress) {
        setFormula(str, FormulaType.ARRAY);
        CTCellFormula f = this._cell.getF();
        f.setT(STCellFormulaType.ARRAY);
        f.setRef(cellRangeAddress.formatAsString());
    }

    private void setFormula(String str, FormulaType formulaType) {
        XSSFWorkbook workbook = this._row.getSheet().getWorkbook();
        if (str == null) {
            workbook.onDeleteFormula(this);
            if (this._cell.isSetF()) {
                this._cell.unsetF();
                return;
            }
            return;
        }
        FormulaParser.parse(str, XSSFEvaluationWorkbook.create(workbook), formulaType, workbook.getSheetIndex(getSheet()), getRowIndex());
        CTCellFormula cTCellFormulaNewInstance = CTCellFormula.Factory.newInstance();
        cTCellFormulaNewInstance.setStringValue(str);
        this._cell.setF(cTCellFormulaNewInstance);
        if (this._cell.isSetV()) {
            this._cell.unsetV();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getColumnIndex() {
        return this._cellNum;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getRowIndex() {
        return this._row.getRowNum();
    }

    public String getReference() {
        String r = this._cell.getR();
        return r == null ? getAddress().formatAsString() : r;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellAddress getAddress() {
        return new CellAddress(this);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFCellStyle getCellStyle() {
        if (this._stylesSource.getNumCellStyles() > 0) {
            return this._stylesSource.getStyleAt((int) (this._cell.isSetS() ? this._cell.getS() : 0L));
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellStyle(CellStyle cellStyle) {
        if (cellStyle == null) {
            if (this._cell.isSetS()) {
                this._cell.unsetS();
            }
        } else {
            XSSFCellStyle xSSFCellStyle = (XSSFCellStyle) cellStyle;
            xSSFCellStyle.verifyBelongsToStylesSource(this._stylesSource);
            this._cell.setS(this._stylesSource.putStyle(xSSFCellStyle));
        }
    }

    private boolean isFormulaCell() {
        return (this._cell.isSetF() && this._cell.getF().getT() != STCellFormulaType.DATA_TABLE) || getSheet().isCellInArrayFormulaContext(this);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    @Removal(version = "3.17")
    @Deprecated
    public int getCellType() {
        return getCellTypeEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCellTypeEnum() {
        if (isFormulaCell()) {
            return CellType.FORMULA;
        }
        return getBaseCellType(true);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    @Removal(version = "3.17")
    @Deprecated
    public int getCachedFormulaResultType() {
        return getCachedFormulaResultTypeEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCachedFormulaResultTypeEnum() {
        if (!isFormulaCell()) {
            throw new IllegalStateException("Only formula cells have cached results");
        }
        return getBaseCellType(false);
    }

    private CellType getBaseCellType(boolean z) {
        switch (this._cell.getT().intValue()) {
            case 1:
                return CellType.BOOLEAN;
            case 2:
                if (!this._cell.isSetV() && z) {
                    return CellType.BLANK;
                }
                return CellType.NUMERIC;
            case 3:
                return CellType.ERROR;
            case 4:
            case 5:
            case 6:
                return CellType.STRING;
            default:
                throw new IllegalStateException("Illegal cell type: " + this._cell.getT());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Date getDateCellValue() {
        if (getCellTypeEnum() == CellType.BLANK) {
            return null;
        }
        return DateUtil.getJavaDate(getNumericCellValue(), getSheet().getWorkbook().isDate1904());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(Date date) {
        if (date == null) {
            setCellType(CellType.BLANK);
        } else {
            setCellValue(DateUtil.getExcelDate(date, getSheet().getWorkbook().isDate1904()));
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(Calendar calendar) {
        if (calendar == null) {
            setCellType(CellType.BLANK);
        } else {
            setCellValue(DateUtil.getExcelDate(calendar, getSheet().getWorkbook().isDate1904()));
        }
    }

    public String getErrorCellString() throws IllegalStateException {
        CellType baseCellType = getBaseCellType(true);
        if (baseCellType != CellType.ERROR) {
            throw typeMismatch(CellType.ERROR, baseCellType, false);
        }
        return this._cell.getV();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public byte getErrorCellValue() throws IllegalStateException {
        String errorCellString = getErrorCellString();
        if (errorCellString == null) {
            return (byte) 0;
        }
        try {
            return FormulaError.forString(errorCellString).getCode();
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Unexpected error code", e);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellErrorValue(byte b) {
        setCellErrorValue(FormulaError.forInt(b));
    }

    public void setCellErrorValue(FormulaError formulaError) {
        this._cell.setT(STCellType.E);
        this._cell.setV(formulaError.getString());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setAsActiveCell() {
        getSheet().setActiveCell(getAddress());
    }

    private void setBlank() {
        CTCell cTCellNewInstance = CTCell.Factory.newInstance();
        cTCellNewInstance.setR(this._cell.getR());
        if (this._cell.isSetS()) {
            cTCellNewInstance.setS(this._cell.getS());
        }
        this._cell.set(cTCellNewInstance);
    }

    protected void setCellNum(int i) {
        checkBounds(i);
        this._cellNum = i;
        this._cell.setR(new CellReference(getRowIndex(), getColumnIndex()).formatAsString());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    @Removal(version = "3.17")
    @Deprecated
    public void setCellType(int i) {
        setCellType(CellType.forInt(i));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellType(CellType cellType) {
        CellType cellTypeEnum = getCellTypeEnum();
        if (isPartOfArrayFormulaGroup()) {
            notifyArrayFormulaChanging();
        }
        if (cellTypeEnum == CellType.FORMULA && cellType != CellType.FORMULA) {
            getSheet().getWorkbook().onDeleteFormula(this);
        }
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        String str = FALSE_AS_STRING;
        switch (i) {
            case 1:
                this._cell.setT(STCellType.N);
                break;
            case 2:
                if (cellTypeEnum != CellType.STRING) {
                    XSSFRichTextString xSSFRichTextString = new XSSFRichTextString(convertCellValueToString());
                    xSSFRichTextString.setStylesTableReference(this._stylesSource);
                    this._cell.setV(Integer.toString(this._sharedStringSource.addEntry(xSSFRichTextString.getCTRst())));
                }
                this._cell.setT(STCellType.S);
                break;
            case 3:
                if (!this._cell.isSetF()) {
                    CTCellFormula cTCellFormulaNewInstance = CTCellFormula.Factory.newInstance();
                    cTCellFormulaNewInstance.setStringValue(FALSE_AS_STRING);
                    this._cell.setF(cTCellFormulaNewInstance);
                    if (this._cell.isSetT()) {
                        this._cell.unsetT();
                    }
                }
                break;
            case 4:
                setBlank();
                break;
            case 5:
                if (convertCellValueToBoolean()) {
                    str = TRUE_AS_STRING;
                }
                this._cell.setT(STCellType.B);
                this._cell.setV(str);
                break;
            case 6:
                this._cell.setT(STCellType.E);
                break;
            default:
                throw new IllegalArgumentException("Illegal cell type: " + cellType);
        }
        if (cellType == CellType.FORMULA || !this._cell.isSetF()) {
            return;
        }
        this._cell.unsetF();
    }

    public String toString() {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCellTypeEnum().ordinal()]) {
            case 1:
                if (DateUtil.isCellDateFormatted(this)) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
                    simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
                    return simpleDateFormat.format(getDateCellValue());
                }
                return Double.toString(getNumericCellValue());
            case 2:
                return getRichStringCellValue().toString();
            case 3:
                return getCellFormula();
            case 4:
                return "";
            case 5:
                return getBooleanCellValue() ? TRUE : FALSE;
            case 6:
                return ErrorEval.getText(getErrorCellValue());
            default:
                return "Unknown Cell Type: " + getCellTypeEnum();
        }
    }

    public String getRawValue() {
        return this._cell.getV();
    }

    private static RuntimeException typeMismatch(CellType cellType, CellType cellType2, boolean z) {
        return new IllegalStateException("Cannot get a " + cellType + " value from a " + cellType2 + " " + (z ? "formula " : "") + "cell");
    }

    private static void checkBounds(int i) {
        SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL2007;
        int lastColumnIndex = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();
        if (i < 0 || i > lastColumnIndex) {
            throw new IllegalArgumentException("Invalid column index (" + i + ").  Allowable column range for " + spreadsheetVersion.name() + " is (0.." + lastColumnIndex + ") or ('A'..'" + spreadsheetVersion.getLastColumnName() + "')");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFComment getCellComment() {
        return getSheet().getCellComment(new CellAddress(this));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellComment(Comment comment) {
        if (comment == null) {
            removeCellComment();
        } else {
            comment.setAddress(getRowIndex(), getColumnIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeCellComment() {
        if (getCellComment() != null) {
            CellAddress cellAddress = new CellAddress(getReference());
            XSSFSheet sheet = getSheet();
            sheet.getCommentsTable(false).removeComment(cellAddress);
            sheet.getVMLDrawing(false).removeCommentShape(getRowIndex(), getColumnIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFHyperlink getHyperlink() {
        return getSheet().getHyperlink(this._row.getRowNum(), this._cellNum);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setHyperlink(Hyperlink hyperlink) {
        if (hyperlink == null) {
            removeHyperlink();
            return;
        }
        XSSFHyperlink xSSFHyperlink = (XSSFHyperlink) hyperlink;
        xSSFHyperlink.setCellReference(new CellReference(this._row.getRowNum(), this._cellNum).formatAsString());
        getSheet().addHyperlink(xSSFHyperlink);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeHyperlink() {
        getSheet().removeHyperlink(this._row.getRowNum(), this._cellNum);
    }

    @Internal
    public CTCell getCTCell() {
        return this._cell;
    }

    @Internal
    public void setCTCell(CTCell cTCell) {
        this._cell = cTCell;
    }

    private boolean convertCellValueToBoolean() {
        CellType cellTypeEnum = getCellTypeEnum();
        if (cellTypeEnum == CellType.FORMULA) {
            cellTypeEnum = getBaseCellType(false);
        }
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()];
        if (i == 1) {
            return Double.parseDouble(this._cell.getV()) != 0.0d;
        }
        if (i == 2) {
            return Boolean.parseBoolean(new XSSFRichTextString(this._sharedStringSource.getEntryAt(Integer.parseInt(this._cell.getV()))).getString());
        }
        if (i != 4) {
            if (i == 5) {
                return TRUE_AS_STRING.equals(this._cell.getV());
            }
            if (i != 6) {
                throw new RuntimeException("Unexpected cell type (" + cellTypeEnum + ")");
            }
        }
        return false;
    }

    private String convertCellValueToString() {
        CellType cellTypeEnum = getCellTypeEnum();
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()]) {
            case 1:
            case 6:
                return this._cell.getV();
            case 2:
                return new XSSFRichTextString(this._sharedStringSource.getEntryAt(Integer.parseInt(this._cell.getV()))).getString();
            case 3:
                CellType baseCellType = getBaseCellType(false);
                String v = this._cell.getV();
                int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[baseCellType.ordinal()];
                if (i != 1 && i != 2) {
                    if (i == 5) {
                        if (TRUE_AS_STRING.equals(v)) {
                            return TRUE;
                        }
                        if (FALSE_AS_STRING.equals(v)) {
                            return FALSE;
                        }
                        throw new IllegalStateException("Unexpected boolean cached formula value '" + v + "'.");
                    }
                    if (i != 6) {
                        throw new IllegalStateException("Unexpected formula result type (" + baseCellType + ")");
                    }
                }
                return v;
            case 4:
                return "";
            case 5:
                return TRUE_AS_STRING.equals(this._cell.getV()) ? TRUE : FALSE;
            default:
                throw new IllegalStateException("Unexpected cell type (" + cellTypeEnum + ")");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellRangeAddress getArrayFormulaRange() {
        XSSFCell firstCellInArrayFormula = getSheet().getFirstCellInArrayFormula(this);
        if (firstCellInArrayFormula == null) {
            throw new IllegalStateException("Cell " + getReference() + " is not part of an array formula.");
        }
        return CellRangeAddress.valueOf(firstCellInArrayFormula._cell.getF().getRef());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean isPartOfArrayFormulaGroup() {
        return getSheet().isCellInArrayFormulaContext(this);
    }

    void notifyArrayFormulaChanging(String str) {
        if (isPartOfArrayFormulaGroup()) {
            if (getArrayFormulaRange().getNumberOfCells() > 1) {
                throw new IllegalStateException(str);
            }
            getRow().getSheet().removeArrayFormula(this);
        }
    }

    void notifyArrayFormulaChanging() {
        notifyArrayFormulaChanging("Cell " + new CellReference(this).formatAsString() + " is part of a multi-cell array formula. You cannot change part of an array.");
    }
}
