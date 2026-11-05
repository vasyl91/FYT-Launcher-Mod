package org.apache.poi.xssf.usermodel;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFCreationHelper implements CreationHelper {
    private final XSSFWorkbook workbook;

    @Internal
    public XSSFCreationHelper(XSSFWorkbook xSSFWorkbook) {
        this.workbook = xSSFWorkbook;
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFRichTextString createRichTextString(String str) {
        XSSFRichTextString xSSFRichTextString = new XSSFRichTextString(str);
        xSSFRichTextString.setStylesTableReference(this.workbook.getStylesSource());
        return xSSFRichTextString;
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFDataFormat createDataFormat() {
        return this.workbook.createDataFormat();
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFColor createExtendedColor() {
        return new XSSFColor(CTColor.Factory.newInstance(), this.workbook.getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFHyperlink createHyperlink(HyperlinkType hyperlinkType) {
        return new XSSFHyperlink(hyperlinkType);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFFormulaEvaluator createFormulaEvaluator() {
        return new XSSFFormulaEvaluator(this.workbook);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFClientAnchor createClientAnchor() {
        return new XSSFClientAnchor();
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public AreaReference createAreaReference(String str) {
        return new AreaReference(str, this.workbook.getSpreadsheetVersion());
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public AreaReference createAreaReference(CellReference cellReference, CellReference cellReference2) {
        return new AreaReference(cellReference, cellReference2, this.workbook.getSpreadsheetVersion());
    }
}
