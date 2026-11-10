package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPivotFieldsImpl extends XmlComplexContentImpl implements CTPivotFields {
    private static final QName PIVOTFIELD$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pivotField");
    private static final QName COUNT$2 = new QName("", "count");

    public CTPivotFieldsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
    public CTPivotField addNewPivotField() {
        CTPivotField cTPivotField;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotField = (CTPivotField) get_store().add_element_user(PIVOTFIELD$0);
        }
        return cTPivotField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
    public CTPivotField getPivotFieldArray(int i) {
        CTPivotField cTPivotField;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotField = (CTPivotField) get_store().find_element_user(PIVOTFIELD$0, i);
            if (cTPivotField == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPivotField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
    public CTPivotField[] getPivotFieldArray() {
        CTPivotField[] cTPivotFieldArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PIVOTFIELD$0, arrayList);
            cTPivotFieldArr = new CTPivotField[arrayList.size()];
            arrayList.toArray(cTPivotFieldArr);
        }
        return cTPivotFieldArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
    public List<CTPivotField> getPivotFieldList() {
        1PivotFieldList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PivotFieldList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
    public CTPivotField insertNewPivotField(int i) {
        CTPivotField cTPivotField;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotField = (CTPivotField) get_store().insert_element_user(PIVOTFIELD$0, i);
        }
        return cTPivotField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
    public void removePivotField(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PIVOTFIELD$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
    public void setPivotFieldArray(int i, CTPivotField cTPivotField) {
        synchronized (monitor()) {
            check_orphaned();
            CTPivotField cTPivotField2 = (CTPivotField) get_store().find_element_user(PIVOTFIELD$0, i);
            if (cTPivotField2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPivotField2.set(cTPivotField);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
    public void setPivotFieldArray(CTPivotField[] cTPivotFieldArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPivotFieldArr, PIVOTFIELD$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
    public int sizeOfPivotFieldArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PIVOTFIELD$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields
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
