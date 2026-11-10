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
@XmlType(name = "CT_ConnectionSiteList", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"cxn"})
public class CTConnectionSiteList {

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected List<CTConnectionSite> cxn;

    public List<CTConnectionSite> getCxn() {
        if (this.cxn == null) {
            this.cxn = new ArrayList();
        }
        return this.cxn;
    }

    public boolean isSetCxn() {
        List<CTConnectionSite> list = this.cxn;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void unsetCxn() {
        this.cxn = null;
    }
}
