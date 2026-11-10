package org.apache.poi.ss.usermodel;

import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Cell {

    @Removal(version = "4.0")
    @Deprecated
    public static final int CELL_TYPE_BLANK = 3;

    @Removal(version = "4.0")
    @Deprecated
    public static final int CELL_TYPE_BOOLEAN = 4;

    @Removal(version = "4.0")
    @Deprecated
    public static final int CELL_TYPE_ERROR = 5;

    @Removal(version = "4.0")
    @Deprecated
    public static final int CELL_TYPE_FORMULA = 2;

    @Removal(version = "4.0")
    @Deprecated
    public static final int CELL_TYPE_NUMERIC = 0;

    @Removal(version = "4.0")
    @Deprecated
    public static final int CELL_TYPE_STRING = 1;

    CellAddress getAddress();

    CellRangeAddress getArrayFormulaRange();

    boolean getBooleanCellValue();

    @Deprecated
    int getCachedFormulaResultType();

    CellType getCachedFormulaResultTypeEnum();

    Comment getCellComment();

    String getCellFormula();

    CellStyle getCellStyle();

    @Deprecated
    int getCellType();

    @Removal(version = "4.2")
    CellType getCellTypeEnum();

    int getColumnIndex();

    Date getDateCellValue();

    byte getErrorCellValue();

    Hyperlink getHyperlink();

    double getNumericCellValue();

    RichTextString getRichStringCellValue();

    Row getRow();

    int getRowIndex();

    Sheet getSheet();

    String getStringCellValue();

    boolean isPartOfArrayFormulaGroup();

    void removeCellComment();

    void removeHyperlink();

    void setAsActiveCell();

    void setCellComment(Comment comment);

    void setCellErrorValue(byte b);

    void setCellFormula(String str) throws FormulaParseException;

    void setCellStyle(CellStyle cellStyle);

    @Removal(version = "4.0")
    @Deprecated
    void setCellType(int i);

    void setCellType(CellType cellType);

    void setCellValue(double d);

    void setCellValue(String str);

    void setCellValue(Calendar calendar);

    void setCellValue(Date date);

    void setCellValue(RichTextString richTextString);

    void setCellValue(boolean z);

    void setHyperlink(Hyperlink hyperlink);
}
