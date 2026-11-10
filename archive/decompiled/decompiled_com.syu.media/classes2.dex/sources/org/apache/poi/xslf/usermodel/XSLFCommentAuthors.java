package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList;
import org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFCommentAuthors extends POIXMLDocumentPart {
    private final CTCommentAuthorList _authors;

    XSLFCommentAuthors() {
        this._authors = CmAuthorLstDocument.Factory.newInstance().addNewCmAuthorLst();
    }

    XSLFCommentAuthors(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        this._authors = CmAuthorLstDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getCmAuthorLst();
    }

    public CTCommentAuthorList getCTCommentAuthorsList() {
        return this._authors;
    }

    public CTCommentAuthor getAuthorById(long j) {
        for (CTCommentAuthor cTCommentAuthor : this._authors.getCmAuthorArray()) {
            if (cTCommentAuthor.getId() == j) {
                return cTCommentAuthor;
            }
        }
        return null;
    }
}
