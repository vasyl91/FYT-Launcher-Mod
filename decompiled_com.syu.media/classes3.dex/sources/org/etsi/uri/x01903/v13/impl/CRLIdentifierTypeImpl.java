package org.etsi.uri.x01903.v13.impl;

import java.math.BigInteger;
import java.util.Calendar;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CRLIdentifierType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CRLIdentifierTypeImpl extends XmlComplexContentImpl implements CRLIdentifierType {
    private static final QName ISSUER$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "Issuer");
    private static final QName ISSUETIME$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "IssueTime");
    private static final QName NUMBER$4 = new QName("http://uri.etsi.org/01903/v1.3.2#", "Number");
    private static final QName URI$6 = new QName("", "URI");

    public CRLIdentifierTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public Calendar getIssueTime() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(ISSUETIME$2, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getCalendarValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public String getIssuer() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(ISSUER$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public BigInteger getNumber() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(NUMBER$4, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getBigIntegerValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public String getURI() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(URI$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public boolean isSetNumber() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMBER$4) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public boolean isSetURI() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$6) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void setIssueTime(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISSUETIME$2;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setCalendarValue(calendar);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void setIssuer(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISSUER$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void setNumber(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMBER$4;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void setURI(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void unsetNumber() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMBER$4, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void unsetURI() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$6);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public XmlDateTime xgetIssueTime() {
        XmlDateTime xmlDateTimeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTimeFind_element_user = get_store().find_element_user(ISSUETIME$2, 0);
        }
        return xmlDateTimeFind_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public XmlString xgetIssuer() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(ISSUER$0, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public XmlInteger xgetNumber() {
        XmlInteger xmlIntegerFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntegerFind_element_user = get_store().find_element_user(NUMBER$4, 0);
        }
        return xmlIntegerFind_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public XmlAnyURI xgetURI() {
        XmlAnyURI xmlAnyURIFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIFind_attribute_user = get_store().find_attribute_user(URI$6);
        }
        return xmlAnyURIFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void xsetIssueTime(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISSUETIME$2;
            XmlDateTime xmlDateTimeFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlDateTimeFind_element_user == null) {
                xmlDateTimeFind_element_user = (XmlDateTime) get_store().add_element_user(qName);
            }
            xmlDateTimeFind_element_user.set(xmlDateTime);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void xsetIssuer(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISSUER$0;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void xsetNumber(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMBER$4;
            XmlInteger xmlIntegerFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlIntegerFind_element_user == null) {
                xmlIntegerFind_element_user = (XmlInteger) get_store().add_element_user(qName);
            }
            xmlIntegerFind_element_user.set(xmlInteger);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLIdentifierType
    public void xsetURI(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$6;
            XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlAnyURIFind_attribute_user == null) {
                xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURIFind_attribute_user.set(xmlAnyURI);
        }
    }
}
