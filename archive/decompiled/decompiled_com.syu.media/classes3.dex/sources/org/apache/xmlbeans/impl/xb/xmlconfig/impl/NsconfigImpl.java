package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList;
import org.apache.xmlbeans.impl.xb.xmlconfig.NamespacePrefixList;
import org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class NsconfigImpl extends XmlComplexContentImpl implements Nsconfig {
    private static final QName PACKAGE$0 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "package");
    private static final QName PREFIX$2 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "prefix");
    private static final QName SUFFIX$4 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "suffix");
    private static final QName URI$6 = new QName("", "uri");
    private static final QName URIPREFIX$8 = new QName("", "uriprefix");
    private static final long serialVersionUID = 1;

    public NsconfigImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public String getPackage() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(PACKAGE$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public XmlString xgetPackage() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(PACKAGE$0, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public boolean isSetPackage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PACKAGE$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void setPackage(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PACKAGE$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void xsetPackage(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PACKAGE$0;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void unsetPackage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PACKAGE$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public String getPrefix() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(PREFIX$2, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public XmlString xgetPrefix() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(PREFIX$2, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public boolean isSetPrefix() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PREFIX$2) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void setPrefix(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFIX$2;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void xsetPrefix(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFIX$2;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void unsetPrefix() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PREFIX$2, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public String getSuffix() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SUFFIX$4, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public XmlString xgetSuffix() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(SUFFIX$4, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public boolean isSetSuffix() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUFFIX$4) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void setSuffix(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUFFIX$4;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void xsetSuffix(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUFFIX$4;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void unsetSuffix() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUFFIX$4, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public Object getUri() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(URI$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public NamespaceList xgetUri() {
        NamespaceList namespaceList;
        synchronized (monitor()) {
            check_orphaned();
            namespaceList = (NamespaceList) get_store().find_attribute_user(URI$6);
        }
        return namespaceList;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public boolean isSetUri() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$6) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void setUri(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void xsetUri(NamespaceList namespaceList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$6;
            NamespaceList namespaceList2 = (NamespaceList) typeStore.find_attribute_user(qName);
            if (namespaceList2 == null) {
                namespaceList2 = (NamespaceList) get_store().add_attribute_user(qName);
            }
            namespaceList2.set(namespaceList);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void unsetUri() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public List getUriprefix() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(URIPREFIX$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getListValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public NamespacePrefixList xgetUriprefix() {
        NamespacePrefixList namespacePrefixList;
        synchronized (monitor()) {
            check_orphaned();
            namespacePrefixList = (NamespacePrefixList) get_store().find_attribute_user(URIPREFIX$8);
        }
        return namespacePrefixList;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public boolean isSetUriprefix() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URIPREFIX$8) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void setUriprefix(List list) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URIPREFIX$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setListValue(list);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void xsetUriprefix(NamespacePrefixList namespacePrefixList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URIPREFIX$8;
            NamespacePrefixList namespacePrefixList2 = (NamespacePrefixList) typeStore.find_attribute_user(qName);
            if (namespacePrefixList2 == null) {
                namespacePrefixList2 = (NamespacePrefixList) get_store().add_attribute_user(qName);
            }
            namespacePrefixList2.set((XmlObject) namespacePrefixList);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig
    public void unsetUriprefix() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URIPREFIX$8);
        }
    }
}
