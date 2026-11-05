package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SimpleContentDocumentImpl extends XmlComplexContentImpl implements SimpleContentDocument {
    private static final QName SIMPLECONTENT$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "simpleContent");
    private static final long serialVersionUID = 1;

    public SimpleContentDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument
    public SimpleContentDocument.SimpleContent getSimpleContent() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleContentDocument.SimpleContent simpleContent = (SimpleContentDocument.SimpleContent) get_store().find_element_user(SIMPLECONTENT$0, 0);
            if (simpleContent == null) {
                return null;
            }
            return simpleContent;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument
    public void setSimpleContent(SimpleContentDocument.SimpleContent simpleContent) {
        generatedSetterHelperImpl(simpleContent, SIMPLECONTENT$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument
    public SimpleContentDocument.SimpleContent addNewSimpleContent() {
        SimpleContentDocument.SimpleContent simpleContent;
        synchronized (monitor()) {
            check_orphaned();
            simpleContent = (SimpleContentDocument.SimpleContent) get_store().add_element_user(SIMPLECONTENT$0);
        }
        return simpleContent;
    }

    public static class SimpleContentImpl extends AnnotatedImpl implements SimpleContentDocument.SimpleContent {
        private static final long serialVersionUID = 1;
        private static final QName RESTRICTION$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "restriction");
        private static final QName EXTENSION$2 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "extension");

        public SimpleContentImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public SimpleRestrictionType getRestriction() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleRestrictionType simpleRestrictionType = (SimpleRestrictionType) get_store().find_element_user(RESTRICTION$0, 0);
                if (simpleRestrictionType == null) {
                    return null;
                }
                return simpleRestrictionType;
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public boolean isSetRestriction() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().count_elements(RESTRICTION$0) != 0;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public void setRestriction(SimpleRestrictionType simpleRestrictionType) {
            generatedSetterHelperImpl(simpleRestrictionType, RESTRICTION$0, 0, (short) 1);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public SimpleRestrictionType addNewRestriction() {
            SimpleRestrictionType simpleRestrictionType;
            synchronized (monitor()) {
                check_orphaned();
                simpleRestrictionType = (SimpleRestrictionType) get_store().add_element_user(RESTRICTION$0);
            }
            return simpleRestrictionType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public void unsetRestriction() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(RESTRICTION$0, 0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public SimpleExtensionType getExtension() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleExtensionType simpleExtensionType = (SimpleExtensionType) get_store().find_element_user(EXTENSION$2, 0);
                if (simpleExtensionType == null) {
                    return null;
                }
                return simpleExtensionType;
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public boolean isSetExtension() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().count_elements(EXTENSION$2) != 0;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public void setExtension(SimpleExtensionType simpleExtensionType) {
            generatedSetterHelperImpl(simpleExtensionType, EXTENSION$2, 0, (short) 1);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public SimpleExtensionType addNewExtension() {
            SimpleExtensionType simpleExtensionType;
            synchronized (monitor()) {
                check_orphaned();
                simpleExtensionType = (SimpleExtensionType) get_store().add_element_user(EXTENSION$2);
            }
            return simpleExtensionType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument.SimpleContent
        public void unsetExtension() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(EXTENSION$2, 0);
            }
        }
    }
}
