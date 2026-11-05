package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Color", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"scrgbClr", "srgbClr", "hslClr", "sysClr", "schemeClr", "prstClr"})
public class CTColor {

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTHslColor hslClr;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTPresetColor prstClr;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTSchemeColor schemeClr;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTScRgbColor scrgbClr;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTSRgbColor srgbClr;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTSystemColor sysClr;

    public CTScRgbColor getScrgbClr() {
        return this.scrgbClr;
    }

    public void setScrgbClr(CTScRgbColor cTScRgbColor) {
        this.scrgbClr = cTScRgbColor;
    }

    public boolean isSetScrgbClr() {
        return this.scrgbClr != null;
    }

    public CTSRgbColor getSrgbClr() {
        return this.srgbClr;
    }

    public void setSrgbClr(CTSRgbColor cTSRgbColor) {
        this.srgbClr = cTSRgbColor;
    }

    public boolean isSetSrgbClr() {
        return this.srgbClr != null;
    }

    public CTHslColor getHslClr() {
        return this.hslClr;
    }

    public void setHslClr(CTHslColor cTHslColor) {
        this.hslClr = cTHslColor;
    }

    public boolean isSetHslClr() {
        return this.hslClr != null;
    }

    public CTSystemColor getSysClr() {
        return this.sysClr;
    }

    public void setSysClr(CTSystemColor cTSystemColor) {
        this.sysClr = cTSystemColor;
    }

    public boolean isSetSysClr() {
        return this.sysClr != null;
    }

    public CTSchemeColor getSchemeClr() {
        return this.schemeClr;
    }

    public void setSchemeClr(CTSchemeColor cTSchemeColor) {
        this.schemeClr = cTSchemeColor;
    }

    public boolean isSetSchemeClr() {
        return this.schemeClr != null;
    }

    public CTPresetColor getPrstClr() {
        return this.prstClr;
    }

    public void setPrstClr(CTPresetColor cTPresetColor) {
        this.prstClr = cTPresetColor;
    }

    public boolean isSetPrstClr() {
        return this.prstClr != null;
    }
}
