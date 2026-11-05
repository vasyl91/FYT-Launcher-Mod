package org.apache.poi.hssf.usermodel;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.record.common.ExtendedColor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFCreationHelper implements CreationHelper {
    private final HSSFWorkbook workbook;

    @Internal(since = "3.15 beta 3")
    HSSFCreationHelper(HSSFWorkbook hSSFWorkbook) {
        this.workbook = hSSFWorkbook;
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public HSSFRichTextString createRichTextString(String str) {
        return new HSSFRichTextString(str);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public HSSFDataFormat createDataFormat() {
        return this.workbook.createDataFormat();
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public HSSFHyperlink createHyperlink(HyperlinkType hyperlinkType) {
        return new HSSFHyperlink(hyperlinkType);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public HSSFExtendedColor createExtendedColor() {
        return new HSSFExtendedColor(new ExtendedColor());
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public HSSFFormulaEvaluator createFormulaEvaluator() {
        return new HSSFFormulaEvaluator(this.workbook);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public HSSFClientAnchor createClientAnchor() {
        return new HSSFClientAnchor();
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
