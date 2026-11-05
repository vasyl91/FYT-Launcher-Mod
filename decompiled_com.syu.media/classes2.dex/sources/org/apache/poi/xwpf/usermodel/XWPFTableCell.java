package org.apache.poi.xwpf.usermodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFTableCell implements IBody, ICell {
    private static EnumMap<XWPFVertAlign, STVerticalJc.Enum> alignMap;
    private static HashMap<Integer, XWPFVertAlign> stVertAlignTypeMap;
    protected List<IBodyElement> bodyElements;
    private final CTTc ctTc;
    protected List<XWPFParagraph> paragraphs;
    protected IBody part;
    private XWPFTableRow tableRow;
    protected List<XWPFTable> tables;

    public enum XWPFVertAlign {
        TOP,
        CENTER,
        BOTH,
        BOTTOM
    }

    static {
        EnumMap<XWPFVertAlign, STVerticalJc.Enum> enumMap = new EnumMap<>(XWPFVertAlign.class);
        alignMap = enumMap;
        enumMap.put(XWPFVertAlign.TOP, STVerticalJc.Enum.forInt(1));
        alignMap.put(XWPFVertAlign.CENTER, STVerticalJc.Enum.forInt(2));
        alignMap.put(XWPFVertAlign.BOTH, STVerticalJc.Enum.forInt(3));
        alignMap.put(XWPFVertAlign.BOTTOM, STVerticalJc.Enum.forInt(4));
        HashMap<Integer, XWPFVertAlign> map = new HashMap<>();
        stVertAlignTypeMap = map;
        map.put(1, XWPFVertAlign.TOP);
        stVertAlignTypeMap.put(2, XWPFVertAlign.CENTER);
        stVertAlignTypeMap.put(3, XWPFVertAlign.BOTH);
        stVertAlignTypeMap.put(4, XWPFVertAlign.BOTTOM);
    }

    public XWPFTableCell(CTTc cTTc, XWPFTableRow xWPFTableRow, IBody iBody) {
        this.paragraphs = null;
        this.tables = null;
        this.bodyElements = null;
        this.ctTc = cTTc;
        this.part = iBody;
        this.tableRow = xWPFTableRow;
        if (cTTc.sizeOfPArray() < 1) {
            cTTc.addNewP();
        }
        this.bodyElements = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        XmlCursor xmlCursorNewCursor = cTTc.newCursor();
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
            if (object instanceof CTSdtBlock) {
                this.bodyElements.add(new XWPFSDT((CTSdtBlock) object, this));
            }
            if (object instanceof CTSdtRun) {
                XWPFSDT xwpfsdt = new XWPFSDT((CTSdtRun) object, this);
                System.out.println(xwpfsdt.getContent().getText());
                this.bodyElements.add(xwpfsdt);
            }
        }
        xmlCursorNewCursor.dispose();
    }

    @Internal
    public CTTc getCTTc() {
        return this.ctTc;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return Collections.unmodifiableList(this.bodyElements);
    }

    public void setParagraph(XWPFParagraph xWPFParagraph) {
        if (this.ctTc.sizeOfPArray() == 0) {
            this.ctTc.addNewP();
        }
        this.ctTc.setPArray(0, xWPFParagraph.getCTP());
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFParagraph> getParagraphs() {
        return this.paragraphs;
    }

    public XWPFParagraph addParagraph() {
        XWPFParagraph xWPFParagraph = new XWPFParagraph(this.ctTc.addNewP(), this);
        addParagraph(xWPFParagraph);
        return xWPFParagraph;
    }

    public void addParagraph(XWPFParagraph xWPFParagraph) {
        this.paragraphs.add(xWPFParagraph);
    }

    public void removeParagraph(int i) {
        this.paragraphs.remove(i);
        this.ctTc.removeP(i);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraph(CTP ctp) {
        for (XWPFParagraph xWPFParagraph : this.paragraphs) {
            if (ctp.equals(xWPFParagraph.getCTP())) {
                return xWPFParagraph;
            }
        }
        return null;
    }

    public XWPFTableRow getTableRow() {
        return this.tableRow;
    }

    public String getColor() {
        CTShd shd;
        CTTcPr tcPr = this.ctTc.getTcPr();
        if (tcPr == null || (shd = tcPr.getShd()) == null) {
            return null;
        }
        return shd.xgetFill().getStringValue();
    }

    public void setColor(String str) {
        CTTcPr tcPr = this.ctTc.isSetTcPr() ? this.ctTc.getTcPr() : this.ctTc.addNewTcPr();
        CTShd shd = tcPr.isSetShd() ? tcPr.getShd() : tcPr.addNewShd();
        shd.setColor(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        shd.setVal(STShd.CLEAR);
        shd.setFill(str);
    }

    public XWPFVertAlign getVerticalAlignment() {
        CTVerticalJc vAlign;
        CTTcPr tcPr = this.ctTc.getTcPr();
        if (tcPr == null || (vAlign = tcPr.getVAlign()) == null) {
            return null;
        }
        return stVertAlignTypeMap.get(Integer.valueOf(vAlign.getVal().intValue()));
    }

    public void setVerticalAlignment(XWPFVertAlign xWPFVertAlign) {
        (this.ctTc.isSetTcPr() ? this.ctTc.getTcPr() : this.ctTc.addNewTcPr()).addNewVAlign().setVal(alignMap.get(xWPFVertAlign));
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph insertNewParagraph(XmlCursor xmlCursor) {
        boolean z;
        CTP ctp;
        XmlObject object = null;
        if (!isCursorInTableCell(xmlCursor)) {
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
        xmlCursorNewCursor2.dispose();
        xmlCursor.toEndToken();
        return xWPFParagraph;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable insertNewTbl(XmlCursor xmlCursor) {
        boolean z;
        XmlObject object = null;
        if (!isCursorInTableCell(xmlCursor)) {
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

    private boolean isCursorInTableCell(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        xmlCursorNewCursor.toParent();
        boolean z = xmlCursorNewCursor.getObject() == this.ctTc;
        xmlCursorNewCursor.dispose();
        return z;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraphArray(int i) {
        if (i < 0 || i >= this.paragraphs.size()) {
            return null;
        }
        return this.paragraphs.get(i);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this.tableRow.getTable().getPart();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.TABLECELL;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTable(CTTbl cTTbl) {
        for (int i = 0; i < this.tables.size(); i++) {
            if (getTables().get(i).getCTTbl() == cTTbl) {
                return getTables().get(i);
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTableArray(int i) {
        if (i < 0 || i >= this.tables.size()) {
            return null;
        }
        return this.tables.get(i);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFTable> getTables() {
        return Collections.unmodifiableList(this.tables);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public void insertTable(int i, XWPFTable xWPFTable) {
        this.bodyElements.add(i, xWPFTable);
        CTTbl[] tblArray = this.ctTc.getTblArray();
        int length = tblArray.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length && tblArray[i3] != xWPFTable.getCTTbl(); i3++) {
            i2++;
        }
        this.tables.add(i2, xWPFTable);
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        Iterator<XWPFParagraph> it = this.paragraphs.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getText());
        }
        return sb.toString();
    }

    public void setText(String str) {
        new XWPFParagraph(this.ctTc.sizeOfPArray() == 0 ? this.ctTc.addNewP() : this.ctTc.getPArray(0), this).createRun().setText(str);
    }

    public String getTextRecursively() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.bodyElements.size(); i++) {
            boolean z = true;
            if (i != this.bodyElements.size() - 1) {
                z = false;
            }
            appendBodyElementText(stringBuffer, this.bodyElements.get(i), z);
        }
        return stringBuffer.toString();
    }

    private void appendBodyElementText(StringBuffer stringBuffer, IBodyElement iBodyElement, boolean z) {
        if (iBodyElement instanceof XWPFParagraph) {
            stringBuffer.append(((XWPFParagraph) iBodyElement).getText());
            if (z) {
                return;
            }
            stringBuffer.append('\t');
            return;
        }
        if (iBodyElement instanceof XWPFTable) {
            Iterator<XWPFTableRow> it = ((XWPFTable) iBodyElement).getRows().iterator();
            while (it.hasNext()) {
                Iterator<XWPFTableCell> it2 = it.next().getTableCells().iterator();
                while (it2.hasNext()) {
                    List<IBodyElement> bodyElements = it2.next().getBodyElements();
                    for (int i = 0; i < bodyElements.size(); i++) {
                        boolean z2 = true;
                        if (i != bodyElements.size() - 1) {
                            z2 = false;
                        }
                        appendBodyElementText(stringBuffer, bodyElements.get(i), z2);
                    }
                }
            }
            if (z) {
                return;
            }
            stringBuffer.append('\n');
            return;
        }
        if (iBodyElement instanceof XWPFSDT) {
            stringBuffer.append(((XWPFSDT) iBodyElement).getContent().getText());
            if (z) {
                return;
            }
            stringBuffer.append('\t');
        }
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

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        return this.part.getXWPFDocument();
    }
}
