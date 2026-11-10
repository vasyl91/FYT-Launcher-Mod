package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.presentationml.x2006.main.CmLstDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFComments extends POIXMLDocumentPart {
    private final CTCommentList _comments;

    XSLFComments() {
        this._comments = CmLstDocument.Factory.newInstance().addNewCmLst();
    }

    XSLFComments(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        this._comments = CmLstDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getCmLst();
    }

    public CTCommentList getCTCommentsList() {
        return this._comments;
    }

    public int getNumberOfComments() {
        return this._comments.sizeOfCmArray();
    }

    public CTComment getCommentAt(int i) {
        return this._comments.getCmArray(i);
    }
}
