package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLsdException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFLatentStyles {
    private CTLatentStyles latentStyles;
    protected XWPFStyles styles;

    protected XWPFLatentStyles() {
    }

    protected XWPFLatentStyles(CTLatentStyles cTLatentStyles) {
        this(cTLatentStyles, null);
    }

    protected XWPFLatentStyles(CTLatentStyles cTLatentStyles, XWPFStyles xWPFStyles) {
        this.latentStyles = cTLatentStyles;
        this.styles = xWPFStyles;
    }

    public int getNumberOfStyles() {
        return this.latentStyles.sizeOfLsdExceptionArray();
    }

    protected boolean isLatentStyle(String str) {
        for (CTLsdException cTLsdException : this.latentStyles.getLsdExceptionArray()) {
            if (cTLsdException.getName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
