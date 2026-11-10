package org.apache.poi.xssf.usermodel.extensions;

import org.apache.poi.ss.usermodel.HeaderFooter;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class XSSFHeaderFooter implements HeaderFooter {
    private CTHeaderFooter headerFooter;
    private boolean stripFields = false;
    private HeaderFooterHelper helper = new HeaderFooterHelper();

    public abstract String getText();

    protected abstract void setText(String str);

    public XSSFHeaderFooter(CTHeaderFooter cTHeaderFooter) {
        this.headerFooter = cTHeaderFooter;
    }

    @Internal
    public CTHeaderFooter getHeaderFooter() {
        return this.headerFooter;
    }

    public String getValue() {
        String text = getText();
        return text == null ? "" : text;
    }

    public boolean areFieldsStripped() {
        return this.stripFields;
    }

    public void setAreFieldsStripped(boolean z) {
        this.stripFields = z;
    }

    public static String stripFields(String str) {
        return org.apache.poi.hssf.usermodel.HeaderFooter.stripFields(str);
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public String getCenter() {
        String centerSection = this.helper.getCenterSection(getText());
        return this.stripFields ? stripFields(centerSection) : centerSection;
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public String getLeft() {
        String leftSection = this.helper.getLeftSection(getText());
        return this.stripFields ? stripFields(leftSection) : leftSection;
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public String getRight() {
        String rightSection = this.helper.getRightSection(getText());
        return this.stripFields ? stripFields(rightSection) : rightSection;
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public void setCenter(String str) {
        setText(this.helper.setCenterSection(getText(), str));
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public void setLeft(String str) {
        setText(this.helper.setLeftSection(getText(), str));
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public void setRight(String str) {
        setText(this.helper.setRightSection(getText(), str));
    }
}
