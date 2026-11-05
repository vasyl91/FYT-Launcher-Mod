package org.apache.poi.xdgf.usermodel.section.geometry;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import org.apache.poi.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ArcTo implements GeometryRow {
    ArcTo _master = null;
    Double a;
    Boolean deleted;
    Double x;
    Double y;

    public ArcTo(RowType rowType) {
        this.x = null;
        this.y = null;
        this.a = null;
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
            } else {
                throw new POIXMLException("Invalid cell '" + n + "' in ArcTo row");
            }
        }
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        ArcTo arcTo = this._master;
        if (arcTo != null) {
            return arcTo.getDel();
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

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (ArcTo) geometryRow;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r28, XDGFShape xDGFShape) {
        if (getDel()) {
            return;
        }
        Point2D currentPoint = r28.getCurrentPoint();
        double dDoubleValue = getX().doubleValue();
        double dDoubleValue2 = getY().doubleValue();
        double dDoubleValue3 = getA().doubleValue();
        if (dDoubleValue3 == 0.0d) {
            r28.lineTo(dDoubleValue, dDoubleValue2);
            return;
        }
        double x = currentPoint.getX();
        double y = currentPoint.getY();
        double d = dDoubleValue2 - y;
        double d2 = dDoubleValue - x;
        double dHypot = Math.hypot(d, d2);
        double dAbs = (((4.0d * dDoubleValue3) * dDoubleValue3) + (dHypot * dHypot)) / (Math.abs(dDoubleValue3) * 8.0d);
        r28.append(AffineTransform.getRotateInstance(Math.atan2(dDoubleValue2 - (y + (d / 2.0d)), dDoubleValue - (x + (d2 / 2.0d))), x, y).createTransformedShape(new Arc2D.Double(x, y - dAbs, dHypot, 2.0d * dAbs, 180.0d, x < dDoubleValue ? 180.0d : -180.0d, 0)), true);
    }
}
