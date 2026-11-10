package org.apache.poi.xssf.usermodel;

import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrameNonVisual;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFGraphicFrame extends XSSFShape {
    private static CTGraphicalObjectFrame prototype;
    private CTGraphicalObjectFrame graphicFrame;

    @Override // org.apache.poi.xssf.usermodel.XSSFShape
    protected CTShapeProperties getShapeProperties() {
        return null;
    }

    protected XSSFGraphicFrame(XSSFDrawing xSSFDrawing, CTGraphicalObjectFrame cTGraphicalObjectFrame) {
        this.drawing = xSSFDrawing;
        this.graphicFrame = cTGraphicalObjectFrame;
        CTGraphicalObjectData graphicData = cTGraphicalObjectFrame.getGraphic().getGraphicData();
        if (graphicData != null) {
            NodeList childNodes = graphicData.getDomNode().getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node nodeItem = childNodes.item(i);
                if (nodeItem.getNodeName().equals("c:chart")) {
                    POIXMLDocumentPart relationById = xSSFDrawing.getRelationById(nodeItem.getAttributes().getNamedItem("r:id").getNodeValue());
                    if (relationById instanceof XSSFChart) {
                        ((XSSFChart) relationById).setGraphicFrame(this);
                    }
                }
            }
        }
    }

    @Internal
    public CTGraphicalObjectFrame getCTGraphicalObjectFrame() {
        return this.graphicFrame;
    }

    protected static CTGraphicalObjectFrame prototype() {
        if (prototype == null) {
            CTGraphicalObjectFrame cTGraphicalObjectFrameNewInstance = CTGraphicalObjectFrame.Factory.newInstance();
            CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr = cTGraphicalObjectFrameNewInstance.addNewNvGraphicFramePr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr.setId(0L);
            cTNonVisualDrawingPropsAddNewCNvPr.setName("Diagramm 1");
            cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvGraphicFramePr();
            CTTransform2D cTTransform2DAddNewXfrm = cTGraphicalObjectFrameNewInstance.addNewXfrm();
            CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
            CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
            cTPositiveSize2DAddNewExt.setCx(0L);
            cTPositiveSize2DAddNewExt.setCy(0L);
            cTPoint2DAddNewOff.setX(0L);
            cTPoint2DAddNewOff.setY(0L);
            cTGraphicalObjectFrameNewInstance.addNewGraphic();
            prototype = cTGraphicalObjectFrameNewInstance;
        }
        return prototype;
    }

    public void setMacro(String str) {
        this.graphicFrame.setMacro(str);
    }

    public void setName(String str) {
        getNonVisualProperties().setName(str);
    }

    public String getName() {
        return getNonVisualProperties().getName();
    }

    private CTNonVisualDrawingProps getNonVisualProperties() {
        return this.graphicFrame.getNvGraphicFramePr().getCNvPr();
    }

    protected void setAnchor(XSSFClientAnchor xSSFClientAnchor) {
        this.anchor = xSSFClientAnchor;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFShape, org.apache.poi.ss.usermodel.Shape
    public XSSFClientAnchor getAnchor() {
        return (XSSFClientAnchor) this.anchor;
    }

    protected void setChart(XSSFChart xSSFChart, String str) {
        appendChartElement(this.graphicFrame.getGraphic().addNewGraphicData(), str);
        xSSFChart.setGraphicFrame(this);
    }

    public long getId() {
        return this.graphicFrame.getNvGraphicFramePr().getCNvPr().getId();
    }

    protected void setId(long j) {
        this.graphicFrame.getNvGraphicFramePr().getCNvPr().setId(j);
    }

    private void appendChartElement(CTGraphicalObjectData cTGraphicalObjectData, String str) {
        String namespaceURI = STRelationshipId.type.getName().getNamespaceURI();
        XmlCursor xmlCursorNewCursor = cTGraphicalObjectData.newCursor();
        xmlCursorNewCursor.toNextToken();
        xmlCursorNewCursor.beginElement(new QName(XSSFRelation.NS_CHART, "chart", "c"));
        xmlCursorNewCursor.insertAttributeWithValue(new QName(namespaceURI, "id", "r"), str);
        xmlCursorNewCursor.dispose();
        cTGraphicalObjectData.setUri(XSSFRelation.NS_CHART);
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public String getShapeName() {
        return this.graphicFrame.getNvGraphicFramePr().getCNvPr().getName();
    }
}
