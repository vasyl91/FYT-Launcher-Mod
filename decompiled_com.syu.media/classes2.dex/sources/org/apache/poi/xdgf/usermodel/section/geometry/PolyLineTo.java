package org.apache.poi.xdgf.usermodel.section.geometry;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.Path2D;
import org.apache.poi.POIXMLException;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PolyLineTo implements GeometryRow {
    PolyLineTo _master = null;
    String a;
    Boolean deleted;
    Double x;
    Double y;

    public PolyLineTo(RowType rowType) {
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
                this.a = cellType.getV();
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
        PolyLineTo polyLineTo = this._master;
        if (polyLineTo != null) {
            return polyLineTo.getDel();
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

    public String getA() {
        String str = this.a;
        return str == null ? this._master.a : str;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (PolyLineTo) geometryRow;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    @NotImplemented
    public void addToPath(Path2D.Double r1, XDGFShape xDGFShape) {
        if (!getDel()) {
            throw new POIXMLException("Polyline support not implemented");
        }
    }
}
