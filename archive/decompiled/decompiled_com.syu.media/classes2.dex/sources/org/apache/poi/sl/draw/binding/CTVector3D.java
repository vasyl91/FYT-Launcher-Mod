package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Vector3D", namespace = XSSFRelation.NS_DRAWINGML)
public class CTVector3D {

    @XmlAttribute(required = true)
    protected long dx;

    @XmlAttribute(required = true)
    protected long dy;

    @XmlAttribute(required = true)
    protected long dz;

    public boolean isSetDx() {
        return true;
    }

    public boolean isSetDy() {
        return true;
    }

    public boolean isSetDz() {
        return true;
    }

    public long getDx() {
        return this.dx;
    }

    public void setDx(long j) {
        this.dx = j;
    }

    public long getDy() {
        return this.dy;
    }

    public void setDy(long j) {
        this.dy = j;
    }

    public long getDz() {
        return this.dz;
    }

    public void setDz(long j) {
        this.dz = j;
    }
}
