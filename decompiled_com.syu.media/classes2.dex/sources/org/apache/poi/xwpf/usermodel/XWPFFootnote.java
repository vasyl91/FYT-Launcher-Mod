package org.apache.poi.xwpf.usermodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFFootnote implements Iterable<XWPFParagraph>, IBody {
    private CTFtnEdn ctFtnEdn;
    private XWPFDocument document;
    private XWPFFootnotes footnotes;
    private List<XWPFParagraph> paragraphs = new ArrayList();
    private List<XWPFTable> tables = new ArrayList();
    private List<XWPFPictureData> pictures = new ArrayList();
    private List<IBodyElement> bodyElements = new ArrayList();

    public XWPFFootnote(CTFtnEdn cTFtnEdn, XWPFFootnotes xWPFFootnotes) {
        this.footnotes = xWPFFootnotes;
        this.ctFtnEdn = cTFtnEdn;
        this.document = xWPFFootnotes.getXWPFDocument();
        init();
    }

    public XWPFFootnote(XWPFDocument xWPFDocument, CTFtnEdn cTFtnEdn) {
        this.ctFtnEdn = cTFtnEdn;
        this.document = xWPFDocument;
        init();
    }

    private void init() {
        XmlCursor xmlCursorNewCursor = this.ctFtnEdn.newCursor();
        xmlCursorNewCursor.selectPath("./*");
        while (xmlCursorNewCursor.toNextSelection()) {
            CTSdtBlock object = xmlCursorNewCursor.getObject();
            if (object instanceof CTP) {
                XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP) object, this);
                this.bodyElements.add(xWPFParagraph);
                this.paragraphs.add(xWPFParagraph);
            } else if (object instanceof CTTbl) {
                XWPFTable xWPFTable = new XWPFTable((CTTbl) object, this);
                this.bodyElements.add(xWPFTable);
                this.tables.add(xWPFTable);
            } else if (object instanceof CTSdtBlock) {
                this.bodyElements.add(new XWPFSDT(object, this));
            }
        }
        xmlCursorNewCursor.dispose();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFParagraph> getParagraphs() {
        return this.paragraphs;
    }

    @Override // java.lang.Iterable
    public Iterator<XWPFParagraph> iterator() {
        return this.paragraphs.iterator();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFTable> getTables() {
        return this.tables;
    }

    public List<XWPFPictureData> getPictures() {
        return this.pictures;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return this.bodyElements;
    }

    public CTFtnEdn getCTFtnEdn() {
        return this.ctFtnEdn;
    }

    public void setCTFtnEdn(CTFtnEdn cTFtnEdn) {
        this.ctFtnEdn = cTFtnEdn;
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
        CTTbl[] tblArray = this.ctFtnEdn.getTblArray();
        int length = tblArray.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length && tblArray[i3] != xWPFTable.getCTTbl(); i3++) {
            i2++;
        }
        this.tables.add(i2, xWPFTable);
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

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTableCell getTableCell(CTTc cTTc) {
        XWPFTable table;
        XWPFTableRow row;
        XmlCursor xmlCursorNewCursor = cTTc.newCursor();
        xmlCursorNewCursor.toParent();
        XmlObject object = xmlCursorNewCursor.getObject();
        if (!(object instanceof CTRow)) {
            return null;
        }
        CTRow cTRow = (CTRow) object;
        xmlCursorNewCursor.toParent();
        XmlObject object2 = xmlCursorNewCursor.getObject();
        xmlCursorNewCursor.dispose();
        if (!(object2 instanceof CTTbl) || (table = getTable((CTTbl) object2)) == null || (row = table.getRow(cTRow)) == null) {
            return null;
        }
        return row.getTableCell(cTTc);
    }

    private boolean isCursorInFtn(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        xmlCursorNewCursor.toParent();
        return xmlCursorNewCursor.getObject() == this.ctFtnEdn;
    }

    public POIXMLDocumentPart getOwner() {
        return this.footnotes;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable insertNewTbl(XmlCursor xmlCursor) {
        boolean z;
        XmlObject object = null;
        if (!isCursorInFtn(xmlCursor)) {
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
        this.bodyElements.add(i, xWPFTable);
        XmlCursor xmlCursorNewCursor2 = object2.newCursor();
        xmlCursorNewCursor.toCursor(xmlCursorNewCursor2);
        xmlCursorNewCursor.toEndToken();
        xmlCursorNewCursor2.dispose();
        return xWPFTable;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph insertNewParagraph(XmlCursor xmlCursor) {
        boolean z;
        CTP ctp;
        XmlObject object = null;
        if (!isCursorInFtn(xmlCursor)) {
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

    public XWPFTable addNewTbl(CTTbl cTTbl) {
        CTTbl cTTblAddNewTbl = this.ctFtnEdn.addNewTbl();
        cTTblAddNewTbl.set(cTTbl);
        XWPFTable xWPFTable = new XWPFTable(cTTblAddNewTbl, this);
        this.tables.add(xWPFTable);
        return xWPFTable;
    }

    public XWPFParagraph addNewParagraph(CTP ctp) {
        CTP ctpAddNewP = this.ctFtnEdn.addNewP();
        ctpAddNewP.set(ctp);
        XWPFParagraph xWPFParagraph = new XWPFParagraph(ctpAddNewP, this);
        this.paragraphs.add(xWPFParagraph);
        return xWPFParagraph;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        return this.document;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this.footnotes;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.FOOTNOTE;
    }
}
