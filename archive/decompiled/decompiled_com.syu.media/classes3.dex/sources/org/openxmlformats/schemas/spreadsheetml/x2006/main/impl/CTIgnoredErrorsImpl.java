package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTIgnoredErrorsImpl extends XmlComplexContentImpl implements CTIgnoredErrors {
    private static final QName IGNOREDERROR$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "ignoredError");
    private static final QName EXTLST$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");

    public CTIgnoredErrorsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$2);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTIgnoredError addNewIgnoredError() {
        CTIgnoredError cTIgnoredError;
        synchronized (monitor()) {
            check_orphaned();
            cTIgnoredError = (CTIgnoredError) get_store().add_element_user(IGNOREDERROR$0);
        }
        return cTIgnoredError;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTIgnoredError getIgnoredErrorArray(int i) {
        CTIgnoredError cTIgnoredError;
        synchronized (monitor()) {
            check_orphaned();
            cTIgnoredError = (CTIgnoredError) get_store().find_element_user(IGNOREDERROR$0, i);
            if (cTIgnoredError == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTIgnoredError;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTIgnoredError[] getIgnoredErrorArray() {
        CTIgnoredError[] cTIgnoredErrorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(IGNOREDERROR$0, arrayList);
            cTIgnoredErrorArr = new CTIgnoredError[arrayList.size()];
            arrayList.toArray(cTIgnoredErrorArr);
        }
        return cTIgnoredErrorArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public List<CTIgnoredError> getIgnoredErrorList() {
        AbstractList<CTIgnoredError> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTIgnoredError>() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTIgnoredErrorsImpl.1IgnoredErrorList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTIgnoredError cTIgnoredError) {
                    CTIgnoredErrorsImpl.this.insertNewIgnoredError(i).set(cTIgnoredError);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTIgnoredError get(int i) {
                    return CTIgnoredErrorsImpl.this.getIgnoredErrorArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTIgnoredError remove(int i) {
                    CTIgnoredError ignoredErrorArray = CTIgnoredErrorsImpl.this.getIgnoredErrorArray(i);
                    CTIgnoredErrorsImpl.this.removeIgnoredError(i);
                    return ignoredErrorArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTIgnoredError set(int i, CTIgnoredError cTIgnoredError) {
                    CTIgnoredError ignoredErrorArray = CTIgnoredErrorsImpl.this.getIgnoredErrorArray(i);
                    CTIgnoredErrorsImpl.this.setIgnoredErrorArray(i, cTIgnoredError);
                    return ignoredErrorArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTIgnoredErrorsImpl.this.sizeOfIgnoredErrorArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTIgnoredError insertNewIgnoredError(int i) {
        CTIgnoredError cTIgnoredError;
        synchronized (monitor()) {
            check_orphaned();
            cTIgnoredError = (CTIgnoredError) get_store().insert_element_user(IGNOREDERROR$0, i);
        }
        return cTIgnoredError;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void removeIgnoredError(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IGNOREDERROR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void setIgnoredErrorArray(int i, CTIgnoredError cTIgnoredError) {
        synchronized (monitor()) {
            check_orphaned();
            CTIgnoredError cTIgnoredError2 = (CTIgnoredError) get_store().find_element_user(IGNOREDERROR$0, i);
            if (cTIgnoredError2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTIgnoredError2.set(cTIgnoredError);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void setIgnoredErrorArray(CTIgnoredError[] cTIgnoredErrorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTIgnoredErrorArr, IGNOREDERROR$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public int sizeOfIgnoredErrorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(IGNOREDERROR$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$2, 0);
        }
    }
}
