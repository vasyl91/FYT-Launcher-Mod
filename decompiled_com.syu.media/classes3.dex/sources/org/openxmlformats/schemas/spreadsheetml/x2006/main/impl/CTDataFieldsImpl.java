package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTDataFieldsImpl extends XmlComplexContentImpl implements CTDataFields {
    private static final QName DATAFIELD$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dataField");
    private static final QName COUNT$2 = new QName("", "count");

    public CTDataFieldsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
    public CTDataField addNewDataField() {
        CTDataField cTDataField;
        synchronized (monitor()) {
            check_orphaned();
            cTDataField = (CTDataField) get_store().add_element_user(DATAFIELD$0);
        }
        return cTDataField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
    public CTDataField getDataFieldArray(int i) {
        CTDataField cTDataField;
        synchronized (monitor()) {
            check_orphaned();
            cTDataField = (CTDataField) get_store().find_element_user(DATAFIELD$0, i);
            if (cTDataField == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDataField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
    public CTDataField[] getDataFieldArray() {
        CTDataField[] cTDataFieldArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DATAFIELD$0, arrayList);
            cTDataFieldArr = new CTDataField[arrayList.size()];
            arrayList.toArray(cTDataFieldArr);
        }
        return cTDataFieldArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
    public List<CTDataField> getDataFieldList() {
        AbstractList<CTDataField> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTDataField>() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTDataFieldsImpl.1DataFieldList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTDataField cTDataField) {
                    CTDataFieldsImpl.this.insertNewDataField(i).set(cTDataField);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTDataField get(int i) {
                    return CTDataFieldsImpl.this.getDataFieldArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTDataField remove(int i) {
                    CTDataField dataFieldArray = CTDataFieldsImpl.this.getDataFieldArray(i);
                    CTDataFieldsImpl.this.removeDataField(i);
                    return dataFieldArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTDataField set(int i, CTDataField cTDataField) {
                    CTDataField dataFieldArray = CTDataFieldsImpl.this.getDataFieldArray(i);
                    CTDataFieldsImpl.this.setDataFieldArray(i, cTDataField);
                    return dataFieldArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTDataFieldsImpl.this.sizeOfDataFieldArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
    public CTDataField insertNewDataField(int i) {
        CTDataField cTDataField;
        synchronized (monitor()) {
            check_orphaned();
            cTDataField = (CTDataField) get_store().insert_element_user(DATAFIELD$0, i);
        }
        return cTDataField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
    public void removeDataField(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATAFIELD$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
    public void setDataFieldArray(int i, CTDataField cTDataField) {
        synchronized (monitor()) {
            check_orphaned();
            CTDataField cTDataField2 = (CTDataField) get_store().find_element_user(DATAFIELD$0, i);
            if (cTDataField2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDataField2.set(cTDataField);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
    public void setDataFieldArray(CTDataField[] cTDataFieldArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTDataFieldArr, DATAFIELD$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
    public int sizeOfDataFieldArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DATAFIELD$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields
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
