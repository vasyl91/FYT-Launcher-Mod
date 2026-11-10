package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CommentsDocumentImpl extends XmlComplexContentImpl implements CommentsDocument {
    private static final QName COMMENTS$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "comments");

    public CommentsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument
    public CTComments addNewComments() {
        CTComments cTComments;
        synchronized (monitor()) {
            check_orphaned();
            cTComments = (CTComments) get_store().add_element_user(COMMENTS$0);
        }
        return cTComments;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument
    public CTComments getComments() {
        synchronized (monitor()) {
            check_orphaned();
            CTComments cTComments = (CTComments) get_store().find_element_user(COMMENTS$0, 0);
            if (cTComments == null) {
                return null;
            }
            return cTComments;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument
    public void setComments(CTComments cTComments) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMMENTS$0;
            CTComments cTComments2 = (CTComments) typeStore.find_element_user(qName, 0);
            if (cTComments2 == null) {
                cTComments2 = (CTComments) get_store().add_element_user(qName);
            }
            cTComments2.set(cTComments);
        }
    }
}
