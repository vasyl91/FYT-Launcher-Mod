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
@XmlType(name = "CT_ColorMRU", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"egColorChoice"})
public class CTColorMRU {

    @XmlElements({@XmlElement(name = "prstClr", namespace = XSSFRelation.NS_DRAWINGML, type = CTPresetColor.class), @XmlElement(name = "sysClr", namespace = XSSFRelation.NS_DRAWINGML, type = CTSystemColor.class), @XmlElement(name = "hslClr", namespace = XSSFRelation.NS_DRAWINGML, type = CTHslColor.class), @XmlElement(name = "srgbClr", namespace = XSSFRelation.NS_DRAWINGML, type = CTSRgbColor.class), @XmlElement(name = "scrgbClr", namespace = XSSFRelation.NS_DRAWINGML, type = CTScRgbColor.class), @XmlElement(name = "schemeClr", namespace = XSSFRelation.NS_DRAWINGML, type = CTSchemeColor.class)})
    protected List<Object> egColorChoice;

    public List<Object> getEGColorChoice() {
        if (this.egColorChoice == null) {
            this.egColorChoice = new ArrayList();
        }
        return this.egColorChoice;
    }

    public boolean isSetEGColorChoice() {
        List<Object> list = this.egColorChoice;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void unsetEGColorChoice() {
        this.egColorChoice = null;
    }
}
