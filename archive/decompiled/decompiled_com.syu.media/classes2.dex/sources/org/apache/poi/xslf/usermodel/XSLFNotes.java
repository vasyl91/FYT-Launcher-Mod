package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.Notes;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSLFNotes extends XSLFSheet implements Notes<XSLFShape, XSLFTextParagraph> {
    private CTNotesSlide _notes;

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    protected String getRootElementName() {
        return "notes";
    }

    XSLFNotes() {
        CTNotesSlide cTNotesSlidePrototype = prototype();
        this._notes = cTNotesSlidePrototype;
        setCommonSlideData(cTNotesSlidePrototype.getCSld());
    }

    XSLFNotes(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        CTNotesSlide notes = NotesDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getNotes();
        this._notes = notes;
        setCommonSlideData(notes.getCSld());
    }

    private static CTNotesSlide prototype() {
        CTNotesSlide cTNotesSlideNewInstance = CTNotesSlide.Factory.newInstance();
        cTNotesSlideNewInstance.addNewCSld().addNewSpTree();
        return cTNotesSlideNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTNotesSlide getXmlObject() {
        return this._notes;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        return getMasterSheet().getTheme();
    }

    @Override // org.apache.poi.sl.usermodel.Sheet
    public XSLFNotesMaster getMasterSheet() {
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XSLFNotesMaster) {
                return (XSLFNotesMaster) pOIXMLDocumentPart;
            }
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.Notes
    public List<List<XSLFTextParagraph>> getTextParagraphs() {
        ArrayList arrayList = new ArrayList();
        for (XSLFShape xSLFShape : super.getShapes()) {
            if (xSLFShape instanceof XSLFTextShape) {
                arrayList.add(((XSLFTextShape) xSLFShape).getTextParagraphs());
            }
        }
        return arrayList;
    }
}
