package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTColsImpl extends XmlComplexContentImpl implements CTCols {
    private static final QName COL$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "col");

    public CTColsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public CTCol addNewCol() {
        CTCol cTCol;
        synchronized (monitor()) {
            check_orphaned();
            cTCol = (CTCol) get_store().add_element_user(COL$0);
        }
        return cTCol;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public CTCol getColArray(int i) {
        CTCol cTCol;
        synchronized (monitor()) {
            check_orphaned();
            cTCol = (CTCol) get_store().find_element_user(COL$0, i);
            if (cTCol == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCol;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public CTCol[] getColArray() {
        CTCol[] cTColArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COL$0, arrayList);
            cTColArr = new CTCol[arrayList.size()];
            arrayList.toArray(cTColArr);
        }
        return cTColArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public List<CTCol> getColList() {
        AbstractList<CTCol> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTCol>() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTColsImpl.1ColList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTCol cTCol) {
                    CTColsImpl.this.insertNewCol(i).set(cTCol);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCol get(int i) {
                    return CTColsImpl.this.getColArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCol remove(int i) {
                    CTCol colArray = CTColsImpl.this.getColArray(i);
                    CTColsImpl.this.removeCol(i);
                    return colArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTCol set(int i, CTCol cTCol) {
                    CTCol colArray = CTColsImpl.this.getColArray(i);
                    CTColsImpl.this.setColArray(i, cTCol);
                    return colArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTColsImpl.this.sizeOfColArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public CTCol insertNewCol(int i) {
        CTCol cTCol;
        synchronized (monitor()) {
            check_orphaned();
            cTCol = (CTCol) get_store().insert_element_user(COL$0, i);
        }
        return cTCol;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public void removeCol(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COL$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public void setColArray(int i, CTCol cTCol) {
        synchronized (monitor()) {
            check_orphaned();
            CTCol cTCol2 = (CTCol) get_store().find_element_user(COL$0, i);
            if (cTCol2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCol2.set(cTCol);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public void setColArray(CTCol[] cTColArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTColArr, COL$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public int sizeOfColArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COL$0);
        }
        return iCount_elements;
    }
}
