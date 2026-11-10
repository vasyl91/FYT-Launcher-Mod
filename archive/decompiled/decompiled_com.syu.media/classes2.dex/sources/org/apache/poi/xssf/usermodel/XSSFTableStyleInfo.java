package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.TableStyle;
import org.apache.poi.ss.usermodel.TableStyleInfo;
import org.apache.poi.xssf.model.StylesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFTableStyleInfo implements TableStyleInfo {
    private boolean columnStripes;
    private boolean firstColumn;
    private boolean lastColumn;
    private boolean rowStripes;
    private TableStyle style;
    private final CTTableStyleInfo styleInfo;
    private final StylesTable stylesTable;

    public XSSFTableStyleInfo(StylesTable stylesTable, CTTableStyleInfo cTTableStyleInfo) {
        this.columnStripes = cTTableStyleInfo.getShowColumnStripes();
        this.rowStripes = cTTableStyleInfo.getShowRowStripes();
        this.firstColumn = cTTableStyleInfo.getShowFirstColumn();
        this.lastColumn = cTTableStyleInfo.getShowLastColumn();
        this.style = stylesTable.getTableStyle(cTTableStyleInfo.getName());
        this.stylesTable = stylesTable;
        this.styleInfo = cTTableStyleInfo;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public boolean isShowColumnStripes() {
        return this.columnStripes;
    }

    public void setShowColumnStripes(boolean z) {
        this.columnStripes = z;
        this.styleInfo.setShowColumnStripes(z);
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public boolean isShowRowStripes() {
        return this.rowStripes;
    }

    public void setShowRowStripes(boolean z) {
        this.rowStripes = z;
        this.styleInfo.setShowRowStripes(z);
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public boolean isShowFirstColumn() {
        return this.firstColumn;
    }

    public void setFirstColumn(boolean z) {
        this.firstColumn = z;
        this.styleInfo.setShowFirstColumn(z);
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public boolean isShowLastColumn() {
        return this.lastColumn;
    }

    public void setLastColumn(boolean z) {
        this.lastColumn = z;
        this.styleInfo.setShowLastColumn(z);
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public String getName() {
        return this.style.getName();
    }

    public void setName(String str) {
        this.styleInfo.setName(str);
        this.style = this.stylesTable.getTableStyle(str);
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public TableStyle getStyle() {
        return this.style;
    }
}
