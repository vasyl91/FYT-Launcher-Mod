package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFFootnotes extends POIXMLDocumentPart {
    private CTFootnotes ctFootnotes;
    protected XWPFDocument document;
    private List<XWPFFootnote> listFootnote;

    public XWPFFootnotes(PackagePart packagePart) throws OpenXML4JException, IOException {
        super(packagePart);
        this.listFootnote = new ArrayList();
    }

    public XWPFFootnotes() {
        this.listFootnote = new ArrayList();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        InputStream inputStream = null;
        try {
            try {
                inputStream = getPackagePart().getInputStream();
                this.ctFootnotes = FootnotesDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getFootnotes();
                if (inputStream != null) {
                    inputStream.close();
                }
                for (CTFtnEdn cTFtnEdn : this.ctFootnotes.getFootnoteArray()) {
                    this.listFootnote.add(new XWPFFootnote(cTFtnEdn, this));
                }
            } catch (XmlException unused) {
                throw new POIXMLException();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTFootnotes.type.getName().getNamespaceURI(), "footnotes"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.ctFootnotes.save(outputStream, xmlOptions);
        outputStream.close();
    }

    public List<XWPFFootnote> getFootnotesList() {
        return this.listFootnote;
    }

    public XWPFFootnote getFootnoteById(int i) {
        for (XWPFFootnote xWPFFootnote : this.listFootnote) {
            if (xWPFFootnote.getCTFtnEdn().getId().intValue() == i) {
                return xWPFFootnote;
            }
        }
        return null;
    }

    public void setFootnotes(CTFootnotes cTFootnotes) {
        this.ctFootnotes = cTFootnotes;
    }

    public void addFootnote(XWPFFootnote xWPFFootnote) {
        this.listFootnote.add(xWPFFootnote);
        this.ctFootnotes.addNewFootnote().set(xWPFFootnote.getCTFtnEdn());
    }

    public XWPFFootnote addFootnote(CTFtnEdn cTFtnEdn) {
        CTFtnEdn cTFtnEdnAddNewFootnote = this.ctFootnotes.addNewFootnote();
        cTFtnEdnAddNewFootnote.set(cTFtnEdn);
        XWPFFootnote xWPFFootnote = new XWPFFootnote(cTFtnEdnAddNewFootnote, this);
        this.listFootnote.add(xWPFFootnote);
        return xWPFFootnote;
    }

    public XWPFDocument getXWPFDocument() {
        XWPFDocument xWPFDocument = this.document;
        return xWPFDocument != null ? xWPFDocument : (XWPFDocument) getParent();
    }

    public void setXWPFDocument(XWPFDocument xWPFDocument) {
        this.document = xWPFDocument;
    }
}
