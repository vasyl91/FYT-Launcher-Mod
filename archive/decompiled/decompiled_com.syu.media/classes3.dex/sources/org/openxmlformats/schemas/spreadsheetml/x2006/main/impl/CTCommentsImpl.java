package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCommentsImpl extends XmlComplexContentImpl implements CTComments {
    private static final QName AUTHORS$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "authors");
    private static final QName COMMENTLIST$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "commentList");
    private static final QName EXTLST$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");

    public CTCommentsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public CTAuthors addNewAuthors() {
        CTAuthors cTAuthors;
        synchronized (monitor()) {
            check_orphaned();
            cTAuthors = (CTAuthors) get_store().add_element_user(AUTHORS$0);
        }
        return cTAuthors;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public CTCommentList addNewCommentList() {
        CTCommentList cTCommentList;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentList = (CTCommentList) get_store().add_element_user(COMMENTLIST$2);
        }
        return cTCommentList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$4);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public CTAuthors getAuthors() {
        synchronized (monitor()) {
            check_orphaned();
            CTAuthors cTAuthors = (CTAuthors) get_store().find_element_user(AUTHORS$0, 0);
            if (cTAuthors == null) {
                return null;
            }
            return cTAuthors;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public CTCommentList getCommentList() {
        synchronized (monitor()) {
            check_orphaned();
            CTCommentList cTCommentList = (CTCommentList) get_store().find_element_user(COMMENTLIST$2, 0);
            if (cTCommentList == null) {
                return null;
            }
            return cTCommentList;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$4, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public void setAuthors(CTAuthors cTAuthors) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTHORS$0;
            CTAuthors cTAuthors2 = (CTAuthors) typeStore.find_element_user(qName, 0);
            if (cTAuthors2 == null) {
                cTAuthors2 = (CTAuthors) get_store().add_element_user(qName);
            }
            cTAuthors2.set(cTAuthors);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public void setCommentList(CTCommentList cTCommentList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMMENTLIST$2;
            CTCommentList cTCommentList2 = (CTCommentList) typeStore.find_element_user(qName, 0);
            if (cTCommentList2 == null) {
                cTCommentList2 = (CTCommentList) get_store().add_element_user(qName);
            }
            cTCommentList2.set(cTCommentList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$4;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$4, 0);
        }
    }
}
