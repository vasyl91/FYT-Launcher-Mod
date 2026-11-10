package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.MasterShortcutType;
import com.microsoft.schemas.office.visio.x2012.main.MasterType;
import com.microsoft.schemas.office.visio.x2012.main.MastersType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class MastersTypeImpl extends XmlComplexContentImpl implements MastersType {
    private static final QName MASTER$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Master");
    private static final QName MASTERSHORTCUT$2 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "MasterShortcut");

    public MastersTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterType addNewMaster() {
        MasterType masterTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            masterTypeAdd_element_user = get_store().add_element_user(MASTER$0);
        }
        return masterTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterShortcutType addNewMasterShortcut() {
        MasterShortcutType masterShortcutTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            masterShortcutTypeAdd_element_user = get_store().add_element_user(MASTERSHORTCUT$2);
        }
        return masterShortcutTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterType getMasterArray(int i) {
        MasterType masterTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            masterTypeFind_element_user = get_store().find_element_user(MASTER$0, i);
            if (masterTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return masterTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterType[] getMasterArray() {
        MasterType[] masterTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MASTER$0, arrayList);
            masterTypeArr = new MasterType[arrayList.size()];
            arrayList.toArray(masterTypeArr);
        }
        return masterTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public List<MasterType> getMasterList() {
        1MasterList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MasterList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterShortcutType getMasterShortcutArray(int i) {
        MasterShortcutType masterShortcutTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            masterShortcutTypeFind_element_user = get_store().find_element_user(MASTERSHORTCUT$2, i);
            if (masterShortcutTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return masterShortcutTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterShortcutType[] getMasterShortcutArray() {
        MasterShortcutType[] masterShortcutTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MASTERSHORTCUT$2, arrayList);
            masterShortcutTypeArr = new MasterShortcutType[arrayList.size()];
            arrayList.toArray(masterShortcutTypeArr);
        }
        return masterShortcutTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public List<MasterShortcutType> getMasterShortcutList() {
        1MasterShortcutList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MasterShortcutList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterType insertNewMaster(int i) {
        MasterType masterTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            masterTypeInsert_element_user = get_store().insert_element_user(MASTER$0, i);
        }
        return masterTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public MasterShortcutType insertNewMasterShortcut(int i) {
        MasterShortcutType masterShortcutTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            masterShortcutTypeInsert_element_user = get_store().insert_element_user(MASTERSHORTCUT$2, i);
        }
        return masterShortcutTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public void removeMaster(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MASTER$0, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public void removeMasterShortcut(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MASTERSHORTCUT$2, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public void setMasterArray(int i, MasterType masterType) {
        synchronized (monitor()) {
            check_orphaned();
            MasterType masterTypeFind_element_user = get_store().find_element_user(MASTER$0, i);
            if (masterTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            masterTypeFind_element_user.set(masterType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public void setMasterArray(MasterType[] masterTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(masterTypeArr, MASTER$0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public void setMasterShortcutArray(int i, MasterShortcutType masterShortcutType) {
        synchronized (monitor()) {
            check_orphaned();
            MasterShortcutType masterShortcutTypeFind_element_user = get_store().find_element_user(MASTERSHORTCUT$2, i);
            if (masterShortcutTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            masterShortcutTypeFind_element_user.set(masterShortcutType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public void setMasterShortcutArray(MasterShortcutType[] masterShortcutTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(masterShortcutTypeArr, MASTERSHORTCUT$2);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public int sizeOfMasterArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MASTER$0);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersType
    public int sizeOfMasterShortcutArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MASTERSHORTCUT$2);
        }
        return iCount_elements;
    }
}
