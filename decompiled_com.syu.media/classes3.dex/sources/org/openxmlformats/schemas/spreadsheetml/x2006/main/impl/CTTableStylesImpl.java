package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTableStylesImpl extends XmlComplexContentImpl implements CTTableStyles {
    private static final QName TABLESTYLE$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tableStyle");
    private static final QName COUNT$2 = new QName("", "count");
    private static final QName DEFAULTTABLESTYLE$4 = new QName("", "defaultTableStyle");
    private static final QName DEFAULTPIVOTSTYLE$6 = new QName("", "defaultPivotStyle");

    public CTTableStylesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public CTTableStyle addNewTableStyle() {
        CTTableStyle cTTableStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyle = (CTTableStyle) get_store().add_element_user(TABLESTYLE$0);
        }
        return cTTableStyle;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public String getDefaultPivotStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFAULTPIVOTSTYLE$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public String getDefaultTableStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFAULTTABLESTYLE$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public CTTableStyle getTableStyleArray(int i) {
        CTTableStyle cTTableStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyle = (CTTableStyle) get_store().find_element_user(TABLESTYLE$0, i);
            if (cTTableStyle == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTableStyle;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public CTTableStyle[] getTableStyleArray() {
        CTTableStyle[] cTTableStyleArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TABLESTYLE$0, arrayList);
            cTTableStyleArr = new CTTableStyle[arrayList.size()];
            arrayList.toArray(cTTableStyleArr);
        }
        return cTTableStyleArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public List<CTTableStyle> getTableStyleList() {
        1TableStyleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TableStyleList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public CTTableStyle insertNewTableStyle(int i) {
        CTTableStyle cTTableStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyle = (CTTableStyle) get_store().insert_element_user(TABLESTYLE$0, i);
        }
        return cTTableStyle;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public boolean isSetDefaultPivotStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFAULTPIVOTSTYLE$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public boolean isSetDefaultTableStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFAULTTABLESTYLE$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public void removeTableStyle(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABLESTYLE$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public void setDefaultPivotStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTPIVOTSTYLE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public void setDefaultTableStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTTABLESTYLE$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public void setTableStyleArray(int i, CTTableStyle cTTableStyle) {
        synchronized (monitor()) {
            check_orphaned();
            CTTableStyle cTTableStyle2 = (CTTableStyle) get_store().find_element_user(TABLESTYLE$0, i);
            if (cTTableStyle2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTableStyle2.set(cTTableStyle);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public void setTableStyleArray(CTTableStyle[] cTTableStyleArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTableStyleArr, TABLESTYLE$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public int sizeOfTableStyleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TABLESTYLE$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public void unsetDefaultPivotStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFAULTPIVOTSTYLE$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public void unsetDefaultTableStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFAULTTABLESTYLE$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public XmlString xgetDefaultPivotStyle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(DEFAULTPIVOTSTYLE$6);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public XmlString xgetDefaultTableStyle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(DEFAULTTABLESTYLE$4);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public void xsetDefaultPivotStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTPIVOTSTYLE$6;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles
    public void xsetDefaultTableStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTTABLESTYLE$4;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
