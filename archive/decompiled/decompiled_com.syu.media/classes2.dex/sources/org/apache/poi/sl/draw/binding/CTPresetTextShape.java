package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_PresetTextShape", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"avLst"})
public class CTPresetTextShape {

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTGeomGuideList avLst;

    @XmlAttribute(required = true)
    protected STTextShapeType prst;

    public CTGeomGuideList getAvLst() {
        return this.avLst;
    }

    public void setAvLst(CTGeomGuideList cTGeomGuideList) {
        this.avLst = cTGeomGuideList;
    }

    public boolean isSetAvLst() {
        return this.avLst != null;
    }

    public STTextShapeType getPrst() {
        return this.prst;
    }

    public void setPrst(STTextShapeType sTTextShapeType) {
        this.prst = sTTextShapeType;
    }

    public boolean isSetPrst() {
        return this.prst != null;
    }
}
