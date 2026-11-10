package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItem;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTItemsImpl extends XmlComplexContentImpl implements CTItems {
    private static final QName ITEM$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "item");
    private static final QName COUNT$2 = new QName("", "count");

    public CTItemsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public CTItem addNewItem() {
        CTItem cTItem;
        synchronized (monitor()) {
            check_orphaned();
            cTItem = (CTItem) get_store().add_element_user(ITEM$0);
        }
        return cTItem;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public CTItem getItemArray(int i) {
        CTItem cTItem;
        synchronized (monitor()) {
            check_orphaned();
            cTItem = (CTItem) get_store().find_element_user(ITEM$0, i);
            if (cTItem == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTItem;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public CTItem[] getItemArray() {
        CTItem[] cTItemArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ITEM$0, arrayList);
            cTItemArr = new CTItem[arrayList.size()];
            arrayList.toArray(cTItemArr);
        }
        return cTItemArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public List<CTItem> getItemList() {
        1ItemList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ItemList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public CTItem insertNewItem(int i) {
        CTItem cTItem;
        synchronized (monitor()) {
            check_orphaned();
            cTItem = (CTItem) get_store().insert_element_user(ITEM$0, i);
        }
        return cTItem;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public void removeItem(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ITEM$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public void setItemArray(int i, CTItem cTItem) {
        synchronized (monitor()) {
            check_orphaned();
            CTItem cTItem2 = (CTItem) get_store().find_element_user(ITEM$0, i);
            if (cTItem2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTItem2.set(cTItem);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public void setItemArray(CTItem[] cTItemArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTItemArr, ITEM$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public int sizeOfItemArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ITEM$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems
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
