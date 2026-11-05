package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTCommentsImpl extends XmlComplexContentImpl implements CTComments {
    private static final QName COMMENT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "comment");

    public CTCommentsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public CTComment addNewComment() {
        CTComment cTCommentAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentAdd_element_user = get_store().add_element_user(COMMENT$0);
        }
        return cTCommentAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public CTComment getCommentArray(int i) {
        CTComment cTCommentFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentFind_element_user = get_store().find_element_user(COMMENT$0, i);
            if (cTCommentFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCommentFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public List<CTComment> getCommentList() {
        1CommentList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CommentList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public CTComment insertNewComment(int i) {
        CTComment cTCommentInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentInsert_element_user = get_store().insert_element_user(COMMENT$0, i);
        }
        return cTCommentInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public void removeComment(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public void setCommentArray(int i, CTComment cTComment) {
        synchronized (monitor()) {
            check_orphaned();
            CTComment cTCommentFind_element_user = get_store().find_element_user(COMMENT$0, i);
            if (cTCommentFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCommentFind_element_user.set(cTComment);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public void setCommentArray(CTComment[] cTCommentArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCommentArr, COMMENT$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public int sizeOfCommentArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENT$0);
        }
        return iCount_elements;
    }
}
