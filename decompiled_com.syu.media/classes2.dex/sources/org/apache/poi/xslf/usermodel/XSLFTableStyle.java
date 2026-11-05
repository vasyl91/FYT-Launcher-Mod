package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFTableStyle {
    private CTTableStyle _tblStyle;

    public enum TablePartStyle {
        wholeTbl,
        band1H,
        band2H,
        band1V,
        band2V,
        firstCol,
        lastCol,
        firstRow,
        lastRow,
        seCell,
        swCell,
        neCell,
        nwCell
    }

    XSLFTableStyle(CTTableStyle cTTableStyle) {
        this._tblStyle = cTTableStyle;
    }

    public CTTableStyle getXmlObject() {
        return this._tblStyle;
    }

    public String getStyleName() {
        return this._tblStyle.getStyleName();
    }

    public String getStyleId() {
        return this._tblStyle.getStyleId();
    }

    protected CTTablePartStyle getTablePartStyle(TablePartStyle tablePartStyle) {
        switch (tablePartStyle) {
            case band1H:
                return this._tblStyle.getBand1H();
            case band2H:
                return this._tblStyle.getBand2H();
            case band1V:
                return this._tblStyle.getBand1V();
            case band2V:
                return this._tblStyle.getBand2V();
            case firstCol:
                return this._tblStyle.getFirstCol();
            case lastCol:
                return this._tblStyle.getLastCol();
            case firstRow:
                return this._tblStyle.getFirstRow();
            case lastRow:
                return this._tblStyle.getLastRow();
            case seCell:
                return this._tblStyle.getSeCell();
            case swCell:
                return this._tblStyle.getSwCell();
            case neCell:
                return this._tblStyle.getNeCell();
            case nwCell:
                return this._tblStyle.getNwCell();
            default:
                return this._tblStyle.getWholeTbl();
        }
    }
}
