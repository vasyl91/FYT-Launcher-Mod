package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class AnyDocumentImpl extends XmlComplexContentImpl implements AnyDocument {
    private static final QName ANY$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "any");
    private static final long serialVersionUID = 1;

    public AnyDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument
    public AnyDocument.Any getAny() {
        synchronized (monitor()) {
            check_orphaned();
            AnyDocument.Any any = (AnyDocument.Any) get_store().find_element_user(ANY$0, 0);
            if (any == null) {
                return null;
            }
            return any;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument
    public void setAny(AnyDocument.Any any) {
        generatedSetterHelperImpl(any, ANY$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument
    public AnyDocument.Any addNewAny() {
        AnyDocument.Any any;
        synchronized (monitor()) {
            check_orphaned();
            any = (AnyDocument.Any) get_store().add_element_user(ANY$0);
        }
        return any;
    }

    public static class AnyImpl extends WildcardImpl implements AnyDocument.Any {
        private static final long serialVersionUID = 1;
        private static final QName MINOCCURS$0 = new QName("", "minOccurs");
        private static final QName MAXOCCURS$2 = new QName("", "maxOccurs");

        public AnyImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public BigInteger getMinOccurs() {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MINOCCURS$0;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getBigIntegerValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public XmlNonNegativeInteger xgetMinOccurs() {
            XmlNonNegativeInteger xmlNonNegativeIntegerFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MINOCCURS$0;
                xmlNonNegativeIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlNonNegativeIntegerFind_attribute_user == null) {
                    xmlNonNegativeIntegerFind_attribute_user = (XmlNonNegativeInteger) get_default_attribute_value(qName);
                }
            }
            return xmlNonNegativeIntegerFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public boolean isSetMinOccurs() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(MINOCCURS$0) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public void setMinOccurs(BigInteger bigInteger) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MINOCCURS$0;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MINOCCURS$0;
                XmlNonNegativeInteger xmlNonNegativeIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlNonNegativeIntegerFind_attribute_user == null) {
                    xmlNonNegativeIntegerFind_attribute_user = (XmlNonNegativeInteger) get_store().add_attribute_user(qName);
                }
                xmlNonNegativeIntegerFind_attribute_user.set(xmlNonNegativeInteger);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public void unsetMinOccurs() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(MINOCCURS$0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public Object getMaxOccurs() {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MAXOCCURS$2;
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

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public AllNNI xgetMaxOccurs() {
            AllNNI allNNI;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MAXOCCURS$2;
                allNNI = (AllNNI) typeStore.find_attribute_user(qName);
                if (allNNI == null) {
                    allNNI = (AllNNI) get_default_attribute_value(qName);
                }
            }
            return allNNI;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public boolean isSetMaxOccurs() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(MAXOCCURS$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public void setMaxOccurs(Object obj) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MAXOCCURS$2;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setObjectValue(obj);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public void xsetMaxOccurs(AllNNI allNNI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MAXOCCURS$2;
                AllNNI allNNI2 = (AllNNI) typeStore.find_attribute_user(qName);
                if (allNNI2 == null) {
                    allNNI2 = (AllNNI) get_store().add_attribute_user(qName);
                }
                allNNI2.set(allNNI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument.Any
        public void unsetMaxOccurs() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(MAXOCCURS$2);
            }
        }
    }
}
