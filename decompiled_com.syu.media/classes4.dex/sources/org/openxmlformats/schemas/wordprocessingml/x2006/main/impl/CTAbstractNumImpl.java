package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMultiLevelType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTAbstractNumImpl extends XmlComplexContentImpl implements CTAbstractNum {
    private static final QName NSID$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "nsid");
    private static final QName MULTILEVELTYPE$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "multiLevelType");
    private static final QName TMPL$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tmpl");
    private static final QName NAME$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name");
    private static final QName STYLELINK$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styleLink");
    private static final QName NUMSTYLELINK$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numStyleLink");
    private static final QName LVL$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvl");
    private static final QName ABSTRACTNUMID$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "abstractNumId");

    public CTAbstractNumImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLvl addNewLvl() {
        CTLvl cTLvlAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLvlAdd_element_user = get_store().add_element_user(LVL$12);
        }
        return cTLvlAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTMultiLevelType addNewMultiLevelType() {
        CTMultiLevelType cTMultiLevelTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMultiLevelTypeAdd_element_user = get_store().add_element_user(MULTILEVELTYPE$2);
        }
        return cTMultiLevelTypeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString addNewName() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(NAME$6);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLongHexNumber addNewNsid() {
        CTLongHexNumber cTLongHexNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLongHexNumberAdd_element_user = get_store().add_element_user(NSID$0);
        }
        return cTLongHexNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString addNewNumStyleLink() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(NUMSTYLELINK$10);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString addNewStyleLink() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(STYLELINK$8);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLongHexNumber addNewTmpl() {
        CTLongHexNumber cTLongHexNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLongHexNumberAdd_element_user = get_store().add_element_user(TMPL$4);
        }
        return cTLongHexNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public BigInteger getAbstractNumId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ABSTRACTNUMID$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLvl getLvlArray(int i) {
        CTLvl cTLvlFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLvlFind_element_user = get_store().find_element_user(LVL$12, i);
            if (cTLvlFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLvlFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLvl[] getLvlArray() {
        CTLvl[] cTLvlArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LVL$12, arrayList);
            cTLvlArr = new CTLvl[arrayList.size()];
            arrayList.toArray(cTLvlArr);
        }
        return cTLvlArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public List<CTLvl> getLvlList() {
        1LvlList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LvlList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTMultiLevelType getMultiLevelType() {
        synchronized (monitor()) {
            check_orphaned();
            CTMultiLevelType cTMultiLevelTypeFind_element_user = get_store().find_element_user(MULTILEVELTYPE$2, 0);
            if (cTMultiLevelTypeFind_element_user == null) {
                return null;
            }
            return cTMultiLevelTypeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString getName() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(NAME$6, 0);
            if (cTStringFind_element_user == null) {
                return null;
            }
            return cTStringFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLongHexNumber getNsid() {
        synchronized (monitor()) {
            check_orphaned();
            CTLongHexNumber cTLongHexNumberFind_element_user = get_store().find_element_user(NSID$0, 0);
            if (cTLongHexNumberFind_element_user == null) {
                return null;
            }
            return cTLongHexNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString getNumStyleLink() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(NUMSTYLELINK$10, 0);
            if (cTStringFind_element_user == null) {
                return null;
            }
            return cTStringFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString getStyleLink() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(STYLELINK$8, 0);
            if (cTStringFind_element_user == null) {
                return null;
            }
            return cTStringFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLongHexNumber getTmpl() {
        synchronized (monitor()) {
            check_orphaned();
            CTLongHexNumber cTLongHexNumberFind_element_user = get_store().find_element_user(TMPL$4, 0);
            if (cTLongHexNumberFind_element_user == null) {
                return null;
            }
            return cTLongHexNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLvl insertNewLvl(int i) {
        CTLvl cTLvlInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLvlInsert_element_user = get_store().insert_element_user(LVL$12, i);
        }
        return cTLvlInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetMultiLevelType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MULTILEVELTYPE$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NAME$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetNsid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NSID$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetNumStyleLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMSTYLELINK$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetStyleLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STYLELINK$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetTmpl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TMPL$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void removeLvl(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVL$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setAbstractNumId(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACTNUMID$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setLvlArray(int i, CTLvl cTLvl) {
        synchronized (monitor()) {
            check_orphaned();
            CTLvl cTLvlFind_element_user = get_store().find_element_user(LVL$12, i);
            if (cTLvlFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLvlFind_element_user.set(cTLvl);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setLvlArray(CTLvl[] cTLvlArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLvlArr, LVL$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setMultiLevelType(CTMultiLevelType cTMultiLevelType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MULTILEVELTYPE$2;
            CTMultiLevelType cTMultiLevelTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTMultiLevelTypeFind_element_user == null) {
                cTMultiLevelTypeFind_element_user = (CTMultiLevelType) get_store().add_element_user(qName);
            }
            cTMultiLevelTypeFind_element_user.set(cTMultiLevelType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setName(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$6;
            CTString cTStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTStringFind_element_user == null) {
                cTStringFind_element_user = (CTString) get_store().add_element_user(qName);
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setNsid(CTLongHexNumber cTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NSID$0;
            CTLongHexNumber cTLongHexNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLongHexNumberFind_element_user == null) {
                cTLongHexNumberFind_element_user = (CTLongHexNumber) get_store().add_element_user(qName);
            }
            cTLongHexNumberFind_element_user.set(cTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setNumStyleLink(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMSTYLELINK$10;
            CTString cTStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTStringFind_element_user == null) {
                cTStringFind_element_user = (CTString) get_store().add_element_user(qName);
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setStyleLink(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLELINK$8;
            CTString cTStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTStringFind_element_user == null) {
                cTStringFind_element_user = (CTString) get_store().add_element_user(qName);
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setTmpl(CTLongHexNumber cTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TMPL$4;
            CTLongHexNumber cTLongHexNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLongHexNumberFind_element_user == null) {
                cTLongHexNumberFind_element_user = (CTLongHexNumber) get_store().add_element_user(qName);
            }
            cTLongHexNumberFind_element_user.set(cTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public int sizeOfLvlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LVL$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetMultiLevelType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MULTILEVELTYPE$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NAME$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetNsid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NSID$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetNumStyleLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMSTYLELINK$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetStyleLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STYLELINK$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetTmpl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TMPL$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public STDecimalNumber xgetAbstractNumId() {
        STDecimalNumber sTDecimalNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumberFind_attribute_user = get_store().find_attribute_user(ABSTRACTNUMID$14);
        }
        return sTDecimalNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void xsetAbstractNumId(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACTNUMID$14;
            STDecimalNumber sTDecimalNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDecimalNumberFind_attribute_user == null) {
                sTDecimalNumberFind_attribute_user = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumberFind_attribute_user.set(sTDecimalNumber);
        }
    }
}
