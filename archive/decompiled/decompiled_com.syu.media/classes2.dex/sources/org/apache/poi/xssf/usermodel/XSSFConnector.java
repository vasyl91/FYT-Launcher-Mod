package org.apache.poi.xssf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STFontCollectionIndex;
import org.openxmlformats.schemas.drawingml.x2006.main.STSchemeColorVal;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnectorNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFConnector extends XSSFShape {
    private static CTConnector prototype;
    private CTConnector ctShape;

    protected XSSFConnector(XSSFDrawing xSSFDrawing, CTConnector cTConnector) {
        this.drawing = xSSFDrawing;
        this.ctShape = cTConnector;
    }

    protected static CTConnector prototype() {
        if (prototype == null) {
            CTConnector cTConnectorNewInstance = CTConnector.Factory.newInstance();
            CTConnectorNonVisual cTConnectorNonVisualAddNewNvCxnSpPr = cTConnectorNewInstance.addNewNvCxnSpPr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTConnectorNonVisualAddNewNvCxnSpPr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr.setId(1L);
            cTNonVisualDrawingPropsAddNewCNvPr.setName("Shape 1");
            cTConnectorNonVisualAddNewNvCxnSpPr.addNewCNvCxnSpPr();
            CTShapeProperties cTShapePropertiesAddNewSpPr = cTConnectorNewInstance.addNewSpPr();
            CTTransform2D cTTransform2DAddNewXfrm = cTShapePropertiesAddNewSpPr.addNewXfrm();
            CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
            cTPositiveSize2DAddNewExt.setCx(0L);
            cTPositiveSize2DAddNewExt.setCy(0L);
            CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
            cTPoint2DAddNewOff.setX(0L);
            cTPoint2DAddNewOff.setY(0L);
            CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapePropertiesAddNewSpPr.addNewPrstGeom();
            cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.LINE);
            cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
            CTShapeStyle cTShapeStyleAddNewStyle = cTConnectorNewInstance.addNewStyle();
            cTShapeStyleAddNewStyle.addNewLnRef().addNewSchemeClr().setVal(STSchemeColorVal.ACCENT_1);
            cTShapeStyleAddNewStyle.getLnRef().setIdx(1L);
            CTStyleMatrixReference cTStyleMatrixReferenceAddNewFillRef = cTShapeStyleAddNewStyle.addNewFillRef();
            cTStyleMatrixReferenceAddNewFillRef.setIdx(0L);
            cTStyleMatrixReferenceAddNewFillRef.addNewSchemeClr().setVal(STSchemeColorVal.ACCENT_1);
            CTStyleMatrixReference cTStyleMatrixReferenceAddNewEffectRef = cTShapeStyleAddNewStyle.addNewEffectRef();
            cTStyleMatrixReferenceAddNewEffectRef.setIdx(0L);
            cTStyleMatrixReferenceAddNewEffectRef.addNewSchemeClr().setVal(STSchemeColorVal.ACCENT_1);
            CTFontReference cTFontReferenceAddNewFontRef = cTShapeStyleAddNewStyle.addNewFontRef();
            cTFontReferenceAddNewFontRef.setIdx(STFontCollectionIndex.MINOR);
            cTFontReferenceAddNewFontRef.addNewSchemeClr().setVal(STSchemeColorVal.TX_1);
            prototype = cTConnectorNewInstance;
        }
        return prototype;
    }

    @Internal
    public CTConnector getCTConnector() {
        return this.ctShape;
    }

    public int getShapeType() {
        return this.ctShape.getSpPr().getPrstGeom().getPrst().intValue();
    }

    public void setShapeType(int i) {
        this.ctShape.getSpPr().getPrstGeom().setPrst(STShapeType.Enum.forInt(i));
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFShape
    protected CTShapeProperties getShapeProperties() {
        return this.ctShape.getSpPr();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public String getShapeName() {
        return this.ctShape.getNvCxnSpPr().getCNvPr().getName();
    }
}
