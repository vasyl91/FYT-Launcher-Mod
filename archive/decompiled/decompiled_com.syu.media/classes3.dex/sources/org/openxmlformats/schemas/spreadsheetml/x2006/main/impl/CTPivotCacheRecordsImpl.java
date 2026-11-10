package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRecord;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPivotCacheRecordsImpl extends XmlComplexContentImpl implements CTPivotCacheRecords {
    private static final QName R$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "r");
    private static final QName EXTLST$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
    private static final QName COUNT$4 = new QName("", "count");

    public CTPivotCacheRecordsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$2);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public CTRecord addNewR() {
        CTRecord cTRecordAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRecordAdd_element_user = get_store().add_element_user(R$0);
        }
        return cTRecordAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public long getCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COUNT$4);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$2, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public CTRecord getRArray(int i) {
        CTRecord cTRecordFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRecordFind_element_user = get_store().find_element_user(R$0, i);
            if (cTRecordFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRecordFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public CTRecord[] getRArray() {
        CTRecord[] cTRecordArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R$0, arrayList);
            cTRecordArr = new CTRecord[arrayList.size()];
            arrayList.toArray(cTRecordArr);
        }
        return cTRecordArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public List<CTRecord> getRList() {
        1RList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public CTRecord insertNewR(int i) {
        CTRecord cTRecordInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRecordInsert_element_user = get_store().insert_element_user(R$0, i);
        }
        return cTRecordInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void removeR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void setCount(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$2;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void setRArray(int i, CTRecord cTRecord) {
        synchronized (monitor()) {
            check_orphaned();
            CTRecord cTRecordFind_element_user = get_store().find_element_user(R$0, i);
            if (cTRecordFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRecordFind_element_user.set(cTRecord);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void setRArray(CTRecord[] cTRecordArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTRecordArr, R$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(R$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$4);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords
    public void xsetCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$4;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }
}
