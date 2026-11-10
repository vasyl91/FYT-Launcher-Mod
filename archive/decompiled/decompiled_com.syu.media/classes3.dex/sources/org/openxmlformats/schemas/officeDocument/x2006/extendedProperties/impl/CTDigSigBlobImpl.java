package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTDigSigBlobImpl extends XmlComplexContentImpl implements CTDigSigBlob {
    private static final QName BLOB$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "blob");

    public CTDigSigBlobImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob
    public byte[] getBlob() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(BLOB$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob
    public void setBlob(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOB$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob
    public XmlBase64Binary xgetBlob() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(BLOB$0, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTDigSigBlob
    public void xsetBlob(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOB$0;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }
}
