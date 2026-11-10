package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import kotlinx.coroutines.DebugKt;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_GroupTransform2D", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {DebugKt.DEBUG_PROPERTY_VALUE_OFF, "ext", "chOff", "chExt"})
public class CTGroupTransform2D {

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTPositiveSize2D chExt;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTPoint2D chOff;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTPositiveSize2D ext;

    @XmlAttribute
    protected Boolean flipH;

    @XmlAttribute
    protected Boolean flipV;

    @XmlElement(namespace = XSSFRelation.NS_DRAWINGML)
    protected CTPoint2D off;

    @XmlAttribute
    protected Integer rot;

    public CTPoint2D getOff() {
        return this.off;
    }

    public void setOff(CTPoint2D cTPoint2D) {
        this.off = cTPoint2D;
    }

    public boolean isSetOff() {
        return this.off != null;
    }

    public CTPositiveSize2D getExt() {
        return this.ext;
    }

    public void setExt(CTPositiveSize2D cTPositiveSize2D) {
        this.ext = cTPositiveSize2D;
    }

    public boolean isSetExt() {
        return this.ext != null;
    }

    public CTPoint2D getChOff() {
        return this.chOff;
    }

    public void setChOff(CTPoint2D cTPoint2D) {
        this.chOff = cTPoint2D;
    }

    public boolean isSetChOff() {
        return this.chOff != null;
    }

    public CTPositiveSize2D getChExt() {
        return this.chExt;
    }

    public void setChExt(CTPositiveSize2D cTPositiveSize2D) {
        this.chExt = cTPositiveSize2D;
    }

    public boolean isSetChExt() {
        return this.chExt != null;
    }

    public int getRot() {
        Integer num = this.rot;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setRot(int i) {
        this.rot = Integer.valueOf(i);
    }

    public boolean isSetRot() {
        return this.rot != null;
    }

    public void unsetRot() {
        this.rot = null;
    }

    public boolean isFlipH() {
        Boolean bool = this.flipH;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public void setFlipH(boolean z) {
        this.flipH = Boolean.valueOf(z);
    }

    public boolean isSetFlipH() {
        return this.flipH != null;
    }

    public void unsetFlipH() {
        this.flipH = null;
    }

    public boolean isFlipV() {
        Boolean bool = this.flipV;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public void setFlipV(boolean z) {
        this.flipV = Boolean.valueOf(z);
    }

    public boolean isSetFlipV() {
        return this.flipV != null;
    }

    public void unsetFlipV() {
        this.flipV = null;
    }
}
