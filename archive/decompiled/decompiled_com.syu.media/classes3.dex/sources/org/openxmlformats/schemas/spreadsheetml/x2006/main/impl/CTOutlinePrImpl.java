package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTOutlinePrImpl extends XmlComplexContentImpl implements CTOutlinePr {
    private static final QName APPLYSTYLES$0 = new QName("", "applyStyles");
    private static final QName SUMMARYBELOW$2 = new QName("", "summaryBelow");
    private static final QName SUMMARYRIGHT$4 = new QName("", "summaryRight");
    private static final QName SHOWOUTLINESYMBOLS$6 = new QName("", "showOutlineSymbols");

    public CTOutlinePrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public boolean getApplyStyles() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYSTYLES$0;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public boolean getShowOutlineSymbols() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWOUTLINESYMBOLS$6;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public boolean getSummaryBelow() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUMMARYBELOW$2;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public boolean getSummaryRight() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUMMARYRIGHT$4;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public boolean isSetApplyStyles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(APPLYSTYLES$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public boolean isSetShowOutlineSymbols() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWOUTLINESYMBOLS$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public boolean isSetSummaryBelow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SUMMARYBELOW$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public boolean isSetSummaryRight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SUMMARYRIGHT$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public void setApplyStyles(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYSTYLES$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public void setShowOutlineSymbols(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWOUTLINESYMBOLS$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public void setSummaryBelow(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUMMARYBELOW$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public void setSummaryRight(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUMMARYRIGHT$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public void unsetApplyStyles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(APPLYSTYLES$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public void unsetShowOutlineSymbols() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWOUTLINESYMBOLS$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public void unsetSummaryBelow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SUMMARYBELOW$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public void unsetSummaryRight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SUMMARYRIGHT$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public XmlBoolean xgetApplyStyles() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYSTYLES$0;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public XmlBoolean xgetShowOutlineSymbols() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWOUTLINESYMBOLS$6;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public XmlBoolean xgetSummaryBelow() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUMMARYBELOW$2;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public XmlBoolean xgetSummaryRight() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUMMARYRIGHT$4;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public void xsetApplyStyles(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYSTYLES$0;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public void xsetShowOutlineSymbols(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHOWOUTLINESYMBOLS$6;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public void xsetSummaryBelow(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUMMARYBELOW$2;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr
    public void xsetSummaryRight(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUMMARYRIGHT$4;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}
