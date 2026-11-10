package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPageFieldsImpl extends XmlComplexContentImpl implements CTPageFields {
    private static final QName PAGEFIELD$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageField");
    private static final QName COUNT$2 = new QName("", "count");

    public CTPageFieldsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public CTPageField addNewPageField() {
        CTPageField cTPageField;
        synchronized (monitor()) {
            check_orphaned();
            cTPageField = (CTPageField) get_store().add_element_user(PAGEFIELD$0);
        }
        return cTPageField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public long getCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COUNT$2);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public CTPageField getPageFieldArray(int i) {
        CTPageField cTPageField;
        synchronized (monitor()) {
            check_orphaned();
            cTPageField = (CTPageField) get_store().find_element_user(PAGEFIELD$0, i);
            if (cTPageField == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPageField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public CTPageField[] getPageFieldArray() {
        CTPageField[] cTPageFieldArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PAGEFIELD$0, arrayList);
            cTPageFieldArr = new CTPageField[arrayList.size()];
            arrayList.toArray(cTPageFieldArr);
        }
        return cTPageFieldArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public List<CTPageField> getPageFieldList() {
        1PageFieldList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PageFieldList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public CTPageField insertNewPageField(int i) {
        CTPageField cTPageField;
        synchronized (monitor()) {
            check_orphaned();
            cTPageField = (CTPageField) get_store().insert_element_user(PAGEFIELD$0, i);
        }
        return cTPageField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public void removePageField(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGEFIELD$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public void setPageFieldArray(int i, CTPageField cTPageField) {
        synchronized (monitor()) {
            check_orphaned();
            CTPageField cTPageField2 = (CTPageField) get_store().find_element_user(PAGEFIELD$0, i);
            if (cTPageField2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPageField2.set(cTPageField);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public void setPageFieldArray(CTPageField[] cTPageFieldArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPageFieldArr, PAGEFIELD$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public int sizeOfPageFieldArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PAGEFIELD$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields
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
