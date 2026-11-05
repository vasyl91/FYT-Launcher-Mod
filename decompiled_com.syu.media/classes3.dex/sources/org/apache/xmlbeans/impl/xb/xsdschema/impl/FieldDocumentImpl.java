package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class FieldDocumentImpl extends XmlComplexContentImpl implements FieldDocument {
    private static final QName FIELD$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, JamXmlElements.FIELD);
    private static final long serialVersionUID = 1;

    public FieldDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument
    public FieldDocument.Field getField() {
        synchronized (monitor()) {
            check_orphaned();
            FieldDocument.Field field = (FieldDocument.Field) get_store().find_element_user(FIELD$0, 0);
            if (field == null) {
                return null;
            }
            return field;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument
    public void setField(FieldDocument.Field field) {
        generatedSetterHelperImpl(field, FIELD$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument
    public FieldDocument.Field addNewField() {
        FieldDocument.Field field;
        synchronized (monitor()) {
            check_orphaned();
            field = (FieldDocument.Field) get_store().add_element_user(FIELD$0);
        }
        return field;
    }

    public static class FieldImpl extends AnnotatedImpl implements FieldDocument.Field {
        private static final QName XPATH$0 = new QName("", "xpath");
        private static final long serialVersionUID = 1;

        public FieldImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field
        public String getXpath() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(XPATH$0);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field
        public FieldDocument.Field.Xpath xgetXpath() {
            FieldDocument.Field.Xpath xpath;
            synchronized (monitor()) {
                check_orphaned();
                xpath = (FieldDocument.Field.Xpath) get_store().find_attribute_user(XPATH$0);
            }
            return xpath;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field
        public void setXpath(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = XPATH$0;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field
        public void xsetXpath(FieldDocument.Field.Xpath xpath) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = XPATH$0;
                FieldDocument.Field.Xpath xpath2 = (FieldDocument.Field.Xpath) typeStore.find_attribute_user(qName);
                if (xpath2 == null) {
                    xpath2 = (FieldDocument.Field.Xpath) get_store().add_attribute_user(qName);
                }
                xpath2.set(xpath);
            }
        }

        public static class XpathImpl extends JavaStringHolderEx implements FieldDocument.Field.Xpath {
            private static final long serialVersionUID = 1;

            public XpathImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected XpathImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }
        }
    }
}
