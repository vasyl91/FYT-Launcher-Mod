package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTDefinedNamesImpl extends XmlComplexContentImpl implements CTDefinedNames {
    private static final QName DEFINEDNAME$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "definedName");

    public CTDefinedNamesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public CTDefinedName addNewDefinedName() {
        CTDefinedName cTDefinedName;
        synchronized (monitor()) {
            check_orphaned();
            cTDefinedName = (CTDefinedName) get_store().add_element_user(DEFINEDNAME$0);
        }
        return cTDefinedName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public CTDefinedName getDefinedNameArray(int i) {
        CTDefinedName cTDefinedName;
        synchronized (monitor()) {
            check_orphaned();
            cTDefinedName = (CTDefinedName) get_store().find_element_user(DEFINEDNAME$0, i);
            if (cTDefinedName == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDefinedName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public CTDefinedName[] getDefinedNameArray() {
        CTDefinedName[] cTDefinedNameArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEFINEDNAME$0, arrayList);
            cTDefinedNameArr = new CTDefinedName[arrayList.size()];
            arrayList.toArray(cTDefinedNameArr);
        }
        return cTDefinedNameArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public List<CTDefinedName> getDefinedNameList() {
        AbstractList<CTDefinedName> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTDefinedName>() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTDefinedNamesImpl.1DefinedNameList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTDefinedName cTDefinedName) {
                    CTDefinedNamesImpl.this.insertNewDefinedName(i).set(cTDefinedName);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTDefinedName get(int i) {
                    return CTDefinedNamesImpl.this.getDefinedNameArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTDefinedName remove(int i) {
                    CTDefinedName definedNameArray = CTDefinedNamesImpl.this.getDefinedNameArray(i);
                    CTDefinedNamesImpl.this.removeDefinedName(i);
                    return definedNameArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTDefinedName set(int i, CTDefinedName cTDefinedName) {
                    CTDefinedName definedNameArray = CTDefinedNamesImpl.this.getDefinedNameArray(i);
                    CTDefinedNamesImpl.this.setDefinedNameArray(i, cTDefinedName);
                    return definedNameArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTDefinedNamesImpl.this.sizeOfDefinedNameArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public CTDefinedName insertNewDefinedName(int i) {
        CTDefinedName cTDefinedName;
        synchronized (monitor()) {
            check_orphaned();
            cTDefinedName = (CTDefinedName) get_store().insert_element_user(DEFINEDNAME$0, i);
        }
        return cTDefinedName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public void removeDefinedName(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEFINEDNAME$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public void setDefinedNameArray(int i, CTDefinedName cTDefinedName) {
        synchronized (monitor()) {
            check_orphaned();
            CTDefinedName cTDefinedName2 = (CTDefinedName) get_store().find_element_user(DEFINEDNAME$0, i);
            if (cTDefinedName2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDefinedName2.set(cTDefinedName);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public void setDefinedNameArray(CTDefinedName[] cTDefinedNameArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTDefinedNameArr, DEFINEDNAME$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public int sizeOfDefinedNameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DEFINEDNAME$0);
        }
        return iCount_elements;
    }
}
