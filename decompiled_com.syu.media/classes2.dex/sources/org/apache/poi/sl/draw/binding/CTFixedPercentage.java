package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_FixedPercentage", namespace = XSSFRelation.NS_DRAWINGML)
public class CTFixedPercentage {

    @XmlAttribute(required = true)
    protected int val;

    public boolean isSetVal() {
        return true;
    }

    public int getVal() {
        return this.val;
    }

    public void setVal(int i) {
        this.val = i;
    }
}
