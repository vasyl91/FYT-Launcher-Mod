package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Point2D", namespace = XSSFRelation.NS_DRAWINGML)
public class CTPoint2D {

    @XmlAttribute(required = true)
    protected long x;

    @XmlAttribute(required = true)
    protected long y;

    public boolean isSetX() {
        return true;
    }

    public boolean isSetY() {
        return true;
    }

    public long getX() {
        return this.x;
    }

    public void setX(long j) {
        this.x = j;
    }

    public long getY() {
        return this.y;
    }

    public void setY(long j) {
        this.y = j;
    }
}
