package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChangeNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTFldCharImpl extends XmlComplexContentImpl implements CTFldChar {
    private static final QName FLDDATA$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldData");
    private static final QName FFDATA$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ffData");
    private static final QName NUMBERINGCHANGE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numberingChange");
    private static final QName FLDCHARTYPE$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldCharType");
    private static final QName FLDLOCK$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldLock");
    private static final QName DIRTY$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dirty");

    public CTFldCharImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public CTFFData addNewFfData() {
        CTFFData cTFFDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFDataAdd_element_user = get_store().add_element_user(FFDATA$2);
        }
        return cTFFDataAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public CTText addNewFldData() {
        CTText cTTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextAdd_element_user = get_store().add_element_user(FLDDATA$0);
        }
        return cTTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public CTTrackChangeNumbering addNewNumberingChange() {
        CTTrackChangeNumbering cTTrackChangeNumberingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeNumberingAdd_element_user = get_store().add_element_user(NUMBERINGCHANGE$4);
        }
        return cTTrackChangeNumberingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public STOnOff.Enum getDirty() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DIRTY$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public CTFFData getFfData() {
        synchronized (monitor()) {
            check_orphaned();
            CTFFData cTFFDataFind_element_user = get_store().find_element_user(FFDATA$2, 0);
            if (cTFFDataFind_element_user == null) {
                return null;
            }
            return cTFFDataFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public STFldCharType.Enum getFldCharType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FLDCHARTYPE$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STFldCharType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public CTText getFldData() {
        synchronized (monitor()) {
            check_orphaned();
            CTText cTTextFind_element_user = get_store().find_element_user(FLDDATA$0, 0);
            if (cTTextFind_element_user == null) {
                return null;
            }
            return cTTextFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public STOnOff.Enum getFldLock() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FLDLOCK$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public CTTrackChangeNumbering getNumberingChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChangeNumbering cTTrackChangeNumberingFind_element_user = get_store().find_element_user(NUMBERINGCHANGE$4, 0);
            if (cTTrackChangeNumberingFind_element_user == null) {
                return null;
            }
            return cTTrackChangeNumberingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public boolean isSetDirty() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DIRTY$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public boolean isSetFfData() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FFDATA$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public boolean isSetFldData() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FLDDATA$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public boolean isSetFldLock() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FLDLOCK$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public boolean isSetNumberingChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMBERINGCHANGE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void setDirty(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIRTY$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void setFfData(CTFFData cTFFData) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FFDATA$2;
            CTFFData cTFFDataFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFFDataFind_element_user == null) {
                cTFFDataFind_element_user = (CTFFData) get_store().add_element_user(qName);
            }
            cTFFDataFind_element_user.set(cTFFData);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void setFldCharType(STFldCharType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLDCHARTYPE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void setFldData(CTText cTText) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLDDATA$0;
            CTText cTTextFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTextFind_element_user == null) {
                cTTextFind_element_user = (CTText) get_store().add_element_user(qName);
            }
            cTTextFind_element_user.set(cTText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void setFldLock(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLDLOCK$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void setNumberingChange(CTTrackChangeNumbering cTTrackChangeNumbering) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMBERINGCHANGE$4;
            CTTrackChangeNumbering cTTrackChangeNumberingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTrackChangeNumberingFind_element_user == null) {
                cTTrackChangeNumberingFind_element_user = (CTTrackChangeNumbering) get_store().add_element_user(qName);
            }
            cTTrackChangeNumberingFind_element_user.set(cTTrackChangeNumbering);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void unsetDirty() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DIRTY$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void unsetFfData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FFDATA$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void unsetFldData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FLDDATA$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void unsetFldLock() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FLDLOCK$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void unsetNumberingChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMBERINGCHANGE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public STOnOff xgetDirty() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(DIRTY$10);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public STFldCharType xgetFldCharType() {
        STFldCharType sTFldCharTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTFldCharTypeFind_attribute_user = get_store().find_attribute_user(FLDCHARTYPE$6);
        }
        return sTFldCharTypeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public STOnOff xgetFldLock() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(FLDLOCK$8);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void xsetDirty(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIRTY$10;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void xsetFldCharType(STFldCharType sTFldCharType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLDCHARTYPE$6;
            STFldCharType sTFldCharTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTFldCharTypeFind_attribute_user == null) {
                sTFldCharTypeFind_attribute_user = (STFldCharType) get_store().add_attribute_user(qName);
            }
            sTFldCharTypeFind_attribute_user.set((XmlObject) sTFldCharType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void xsetFldLock(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLDLOCK$8;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }
}
