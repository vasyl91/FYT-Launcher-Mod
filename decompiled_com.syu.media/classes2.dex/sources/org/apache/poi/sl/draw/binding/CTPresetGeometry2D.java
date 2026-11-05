package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_PresetGeometry2D", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"avLst"})
public class CTPresetGeometry2D {

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTGeomGuideList avLst;

    @XmlAttribute(required = true)
    protected STShapeType prst;

    public CTGeomGuideList getAvLst() {
        return this.avLst;
    }

    public void setAvLst(CTGeomGuideList cTGeomGuideList) {
        this.avLst = cTGeomGuideList;
    }

    public boolean isSetAvLst() {
        return this.avLst != null;
    }

    public STShapeType getPrst() {
        return this.prst;
    }

    public void setPrst(STShapeType sTShapeType) {
        this.prst = sTShapeType;
    }

    public boolean isSetPrst() {
        return this.prst != null;
    }
}
