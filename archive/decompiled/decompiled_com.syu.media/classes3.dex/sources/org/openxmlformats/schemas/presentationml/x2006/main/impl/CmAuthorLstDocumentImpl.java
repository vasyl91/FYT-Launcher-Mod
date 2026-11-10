package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList;
import org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CmAuthorLstDocumentImpl extends XmlComplexContentImpl implements CmAuthorLstDocument {
    private static final QName CMAUTHORLST$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cmAuthorLst");

    public CmAuthorLstDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument
    public CTCommentAuthorList addNewCmAuthorLst() {
        CTCommentAuthorList cTCommentAuthorList;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentAuthorList = (CTCommentAuthorList) get_store().add_element_user(CMAUTHORLST$0);
        }
        return cTCommentAuthorList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument
    public CTCommentAuthorList getCmAuthorLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTCommentAuthorList cTCommentAuthorList = (CTCommentAuthorList) get_store().find_element_user(CMAUTHORLST$0, 0);
            if (cTCommentAuthorList == null) {
                return null;
            }
            return cTCommentAuthorList;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument
    public void setCmAuthorLst(CTCommentAuthorList cTCommentAuthorList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CMAUTHORLST$0;
            CTCommentAuthorList cTCommentAuthorList2 = (CTCommentAuthorList) typeStore.find_element_user(qName, 0);
            if (cTCommentAuthorList2 == null) {
                cTCommentAuthorList2 = (CTCommentAuthorList) get_store().add_element_user(qName);
            }
            cTCommentAuthorList2.set(cTCommentAuthorList);
        }
    }
}
