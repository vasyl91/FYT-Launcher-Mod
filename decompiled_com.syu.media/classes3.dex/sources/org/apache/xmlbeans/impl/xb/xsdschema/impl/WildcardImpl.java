package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class WildcardImpl extends AnnotatedImpl implements Wildcard {
    private static final QName NAMESPACE$0 = new QName("", "namespace");
    private static final QName PROCESSCONTENTS$2 = new QName("", "processContents");
    private static final long serialVersionUID = 1;

    public WildcardImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Wildcard
    public Object getNamespace() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMESPACE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Wildcard
    public NamespaceList xgetNamespace() {
        NamespaceList namespaceList;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMESPACE$0;
            namespaceList = (NamespaceList) typeStore.find_attribute_user(qName);
            if (namespaceList == null) {
                namespaceList = (NamespaceList) get_default_attribute_value(qName);
            }
        }
        return namespaceList;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Wildcard
    public boolean isSetNamespace() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAMESPACE$0) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Wildcard
    public void setNamespace(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMESPACE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Wildcard
    public void xsetNamespace(NamespaceList namespaceList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMESPACE$0;
            NamespaceList namespaceList2 = (NamespaceList) typeStore.find_attribute_user(qName);
            if (namespaceList2 == null) {
                namespaceList2 = (NamespaceList) get_store().add_attribute_user(qName);
            }
            namespaceList2.set(namespaceList);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Wildcard
    public void unsetNamespace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAMESPACE$0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Wildcard
    public Wildcard.ProcessContents.Enum getProcessContents() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROCESSCONTENTS$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (Wildcard.ProcessContents.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Wildcard
    public Wildcard.ProcessContents xgetProcessContents() {
        Wildcard.ProcessContents processContents;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROCESSCONTENTS$2;
            processContents = (Wildcard.ProcessContents) typeStore.find_attribute_user(qName);
            if (processContents == null) {
                processContents = (Wildcard.ProcessContents) get_default_attribute_value(qName);
            }
        }
        return processContents;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Wildcard
    public boolean isSetProcessContents() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROCESSCONTENTS$2) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Wildcard
    public void setProcessContents(Wildcard.ProcessContents.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROCESSCONTENTS$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Wildcard
    public void xsetProcessContents(Wildcard.ProcessContents processContents) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROCESSCONTENTS$2;
            Wildcard.ProcessContents processContents2 = (Wildcard.ProcessContents) typeStore.find_attribute_user(qName);
            if (processContents2 == null) {
                processContents2 = (Wildcard.ProcessContents) get_store().add_attribute_user(qName);
            }
            processContents2.set((XmlObject) processContents);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Wildcard
    public void unsetProcessContents() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROCESSCONTENTS$2);
        }
    }

    public static class ProcessContentsImpl extends JavaStringEnumerationHolderEx implements Wildcard.ProcessContents {
        private static final long serialVersionUID = 1;

        public ProcessContentsImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected ProcessContentsImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }
}
