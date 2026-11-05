package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSheetDataImpl extends XmlComplexContentImpl implements CTSheetData {
    private static final QName ROW$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "row");

    public CTSheetDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData
    public CTRow addNewRow() {
        CTRow cTRow;
        synchronized (monitor()) {
            check_orphaned();
            cTRow = (CTRow) get_store().add_element_user(ROW$0);
        }
        return cTRow;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData
    public CTRow getRowArray(int i) {
        CTRow cTRow;
        synchronized (monitor()) {
            check_orphaned();
            cTRow = (CTRow) get_store().find_element_user(ROW$0, i);
            if (cTRow == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRow;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData
    public CTRow[] getRowArray() {
        CTRow[] cTRowArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ROW$0, arrayList);
            cTRowArr = new CTRow[arrayList.size()];
            arrayList.toArray(cTRowArr);
        }
        return cTRowArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData
    public List<CTRow> getRowList() {
        1RowList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RowList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData
    public CTRow insertNewRow(int i) {
        CTRow cTRow;
        synchronized (monitor()) {
            check_orphaned();
            cTRow = (CTRow) get_store().insert_element_user(ROW$0, i);
        }
        return cTRow;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData
    public void removeRow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ROW$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData
    public void setRowArray(int i, CTRow cTRow) {
        synchronized (monitor()) {
            check_orphaned();
            CTRow cTRow2 = (CTRow) get_store().find_element_user(ROW$0, i);
            if (cTRow2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRow2.set(cTRow);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData
    public void setRowArray(CTRow[] cTRowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRowArr, ROW$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData
    public int sizeOfRowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ROW$0);
        }
        return iCount_elements;
    }
}
