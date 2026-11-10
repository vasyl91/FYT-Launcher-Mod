package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFDefaultRunStyle {
    private CTRPr rpr;

    public XWPFDefaultRunStyle(CTRPr cTRPr) {
        this.rpr = cTRPr;
    }

    protected CTRPr getRPr() {
        return this.rpr;
    }

    public int getFontSize() {
        if (this.rpr.isSetSz()) {
            return this.rpr.getSz().getVal().intValue() / 2;
        }
        return -1;
    }
}
