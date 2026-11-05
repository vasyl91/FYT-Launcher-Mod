package org.apache.xmlbeans.impl.xb.ltgfmt.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.Code;
import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class FileDescImpl extends XmlComplexContentImpl implements FileDesc {
    private static final long serialVersionUID = 1;
    private static final QName CODE$0 = new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "code");
    private static final QName TSDIR$2 = new QName("", "tsDir");
    private static final QName FOLDER$4 = new QName("", "folder");
    private static final QName FILENAME$6 = new QName("", "fileName");
    private static final QName ROLE$8 = new QName("", "role");
    private static final QName VALIDITY$10 = new QName("", "validity");

    public FileDescImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public Code getCode() {
        synchronized (monitor()) {
            check_orphaned();
            Code code = (Code) get_store().find_element_user(CODE$0, 0);
            if (code == null) {
                return null;
            }
            return code;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetCode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CODE$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setCode(Code code) {
        generatedSetterHelperImpl(code, CODE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public Code addNewCode() {
        Code code;
        synchronized (monitor()) {
            check_orphaned();
            code = (Code) get_store().add_element_user(CODE$0);
        }
        return code;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetCode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CODE$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public String getTsDir() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TSDIR$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public XmlToken xgetTsDir() {
        XmlToken xmlTokenFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlTokenFind_attribute_user = get_store().find_attribute_user(TSDIR$2);
        }
        return xmlTokenFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetTsDir() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TSDIR$2) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setTsDir(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TSDIR$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetTsDir(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TSDIR$2;
            XmlToken xmlTokenFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlTokenFind_attribute_user == null) {
                xmlTokenFind_attribute_user = (XmlToken) get_store().add_attribute_user(qName);
            }
            xmlTokenFind_attribute_user.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetTsDir() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TSDIR$2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public String getFolder() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FOLDER$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public XmlToken xgetFolder() {
        XmlToken xmlTokenFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlTokenFind_attribute_user = get_store().find_attribute_user(FOLDER$4);
        }
        return xmlTokenFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetFolder() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FOLDER$4) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setFolder(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOLDER$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetFolder(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOLDER$4;
            XmlToken xmlTokenFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlTokenFind_attribute_user == null) {
                xmlTokenFind_attribute_user = (XmlToken) get_store().add_attribute_user(qName);
            }
            xmlTokenFind_attribute_user.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetFolder() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FOLDER$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public String getFileName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FILENAME$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public XmlToken xgetFileName() {
        XmlToken xmlTokenFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlTokenFind_attribute_user = get_store().find_attribute_user(FILENAME$6);
        }
        return xmlTokenFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetFileName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILENAME$6) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setFileName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILENAME$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetFileName(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILENAME$6;
            XmlToken xmlTokenFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlTokenFind_attribute_user == null) {
                xmlTokenFind_attribute_user = (XmlToken) get_store().add_attribute_user(qName);
            }
            xmlTokenFind_attribute_user.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetFileName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILENAME$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public FileDesc.Role.Enum getRole() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ROLE$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (FileDesc.Role.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public FileDesc.Role xgetRole() {
        FileDesc.Role role;
        synchronized (monitor()) {
            check_orphaned();
            role = (FileDesc.Role) get_store().find_attribute_user(ROLE$8);
        }
        return role;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetRole() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ROLE$8) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setRole(FileDesc.Role.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROLE$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetRole(FileDesc.Role role) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROLE$8;
            FileDesc.Role role2 = (FileDesc.Role) typeStore.find_attribute_user(qName);
            if (role2 == null) {
                role2 = (FileDesc.Role) get_store().add_attribute_user(qName);
            }
            role2.set((XmlObject) role);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetRole() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ROLE$8);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean getValidity() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VALIDITY$10);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public XmlBoolean xgetValidity() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(VALIDITY$10);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public boolean isSetValidity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VALIDITY$10) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void setValidity(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VALIDITY$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void xsetValidity(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VALIDITY$10;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc
    public void unsetValidity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VALIDITY$10);
        }
    }

    public static class RoleImpl extends JavaStringEnumerationHolderEx implements FileDesc.Role {
        private static final long serialVersionUID = 1;

        public RoleImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected RoleImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }
}
