package org.apache.poi.xssf.usermodel;

import java.util.Iterator;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.ss.usermodel.ShapeContainer;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFShapeGroup extends XSSFShape implements ShapeContainer<XSSFShape> {
    private static CTGroupShape prototype;
    private CTGroupShape ctGroup;

    protected XSSFShapeGroup(XSSFDrawing xSSFDrawing, CTGroupShape cTGroupShape) {
        this.drawing = xSSFDrawing;
        this.ctGroup = cTGroupShape;
    }

    protected static CTGroupShape prototype() {
        if (prototype == null) {
            CTGroupShape cTGroupShapeNewInstance = CTGroupShape.Factory.newInstance();
            CTGroupShapeNonVisual cTGroupShapeNonVisualAddNewNvGrpSpPr = cTGroupShapeNewInstance.addNewNvGrpSpPr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr.setId(0L);
            cTNonVisualDrawingPropsAddNewCNvPr.setName("Group 0");
            cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewCNvGrpSpPr();
            CTGroupTransform2D cTGroupTransform2DAddNewXfrm = cTGroupShapeNewInstance.addNewGrpSpPr().addNewXfrm();
            CTPositiveSize2D cTPositiveSize2DAddNewExt = cTGroupTransform2DAddNewXfrm.addNewExt();
            cTPositiveSize2DAddNewExt.setCx(0L);
            cTPositiveSize2DAddNewExt.setCy(0L);
            CTPoint2D cTPoint2DAddNewOff = cTGroupTransform2DAddNewXfrm.addNewOff();
            cTPoint2DAddNewOff.setX(0L);
            cTPoint2DAddNewOff.setY(0L);
            CTPositiveSize2D cTPositiveSize2DAddNewChExt = cTGroupTransform2DAddNewXfrm.addNewChExt();
            cTPositiveSize2DAddNewChExt.setCx(0L);
            cTPositiveSize2DAddNewChExt.setCy(0L);
            CTPoint2D cTPoint2DAddNewChOff = cTGroupTransform2DAddNewXfrm.addNewChOff();
            cTPoint2DAddNewChOff.setX(0L);
            cTPoint2DAddNewChOff.setY(0L);
            prototype = cTGroupShapeNewInstance;
        }
        return prototype;
    }

    public XSSFTextBox createTextbox(XSSFChildAnchor xSSFChildAnchor) {
        CTShape cTShapeAddNewSp = this.ctGroup.addNewSp();
        cTShapeAddNewSp.set(XSSFSimpleShape.prototype());
        XSSFTextBox xSSFTextBox = new XSSFTextBox(getDrawing(), cTShapeAddNewSp);
        xSSFTextBox.parent = this;
        xSSFTextBox.anchor = xSSFChildAnchor;
        xSSFTextBox.getCTShape().getSpPr().setXfrm(xSSFChildAnchor.getCTTransform2D());
        return xSSFTextBox;
    }

    public XSSFSimpleShape createSimpleShape(XSSFChildAnchor xSSFChildAnchor) {
        CTShape cTShapeAddNewSp = this.ctGroup.addNewSp();
        cTShapeAddNewSp.set(XSSFSimpleShape.prototype());
        XSSFSimpleShape xSSFSimpleShape = new XSSFSimpleShape(getDrawing(), cTShapeAddNewSp);
        xSSFSimpleShape.parent = this;
        xSSFSimpleShape.anchor = xSSFChildAnchor;
        xSSFSimpleShape.getCTShape().getSpPr().setXfrm(xSSFChildAnchor.getCTTransform2D());
        return xSSFSimpleShape;
    }

    public XSSFConnector createConnector(XSSFChildAnchor xSSFChildAnchor) {
        CTConnector cTConnectorAddNewCxnSp = this.ctGroup.addNewCxnSp();
        cTConnectorAddNewCxnSp.set(XSSFConnector.prototype());
        XSSFConnector xSSFConnector = new XSSFConnector(getDrawing(), cTConnectorAddNewCxnSp);
        xSSFConnector.parent = this;
        xSSFConnector.anchor = xSSFChildAnchor;
        xSSFConnector.getCTConnector().getSpPr().setXfrm(xSSFChildAnchor.getCTTransform2D());
        return xSSFConnector;
    }

    public XSSFPicture createPicture(XSSFClientAnchor xSSFClientAnchor, int i) {
        PackageRelationship packageRelationshipAddPictureReference = getDrawing().addPictureReference(i);
        CTPicture cTPictureAddNewPic = this.ctGroup.addNewPic();
        cTPictureAddNewPic.set(XSSFPicture.prototype());
        XSSFPicture xSSFPicture = new XSSFPicture(getDrawing(), cTPictureAddNewPic);
        xSSFPicture.parent = this;
        xSSFPicture.anchor = xSSFClientAnchor;
        xSSFPicture.setPictureReference(packageRelationshipAddPictureReference);
        return xSSFPicture;
    }

    public XSSFShapeGroup createGroup(XSSFChildAnchor xSSFChildAnchor) {
        CTGroupShape cTGroupShapeAddNewGrpSp = this.ctGroup.addNewGrpSp();
        cTGroupShapeAddNewGrpSp.set(prototype());
        XSSFShapeGroup xSSFShapeGroup = new XSSFShapeGroup(getDrawing(), cTGroupShapeAddNewGrpSp);
        xSSFShapeGroup.parent = this;
        xSSFShapeGroup.anchor = xSSFChildAnchor;
        CTGroupTransform2D xfrm = xSSFShapeGroup.getCTGroupShape().getGrpSpPr().getXfrm();
        CTTransform2D cTTransform2D = xSSFChildAnchor.getCTTransform2D();
        xfrm.setOff(cTTransform2D.getOff());
        xfrm.setExt(cTTransform2D.getExt());
        xfrm.setChExt(cTTransform2D.getExt());
        xfrm.setFlipH(cTTransform2D.getFlipH());
        xfrm.setFlipV(cTTransform2D.getFlipV());
        return xSSFShapeGroup;
    }

    @Internal
    public CTGroupShape getCTGroupShape() {
        return this.ctGroup;
    }

    public void setCoordinates(int i, int i2, int i3, int i4) {
        CTGroupTransform2D xfrm = this.ctGroup.getGrpSpPr().getXfrm();
        CTPoint2D off = xfrm.getOff();
        long j = i;
        off.setX(j);
        long j2 = i2;
        off.setY(j2);
        CTPositiveSize2D ext = xfrm.getExt();
        long j3 = i3;
        ext.setCx(j3);
        long j4 = i4;
        ext.setCy(j4);
        CTPoint2D chOff = xfrm.getChOff();
        chOff.setX(j);
        chOff.setY(j2);
        CTPositiveSize2D chExt = xfrm.getChExt();
        chExt.setCx(j3);
        chExt.setCy(j4);
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFShape
    protected CTShapeProperties getShapeProperties() {
        throw new IllegalStateException("Not supported for shape group");
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFShape> iterator() {
        return getDrawing().getShapes(this).iterator();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public String getShapeName() {
        return this.ctGroup.getNvGrpSpPr().getCNvPr().getName();
    }
}
