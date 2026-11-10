package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CommentsDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CommentsDocumentImpl extends XmlComplexContentImpl implements CommentsDocument {
    private static final QName COMMENTS$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "comments");

    public CommentsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CommentsDocument
    public CTComments addNewComments() {
        CTComments cTCommentsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentsAdd_element_user = get_store().add_element_user(COMMENTS$0);
        }
        return cTCommentsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CommentsDocument
    public CTComments getComments() {
        synchronized (monitor()) {
            check_orphaned();
            CTComments cTCommentsFind_element_user = get_store().find_element_user(COMMENTS$0, 0);
            if (cTCommentsFind_element_user == null) {
                return null;
            }
            return cTCommentsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CommentsDocument
    public void setComments(CTComments cTComments) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMMENTS$0;
            CTComments cTCommentsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCommentsFind_element_user == null) {
                cTCommentsFind_element_user = (CTComments) get_store().add_element_user(qName);
            }
            cTCommentsFind_element_user.set(cTComments);
        }
    }
}
