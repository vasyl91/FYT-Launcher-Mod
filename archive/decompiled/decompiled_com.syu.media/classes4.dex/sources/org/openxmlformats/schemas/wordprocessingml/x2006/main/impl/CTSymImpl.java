package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShortHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTSymImpl extends XmlComplexContentImpl implements CTSym {
    private static final QName FONT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "font");
    private static final QName CHAR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "char");

    public CTSymImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public byte[] getChar() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CHAR$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public String getFont() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FONT$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public boolean isSetChar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CHAR$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public boolean isSetFont() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FONT$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public void setChar(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHAR$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public void setFont(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONT$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public void unsetChar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CHAR$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public void unsetFont() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FONT$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public STShortHexNumber xgetChar() {
        STShortHexNumber sTShortHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTShortHexNumberFind_attribute_user = get_store().find_attribute_user(CHAR$2);
        }
        return sTShortHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public STString xgetFont() {
        STString sTStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTStringFind_attribute_user = get_store().find_attribute_user(FONT$0);
        }
        return sTStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public void xsetChar(STShortHexNumber sTShortHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHAR$2;
            STShortHexNumber sTShortHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTShortHexNumberFind_attribute_user == null) {
                sTShortHexNumberFind_attribute_user = (STShortHexNumber) get_store().add_attribute_user(qName);
            }
            sTShortHexNumberFind_attribute_user.set(sTShortHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym
    public void xsetFont(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONT$0;
            STString sTStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTStringFind_attribute_user == null) {
                sTStringFind_attribute_user = (STString) get_store().add_attribute_user(qName);
            }
            sTStringFind_attribute_user.set(sTString);
        }
    }
}
