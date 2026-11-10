package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_PolarAdjustHandle", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"pos"})
public class CTPolarAdjustHandle {

    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String gdRefAng;

    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String gdRefR;

    @XmlAttribute
    protected String maxAng;

    @XmlAttribute
    protected String maxR;

    @XmlAttribute
    protected String minAng;

    @XmlAttribute
    protected String minR;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML, required = true)
    protected CTAdjPoint2D pos;

    public CTAdjPoint2D getPos() {
        return this.pos;
    }

    public void setPos(CTAdjPoint2D cTAdjPoint2D) {
        this.pos = cTAdjPoint2D;
    }

    public boolean isSetPos() {
        return this.pos != null;
    }

    public String getGdRefR() {
        return this.gdRefR;
    }

    public void setGdRefR(String str) {
        this.gdRefR = str;
    }

    public boolean isSetGdRefR() {
        return this.gdRefR != null;
    }

    public String getMinR() {
        return this.minR;
    }

    public void setMinR(String str) {
        this.minR = str;
    }

    public boolean isSetMinR() {
        return this.minR != null;
    }

    public String getMaxR() {
        return this.maxR;
    }

    public void setMaxR(String str) {
        this.maxR = str;
    }

    public boolean isSetMaxR() {
        return this.maxR != null;
    }

    public String getGdRefAng() {
        return this.gdRefAng;
    }

    public void setGdRefAng(String str) {
        this.gdRefAng = str;
    }

    public boolean isSetGdRefAng() {
        return this.gdRefAng != null;
    }

    public String getMinAng() {
        return this.minAng;
    }

    public void setMinAng(String str) {
        this.minAng = str;
    }

    public boolean isSetMinAng() {
        return this.minAng != null;
    }

    public String getMaxAng() {
        return this.maxAng;
    }

    public void setMaxAng(String str) {
        this.maxAng = str;
    }

    public boolean isSetMaxAng() {
        return this.maxAng != null;
    }
}
