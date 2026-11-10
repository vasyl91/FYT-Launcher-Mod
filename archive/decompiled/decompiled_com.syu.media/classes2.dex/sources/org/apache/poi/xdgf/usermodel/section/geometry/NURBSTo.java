package org.apache.poi.xdgf.usermodel.section.geometry;

import com.graphbuilder.curve.ControlPath;
import com.graphbuilder.curve.ValueVector;
import com.graphbuilder.geom.PointFactory;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import org.apache.poi.POIXMLException;
import org.apache.poi.xdgf.geom.SplineRenderer;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class NURBSTo implements GeometryRow {
    NURBSTo _master = null;
    Double a;
    Double b;
    Double c;
    Double d;
    Boolean deleted;
    String e;
    Double x;
    Double y;

    public NURBSTo(RowType rowType) {
        this.x = null;
        this.y = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
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
            } else if (n.equals("E")) {
                this.e = cellType.getV();
            } else {
                throw new POIXMLException("Invalid cell '" + n + "' in NURBS row");
            }
        }
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        NURBSTo nURBSTo = this._master;
        if (nURBSTo != null) {
            return nURBSTo.getDel();
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

    public String getE() {
        String str = this.e;
        return str == null ? this._master.e : str;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void setupMaster(GeometryRow geometryRow) {
        this._master = (NURBSTo) geometryRow;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r34, XDGFShape xDGFShape) {
        if (getDel()) {
            return;
        }
        Point2D currentPoint = r34.getCurrentPoint();
        String strTrim = getE().trim();
        if (!strTrim.startsWith("NURBS(") || !strTrim.endsWith(")")) {
            throw new POIXMLException("Invalid NURBS formula: " + strTrim);
        }
        String[] strArrSplit = strTrim.substring(6, strTrim.length() - 1).split(",");
        if (strArrSplit.length < 8) {
            throw new POIXMLException("Invalid NURBS formula (not enough arguments)");
        }
        if ((strArrSplit.length - 4) % 4 != 0) {
            throw new POIXMLException("Invalid NURBS formula -- need 4 + n*4 arguments, got " + strArrSplit.length);
        }
        double dDoubleValue = getX().doubleValue();
        double dDoubleValue2 = getY().doubleValue();
        double dDoubleValue3 = getA().doubleValue();
        double dDoubleValue4 = getB().doubleValue();
        double dDoubleValue5 = getC().doubleValue();
        double dDoubleValue6 = getD().doubleValue();
        double d = Double.parseDouble(strArrSplit[0].trim());
        int i = Integer.parseInt(strArrSplit[1].trim());
        int i2 = Integer.parseInt(strArrSplit[2].trim());
        int i3 = Integer.parseInt(strArrSplit[3].trim());
        double dDoubleValue7 = i2 == 0 ? xDGFShape.getWidth().doubleValue() : 1.0d;
        double dDoubleValue8 = i3 == 0 ? xDGFShape.getHeight().doubleValue() : 1.0d;
        ControlPath controlPath = new ControlPath();
        ValueVector valueVector = new ValueVector();
        ValueVector valueVector2 = new ValueVector();
        valueVector.add(dDoubleValue5);
        valueVector2.add(dDoubleValue6);
        controlPath.addPoint(PointFactory.create(currentPoint.getX(), currentPoint.getY()));
        int length = (strArrSplit.length - 4) / 4;
        int i4 = 0;
        while (i4 < length) {
            int i5 = (i4 * 4) + 4;
            double d2 = Double.parseDouble(strArrSplit[i5 + 0].trim());
            double d3 = Double.parseDouble(strArrSplit[i5 + 1].trim());
            double d4 = dDoubleValue4;
            double d5 = Double.parseDouble(strArrSplit[i5 + 2].trim());
            int i6 = length;
            double d6 = Double.parseDouble(strArrSplit[i5 + 3].trim());
            controlPath.addPoint(PointFactory.create(d2 * dDoubleValue7, d3 * dDoubleValue8));
            valueVector.add(d5);
            valueVector2.add(d6);
            i4++;
            length = i6;
            strArrSplit = strArrSplit;
            dDoubleValue4 = d4;
            d = d;
        }
        valueVector.add(dDoubleValue3);
        valueVector.add(d);
        valueVector2.add(dDoubleValue4);
        controlPath.addPoint(PointFactory.create(dDoubleValue, dDoubleValue2));
        r34.append(SplineRenderer.createNurbsSpline(controlPath, valueVector, valueVector2, i), true);
    }
}
