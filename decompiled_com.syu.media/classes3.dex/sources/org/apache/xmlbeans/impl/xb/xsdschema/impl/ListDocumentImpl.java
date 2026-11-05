package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ListDocumentImpl extends XmlComplexContentImpl implements ListDocument {
    private static final QName LIST$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "list");
    private static final long serialVersionUID = 1;

    public ListDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument
    public ListDocument.List getList() {
        synchronized (monitor()) {
            check_orphaned();
            ListDocument.List list = (ListDocument.List) get_store().find_element_user(LIST$0, 0);
            if (list == null) {
                return null;
            }
            return list;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument
    public void setList(ListDocument.List list) {
        generatedSetterHelperImpl(list, LIST$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument
    public ListDocument.List addNewList() {
        ListDocument.List list;
        synchronized (monitor()) {
            check_orphaned();
            list = (ListDocument.List) get_store().add_element_user(LIST$0);
        }
        return list;
    }

    public static class ListImpl extends AnnotatedImpl implements ListDocument.List {
        private static final long serialVersionUID = 1;
        private static final QName SIMPLETYPE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "simpleType");
        private static final QName ITEMTYPE$2 = new QName("", "itemType");

        public ListImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public LocalSimpleType getSimpleType() {
            synchronized (monitor()) {
                check_orphaned();
                LocalSimpleType localSimpleType = (LocalSimpleType) get_store().find_element_user(SIMPLETYPE$0, 0);
                if (localSimpleType == null) {
                    return null;
                }
                return localSimpleType;
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public boolean isSetSimpleType() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().count_elements(SIMPLETYPE$0) != 0;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public void setSimpleType(LocalSimpleType localSimpleType) {
            generatedSetterHelperImpl(localSimpleType, SIMPLETYPE$0, 0, (short) 1);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public LocalSimpleType addNewSimpleType() {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().add_element_user(SIMPLETYPE$0);
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public void unsetSimpleType() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(SIMPLETYPE$0, 0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public QName getItemType() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ITEMTYPE$2);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getQNameValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public XmlQName xgetItemType() {
            XmlQName xmlQNameFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlQNameFind_attribute_user = get_store().find_attribute_user(ITEMTYPE$2);
            }
            return xmlQNameFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public boolean isSetItemType() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(ITEMTYPE$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public void setItemType(QName qName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName2 = ITEMTYPE$2;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName2);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName2);
                }
                simpleValueFind_attribute_user.setQNameValue(qName);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public void xsetItemType(XmlQName xmlQName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ITEMTYPE$2;
                XmlQName xmlQNameFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlQNameFind_attribute_user == null) {
                    xmlQNameFind_attribute_user = (XmlQName) get_store().add_attribute_user(qName);
                }
                xmlQNameFind_attribute_user.set(xmlQName);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List
        public void unsetItemType() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(ITEMTYPE$2);
            }
        }
    }
}
