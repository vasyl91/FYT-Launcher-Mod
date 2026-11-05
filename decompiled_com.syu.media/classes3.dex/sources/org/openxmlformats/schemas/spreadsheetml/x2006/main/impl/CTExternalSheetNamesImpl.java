package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTExternalSheetNamesImpl extends XmlComplexContentImpl implements CTExternalSheetNames {
    private static final QName SHEETNAME$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetName");

    public CTExternalSheetNamesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public CTExternalSheetName addNewSheetName() {
        CTExternalSheetName cTExternalSheetName;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetName = (CTExternalSheetName) get_store().add_element_user(SHEETNAME$0);
        }
        return cTExternalSheetName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public CTExternalSheetName getSheetNameArray(int i) {
        CTExternalSheetName cTExternalSheetName;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetName = (CTExternalSheetName) get_store().find_element_user(SHEETNAME$0, i);
            if (cTExternalSheetName == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTExternalSheetName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public CTExternalSheetName[] getSheetNameArray() {
        CTExternalSheetName[] cTExternalSheetNameArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHEETNAME$0, arrayList);
            cTExternalSheetNameArr = new CTExternalSheetName[arrayList.size()];
            arrayList.toArray(cTExternalSheetNameArr);
        }
        return cTExternalSheetNameArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public List<CTExternalSheetName> getSheetNameList() {
        1SheetNameList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SheetNameList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public CTExternalSheetName insertNewSheetName(int i) {
        CTExternalSheetName cTExternalSheetName;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetName = (CTExternalSheetName) get_store().insert_element_user(SHEETNAME$0, i);
        }
        return cTExternalSheetName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public void removeSheetName(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETNAME$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public void setSheetNameArray(int i, CTExternalSheetName cTExternalSheetName) {
        synchronized (monitor()) {
            check_orphaned();
            CTExternalSheetName cTExternalSheetName2 = (CTExternalSheetName) get_store().find_element_user(SHEETNAME$0, i);
            if (cTExternalSheetName2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTExternalSheetName2.set(cTExternalSheetName);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public void setSheetNameArray(CTExternalSheetName[] cTExternalSheetNameArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTExternalSheetNameArr, SHEETNAME$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public int sizeOfSheetNameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHEETNAME$0);
        }
        return iCount_elements;
    }
}
