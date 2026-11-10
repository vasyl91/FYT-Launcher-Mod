package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.HeaderRecord;
import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
import org.apache.poi.ss.usermodel.Header;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFHeader extends HeaderFooter implements Header {
    private final PageSettingsBlock _psb;

    protected HSSFHeader(PageSettingsBlock pageSettingsBlock) {
        this._psb = pageSettingsBlock;
    }

    @Override // org.apache.poi.hssf.usermodel.HeaderFooter
    protected String getRawText() {
        HeaderRecord header = this._psb.getHeader();
        return header == null ? "" : header.getText();
    }

    @Override // org.apache.poi.hssf.usermodel.HeaderFooter
    protected void setHeaderFooterText(String str) {
        HeaderRecord header = this._psb.getHeader();
        if (header == null) {
            this._psb.setHeader(new HeaderRecord(str));
        } else {
            header.setText(str);
        }
    }
}
