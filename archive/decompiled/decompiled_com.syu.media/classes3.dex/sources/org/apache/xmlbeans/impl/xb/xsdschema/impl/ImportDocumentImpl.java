package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ImportDocumentImpl extends XmlComplexContentImpl implements ImportDocument {
    private static final QName IMPORT$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "import");
    private static final long serialVersionUID = 1;

    public ImportDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument
    public ImportDocument.Import getImport() {
        synchronized (monitor()) {
            check_orphaned();
            ImportDocument.Import r1 = (ImportDocument.Import) get_store().find_element_user(IMPORT$0, 0);
            if (r1 == null) {
                return null;
            }
            return r1;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument
    public void setImport(ImportDocument.Import r4) {
        generatedSetterHelperImpl(r4, IMPORT$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument
    public ImportDocument.Import addNewImport() {
        ImportDocument.Import r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = (ImportDocument.Import) get_store().add_element_user(IMPORT$0);
        }
        return r1;
    }

    public static class ImportImpl extends AnnotatedImpl implements ImportDocument.Import {
        private static final QName NAMESPACE$0 = new QName("", "namespace");
        private static final QName SCHEMALOCATION$2 = new QName("", "schemaLocation");
        private static final long serialVersionUID = 1;

        public ImportImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public String getNamespace() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAMESPACE$0);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public XmlAnyURI xgetNamespace() {
            XmlAnyURI xmlAnyURIFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURIFind_attribute_user = get_store().find_attribute_user(NAMESPACE$0);
            }
            return xmlAnyURIFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public boolean isSetNamespace() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(NAMESPACE$0) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public void setNamespace(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAMESPACE$0;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public void xsetNamespace(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAMESPACE$0;
                XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlAnyURIFind_attribute_user == null) {
                    xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURIFind_attribute_user.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public void unsetNamespace() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(NAMESPACE$0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public String getSchemaLocation() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SCHEMALOCATION$2);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public XmlAnyURI xgetSchemaLocation() {
            XmlAnyURI xmlAnyURIFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURIFind_attribute_user = get_store().find_attribute_user(SCHEMALOCATION$2);
            }
            return xmlAnyURIFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public boolean isSetSchemaLocation() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(SCHEMALOCATION$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public void setSchemaLocation(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SCHEMALOCATION$2;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public void xsetSchemaLocation(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SCHEMALOCATION$2;
                XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlAnyURIFind_attribute_user == null) {
                    xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURIFind_attribute_user.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import
        public void unsetSchemaLocation() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(SCHEMALOCATION$2);
            }
        }
    }
}
