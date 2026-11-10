package org.apache.poi.xslf.usermodel;

import org.apache.poi.sl.usermodel.AutoShape;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFAutoShape extends XSLFTextShape implements AutoShape<XSLFShape, XSLFTextParagraph> {
    XSLFAutoShape(CTShape cTShape, XSLFSheet xSLFSheet) {
        super(cTShape, xSLFSheet);
    }

    static XSLFAutoShape create(CTShape cTShape, XSLFSheet xSLFSheet) {
        if (cTShape.getSpPr().isSetCustGeom()) {
            return new XSLFFreeformShape(cTShape, xSLFSheet);
        }
        if (cTShape.getNvSpPr().getCNvSpPr().isSetTxBox()) {
            return new XSLFTextBox(cTShape, xSLFSheet);
        }
        return new XSLFAutoShape(cTShape, xSLFSheet);
    }

    static CTShape prototype(int i) {
        CTShape cTShapeNewInstance = CTShape.Factory.newInstance();
        CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTShapeNonVisualAddNewNvSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("AutoShape " + i);
        cTNonVisualDrawingPropsAddNewCNvPr.setId(i + 1);
        cTShapeNonVisualAddNewNvSpPr.addNewCNvSpPr();
        cTShapeNonVisualAddNewNvSpPr.addNewNvPr();
        CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapeNewInstance.addNewSpPr().addNewPrstGeom();
        cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
        cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
        return cTShapeNewInstance;
    }

    protected static void initTextBody(CTTextBody cTTextBody) {
        CTTextBodyProperties cTTextBodyPropertiesAddNewBodyPr = cTTextBody.addNewBodyPr();
        cTTextBodyPropertiesAddNewBodyPr.setAnchor(STTextAnchoringType.T);
        cTTextBodyPropertiesAddNewBodyPr.setRtlCol(false);
        CTTextParagraph cTTextParagraphAddNewP = cTTextBody.addNewP();
        cTTextParagraphAddNewP.addNewPPr().setAlgn(STTextAlignType.L);
        CTTextCharacterProperties cTTextCharacterPropertiesAddNewEndParaRPr = cTTextParagraphAddNewP.addNewEndParaRPr();
        cTTextCharacterPropertiesAddNewEndParaRPr.setLang("en-US");
        cTTextCharacterPropertiesAddNewEndParaRPr.setSz(1100);
        cTTextParagraphAddNewP.addNewR().setT("");
        cTTextBody.addNewLstStyle();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    protected CTTextBody getTextBody(boolean z) {
        CTShape xmlObject = getXmlObject();
        CTTextBody txBody = xmlObject.getTxBody();
        if (txBody != null || !z) {
            return txBody;
        }
        CTTextBody cTTextBodyAddNewTxBody = xmlObject.addNewTxBody();
        initTextBody(cTTextBodyAddNewTxBody);
        return cTTextBodyAddNewTxBody;
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + "] " + getShapeName();
    }
}
