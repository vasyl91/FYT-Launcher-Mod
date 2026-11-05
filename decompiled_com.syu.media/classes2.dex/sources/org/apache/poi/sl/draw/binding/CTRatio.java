package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Ratio", namespace = XSSFRelation.NS_DRAWINGML)
public class CTRatio {

    @XmlAttribute(required = true)
    protected long d;

    @XmlAttribute(required = true)
    protected long n;

    public boolean isSetD() {
        return true;
    }

    public boolean isSetN() {
        return true;
    }

    public long getN() {
        return this.n;
    }

    public void setN(long j) {
        this.n = j;
    }

    public long getD() {
        return this.d;
    }

    public void setD(long j) {
        this.d = j;
    }
}
