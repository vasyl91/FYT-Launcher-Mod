package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTRowFieldsImpl extends XmlComplexContentImpl implements CTRowFields {
    private static final QName FIELD$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", JamXmlElements.FIELD);
    private static final QName COUNT$2 = new QName("", "count");

    public CTRowFieldsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public CTField addNewField() {
        CTField cTField;
        synchronized (monitor()) {
            check_orphaned();
            cTField = (CTField) get_store().add_element_user(FIELD$0);
        }
        return cTField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public long getCount() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public CTField getFieldArray(int i) {
        CTField cTField;
        synchronized (monitor()) {
            check_orphaned();
            cTField = (CTField) get_store().find_element_user(FIELD$0, i);
            if (cTField == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public CTField[] getFieldArray() {
        CTField[] cTFieldArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FIELD$0, arrayList);
            cTFieldArr = new CTField[arrayList.size()];
            arrayList.toArray(cTFieldArr);
        }
        return cTFieldArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public List<CTField> getFieldList() {
        1FieldList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FieldList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public CTField insertNewField(int i) {
        CTField cTField;
        synchronized (monitor()) {
            check_orphaned();
            cTField = (CTField) get_store().insert_element_user(FIELD$0, i);
        }
        return cTField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public void removeField(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FIELD$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public void setCount(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public void setFieldArray(int i, CTField cTField) {
        synchronized (monitor()) {
            check_orphaned();
            CTField cTField2 = (CTField) get_store().find_element_user(FIELD$0, i);
            if (cTField2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTField2.set(cTField);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public void setFieldArray(CTField[] cTFieldArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFieldArr, FIELD$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public int sizeOfFieldArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FIELD$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$2;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields
    public void xsetCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$2;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }
}
