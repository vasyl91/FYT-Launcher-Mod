package org.apache.poi.xssf.usermodel;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.excel.STObjectType;
import com.microsoft.schemas.office.office.CTIdMap;
import com.microsoft.schemas.office.office.CTShapeLayout;
import com.microsoft.schemas.office.office.STConnectType;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.CTShape;
import com.microsoft.schemas.vml.CTShapetype;
import com.microsoft.schemas.vml.STExt;
import com.microsoft.schemas.vml.STStrokeJoinStyle;
import com.microsoft.schemas.vml.STTrueFalse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.ReplacingInputStream;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFVMLDrawing extends POIXMLDocumentPart {
    private static final String COMMENT_SHAPE_TYPE_ID = "_x0000_t202";
    private List<XmlObject> _items;
    private List<QName> _qnames;
    private int _shapeId;
    private String _shapeTypeId;
    private static final QName QNAME_SHAPE_LAYOUT = new QName("urn:schemas-microsoft-com:office:office", "shapelayout");
    private static final QName QNAME_SHAPE_TYPE = new QName("urn:schemas-microsoft-com:vml", "shapetype");
    private static final QName QNAME_SHAPE = new QName("urn:schemas-microsoft-com:vml", "shape");
    private static final Pattern ptrn_shapeId = Pattern.compile("_x0000_s(\\d+)");

    protected XSSFVMLDrawing() {
        this._qnames = new ArrayList();
        this._items = new ArrayList();
        this._shapeId = 1024;
        newDrawing();
    }

    protected XSSFVMLDrawing(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        this._qnames = new ArrayList();
        this._items = new ArrayList();
        this._shapeId = 1024;
        read(getPackagePart().getInputStream());
    }

    protected void read(InputStream inputStream) throws XmlException, IOException {
        try {
            XmlObject xmlObject = XmlObject.Factory.parse(DocumentHelper.readDocument(new ReplacingInputStream(inputStream, "<br>", "<br/>")), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            this._qnames = new ArrayList();
            this._items = new ArrayList();
            for (XmlObject xmlObject2 : xmlObject.selectPath("$this/xml/*")) {
                Node domNode = xmlObject2.getDomNode();
                QName qName = new QName(domNode.getNamespaceURI(), domNode.getLocalName());
                if (qName.equals(QNAME_SHAPE_LAYOUT)) {
                    this._items.add(CTShapeLayout.Factory.parse(xmlObject2.xmlText(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
                } else if (qName.equals(QNAME_SHAPE_TYPE)) {
                    XmlObject xmlObject3 = CTShapetype.Factory.parse(xmlObject2.xmlText(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
                    this._items.add(xmlObject3);
                    this._shapeTypeId = xmlObject3.getId();
                } else if (qName.equals(QNAME_SHAPE)) {
                    XmlObject xmlObject4 = CTShape.Factory.parse(xmlObject2.xmlText(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
                    String id = xmlObject4.getId();
                    if (id != null) {
                        Matcher matcher = ptrn_shapeId.matcher(id);
                        if (matcher.find()) {
                            this._shapeId = Math.max(this._shapeId, Integer.parseInt(matcher.group(1)));
                        }
                    }
                    this._items.add(xmlObject4);
                } else {
                    try {
                        this._items.add(XmlObject.Factory.parse(DocumentHelper.readDocument(new InputSource(new StringReader(xmlObject2.xmlText()))), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
                    } catch (SAXException e) {
                        throw new XmlException(e.getMessage(), e);
                    }
                }
                this._qnames.add(qName);
            }
        } catch (SAXException e2) {
            throw new XmlException(e2.getMessage(), e2);
        }
    }

    protected List<XmlObject> getItems() {
        return this._items;
    }

    protected void write(OutputStream outputStream) throws IOException {
        XmlObject xmlObjectNewInstance = XmlObject.Factory.newInstance();
        XmlCursor xmlCursorNewCursor = xmlObjectNewInstance.newCursor();
        xmlCursorNewCursor.toNextToken();
        xmlCursorNewCursor.beginElement("xml");
        for (int i = 0; i < this._items.size(); i++) {
            XmlCursor xmlCursorNewCursor2 = this._items.get(i).newCursor();
            xmlCursorNewCursor.beginElement(this._qnames.get(i));
            while (xmlCursorNewCursor2.toNextToken() == XmlCursor.TokenType.ATTR) {
                Node domNode = xmlCursorNewCursor2.getDomNode();
                xmlCursorNewCursor.insertAttributeWithValue(domNode.getLocalName(), domNode.getNamespaceURI(), domNode.getNodeValue());
            }
            xmlCursorNewCursor2.toStartDoc();
            xmlCursorNewCursor2.copyXmlContents(xmlCursorNewCursor);
            xmlCursorNewCursor.toNextToken();
            xmlCursorNewCursor2.dispose();
        }
        xmlCursorNewCursor.dispose();
        xmlObjectNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        write(outputStream);
        outputStream.close();
    }

    private void newDrawing() {
        XmlObject xmlObjectNewInstance = CTShapeLayout.Factory.newInstance();
        xmlObjectNewInstance.setExt(STExt.EDIT);
        CTIdMap cTIdMapAddNewIdmap = xmlObjectNewInstance.addNewIdmap();
        cTIdMapAddNewIdmap.setExt(STExt.EDIT);
        cTIdMapAddNewIdmap.setData("1");
        this._items.add(xmlObjectNewInstance);
        this._qnames.add(QNAME_SHAPE_LAYOUT);
        XmlObject xmlObjectNewInstance2 = CTShapetype.Factory.newInstance();
        this._shapeTypeId = COMMENT_SHAPE_TYPE_ID;
        xmlObjectNewInstance2.setId(COMMENT_SHAPE_TYPE_ID);
        xmlObjectNewInstance2.setCoordsize("21600,21600");
        xmlObjectNewInstance2.setSpt(202.0f);
        xmlObjectNewInstance2.setPath2("m,l,21600r21600,l21600,xe");
        xmlObjectNewInstance2.addNewStroke().setJoinstyle(STStrokeJoinStyle.MITER);
        CTPath cTPathAddNewPath = xmlObjectNewInstance2.addNewPath();
        cTPathAddNewPath.setGradientshapeok(STTrueFalse.T);
        cTPathAddNewPath.setConnecttype(STConnectType.RECT);
        this._items.add(xmlObjectNewInstance2);
        this._qnames.add(QNAME_SHAPE_TYPE);
    }

    protected CTShape newCommentShape() {
        XmlObject xmlObjectNewInstance = CTShape.Factory.newInstance();
        StringBuilder sb = new StringBuilder("_x0000_s");
        int i = this._shapeId + 1;
        this._shapeId = i;
        xmlObjectNewInstance.setId(sb.append(i).toString());
        xmlObjectNewInstance.setType("#" + this._shapeTypeId);
        xmlObjectNewInstance.setStyle("position:absolute; visibility:hidden");
        xmlObjectNewInstance.setFillcolor("#ffffe1");
        xmlObjectNewInstance.setInsetmode(STInsetMode.AUTO);
        xmlObjectNewInstance.addNewFill().setColor("#ffffe1");
        CTShadow cTShadowAddNewShadow = xmlObjectNewInstance.addNewShadow();
        cTShadowAddNewShadow.setOn(STTrueFalse.T);
        cTShadowAddNewShadow.setColor("black");
        cTShadowAddNewShadow.setObscured(STTrueFalse.T);
        xmlObjectNewInstance.addNewPath().setConnecttype(STConnectType.NONE);
        xmlObjectNewInstance.addNewTextbox().setStyle("mso-direction-alt:auto");
        CTClientData cTClientDataAddNewClientData = xmlObjectNewInstance.addNewClientData();
        cTClientDataAddNewClientData.setObjectType(STObjectType.NOTE);
        cTClientDataAddNewClientData.addNewMoveWithCells();
        cTClientDataAddNewClientData.addNewSizeWithCells();
        cTClientDataAddNewClientData.addNewAnchor().setStringValue("1, 15, 0, 2, 3, 15, 3, 16");
        cTClientDataAddNewClientData.addNewAutoFill().setStringValue("False");
        cTClientDataAddNewClientData.addNewRow().setBigIntegerValue(new BigInteger("0"));
        cTClientDataAddNewClientData.addNewColumn().setBigIntegerValue(new BigInteger("0"));
        this._items.add(xmlObjectNewInstance);
        this._qnames.add(QNAME_SHAPE);
        return xmlObjectNewInstance;
    }

    protected CTShape findCommentShape(int i, int i2) {
        Iterator<XmlObject> it = this._items.iterator();
        while (it.hasNext()) {
            CTShape cTShape = (XmlObject) it.next();
            if (cTShape instanceof CTShape) {
                CTShape cTShape2 = cTShape;
                if (cTShape2.sizeOfClientDataArray() > 0) {
                    CTClientData clientDataArray = cTShape2.getClientDataArray(0);
                    if (clientDataArray.getObjectType() == STObjectType.NOTE) {
                        int iIntValue = clientDataArray.getRowArray(0).intValue();
                        int iIntValue2 = clientDataArray.getColumnArray(0).intValue();
                        if (iIntValue == i && iIntValue2 == i2) {
                            return cTShape2;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    protected boolean removeCommentShape(int i, int i2) {
        CTShape cTShapeFindCommentShape = findCommentShape(i, i2);
        return cTShapeFindCommentShape != null && this._items.remove(cTShapeFindCommentShape);
    }
}
