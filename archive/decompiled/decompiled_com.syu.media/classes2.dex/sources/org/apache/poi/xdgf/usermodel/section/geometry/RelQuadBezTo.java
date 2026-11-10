package org.apache.poi.xdgf.usermodel.section.geometry;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.Path2D;
import org.apache.poi.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RelQuadBezTo implements GeometryRow {
    RelQuadBezTo _master = null;
    Double a;
    Double b;
    Boolean deleted;
    Double x;
    Double y;

    public RelQuadBezTo(RowType rowType) {
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
                throw new POIXMLException("Invalid cell '" + n + "' in RelQuadBezTo row");
            }
        }
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        RelQuadBezTo relQuadBezTo = this._master;
        if (relQuadBezTo != null) {
            return relQuadBezTo.getDel();
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
        this._master = (RelQuadBezTo) geometryRow;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r16, XDGFShape xDGFShape) {
        if (getDel()) {
            return;
        }
        double dDoubleValue = xDGFShape.getWidth().doubleValue();
        double dDoubleValue2 = xDGFShape.getHeight().doubleValue();
        r16.quadTo(getA().doubleValue() * dDoubleValue, getB().doubleValue() * dDoubleValue2, getX().doubleValue() * dDoubleValue, getY().doubleValue() * dDoubleValue2);
    }
}
