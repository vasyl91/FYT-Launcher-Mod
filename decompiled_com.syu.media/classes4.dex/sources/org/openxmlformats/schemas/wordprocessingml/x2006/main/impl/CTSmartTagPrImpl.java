package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAttr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTSmartTagPrImpl extends XmlComplexContentImpl implements CTSmartTagPr {
    private static final QName ATTR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "attr");

    public CTSmartTagPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public CTAttr addNewAttr() {
        CTAttr cTAttrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAttrAdd_element_user = get_store().add_element_user(ATTR$0);
        }
        return cTAttrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public CTAttr getAttrArray(int i) {
        CTAttr cTAttrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAttrFind_element_user = get_store().find_element_user(ATTR$0, i);
            if (cTAttrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAttrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public CTAttr[] getAttrArray() {
        CTAttr[] cTAttrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTR$0, arrayList);
            cTAttrArr = new CTAttr[arrayList.size()];
            arrayList.toArray(cTAttrArr);
        }
        return cTAttrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public List<CTAttr> getAttrList() {
        1AttrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AttrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public CTAttr insertNewAttr(int i) {
        CTAttr cTAttrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAttrInsert_element_user = get_store().insert_element_user(ATTR$0, i);
        }
        return cTAttrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public void removeAttr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public void setAttrArray(int i, CTAttr cTAttr) {
        synchronized (monitor()) {
            check_orphaned();
            CTAttr cTAttrFind_element_user = get_store().find_element_user(ATTR$0, i);
            if (cTAttrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTAttrFind_element_user.set(cTAttr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public void setAttrArray(CTAttr[] cTAttrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTAttrArr, ATTR$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public int sizeOfAttrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ATTR$0);
        }
        return iCount_elements;
    }
}
