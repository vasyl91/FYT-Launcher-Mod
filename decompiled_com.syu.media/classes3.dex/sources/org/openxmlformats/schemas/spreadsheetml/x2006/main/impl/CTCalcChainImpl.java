package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCalcChainImpl extends XmlComplexContentImpl implements CTCalcChain {
    private static final QName C$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "c");
    private static final QName EXTLST$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");

    public CTCalcChainImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTCalcCell addNewC() {
        CTCalcCell cTCalcCell;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcCell = (CTCalcCell) get_store().add_element_user(C$0);
        }
        return cTCalcCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$2);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTCalcCell getCArray(int i) {
        CTCalcCell cTCalcCell;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcCell = (CTCalcCell) get_store().find_element_user(C$0, i);
            if (cTCalcCell == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCalcCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTCalcCell[] getCArray() {
        CTCalcCell[] cTCalcCellArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(C$0, arrayList);
            cTCalcCellArr = new CTCalcCell[arrayList.size()];
            arrayList.toArray(cTCalcCellArr);
        }
        return cTCalcCellArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public List<CTCalcCell> getCList() {
        AbstractList<CTCalcCell> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTCalcCell>() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCalcChainImpl.1CList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTCalcCell cTCalcCell) {
                    CTCalcChainImpl.this.insertNewC(i).set(cTCalcCell);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCalcCell get(int i) {
                    return CTCalcChainImpl.this.getCArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCalcCell remove(int i) {
                    CTCalcCell cArray = CTCalcChainImpl.this.getCArray(i);
                    CTCalcChainImpl.this.removeC(i);
                    return cArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCalcCell set(int i, CTCalcCell cTCalcCell) {
                    CTCalcCell cArray = CTCalcChainImpl.this.getCArray(i);
                    CTCalcChainImpl.this.setCArray(i, cTCalcCell);
                    return cArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTCalcChainImpl.this.sizeOfCArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$2, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTCalcCell insertNewC(int i) {
        CTCalcCell cTCalcCell;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcCell = (CTCalcCell) get_store().insert_element_user(C$0, i);
        }
        return cTCalcCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void removeC(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(C$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void setCArray(int i, CTCalcCell cTCalcCell) {
        synchronized (monitor()) {
            check_orphaned();
            CTCalcCell cTCalcCell2 = (CTCalcCell) get_store().find_element_user(C$0, i);
            if (cTCalcCell2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCalcCell2.set(cTCalcCell);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void setCArray(CTCalcCell[] cTCalcCellArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCalcCellArr, C$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$2;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public int sizeOfCArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(C$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$2, 0);
        }
    }
}
