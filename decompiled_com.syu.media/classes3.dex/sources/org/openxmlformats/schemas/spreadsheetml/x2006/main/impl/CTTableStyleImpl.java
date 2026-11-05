package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTableStyleImpl extends XmlComplexContentImpl implements CTTableStyle {
    private static final QName TABLESTYLEELEMENT$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tableStyleElement");
    private static final QName NAME$2 = new QName("", "name");
    private static final QName PIVOT$4 = new QName("", "pivot");
    private static final QName TABLE$6 = new QName("", "table");
    private static final QName COUNT$8 = new QName("", "count");

    public CTTableStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public CTTableStyleElement addNewTableStyleElement() {
        CTTableStyleElement cTTableStyleElement;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleElement = (CTTableStyleElement) get_store().add_element_user(TABLESTYLEELEMENT$0);
        }
        return cTTableStyleElement;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public long getCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COUNT$8);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public boolean getPivot() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOT$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public boolean getTable() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public CTTableStyleElement getTableStyleElementArray(int i) {
        CTTableStyleElement cTTableStyleElement;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleElement = (CTTableStyleElement) get_store().find_element_user(TABLESTYLEELEMENT$0, i);
            if (cTTableStyleElement == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTableStyleElement;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public CTTableStyleElement[] getTableStyleElementArray() {
        CTTableStyleElement[] cTTableStyleElementArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TABLESTYLEELEMENT$0, arrayList);
            cTTableStyleElementArr = new CTTableStyleElement[arrayList.size()];
            arrayList.toArray(cTTableStyleElementArr);
        }
        return cTTableStyleElementArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public List<CTTableStyleElement> getTableStyleElementList() {
        AbstractList<CTTableStyleElement> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTableStyleElement>() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTTableStyleImpl.1TableStyleElementList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTableStyleElement cTTableStyleElement) {
                    CTTableStyleImpl.this.insertNewTableStyleElement(i).set(cTTableStyleElement);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTableStyleElement get(int i) {
                    return CTTableStyleImpl.this.getTableStyleElementArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTableStyleElement remove(int i) {
                    CTTableStyleElement tableStyleElementArray = CTTableStyleImpl.this.getTableStyleElementArray(i);
                    CTTableStyleImpl.this.removeTableStyleElement(i);
                    return tableStyleElementArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTableStyleElement set(int i, CTTableStyleElement cTTableStyleElement) {
                    CTTableStyleElement tableStyleElementArray = CTTableStyleImpl.this.getTableStyleElementArray(i);
                    CTTableStyleImpl.this.setTableStyleElementArray(i, cTTableStyleElement);
                    return tableStyleElementArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTableStyleImpl.this.sizeOfTableStyleElementArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public CTTableStyleElement insertNewTableStyleElement(int i) {
        CTTableStyleElement cTTableStyleElement;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleElement = (CTTableStyleElement) get_store().insert_element_user(TABLESTYLEELEMENT$0, i);
        }
        return cTTableStyleElement;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public boolean isSetPivot() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PIVOT$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public boolean isSetTable() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TABLE$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void removeTableStyleElement(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABLESTYLEELEMENT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void setCount(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void setPivot(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOT$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void setTable(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void setTableStyleElementArray(int i, CTTableStyleElement cTTableStyleElement) {
        synchronized (monitor()) {
            check_orphaned();
            CTTableStyleElement cTTableStyleElement2 = (CTTableStyleElement) get_store().find_element_user(TABLESTYLEELEMENT$0, i);
            if (cTTableStyleElement2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTableStyleElement2.set(cTTableStyleElement);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void setTableStyleElementArray(CTTableStyleElement[] cTTableStyleElementArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTableStyleElementArr, TABLESTYLEELEMENT$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public int sizeOfTableStyleElementArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TABLESTYLEELEMENT$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void unsetPivot() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PIVOT$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void unsetTable() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TABLE$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$8);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public XmlString xgetName() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(NAME$2);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public XmlBoolean xgetPivot() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOT$4;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public XmlBoolean xgetTable() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLE$6;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void xsetCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$8;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$2;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void xsetPivot(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOT$4;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle
    public void xsetTable(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLE$6;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}
