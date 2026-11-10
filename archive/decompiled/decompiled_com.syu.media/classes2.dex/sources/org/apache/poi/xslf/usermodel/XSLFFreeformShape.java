package org.apache.poi.xslf.usermodel;

import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.usermodel.FreeformShape;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DClose;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFFreeformShape extends XSLFAutoShape implements FreeformShape<XSLFShape, XSLFTextParagraph> {
    XSLFFreeformShape(CTShape cTShape, XSLFSheet xSLFSheet) {
        super(cTShape, xSLFSheet);
    }

    @Override // org.apache.poi.sl.usermodel.FreeformShape
    public int setPath(Path2D.Double r17) {
        CTPath2D cTPath2DNewInstance = CTPath2D.Factory.newInstance();
        Rectangle2D bounds2D = r17.getBounds2D();
        int emu = Units.toEMU(bounds2D.getX());
        int emu2 = Units.toEMU(bounds2D.getY());
        PathIterator pathIterator = r17.getPathIterator(new AffineTransform());
        cTPath2DNewInstance.setH(Units.toEMU(bounds2D.getHeight()));
        cTPath2DNewInstance.setW(Units.toEMU(bounds2D.getWidth()));
        int i = 0;
        while (!pathIterator.isDone()) {
            double[] dArr = new double[6];
            int iCurrentSegment = pathIterator.currentSegment(dArr);
            if (iCurrentSegment == 0) {
                CTAdjPoint2D cTAdjPoint2DAddNewPt = cTPath2DNewInstance.addNewMoveTo().addNewPt();
                cTAdjPoint2DAddNewPt.setX(Integer.valueOf(Units.toEMU(dArr[0]) - emu));
                cTAdjPoint2DAddNewPt.setY(Integer.valueOf(Units.toEMU(dArr[1]) - emu2));
            } else {
                if (iCurrentSegment == 1) {
                    CTAdjPoint2D cTAdjPoint2DAddNewPt2 = cTPath2DNewInstance.addNewLnTo().addNewPt();
                    cTAdjPoint2DAddNewPt2.setX(Integer.valueOf(Units.toEMU(dArr[0]) - emu));
                    cTAdjPoint2DAddNewPt2.setY(Integer.valueOf(Units.toEMU(dArr[1]) - emu2));
                } else if (iCurrentSegment == 2) {
                    CTPath2DQuadBezierTo cTPath2DQuadBezierToAddNewQuadBezTo = cTPath2DNewInstance.addNewQuadBezTo();
                    CTAdjPoint2D cTAdjPoint2DAddNewPt3 = cTPath2DQuadBezierToAddNewQuadBezTo.addNewPt();
                    cTAdjPoint2DAddNewPt3.setX(Integer.valueOf(Units.toEMU(dArr[0]) - emu));
                    cTAdjPoint2DAddNewPt3.setY(Integer.valueOf(Units.toEMU(dArr[1]) - emu2));
                    CTAdjPoint2D cTAdjPoint2DAddNewPt4 = cTPath2DQuadBezierToAddNewQuadBezTo.addNewPt();
                    cTAdjPoint2DAddNewPt4.setX(Integer.valueOf(Units.toEMU(dArr[2]) - emu));
                    cTAdjPoint2DAddNewPt4.setY(Integer.valueOf(Units.toEMU(dArr[3]) - emu2));
                    i += 2;
                } else if (iCurrentSegment == 3) {
                    CTPath2DCubicBezierTo cTPath2DCubicBezierToAddNewCubicBezTo = cTPath2DNewInstance.addNewCubicBezTo();
                    CTAdjPoint2D cTAdjPoint2DAddNewPt5 = cTPath2DCubicBezierToAddNewCubicBezTo.addNewPt();
                    cTAdjPoint2DAddNewPt5.setX(Integer.valueOf(Units.toEMU(dArr[0]) - emu));
                    cTAdjPoint2DAddNewPt5.setY(Integer.valueOf(Units.toEMU(dArr[1]) - emu2));
                    CTAdjPoint2D cTAdjPoint2DAddNewPt6 = cTPath2DCubicBezierToAddNewCubicBezTo.addNewPt();
                    cTAdjPoint2DAddNewPt6.setX(Integer.valueOf(Units.toEMU(dArr[2]) - emu));
                    cTAdjPoint2DAddNewPt6.setY(Integer.valueOf(Units.toEMU(dArr[3]) - emu2));
                    CTAdjPoint2D cTAdjPoint2DAddNewPt7 = cTPath2DCubicBezierToAddNewCubicBezTo.addNewPt();
                    cTAdjPoint2DAddNewPt7.setX(Integer.valueOf(Units.toEMU(dArr[4]) - emu));
                    cTAdjPoint2DAddNewPt7.setY(Integer.valueOf(Units.toEMU(dArr[5]) - emu2));
                    i += 3;
                } else if (iCurrentSegment == 4) {
                    i++;
                    cTPath2DNewInstance.addNewClose();
                } else {
                    throw new IllegalStateException("Unrecognized path segment type: " + iCurrentSegment);
                }
                pathIterator.next();
            }
            i++;
            pathIterator.next();
        }
        CTShapeProperties shapeProperties = getShapeProperties();
        if (!(shapeProperties instanceof CTShapeProperties)) {
            return -1;
        }
        shapeProperties.getCustGeom().getPathLst().setPathArray(new CTPath2D[]{cTPath2DNewInstance});
        setAnchor(bounds2D);
        return i;
    }

    @Override // org.apache.poi.sl.usermodel.FreeformShape
    public Path2D.Double getPath() {
        Path2D.Double r22;
        int i;
        int i2;
        int i3;
        Path2D.Double r13 = new Path2D.Double();
        Rectangle2D anchor = getAnchor();
        CTShapeProperties shapeProperties = getShapeProperties();
        if (!(shapeProperties instanceof CTShapeProperties)) {
            return null;
        }
        CTPath2D[] pathArray = shapeProperties.getCustGeom().getPathLst().getPathArray();
        int length = pathArray.length;
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            CTPath2D cTPath2D = pathArray[i5];
            double width = anchor.getWidth() / Units.toPoints(cTPath2D.getW());
            double height = anchor.getHeight() / Units.toPoints(cTPath2D.getH());
            CTPath2DMoveTo[] cTPath2DMoveToArrSelectPath = cTPath2D.selectPath("*");
            int length2 = cTPath2DMoveToArrSelectPath.length;
            int i6 = i4;
            while (i6 < length2) {
                CTPath2DMoveTo cTPath2DMoveTo = cTPath2DMoveToArrSelectPath[i6];
                if (cTPath2DMoveTo instanceof CTPath2DMoveTo) {
                    CTAdjPoint2D pt = cTPath2DMoveTo.getPt();
                    r13.moveTo((float) (Units.toPoints(((Long) pt.getX()).longValue()) * width), (float) (Units.toPoints(((Long) pt.getY()).longValue()) * height));
                } else {
                    if (cTPath2DMoveTo instanceof CTPath2DLineTo) {
                        CTAdjPoint2D pt2 = ((CTPath2DLineTo) cTPath2DMoveTo).getPt();
                        r13.lineTo((float) Units.toPoints(((Long) pt2.getX()).longValue()), (float) Units.toPoints(((Long) pt2.getY()).longValue()));
                    } else if (cTPath2DMoveTo instanceof CTPath2DQuadBezierTo) {
                        CTPath2DQuadBezierTo cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo) cTPath2DMoveTo;
                        CTAdjPoint2D ptArray = cTPath2DQuadBezierTo.getPtArray(i4);
                        CTAdjPoint2D ptArray2 = cTPath2DQuadBezierTo.getPtArray(1);
                        r22 = r13;
                        r22.quadTo((float) (Units.toPoints(((Long) ptArray.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray.getY()).longValue()) * height), (float) (Units.toPoints(((Long) ptArray2.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray2.getY()).longValue()) * height));
                        i = length2;
                        i2 = 0;
                        i3 = length;
                    } else {
                        i6 = i6;
                        r22 = r13;
                        int i7 = length2;
                        if (cTPath2DMoveTo instanceof CTPath2DCubicBezierTo) {
                            CTPath2DCubicBezierTo cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo) cTPath2DMoveTo;
                            CTAdjPoint2D ptArray3 = cTPath2DCubicBezierTo.getPtArray(0);
                            CTAdjPoint2D ptArray4 = cTPath2DCubicBezierTo.getPtArray(1);
                            CTAdjPoint2D ptArray5 = cTPath2DCubicBezierTo.getPtArray(2);
                            i = i7;
                            i5 = i5;
                            cTPath2DMoveToArrSelectPath = cTPath2DMoveToArrSelectPath;
                            i3 = length;
                            i2 = 0;
                            r22.curveTo((float) (Units.toPoints(((Long) ptArray3.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray3.getY()).longValue()) * height), (float) (Units.toPoints(((Long) ptArray4.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray4.getY()).longValue()) * height), (float) (Units.toPoints(((Long) ptArray5.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray5.getY()).longValue()) * height));
                        } else {
                            i5 = i5;
                            cTPath2DMoveToArrSelectPath = cTPath2DMoveToArrSelectPath;
                            i = i7;
                            i2 = 0;
                            i3 = length;
                            if (cTPath2DMoveTo instanceof CTPath2DClose) {
                                r22.closePath();
                            }
                        }
                    }
                    i6++;
                    length = i3;
                    i5 = i5;
                    cTPath2DMoveToArrSelectPath = cTPath2DMoveToArrSelectPath;
                    r13 = r22;
                    length2 = i;
                    i4 = i2;
                }
                i = length2;
                i2 = i4;
                r22 = r13;
                i3 = length;
                i6++;
                length = i3;
                i5 = i5;
                cTPath2DMoveToArrSelectPath = cTPath2DMoveToArrSelectPath;
                r13 = r22;
                length2 = i;
                i4 = i2;
            }
            i5++;
            r13 = r13;
        }
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(anchor.getX(), anchor.getY());
        return new Path2D.Double(affineTransform.createTransformedShape(r13));
    }

    static CTShape prototype(int i) {
        CTShape cTShapeNewInstance = CTShape.Factory.newInstance();
        CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTShapeNonVisualAddNewNvSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Freeform " + i);
        cTNonVisualDrawingPropsAddNewCNvPr.setId(i + 1);
        cTShapeNonVisualAddNewNvSpPr.addNewCNvSpPr();
        cTShapeNonVisualAddNewNvSpPr.addNewNvPr();
        CTCustomGeometry2D cTCustomGeometry2DAddNewCustGeom = cTShapeNewInstance.addNewSpPr().addNewCustGeom();
        cTCustomGeometry2DAddNewCustGeom.addNewAvLst();
        cTCustomGeometry2DAddNewCustGeom.addNewGdLst();
        cTCustomGeometry2DAddNewCustGeom.addNewAhLst();
        cTCustomGeometry2DAddNewCustGeom.addNewCxnLst();
        CTGeomRect cTGeomRectAddNewRect = cTCustomGeometry2DAddNewCustGeom.addNewRect();
        cTGeomRectAddNewRect.setR("r");
        cTGeomRectAddNewRect.setB("b");
        cTGeomRectAddNewRect.setT("t");
        cTGeomRectAddNewRect.setL("l");
        cTCustomGeometry2DAddNewCustGeom.addNewPathLst();
        return cTShapeNewInstance;
    }
}
