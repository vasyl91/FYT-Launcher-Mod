package org.apache.poi.sl.draw.binding;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_AdjustHandleList", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"ahXYOrAhPolar"})
public class CTAdjustHandleList {

    @XmlElements({@XmlElement(name = "ahXY", namespace = XSSFRelation.NS_DRAWINGML, type = CTXYAdjustHandle.class), @XmlElement(name = "ahPolar", namespace = XSSFRelation.NS_DRAWINGML, type = CTPolarAdjustHandle.class)})
    protected List<Object> ahXYOrAhPolar;

    public List<Object> getAhXYOrAhPolar() {
        if (this.ahXYOrAhPolar == null) {
            this.ahXYOrAhPolar = new ArrayList();
        }
        return this.ahXYOrAhPolar;
    }

    public boolean isSetAhXYOrAhPolar() {
        List<Object> list = this.ahXYOrAhPolar;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void unsetAhXYOrAhPolar() {
        this.ahXYOrAhPolar = null;
    }
}
