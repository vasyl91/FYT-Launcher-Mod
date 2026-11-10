package org.apache.poi.sl.draw.binding;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_GeomGuideList", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"gd"})
public class CTGeomGuideList {

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected List<CTGeomGuide> gd;

    public List<CTGeomGuide> getGd() {
        if (this.gd == null) {
            this.gd = new ArrayList();
        }
        return this.gd;
    }

    public boolean isSetGd() {
        List<CTGeomGuide> list = this.gd;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void unsetGd() {
        this.gd = null;
    }
}
