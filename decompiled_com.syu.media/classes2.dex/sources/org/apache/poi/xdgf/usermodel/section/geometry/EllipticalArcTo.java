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
public class EllipticalArcTo implements GeometryRow {
    public static int draw;
    EllipticalArcTo _master = null;
    Double a;
    Double b;
    Double c;
    Double d;
    Boolean deleted;
    Double x;
    Double y;

    protected static double computeSweep(double d, double d2, double d3) {
        double d4 = (d + 360.0d) % 360.0d;
        double d5 = (d2 + 360.0d) % 360.0d;
        double d6 = (d3 + 360.0d) % 360.0d;
        if (d4 < d5) {
            if (d4 >= d6 || d6 >= d5) {
                return (d4 - d5) + 360.0d;
            }
        } else if (d5 >= d6 || d6 >= d4) {
            return -(360.0d - (d4 - d5));
        }
        return d4 - d5;
    }

    public EllipticalArcTo(RowType rowType) {
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
                throw new POIXMLException("Invalid cell '" + n + "' in EllipticalArcTo row");
            }
        }
    }

    public boolean getDel() {
        Boolean bool = this.deleted;
        if (bool != null) {
            return bool.booleanValue();
        }
        EllipticalArcTo ellipticalArcTo = this._master;
        if (ellipticalArcTo != null) {
            return ellipticalArcTo.getDel();
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
        this._master = (EllipticalArcTo) geometryRow;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow
    public void addToPath(Path2D.Double r14, XDGFShape xDGFShape) {
        if (getDel()) {
            return;
        }
        createEllipticalArc(getX().doubleValue(), getY().doubleValue(), getA().doubleValue(), getB().doubleValue(), getC().doubleValue(), getD().doubleValue(), r14);
    }

    public static void createEllipticalArc(double d, double d2, double d3, double d4, double d5, double d6, Path2D.Double r58) {
        Point2D currentPoint = r58.getCurrentPoint();
        double x = currentPoint.getX();
        double y = currentPoint.getY();
        AffineTransform rotateInstance = AffineTransform.getRotateInstance(-d5);
        double[] dArr = {x, y, d, d2, d3, d4};
        rotateInstance.transform(dArr, 0, dArr, 0, 3);
        double d7 = dArr[0];
        double d8 = dArr[1];
        double d9 = dArr[2];
        double d10 = dArr[3];
        double d11 = dArr[4];
        double d12 = dArr[5];
        double d13 = d6 * d6;
        double d14 = d7 - d9;
        double d15 = d10 - d12;
        double d16 = d9 - d11;
        double d17 = d8 - d10;
        double d18 = ((((d7 + d9) * d14) * d15) - (((d9 + d11) * d16) * d17)) + (d13 * d17 * d15 * (d8 - d12));
        double d19 = d15 * d14;
        double d20 = d17 * d16;
        double d21 = d18 / ((d19 - d20) * 2.0d);
        double d22 = (((((d14 * d16) * (d7 - d11)) / d13) + ((d8 + d10) * d20)) - ((d10 + d12) * d19)) / ((d20 - d19) * 2.0d);
        double d23 = d7 - d21;
        double d24 = d8 - d22;
        double dSqrt = Math.sqrt(Math.pow(d23, 2.0d) + (Math.pow(d24, 2.0d) * d13));
        double d25 = dSqrt / d6;
        double degrees = Math.toDegrees(Math.atan2((d12 - d22) / d25, (d11 - d21) / dSqrt));
        double degrees2 = Math.toDegrees(Math.atan2(d24 / d25, d23 / dSqrt));
        Arc2D.Double r3 = new Arc2D.Double(d21 - dSqrt, d22 - d25, dSqrt * 2.0d, d25 * 2.0d, -degrees2, computeSweep(degrees2, Math.toDegrees(Math.atan2((d10 - d22) / d25, (d9 - d21) / dSqrt)), degrees), 0);
        rotateInstance.setToRotation(d5);
        r58.append(rotateInstance.createTransformedShape(r3), false);
    }
}
