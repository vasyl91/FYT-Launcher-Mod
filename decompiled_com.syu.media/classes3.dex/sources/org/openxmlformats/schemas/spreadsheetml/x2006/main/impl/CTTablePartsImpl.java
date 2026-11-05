package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTablePart;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTablePartsImpl extends XmlComplexContentImpl implements CTTableParts {
    private static final QName TABLEPART$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tablePart");
    private static final QName COUNT$2 = new QName("", "count");

    public CTTablePartsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public CTTablePart addNewTablePart() {
        CTTablePart cTTablePart;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePart = (CTTablePart) get_store().add_element_user(TABLEPART$0);
        }
        return cTTablePart;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public CTTablePart getTablePartArray(int i) {
        CTTablePart cTTablePart;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePart = (CTTablePart) get_store().find_element_user(TABLEPART$0, i);
            if (cTTablePart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTablePart;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public CTTablePart[] getTablePartArray() {
        CTTablePart[] cTTablePartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TABLEPART$0, arrayList);
            cTTablePartArr = new CTTablePart[arrayList.size()];
            arrayList.toArray(cTTablePartArr);
        }
        return cTTablePartArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public List<CTTablePart> getTablePartList() {
        1TablePartList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TablePartList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public CTTablePart insertNewTablePart(int i) {
        CTTablePart cTTablePart;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePart = (CTTablePart) get_store().insert_element_user(TABLEPART$0, i);
        }
        return cTTablePart;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public void removeTablePart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABLEPART$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public void setTablePartArray(int i, CTTablePart cTTablePart) {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePart cTTablePart2 = (CTTablePart) get_store().find_element_user(TABLEPART$0, i);
            if (cTTablePart2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTablePart2.set(cTTablePart);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public void setTablePartArray(CTTablePart[] cTTablePartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTablePartArr, TABLEPART$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public int sizeOfTablePartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TABLEPART$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts
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
