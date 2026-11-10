package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class UsertypeconfigImpl extends XmlComplexContentImpl implements Usertypeconfig {
    private static final long serialVersionUID = 1;
    private static final QName STATICHANDLER$0 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "staticHandler");
    private static final QName NAME$2 = new QName("", "name");
    private static final QName JAVANAME$4 = new QName("", "javaname");

    public UsertypeconfigImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public String getStaticHandler() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(STATICHANDLER$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public XmlString xgetStaticHandler() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(STATICHANDLER$0, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public void setStaticHandler(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STATICHANDLER$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public void xsetStaticHandler(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STATICHANDLER$0;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public QName getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public XmlQName xgetName() {
        XmlQName xmlQNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlQNameFind_attribute_user = get_store().find_attribute_user(NAME$2);
        }
        return xmlQNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$2) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public void setName(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = NAME$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName2);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValueFind_attribute_user.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public void xsetName(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$2;
            XmlQName xmlQNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlQNameFind_attribute_user == null) {
                xmlQNameFind_attribute_user = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQNameFind_attribute_user.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public String getJavaname() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(JAVANAME$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public XmlString xgetJavaname() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(JAVANAME$4);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public boolean isSetJavaname() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(JAVANAME$4) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public void setJavaname(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JAVANAME$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public void xsetJavaname(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JAVANAME$4;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig
    public void unsetJavaname() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(JAVANAME$4);
        }
    }
}
