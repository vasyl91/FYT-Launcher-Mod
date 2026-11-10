package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLsdException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTLatentStylesImpl extends XmlComplexContentImpl implements CTLatentStyles {
    private static final QName LSDEXCEPTION$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lsdException");
    private static final QName DEFLOCKEDSTATE$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defLockedState");
    private static final QName DEFUIPRIORITY$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defUIPriority");
    private static final QName DEFSEMIHIDDEN$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defSemiHidden");
    private static final QName DEFUNHIDEWHENUSED$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defUnhideWhenUsed");
    private static final QName DEFQFORMAT$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defQFormat");
    private static final QName COUNT$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "count");

    public CTLatentStylesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public CTLsdException addNewLsdException() {
        CTLsdException cTLsdExceptionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLsdExceptionAdd_element_user = get_store().add_element_user(LSDEXCEPTION$0);
        }
        return cTLsdExceptionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public BigInteger getCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COUNT$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff.Enum getDefLockedState() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFLOCKEDSTATE$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff.Enum getDefQFormat() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFQFORMAT$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff.Enum getDefSemiHidden() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFSEMIHIDDEN$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public BigInteger getDefUIPriority() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFUIPRIORITY$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff.Enum getDefUnhideWhenUsed() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFUNHIDEWHENUSED$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public CTLsdException getLsdExceptionArray(int i) {
        CTLsdException cTLsdExceptionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLsdExceptionFind_element_user = get_store().find_element_user(LSDEXCEPTION$0, i);
            if (cTLsdExceptionFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLsdExceptionFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public CTLsdException[] getLsdExceptionArray() {
        CTLsdException[] cTLsdExceptionArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LSDEXCEPTION$0, arrayList);
            cTLsdExceptionArr = new CTLsdException[arrayList.size()];
            arrayList.toArray(cTLsdExceptionArr);
        }
        return cTLsdExceptionArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public List<CTLsdException> getLsdExceptionList() {
        1LsdExceptionList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LsdExceptionList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public CTLsdException insertNewLsdException(int i) {
        CTLsdException cTLsdExceptionInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLsdExceptionInsert_element_user = get_store().insert_element_user(LSDEXCEPTION$0, i);
        }
        return cTLsdExceptionInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public boolean isSetDefLockedState() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFLOCKEDSTATE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public boolean isSetDefQFormat() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFQFORMAT$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public boolean isSetDefSemiHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFSEMIHIDDEN$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public boolean isSetDefUIPriority() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFUIPRIORITY$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public boolean isSetDefUnhideWhenUsed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFUNHIDEWHENUSED$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void removeLsdException(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LSDEXCEPTION$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setCount(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setDefLockedState(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFLOCKEDSTATE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setDefQFormat(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFQFORMAT$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setDefSemiHidden(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFSEMIHIDDEN$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setDefUIPriority(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFUIPRIORITY$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setDefUnhideWhenUsed(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFUNHIDEWHENUSED$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setLsdExceptionArray(int i, CTLsdException cTLsdException) {
        synchronized (monitor()) {
            check_orphaned();
            CTLsdException cTLsdExceptionFind_element_user = get_store().find_element_user(LSDEXCEPTION$0, i);
            if (cTLsdExceptionFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLsdExceptionFind_element_user.set(cTLsdException);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setLsdExceptionArray(CTLsdException[] cTLsdExceptionArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLsdExceptionArr, LSDEXCEPTION$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public int sizeOfLsdExceptionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LSDEXCEPTION$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void unsetDefLockedState() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFLOCKEDSTATE$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void unsetDefQFormat() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFQFORMAT$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void unsetDefSemiHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFSEMIHIDDEN$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void unsetDefUIPriority() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFUIPRIORITY$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void unsetDefUnhideWhenUsed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFUNHIDEWHENUSED$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STDecimalNumber xgetCount() {
        STDecimalNumber sTDecimalNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumberFind_attribute_user = get_store().find_attribute_user(COUNT$12);
        }
        return sTDecimalNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff xgetDefLockedState() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(DEFLOCKEDSTATE$2);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff xgetDefQFormat() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(DEFQFORMAT$10);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff xgetDefSemiHidden() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(DEFSEMIHIDDEN$6);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STDecimalNumber xgetDefUIPriority() {
        STDecimalNumber sTDecimalNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumberFind_attribute_user = get_store().find_attribute_user(DEFUIPRIORITY$4);
        }
        return sTDecimalNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff xgetDefUnhideWhenUsed() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(DEFUNHIDEWHENUSED$8);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void xsetCount(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$12;
            STDecimalNumber sTDecimalNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDecimalNumberFind_attribute_user == null) {
                sTDecimalNumberFind_attribute_user = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumberFind_attribute_user.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void xsetDefLockedState(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFLOCKEDSTATE$2;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void xsetDefQFormat(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFQFORMAT$10;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void xsetDefSemiHidden(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFSEMIHIDDEN$6;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void xsetDefUIPriority(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFUIPRIORITY$4;
            STDecimalNumber sTDecimalNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDecimalNumberFind_attribute_user == null) {
                sTDecimalNumberFind_attribute_user = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumberFind_attribute_user.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void xsetDefUnhideWhenUsed(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFUNHIDEWHENUSED$8;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }
}
