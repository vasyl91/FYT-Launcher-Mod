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
@XmlType(name = "CT_OfficeArtExtensionList", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"ext"})
public class CTOfficeArtExtensionList {

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected List<CTOfficeArtExtension> ext;

    public List<CTOfficeArtExtension> getExt() {
        if (this.ext == null) {
            this.ext = new ArrayList();
        }
        return this.ext;
    }

    public boolean isSetExt() {
        List<CTOfficeArtExtension> list = this.ext;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void unsetExt() {
        this.ext = null;
    }
}
