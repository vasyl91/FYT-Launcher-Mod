package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFHeader extends XWPFHeaderFooter {
    public XWPFHeader() {
    }

    public XWPFHeader(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) throws IOException {
        super(pOIXMLDocumentPart, packagePart);
    }

    public XWPFHeader(XWPFDocument xWPFDocument, CTHdrFtr cTHdrFtr) {
        super(xWPFDocument, cTHdrFtr);
        XmlCursor xmlCursorNewCursor = this.headerFooter.newCursor();
        xmlCursorNewCursor.selectPath("./*");
        while (xmlCursorNewCursor.toNextSelection()) {
            CTP object = xmlCursorNewCursor.getObject();
            if (object instanceof CTP) {
                this.paragraphs.add(new XWPFParagraph(object, this));
            }
            if (object instanceof CTTbl) {
                this.tables.add(new XWPFTable((CTTbl) object, this));
            }
        }
        xmlCursorNewCursor.dispose();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTNumbering.type.getName().getNamespaceURI(), "hdr"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        super._getHdrFtr().save(outputStream, xmlOptions);
        outputStream.close();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0073 */
    @Override // org.apache.poi.xwpf.usermodel.XWPFHeaderFooter, org.apache.poi.POIXMLDocumentPart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDocumentRead() throws java.io.IOException {
        /*
            r5 = this;
            super.onDocumentRead()
            r0 = 0
            org.apache.poi.openxml4j.opc.PackagePart r1 = r5.getPackagePart()     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            java.io.InputStream r0 = r1.getInputStream()     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            org.apache.xmlbeans.XmlOptions r1 = org.apache.poi.POIXMLTypeLoader.DEFAULT_XML_OPTIONS     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument r1 = org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument.Factory.parse(r0, r1)     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr r1 = r1.getHdr()     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            r5.headerFooter = r1     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr r1 = r5.headerFooter     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            org.apache.xmlbeans.XmlCursor r1 = r1.newCursor()     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            java.lang.String r2 = "./*"
            r1.selectPath(r2)     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
        L23:
            boolean r2 = r1.toNextSelection()     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            if (r2 == 0) goto L6a
            org.apache.xmlbeans.XmlObject r2 = r1.getObject()     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            boolean r3 = r2 instanceof org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            if (r3 == 0) goto L43
            org.apache.poi.xwpf.usermodel.XWPFParagraph r3 = new org.apache.poi.xwpf.usermodel.XWPFParagraph     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            r4 = r2
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP r4 = (org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP) r4     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            java.util.List<org.apache.poi.xwpf.usermodel.XWPFParagraph> r4 = r5.paragraphs     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            r4.add(r3)     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            java.util.List<org.apache.poi.xwpf.usermodel.IBodyElement> r4 = r5.bodyElements     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            r4.add(r3)     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
        L43:
            boolean r3 = r2 instanceof org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            if (r3 == 0) goto L59
            org.apache.poi.xwpf.usermodel.XWPFTable r3 = new org.apache.poi.xwpf.usermodel.XWPFTable     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            r4 = r2
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl r4 = (org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl) r4     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            java.util.List<org.apache.poi.xwpf.usermodel.XWPFTable> r4 = r5.tables     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            r4.add(r3)     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            java.util.List<org.apache.poi.xwpf.usermodel.IBodyElement> r4 = r5.bodyElements     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            r4.add(r3)     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
        L59:
            boolean r3 = r2 instanceof org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            if (r3 == 0) goto L23
            org.apache.poi.xwpf.usermodel.XWPFSDT r3 = new org.apache.poi.xwpf.usermodel.XWPFSDT     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock r2 = (org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock) r2     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            r3.<init>(r2, r5)     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            java.util.List<org.apache.poi.xwpf.usermodel.IBodyElement> r2 = r5.bodyElements     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            r2.add(r3)     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            goto L23
        L6a:
            r1.dispose()     // Catch: java.lang.Throwable -> L73 org.apache.xmlbeans.XmlException -> L75
            if (r0 == 0) goto L72
            r0.close()
        L72:
            return
        L73:
            r1 = move-exception
            goto L7c
        L75:
            r1 = move-exception
            org.apache.poi.POIXMLException r2 = new org.apache.poi.POIXMLException     // Catch: java.lang.Throwable -> L73
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L73
            throw r2     // Catch: java.lang.Throwable -> L73
        L7c:
            if (r0 == 0) goto L81
            r0.close()
        L81:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.xwpf.usermodel.XWPFHeader.onDocumentRead():void");
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.HEADER;
    }
}
