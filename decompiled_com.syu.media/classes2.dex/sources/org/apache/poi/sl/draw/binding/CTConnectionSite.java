package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_ConnectionSite", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"pos"})
public class CTConnectionSite {

    @XmlAttribute(required = true)
    protected String ang;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML, required = true)
    protected CTAdjPoint2D pos;

    public CTAdjPoint2D getPos() {
        return this.pos;
    }

    public void setPos(CTAdjPoint2D cTAdjPoint2D) {
        this.pos = cTAdjPoint2D;
    }

    public boolean isSetPos() {
        return this.pos != null;
    }

    public String getAng() {
        return this.ang;
    }

    public void setAng(String str) {
        this.ang = str;
    }

    public boolean isSetAng() {
        return this.ang != null;
    }
}
