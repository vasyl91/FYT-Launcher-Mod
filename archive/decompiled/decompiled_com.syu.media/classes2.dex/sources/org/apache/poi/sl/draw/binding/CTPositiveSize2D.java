package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_PositiveSize2D", namespace = XSSFRelation.NS_DRAWINGML)
public class CTPositiveSize2D {

    @XmlAttribute(required = true)
    protected long cx;

    @XmlAttribute(required = true)
    protected long cy;

    public boolean isSetCx() {
        return true;
    }

    public boolean isSetCy() {
        return true;
    }

    public long getCx() {
        return this.cx;
    }

    public void setCx(long j) {
        this.cx = j;
    }

    public long getCy() {
        return this.cy;
    }

    public void setCy(long j) {
        this.cy = j;
    }
}
