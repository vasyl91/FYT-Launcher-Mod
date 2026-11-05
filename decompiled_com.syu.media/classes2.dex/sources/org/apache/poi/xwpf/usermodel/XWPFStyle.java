package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFStyle {
    private CTStyle ctStyle;
    protected XWPFStyles styles;

    public XWPFStyle(CTStyle cTStyle) {
        this(cTStyle, null);
    }

    public XWPFStyle(CTStyle cTStyle, XWPFStyles xWPFStyles) {
        this.ctStyle = cTStyle;
        this.styles = xWPFStyles;
    }

    public String getStyleId() {
        return this.ctStyle.getStyleId();
    }

    public void setStyleId(String str) {
        this.ctStyle.setStyleId(str);
    }

    public STStyleType.Enum getType() {
        return this.ctStyle.getType();
    }

    public void setType(STStyleType.Enum r2) {
        this.ctStyle.setType(r2);
    }

    public void setStyle(CTStyle cTStyle) {
        this.ctStyle = cTStyle;
    }

    public CTStyle getCTStyle() {
        return this.ctStyle;
    }

    public XWPFStyles getStyles() {
        return this.styles;
    }

    public String getBasisStyleID() {
        if (this.ctStyle.getBasedOn() != null) {
            return this.ctStyle.getBasedOn().getVal();
        }
        return null;
    }

    public String getLinkStyleID() {
        if (this.ctStyle.getLink() != null) {
            return this.ctStyle.getLink().getVal();
        }
        return null;
    }

    public String getNextStyleID() {
        if (this.ctStyle.getNext() != null) {
            return this.ctStyle.getNext().getVal();
        }
        return null;
    }

    public String getName() {
        if (this.ctStyle.isSetName()) {
            return this.ctStyle.getName().getVal();
        }
        return null;
    }

    public boolean hasSameName(XWPFStyle xWPFStyle) {
        return xWPFStyle.getCTStyle().getName().getVal().equals(this.ctStyle.getName().getVal());
    }
}
