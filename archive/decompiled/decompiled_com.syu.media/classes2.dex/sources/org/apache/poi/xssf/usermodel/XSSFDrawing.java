package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.ImageUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAbsoluteAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTOneCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.STEditAs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFDrawing extends POIXMLDocumentPart implements Drawing<XSSFShape> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XSSFDrawing.class);
    protected static final String NAMESPACE_A = "http://schemas.openxmlformats.org/drawingml/2006/main";
    protected static final String NAMESPACE_C = "http://schemas.openxmlformats.org/drawingml/2006/chart";
    private CTDrawing drawing;
    private long numOfGraphicFrames;

    protected XSSFDrawing() {
        this.numOfGraphicFrames = 0L;
        this.drawing = newDrawing();
    }

    public XSSFDrawing(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        this.numOfGraphicFrames = 0L;
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setLoadReplaceDocumentElement(null);
        InputStream inputStream = packagePart.getInputStream();
        try {
            this.drawing = CTDrawing.Factory.parse(inputStream, xmlOptions);
        } finally {
            inputStream.close();
        }
    }

    private static CTDrawing newDrawing() {
        return CTDrawing.Factory.newInstance();
    }

    @Internal
    public CTDrawing getCTDrawing() {
        return this.drawing;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTDrawing.type.getName().getNamespaceURI(), "wsDr", "xdr"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.drawing.save(outputStream, xmlOptions);
        outputStream.close();
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFClientAnchor createAnchor(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return new XSSFClientAnchor(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public XSSFTextBox createTextbox(XSSFClientAnchor xSSFClientAnchor) {
        long jNewShapeId = newShapeId();
        CTShape cTShapeAddNewSp = createTwoCellAnchor(xSSFClientAnchor).addNewSp();
        cTShapeAddNewSp.set(XSSFSimpleShape.prototype());
        cTShapeAddNewSp.getNvSpPr().getCNvPr().setId(jNewShapeId);
        XSSFTextBox xSSFTextBox = new XSSFTextBox(this, cTShapeAddNewSp);
        xSSFTextBox.anchor = xSSFClientAnchor;
        return xSSFTextBox;
    }

    public XSSFPicture createPicture(XSSFClientAnchor xSSFClientAnchor, int i) {
        PackageRelationship packageRelationshipAddPictureReference = addPictureReference(i);
        long jNewShapeId = newShapeId();
        CTPicture cTPictureAddNewPic = createTwoCellAnchor(xSSFClientAnchor).addNewPic();
        cTPictureAddNewPic.set(XSSFPicture.prototype());
        cTPictureAddNewPic.getNvPicPr().getCNvPr().setId(jNewShapeId);
        XSSFPicture xSSFPicture = new XSSFPicture(this, cTPictureAddNewPic);
        xSSFPicture.anchor = xSSFClientAnchor;
        xSSFPicture.setPictureReference(packageRelationshipAddPictureReference);
        cTPictureAddNewPic.getSpPr().setXfrm(createXfrm(xSSFClientAnchor));
        return xSSFPicture;
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFPicture createPicture(ClientAnchor clientAnchor, int i) {
        return createPicture((XSSFClientAnchor) clientAnchor, i);
    }

    public XSSFChart createChart(XSSFClientAnchor xSSFClientAnchor) {
        POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(XSSFRelation.CHART, XSSFFactory.getInstance(), getPackagePart().getPackage().getPartsByContentType(XSSFRelation.CHART.getContentType()).size() + 1, false);
        XSSFChart xSSFChart = (XSSFChart) relationPartCreateRelationship.getDocumentPart();
        String id = relationPartCreateRelationship.getRelationship().getId();
        XSSFGraphicFrame xSSFGraphicFrameCreateGraphicFrame = createGraphicFrame(xSSFClientAnchor);
        xSSFGraphicFrameCreateGraphicFrame.setChart(xSSFChart, id);
        xSSFGraphicFrameCreateGraphicFrame.getCTGraphicalObjectFrame().setXfrm(createXfrm(xSSFClientAnchor));
        return xSSFChart;
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFChart createChart(ClientAnchor clientAnchor) {
        return createChart((XSSFClientAnchor) clientAnchor);
    }

    protected PackageRelationship addPictureReference(int i) {
        return addRelation(null, XSSFRelation.IMAGES, new XSSFPictureData(((XSSFWorkbook) getParent().getParent()).getAllPictures().get(i).getPackagePart())).getRelationship();
    }

    public XSSFSimpleShape createSimpleShape(XSSFClientAnchor xSSFClientAnchor) {
        long jNewShapeId = newShapeId();
        CTShape cTShapeAddNewSp = createTwoCellAnchor(xSSFClientAnchor).addNewSp();
        cTShapeAddNewSp.set(XSSFSimpleShape.prototype());
        cTShapeAddNewSp.getNvSpPr().getCNvPr().setId(jNewShapeId);
        cTShapeAddNewSp.getSpPr().setXfrm(createXfrm(xSSFClientAnchor));
        XSSFSimpleShape xSSFSimpleShape = new XSSFSimpleShape(this, cTShapeAddNewSp);
        xSSFSimpleShape.anchor = xSSFClientAnchor;
        return xSSFSimpleShape;
    }

    public XSSFConnector createConnector(XSSFClientAnchor xSSFClientAnchor) {
        CTConnector cTConnectorAddNewCxnSp = createTwoCellAnchor(xSSFClientAnchor).addNewCxnSp();
        cTConnectorAddNewCxnSp.set(XSSFConnector.prototype());
        XSSFConnector xSSFConnector = new XSSFConnector(this, cTConnectorAddNewCxnSp);
        xSSFConnector.anchor = xSSFClientAnchor;
        return xSSFConnector;
    }

    public XSSFShapeGroup createGroup(XSSFClientAnchor xSSFClientAnchor) {
        CTGroupShape cTGroupShapeAddNewGrpSp = createTwoCellAnchor(xSSFClientAnchor).addNewGrpSp();
        cTGroupShapeAddNewGrpSp.set(XSSFShapeGroup.prototype());
        CTTransform2D cTTransform2DCreateXfrm = createXfrm(xSSFClientAnchor);
        CTGroupTransform2D xfrm = cTGroupShapeAddNewGrpSp.getGrpSpPr().getXfrm();
        xfrm.setOff(cTTransform2DCreateXfrm.getOff());
        xfrm.setExt(cTTransform2DCreateXfrm.getExt());
        xfrm.setChExt(cTTransform2DCreateXfrm.getExt());
        XSSFShapeGroup xSSFShapeGroup = new XSSFShapeGroup(this, cTGroupShapeAddNewGrpSp);
        xSSFShapeGroup.anchor = xSSFClientAnchor;
        return xSSFShapeGroup;
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFComment createCellComment(ClientAnchor clientAnchor) {
        XSSFClientAnchor xSSFClientAnchor = (XSSFClientAnchor) clientAnchor;
        XSSFSheet sheet = getSheet();
        CommentsTable commentsTable = sheet.getCommentsTable(true);
        com.microsoft.schemas.vml.CTShape cTShapeNewCommentShape = sheet.getVMLDrawing(true).newCommentShape();
        if (xSSFClientAnchor.isSet()) {
            cTShapeNewCommentShape.getClientDataArray(0).setAnchorArray(0, ((int) xSSFClientAnchor.getCol1()) + ", " + (xSSFClientAnchor.getDx1() / 9525) + ", " + xSSFClientAnchor.getRow1() + ", " + (xSSFClientAnchor.getDy1() / 9525) + ", " + ((int) xSSFClientAnchor.getCol2()) + ", " + (xSSFClientAnchor.getDx2() / 9525) + ", " + xSSFClientAnchor.getRow2() + ", " + (xSSFClientAnchor.getDy2() / 9525));
        }
        CellAddress cellAddress = new CellAddress(xSSFClientAnchor.getRow1(), xSSFClientAnchor.getCol1());
        if (commentsTable.findCellComment(cellAddress) != null) {
            throw new IllegalArgumentException("Multiple cell comments in one cell are not allowed, cell: " + cellAddress);
        }
        return new XSSFComment(commentsTable, commentsTable.newComment(cellAddress), cTShapeNewCommentShape);
    }

    private XSSFGraphicFrame createGraphicFrame(XSSFClientAnchor xSSFClientAnchor) {
        CTGraphicalObjectFrame cTGraphicalObjectFrameAddNewGraphicFrame = createTwoCellAnchor(xSSFClientAnchor).addNewGraphicFrame();
        cTGraphicalObjectFrameAddNewGraphicFrame.set(XSSFGraphicFrame.prototype());
        cTGraphicalObjectFrameAddNewGraphicFrame.setXfrm(createXfrm(xSSFClientAnchor));
        long j = this.numOfGraphicFrames;
        this.numOfGraphicFrames = 1 + j;
        XSSFGraphicFrame xSSFGraphicFrame = new XSSFGraphicFrame(this, cTGraphicalObjectFrameAddNewGraphicFrame);
        xSSFGraphicFrame.setAnchor(xSSFClientAnchor);
        xSSFGraphicFrame.setId(j);
        xSSFGraphicFrame.setName("Diagramm" + j);
        return xSSFGraphicFrame;
    }

    @Override // org.apache.poi.ss.usermodel.Drawing
    public XSSFObjectData createObjectData(ClientAnchor clientAnchor, int i, int i2) {
        XSSFSheet sheet = getSheet();
        PackagePart packagePart = sheet.getPackagePart();
        XSSFSheet sheet2 = getSheet();
        long sheetIndex = ((long) ((sheet2.getWorkbook().getSheetIndex(sheet2) + 1) * 1024)) + newShapeId();
        try {
            PackageRelationship packageRelationshipAddRelationship = packagePart.addRelationship(PackagingURIHelper.createPartName("/xl/embeddings/oleObject" + i + ".bin"), TargetMode.INTERNAL, POIXMLDocument.OLE_OBJECT_REL_TYPE);
            PackagePartName partName = sheet.getWorkbook().getAllPictures().get(i2).getPackagePart().getPartName();
            PackageRelationship packageRelationshipAddRelationship2 = packagePart.addRelationship(partName, TargetMode.INTERNAL, PackageRelationshipTypes.IMAGE_PART);
            PackageRelationship packageRelationshipAddRelationship3 = getPackagePart().addRelationship(partName, TargetMode.INTERNAL, PackageRelationshipTypes.IMAGE_PART);
            CTWorksheet cTWorksheet = sheet.getCTWorksheet();
            CTOleObject cTOleObjectAddNewOleObject = (cTWorksheet.isSetOleObjects() ? cTWorksheet.getOleObjects() : cTWorksheet.addNewOleObjects()).addNewOleObject();
            cTOleObjectAddNewOleObject.setProgId("Package");
            cTOleObjectAddNewOleObject.setShapeId(sheetIndex);
            cTOleObjectAddNewOleObject.setId(packageRelationshipAddRelationship.getId());
            XmlCursor xmlCursorNewCursor = cTOleObjectAddNewOleObject.newCursor();
            xmlCursorNewCursor.toEndToken();
            xmlCursorNewCursor.beginElement("objectPr", XSSFRelation.NS_SPREADSHEETML);
            xmlCursorNewCursor.insertAttributeWithValue("id", PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, packageRelationshipAddRelationship2.getId());
            xmlCursorNewCursor.insertAttributeWithValue("defaultSize", "0");
            xmlCursorNewCursor.beginElement("anchor", XSSFRelation.NS_SPREADSHEETML);
            xmlCursorNewCursor.insertAttributeWithValue("moveWithCells", "1");
            XSSFClientAnchor xSSFClientAnchor = (XSSFClientAnchor) clientAnchor;
            CTTwoCellAnchor cTTwoCellAnchorCreateTwoCellAnchor = createTwoCellAnchor(xSSFClientAnchor);
            XmlCursor xmlCursorNewCursor2 = cTTwoCellAnchorCreateTwoCellAnchor.newCursor();
            xmlCursorNewCursor2.copyXmlContents(xmlCursorNewCursor);
            xmlCursorNewCursor2.dispose();
            xmlCursorNewCursor.toParent();
            xmlCursorNewCursor.toFirstChild();
            xmlCursorNewCursor.setName(new QName(XSSFRelation.NS_SPREADSHEETML, "from"));
            xmlCursorNewCursor.toNextSibling();
            xmlCursorNewCursor.setName(new QName(XSSFRelation.NS_SPREADSHEETML, "to"));
            xmlCursorNewCursor.dispose();
            CTShape cTShapeAddNewSp = cTTwoCellAnchorCreateTwoCellAnchor.addNewSp();
            cTShapeAddNewSp.set(XSSFObjectData.prototype());
            cTShapeAddNewSp.getSpPr().setXfrm(createXfrm(xSSFClientAnchor));
            CTBlipFillProperties cTBlipFillPropertiesAddNewBlipFill = cTShapeAddNewSp.getSpPr().addNewBlipFill();
            cTBlipFillPropertiesAddNewBlipFill.addNewBlip().setEmbed(packageRelationshipAddRelationship3.getId());
            cTBlipFillPropertiesAddNewBlipFill.addNewStretch().addNewFillRect();
            CTNonVisualDrawingProps cNvPr = cTShapeAddNewSp.getNvSpPr().getCNvPr();
            cNvPr.setId(sheetIndex);
            cNvPr.setName("Object " + sheetIndex);
            XmlCursor xmlCursorNewCursor3 = cNvPr.getExtLst().getExtArray(0).newCursor();
            xmlCursorNewCursor3.toFirstChild();
            xmlCursorNewCursor3.setAttributeText(new QName("spid"), "_x0000_s" + sheetIndex);
            xmlCursorNewCursor3.dispose();
            XSSFObjectData xSSFObjectData = new XSSFObjectData(this, cTShapeAddNewSp);
            xSSFObjectData.anchor = xSSFClientAnchor;
            return xSSFObjectData;
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    public List<XSSFChart> getCharts() {
        ArrayList arrayList = new ArrayList();
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XSSFChart) {
                arrayList.add((XSSFChart) pOIXMLDocumentPart);
            }
        }
        return arrayList;
    }

    private CTTwoCellAnchor createTwoCellAnchor(XSSFClientAnchor xSSFClientAnchor) {
        STEditAs.Enum r3;
        CTTwoCellAnchor cTTwoCellAnchorAddNewTwoCellAnchor = this.drawing.addNewTwoCellAnchor();
        cTTwoCellAnchorAddNewTwoCellAnchor.setFrom(xSSFClientAnchor.getFrom());
        cTTwoCellAnchorAddNewTwoCellAnchor.setTo(xSSFClientAnchor.getTo());
        cTTwoCellAnchorAddNewTwoCellAnchor.addNewClientData();
        xSSFClientAnchor.setTo(cTTwoCellAnchorAddNewTwoCellAnchor.getTo());
        xSSFClientAnchor.setFrom(cTTwoCellAnchorAddNewTwoCellAnchor.getFrom());
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$ClientAnchor$AnchorType[xSSFClientAnchor.getAnchorType().ordinal()];
        if (i == 1) {
            r3 = STEditAs.ABSOLUTE;
        } else if (i == 2) {
            r3 = STEditAs.TWO_CELL;
        } else if (i == 3) {
            r3 = STEditAs.ONE_CELL;
        } else {
            r3 = STEditAs.ONE_CELL;
        }
        cTTwoCellAnchorAddNewTwoCellAnchor.setEditAs(r3);
        return cTTwoCellAnchorAddNewTwoCellAnchor;
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFDrawing$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$ClientAnchor$AnchorType;

        static {
            int[] iArr = new int[ClientAnchor.AnchorType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$ClientAnchor$AnchorType = iArr;
            try {
                iArr[ClientAnchor.AnchorType.DONT_MOVE_AND_RESIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ClientAnchor$AnchorType[ClientAnchor.AnchorType.MOVE_AND_RESIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$ClientAnchor$AnchorType[ClientAnchor.AnchorType.MOVE_DONT_RESIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private CTTransform2D createXfrm(XSSFClientAnchor xSSFClientAnchor) {
        CTTransform2D cTTransform2DNewInstance = CTTransform2D.Factory.newInstance();
        CTPoint2D cTPoint2DAddNewOff = cTTransform2DNewInstance.addNewOff();
        cTPoint2DAddNewOff.setX(xSSFClientAnchor.getDx1());
        cTPoint2DAddNewOff.setY(xSSFClientAnchor.getDy1());
        XSSFSheet sheet = getSheet();
        double rowHeightInPixels = 0.0d;
        double columnWidthInPixels = 0.0d;
        for (int col1 = xSSFClientAnchor.getCol1(); col1 < xSSFClientAnchor.getCol2(); col1++) {
            columnWidthInPixels += (double) sheet.getColumnWidthInPixels(col1);
        }
        for (int row1 = xSSFClientAnchor.getRow1(); row1 < xSSFClientAnchor.getRow2(); row1++) {
            rowHeightInPixels += ImageUtils.getRowHeightInPixels(sheet, row1);
        }
        long jPixelToEMU = Units.pixelToEMU((int) columnWidthInPixels);
        long jPixelToEMU2 = Units.pixelToEMU((int) rowHeightInPixels);
        CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DNewInstance.addNewExt();
        cTPositiveSize2DAddNewExt.setCx((jPixelToEMU - ((long) xSSFClientAnchor.getDx1())) + ((long) xSSFClientAnchor.getDx2()));
        cTPositiveSize2DAddNewExt.setCy((jPixelToEMU2 - ((long) xSSFClientAnchor.getDy1())) + ((long) xSSFClientAnchor.getDy2()));
        return cTTransform2DNewInstance;
    }

    private long newShapeId() {
        return this.drawing.sizeOfAbsoluteAnchorArray() + 1 + this.drawing.sizeOfOneCellAnchorArray() + this.drawing.sizeOfTwoCellAnchorArray();
    }

    public List<XSSFShape> getShapes() {
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = this.drawing.newCursor();
        try {
            if (xmlCursorNewCursor.toFirstChild()) {
                addShapes(xmlCursorNewCursor, arrayList);
            }
            return arrayList;
        } finally {
            xmlCursorNewCursor.dispose();
        }
    }

    public List<XSSFShape> getShapes(XSSFShapeGroup xSSFShapeGroup) {
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = xSSFShapeGroup.getCTGroupShape().newCursor();
        try {
            addShapes(xmlCursorNewCursor, arrayList);
            return arrayList;
        } finally {
            xmlCursorNewCursor.dispose();
        }
    }

    private void addShapes(XmlCursor xmlCursor, List<XSSFShape> list) {
        XSSFShape xSSFShapeGroup;
        do {
            try {
                xmlCursor.push();
                if (xmlCursor.toFirstChild()) {
                    do {
                        CTPicture object = xmlCursor.getObject();
                        if (!(object instanceof CTMarker)) {
                            if (object instanceof CTPicture) {
                                xSSFShapeGroup = new XSSFPicture(this, object);
                            } else if (object instanceof CTConnector) {
                                xSSFShapeGroup = new XSSFConnector(this, (CTConnector) object);
                            } else if (object instanceof CTShape) {
                                xSSFShapeGroup = hasOleLink(object) ? new XSSFObjectData(this, (CTShape) object) : new XSSFSimpleShape(this, (CTShape) object);
                            } else if (object instanceof CTGraphicalObjectFrame) {
                                xSSFShapeGroup = new XSSFGraphicFrame(this, (CTGraphicalObjectFrame) object);
                            } else if (object instanceof CTGroupShape) {
                                xSSFShapeGroup = new XSSFShapeGroup(this, (CTGroupShape) object);
                            } else if (object instanceof XmlAnyTypeImpl) {
                                LOG.log(5, "trying to parse AlternateContent, this unlinks the returned Shapes from the underlying xml content, so those shapes can't be used to modify the drawing, i.e. modifications will be ignored!");
                                xmlCursor.push();
                                xmlCursor.toFirstChild();
                                XmlCursor xmlCursorNewCursor = null;
                                try {
                                    try {
                                        xmlCursorNewCursor = CTDrawing.Factory.parse(xmlCursor.newXMLStreamReader()).newCursor();
                                        if (xmlCursorNewCursor.toFirstChild()) {
                                            addShapes(xmlCursorNewCursor, list);
                                        }
                                        if (xmlCursorNewCursor != null) {
                                            xmlCursorNewCursor.dispose();
                                        }
                                    } catch (XmlException e) {
                                        LOG.log(5, "unable to parse CTDrawing in alternate content.", e);
                                        if (xmlCursorNewCursor != null) {
                                            xmlCursorNewCursor.dispose();
                                        }
                                    }
                                    xmlCursor.pop();
                                } catch (Throwable th) {
                                    if (xmlCursorNewCursor != null) {
                                        xmlCursorNewCursor.dispose();
                                    }
                                    xmlCursor.pop();
                                    throw th;
                                }
                            }
                            xSSFShapeGroup.anchor = getAnchorFromParent(object);
                            list.add(xSSFShapeGroup);
                        }
                    } while (xmlCursor.toNextSibling());
                }
                xmlCursor.pop();
            } catch (Throwable th2) {
                xmlCursor.dispose();
                throw th2;
            }
        } while (xmlCursor.toNextSibling());
        xmlCursor.dispose();
    }

    private boolean hasOleLink(XmlObject xmlObject) {
        QName qName = new QName(null, "uri");
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        xmlCursorNewCursor.selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:extLst/a:ext");
        while (xmlCursorNewCursor.toNextSelection()) {
            try {
                if ("{63B3BB69-23CF-44E3-9099-C40C66FF867C}".equals(xmlCursorNewCursor.getAttributeText(qName))) {
                    return true;
                }
            } finally {
                xmlCursorNewCursor.dispose();
            }
        }
        return false;
    }

    private XSSFAnchor getAnchorFromParent(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        XmlObject object = xmlCursorNewCursor.toParent() ? xmlCursorNewCursor.getObject() : null;
        xmlCursorNewCursor.dispose();
        if (object == null) {
            return null;
        }
        if (object instanceof CTTwoCellAnchor) {
            CTTwoCellAnchor cTTwoCellAnchor = (CTTwoCellAnchor) object;
            return new XSSFClientAnchor(cTTwoCellAnchor.getFrom(), cTTwoCellAnchor.getTo());
        }
        if (object instanceof CTOneCellAnchor) {
            CTOneCellAnchor cTOneCellAnchor = (CTOneCellAnchor) object;
            return new XSSFClientAnchor(getSheet(), cTOneCellAnchor.getFrom(), cTOneCellAnchor.getExt());
        }
        if (!(object instanceof CTAbsoluteAnchor)) {
            return null;
        }
        CTAbsoluteAnchor cTAbsoluteAnchor = (CTAbsoluteAnchor) object;
        return new XSSFClientAnchor(getSheet(), cTAbsoluteAnchor.getPos(), cTAbsoluteAnchor.getExt());
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFShape> iterator() {
        return getShapes().iterator();
    }

    public XSSFSheet getSheet() {
        return (XSSFSheet) getParent();
    }
}
