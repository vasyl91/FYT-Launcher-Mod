package org.apache.poi.xssf.streaming;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.Cell;
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
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SXSSFCell implements Cell {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) SXSSFCell.class);
    private Property _firstProperty;
    private final SXSSFRow _row;
    private CellStyle _style;
    private Value _value;

    interface Value {
        CellType getType();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    @NotImplemented
    public CellRangeAddress getArrayFormulaRange() {
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    @NotImplemented
    public boolean isPartOfArrayFormulaGroup() {
        return false;
    }

    public SXSSFCell(SXSSFRow sXSSFRow, CellType cellType) {
        this._row = sXSSFRow;
        setType(cellType);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getColumnIndex() {
        return this._row.getCellIndex(this);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getRowIndex() {
        return this._row.getRowNum();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellAddress getAddress() {
        return new CellAddress(this);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public SXSSFSheet getSheet() {
        return this._row.getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Row getRow() {
        return this._row;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellType(int i) {
        ensureType(CellType.forInt(i));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellType(CellType cellType) {
        ensureType(cellType);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getCellType() {
        return getCellTypeEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCellTypeEnum() {
        return this._value.getType();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getCachedFormulaResultType() {
        return getCachedFormulaResultTypeEnum().getCode();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCachedFormulaResultTypeEnum() {
        if (this._value.getType() != CellType.FORMULA) {
            throw new IllegalStateException("Only formula cells have cached results");
        }
        return ((FormulaValue) this._value).getFormulaType();
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
        ensureTypeOrFormulaType(CellType.NUMERIC);
        if (this._value.getType() == CellType.FORMULA) {
            ((NumericFormulaValue) this._value).setPreEvaluatedValue(d);
        } else {
            ((NumericValue) this._value).setValue(d);
        }
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

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(RichTextString richTextString) {
        XSSFRichTextString xSSFRichTextString = (XSSFRichTextString) richTextString;
        if (xSSFRichTextString != null && xSSFRichTextString.getString() != null) {
            ensureRichTextStringType();
            if (xSSFRichTextString.length() > SpreadsheetVersion.EXCEL2007.getMaxTextLength()) {
                throw new IllegalArgumentException("The maximum length of cell contents (text) is 32,767 characters");
            }
            if (xSSFRichTextString.hasFormatting()) {
                logger.log(5, "SXSSF doesn't support Shared Strings, rich text formatting information has be lost");
            }
            ((RichTextValue) this._value).setValue(xSSFRichTextString);
            return;
        }
        setCellType(CellType.BLANK);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(String str) {
        if (str != null) {
            ensureTypeOrFormulaType(CellType.STRING);
            if (str.length() > SpreadsheetVersion.EXCEL2007.getMaxTextLength()) {
                throw new IllegalArgumentException("The maximum length of cell contents (text) is 32,767 characters");
            }
            if (this._value.getType() == CellType.FORMULA) {
                Value value = this._value;
                if (value instanceof NumericFormulaValue) {
                    ((NumericFormulaValue) value).setPreEvaluatedValue(Double.parseDouble(str));
                    return;
                } else {
                    ((StringFormulaValue) value).setPreEvaluatedValue(str);
                    return;
                }
            }
            ((PlainStringValue) this._value).setValue(str);
            return;
        }
        setCellType(CellType.BLANK);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellFormula(String str) throws FormulaParseException {
        if (str == null) {
            setType(CellType.BLANK);
        } else {
            ensureFormulaType(computeTypeFromFormula(str));
            ((FormulaValue) this._value).setValue(str);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getCellFormula() {
        if (this._value.getType() != CellType.FORMULA) {
            throw typeMismatch(CellType.FORMULA, this._value.getType(), false);
        }
        return ((FormulaValue) this._value).getValue();
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.streaming.SXSSFCell$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.BLANK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 4;
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

    @Override // org.apache.poi.ss.usermodel.Cell
    public double getNumericCellValue() {
        CellType cellTypeEnum = getCellTypeEnum();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()];
        if (i == 1) {
            return 0.0d;
        }
        if (i != 2) {
            if (i == 3) {
                return ((NumericValue) this._value).getValue();
            }
            throw typeMismatch(CellType.NUMERIC, cellTypeEnum, false);
        }
        if (((FormulaValue) this._value).getFormulaType() != CellType.NUMERIC) {
            throw typeMismatch(CellType.NUMERIC, CellType.FORMULA, false);
        }
        return ((NumericFormulaValue) this._value).getPreEvaluatedValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Date getDateCellValue() {
        if (getCellTypeEnum() == CellType.BLANK) {
            return null;
        }
        return DateUtil.getJavaDate(getNumericCellValue(), getSheet().getWorkbook().isDate1904());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public RichTextString getRichStringCellValue() {
        CellType cellTypeEnum = getCellTypeEnum();
        if (getCellTypeEnum() != CellType.STRING) {
            throw typeMismatch(CellType.STRING, cellTypeEnum, false);
        }
        if (((StringValue) this._value).isRichText()) {
            return ((RichTextValue) this._value).getValue();
        }
        return getSheet().getWorkbook().getCreationHelper().createRichTextString(getStringCellValue());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getStringCellValue() {
        CellType cellTypeEnum = getCellTypeEnum();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()];
        if (i == 1) {
            return "";
        }
        if (i == 2) {
            if (((FormulaValue) this._value).getFormulaType() != CellType.STRING) {
                throw typeMismatch(CellType.STRING, CellType.FORMULA, false);
            }
            return ((StringFormulaValue) this._value).getPreEvaluatedValue();
        }
        if (i == 4) {
            if (((StringValue) this._value).isRichText()) {
                return ((RichTextValue) this._value).getValue().getString();
            }
            return ((PlainStringValue) this._value).getValue();
        }
        throw typeMismatch(CellType.STRING, cellTypeEnum, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(boolean z) {
        ensureTypeOrFormulaType(CellType.BOOLEAN);
        if (this._value.getType() == CellType.FORMULA) {
            ((BooleanFormulaValue) this._value).setPreEvaluatedValue(z);
        } else {
            ((BooleanValue) this._value).setValue(z);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellErrorValue(byte b) {
        ensureType(CellType.ERROR);
        if (this._value.getType() == CellType.FORMULA) {
            ((ErrorFormulaValue) this._value).setPreEvaluatedValue(b);
        } else {
            ((ErrorValue) this._value).setValue(b);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean getBooleanCellValue() {
        CellType cellTypeEnum = getCellTypeEnum();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            if (i == 5) {
                return ((BooleanValue) this._value).getValue();
            }
            throw typeMismatch(CellType.BOOLEAN, cellTypeEnum, false);
        }
        if (((FormulaValue) this._value).getFormulaType() != CellType.BOOLEAN) {
            throw typeMismatch(CellType.BOOLEAN, CellType.FORMULA, false);
        }
        return ((BooleanFormulaValue) this._value).getPreEvaluatedValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public byte getErrorCellValue() {
        CellType cellTypeEnum = getCellTypeEnum();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()];
        if (i == 1) {
            return (byte) 0;
        }
        if (i != 2) {
            if (i == 6) {
                return ((ErrorValue) this._value).getValue();
            }
            throw typeMismatch(CellType.ERROR, cellTypeEnum, false);
        }
        if (((FormulaValue) this._value).getFormulaType() != CellType.ERROR) {
            throw typeMismatch(CellType.ERROR, CellType.FORMULA, false);
        }
        return ((ErrorFormulaValue) this._value).getPreEvaluatedValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellStyle(CellStyle cellStyle) {
        this._style = cellStyle;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellStyle getCellStyle() {
        CellStyle cellStyle = this._style;
        return cellStyle == null ? ((SXSSFWorkbook) getRow().getSheet().getWorkbook()).getCellStyleAt(0) : cellStyle;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setAsActiveCell() {
        getSheet().setActiveCell(getAddress());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellComment(Comment comment) {
        setProperty(1, comment);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Comment getCellComment() {
        return (Comment) getPropertyValue(1);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeCellComment() {
        removeProperty(1);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Hyperlink getHyperlink() {
        return (Hyperlink) getPropertyValue(2);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setHyperlink(Hyperlink hyperlink) {
        if (hyperlink == null) {
            removeHyperlink();
            return;
        }
        setProperty(2, hyperlink);
        XSSFHyperlink xSSFHyperlink = (XSSFHyperlink) hyperlink;
        xSSFHyperlink.setCellReference(new CellReference(getRowIndex(), getColumnIndex()));
        getSheet()._sh.addHyperlink(xSSFHyperlink);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeHyperlink() {
        removeProperty(2);
        getSheet()._sh.removeHyperlink(getRowIndex(), getColumnIndex());
    }

    public String toString() {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCellTypeEnum().ordinal()]) {
            case 1:
                return "";
            case 2:
                return getCellFormula();
            case 3:
                if (DateUtil.isCellDateFormatted(this)) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
                    simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
                    return simpleDateFormat.format(getDateCellValue());
                }
                return getNumericCellValue() + "";
            case 4:
                return getRichStringCellValue().toString();
            case 5:
                return getBooleanCellValue() ? "TRUE" : "FALSE";
            case 6:
                return ErrorEval.getText(getErrorCellValue());
            default:
                return "Unknown Cell Type: " + getCellTypeEnum();
        }
    }

    void removeProperty(int i) {
        Property property = this._firstProperty;
        Property property2 = null;
        while (property != null && property.getType() != i) {
            property2 = property;
            property = property._next;
        }
        if (property != null) {
            if (property2 != null) {
                property2._next = property._next;
            } else {
                this._firstProperty = property._next;
            }
        }
    }

    void setProperty(int i, Object obj) {
        Property commentProperty;
        Property property = this._firstProperty;
        Property property2 = null;
        while (property != null && property.getType() != i) {
            property2 = property;
            property = property._next;
        }
        if (property != null) {
            property.setValue(obj);
            return;
        }
        if (i == 1) {
            commentProperty = new CommentProperty(obj);
        } else if (i == 2) {
            commentProperty = new HyperlinkProperty(obj);
        } else {
            throw new IllegalArgumentException("Invalid type: " + i);
        }
        if (property2 != null) {
            property2._next = commentProperty;
        } else {
            this._firstProperty = commentProperty;
        }
    }

    Object getPropertyValue(int i) {
        return getPropertyValue(i, null);
    }

    Object getPropertyValue(int i, String str) {
        Property property = this._firstProperty;
        while (property != null && property.getType() != i) {
            property = property._next;
        }
        return property == null ? str : property.getValue();
    }

    void ensurePlainStringType() {
        if (this._value.getType() != CellType.STRING || ((StringValue) this._value).isRichText()) {
            this._value = new PlainStringValue();
        }
    }

    void ensureRichTextStringType() {
        if (this._value.getType() == CellType.STRING && ((StringValue) this._value).isRichText()) {
            return;
        }
        this._value = new RichTextValue();
    }

    void ensureType(CellType cellType) {
        if (this._value.getType() != cellType) {
            setType(cellType);
        }
    }

    void ensureFormulaType(CellType cellType) {
        if (this._value.getType() == CellType.FORMULA && ((FormulaValue) this._value).getFormulaType() == cellType) {
            return;
        }
        setFormulaType(cellType);
    }

    void ensureTypeOrFormulaType(CellType cellType) {
        if (this._value.getType() == cellType) {
            if (cellType == CellType.STRING && ((StringValue) this._value).isRichText()) {
                setType(CellType.STRING);
                return;
            }
            return;
        }
        if (this._value.getType() == CellType.FORMULA) {
            if (((FormulaValue) this._value).getFormulaType() == cellType) {
                return;
            }
            setFormulaType(cellType);
            return;
        }
        setType(cellType);
    }

    void setType(CellType cellType) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()]) {
            case 1:
                this._value = new BlankValue();
                return;
            case 2:
                this._value = new NumericFormulaValue();
                return;
            case 3:
                this._value = new NumericValue();
                return;
            case 4:
                PlainStringValue plainStringValue = new PlainStringValue();
                if (this._value != null) {
                    plainStringValue.setValue(convertCellValueToString());
                }
                this._value = plainStringValue;
                return;
            case 5:
                BooleanValue booleanValue = new BooleanValue();
                if (this._value != null) {
                    booleanValue.setValue(convertCellValueToBoolean());
                }
                this._value = booleanValue;
                return;
            case 6:
                this._value = new ErrorValue();
                return;
            default:
                throw new IllegalArgumentException("Illegal type " + cellType);
        }
    }

    void setFormulaType(CellType cellType) {
        Value value = this._value;
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i == 3) {
            this._value = new NumericFormulaValue();
        } else if (i == 4) {
            this._value = new StringFormulaValue();
        } else if (i == 5) {
            this._value = new BooleanFormulaValue();
        } else if (i == 6) {
            this._value = new ErrorFormulaValue();
        } else {
            throw new IllegalArgumentException("Illegal type " + cellType);
        }
        if (value instanceof FormulaValue) {
            ((FormulaValue) this._value)._value = ((FormulaValue) value)._value;
        }
    }

    @NotImplemented
    CellType computeTypeFromFormula(String str) {
        return CellType.NUMERIC;
    }

    private static RuntimeException typeMismatch(CellType cellType, CellType cellType2, boolean z) {
        return new IllegalStateException("Cannot get a " + cellType + " value from a " + cellType2 + " " + (z ? "formula " : "") + "cell");
    }

    private boolean convertCellValueToBoolean() {
        CellType cellTypeEnum = getCellTypeEnum();
        if (cellTypeEnum == CellType.FORMULA) {
            cellTypeEnum = getCachedFormulaResultTypeEnum();
        }
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 3) {
            return getNumericCellValue() != 0.0d;
        }
        if (i == 4) {
            return Boolean.parseBoolean(getStringCellValue());
        }
        if (i == 5) {
            return getBooleanCellValue();
        }
        if (i == 6) {
            return false;
        }
        throw new RuntimeException("Unexpected cell type (" + cellTypeEnum + ")");
    }

    private String convertCellValueToString() {
        return convertCellValueToString(getCellTypeEnum());
    }

    private String convertCellValueToString(CellType cellType) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()]) {
            case 2:
                Value value = this._value;
                if (value != null) {
                    FormulaValue formulaValue = (FormulaValue) value;
                    if (formulaValue.getFormulaType() != CellType.FORMULA) {
                        return convertCellValueToString(formulaValue.getFormulaType());
                    }
                }
            case 1:
                return "";
            case 3:
                return Double.toString(getNumericCellValue());
            case 4:
                return getStringCellValue();
            case 5:
                return getBooleanCellValue() ? "TRUE" : "FALSE";
            case 6:
                return FormulaError.forInt(getErrorCellValue()).getString();
            default:
                throw new IllegalStateException("Unexpected cell type (" + cellType + ")");
        }
    }

    static abstract class Property {
        static final int COMMENT = 1;
        static final int HYPERLINK = 2;
        Property _next;
        Object _value;

        abstract int getType();

        public Property(Object obj) {
            this._value = obj;
        }

        void setValue(Object obj) {
            this._value = obj;
        }

        Object getValue() {
            return this._value;
        }
    }

    static class CommentProperty extends Property {
        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Property
        public int getType() {
            return 1;
        }

        public CommentProperty(Object obj) {
            super(obj);
        }
    }

    static class HyperlinkProperty extends Property {
        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Property
        public int getType() {
            return 2;
        }

        public HyperlinkProperty(Object obj) {
            super(obj);
        }
    }

    static class NumericValue implements Value {
        double _value;

        NumericValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.NUMERIC;
        }

        void setValue(double d) {
            this._value = d;
        }

        double getValue() {
            return this._value;
        }
    }

    static abstract class StringValue implements Value {
        abstract boolean isRichText();

        StringValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.STRING;
        }
    }

    static class PlainStringValue extends StringValue {
        String _value;

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.StringValue
        boolean isRichText() {
            return false;
        }

        PlainStringValue() {
        }

        void setValue(String str) {
            this._value = str;
        }

        String getValue() {
            return this._value;
        }
    }

    static class RichTextValue extends StringValue {
        RichTextString _value;

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.StringValue
        boolean isRichText() {
            return true;
        }

        RichTextValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.StringValue, org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.STRING;
        }

        void setValue(RichTextString richTextString) {
            this._value = richTextString;
        }

        RichTextString getValue() {
            return this._value;
        }
    }

    static abstract class FormulaValue implements Value {
        String _value;

        abstract CellType getFormulaType();

        FormulaValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.FORMULA;
        }

        void setValue(String str) {
            this._value = str;
        }

        String getValue() {
            return this._value;
        }
    }

    static class NumericFormulaValue extends FormulaValue {
        double _preEvaluatedValue;

        NumericFormulaValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        CellType getFormulaType() {
            return CellType.NUMERIC;
        }

        void setPreEvaluatedValue(double d) {
            this._preEvaluatedValue = d;
        }

        double getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }
    }

    static class StringFormulaValue extends FormulaValue {
        String _preEvaluatedValue;

        StringFormulaValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        CellType getFormulaType() {
            return CellType.STRING;
        }

        void setPreEvaluatedValue(String str) {
            this._preEvaluatedValue = str;
        }

        String getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }
    }

    static class BooleanFormulaValue extends FormulaValue {
        boolean _preEvaluatedValue;

        BooleanFormulaValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        CellType getFormulaType() {
            return CellType.BOOLEAN;
        }

        void setPreEvaluatedValue(boolean z) {
            this._preEvaluatedValue = z;
        }

        boolean getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }
    }

    static class ErrorFormulaValue extends FormulaValue {
        byte _preEvaluatedValue;

        ErrorFormulaValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        CellType getFormulaType() {
            return CellType.ERROR;
        }

        void setPreEvaluatedValue(byte b) {
            this._preEvaluatedValue = b;
        }

        byte getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }
    }

    static class BlankValue implements Value {
        BlankValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.BLANK;
        }
    }

    static class BooleanValue implements Value {
        boolean _value;

        BooleanValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.BOOLEAN;
        }

        void setValue(boolean z) {
            this._value = z;
        }

        boolean getValue() {
            return this._value;
        }
    }

    static class ErrorValue implements Value {
        byte _value;

        ErrorValue() {
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.ERROR;
        }

        void setValue(byte b) {
            this._value = b;
        }

        byte getValue() {
            return this._value;
        }
    }
}
