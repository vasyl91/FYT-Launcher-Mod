package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTDataBarImpl extends XmlComplexContentImpl implements CTDataBar {
    private static final QName CFVO$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cfvo");
    private static final QName COLOR$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "color");
    private static final QName MINLENGTH$4 = new QName("", "minLength");
    private static final QName MAXLENGTH$6 = new QName("", "maxLength");
    private static final QName SHOWVALUE$8 = new QName("", "showValue");

    public CTDataBarImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public CTCfvo addNewCfvo() {
        CTCfvo cTCfvo;
        synchronized (monitor()) {
            check_orphaned();
            cTCfvo = (CTCfvo) get_store().add_element_user(CFVO$0);
        }
        return cTCfvo;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public CTColor addNewColor() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(COLOR$2);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public List<CTCfvo> getCfvoList() {
        1CfvoList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CfvoList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public CTColor getColor() {
        synchronized (monitor()) {
            check_orphaned();
            CTColor cTColor = (CTColor) get_store().find_element_user(COLOR$2, 0);
            if (cTColor == null) {
                return null;
            }
            return cTColor;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public long getMaxLength() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXLENGTH$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public long getMinLength() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINLENGTH$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public boolean getShowValue() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWVALUE$8;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public CTCfvo insertNewCfvo(int i) {
        CTCfvo cTCfvo;
        synchronized (monitor()) {
            check_orphaned();
            cTCfvo = (CTCfvo) get_store().insert_element_user(CFVO$0, i);
        }
        return cTCfvo;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public boolean isSetMaxLength() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MAXLENGTH$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public boolean isSetMinLength() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MINLENGTH$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public boolean isSetShowValue() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWVALUE$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public void removeCfvo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CFVO$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public void setCfvoArray(CTCfvo[] cTCfvoArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCfvoArr, CFVO$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public void setColor(CTColor cTColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$2;
            CTColor cTColor2 = (CTColor) typeStore.find_element_user(qName, 0);
            if (cTColor2 == null) {
                cTColor2 = (CTColor) get_store().add_element_user(qName);
            }
            cTColor2.set(cTColor);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public void setMaxLength(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXLENGTH$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public void setMinLength(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINLENGTH$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public void setShowValue(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWVALUE$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public int sizeOfCfvoArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CFVO$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public void unsetMaxLength() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MAXLENGTH$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public void unsetMinLength() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MINLENGTH$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public void unsetShowValue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWVALUE$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public XmlUnsignedInt xgetMaxLength() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXLENGTH$6;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public XmlUnsignedInt xgetMinLength() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINLENGTH$4;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public XmlBoolean xgetShowValue() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWVALUE$8;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public void xsetMaxLength(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXLENGTH$6;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public void xsetMinLength(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINLENGTH$4;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar
    public void xsetShowValue(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWVALUE$8;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}
