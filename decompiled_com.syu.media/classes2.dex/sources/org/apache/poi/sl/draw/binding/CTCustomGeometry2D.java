package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_CustomGeometry2D", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"avLst", "gdLst", "ahLst", "cxnLst", "rect", "pathLst"})
public class CTCustomGeometry2D {

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTAdjustHandleList ahLst;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTGeomGuideList avLst;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTConnectionSiteList cxnLst;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTGeomGuideList gdLst;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML, required = true)
    protected CTPath2DList pathLst;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTGeomRect rect;

    public CTGeomGuideList getAvLst() {
        return this.avLst;
    }

    public void setAvLst(CTGeomGuideList cTGeomGuideList) {
        this.avLst = cTGeomGuideList;
    }

    public boolean isSetAvLst() {
        return this.avLst != null;
    }

    public CTGeomGuideList getGdLst() {
        return this.gdLst;
    }

    public void setGdLst(CTGeomGuideList cTGeomGuideList) {
        this.gdLst = cTGeomGuideList;
    }

    public boolean isSetGdLst() {
        return this.gdLst != null;
    }

    public CTAdjustHandleList getAhLst() {
        return this.ahLst;
    }

    public void setAhLst(CTAdjustHandleList cTAdjustHandleList) {
        this.ahLst = cTAdjustHandleList;
    }

    public boolean isSetAhLst() {
        return this.ahLst != null;
    }

    public CTConnectionSiteList getCxnLst() {
        return this.cxnLst;
    }

    public void setCxnLst(CTConnectionSiteList cTConnectionSiteList) {
        this.cxnLst = cTConnectionSiteList;
    }

    public boolean isSetCxnLst() {
        return this.cxnLst != null;
    }

    public CTGeomRect getRect() {
        return this.rect;
    }

    public void setRect(CTGeomRect cTGeomRect) {
        this.rect = cTGeomRect;
    }

    public boolean isSetRect() {
        return this.rect != null;
    }

    public CTPath2DList getPathLst() {
        return this.pathLst;
    }

    public void setPathLst(CTPath2DList cTPath2DList) {
        this.pathLst = cTPath2DList;
    }

    public boolean isSetPathLst() {
        return this.pathLst != null;
    }
}
