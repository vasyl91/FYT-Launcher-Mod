package org.apache.poi.xdgf.usermodel.section.geometry;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.Path2D;
import org.apache.poi.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RelCubBezTo implements GeometryRow {
    RelCubBezTo _master = null;
    Double a;
    Double b;
    Double c;
    Double d;
    Boolean deleted;
    Double x;
    Double y;

    public RelCubBezTo(RowType rowType) {
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
                throw new POIXMLException("Invalid cell '" + n + "' in RelCubBezTo row");
            }
        }
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        RelCubBezTo relCubBezTo = this._master;
        if (relCubBezTo != null) {
            return relCubBezTo.getDel();
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
        this._master = (RelCubBezTo) geometryRow;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r20, XDGFShape xDGFShape) {
        if (getDel()) {
            return;
        }
        double dDoubleValue = xDGFShape.getWidth().doubleValue();
        double dDoubleValue2 = xDGFShape.getHeight().doubleValue();
        r20.curveTo(getA().doubleValue() * dDoubleValue, getB().doubleValue() * dDoubleValue2, getC().doubleValue() * dDoubleValue, getD().doubleValue() * dDoubleValue2, getX().doubleValue() * dDoubleValue, getY().doubleValue() * dDoubleValue2);
    }
}
