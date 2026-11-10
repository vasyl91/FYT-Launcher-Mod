package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_RelativeRect", namespace = XSSFRelation.NS_DRAWINGML)
public class CTRelativeRect {

    @XmlAttribute
    protected Integer b;

    @XmlAttribute
    protected Integer l;

    @XmlAttribute
    protected Integer r;

    @XmlAttribute
    protected Integer t;

    public int getL() {
        Integer num = this.l;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setL(int i) {
        this.l = Integer.valueOf(i);
    }

    public boolean isSetL() {
        return this.l != null;
    }

    public void unsetL() {
        this.l = null;
    }

    public int getT() {
        Integer num = this.t;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setT(int i) {
        this.t = Integer.valueOf(i);
    }

    public boolean isSetT() {
        return this.t != null;
    }

    public void unsetT() {
        this.t = null;
    }

    public int getR() {
        Integer num = this.r;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setR(int i) {
        this.r = Integer.valueOf(i);
    }

    public boolean isSetR() {
        return this.r != null;
    }

    public void unsetR() {
        this.r = null;
    }

    public int getB() {
        Integer num = this.b;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setB(int i) {
        this.b = Integer.valueOf(i);
    }

    public boolean isSetB() {
        return this.b != null;
    }

    public void unsetB() {
        this.b = null;
    }
}
