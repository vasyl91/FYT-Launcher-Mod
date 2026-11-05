package org.apache.poi.ss.usermodel;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PaneInformation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Sheet extends Iterable<Row> {
    public static final short BottomMargin = 3;
    public static final short FooterMargin = 5;
    public static final short HeaderMargin = 4;
    public static final short LeftMargin = 0;
    public static final byte PANE_LOWER_LEFT = 2;
    public static final byte PANE_LOWER_RIGHT = 0;
    public static final byte PANE_UPPER_LEFT = 3;
    public static final byte PANE_UPPER_RIGHT = 1;
    public static final short RightMargin = 1;
    public static final short TopMargin = 2;

    int addMergedRegion(CellRangeAddress cellRangeAddress);

    int addMergedRegionUnsafe(CellRangeAddress cellRangeAddress);

    void addValidationData(DataValidation dataValidation);

    void autoSizeColumn(int i);

    void autoSizeColumn(int i, boolean z);

    Drawing<?> createDrawingPatriarch();

    void createFreezePane(int i, int i2);

    void createFreezePane(int i, int i2, int i3, int i4);

    Row createRow(int i);

    void createSplitPane(int i, int i2, int i3, int i4, int i5);

    CellAddress getActiveCell();

    boolean getAutobreaks();

    Comment getCellComment(CellAddress cellAddress);

    Map<CellAddress, ? extends Comment> getCellComments();

    int[] getColumnBreaks();

    int getColumnOutlineLevel(int i);

    CellStyle getColumnStyle(int i);

    int getColumnWidth(int i);

    float getColumnWidthInPixels(int i);

    DataValidationHelper getDataValidationHelper();

    List<? extends DataValidation> getDataValidations();

    int getDefaultColumnWidth();

    short getDefaultRowHeight();

    float getDefaultRowHeightInPoints();

    boolean getDisplayGuts();

    Drawing<?> getDrawingPatriarch();

    int getFirstRowNum();

    boolean getFitToPage();

    Footer getFooter();

    boolean getForceFormulaRecalculation();

    Header getHeader();

    boolean getHorizontallyCenter();

    Hyperlink getHyperlink(int i, int i2);

    Hyperlink getHyperlink(CellAddress cellAddress);

    List<? extends Hyperlink> getHyperlinkList();

    int getLastRowNum();

    short getLeftCol();

    double getMargin(short s);

    CellRangeAddress getMergedRegion(int i);

    List<CellRangeAddress> getMergedRegions();

    int getNumMergedRegions();

    PaneInformation getPaneInformation();

    int getPhysicalNumberOfRows();

    PrintSetup getPrintSetup();

    boolean getProtect();

    CellRangeAddress getRepeatingColumns();

    CellRangeAddress getRepeatingRows();

    Row getRow(int i);

    int[] getRowBreaks();

    boolean getRowSumsBelow();

    boolean getRowSumsRight();

    boolean getScenarioProtect();

    SheetConditionalFormatting getSheetConditionalFormatting();

    String getSheetName();

    short getTopRow();

    boolean getVerticallyCenter();

    Workbook getWorkbook();

    void groupColumn(int i, int i2);

    void groupRow(int i, int i2);

    boolean isColumnBroken(int i);

    boolean isColumnHidden(int i);

    boolean isDisplayFormulas();

    boolean isDisplayGridlines();

    boolean isDisplayRowColHeadings();

    boolean isDisplayZeros();

    boolean isPrintGridlines();

    boolean isPrintRowAndColumnHeadings();

    boolean isRightToLeft();

    boolean isRowBroken(int i);

    boolean isSelected();

    void protectSheet(String str);

    CellRange<? extends Cell> removeArrayFormula(Cell cell);

    void removeColumnBreak(int i);

    void removeMergedRegion(int i);

    void removeMergedRegions(Collection<Integer> collection);

    void removeRow(Row row);

    void removeRowBreak(int i);

    Iterator<Row> rowIterator();

    void setActiveCell(CellAddress cellAddress);

    CellRange<? extends Cell> setArrayFormula(String str, CellRangeAddress cellRangeAddress);

    AutoFilter setAutoFilter(CellRangeAddress cellRangeAddress);

    void setAutobreaks(boolean z);

    void setColumnBreak(int i);

    void setColumnGroupCollapsed(int i, boolean z);

    void setColumnHidden(int i, boolean z);

    void setColumnWidth(int i, int i2);

    void setDefaultColumnStyle(int i, CellStyle cellStyle);

    void setDefaultColumnWidth(int i);

    void setDefaultRowHeight(short s);

    void setDefaultRowHeightInPoints(float f);

    void setDisplayFormulas(boolean z);

    void setDisplayGridlines(boolean z);

    void setDisplayGuts(boolean z);

    void setDisplayRowColHeadings(boolean z);

    void setDisplayZeros(boolean z);

    void setFitToPage(boolean z);

    void setForceFormulaRecalculation(boolean z);

    void setHorizontallyCenter(boolean z);

    void setMargin(short s, double d);

    void setPrintGridlines(boolean z);

    void setPrintRowAndColumnHeadings(boolean z);

    void setRepeatingColumns(CellRangeAddress cellRangeAddress);

    void setRepeatingRows(CellRangeAddress cellRangeAddress);

    void setRightToLeft(boolean z);

    void setRowBreak(int i);

    void setRowGroupCollapsed(int i, boolean z);

    void setRowSumsBelow(boolean z);

    void setRowSumsRight(boolean z);

    void setSelected(boolean z);

    void setVerticallyCenter(boolean z);

    void setZoom(int i);

    void shiftRows(int i, int i2, int i3);

    void shiftRows(int i, int i2, int i3, boolean z, boolean z2);

    void showInPane(int i, int i2);

    void ungroupColumn(int i, int i2);

    void ungroupRow(int i, int i2);

    void validateMergedRegions();
}
