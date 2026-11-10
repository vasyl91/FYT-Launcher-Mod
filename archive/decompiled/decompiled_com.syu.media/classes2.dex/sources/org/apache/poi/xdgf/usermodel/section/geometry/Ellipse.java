package org.apache.poi.xdgf.usermodel.section.geometry;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import org.apache.poi.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Ellipse implements GeometryRow {
    Ellipse _master = null;
    Double a;
    Double b;
    Double c;
    Double d;
    Boolean deleted;
    Double x;
    Double y;

    public Ellipse(RowType rowType) {
        this.x = null;
        this.y = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.deleted = null;
        if (rowType.isSetDel()) {
            this.deleted = Boolean.valueOf(rowType.getDel());
        }
        for (CellType cellType : rowType.getCellArray()) {
            String n = cellType.getN();
            if (n.equals("X")) {
                this.x = XDGFCell.parseDoubleValue(cellType);
            } else if (n.equals("Y")) {
                this.y = XDGFCell.parseDoubleValue(cellType);
            } else if (n.equals("A")) {
                this.a = XDGFCell.parseDoubleValue(cellType);
            } else if (n.equals("B")) {
                this.b = XDGFCell.parseDoubleValue(cellType);
            } else if (n.equals("C")) {
                this.c = XDGFCell.parseDoubleValue(cellType);
            } else if (n.equals("D")) {
                this.d = XDGFCell.parseDoubleValue(cellType);
            } else {
                throw new POIXMLException("Invalid cell '" + n + "' in Ellipse row");
            }
        }
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        Ellipse ellipse = this._master;
        if (ellipse != null) {
            return ellipse.getDel();
        }
        return false;
    }

    public Double getX() {
        Double d = this.x;
        return d == null ? this._master.x : d;
    }

    public Double getY() {
        Double d = this.y;
        return d == null ? this._master.y : d;
    }

    public Double getA() {
        Double d = this.a;
        return d == null ? this._master.a : d;
    }

    public Double getB() {
        Double d = this.b;
        return d == null ? this._master.b : d;
    }

    public Double getC() {
        Double d = this.c;
        return d == null ? this._master.c : d;
    }

    public Double getD() {
        Double d = this.d;
        return d == null ? this._master.d : d;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (Ellipse) geometryRow;
    }

    public Path2D.Double getPath() {
        if (getDel()) {
            return null;
        }
        double dDoubleValue = getX().doubleValue();
        double dDoubleValue2 = getY().doubleValue();
        double dDoubleValue3 = getA().doubleValue();
        double dDoubleValue4 = getB().doubleValue();
        double dDoubleValue5 = getC().doubleValue();
        double dDoubleValue6 = getD().doubleValue();
        double dHypot = Math.hypot(dDoubleValue3 - dDoubleValue, dDoubleValue4 - dDoubleValue2);
        double dHypot2 = Math.hypot(dDoubleValue5 - dDoubleValue, dDoubleValue6 - dDoubleValue2);
        double dAcos = (((dDoubleValue2 > dDoubleValue4 ? 1.0d : -1.0d) * Math.acos((dDoubleValue - dDoubleValue3) / dHypot)) + 6.283185307179586d) % 6.283185307179586d;
        Path2D.Double r8 = new Path2D.Double(new Ellipse2D.Double(dDoubleValue - dHypot, dDoubleValue2 - dHypot2, dHypot * 2.0d, dHypot2 * 2.0d));
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(dAcos, dDoubleValue, dDoubleValue2);
        r8.transform(affineTransform);
        return r8;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r1, XDGFShape xDGFShape) {
        throw new POIXMLException("Ellipse elements cannot be part of a path");
    }
}
