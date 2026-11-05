package org.apache.poi.hssf.usermodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.BoolErrRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.HyperlinkRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.aggregates.FormulaRecordAggregate;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.ptg.ExpPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFCell implements Cell {
    public static final short ENCODING_COMPRESSED_UNICODE = 0;
    public static final short ENCODING_UNCHANGED = -1;
    public static final short ENCODING_UTF_16 = 1;
    private static final String FILE_FORMAT_NAME = "BIFF8";
    private final HSSFWorkbook _book;
    private CellType _cellType;
    private HSSFComment _comment;
    private CellValueRecordInterface _record;
    private final HSSFSheet _sheet;
    private HSSFRichTextString _stringValue;
    public static final int LAST_COLUMN_NUMBER = SpreadsheetVersion.EXCEL97.getLastColumnIndex();
    private static final String LAST_COLUMN_NAME = SpreadsheetVersion.EXCEL97.getLastColumnName();

    protected HSSFCell(HSSFWorkbook hSSFWorkbook, HSSFSheet hSSFSheet, int i, short s) {
        checkBounds(s);
        this._stringValue = null;
        this._book = hSSFWorkbook;
        this._sheet = hSSFSheet;
        setCellType(CellType.BLANK, false, i, s, hSSFSheet.getSheet().getXFIndexForColAt(s));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFSheet getSheet() {
        return this._sheet;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFRow getRow() {
        return this._sheet.getRow(getRowIndex());
    }

    protected HSSFCell(HSSFWorkbook hSSFWorkbook, HSSFSheet hSSFSheet, int i, short s, CellType cellType) {
        checkBounds(s);
        this._cellType = CellType._NONE;
        this._stringValue = null;
        this._book = hSSFWorkbook;
        this._sheet = hSSFSheet;
        setCellType(cellType, false, i, s, hSSFSheet.getSheet().getXFIndexForColAt(s));
    }

    protected HSSFCell(HSSFWorkbook hSSFWorkbook, HSSFSheet hSSFSheet, CellValueRecordInterface cellValueRecordInterface) {
        this._record = cellValueRecordInterface;
        this._cellType = determineType(cellValueRecordInterface);
        this._stringValue = null;
        this._book = hSSFWorkbook;
        this._sheet = hSSFSheet;
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (i == 1) {
            this._stringValue = new HSSFRichTextString(hSSFWorkbook.getWorkbook(), (LabelSSTRecord) cellValueRecordInterface);
        } else {
            if (i != 3) {
                return;
            }
            this._stringValue = new HSSFRichTextString(((FormulaRecordAggregate) cellValueRecordInterface).getStringValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static CellType determineType(CellValueRecordInterface cellValueRecordInterface) {
        if (cellValueRecordInterface instanceof FormulaRecordAggregate) {
            return CellType.FORMULA;
        }
        Record record = (Record) cellValueRecordInterface;
        short sid = record.getSid();
        if (sid == 253) {
            return CellType.STRING;
        }
        if (sid == 513) {
            return CellType.BLANK;
        }
        if (sid == 515) {
            return CellType.NUMERIC;
        }
        if (sid == 517) {
            return ((BoolErrRecord) record).isBoolean() ? CellType.BOOLEAN : CellType.ERROR;
        }
        throw new RuntimeException("Bad cell value rec (" + cellValueRecordInterface.getClass().getName() + ")");
    }

    protected InternalWorkbook getBoundWorkbook() {
        return this._book.getWorkbook();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getRowIndex() {
        return this._record.getRow();
    }

    protected void updateCellNum(short s) {
        this._record.setColumn(s);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getColumnIndex() {
        return this._record.getColumn() & 65535;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellAddress getAddress() {
        return new CellAddress(this);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellType(int i) {
        setCellType(CellType.forInt(i));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellType(CellType cellType) {
        notifyFormulaChanging();
        if (isPartOfArrayFormulaGroup()) {
            notifyArrayFormulaChanging();
        }
        setCellType(cellType, true, this._record.getRow(), this._record.getColumn(), this._record.getXFIndex());
    }

    private void setCellType(CellType cellType, boolean z, int i, short s, short s2) {
        LabelSSTRecord labelSSTRecord;
        BlankRecord blankRecord;
        FormulaRecordAggregate formulaRecordAggregateCreateFormula;
        NumberRecord numberRecord;
        BoolErrRecord boolErrRecord;
        BoolErrRecord boolErrRecord2;
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()]) {
            case 1:
                if (cellType == this._cellType) {
                    labelSSTRecord = (LabelSSTRecord) this._record;
                } else {
                    labelSSTRecord = new LabelSSTRecord();
                    labelSSTRecord.setColumn(s);
                    labelSSTRecord.setRow(i);
                    labelSSTRecord.setXFIndex(s2);
                }
                if (z) {
                    String strConvertCellValueToString = convertCellValueToString();
                    if (strConvertCellValueToString == null) {
                        setCellType(CellType.BLANK, false, i, s, s2);
                        return;
                    }
                    int iAddSSTString = this._book.getWorkbook().addSSTString(new UnicodeString(strConvertCellValueToString));
                    labelSSTRecord.setSSTIndex(iAddSSTString);
                    UnicodeString sSTString = this._book.getWorkbook().getSSTString(iAddSSTString);
                    HSSFRichTextString hSSFRichTextString = new HSSFRichTextString();
                    this._stringValue = hSSFRichTextString;
                    hSSFRichTextString.setUnicodeString(sSTString);
                }
                this._record = labelSSTRecord;
                break;
            case 2:
                if (cellType != this._cellType) {
                    blankRecord = new BlankRecord();
                } else {
                    blankRecord = (BlankRecord) this._record;
                }
                blankRecord.setColumn(s);
                blankRecord.setXFIndex(s2);
                blankRecord.setRow(i);
                this._record = blankRecord;
                break;
            case 3:
                if (cellType != this._cellType) {
                    formulaRecordAggregateCreateFormula = this._sheet.getSheet().getRowsAggregate().createFormula(i, s);
                } else {
                    FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate) this._record;
                    formulaRecordAggregate.setRow(i);
                    formulaRecordAggregate.setColumn(s);
                    formulaRecordAggregateCreateFormula = formulaRecordAggregate;
                }
                if (z) {
                    formulaRecordAggregateCreateFormula.getFormulaRecord().setValue(getNumericCellValue());
                }
                formulaRecordAggregateCreateFormula.setXFIndex(s2);
                this._record = formulaRecordAggregateCreateFormula;
                break;
            case 4:
                if (cellType != this._cellType) {
                    numberRecord = new NumberRecord();
                } else {
                    numberRecord = (NumberRecord) this._record;
                }
                numberRecord.setColumn(s);
                if (z) {
                    numberRecord.setValue(getNumericCellValue());
                }
                numberRecord.setXFIndex(s2);
                numberRecord.setRow(i);
                this._record = numberRecord;
                break;
            case 5:
                if (cellType != this._cellType) {
                    boolErrRecord = new BoolErrRecord();
                } else {
                    boolErrRecord = (BoolErrRecord) this._record;
                }
                boolErrRecord.setColumn(s);
                if (z) {
                    boolErrRecord.setValue(convertCellValueToBoolean());
                }
                boolErrRecord.setXFIndex(s2);
                boolErrRecord.setRow(i);
                this._record = boolErrRecord;
                break;
            case 6:
                if (cellType != this._cellType) {
                    boolErrRecord2 = new BoolErrRecord();
                } else {
                    boolErrRecord2 = (BoolErrRecord) this._record;
                }
                boolErrRecord2.setColumn(s);
                if (z) {
                    boolErrRecord2.setValue(FormulaError.VALUE.getCode());
                }
                boolErrRecord2.setXFIndex(s2);
                boolErrRecord2.setRow(i);
                this._record = boolErrRecord2;
                break;
            default:
                throw new IllegalStateException("Invalid cell type: " + cellType);
        }
        CellType cellType2 = this._cellType;
        if (cellType != cellType2 && cellType2 != CellType._NONE) {
            this._sheet.getSheet().replaceValueRecord(this._record);
        }
        this._cellType = cellType;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getCellType() {
        return getCellTypeEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCellTypeEnum() {
        return this._cellType;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(double d) {
        if (Double.isInfinite(d)) {
            setCellErrorValue(FormulaError.DIV0.getCode());
            return;
        }
        if (Double.isNaN(d)) {
            setCellErrorValue(FormulaError.NUM.getCode());
            return;
        }
        int row = this._record.getRow();
        short column = this._record.getColumn();
        short xFIndex = this._record.getXFIndex();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (i != 3) {
            if (i != 4) {
                setCellType(CellType.NUMERIC, false, row, column, xFIndex);
            }
            ((NumberRecord) this._record).setValue(d);
            return;
        }
        ((FormulaRecordAggregate) this._record).setCachedDoubleResult(d);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(Date date) {
        setCellValue(HSSFDateUtil.getExcelDate(date, this._book.getWorkbook().isUsing1904DateWindowing()));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(Calendar calendar) {
        setCellValue(HSSFDateUtil.getExcelDate(calendar, this._book.getWorkbook().isUsing1904DateWindowing()));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(String str) {
        setCellValue(str == null ? null : new HSSFRichTextString(str));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(RichTextString richTextString) {
        int row = this._record.getRow();
        short column = this._record.getColumn();
        short xFIndex = this._record.getXFIndex();
        if (richTextString == null) {
            notifyFormulaChanging();
            setCellType(CellType.BLANK, false, row, column, xFIndex);
            return;
        }
        if (richTextString.length() > SpreadsheetVersion.EXCEL97.getMaxTextLength()) {
            throw new IllegalArgumentException("The maximum length of cell contents (text) is 32,767 characters");
        }
        if (this._cellType == CellType.FORMULA) {
            ((FormulaRecordAggregate) this._record).setCachedStringResult(richTextString.getString());
            this._stringValue = new HSSFRichTextString(richTextString.getString());
            return;
        }
        if (this._cellType != CellType.STRING) {
            setCellType(CellType.STRING, false, row, column, xFIndex);
        }
        HSSFRichTextString hSSFRichTextString = (HSSFRichTextString) richTextString;
        int iAddSSTString = this._book.getWorkbook().addSSTString(hSSFRichTextString.getUnicodeString());
        ((LabelSSTRecord) this._record).setSSTIndex(iAddSSTString);
        this._stringValue = hSSFRichTextString;
        hSSFRichTextString.setWorkbookReferences(this._book.getWorkbook(), (LabelSSTRecord) this._record);
        this._stringValue.setUnicodeString(this._book.getWorkbook().getSSTString(iAddSSTString));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellFormula(String str) {
        if (isPartOfArrayFormulaGroup()) {
            notifyArrayFormulaChanging();
        }
        int row = this._record.getRow();
        short column = this._record.getColumn();
        short xFIndex = this._record.getXFIndex();
        if (str == null) {
            notifyFormulaChanging();
            setCellType(CellType.BLANK, false, row, column, xFIndex);
            return;
        }
        Ptg[] ptgArr = HSSFFormulaParser.parse(str, this._book, FormulaType.CELL, this._book.getSheetIndex(this._sheet));
        setCellType(CellType.FORMULA, false, row, column, xFIndex);
        FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate) this._record;
        FormulaRecord formulaRecord = formulaRecordAggregate.getFormulaRecord();
        formulaRecord.setOptions((short) 2);
        formulaRecord.setValue(0.0d);
        if (formulaRecordAggregate.getXFIndex() == 0) {
            formulaRecordAggregate.setXFIndex((short) 15);
        }
        formulaRecordAggregate.setParsedExpression(ptgArr);
    }

    private void notifyFormulaChanging() {
        CellValueRecordInterface cellValueRecordInterface = this._record;
        if (cellValueRecordInterface instanceof FormulaRecordAggregate) {
            ((FormulaRecordAggregate) cellValueRecordInterface).notifyFormulaChanging();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getCellFormula() {
        CellValueRecordInterface cellValueRecordInterface = this._record;
        if (!(cellValueRecordInterface instanceof FormulaRecordAggregate)) {
            throw typeMismatch(CellType.FORMULA, this._cellType, true);
        }
        return HSSFFormulaParser.toFormulaString(this._book, ((FormulaRecordAggregate) cellValueRecordInterface).getFormulaTokens());
    }

    private static RuntimeException typeMismatch(CellType cellType, CellType cellType2, boolean z) {
        return new IllegalStateException("Cannot get a " + cellType + " value from a " + cellType2 + " " + (z ? "formula " : "") + "cell");
    }

    private static void checkFormulaCachedValueType(CellType cellType, FormulaRecord formulaRecord) {
        CellType cellTypeForInt = CellType.forInt(formulaRecord.getCachedResultType());
        if (cellTypeForInt != cellType) {
            throw typeMismatch(cellType, cellTypeForInt, true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public double getNumericCellValue() {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (i == 2) {
            return 0.0d;
        }
        if (i != 3) {
            if (i == 4) {
                return ((NumberRecord) this._record).getValue();
            }
            throw typeMismatch(CellType.NUMERIC, this._cellType, false);
        }
        FormulaRecord formulaRecord = ((FormulaRecordAggregate) this._record).getFormulaRecord();
        checkFormulaCachedValueType(CellType.NUMERIC, formulaRecord);
        return formulaRecord.getValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Date getDateCellValue() {
        if (this._cellType == CellType.BLANK) {
            return null;
        }
        double numericCellValue = getNumericCellValue();
        if (this._book.getWorkbook().isUsing1904DateWindowing()) {
            return HSSFDateUtil.getJavaDate(numericCellValue, true);
        }
        return HSSFDateUtil.getJavaDate(numericCellValue, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getStringCellValue() {
        return getRichStringCellValue().getString();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFRichTextString getRichStringCellValue() {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (i == 1) {
            return this._stringValue;
        }
        if (i == 2) {
            return new HSSFRichTextString("");
        }
        if (i != 3) {
            throw typeMismatch(CellType.STRING, this._cellType, false);
        }
        FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate) this._record;
        checkFormulaCachedValueType(CellType.STRING, formulaRecordAggregate.getFormulaRecord());
        String stringValue = formulaRecordAggregate.getStringValue();
        return new HSSFRichTextString(stringValue != null ? stringValue : "");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(boolean z) {
        int row = this._record.getRow();
        short column = this._record.getColumn();
        short xFIndex = this._record.getXFIndex();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (i != 3) {
            if (i != 5) {
                setCellType(CellType.BOOLEAN, false, row, column, xFIndex);
            }
            ((BoolErrRecord) this._record).setValue(z);
            return;
        }
        ((FormulaRecordAggregate) this._record).setCachedBooleanResult(z);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellErrorValue(byte b) {
        setCellErrorValue(FormulaError.forInt(b));
    }

    public void setCellErrorValue(FormulaError formulaError) {
        int row = this._record.getRow();
        short column = this._record.getColumn();
        short xFIndex = this._record.getXFIndex();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (i != 3) {
            if (i != 6) {
                setCellType(CellType.ERROR, false, row, column, xFIndex);
            }
            ((BoolErrRecord) this._record).setValue(formulaError);
            return;
        }
        ((FormulaRecordAggregate) this._record).setCachedErrorResult(formulaError.getCode());
    }

    private boolean convertCellValueToBoolean() {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()]) {
            case 1:
                return Boolean.valueOf(this._book.getWorkbook().getSSTString(((LabelSSTRecord) this._record).getSSTIndex()).getString()).booleanValue();
            case 2:
            case 6:
                return false;
            case 3:
                FormulaRecord formulaRecord = ((FormulaRecordAggregate) this._record).getFormulaRecord();
                checkFormulaCachedValueType(CellType.BOOLEAN, formulaRecord);
                return formulaRecord.getCachedBooleanValue();
            case 4:
                return ((NumberRecord) this._record).getValue() != 0.0d;
            case 5:
                return ((BoolErrRecord) this._record).getBooleanValue();
            default:
                throw new RuntimeException("Unexpected cell type (" + this._cellType + ")");
        }
    }

    private String convertCellValueToString() {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()]) {
            case 1:
                return this._book.getWorkbook().getSSTString(((LabelSSTRecord) this._record).getSSTIndex()).getString();
            case 2:
                return "";
            case 3:
                FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate) this._record;
                FormulaRecord formulaRecord = formulaRecordAggregate.getFormulaRecord();
                int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.forInt(formulaRecord.getCachedResultType()).ordinal()];
                if (i == 1) {
                    return formulaRecordAggregate.getStringValue();
                }
                if (i == 4) {
                    return NumberToTextConverter.toText(formulaRecord.getValue());
                }
                if (i == 5) {
                    return formulaRecord.getCachedBooleanValue() ? "TRUE" : "FALSE";
                }
                if (i == 6) {
                    return FormulaError.forInt(formulaRecord.getCachedErrorValue()).getString();
                }
                throw new IllegalStateException("Unexpected formula result type (" + this._cellType + ")");
            case 4:
                return NumberToTextConverter.toText(((NumberRecord) this._record).getValue());
            case 5:
                return ((BoolErrRecord) this._record).getBooleanValue() ? "TRUE" : "FALSE";
            case 6:
                return FormulaError.forInt(((BoolErrRecord) this._record).getErrorValue()).getString();
            default:
                throw new IllegalStateException("Unexpected cell type (" + this._cellType + ")");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean getBooleanCellValue() {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (i == 2) {
            return false;
        }
        if (i != 3) {
            if (i == 5) {
                return ((BoolErrRecord) this._record).getBooleanValue();
            }
            throw typeMismatch(CellType.BOOLEAN, this._cellType, false);
        }
        FormulaRecord formulaRecord = ((FormulaRecordAggregate) this._record).getFormulaRecord();
        checkFormulaCachedValueType(CellType.BOOLEAN, formulaRecord);
        return formulaRecord.getCachedBooleanValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public byte getErrorCellValue() {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (i != 3) {
            if (i == 6) {
                return ((BoolErrRecord) this._record).getErrorValue();
            }
            throw typeMismatch(CellType.ERROR, this._cellType, false);
        }
        FormulaRecord formulaRecord = ((FormulaRecordAggregate) this._record).getFormulaRecord();
        checkFormulaCachedValueType(CellType.ERROR, formulaRecord);
        return (byte) formulaRecord.getCachedErrorValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellStyle(CellStyle cellStyle) {
        setCellStyle((HSSFCellStyle) cellStyle);
    }

    public void setCellStyle(HSSFCellStyle hSSFCellStyle) {
        short index;
        if (hSSFCellStyle == null) {
            this._record.setXFIndex((short) 15);
            return;
        }
        hSSFCellStyle.verifyBelongsToWorkbook(this._book);
        if (hSSFCellStyle.getUserStyleName() != null) {
            index = applyUserCellStyle(hSSFCellStyle);
        } else {
            index = hSSFCellStyle.getIndex();
        }
        this._record.setXFIndex(index);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFCellStyle getCellStyle() {
        short xFIndex = this._record.getXFIndex();
        return new HSSFCellStyle(xFIndex, this._book.getWorkbook().getExFormatAt(xFIndex), this._book);
    }

    protected CellValueRecordInterface getCellValueRecord() {
        return this._record;
    }

    private static void checkBounds(int i) {
        if (i < 0 || i > LAST_COLUMN_NUMBER) {
            throw new IllegalArgumentException("Invalid column index (" + i + ").  Allowable column range for BIFF8 is (0.." + LAST_COLUMN_NUMBER + ") or ('A'..'" + LAST_COLUMN_NAME + "')");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setAsActiveCell() {
        int row = this._record.getRow();
        short column = this._record.getColumn();
        this._sheet.getSheet().setActiveCellRow(row);
        this._sheet.getSheet().setActiveCellCol(column);
    }

    public String toString() {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCellTypeEnum().ordinal()]) {
            case 1:
                return getStringCellValue();
            case 2:
                return "";
            case 3:
                return getCellFormula();
            case 4:
                if (HSSFDateUtil.isCellDateFormatted(this)) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
                    simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
                    return simpleDateFormat.format(getDateCellValue());
                }
                return String.valueOf(getNumericCellValue());
            case 5:
                return getBooleanCellValue() ? "TRUE" : "FALSE";
            case 6:
                return ErrorEval.getText(((BoolErrRecord) this._record).getErrorValue());
            default:
                return "Unknown Cell Type: " + getCellTypeEnum();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellComment(Comment comment) {
        if (comment == null) {
            removeCellComment();
            return;
        }
        comment.setRow(this._record.getRow());
        comment.setColumn(this._record.getColumn());
        this._comment = (HSSFComment) comment;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFComment getCellComment() {
        if (this._comment == null) {
            this._comment = this._sheet.findCellComment(this._record.getRow(), this._record.getColumn());
        }
        return this._comment;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeCellComment() {
        HSSFComment hSSFCommentFindCellComment = this._sheet.findCellComment(this._record.getRow(), this._record.getColumn());
        this._comment = null;
        if (hSSFCommentFindCellComment == null) {
            return;
        }
        this._sheet.getDrawingPatriarch().removeShape(hSSFCommentFindCellComment);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFHyperlink getHyperlink() {
        return this._sheet.getHyperlink(this._record.getRow(), (int) this._record.getColumn());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setHyperlink(Hyperlink hyperlink) {
        if (hyperlink == null) {
            removeHyperlink();
            return;
        }
        HSSFHyperlink hSSFHyperlink = (HSSFHyperlink) hyperlink;
        hSSFHyperlink.setFirstRow(this._record.getRow());
        hSSFHyperlink.setLastRow(this._record.getRow());
        hSSFHyperlink.setFirstColumn(this._record.getColumn());
        hSSFHyperlink.setLastColumn(this._record.getColumn());
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[hSSFHyperlink.getTypeEnum().ordinal()];
        if (i == 1 || i == 2) {
            hSSFHyperlink.setLabel("url");
        } else if (i == 3) {
            hSSFHyperlink.setLabel("file");
        } else if (i == 4) {
            hSSFHyperlink.setLabel("place");
        }
        List<RecordBase> records = this._sheet.getSheet().getRecords();
        records.add(records.size() - 1, hSSFHyperlink.record);
    }

    /* JADX INFO: renamed from: org.apache.poi.hssf.usermodel.HSSFCell$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[HyperlinkType.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType = iArr;
            try {
                iArr[HyperlinkType.EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr2;
            try {
                iArr2[CellType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeHyperlink() {
        Iterator<RecordBase> it = this._sheet.getSheet().getRecords().iterator();
        while (it.hasNext()) {
            RecordBase next = it.next();
            if (next instanceof HyperlinkRecord) {
                HyperlinkRecord hyperlinkRecord = (HyperlinkRecord) next;
                if (hyperlinkRecord.getFirstColumn() == this._record.getColumn() && hyperlinkRecord.getFirstRow() == this._record.getRow()) {
                    it.remove();
                    return;
                }
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getCachedFormulaResultType() {
        return getCachedFormulaResultTypeEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCachedFormulaResultTypeEnum() {
        if (this._cellType != CellType.FORMULA) {
            throw new IllegalStateException("Only formula cells have cached results");
        }
        return CellType.forInt(((FormulaRecordAggregate) this._record).getFormulaRecord().getCachedResultType());
    }

    void setCellArrayFormula(CellRangeAddress cellRangeAddress) {
        setCellType(CellType.FORMULA, false, this._record.getRow(), this._record.getColumn(), this._record.getXFIndex());
        ((FormulaRecordAggregate) this._record).setParsedExpression(new Ptg[]{new ExpPtg(cellRangeAddress.getFirstRow(), cellRangeAddress.getFirstColumn())});
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellRangeAddress getArrayFormulaRange() {
        if (this._cellType != CellType.FORMULA) {
            throw new IllegalStateException("Cell " + new CellReference(this).formatAsString() + " is not part of an array formula.");
        }
        return ((FormulaRecordAggregate) this._record).getArrayFormulaRange();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean isPartOfArrayFormulaGroup() {
        if (this._cellType != CellType.FORMULA) {
            return false;
        }
        return ((FormulaRecordAggregate) this._record).isPartOfArrayFormula();
    }

    void notifyArrayFormulaChanging(String str) {
        if (getArrayFormulaRange().getNumberOfCells() > 1) {
            throw new IllegalStateException(str);
        }
        getRow().getSheet().removeArrayFormula(this);
    }

    void notifyArrayFormulaChanging() {
        notifyArrayFormulaChanging("Cell " + new CellReference(this).formatAsString() + " is part of a multi-cell array formula. You cannot change part of an array.");
    }

    private short applyUserCellStyle(HSSFCellStyle hSSFCellStyle) {
        if (hSSFCellStyle.getUserStyleName() == null) {
            throw new IllegalArgumentException("Expected user-defined style");
        }
        InternalWorkbook workbook = this._book.getWorkbook();
        int numExFormats = workbook.getNumExFormats();
        short s = 0;
        while (true) {
            if (s >= numExFormats) {
                s = -1;
                break;
            }
            ExtendedFormatRecord exFormatAt = workbook.getExFormatAt(s);
            if (exFormatAt.getXFType() == 0 && exFormatAt.getParentIndex() == hSSFCellStyle.getIndex()) {
                break;
            }
            s = (short) (s + 1);
        }
        if (s != -1) {
            return s;
        }
        ExtendedFormatRecord extendedFormatRecordCreateCellXF = workbook.createCellXF();
        extendedFormatRecordCreateCellXF.cloneStyleFrom(workbook.getExFormatAt(hSSFCellStyle.getIndex()));
        extendedFormatRecordCreateCellXF.setIndentionOptions((short) 0);
        extendedFormatRecordCreateCellXF.setXFType((short) 0);
        extendedFormatRecordCreateCellXF.setParentIndex(hSSFCellStyle.getIndex());
        return (short) numExFormats;
    }
}
