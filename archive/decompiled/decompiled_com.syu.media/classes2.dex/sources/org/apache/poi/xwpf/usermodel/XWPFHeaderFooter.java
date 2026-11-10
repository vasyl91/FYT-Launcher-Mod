package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class XWPFHeaderFooter extends POIXMLDocumentPart implements IBody {
    List<IBodyElement> bodyElements;
    XWPFDocument document;
    CTHdrFtr headerFooter;
    List<XWPFParagraph> paragraphs;
    List<XWPFPictureData> pictures;
    List<XWPFTable> tables;

    public POIXMLDocumentPart getOwner() {
        return this;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this;
    }

    XWPFHeaderFooter(XWPFDocument xWPFDocument, CTHdrFtr cTHdrFtr) {
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
        xWPFDocument.getClass();
        this.document = xWPFDocument;
        this.headerFooter = cTHdrFtr;
        readHdrFtr();
    }

    protected XWPFHeaderFooter() {
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
        this.headerFooter = CTHdrFtr.Factory.newInstance();
        readHdrFtr();
    }

    public XWPFHeaderFooter(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) throws IOException {
        super(pOIXMLDocumentPart, packagePart);
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
        XWPFDocument xWPFDocument = (XWPFDocument) getParent();
        this.document = xWPFDocument;
        xWPFDocument.getClass();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XWPFPictureData) {
                XWPFPictureData xWPFPictureData = (XWPFPictureData) pOIXMLDocumentPart;
                this.pictures.add(xWPFPictureData);
                this.document.registerPackagePictureData(xWPFPictureData);
            }
        }
    }

    @Internal
    public CTHdrFtr _getHdrFtr() {
        return this.headerFooter;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return Collections.unmodifiableList(this.bodyElements);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFParagraph> getParagraphs() {
        return Collections.unmodifiableList(this.paragraphs);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFTable> getTables() throws ArrayIndexOutOfBoundsException {
        return Collections.unmodifiableList(this.tables);
    }

    public String getText() {
        String text;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.paragraphs.size(); i++) {
            if (!this.paragraphs.get(i).isEmpty() && (text = this.paragraphs.get(i).getText()) != null && text.length() > 0) {
                stringBuffer.append(text);
                stringBuffer.append('\n');
            }
        }
        for (int i2 = 0; i2 < this.tables.size(); i2++) {
            String text2 = this.tables.get(i2).getText();
            if (text2 != null && text2.length() > 0) {
                stringBuffer.append(text2);
                stringBuffer.append('\n');
            }
        }
        for (IBodyElement iBodyElement : getBodyElements()) {
            if (iBodyElement instanceof XWPFSDT) {
                stringBuffer.append(((XWPFSDT) iBodyElement).getContent().getText() + '\n');
            }
        }
        return stringBuffer.toString();
    }

    public void setHeaderFooter(CTHdrFtr cTHdrFtr) {
        this.headerFooter = cTHdrFtr;
        readHdrFtr();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTable(CTTbl cTTbl) {
        XWPFTable next;
        Iterator<XWPFTable> it = this.tables.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next.getCTTbl().equals(cTTbl)) {
                return next;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraph(CTP ctp) {
        for (XWPFParagraph xWPFParagraph : this.paragraphs) {
            if (xWPFParagraph.getCTP().equals(ctp)) {
                return xWPFParagraph;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraphArray(int i) {
        if (i < 0 || i >= this.paragraphs.size()) {
            return null;
        }
        return this.paragraphs.get(i);
    }

    public List<XWPFParagraph> getListParagraph() {
        return this.paragraphs;
    }

    public List<XWPFPictureData> getAllPictures() {
        return Collections.unmodifiableList(this.pictures);
    }

    public List<XWPFPictureData> getAllPackagePictures() {
        return this.document.getAllPackagePictures();
    }

    public String addPictureData(byte[] bArr, int i) throws InvalidFormatException {
        XWPFPictureData xWPFPictureDataFindPackagePictureData = this.document.findPackagePictureData(bArr, i);
        POIXMLRelation pOIXMLRelation = XWPFPictureData.RELATIONS[i];
        OutputStream outputStream = null;
        if (xWPFPictureDataFindPackagePictureData == null) {
            XWPFPictureData xWPFPictureData = (XWPFPictureData) createRelationship(pOIXMLRelation, XWPFFactory.getInstance(), this.document.getNextPicNameNumber(i));
            try {
                try {
                    outputStream = xWPFPictureData.getPackagePart().getOutputStream();
                    outputStream.write(bArr);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    this.document.registerPackagePictureData(xWPFPictureData);
                    this.pictures.add(xWPFPictureData);
                    return getRelationId(xWPFPictureData);
                } catch (IOException e) {
                    throw new POIXMLException(e);
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
        if (!getRelations().contains(xWPFPictureDataFindPackagePictureData)) {
            POIXMLDocumentPart.RelationPart relationPartAddRelation = addRelation(null, XWPFRelation.IMAGES, xWPFPictureDataFindPackagePictureData);
            this.pictures.add(xWPFPictureDataFindPackagePictureData);
            return relationPartAddRelation.getRelationship().getId();
        }
        return getRelationId(xWPFPictureDataFindPackagePictureData);
    }

    public String addPictureData(InputStream inputStream, int i) throws InvalidFormatException, IOException {
        return addPictureData(IOUtils.toByteArray(inputStream), i);
    }

    public XWPFPictureData getPictureDataByID(String str) {
        POIXMLDocumentPart relationById = getRelationById(str);
        if (relationById == null || !(relationById instanceof XWPFPictureData)) {
            return null;
        }
        return (XWPFPictureData) relationById;
    }

    public XWPFParagraph createParagraph() {
        XWPFParagraph xWPFParagraph = new XWPFParagraph(this.headerFooter.addNewP(), this);
        this.paragraphs.add(xWPFParagraph);
        this.bodyElements.add(xWPFParagraph);
        return xWPFParagraph;
    }

    public XWPFTable createTable(int i, int i2) {
        XWPFTable xWPFTable = new XWPFTable(this.headerFooter.addNewTbl(), this, i, i2);
        this.tables.add(xWPFTable);
        this.bodyElements.add(xWPFTable);
        return xWPFTable;
    }

    public void removeParagraph(XWPFParagraph xWPFParagraph) {
        if (this.paragraphs.contains(xWPFParagraph)) {
            XmlCursor xmlCursorNewCursor = xWPFParagraph.getCTP().newCursor();
            xmlCursorNewCursor.removeXml();
            xmlCursorNewCursor.dispose();
            this.paragraphs.remove(xWPFParagraph);
            this.bodyElements.remove(xWPFParagraph);
        }
    }

    public void removeTable(XWPFTable xWPFTable) {
        if (this.tables.contains(xWPFTable)) {
            XmlCursor xmlCursorNewCursor = xWPFTable.getCTTbl().newCursor();
            xmlCursorNewCursor.removeXml();
            xmlCursorNewCursor.dispose();
            this.tables.remove(xWPFTable);
            this.bodyElements.remove(xWPFTable);
        }
    }

    public void clearHeaderFooter() {
        XmlCursor xmlCursorNewCursor = this.headerFooter.newCursor();
        xmlCursorNewCursor.removeXmlContents();
        xmlCursorNewCursor.dispose();
        this.paragraphs.clear();
        this.tables.clear();
        this.bodyElements.clear();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph insertNewParagraph(XmlCursor xmlCursor) {
        boolean z;
        CTP ctp;
        XmlObject object = null;
        if (!isCursorInHdrF(xmlCursor)) {
            return null;
        }
        xmlCursor.beginElement("p", CTP.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTP ctp2 = (CTP) xmlCursor.getObject();
        XWPFParagraph xWPFParagraph = new XWPFParagraph(ctp2, this);
        while (true) {
            z = object instanceof CTP;
            if (z || !xmlCursor.toPrevSibling()) {
                break;
            }
            object = xmlCursor.getObject();
        }
        int i = 0;
        if (!z || (ctp = (CTP) object) == ctp2) {
            this.paragraphs.add(0, xWPFParagraph);
        } else {
            this.paragraphs.add(this.paragraphs.indexOf(getParagraph(ctp)) + 1, xWPFParagraph);
        }
        XmlCursor xmlCursorNewCursor = ctp2.newCursor();
        xmlCursor.toCursor(xmlCursorNewCursor);
        xmlCursorNewCursor.dispose();
        while (xmlCursor.toPrevSibling()) {
            XmlObject object2 = xmlCursor.getObject();
            if ((object2 instanceof CTP) || (object2 instanceof CTTbl)) {
                i++;
            }
        }
        this.bodyElements.add(i, xWPFParagraph);
        XmlCursor xmlCursorNewCursor2 = ctp2.newCursor();
        xmlCursor.toCursor(xmlCursorNewCursor2);
        xmlCursor.toEndToken();
        xmlCursorNewCursor2.dispose();
        return xWPFParagraph;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable insertNewTbl(XmlCursor xmlCursor) {
        boolean z;
        XmlObject object = null;
        if (!isCursorInHdrF(xmlCursor)) {
            return null;
        }
        xmlCursor.beginElement("tbl", CTTbl.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTTbl object2 = xmlCursor.getObject();
        XWPFTable xWPFTable = new XWPFTable(object2, this);
        xmlCursor.removeXmlContents();
        while (true) {
            z = object instanceof CTTbl;
            if (z || !xmlCursor.toPrevSibling()) {
                break;
            }
            object = xmlCursor.getObject();
        }
        int i = 0;
        if (!z) {
            this.tables.add(0, xWPFTable);
        } else {
            this.tables.add(this.tables.indexOf(getTable((CTTbl) object)) + 1, xWPFTable);
        }
        XmlCursor xmlCursorNewCursor = object2.newCursor();
        while (xmlCursorNewCursor.toPrevSibling()) {
            XmlObject object3 = xmlCursorNewCursor.getObject();
            if ((object3 instanceof CTP) || (object3 instanceof CTTbl)) {
                i++;
            }
        }
        xmlCursorNewCursor.dispose();
        this.bodyElements.add(i, xWPFTable);
        XmlCursor xmlCursorNewCursor2 = object2.newCursor();
        xmlCursor.toCursor(xmlCursorNewCursor2);
        xmlCursor.toEndToken();
        xmlCursorNewCursor2.dispose();
        return xWPFTable;
    }

    private boolean isCursorInHdrF(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        xmlCursorNewCursor.toParent();
        boolean z = xmlCursorNewCursor.getObject() == this.headerFooter;
        xmlCursorNewCursor.dispose();
        return z;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTableArray(int i) {
        if (i < 0 || i >= this.tables.size()) {
            return null;
        }
        return this.tables.get(i);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public void insertTable(int i, XWPFTable xWPFTable) {
        this.bodyElements.add(i, xWPFTable);
        CTTbl[] tblArray = this.headerFooter.getTblArray();
        int length = tblArray.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length && tblArray[i3] != xWPFTable.getCTTbl(); i3++) {
            i2++;
        }
        this.tables.add(i2, xWPFTable);
    }

    public void readHdrFtr() {
        this.bodyElements = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        XmlCursor xmlCursorNewCursor = this.headerFooter.newCursor();
        xmlCursorNewCursor.selectPath("./*");
        while (xmlCursorNewCursor.toNextSelection()) {
            CTP object = xmlCursorNewCursor.getObject();
            if (object instanceof CTP) {
                XWPFParagraph xWPFParagraph = new XWPFParagraph(object, this);
                this.paragraphs.add(xWPFParagraph);
                this.bodyElements.add(xWPFParagraph);
            }
            if (object instanceof CTTbl) {
                XWPFTable xWPFTable = new XWPFTable((CTTbl) object, this);
                this.tables.add(xWPFTable);
                this.bodyElements.add(xWPFTable);
            }
        }
        xmlCursorNewCursor.dispose();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTableCell getTableCell(CTTc cTTc) {
        XWPFTable table;
        XmlCursor xmlCursorNewCursor = cTTc.newCursor();
        xmlCursorNewCursor.toParent();
        XmlObject object = xmlCursorNewCursor.getObject();
        if (!(object instanceof CTRow)) {
            xmlCursorNewCursor.dispose();
            return null;
        }
        CTRow cTRow = (CTRow) object;
        xmlCursorNewCursor.toParent();
        XmlObject object2 = xmlCursorNewCursor.getObject();
        xmlCursorNewCursor.dispose();
        if ((object2 instanceof CTTbl) && (table = getTable((CTTbl) object2)) != null) {
            return table.getRow(cTRow).getTableCell(cTTc);
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        XWPFDocument xWPFDocument = this.document;
        return xWPFDocument != null ? xWPFDocument : (XWPFDocument) getParent();
    }

    public void setXWPFDocument(XWPFDocument xWPFDocument) {
        this.document = xWPFDocument;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void prepareForCommit() {
        if (this.bodyElements.size() == 0) {
            createParagraph();
        }
        Iterator<XWPFTable> it = this.tables.iterator();
        while (it.hasNext()) {
            Iterator<XWPFTableRow> it2 = it.next().tableRows.iterator();
            while (it2.hasNext()) {
                for (XWPFTableCell xWPFTableCell : it2.next().getTableCells()) {
                    if (xWPFTableCell.getBodyElements().size() == 0) {
                        xWPFTableCell.addParagraph();
                    }
                }
            }
        }
        super.prepareForCommit();
    }
}
