package org.apache.poi.xssf.streaming;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.ExtendedColor;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SXSSFCreationHelper implements CreationHelper {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) SXSSFCreationHelper.class);
    private final XSSFCreationHelper helper;
    private final SXSSFWorkbook wb;

    @Internal
    public SXSSFCreationHelper(SXSSFWorkbook sXSSFWorkbook) {
        this.helper = new XSSFCreationHelper(sXSSFWorkbook.getXSSFWorkbook());
        this.wb = sXSSFWorkbook;
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFRichTextString createRichTextString(String str) {
        logger.log(3, "SXSSF doesn't support Rich Text Strings, any formatting information will be lost");
        return new XSSFRichTextString(str);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public SXSSFFormulaEvaluator createFormulaEvaluator() {
        return new SXSSFFormulaEvaluator(this.wb);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public DataFormat createDataFormat() {
        return this.helper.createDataFormat();
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public Hyperlink createHyperlink(HyperlinkType hyperlinkType) {
        return this.helper.createHyperlink(hyperlinkType);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public ExtendedColor createExtendedColor() {
        return this.helper.createExtendedColor();
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public ClientAnchor createClientAnchor() {
        return this.helper.createClientAnchor();
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public AreaReference createAreaReference(String str) {
        return new AreaReference(str, this.wb.getSpreadsheetVersion());
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public AreaReference createAreaReference(CellReference cellReference, CellReference cellReference2) {
        return new AreaReference(cellReference, cellReference2, this.wb.getSpreadsheetVersion());
    }
}
