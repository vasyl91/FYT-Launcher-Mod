package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_GeomRect", namespace = XSSFRelation.NS_DRAWINGML)
public class CTGeomRect {

    @XmlAttribute(required = true)
    protected String b;

    @XmlAttribute(required = true)
    protected String l;

    @XmlAttribute(required = true)
    protected String r;

    @XmlAttribute(required = true)
    protected String t;

    public String getL() {
        return this.l;
    }

    public void setL(String str) {
        this.l = str;
    }

    public boolean isSetL() {
        return this.l != null;
    }

    public String getT() {
        return this.t;
    }

    public void setT(String str) {
        this.t = str;
    }

    public boolean isSetT() {
        return this.t != null;
    }

    public String getR() {
        return this.r;
    }

    public void setR(String str) {
        this.r = str;
    }

    public boolean isSetR() {
        return this.r != null;
    }

    public String getB() {
        return this.b;
    }

    public void setB(String str) {
        this.b = str;
    }

    public boolean isSetB() {
        return this.b != null;
    }
}
