package org.apache.poi.xslf.usermodel;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.sl.draw.DrawPictureShape;
import org.apache.poi.sl.usermodel.GroupShape;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFGroupShape extends XSLFShape implements XSLFShapeContainer, GroupShape<XSLFShape, XSLFTextParagraph> {
    private static final POILogger _logger = POILogFactory.getLogger((Class<?>) XSLFGroupShape.class);
    private XSLFDrawing _drawing;
    private final CTGroupShapeProperties _grpSpPr;
    private final List<XSLFShape> _shapes;

    protected XSLFGroupShape(CTGroupShape cTGroupShape, XSLFSheet xSLFSheet) {
        super(cTGroupShape, xSLFSheet);
        this._shapes = XSLFSheet.buildShapes(cTGroupShape, xSLFSheet);
        this._grpSpPr = cTGroupShape.getGrpSpPr();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    protected CTGroupShapeProperties getGrpSpPr() {
        return this._grpSpPr;
    }

    protected CTGroupTransform2D getSafeXfrm() {
        CTGroupTransform2D xfrm = getXfrm();
        return xfrm == null ? getGrpSpPr().addNewXfrm() : xfrm;
    }

    protected CTGroupTransform2D getXfrm() {
        return getGrpSpPr().getXfrm();
    }

    @Override // org.apache.poi.sl.usermodel.Shape, org.apache.poi.sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        CTGroupTransform2D xfrm = getXfrm();
        CTPoint2D off = xfrm.getOff();
        double points = Units.toPoints(off.getX());
        double points2 = Units.toPoints(off.getY());
        CTPositiveSize2D ext = xfrm.getExt();
        return new Rectangle2D.Double(points, points2, Units.toPoints(ext.getCx()), Units.toPoints(ext.getCy()));
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setAnchor(Rectangle2D rectangle2D) {
        CTGroupTransform2D safeXfrm = getSafeXfrm();
        CTPoint2D off = safeXfrm.isSetOff() ? safeXfrm.getOff() : safeXfrm.addNewOff();
        long emu = Units.toEMU(rectangle2D.getX());
        long emu2 = Units.toEMU(rectangle2D.getY());
        off.setX(emu);
        off.setY(emu2);
        CTPositiveSize2D ext = safeXfrm.isSetExt() ? safeXfrm.getExt() : safeXfrm.addNewExt();
        long emu3 = Units.toEMU(rectangle2D.getWidth());
        long emu4 = Units.toEMU(rectangle2D.getHeight());
        ext.setCx(emu3);
        ext.setCy(emu4);
    }

    @Override // org.apache.poi.sl.usermodel.GroupShape
    public Rectangle2D getInteriorAnchor() {
        CTGroupTransform2D xfrm = getXfrm();
        CTPoint2D chOff = xfrm.getChOff();
        double points = Units.toPoints(chOff.getX());
        double points2 = Units.toPoints(chOff.getY());
        CTPositiveSize2D chExt = xfrm.getChExt();
        return new Rectangle2D.Double(points, points2, Units.toPoints(chExt.getCx()), Units.toPoints(chExt.getCy()));
    }

    @Override // org.apache.poi.sl.usermodel.GroupShape
    public void setInteriorAnchor(Rectangle2D rectangle2D) {
        CTGroupTransform2D safeXfrm = getSafeXfrm();
        CTPoint2D chOff = safeXfrm.isSetChOff() ? safeXfrm.getChOff() : safeXfrm.addNewChOff();
        long emu = Units.toEMU(rectangle2D.getX());
        long emu2 = Units.toEMU(rectangle2D.getY());
        chOff.setX(emu);
        chOff.setY(emu2);
        CTPositiveSize2D chExt = safeXfrm.isSetChExt() ? safeXfrm.getChExt() : safeXfrm.addNewChExt();
        long emu3 = Units.toEMU(rectangle2D.getWidth());
        long emu4 = Units.toEMU(rectangle2D.getHeight());
        chExt.setCx(emu3);
        chExt.setCy(emu4);
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public List<XSLFShape> getShapes() {
        return this._shapes;
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFShape> iterator() {
        return this._shapes.iterator();
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public boolean removeShape(XSLFShape xSLFShape) {
        XmlObject xmlObject = xSLFShape.getXmlObject();
        CTGroupShape xmlObject2 = getXmlObject();
        if (xmlObject instanceof CTShape) {
            xmlObject2.getSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTGroupShape) {
            xmlObject2.getGrpSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTConnector) {
            xmlObject2.getCxnSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTGraphicalObjectFrame) {
            xmlObject2.getGraphicFrameList().remove(xmlObject);
        } else if (xmlObject instanceof CTPicture) {
            XSLFPictureShape xSLFPictureShape = (XSLFPictureShape) xSLFShape;
            XSLFSheet sheet = getSheet();
            if (sheet != null) {
                sheet.removePictureRelation(xSLFPictureShape);
            }
            xmlObject2.getPicList().remove(xmlObject);
        } else {
            throw new IllegalArgumentException("Unsupported shape: " + xSLFShape);
        }
        return this._shapes.remove(xSLFShape);
    }

    static CTGroupShape prototype(int i) {
        CTGroupShape cTGroupShapeNewInstance = CTGroupShape.Factory.newInstance();
        CTGroupShapeNonVisual cTGroupShapeNonVisualAddNewNvGrpSpPr = cTGroupShapeNewInstance.addNewNvGrpSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Group " + i);
        cTNonVisualDrawingPropsAddNewCNvPr.setId(i + 1);
        cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewCNvGrpSpPr();
        cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewNvPr();
        cTGroupShapeNewInstance.addNewGrpSpPr();
        return cTGroupShapeNewInstance;
    }

    private XSLFDrawing getDrawing() {
        if (this._drawing == null) {
            this._drawing = new XSLFDrawing(getSheet(), getXmlObject());
        }
        return this._drawing;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFAutoShape createAutoShape() {
        XSLFAutoShape xSLFAutoShapeCreateAutoShape = getDrawing().createAutoShape();
        this._shapes.add(xSLFAutoShapeCreateAutoShape);
        xSLFAutoShapeCreateAutoShape.setParent(this);
        return xSLFAutoShapeCreateAutoShape;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFFreeformShape createFreeform() {
        XSLFFreeformShape xSLFFreeformShapeCreateFreeform = getDrawing().createFreeform();
        this._shapes.add(xSLFFreeformShapeCreateFreeform);
        xSLFFreeformShapeCreateFreeform.setParent(this);
        return xSLFFreeformShapeCreateFreeform;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFTextBox createTextBox() {
        XSLFTextBox xSLFTextBoxCreateTextBox = getDrawing().createTextBox();
        this._shapes.add(xSLFTextBoxCreateTextBox);
        xSLFTextBoxCreateTextBox.setParent(this);
        return xSLFTextBoxCreateTextBox;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFConnectorShape createConnector() {
        XSLFConnectorShape xSLFConnectorShapeCreateConnector = getDrawing().createConnector();
        this._shapes.add(xSLFConnectorShapeCreateConnector);
        xSLFConnectorShapeCreateConnector.setParent(this);
        return xSLFConnectorShapeCreateConnector;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFGroupShape createGroup() {
        XSLFGroupShape xSLFGroupShapeCreateGroup = getDrawing().createGroup();
        this._shapes.add(xSLFGroupShapeCreateGroup);
        xSLFGroupShapeCreateGroup.setParent(this);
        return xSLFGroupShapeCreateGroup;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFPictureShape createPicture(PictureData pictureData) {
        if (!(pictureData instanceof XSLFPictureData)) {
            throw new IllegalArgumentException("pictureData needs to be of type XSLFPictureData");
        }
        XSLFPictureShape xSLFPictureShapeCreatePicture = getDrawing().createPicture(getSheet().getPackagePart().addRelationship(((XSLFPictureData) pictureData).getPackagePart().getPartName(), TargetMode.INTERNAL, XSLFRelation.IMAGES.getRelation()).getId());
        new DrawPictureShape(xSLFPictureShapeCreatePicture).resize();
        this._shapes.add(xSLFPictureShapeCreatePicture);
        xSLFPictureShapeCreatePicture.setParent(this);
        return xSLFPictureShapeCreatePicture;
    }

    public XSLFTable createTable() {
        XSLFTable xSLFTableCreateTable = getDrawing().createTable();
        this._shapes.add(xSLFTableCreateTable);
        xSLFTableCreateTable.setParent(this);
        return xSLFTableCreateTable;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFTable createTable(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("numRows and numCols must be greater than 0");
        }
        XSLFTable xSLFTableCreateTable = getDrawing().createTable();
        this._shapes.add(xSLFTableCreateTable);
        xSLFTableCreateTable.setParent(this);
        for (int i3 = 0; i3 < i; i3++) {
            XSLFTableRow xSLFTableRowAddRow = xSLFTableCreateTable.addRow();
            for (int i4 = 0; i4 < i2; i4++) {
                xSLFTableRowAddRow.addCell();
            }
        }
        return xSLFTableCreateTable;
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setFlipHorizontal(boolean z) {
        getSafeXfrm().setFlipH(z);
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setFlipVertical(boolean z) {
        getSafeXfrm().setFlipV(z);
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public boolean getFlipHorizontal() {
        CTGroupTransform2D xfrm = getXfrm();
        return xfrm != null && xfrm.isSetFlipH() && xfrm.getFlipH();
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public boolean getFlipVertical() {
        CTGroupTransform2D xfrm = getXfrm();
        return xfrm != null && xfrm.isSetFlipV() && xfrm.getFlipV();
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setRotation(double d) {
        getSafeXfrm().setRot((int) (d * 60000.0d));
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public double getRotation() {
        CTGroupTransform2D xfrm = getXfrm();
        if (xfrm == null || !xfrm.isSetRot()) {
            return 0.0d;
        }
        return ((double) xfrm.getRot()) / 60000.0d;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    void copy(XSLFShape xSLFShape) {
        XSLFShape xSLFShapeCreateTextBox;
        List<XSLFShape> shapes = getShapes();
        List<XSLFShape> shapes2 = ((XSLFGroupShape) xSLFShape).getShapes();
        if (shapes.size() == shapes2.size()) {
            for (int i = 0; i < shapes.size(); i++) {
                shapes.get(i).copy(shapes2.get(i));
            }
            return;
        }
        clear();
        for (XSLFShape xSLFShape2 : shapes2) {
            if (xSLFShape2 instanceof XSLFTextBox) {
                xSLFShapeCreateTextBox = createTextBox();
            } else if (xSLFShape2 instanceof XSLFAutoShape) {
                xSLFShapeCreateTextBox = createAutoShape();
            } else if (xSLFShape2 instanceof XSLFConnectorShape) {
                xSLFShapeCreateTextBox = createConnector();
            } else if (xSLFShape2 instanceof XSLFFreeformShape) {
                xSLFShapeCreateTextBox = createFreeform();
            } else if (xSLFShape2 instanceof XSLFPictureShape) {
                XSLFPictureData pictureData = ((XSLFPictureShape) xSLFShape2).getPictureData();
                xSLFShapeCreateTextBox = createPicture((PictureData) getSheet().getSlideShow().addPicture(pictureData.getData(), pictureData.getType()));
            } else if (xSLFShape2 instanceof XSLFGroupShape) {
                xSLFShapeCreateTextBox = createGroup();
            } else if (xSLFShape2 instanceof XSLFTable) {
                xSLFShapeCreateTextBox = createTable();
            } else {
                _logger.log(5, "copying of class " + xSLFShape2.getClass() + " not supported.");
            }
            xSLFShapeCreateTextBox.copy(xSLFShape2);
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public void clear() {
        Iterator it = new ArrayList(getShapes()).iterator();
        while (it.hasNext()) {
            removeShape((XSLFShape) it.next());
        }
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public void addShape(XSLFShape xSLFShape) {
        throw new UnsupportedOperationException("Adding a shape from a different container is not supported - create it from scratch with XSLFGroupShape.create* methods");
    }
}
