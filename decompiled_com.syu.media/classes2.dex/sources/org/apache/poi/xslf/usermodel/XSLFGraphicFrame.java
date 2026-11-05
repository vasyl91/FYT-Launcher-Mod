package org.apache.poi.xslf.usermodel;

import java.awt.geom.Rectangle2D;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.sl.usermodel.GraphicalFrame;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFGraphicFrame extends XSLFShape implements GraphicalFrame<XSLFShape, XSLFTextParagraph> {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XSLFGraphicFrame.class);

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public boolean getFlipHorizontal() {
        return false;
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public boolean getFlipVertical() {
        return false;
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public double getRotation() {
        return 0.0d;
    }

    XSLFGraphicFrame(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        super(cTGraphicalObjectFrame, xSLFSheet);
    }

    public ShapeType getShapeType() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.poi.sl.usermodel.Shape, org.apache.poi.sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        CTTransform2D xfrm = getXmlObject().getXfrm();
        CTPoint2D off = xfrm.getOff();
        double points = Units.toPoints(off.getX());
        double points2 = Units.toPoints(off.getY());
        CTPositiveSize2D ext = xfrm.getExt();
        return new Rectangle2D.Double(points, points2, Units.toPoints(ext.getCx()), Units.toPoints(ext.getCy()));
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setAnchor(Rectangle2D rectangle2D) {
        CTTransform2D xfrm = getXmlObject().getXfrm();
        CTPoint2D off = xfrm.isSetOff() ? xfrm.getOff() : xfrm.addNewOff();
        long emu = Units.toEMU(rectangle2D.getX());
        long emu2 = Units.toEMU(rectangle2D.getY());
        off.setX(emu);
        off.setY(emu2);
        CTPositiveSize2D ext = xfrm.isSetExt() ? xfrm.getExt() : xfrm.addNewExt();
        long emu3 = Units.toEMU(rectangle2D.getWidth());
        long emu4 = Units.toEMU(rectangle2D.getHeight());
        ext.setCx(emu3);
        ext.setCy(emu4);
    }

    static XSLFGraphicFrame create(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        if ("http://schemas.openxmlformats.org/drawingml/2006/table".equals(cTGraphicalObjectFrame.getGraphic().getGraphicData().getUri())) {
            return new XSLFTable(cTGraphicalObjectFrame, xSLFSheet);
        }
        return new XSLFGraphicFrame(cTGraphicalObjectFrame, xSLFSheet);
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setRotation(double d) {
        throw new IllegalArgumentException("Operation not supported");
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setFlipHorizontal(boolean z) {
        throw new IllegalArgumentException("Operation not supported");
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setFlipVertical(boolean z) {
        throw new IllegalArgumentException("Operation not supported");
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    void copy(XSLFShape xSLFShape) {
        super.copy(xSLFShape);
        CTGraphicalObjectData graphicData = getXmlObject().getGraphic().getGraphicData();
        if (graphicData.getUri().equals("http://schemas.openxmlformats.org/drawingml/2006/diagram")) {
            copyDiagram(graphicData, (XSLFGraphicFrame) xSLFShape);
        }
    }

    private void copyDiagram(CTGraphicalObjectData cTGraphicalObjectData, XSLFGraphicFrame xSLFGraphicFrame) {
        XmlObject[] xmlObjectArrSelectPath = cTGraphicalObjectData.selectPath("declare namespace dgm='http://schemas.openxmlformats.org/drawingml/2006/diagram' $this//dgm:relIds");
        if (xmlObjectArrSelectPath == null || xmlObjectArrSelectPath.length != 1) {
            return;
        }
        XmlCursor xmlCursorNewCursor = xmlObjectArrSelectPath[0].newCursor();
        XSLFSheet sheet = xSLFGraphicFrame.getSheet();
        try {
            PackageRelationship relationship = sheet.getPackagePart().getRelationship(xmlCursorNewCursor.getAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "dm")));
            getSheet().importPart(relationship, sheet.getPackagePart().getRelatedPart(relationship));
            PackageRelationship relationship2 = sheet.getPackagePart().getRelationship(xmlCursorNewCursor.getAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "lo")));
            getSheet().importPart(relationship2, sheet.getPackagePart().getRelatedPart(relationship2));
            PackageRelationship relationship3 = sheet.getPackagePart().getRelationship(xmlCursorNewCursor.getAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "qs")));
            getSheet().importPart(relationship3, sheet.getPackagePart().getRelatedPart(relationship3));
            PackageRelationship relationship4 = sheet.getPackagePart().getRelationship(xmlCursorNewCursor.getAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "cs")));
            getSheet().importPart(relationship4, sheet.getPackagePart().getRelatedPart(relationship4));
            xmlCursorNewCursor.dispose();
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.sl.usermodel.GraphicalFrame
    public XSLFPictureShape getFallbackPicture() {
        XmlObject xmlObjectSelectProperty = selectProperty(XmlObject.class, "declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main'; declare namespace mc='http://schemas.openxmlformats.org/markup-compatibility/2006' .//mc:Fallback/*/p:pic");
        if (xmlObjectSelectProperty == null) {
            return null;
        }
        try {
            CTGroupShape cTGroupShape = CTGroupShape.Factory.parse(xmlObjectSelectProperty.newDomNode());
            if (cTGroupShape.sizeOfPicArray() == 0) {
                return null;
            }
            return new XSLFPictureShape(cTGroupShape.getPicArray(0), getSheet());
        } catch (XmlException e) {
            LOG.log(5, "Can't parse fallback picture stream of graphical frame", e);
            return null;
        }
    }
}
