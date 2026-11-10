package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class XSSFLineBreak extends XSSFTextRun {
    private final CTTextCharacterProperties _brProps;

    XSSFLineBreak(CTRegularTextRun cTRegularTextRun, XSSFTextParagraph xSSFTextParagraph, CTTextCharacterProperties cTTextCharacterProperties) {
        super(cTRegularTextRun, xSSFTextParagraph);
        this._brProps = cTTextCharacterProperties;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFTextRun
    protected CTTextCharacterProperties getRPr() {
        return this._brProps;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFTextRun
    public void setText(String str) {
        throw new IllegalStateException("You cannot change text of a line break, it is always '\\n'");
    }
}
