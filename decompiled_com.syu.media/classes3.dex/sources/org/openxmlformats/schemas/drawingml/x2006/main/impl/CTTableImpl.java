package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTableImpl extends XmlComplexContentImpl implements CTTable {
    private static final QName TBLPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tblPr");
    private static final QName TBLGRID$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tblGrid");
    private static final QName TR$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tr");

    public CTTableImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableGrid addNewTblGrid() {
        CTTableGrid cTTableGrid;
        synchronized (monitor()) {
            check_orphaned();
            cTTableGrid = (CTTableGrid) get_store().add_element_user(TBLGRID$2);
        }
        return cTTableGrid;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableProperties addNewTblPr() {
        CTTableProperties cTTableProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTableProperties = (CTTableProperties) get_store().add_element_user(TBLPR$0);
        }
        return cTTableProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableRow addNewTr() {
        CTTableRow cTTableRow;
        synchronized (monitor()) {
            check_orphaned();
            cTTableRow = (CTTableRow) get_store().add_element_user(TR$4);
        }
        return cTTableRow;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableGrid getTblGrid() {
        synchronized (monitor()) {
            check_orphaned();
            CTTableGrid cTTableGrid = (CTTableGrid) get_store().find_element_user(TBLGRID$2, 0);
            if (cTTableGrid == null) {
                return null;
            }
            return cTTableGrid;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableProperties getTblPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTableProperties cTTableProperties = (CTTableProperties) get_store().find_element_user(TBLPR$0, 0);
            if (cTTableProperties == null) {
                return null;
            }
            return cTTableProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableRow getTrArray(int i) {
        CTTableRow cTTableRow;
        synchronized (monitor()) {
            check_orphaned();
            cTTableRow = (CTTableRow) get_store().find_element_user(TR$4, i);
            if (cTTableRow == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTableRow;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableRow[] getTrArray() {
        CTTableRow[] cTTableRowArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TR$4, arrayList);
            cTTableRowArr = new CTTableRow[arrayList.size()];
            arrayList.toArray(cTTableRowArr);
        }
        return cTTableRowArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public List<CTTableRow> getTrList() {
        1TrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableRow insertNewTr(int i) {
        CTTableRow cTTableRow;
        synchronized (monitor()) {
            check_orphaned();
            cTTableRow = (CTTableRow) get_store().insert_element_user(TR$4, i);
        }
        return cTTableRow;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public boolean isSetTblPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public void removeTr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TR$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public void setTblGrid(CTTableGrid cTTableGrid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLGRID$2;
            CTTableGrid cTTableGrid2 = (CTTableGrid) typeStore.find_element_user(qName, 0);
            if (cTTableGrid2 == null) {
                cTTableGrid2 = (CTTableGrid) get_store().add_element_user(qName);
            }
            cTTableGrid2.set(cTTableGrid);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public void setTblPr(CTTableProperties cTTableProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLPR$0;
            CTTableProperties cTTableProperties2 = (CTTableProperties) typeStore.find_element_user(qName, 0);
            if (cTTableProperties2 == null) {
                cTTableProperties2 = (CTTableProperties) get_store().add_element_user(qName);
            }
            cTTableProperties2.set(cTTableProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public void setTrArray(int i, CTTableRow cTTableRow) {
        synchronized (monitor()) {
            check_orphaned();
            CTTableRow cTTableRow2 = (CTTableRow) get_store().find_element_user(TR$4, i);
            if (cTTableRow2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTableRow2.set(cTTableRow);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public void setTrArray(CTTableRow[] cTTableRowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTableRowArr, TR$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public int sizeOfTrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TR$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public void unsetTblPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLPR$0, 0);
        }
    }
}
