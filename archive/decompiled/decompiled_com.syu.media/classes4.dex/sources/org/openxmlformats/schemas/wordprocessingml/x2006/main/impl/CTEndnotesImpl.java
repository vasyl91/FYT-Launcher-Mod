package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTEndnotesImpl extends XmlComplexContentImpl implements CTEndnotes {
    private static final QName ENDNOTE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnote");

    public CTEndnotesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public CTFtnEdn addNewEndnote() {
        CTFtnEdn cTFtnEdnAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnAdd_element_user = get_store().add_element_user(ENDNOTE$0);
        }
        return cTFtnEdnAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public CTFtnEdn getEndnoteArray(int i) {
        CTFtnEdn cTFtnEdnFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnFind_element_user = get_store().find_element_user(ENDNOTE$0, i);
            if (cTFtnEdnFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFtnEdnFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public CTFtnEdn[] getEndnoteArray() {
        CTFtnEdn[] cTFtnEdnArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ENDNOTE$0, arrayList);
            cTFtnEdnArr = new CTFtnEdn[arrayList.size()];
            arrayList.toArray(cTFtnEdnArr);
        }
        return cTFtnEdnArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public List<CTFtnEdn> getEndnoteList() {
        1EndnoteList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EndnoteList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public CTFtnEdn insertNewEndnote(int i) {
        CTFtnEdn cTFtnEdnInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnInsert_element_user = get_store().insert_element_user(ENDNOTE$0, i);
        }
        return cTFtnEdnInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public void removeEndnote(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENDNOTE$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public void setEndnoteArray(int i, CTFtnEdn cTFtnEdn) {
        synchronized (monitor()) {
            check_orphaned();
            CTFtnEdn cTFtnEdnFind_element_user = get_store().find_element_user(ENDNOTE$0, i);
            if (cTFtnEdnFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFtnEdnFind_element_user.set(cTFtnEdn);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public void setEndnoteArray(CTFtnEdn[] cTFtnEdnArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFtnEdnArr, ENDNOTE$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes
    public int sizeOfEndnoteArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ENDNOTE$0);
        }
        return iCount_elements;
    }
}
