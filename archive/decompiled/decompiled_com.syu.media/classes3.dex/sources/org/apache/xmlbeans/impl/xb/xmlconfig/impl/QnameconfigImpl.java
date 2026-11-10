package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnametargetlist;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class QnameconfigImpl extends XmlComplexContentImpl implements Qnameconfig {
    private static final long serialVersionUID = 1;
    private static final QName NAME$0 = new QName("", "name");
    private static final QName JAVANAME$2 = new QName("", "javaname");
    private static final QName TARGET$4 = new QName("", "target");

    public QnameconfigImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public QName getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public XmlQName xgetName() {
        XmlQName xmlQNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlQNameFind_attribute_user = get_store().find_attribute_user(NAME$0);
        }
        return xmlQNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$0) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void setName(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = NAME$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName2);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValueFind_attribute_user.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void xsetName(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$0;
            XmlQName xmlQNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlQNameFind_attribute_user == null) {
                xmlQNameFind_attribute_user = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQNameFind_attribute_user.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public String getJavaname() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(JAVANAME$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public XmlString xgetJavaname() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(JAVANAME$2);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public boolean isSetJavaname() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(JAVANAME$2) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void setJavaname(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JAVANAME$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void xsetJavaname(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JAVANAME$2;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void unsetJavaname() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(JAVANAME$2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public List getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getListValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public Qnametargetlist xgetTarget() {
        Qnametargetlist qnametargetlist;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$4;
            qnametargetlist = (Qnametargetlist) typeStore.find_attribute_user(qName);
            if (qnametargetlist == null) {
                qnametargetlist = (Qnametargetlist) get_default_attribute_value(qName);
            }
        }
        return qnametargetlist;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public boolean isSetTarget() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TARGET$4) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void setTarget(List list) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setListValue(list);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void xsetTarget(Qnametargetlist qnametargetlist) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$4;
            Qnametargetlist qnametargetlist2 = (Qnametargetlist) typeStore.find_attribute_user(qName);
            if (qnametargetlist2 == null) {
                qnametargetlist2 = (Qnametargetlist) get_store().add_attribute_user(qName);
            }
            qnametargetlist2.set((XmlObject) qnametargetlist);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig
    public void unsetTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TARGET$4);
        }
    }
}
