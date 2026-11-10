package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTIconSetImpl extends XmlComplexContentImpl implements CTIconSet {
    private static final QName CFVO$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cfvo");
    private static final QName ICONSET$2 = new QName("", "iconSet");
    private static final QName SHOWVALUE$4 = new QName("", "showValue");
    private static final QName PERCENT$6 = new QName("", "percent");
    private static final QName REVERSE$8 = new QName("", "reverse");

    public CTIconSetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public CTCfvo addNewCfvo() {
        CTCfvo cTCfvo;
        synchronized (monitor()) {
            check_orphaned();
            cTCfvo = (CTCfvo) get_store().add_element_user(CFVO$0);
        }
        return cTCfvo;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public CTCfvo getCfvoArray(int i) {
        CTCfvo cTCfvo;
        synchronized (monitor()) {
            check_orphaned();
            cTCfvo = (CTCfvo) get_store().find_element_user(CFVO$0, i);
            if (cTCfvo == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCfvo;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public CTCfvo[] getCfvoArray() {
        CTCfvo[] cTCfvoArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CFVO$0, arrayList);
            cTCfvoArr = new CTCfvo[arrayList.size()];
            arrayList.toArray(cTCfvoArr);
        }
        return cTCfvoArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public List<CTCfvo> getCfvoList() {
        1CfvoList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CfvoList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public STIconSetType.Enum getIconSet() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICONSET$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STIconSetType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public boolean getPercent() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERCENT$6;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public boolean getReverse() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REVERSE$8;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public boolean getShowValue() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWVALUE$4;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public CTCfvo insertNewCfvo(int i) {
        CTCfvo cTCfvo;
        synchronized (monitor()) {
            check_orphaned();
            cTCfvo = (CTCfvo) get_store().insert_element_user(CFVO$0, i);
        }
        return cTCfvo;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public boolean isSetIconSet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ICONSET$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public boolean isSetPercent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PERCENT$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public boolean isSetReverse() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REVERSE$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public boolean isSetShowValue() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWVALUE$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void removeCfvo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CFVO$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void setCfvoArray(int i, CTCfvo cTCfvo) {
        synchronized (monitor()) {
            check_orphaned();
            CTCfvo cTCfvo2 = (CTCfvo) get_store().find_element_user(CFVO$0, i);
            if (cTCfvo2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCfvo2.set(cTCfvo);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void setCfvoArray(CTCfvo[] cTCfvoArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCfvoArr, CFVO$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void setIconSet(STIconSetType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICONSET$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void setPercent(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERCENT$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void setReverse(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REVERSE$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void setShowValue(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWVALUE$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public int sizeOfCfvoArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CFVO$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void unsetIconSet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ICONSET$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void unsetPercent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PERCENT$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void unsetReverse() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REVERSE$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void unsetShowValue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWVALUE$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public STIconSetType xgetIconSet() {
        STIconSetType sTIconSetType;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICONSET$2;
            sTIconSetType = (STIconSetType) typeStore.find_attribute_user(qName);
            if (sTIconSetType == null) {
                sTIconSetType = (STIconSetType) get_default_attribute_value(qName);
            }
        }
        return sTIconSetType;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public XmlBoolean xgetPercent() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERCENT$6;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public XmlBoolean xgetReverse() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REVERSE$8;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public XmlBoolean xgetShowValue() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWVALUE$4;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void xsetIconSet(STIconSetType sTIconSetType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICONSET$2;
            STIconSetType sTIconSetType2 = (STIconSetType) typeStore.find_attribute_user(qName);
            if (sTIconSetType2 == null) {
                sTIconSetType2 = (STIconSetType) get_store().add_attribute_user(qName);
            }
            sTIconSetType2.set((XmlObject) sTIconSetType);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void xsetPercent(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PERCENT$6;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void xsetReverse(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REVERSE$8;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet
    public void xsetShowValue(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWVALUE$4;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}
