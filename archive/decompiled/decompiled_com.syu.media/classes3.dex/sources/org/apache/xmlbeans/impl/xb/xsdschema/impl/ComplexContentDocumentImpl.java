package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexRestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ComplexContentDocumentImpl extends XmlComplexContentImpl implements ComplexContentDocument {
    private static final QName COMPLEXCONTENT$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "complexContent");
    private static final long serialVersionUID = 1;

    public ComplexContentDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument
    public ComplexContentDocument.ComplexContent getComplexContent() {
        synchronized (monitor()) {
            check_orphaned();
            ComplexContentDocument.ComplexContent complexContent = (ComplexContentDocument.ComplexContent) get_store().find_element_user(COMPLEXCONTENT$0, 0);
            if (complexContent == null) {
                return null;
            }
            return complexContent;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument
    public void setComplexContent(ComplexContentDocument.ComplexContent complexContent) {
        generatedSetterHelperImpl(complexContent, COMPLEXCONTENT$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument
    public ComplexContentDocument.ComplexContent addNewComplexContent() {
        ComplexContentDocument.ComplexContent complexContent;
        synchronized (monitor()) {
            check_orphaned();
            complexContent = (ComplexContentDocument.ComplexContent) get_store().add_element_user(COMPLEXCONTENT$0);
        }
        return complexContent;
    }

    public static class ComplexContentImpl extends AnnotatedImpl implements ComplexContentDocument.ComplexContent {
        private static final long serialVersionUID = 1;
        private static final QName RESTRICTION$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "restriction");
        private static final QName EXTENSION$2 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "extension");
        private static final QName MIXED$4 = new QName("", "mixed");

        public ComplexContentImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public ComplexRestrictionType getRestriction() {
            synchronized (monitor()) {
                check_orphaned();
                ComplexRestrictionType complexRestrictionType = (ComplexRestrictionType) get_store().find_element_user(RESTRICTION$0, 0);
                if (complexRestrictionType == null) {
                    return null;
                }
                return complexRestrictionType;
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public boolean isSetRestriction() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().count_elements(RESTRICTION$0) != 0;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void setRestriction(ComplexRestrictionType complexRestrictionType) {
            generatedSetterHelperImpl(complexRestrictionType, RESTRICTION$0, 0, (short) 1);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public ComplexRestrictionType addNewRestriction() {
            ComplexRestrictionType complexRestrictionType;
            synchronized (monitor()) {
                check_orphaned();
                complexRestrictionType = (ComplexRestrictionType) get_store().add_element_user(RESTRICTION$0);
            }
            return complexRestrictionType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void unsetRestriction() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(RESTRICTION$0, 0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public ExtensionType getExtension() {
            synchronized (monitor()) {
                check_orphaned();
                ExtensionType extensionType = (ExtensionType) get_store().find_element_user(EXTENSION$2, 0);
                if (extensionType == null) {
                    return null;
                }
                return extensionType;
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public boolean isSetExtension() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().count_elements(EXTENSION$2) != 0;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void setExtension(ExtensionType extensionType) {
            generatedSetterHelperImpl(extensionType, EXTENSION$2, 0, (short) 1);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public ExtensionType addNewExtension() {
            ExtensionType extensionType;
            synchronized (monitor()) {
                check_orphaned();
                extensionType = (ExtensionType) get_store().add_element_user(EXTENSION$2);
            }
            return extensionType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void unsetExtension() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(EXTENSION$2, 0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public boolean getMixed() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MIXED$4);
                if (simpleValueFind_attribute_user == null) {
                    return false;
                }
                return simpleValueFind_attribute_user.getBooleanValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public XmlBoolean xgetMixed() {
            XmlBoolean xmlBooleanFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlBooleanFind_attribute_user = get_store().find_attribute_user(MIXED$4);
            }
            return xmlBooleanFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public boolean isSetMixed() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(MIXED$4) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void setMixed(boolean z) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MIXED$4;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setBooleanValue(z);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void xsetMixed(XmlBoolean xmlBoolean) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MIXED$4;
                XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlBooleanFind_attribute_user == null) {
                    xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
                }
                xmlBooleanFind_attribute_user.set(xmlBoolean);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument.ComplexContent
        public void unsetMixed() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(MIXED$4);
            }
        }
    }
}
