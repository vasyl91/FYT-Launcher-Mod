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
@XmlType(name = "CT_Path2DList", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"path"})
public class CTPath2DList {

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected List<CTPath2D> path;

    public List<CTPath2D> getPath() {
        if (this.path == null) {
            this.path = new ArrayList();
        }
        return this.path;
    }

    public boolean isSetPath() {
        List<CTPath2D> list = this.path;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void unsetPath() {
        this.path = null;
    }
}
