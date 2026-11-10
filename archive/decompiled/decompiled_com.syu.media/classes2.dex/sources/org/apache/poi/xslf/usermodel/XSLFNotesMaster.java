package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFNotesMaster extends XSLFSheet implements MasterSheet<XSLFShape, XSLFTextParagraph> {
    private CTNotesMaster _slide;
    private XSLFTheme _theme;

    @Override // org.apache.poi.sl.usermodel.Sheet
    public MasterSheet<XSLFShape, XSLFTextParagraph> getMasterSheet() {
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    protected String getRootElementName() {
        return "notesMaster";
    }

    XSLFNotesMaster() {
        this._slide = prototype();
    }

    protected XSLFNotesMaster(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        CTNotesMaster notesMaster = NotesMasterDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getNotesMaster();
        this._slide = notesMaster;
        setCommonSlideData(notesMaster.getCSld());
    }

    private static CTNotesMaster prototype() {
        InputStream resourceAsStream = XSLFNotesMaster.class.getResourceAsStream("notesMaster.xml");
        try {
            if (resourceAsStream == null) {
                throw new POIXMLException("Missing resource 'notesMaster.xml'");
            }
            try {
                return NotesMasterDocument.Factory.parse(resourceAsStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getNotesMaster();
            } finally {
                resourceAsStream.close();
            }
        } catch (Exception e) {
            throw new POIXMLException("Can't initialize NotesMaster", e);
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTNotesMaster getXmlObject() {
        return this._slide;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        if (this._theme == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFTheme) {
                    this._theme = (XSLFTheme) pOIXMLDocumentPart;
                    CTColorMapping clrMap = this._slide.getClrMap();
                    if (clrMap == null) {
                        break;
                    }
                    this._theme.initColorMap(clrMap);
                    break;
                }
            }
        }
        return this._theme;
    }
}
