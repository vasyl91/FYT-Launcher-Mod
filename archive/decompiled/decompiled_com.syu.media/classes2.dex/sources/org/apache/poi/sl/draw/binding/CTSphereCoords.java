package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_SphereCoords", namespace = XSSFRelation.NS_DRAWINGML)
public class CTSphereCoords {

    @XmlAttribute(required = true)
    protected int lat;

    @XmlAttribute(required = true)
    protected int lon;

    @XmlAttribute(required = true)
    protected int rev;

    public boolean isSetLat() {
        return true;
    }

    public boolean isSetLon() {
        return true;
    }

    public boolean isSetRev() {
        return true;
    }

    public int getLat() {
        return this.lat;
    }

    public void setLat(int i) {
        this.lat = i;
    }

    public int getLon() {
        return this.lon;
    }

    public void setLon(int i) {
        this.lon = i;
    }

    public int getRev() {
        return this.rev;
    }

    public void setRev(int i) {
        this.rev = i;
    }
}
