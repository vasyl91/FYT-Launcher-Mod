package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCommentListImpl extends XmlComplexContentImpl implements CTCommentList {
    private static final QName COMMENT$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", JamXmlElements.COMMENT);

    public CTCommentListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList
    public CTComment addNewComment() {
        CTComment cTComment;
        synchronized (monitor()) {
            check_orphaned();
            cTComment = (CTComment) get_store().add_element_user(COMMENT$0);
        }
        return cTComment;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList
    public CTComment getCommentArray(int i) {
        CTComment cTComment;
        synchronized (monitor()) {
            check_orphaned();
            cTComment = (CTComment) get_store().find_element_user(COMMENT$0, i);
            if (cTComment == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTComment;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList
    public CTComment[] getCommentArray() {
        CTComment[] cTCommentArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENT$0, arrayList);
            cTCommentArr = new CTComment[arrayList.size()];
            arrayList.toArray(cTCommentArr);
        }
        return cTCommentArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList
    public List<CTComment> getCommentList() {
        1CommentList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList
    public CTComment insertNewComment(int i) {
        CTComment cTComment;
        synchronized (monitor()) {
            check_orphaned();
            cTComment = (CTComment) get_store().insert_element_user(COMMENT$0, i);
        }
        return cTComment;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList
    public void removeComment(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList
    public void setCommentArray(int i, CTComment cTComment) {
        synchronized (monitor()) {
            check_orphaned();
            CTComment cTComment2 = (CTComment) get_store().find_element_user(COMMENT$0, i);
            if (cTComment2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTComment2.set(cTComment);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList
    public void setCommentArray(CTComment[] cTCommentArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCommentArr, COMMENT$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList
    public int sizeOfCommentArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENT$0);
        }
        return iCount_elements;
    }
}
