package org.apache.poi.sl.draw.binding;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_SystemColor", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"egColorTransform"})
public class CTSystemColor {

    @XmlElementRefs({@XmlElementRef(name = "gray", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "green", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "shade", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "blueOff", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "lumMod", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "alphaMod", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "redMod", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "blue", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "sat", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "alphaOff", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "red", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "greenOff", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "hueMod", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "satOff", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "gamma", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "redOff", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "hue", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "satMod", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "lum", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "comp", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "invGamma", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "hueOff", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "alpha", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "greenMod", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "inv", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "blueMod", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "tint", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class), @XmlElementRef(name = "lumOff", namespace = XSSFRelation.NS_DRAWINGML, type = JAXBElement.class)})
    protected List<JAXBElement<?>> egColorTransform;

    @XmlAttribute
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] lastClr;

    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String val;

    public List<JAXBElement<?>> getEGColorTransform() {
        if (this.egColorTransform == null) {
            this.egColorTransform = new ArrayList();
        }
        return this.egColorTransform;
    }

    public boolean isSetEGColorTransform() {
        List<JAXBElement<?>> list = this.egColorTransform;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void unsetEGColorTransform() {
        this.egColorTransform = null;
    }

    public String getVal() {
        return this.val;
    }

    public void setVal(String str) {
        this.val = str;
    }

    public boolean isSetVal() {
        return this.val != null;
    }

    public byte[] getLastClr() {
        return this.lastClr;
    }

    public void setLastClr(byte[] bArr) {
        this.lastClr = bArr != null ? (byte[]) bArr.clone() : null;
    }

    public boolean isSetLastClr() {
        return this.lastClr != null;
    }
}
