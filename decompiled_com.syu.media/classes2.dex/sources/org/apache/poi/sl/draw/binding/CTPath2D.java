package org.apache.poi.sl.draw.binding;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Path2D", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {"closeOrMoveToOrLnTo"})
public class CTPath2D {

    @XmlElements({@XmlElement(name = "lnTo", namespace = XSSFRelation.NS_DRAWINGML, type = CTPath2DLineTo.class), @XmlElement(name = "close", namespace = XSSFRelation.NS_DRAWINGML, type = CTPath2DClose.class), @XmlElement(name = "cubicBezTo", namespace = XSSFRelation.NS_DRAWINGML, type = CTPath2DCubicBezierTo.class), @XmlElement(name = "quadBezTo", namespace = XSSFRelation.NS_DRAWINGML, type = CTPath2DQuadBezierTo.class), @XmlElement(name = "arcTo", namespace = XSSFRelation.NS_DRAWINGML, type = CTPath2DArcTo.class), @XmlElement(name = "moveTo", namespace = XSSFRelation.NS_DRAWINGML, type = CTPath2DMoveTo.class)})
    protected List<Object> closeOrMoveToOrLnTo;

    @XmlAttribute
    protected Boolean extrusionOk;

    @XmlAttribute
    protected STPathFillMode fill;

    @XmlAttribute
    protected Long h;

    @XmlAttribute
    protected Boolean stroke;

    @XmlAttribute
    protected Long w;

    public List<Object> getCloseOrMoveToOrLnTo() {
        if (this.closeOrMoveToOrLnTo == null) {
            this.closeOrMoveToOrLnTo = new ArrayList();
        }
        return this.closeOrMoveToOrLnTo;
    }

    public boolean isSetCloseOrMoveToOrLnTo() {
        List<Object> list = this.closeOrMoveToOrLnTo;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void unsetCloseOrMoveToOrLnTo() {
        this.closeOrMoveToOrLnTo = null;
    }

    public long getW() {
        Long l = this.w;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public void setW(long j) {
        this.w = Long.valueOf(j);
    }

    public boolean isSetW() {
        return this.w != null;
    }

    public void unsetW() {
        this.w = null;
    }

    public long getH() {
        Long l = this.h;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public void setH(long j) {
        this.h = Long.valueOf(j);
    }

    public boolean isSetH() {
        return this.h != null;
    }

    public void unsetH() {
        this.h = null;
    }

    public STPathFillMode getFill() {
        STPathFillMode sTPathFillMode = this.fill;
        return sTPathFillMode == null ? STPathFillMode.NORM : sTPathFillMode;
    }

    public void setFill(STPathFillMode sTPathFillMode) {
        this.fill = sTPathFillMode;
    }

    public boolean isSetFill() {
        return this.fill != null;
    }

    public boolean isStroke() {
        Boolean bool = this.stroke;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void setStroke(boolean z) {
        this.stroke = Boolean.valueOf(z);
    }

    public boolean isSetStroke() {
        return this.stroke != null;
    }

    public void unsetStroke() {
        this.stroke = null;
    }

    public boolean isExtrusionOk() {
        Boolean bool = this.extrusionOk;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void setExtrusionOk(boolean z) {
        this.extrusionOk = Boolean.valueOf(z);
    }

    public boolean isSetExtrusionOk() {
        return this.extrusionOk != null;
    }

    public void unsetExtrusionOk() {
        this.extrusionOk = null;
    }
}
