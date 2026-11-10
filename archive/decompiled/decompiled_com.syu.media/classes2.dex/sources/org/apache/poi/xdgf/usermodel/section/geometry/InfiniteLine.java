package org.apache.poi.xdgf.usermodel.section.geometry;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.Path2D;
import org.apache.poi.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class InfiniteLine implements GeometryRow {
    InfiniteLine _master = null;
    Double a;
    Double b;
    Boolean deleted;
    Double x;
    Double y;

    public InfiniteLine(RowType rowType) {
        this.x = null;
        this.y = null;
        this.a = null;
        this.b = null;
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
            } else {
                throw new POIXMLException("Invalid cell '" + n + "' in InfiniteLine row");
            }
        }
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        InfiniteLine infiniteLine = this._master;
        if (infiniteLine != null) {
            return infiniteLine.getDel();
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

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (InfiniteLine) geometryRow;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r1, XDGFShape xDGFShape) {
        if (!getDel()) {
            throw new POIXMLException("InfiniteLine elements cannot be part of a path");
        }
    }

    public Path2D.Double getPath() {
        Path2D.Double r0 = new Path2D.Double();
        double dDoubleValue = getX().doubleValue();
        double dDoubleValue2 = getY().doubleValue();
        double dDoubleValue3 = getA().doubleValue();
        double dDoubleValue4 = getB().doubleValue();
        if (dDoubleValue == dDoubleValue3) {
            r0.moveTo(dDoubleValue, -100000.0d);
            r0.lineTo(dDoubleValue, 100000.0d);
        } else if (dDoubleValue2 == dDoubleValue4) {
            r0.moveTo(-100000.0d, dDoubleValue2);
            r0.lineTo(100000.0d, dDoubleValue2);
        } else {
            double d = (dDoubleValue4 - dDoubleValue2) / (dDoubleValue3 - dDoubleValue);
            double d2 = dDoubleValue2 - (dDoubleValue * d);
            r0.moveTo(100000.0d, (d * 100000.0d) + d2);
            r0.lineTo(100000.0d, (100000.0d - d2) / d);
        }
        return r0;
    }
}
