package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Path2DArcTo", namespace = XSSFRelation.NS_DRAWINGML)
public class CTPath2DArcTo {

    @XmlAttribute(name = "hR", required = true)
    protected String hr;

    @XmlAttribute(required = true)
    protected String stAng;

    @XmlAttribute(required = true)
    protected String swAng;

    @XmlAttribute(name = "wR", required = true)
    protected String wr;

    public String getWR() {
        return this.wr;
    }

    public void setWR(String str) {
        this.wr = str;
    }

    public boolean isSetWR() {
        return this.wr != null;
    }

    public String getHR() {
        return this.hr;
    }

    public void setHR(String str) {
        this.hr = str;
    }

    public boolean isSetHR() {
        return this.hr != null;
    }

    public String getStAng() {
        return this.stAng;
    }

    public void setStAng(String str) {
        this.stAng = str;
    }

    public boolean isSetStAng() {
        return this.stAng != null;
    }

    public String getSwAng() {
        return this.swAng;
    }

    public void setSwAng(String str) {
        this.swAng = str;
    }

    public boolean isSetSwAng() {
        return this.swAng != null;
    }
}
