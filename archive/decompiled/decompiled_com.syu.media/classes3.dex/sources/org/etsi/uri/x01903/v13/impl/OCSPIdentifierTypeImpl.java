package org.etsi.uri.x01903.v13.impl;

import java.util.Calendar;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.OCSPIdentifierType;
import org.etsi.uri.x01903.v13.ResponderIDType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class OCSPIdentifierTypeImpl extends XmlComplexContentImpl implements OCSPIdentifierType {
    private static final QName RESPONDERID$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "ResponderID");
    private static final QName PRODUCEDAT$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "ProducedAt");
    private static final QName URI$4 = new QName("", "URI");

    public OCSPIdentifierTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public ResponderIDType addNewResponderID() {
        ResponderIDType responderIDType;
        synchronized (monitor()) {
            check_orphaned();
            responderIDType = (ResponderIDType) get_store().add_element_user(RESPONDERID$0);
        }
        return responderIDType;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public Calendar getProducedAt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(PRODUCEDAT$2, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getCalendarValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public ResponderIDType getResponderID() {
        synchronized (monitor()) {
            check_orphaned();
            ResponderIDType responderIDType = (ResponderIDType) get_store().find_element_user(RESPONDERID$0, 0);
            if (responderIDType == null) {
                return null;
            }
            return responderIDType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public String getURI() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(URI$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public boolean isSetURI() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$4) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public void setProducedAt(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRODUCEDAT$2;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setCalendarValue(calendar);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public void setResponderID(ResponderIDType responderIDType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RESPONDERID$0;
            ResponderIDType responderIDType2 = (ResponderIDType) typeStore.find_element_user(qName, 0);
            if (responderIDType2 == null) {
                responderIDType2 = (ResponderIDType) get_store().add_element_user(qName);
            }
            responderIDType2.set(responderIDType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public void setURI(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public void unsetURI() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$4);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public XmlDateTime xgetProducedAt() {
        XmlDateTime xmlDateTimeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTimeFind_element_user = get_store().find_element_user(PRODUCEDAT$2, 0);
        }
        return xmlDateTimeFind_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public XmlAnyURI xgetURI() {
        XmlAnyURI xmlAnyURIFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIFind_attribute_user = get_store().find_attribute_user(URI$4);
        }
        return xmlAnyURIFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public void xsetProducedAt(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRODUCEDAT$2;
            XmlDateTime xmlDateTimeFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlDateTimeFind_element_user == null) {
                xmlDateTimeFind_element_user = (XmlDateTime) get_store().add_element_user(qName);
            }
            xmlDateTimeFind_element_user.set(xmlDateTime);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPIdentifierType
    public void xsetURI(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$4;
            XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlAnyURIFind_attribute_user == null) {
                xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURIFind_attribute_user.set(xmlAnyURI);
        }
    }
}
