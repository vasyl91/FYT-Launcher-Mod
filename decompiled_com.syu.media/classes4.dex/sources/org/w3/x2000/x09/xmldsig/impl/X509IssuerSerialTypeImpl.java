package org.w3.x2000.x09.xmldsig.impl;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.X509IssuerSerialType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class X509IssuerSerialTypeImpl extends XmlComplexContentImpl implements X509IssuerSerialType {
    private static final QName X509ISSUERNAME$0 = new QName("http://www.w3.org/2000/09/xmldsig#", "X509IssuerName");
    private static final QName X509SERIALNUMBER$2 = new QName("http://www.w3.org/2000/09/xmldsig#", "X509SerialNumber");

    public X509IssuerSerialTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public String getX509IssuerName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(X509ISSUERNAME$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public BigInteger getX509SerialNumber() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(X509SERIALNUMBER$2, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getBigIntegerValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public void setX509IssuerName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X509ISSUERNAME$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public void setX509SerialNumber(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X509SERIALNUMBER$2;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public XmlString xgetX509IssuerName() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(X509ISSUERNAME$0, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public XmlInteger xgetX509SerialNumber() {
        XmlInteger xmlIntegerFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_element_user = get_store().find_element_user(X509SERIALNUMBER$2, 0);
        }
        return xmlIntegerFind_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public void xsetX509IssuerName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X509ISSUERNAME$0;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.X509IssuerSerialType
    public void xsetX509SerialNumber(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X509SERIALNUMBER$2;
            XmlInteger xmlIntegerFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntegerFind_element_user == null) {
                xmlIntegerFind_element_user = (XmlInteger) get_store().add_element_user(qName);
            }
            xmlIntegerFind_element_user.set(xmlInteger);
        }
    }
}
