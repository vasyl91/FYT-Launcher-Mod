package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class DocumentationDocumentImpl extends XmlComplexContentImpl implements DocumentationDocument {
    private static final QName DOCUMENTATION$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "documentation");
    private static final long serialVersionUID = 1;

    public DocumentationDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument
    public DocumentationDocument.Documentation getDocumentation() {
        synchronized (monitor()) {
            check_orphaned();
            DocumentationDocument.Documentation documentation = (DocumentationDocument.Documentation) get_store().find_element_user(DOCUMENTATION$0, 0);
            if (documentation == null) {
                return null;
            }
            return documentation;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument
    public void setDocumentation(DocumentationDocument.Documentation documentation) {
        generatedSetterHelperImpl(documentation, DOCUMENTATION$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument
    public DocumentationDocument.Documentation addNewDocumentation() {
        DocumentationDocument.Documentation documentation;
        synchronized (monitor()) {
            check_orphaned();
            documentation = (DocumentationDocument.Documentation) get_store().add_element_user(DOCUMENTATION$0);
        }
        return documentation;
    }

    public static class DocumentationImpl extends XmlComplexContentImpl implements DocumentationDocument.Documentation {
        private static final long serialVersionUID = 1;
        private static final QName SOURCE$0 = new QName("", "source");
        private static final QName LANG$2 = new QName(XMLValidationSchema.SCHEMA_ID_DTD, "lang");

        public DocumentationImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public String getSource() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SOURCE$0);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public XmlAnyURI xgetSource() {
            XmlAnyURI xmlAnyURIFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURIFind_attribute_user = get_store().find_attribute_user(SOURCE$0);
            }
            return xmlAnyURIFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public boolean isSetSource() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(SOURCE$0) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void setSource(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SOURCE$0;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void xsetSource(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SOURCE$0;
                XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlAnyURIFind_attribute_user == null) {
                    xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURIFind_attribute_user.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void unsetSource() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(SOURCE$0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public String getLang() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LANG$2);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public XmlLanguage xgetLang() {
            XmlLanguage xmlLanguageFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlLanguageFind_attribute_user = get_store().find_attribute_user(LANG$2);
            }
            return xmlLanguageFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public boolean isSetLang() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(LANG$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void setLang(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LANG$2;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void xsetLang(XmlLanguage xmlLanguage) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LANG$2;
                XmlLanguage xmlLanguageFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlLanguageFind_attribute_user == null) {
                    xmlLanguageFind_attribute_user = (XmlLanguage) get_store().add_attribute_user(qName);
                }
                xmlLanguageFind_attribute_user.set(xmlLanguage);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument.Documentation
        public void unsetLang() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(LANG$2);
            }
        }
    }
}
