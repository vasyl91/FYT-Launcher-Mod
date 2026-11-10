package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPolarAdjustHandle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTXYAdjustHandle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTAdjustHandleListImpl extends XmlComplexContentImpl implements CTAdjustHandleList {
    private static final QName AHXY$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ahXY");
    private static final QName AHPOLAR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ahPolar");

    public CTAdjustHandleListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTPolarAdjustHandle addNewAhPolar() {
        CTPolarAdjustHandle cTPolarAdjustHandleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPolarAdjustHandleAdd_element_user = get_store().add_element_user(AHPOLAR$2);
        }
        return cTPolarAdjustHandleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTXYAdjustHandle addNewAhXY() {
        CTXYAdjustHandle cTXYAdjustHandleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTXYAdjustHandleAdd_element_user = get_store().add_element_user(AHXY$0);
        }
        return cTXYAdjustHandleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTPolarAdjustHandle getAhPolarArray(int i) {
        CTPolarAdjustHandle cTPolarAdjustHandleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPolarAdjustHandleFind_element_user = get_store().find_element_user(AHPOLAR$2, i);
            if (cTPolarAdjustHandleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPolarAdjustHandleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTPolarAdjustHandle[] getAhPolarArray() {
        CTPolarAdjustHandle[] cTPolarAdjustHandleArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AHPOLAR$2, arrayList);
            cTPolarAdjustHandleArr = new CTPolarAdjustHandle[arrayList.size()];
            arrayList.toArray(cTPolarAdjustHandleArr);
        }
        return cTPolarAdjustHandleArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public List<CTPolarAdjustHandle> getAhPolarList() {
        1AhPolarList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AhPolarList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTXYAdjustHandle getAhXYArray(int i) {
        CTXYAdjustHandle cTXYAdjustHandleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTXYAdjustHandleFind_element_user = get_store().find_element_user(AHXY$0, i);
            if (cTXYAdjustHandleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTXYAdjustHandleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTXYAdjustHandle[] getAhXYArray() {
        CTXYAdjustHandle[] cTXYAdjustHandleArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AHXY$0, arrayList);
            cTXYAdjustHandleArr = new CTXYAdjustHandle[arrayList.size()];
            arrayList.toArray(cTXYAdjustHandleArr);
        }
        return cTXYAdjustHandleArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public List<CTXYAdjustHandle> getAhXYList() {
        1AhXYList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AhXYList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTPolarAdjustHandle insertNewAhPolar(int i) {
        CTPolarAdjustHandle cTPolarAdjustHandleInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPolarAdjustHandleInsert_element_user = get_store().insert_element_user(AHPOLAR$2, i);
        }
        return cTPolarAdjustHandleInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public CTXYAdjustHandle insertNewAhXY(int i) {
        CTXYAdjustHandle cTXYAdjustHandleInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTXYAdjustHandleInsert_element_user = get_store().insert_element_user(AHXY$0, i);
        }
        return cTXYAdjustHandleInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void removeAhPolar(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AHPOLAR$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void removeAhXY(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AHXY$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void setAhPolarArray(int i, CTPolarAdjustHandle cTPolarAdjustHandle) {
        synchronized (monitor()) {
            check_orphaned();
            CTPolarAdjustHandle cTPolarAdjustHandleFind_element_user = get_store().find_element_user(AHPOLAR$2, i);
            if (cTPolarAdjustHandleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPolarAdjustHandleFind_element_user.set(cTPolarAdjustHandle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void setAhPolarArray(CTPolarAdjustHandle[] cTPolarAdjustHandleArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPolarAdjustHandleArr, AHPOLAR$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void setAhXYArray(int i, CTXYAdjustHandle cTXYAdjustHandle) {
        synchronized (monitor()) {
            check_orphaned();
            CTXYAdjustHandle cTXYAdjustHandleFind_element_user = get_store().find_element_user(AHXY$0, i);
            if (cTXYAdjustHandleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTXYAdjustHandleFind_element_user.set(cTXYAdjustHandle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public void setAhXYArray(CTXYAdjustHandle[] cTXYAdjustHandleArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTXYAdjustHandleArr, AHXY$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public int sizeOfAhPolarArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(AHPOLAR$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList
    public int sizeOfAhXYArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(AHXY$0);
        }
        return iCount_elements;
    }
}
