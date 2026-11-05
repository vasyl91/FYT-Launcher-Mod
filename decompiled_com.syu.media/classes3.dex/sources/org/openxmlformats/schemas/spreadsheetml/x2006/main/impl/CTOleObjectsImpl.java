package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTOleObjectsImpl extends XmlComplexContentImpl implements CTOleObjects {
    private static final QName OLEOBJECT$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "oleObject");

    public CTOleObjectsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public CTOleObject addNewOleObject() {
        CTOleObject cTOleObject;
        synchronized (monitor()) {
            check_orphaned();
            cTOleObject = (CTOleObject) get_store().add_element_user(OLEOBJECT$0);
        }
        return cTOleObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public CTOleObject getOleObjectArray(int i) {
        CTOleObject cTOleObject;
        synchronized (monitor()) {
            check_orphaned();
            cTOleObject = (CTOleObject) get_store().find_element_user(OLEOBJECT$0, i);
            if (cTOleObject == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOleObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public CTOleObject[] getOleObjectArray() {
        CTOleObject[] cTOleObjectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OLEOBJECT$0, arrayList);
            cTOleObjectArr = new CTOleObject[arrayList.size()];
            arrayList.toArray(cTOleObjectArr);
        }
        return cTOleObjectArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public List<CTOleObject> getOleObjectList() {
        1OleObjectList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OleObjectList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public CTOleObject insertNewOleObject(int i) {
        CTOleObject cTOleObject;
        synchronized (monitor()) {
            check_orphaned();
            cTOleObject = (CTOleObject) get_store().insert_element_user(OLEOBJECT$0, i);
        }
        return cTOleObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public void removeOleObject(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OLEOBJECT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public void setOleObjectArray(int i, CTOleObject cTOleObject) {
        synchronized (monitor()) {
            check_orphaned();
            CTOleObject cTOleObject2 = (CTOleObject) get_store().find_element_user(OLEOBJECT$0, i);
            if (cTOleObject2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOleObject2.set(cTOleObject);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public void setOleObjectArray(CTOleObject[] cTOleObjectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOleObjectArr, OLEOBJECT$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects
    public int sizeOfOleObjectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OLEOBJECT$0);
        }
        return iCount_elements;
    }
}
