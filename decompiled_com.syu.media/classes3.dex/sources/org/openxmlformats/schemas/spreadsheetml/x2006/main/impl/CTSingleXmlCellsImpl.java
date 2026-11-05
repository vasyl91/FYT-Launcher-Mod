package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSingleXmlCellsImpl extends XmlComplexContentImpl implements CTSingleXmlCells {
    private static final QName SINGLEXMLCELL$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "singleXmlCell");

    public CTSingleXmlCellsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public CTSingleXmlCell addNewSingleXmlCell() {
        CTSingleXmlCell cTSingleXmlCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSingleXmlCell = (CTSingleXmlCell) get_store().add_element_user(SINGLEXMLCELL$0);
        }
        return cTSingleXmlCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public CTSingleXmlCell getSingleXmlCellArray(int i) {
        CTSingleXmlCell cTSingleXmlCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSingleXmlCell = (CTSingleXmlCell) get_store().find_element_user(SINGLEXMLCELL$0, i);
            if (cTSingleXmlCell == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSingleXmlCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public CTSingleXmlCell[] getSingleXmlCellArray() {
        CTSingleXmlCell[] cTSingleXmlCellArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SINGLEXMLCELL$0, arrayList);
            cTSingleXmlCellArr = new CTSingleXmlCell[arrayList.size()];
            arrayList.toArray(cTSingleXmlCellArr);
        }
        return cTSingleXmlCellArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public List<CTSingleXmlCell> getSingleXmlCellList() {
        1SingleXmlCellList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SingleXmlCellList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public CTSingleXmlCell insertNewSingleXmlCell(int i) {
        CTSingleXmlCell cTSingleXmlCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSingleXmlCell = (CTSingleXmlCell) get_store().insert_element_user(SINGLEXMLCELL$0, i);
        }
        return cTSingleXmlCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public void removeSingleXmlCell(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SINGLEXMLCELL$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public void setSingleXmlCellArray(int i, CTSingleXmlCell cTSingleXmlCell) {
        synchronized (monitor()) {
            check_orphaned();
            CTSingleXmlCell cTSingleXmlCell2 = (CTSingleXmlCell) get_store().find_element_user(SINGLEXMLCELL$0, i);
            if (cTSingleXmlCell2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSingleXmlCell2.set(cTSingleXmlCell);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public void setSingleXmlCellArray(CTSingleXmlCell[] cTSingleXmlCellArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSingleXmlCellArr, SINGLEXMLCELL$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public int sizeOfSingleXmlCellArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SINGLEXMLCELL$0);
        }
        return iCount_elements;
    }
}
