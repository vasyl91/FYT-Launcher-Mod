package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFilterColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTAutoFilterImpl extends XmlComplexContentImpl implements CTAutoFilter {
    private static final QName FILTERCOLUMN$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "filterColumn");
    private static final QName SORTSTATE$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sortState");
    private static final QName EXTLST$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
    private static final QName REF$6 = new QName("", "ref");

    public CTAutoFilterImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$4);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTFilterColumn addNewFilterColumn() {
        CTFilterColumn cTFilterColumnAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFilterColumnAdd_element_user = get_store().add_element_user(FILTERCOLUMN$0);
        }
        return cTFilterColumnAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTSortState addNewSortState() {
        CTSortState cTSortStateAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSortStateAdd_element_user = get_store().add_element_user(SORTSTATE$2);
        }
        return cTSortStateAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTFilterColumn getFilterColumnArray(int i) {
        CTFilterColumn cTFilterColumnFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFilterColumnFind_element_user = get_store().find_element_user(FILTERCOLUMN$0, i);
            if (cTFilterColumnFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFilterColumnFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTFilterColumn[] getFilterColumnArray() {
        CTFilterColumn[] cTFilterColumnArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FILTERCOLUMN$0, arrayList);
            cTFilterColumnArr = new CTFilterColumn[arrayList.size()];
            arrayList.toArray(cTFilterColumnArr);
        }
        return cTFilterColumnArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public List<CTFilterColumn> getFilterColumnList() {
        1FilterColumnList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FilterColumnList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public String getRef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REF$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTSortState getSortState() {
        synchronized (monitor()) {
            check_orphaned();
            CTSortState cTSortStateFind_element_user = get_store().find_element_user(SORTSTATE$2, 0);
            if (cTSortStateFind_element_user == null) {
                return null;
            }
            return cTSortStateFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTFilterColumn insertNewFilterColumn(int i) {
        CTFilterColumn cTFilterColumnInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFilterColumnInsert_element_user = get_store().insert_element_user(FILTERCOLUMN$0, i);
        }
        return cTFilterColumnInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public boolean isSetRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REF$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public boolean isSetSortState() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SORTSTATE$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void removeFilterColumn(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILTERCOLUMN$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void setFilterColumnArray(int i, CTFilterColumn cTFilterColumn) {
        synchronized (monitor()) {
            check_orphaned();
            CTFilterColumn cTFilterColumnFind_element_user = get_store().find_element_user(FILTERCOLUMN$0, i);
            if (cTFilterColumnFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFilterColumnFind_element_user.set(cTFilterColumn);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void setFilterColumnArray(CTFilterColumn[] cTFilterColumnArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTFilterColumnArr, FILTERCOLUMN$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void setRef(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void setSortState(CTSortState cTSortState) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SORTSTATE$2;
            CTSortState cTSortStateFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSortStateFind_element_user == null) {
                cTSortStateFind_element_user = (CTSortState) get_store().add_element_user(qName);
            }
            cTSortStateFind_element_user.set(cTSortState);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public int sizeOfFilterColumnArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FILTERCOLUMN$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void unsetRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REF$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void unsetSortState() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SORTSTATE$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public STRef xgetRef() {
        STRef sTRef;
        synchronized (monitor()) {
            check_orphaned();
            sTRef = (STRef) get_store().find_attribute_user(REF$6);
        }
        return sTRef;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void xsetRef(STRef sTRef) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$6;
            STRef sTRef2 = (STRef) typeStore.find_attribute_user(qName);
            if (sTRef2 == null) {
                sTRef2 = (STRef) get_store().add_attribute_user(qName);
            }
            sTRef2.set(sTRef);
        }
    }
}
