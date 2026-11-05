package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTNumImpl extends XmlComplexContentImpl implements CTNum {
    private static final QName ABSTRACTNUMID$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "abstractNumId");
    private static final QName LVLOVERRIDE$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlOverride");
    private static final QName NUMID$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numId");

    public CTNumImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public CTDecimalNumber addNewAbstractNumId() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(ABSTRACTNUMID$0);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public CTNumLvl addNewLvlOverride() {
        CTNumLvl cTNumLvlAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumLvlAdd_element_user = get_store().add_element_user(LVLOVERRIDE$2);
        }
        return cTNumLvlAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public CTDecimalNumber getAbstractNumId() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(ABSTRACTNUMID$0, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public CTNumLvl getLvlOverrideArray(int i) {
        CTNumLvl cTNumLvlFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumLvlFind_element_user = get_store().find_element_user(LVLOVERRIDE$2, i);
            if (cTNumLvlFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNumLvlFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public CTNumLvl[] getLvlOverrideArray() {
        CTNumLvl[] cTNumLvlArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LVLOVERRIDE$2, arrayList);
            cTNumLvlArr = new CTNumLvl[arrayList.size()];
            arrayList.toArray(cTNumLvlArr);
        }
        return cTNumLvlArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public List<CTNumLvl> getLvlOverrideList() {
        1LvlOverrideList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LvlOverrideList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public BigInteger getNumId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NUMID$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public CTNumLvl insertNewLvlOverride(int i) {
        CTNumLvl cTNumLvlInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumLvlInsert_element_user = get_store().insert_element_user(LVLOVERRIDE$2, i);
        }
        return cTNumLvlInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public void removeLvlOverride(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVLOVERRIDE$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public void setAbstractNumId(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACTNUMID$0;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public void setLvlOverrideArray(int i, CTNumLvl cTNumLvl) {
        synchronized (monitor()) {
            check_orphaned();
            CTNumLvl cTNumLvlFind_element_user = get_store().find_element_user(LVLOVERRIDE$2, i);
            if (cTNumLvlFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTNumLvlFind_element_user.set(cTNumLvl);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public void setLvlOverrideArray(CTNumLvl[] cTNumLvlArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTNumLvlArr, LVLOVERRIDE$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public void setNumId(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMID$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public int sizeOfLvlOverrideArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LVLOVERRIDE$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public STDecimalNumber xgetNumId() {
        STDecimalNumber sTDecimalNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumberFind_attribute_user = get_store().find_attribute_user(NUMID$4);
        }
        return sTDecimalNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public void xsetNumId(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMID$4;
            STDecimalNumber sTDecimalNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDecimalNumberFind_attribute_user == null) {
                sTDecimalNumberFind_attribute_user = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumberFind_attribute_user.set(sTDecimalNumber);
        }
    }
}
