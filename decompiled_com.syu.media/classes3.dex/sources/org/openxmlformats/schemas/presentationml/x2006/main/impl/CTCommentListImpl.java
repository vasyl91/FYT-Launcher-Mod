package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCommentListImpl extends XmlComplexContentImpl implements CTCommentList {
    private static final QName CM$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cm");

    public CTCommentListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public CTComment addNewCm() {
        CTComment cTComment;
        synchronized (monitor()) {
            check_orphaned();
            cTComment = (CTComment) get_store().add_element_user(CM$0);
        }
        return cTComment;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public CTComment getCmArray(int i) {
        CTComment cTComment;
        synchronized (monitor()) {
            check_orphaned();
            cTComment = (CTComment) get_store().find_element_user(CM$0, i);
            if (cTComment == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTComment;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public CTComment[] getCmArray() {
        CTComment[] cTCommentArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CM$0, arrayList);
            cTCommentArr = new CTComment[arrayList.size()];
            arrayList.toArray(cTCommentArr);
        }
        return cTCommentArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public List<CTComment> getCmList() {
        1CmList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CmList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public CTComment insertNewCm(int i) {
        CTComment cTComment;
        synchronized (monitor()) {
            check_orphaned();
            cTComment = (CTComment) get_store().insert_element_user(CM$0, i);
        }
        return cTComment;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public void removeCm(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CM$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public void setCmArray(int i, CTComment cTComment) {
        synchronized (monitor()) {
            check_orphaned();
            CTComment cTComment2 = (CTComment) get_store().find_element_user(CM$0, i);
            if (cTComment2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTComment2.set(cTComment);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public void setCmArray(CTComment[] cTCommentArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCommentArr, CM$0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList
    public int sizeOfCmArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CM$0);
        }
        return iCount_elements;
    }
}
