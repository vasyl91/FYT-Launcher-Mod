package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPicBullet;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTNumberingImpl extends XmlComplexContentImpl implements CTNumbering {
    private static final QName NUMPICBULLET$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numPicBullet");
    private static final QName ABSTRACTNUM$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "abstractNum");
    private static final QName NUM$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "num");
    private static final QName NUMIDMACATCLEANUP$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numIdMacAtCleanup");

    public CTNumberingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum addNewAbstractNum() {
        CTAbstractNum cTAbstractNumAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAbstractNumAdd_element_user = get_store().add_element_user(ABSTRACTNUM$2);
        }
        return cTAbstractNumAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum addNewNum() {
        CTNum cTNumAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumAdd_element_user = get_store().add_element_user(NUM$4);
        }
        return cTNumAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTDecimalNumber addNewNumIdMacAtCleanup() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(NUMIDMACATCLEANUP$6);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet addNewNumPicBullet() {
        CTNumPicBullet cTNumPicBulletAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumPicBulletAdd_element_user = get_store().add_element_user(NUMPICBULLET$0);
        }
        return cTNumPicBulletAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum getAbstractNumArray(int i) {
        CTAbstractNum cTAbstractNumFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAbstractNumFind_element_user = get_store().find_element_user(ABSTRACTNUM$2, i);
            if (cTAbstractNumFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAbstractNumFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum[] getAbstractNumArray() {
        CTAbstractNum[] cTAbstractNumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ABSTRACTNUM$2, arrayList);
            cTAbstractNumArr = new CTAbstractNum[arrayList.size()];
            arrayList.toArray(cTAbstractNumArr);
        }
        return cTAbstractNumArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public List<CTAbstractNum> getAbstractNumList() {
        1AbstractNumList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AbstractNumList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum getNumArray(int i) {
        CTNum cTNumFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFind_element_user = get_store().find_element_user(NUM$4, i);
            if (cTNumFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNumFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum[] getNumArray() {
        CTNum[] cTNumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NUM$4, arrayList);
            cTNumArr = new CTNum[arrayList.size()];
            arrayList.toArray(cTNumArr);
        }
        return cTNumArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTDecimalNumber getNumIdMacAtCleanup() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(NUMIDMACATCLEANUP$6, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public List<CTNum> getNumList() {
        1NumList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NumList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet getNumPicBulletArray(int i) {
        CTNumPicBullet cTNumPicBulletFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumPicBulletFind_element_user = get_store().find_element_user(NUMPICBULLET$0, i);
            if (cTNumPicBulletFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNumPicBulletFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet[] getNumPicBulletArray() {
        CTNumPicBullet[] cTNumPicBulletArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NUMPICBULLET$0, arrayList);
            cTNumPicBulletArr = new CTNumPicBullet[arrayList.size()];
            arrayList.toArray(cTNumPicBulletArr);
        }
        return cTNumPicBulletArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public List<CTNumPicBullet> getNumPicBulletList() {
        1NumPicBulletList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NumPicBulletList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum insertNewAbstractNum(int i) {
        CTAbstractNum cTAbstractNumInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAbstractNumInsert_element_user = get_store().insert_element_user(ABSTRACTNUM$2, i);
        }
        return cTAbstractNumInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum insertNewNum(int i) {
        CTNum cTNumInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumInsert_element_user = get_store().insert_element_user(NUM$4, i);
        }
        return cTNumInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet insertNewNumPicBullet(int i) {
        CTNumPicBullet cTNumPicBulletInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumPicBulletInsert_element_user = get_store().insert_element_user(NUMPICBULLET$0, i);
        }
        return cTNumPicBulletInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public boolean isSetNumIdMacAtCleanup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMIDMACATCLEANUP$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void removeAbstractNum(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ABSTRACTNUM$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void removeNum(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUM$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void removeNumPicBullet(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMPICBULLET$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setAbstractNumArray(int i, CTAbstractNum cTAbstractNum) {
        synchronized (monitor()) {
            check_orphaned();
            CTAbstractNum cTAbstractNumFind_element_user = get_store().find_element_user(ABSTRACTNUM$2, i);
            if (cTAbstractNumFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTAbstractNumFind_element_user.set(cTAbstractNum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setAbstractNumArray(CTAbstractNum[] cTAbstractNumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTAbstractNumArr, ABSTRACTNUM$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumArray(int i, CTNum cTNum) {
        synchronized (monitor()) {
            check_orphaned();
            CTNum cTNumFind_element_user = get_store().find_element_user(NUM$4, i);
            if (cTNumFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTNumFind_element_user.set(cTNum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumArray(CTNum[] cTNumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTNumArr, NUM$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumIdMacAtCleanup(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMIDMACATCLEANUP$6;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumPicBulletArray(int i, CTNumPicBullet cTNumPicBullet) {
        synchronized (monitor()) {
            check_orphaned();
            CTNumPicBullet cTNumPicBulletFind_element_user = get_store().find_element_user(NUMPICBULLET$0, i);
            if (cTNumPicBulletFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTNumPicBulletFind_element_user.set(cTNumPicBullet);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumPicBulletArray(CTNumPicBullet[] cTNumPicBulletArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTNumPicBulletArr, NUMPICBULLET$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public int sizeOfAbstractNumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ABSTRACTNUM$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public int sizeOfNumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(NUM$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public int sizeOfNumPicBulletArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(NUMPICBULLET$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void unsetNumIdMacAtCleanup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMIDMACATCLEANUP$6, 0);
        }
    }
}
