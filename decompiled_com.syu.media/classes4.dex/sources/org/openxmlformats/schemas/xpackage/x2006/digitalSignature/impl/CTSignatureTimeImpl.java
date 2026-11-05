package org.openxmlformats.schemas.xpackage.x2006.digitalSignature.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.STFormat;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.STValue;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTSignatureTimeImpl extends XmlComplexContentImpl implements CTSignatureTime {
    private static final QName FORMAT$0 = new QName("http://schemas.openxmlformats.org/package/2006/digital-signature", "Format");
    private static final QName VALUE$2 = new QName("http://schemas.openxmlformats.org/package/2006/digital-signature", "Value");

    public CTSignatureTimeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public String getFormat() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(FORMAT$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public String getValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(VALUE$2, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public void setFormat(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMAT$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public void setValue(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VALUE$2;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public STFormat xgetFormat() {
        STFormat sTFormatFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTFormatFind_element_user = get_store().find_element_user(FORMAT$0, 0);
        }
        return sTFormatFind_element_user;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public STValue xgetValue() {
        STValue sTValueFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTValueFind_element_user = get_store().find_element_user(VALUE$2, 0);
        }
        return sTValueFind_element_user;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public void xsetFormat(STFormat sTFormat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMAT$0;
            STFormat sTFormatFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTFormatFind_element_user == null) {
                sTFormatFind_element_user = (STFormat) get_store().add_element_user(qName);
            }
            sTFormatFind_element_user.set(sTFormat);
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime
    public void xsetValue(STValue sTValue) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VALUE$2;
            STValue sTValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (sTValueFind_element_user == null) {
                sTValueFind_element_user = (STValue) get_store().add_element_user(qName);
            }
            sTValueFind_element_user.set(sTValue);
        }
    }
}
