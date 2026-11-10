package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTFFCheckBoxImpl extends XmlComplexContentImpl implements CTFFCheckBox {
    private static final QName SIZE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "size");
    private static final QName SIZEAUTO$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sizeAuto");
    private static final QName DEFAULT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "default");
    private static final QName CHECKED$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "checked");

    public CTFFCheckBoxImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTOnOff addNewChecked() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(CHECKED$6);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTOnOff addNewDefault() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DEFAULT$4);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTHpsMeasure addNewSize() {
        CTHpsMeasure cTHpsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasureAdd_element_user = get_store().add_element_user(SIZE$0);
        }
        return cTHpsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTOnOff addNewSizeAuto() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(SIZEAUTO$2);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTOnOff getChecked() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(CHECKED$6, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTOnOff getDefault() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DEFAULT$4, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTHpsMeasure getSize() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasureFind_element_user = get_store().find_element_user(SIZE$0, 0);
            if (cTHpsMeasureFind_element_user == null) {
                return null;
            }
            return cTHpsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTOnOff getSizeAuto() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(SIZEAUTO$2, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public boolean isSetChecked() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CHECKED$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public boolean isSetDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DEFAULT$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public boolean isSetSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIZE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public boolean isSetSizeAuto() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIZEAUTO$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void setChecked(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHECKED$6;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void setDefault(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULT$4;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void setSize(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$0;
            CTHpsMeasure cTHpsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHpsMeasureFind_element_user == null) {
                cTHpsMeasureFind_element_user = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasureFind_element_user.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void setSizeAuto(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZEAUTO$2;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void unsetChecked() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHECKED$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void unsetDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEFAULT$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void unsetSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIZE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void unsetSizeAuto() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIZEAUTO$2, 0);
        }
    }
}
