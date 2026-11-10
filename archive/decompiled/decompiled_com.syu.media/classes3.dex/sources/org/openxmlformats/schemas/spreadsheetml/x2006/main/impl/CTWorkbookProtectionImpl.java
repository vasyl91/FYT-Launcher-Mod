package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnsignedShortHex;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTWorkbookProtectionImpl extends XmlComplexContentImpl implements CTWorkbookProtection {
    private static final QName WORKBOOKPASSWORD$0 = new QName("", "workbookPassword");
    private static final QName REVISIONSPASSWORD$2 = new QName("", "revisionsPassword");
    private static final QName LOCKSTRUCTURE$4 = new QName("", "lockStructure");
    private static final QName LOCKWINDOWS$6 = new QName("", "lockWindows");
    private static final QName LOCKREVISION$8 = new QName("", "lockRevision");

    public CTWorkbookProtectionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public boolean getLockRevision() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKREVISION$8;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public boolean getLockStructure() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKSTRUCTURE$4;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public boolean getLockWindows() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKWINDOWS$6;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public byte[] getRevisionsPassword() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REVISIONSPASSWORD$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public byte[] getWorkbookPassword() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(WORKBOOKPASSWORD$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public boolean isSetLockRevision() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LOCKREVISION$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public boolean isSetLockStructure() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LOCKSTRUCTURE$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public boolean isSetLockWindows() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LOCKWINDOWS$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public boolean isSetRevisionsPassword() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REVISIONSPASSWORD$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public boolean isSetWorkbookPassword() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WORKBOOKPASSWORD$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void setLockRevision(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKREVISION$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void setLockStructure(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKSTRUCTURE$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void setLockWindows(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKWINDOWS$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void setRevisionsPassword(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REVISIONSPASSWORD$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void setWorkbookPassword(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WORKBOOKPASSWORD$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void unsetLockRevision() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LOCKREVISION$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void unsetLockStructure() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LOCKSTRUCTURE$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void unsetLockWindows() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LOCKWINDOWS$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void unsetRevisionsPassword() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REVISIONSPASSWORD$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void unsetWorkbookPassword() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WORKBOOKPASSWORD$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public XmlBoolean xgetLockRevision() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKREVISION$8;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public XmlBoolean xgetLockStructure() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKSTRUCTURE$4;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public XmlBoolean xgetLockWindows() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKWINDOWS$6;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public STUnsignedShortHex xgetRevisionsPassword() {
        STUnsignedShortHex sTUnsignedShortHex;
        synchronized (monitor()) {
            check_orphaned();
            sTUnsignedShortHex = (STUnsignedShortHex) get_store().find_attribute_user(REVISIONSPASSWORD$2);
        }
        return sTUnsignedShortHex;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public STUnsignedShortHex xgetWorkbookPassword() {
        STUnsignedShortHex sTUnsignedShortHex;
        synchronized (monitor()) {
            check_orphaned();
            sTUnsignedShortHex = (STUnsignedShortHex) get_store().find_attribute_user(WORKBOOKPASSWORD$0);
        }
        return sTUnsignedShortHex;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void xsetLockRevision(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKREVISION$8;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void xsetLockStructure(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKSTRUCTURE$4;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void xsetLockWindows(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKWINDOWS$6;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void xsetRevisionsPassword(STUnsignedShortHex sTUnsignedShortHex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REVISIONSPASSWORD$2;
            STUnsignedShortHex sTUnsignedShortHex2 = (STUnsignedShortHex) typeStore.find_attribute_user(qName);
            if (sTUnsignedShortHex2 == null) {
                sTUnsignedShortHex2 = (STUnsignedShortHex) get_store().add_attribute_user(qName);
            }
            sTUnsignedShortHex2.set(sTUnsignedShortHex);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection
    public void xsetWorkbookPassword(STUnsignedShortHex sTUnsignedShortHex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WORKBOOKPASSWORD$0;
            STUnsignedShortHex sTUnsignedShortHex2 = (STUnsignedShortHex) typeStore.find_attribute_user(qName);
            if (sTUnsignedShortHex2 == null) {
                sTUnsignedShortHex2 = (STUnsignedShortHex) get_store().add_attribute_user(qName);
            }
            sTUnsignedShortHex2.set(sTUnsignedShortHex);
        }
    }
}
