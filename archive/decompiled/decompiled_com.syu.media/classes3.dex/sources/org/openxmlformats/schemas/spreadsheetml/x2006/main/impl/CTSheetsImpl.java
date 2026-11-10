package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSheetsImpl extends XmlComplexContentImpl implements CTSheets {
    private static final QName SHEET$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheet");

    public CTSheetsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public CTSheet addNewSheet() {
        CTSheet cTSheet;
        synchronized (monitor()) {
            check_orphaned();
            cTSheet = (CTSheet) get_store().add_element_user(SHEET$0);
        }
        return cTSheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public CTSheet getSheetArray(int i) {
        CTSheet cTSheet;
        synchronized (monitor()) {
            check_orphaned();
            cTSheet = (CTSheet) get_store().find_element_user(SHEET$0, i);
            if (cTSheet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public CTSheet[] getSheetArray() {
        CTSheet[] cTSheetArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHEET$0, arrayList);
            cTSheetArr = new CTSheet[arrayList.size()];
            arrayList.toArray(cTSheetArr);
        }
        return cTSheetArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public List<CTSheet> getSheetList() {
        1SheetList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SheetList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public CTSheet insertNewSheet(int i) {
        CTSheet cTSheet;
        synchronized (monitor()) {
            check_orphaned();
            cTSheet = (CTSheet) get_store().insert_element_user(SHEET$0, i);
        }
        return cTSheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public void removeSheet(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEET$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public void setSheetArray(int i, CTSheet cTSheet) {
        synchronized (monitor()) {
            check_orphaned();
            CTSheet cTSheet2 = (CTSheet) get_store().find_element_user(SHEET$0, i);
            if (cTSheet2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSheet2.set(cTSheet);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public void setSheetArray(CTSheet[] cTSheetArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSheetArr, SHEET$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets
    public int sizeOfSheetArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHEET$0);
        }
        return iCount_elements;
    }
}
