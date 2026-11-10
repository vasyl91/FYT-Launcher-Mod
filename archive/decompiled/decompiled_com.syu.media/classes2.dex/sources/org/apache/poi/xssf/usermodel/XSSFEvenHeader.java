package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFEvenHeader extends XSSFHeaderFooter implements Header {
    public XSSFEvenHeader(CTHeaderFooter cTHeaderFooter) {
        super(cTHeaderFooter);
        cTHeaderFooter.setDifferentOddEven(true);
    }

    @Override // org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter
    public String getText() {
        return getHeaderFooter().getEvenHeader();
    }

    @Override // org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter
    public void setText(String str) {
        if (str == null) {
            getHeaderFooter().unsetEvenHeader();
        } else {
            getHeaderFooter().setEvenHeader(str);
        }
    }
}
