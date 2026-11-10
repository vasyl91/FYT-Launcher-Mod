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
@XmlType(name = "CT_XYAdjustHandle", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"pos"})
public class CTXYAdjustHandle {

    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String gdRefX;

    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String gdRefY;

    @XmlAttribute
    protected String maxX;

    @XmlAttribute
    protected String maxY;

    @XmlAttribute
    protected String minX;

    @XmlAttribute
    protected String minY;

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

    public String getGdRefX() {
        return this.gdRefX;
    }

    public void setGdRefX(String str) {
        this.gdRefX = str;
    }

    public boolean isSetGdRefX() {
        return this.gdRefX != null;
    }

    public String getMinX() {
        return this.minX;
    }

    public void setMinX(String str) {
        this.minX = str;
    }

    public boolean isSetMinX() {
        return this.minX != null;
    }

    public String getMaxX() {
        return this.maxX;
    }

    public void setMaxX(String str) {
        this.maxX = str;
    }

    public boolean isSetMaxX() {
        return this.maxX != null;
    }

    public String getGdRefY() {
        return this.gdRefY;
    }

    public void setGdRefY(String str) {
        this.gdRefY = str;
    }

    public boolean isSetGdRefY() {
        return this.gdRefY != null;
    }

    public String getMinY() {
        return this.minY;
    }

    public void setMinY(String str) {
        this.minY = str;
    }

    public boolean isSetMinY() {
        return this.minY != null;
    }

    public String getMaxY() {
        return this.maxY;
    }

    public void setMaxY(String str) {
        this.maxY = str;
    }

    public boolean isSetMaxY() {
        return this.maxY != null;
    }
}
