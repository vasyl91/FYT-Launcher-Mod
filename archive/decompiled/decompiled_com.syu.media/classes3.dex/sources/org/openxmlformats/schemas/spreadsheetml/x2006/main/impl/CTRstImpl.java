package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticRun;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTRstImpl extends XmlComplexContentImpl implements CTRst {
    private static final QName T$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "t");
    private static final QName R$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "r");
    private static final QName RPH$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rPh");
    private static final QName PHONETICPR$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "phoneticPr");

    public CTRstImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTPhoneticPr addNewPhoneticPr() {
        CTPhoneticPr cTPhoneticPr;
        synchronized (monitor()) {
            check_orphaned();
            cTPhoneticPr = (CTPhoneticPr) get_store().add_element_user(PHONETICPR$6);
        }
        return cTPhoneticPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTRElt addNewR() {
        CTRElt cTRElt;
        synchronized (monitor()) {
            check_orphaned();
            cTRElt = (CTRElt) get_store().add_element_user(R$2);
        }
        return cTRElt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTPhoneticRun addNewRPh() {
        CTPhoneticRun cTPhoneticRunAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhoneticRunAdd_element_user = get_store().add_element_user(RPH$4);
        }
        return cTPhoneticRunAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTPhoneticPr getPhoneticPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTPhoneticPr cTPhoneticPr = (CTPhoneticPr) get_store().find_element_user(PHONETICPR$6, 0);
            if (cTPhoneticPr == null) {
                return null;
            }
            return cTPhoneticPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTRElt getRArray(int i) {
        CTRElt cTRElt;
        synchronized (monitor()) {
            check_orphaned();
            cTRElt = (CTRElt) get_store().find_element_user(R$2, i);
            if (cTRElt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRElt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTRElt[] getRArray() {
        CTRElt[] cTREltArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R$2, arrayList);
            cTREltArr = new CTRElt[arrayList.size()];
            arrayList.toArray(cTREltArr);
        }
        return cTREltArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public List<CTRElt> getRList() {
        1RList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTPhoneticRun getRPhArray(int i) {
        CTPhoneticRun cTPhoneticRunFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhoneticRunFind_element_user = get_store().find_element_user(RPH$4, i);
            if (cTPhoneticRunFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPhoneticRunFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTPhoneticRun[] getRPhArray() {
        CTPhoneticRun[] cTPhoneticRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RPH$4, arrayList);
            cTPhoneticRunArr = new CTPhoneticRun[arrayList.size()];
            arrayList.toArray(cTPhoneticRunArr);
        }
        return cTPhoneticRunArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public List<CTPhoneticRun> getRPhList() {
        1RPhList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RPhList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public String getT() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(T$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTRElt insertNewR(int i) {
        CTRElt cTRElt;
        synchronized (monitor()) {
            check_orphaned();
            cTRElt = (CTRElt) get_store().insert_element_user(R$2, i);
        }
        return cTRElt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTPhoneticRun insertNewRPh(int i) {
        CTPhoneticRun cTPhoneticRunInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhoneticRunInsert_element_user = get_store().insert_element_user(RPH$4, i);
        }
        return cTPhoneticRunInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public boolean isSetPhoneticPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PHONETICPR$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public boolean isSetT() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(T$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void removeR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void removeRPh(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPH$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void setPhoneticPr(CTPhoneticPr cTPhoneticPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PHONETICPR$6;
            CTPhoneticPr cTPhoneticPr2 = (CTPhoneticPr) typeStore.find_element_user(qName, 0);
            if (cTPhoneticPr2 == null) {
                cTPhoneticPr2 = (CTPhoneticPr) get_store().add_element_user(qName);
            }
            cTPhoneticPr2.set(cTPhoneticPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void setRArray(int i, CTRElt cTRElt) {
        synchronized (monitor()) {
            check_orphaned();
            CTRElt cTRElt2 = (CTRElt) get_store().find_element_user(R$2, i);
            if (cTRElt2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRElt2.set(cTRElt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void setRArray(CTRElt[] cTREltArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTREltArr, R$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void setRPhArray(int i, CTPhoneticRun cTPhoneticRun) {
        synchronized (monitor()) {
            check_orphaned();
            CTPhoneticRun cTPhoneticRunFind_element_user = get_store().find_element_user(RPH$4, i);
            if (cTPhoneticRunFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPhoneticRunFind_element_user.set(cTPhoneticRun);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void setRPhArray(CTPhoneticRun[] cTPhoneticRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPhoneticRunArr, RPH$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void setT(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(R$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public int sizeOfRPhArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(RPH$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void unsetPhoneticPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PHONETICPR$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void unsetT() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(T$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public STXstring xgetT() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_element_user(T$0, 0);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void xsetT(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = T$0;
            STXstring sTXstring2 = (STXstring) typeStore.find_element_user(qName, 0);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_element_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }
}
