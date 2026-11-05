package org.apache.poi.xslf.usermodel;

import org.apache.poi.POIXMLException;
import org.apache.poi.sl.usermodel.ConnectorShape;
import org.apache.poi.sl.usermodel.Placeholder;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFConnectorShape extends XSLFSimpleShape implements ConnectorShape<XSLFShape, XSLFTextParagraph> {
    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.SimpleShape
    public XSLFShadow getShadow() {
        return null;
    }

    XSLFConnectorShape(CTConnector cTConnector, XSLFSheet xSLFSheet) {
        super(cTConnector, xSLFSheet);
    }

    static CTConnector prototype(int i) {
        CTConnector cTConnectorNewInstance = CTConnector.Factory.newInstance();
        CTConnectorNonVisual cTConnectorNonVisualAddNewNvCxnSpPr = cTConnectorNewInstance.addNewNvCxnSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTConnectorNonVisualAddNewNvCxnSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Connector " + i);
        cTNonVisualDrawingPropsAddNewCNvPr.setId(i + 1);
        cTConnectorNonVisualAddNewNvCxnSpPr.addNewCNvCxnSpPr();
        cTConnectorNonVisualAddNewNvCxnSpPr.addNewNvPr();
        CTShapeProperties cTShapePropertiesAddNewSpPr = cTConnectorNewInstance.addNewSpPr();
        CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapePropertiesAddNewSpPr.addNewPrstGeom();
        cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.LINE);
        cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
        cTShapePropertiesAddNewSpPr.addNewLn();
        return cTConnectorNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape, org.apache.poi.sl.usermodel.SimpleShape
    public void setPlaceholder(Placeholder placeholder) {
        throw new POIXMLException("A connector shape can't be a placeholder.");
    }
}
