package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class XSLFLineBreak extends XSLFTextRun {
    protected XSLFLineBreak(CTTextLineBreak cTTextLineBreak, XSLFTextParagraph xSLFTextParagraph) {
        super(cTTextLineBreak, xSLFTextParagraph);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextRun, org.apache.poi.sl.usermodel.TextRun
    public void setText(String str) {
        throw new IllegalStateException("You cannot change text of a line break, it is always '\\n'");
    }
}
