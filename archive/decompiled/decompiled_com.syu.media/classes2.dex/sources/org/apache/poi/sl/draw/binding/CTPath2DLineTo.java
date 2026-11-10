package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Path2DLineTo", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"pt"})
public class CTPath2DLineTo {

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML, required = true)
    protected CTAdjPoint2D pt;

    public CTAdjPoint2D getPt() {
        return this.pt;
    }

    public void setPt(CTAdjPoint2D cTAdjPoint2D) {
        this.pt = cTAdjPoint2D;
    }

    public boolean isSetPt() {
        return this.pt != null;
    }
}
