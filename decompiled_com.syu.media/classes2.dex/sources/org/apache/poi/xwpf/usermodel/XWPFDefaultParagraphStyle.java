package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFDefaultParagraphStyle {
    private CTPPr ppr;

    public XWPFDefaultParagraphStyle(CTPPr cTPPr) {
        this.ppr = cTPPr;
    }

    protected CTPPr getPPr() {
        return this.ppr;
    }

    public int getSpacingAfter() {
        if (this.ppr.isSetSpacing()) {
            return this.ppr.getSpacing().getAfter().intValue();
        }
        return -1;
    }
}
