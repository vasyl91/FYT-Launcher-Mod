package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FtrDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFFooter extends XWPFHeaderFooter {
    public XWPFFooter() {
    }

    public XWPFFooter(XWPFDocument xWPFDocument, CTHdrFtr cTHdrFtr) throws IOException {
        super(xWPFDocument, cTHdrFtr);
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

    public XWPFFooter(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) throws IOException {
        super(pOIXMLDocumentPart, packagePart);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTNumbering.type.getName().getNamespaceURI(), "ftr"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        super._getHdrFtr().save(outputStream, xmlOptions);
        outputStream.close();
    }

    @Override // org.apache.poi.xwpf.usermodel.XWPFHeaderFooter, org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        super.onDocumentRead();
        InputStream inputStream = null;
        try {
            try {
                inputStream = getPackagePart().getInputStream();
                this.headerFooter = FtrDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getFtr();
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
                    if (object instanceof CTSdtBlock) {
                        this.bodyElements.add(new XWPFSDT((CTSdtBlock) object, this));
                    }
                }
                xmlCursorNewCursor.dispose();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                throw new POIXMLException(e);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.FOOTER;
    }
}
