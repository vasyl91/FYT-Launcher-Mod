package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.Sheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFDialogsheet extends XSSFSheet implements Sheet {
    protected CTDialogsheet dialogsheet;

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet, org.apache.poi.ss.usermodel.Sheet
    public XSSFRow createRow(int i) {
        return null;
    }

    public boolean getDialog() {
        return true;
    }

    protected CTPageBreak getSheetTypeColumnBreaks() {
        return null;
    }

    protected CTPageBreak getSheetTypeRowBreaks() {
        return null;
    }

    protected XSSFDialogsheet(XSSFSheet xSSFSheet) {
        super(xSSFSheet.getPackagePart());
        this.dialogsheet = CTDialogsheet.Factory.newInstance();
        this.worksheet = CTWorksheet.Factory.newInstance();
    }

    protected CTHeaderFooter getSheetTypeHeaderFooter() {
        if (this.dialogsheet.getHeaderFooter() == null) {
            this.dialogsheet.setHeaderFooter(CTHeaderFooter.Factory.newInstance());
        }
        return this.dialogsheet.getHeaderFooter();
    }

    protected CTSheetPr getSheetTypeSheetPr() {
        if (this.dialogsheet.getSheetPr() == null) {
            this.dialogsheet.setSheetPr(CTSheetPr.Factory.newInstance());
        }
        return this.dialogsheet.getSheetPr();
    }

    protected CTSheetFormatPr getSheetTypeSheetFormatPr() {
        if (this.dialogsheet.getSheetFormatPr() == null) {
            this.dialogsheet.setSheetFormatPr(CTSheetFormatPr.Factory.newInstance());
        }
        return this.dialogsheet.getSheetFormatPr();
    }

    protected CTPageMargins getSheetTypePageMargins() {
        if (this.dialogsheet.getPageMargins() == null) {
            this.dialogsheet.setPageMargins(CTPageMargins.Factory.newInstance());
        }
        return this.dialogsheet.getPageMargins();
    }

    protected CTSheetViews getSheetTypeSheetViews() {
        if (this.dialogsheet.getSheetViews() == null) {
            this.dialogsheet.setSheetViews(CTSheetViews.Factory.newInstance());
            this.dialogsheet.getSheetViews().addNewSheetView();
        }
        return this.dialogsheet.getSheetViews();
    }

    protected CTPrintOptions getSheetTypePrintOptions() {
        if (this.dialogsheet.getPrintOptions() == null) {
            this.dialogsheet.setPrintOptions(CTPrintOptions.Factory.newInstance());
        }
        return this.dialogsheet.getPrintOptions();
    }

    protected CTSheetProtection getSheetTypeProtection() {
        if (this.dialogsheet.getSheetProtection() == null) {
            this.dialogsheet.setSheetProtection(CTSheetProtection.Factory.newInstance());
        }
        return this.dialogsheet.getSheetProtection();
    }
}
