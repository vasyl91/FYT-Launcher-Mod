package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class IncludeDocumentImpl extends XmlComplexContentImpl implements IncludeDocument {
    private static final QName INCLUDE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "include");
    private static final long serialVersionUID = 1;

    public IncludeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument
    public IncludeDocument.Include getInclude() {
        synchronized (monitor()) {
            check_orphaned();
            IncludeDocument.Include include = (IncludeDocument.Include) get_store().find_element_user(INCLUDE$0, 0);
            if (include == null) {
                return null;
            }
            return include;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument
    public void setInclude(IncludeDocument.Include include) {
        generatedSetterHelperImpl(include, INCLUDE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument
    public IncludeDocument.Include addNewInclude() {
        IncludeDocument.Include include;
        synchronized (monitor()) {
            check_orphaned();
            include = (IncludeDocument.Include) get_store().add_element_user(INCLUDE$0);
        }
        return include;
    }

    public static class IncludeImpl extends AnnotatedImpl implements IncludeDocument.Include {
        private static final QName SCHEMALOCATION$0 = new QName("", "schemaLocation");
        private static final long serialVersionUID = 1;

        public IncludeImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument.Include
        public String getSchemaLocation() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SCHEMALOCATION$0);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument.Include
        public XmlAnyURI xgetSchemaLocation() {
            XmlAnyURI xmlAnyURIFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURIFind_attribute_user = get_store().find_attribute_user(SCHEMALOCATION$0);
            }
            return xmlAnyURIFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument.Include
        public void setSchemaLocation(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SCHEMALOCATION$0;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument.Include
        public void xsetSchemaLocation(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SCHEMALOCATION$0;
                XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlAnyURIFind_attribute_user == null) {
                    xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURIFind_attribute_user.set(xmlAnyURI);
            }
        }
    }
}
