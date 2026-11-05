package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.BorderFormatting;
import org.apache.poi.ss.usermodel.DifferentialStyleProvider;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFDxfStyleProvider implements DifferentialStyleProvider {
    private final BorderFormatting border;
    private final IndexedColorMap colorMap;
    private final PatternFormatting fill;
    private final FontFormatting font;
    private final ExcelNumberFormat number;
    private final int stripeSize;

    public XSSFDxfStyleProvider(CTDxf cTDxf, int i, IndexedColorMap indexedColorMap) {
        this.stripeSize = i;
        this.colorMap = indexedColorMap;
        if (cTDxf == null) {
            this.border = null;
            this.font = null;
            this.number = null;
            this.fill = null;
            return;
        }
        this.border = cTDxf.isSetBorder() ? new XSSFBorderFormatting(cTDxf.getBorder(), indexedColorMap) : null;
        this.font = cTDxf.isSetFont() ? new XSSFFontFormatting(cTDxf.getFont(), indexedColorMap) : null;
        if (cTDxf.isSetNumFmt()) {
            CTNumFmt numFmt = cTDxf.getNumFmt();
            this.number = new ExcelNumberFormat((int) numFmt.getNumFmtId(), numFmt.getFormatCode());
        } else {
            this.number = null;
        }
        this.fill = cTDxf.isSetFill() ? new XSSFPatternFormatting(cTDxf.getFill(), indexedColorMap) : null;
    }

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public BorderFormatting getBorderFormatting() {
        return this.border;
    }

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public FontFormatting getFontFormatting() {
        return this.font;
    }

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public ExcelNumberFormat getNumberFormat() {
        return this.number;
    }

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public PatternFormatting getPatternFormatting() {
        return this.fill;
    }

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public int getStripeSize() {
        return this.stripeSize;
    }
}
