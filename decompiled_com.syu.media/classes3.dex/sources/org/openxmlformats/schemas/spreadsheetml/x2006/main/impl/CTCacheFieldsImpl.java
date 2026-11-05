package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCacheFieldsImpl extends XmlComplexContentImpl implements CTCacheFields {
    private static final QName CACHEFIELD$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cacheField");
    private static final QName COUNT$2 = new QName("", "count");

    public CTCacheFieldsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
    public CTCacheField addNewCacheField() {
        CTCacheField cTCacheField;
        synchronized (monitor()) {
            check_orphaned();
            cTCacheField = (CTCacheField) get_store().add_element_user(CACHEFIELD$0);
        }
        return cTCacheField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
    public CTCacheField getCacheFieldArray(int i) {
        CTCacheField cTCacheField;
        synchronized (monitor()) {
            check_orphaned();
            cTCacheField = (CTCacheField) get_store().find_element_user(CACHEFIELD$0, i);
            if (cTCacheField == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCacheField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
    public CTCacheField[] getCacheFieldArray() {
        CTCacheField[] cTCacheFieldArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CACHEFIELD$0, arrayList);
            cTCacheFieldArr = new CTCacheField[arrayList.size()];
            arrayList.toArray(cTCacheFieldArr);
        }
        return cTCacheFieldArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
    public List<CTCacheField> getCacheFieldList() {
        1CacheFieldList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CacheFieldList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
    public CTCacheField insertNewCacheField(int i) {
        CTCacheField cTCacheField;
        synchronized (monitor()) {
            check_orphaned();
            cTCacheField = (CTCacheField) get_store().insert_element_user(CACHEFIELD$0, i);
        }
        return cTCacheField;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
    public void removeCacheField(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CACHEFIELD$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
    public void setCacheFieldArray(int i, CTCacheField cTCacheField) {
        synchronized (monitor()) {
            check_orphaned();
            CTCacheField cTCacheField2 = (CTCacheField) get_store().find_element_user(CACHEFIELD$0, i);
            if (cTCacheField2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCacheField2.set(cTCacheField);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
    public void setCacheFieldArray(CTCacheField[] cTCacheFieldArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCacheFieldArr, CACHEFIELD$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
    public int sizeOfCacheFieldArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CACHEFIELD$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields
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
