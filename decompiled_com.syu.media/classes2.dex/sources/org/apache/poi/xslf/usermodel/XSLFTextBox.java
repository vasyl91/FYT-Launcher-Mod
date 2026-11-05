package org.apache.poi.xslf.usermodel;

import org.apache.poi.sl.usermodel.TextBox;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFTextBox extends XSLFAutoShape implements TextBox<XSLFShape, XSLFTextParagraph> {
    XSLFTextBox(CTShape cTShape, XSLFSheet xSLFSheet) {
        super(cTShape, xSLFSheet);
    }

    static CTShape prototype(int i) {
        CTShape cTShapeNewInstance = CTShape.Factory.newInstance();
        CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTShapeNonVisualAddNewNvSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("TextBox " + i);
        cTNonVisualDrawingPropsAddNewCNvPr.setId(i + 1);
        cTShapeNonVisualAddNewNvSpPr.addNewCNvSpPr().setTxBox(true);
        cTShapeNonVisualAddNewNvSpPr.addNewNvPr();
        CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapeNewInstance.addNewSpPr().addNewPrstGeom();
        cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
        cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
        XSLFAutoShape.initTextBody(cTShapeNewInstance.addNewTxBody());
        return cTShapeNewInstance;
    }
}
