package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class NotationDocumentImpl extends XmlComplexContentImpl implements NotationDocument {
    private static final QName NOTATION$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "notation");
    private static final long serialVersionUID = 1;

    public NotationDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument
    public NotationDocument.Notation getNotation() {
        synchronized (monitor()) {
            check_orphaned();
            NotationDocument.Notation notation = (NotationDocument.Notation) get_store().find_element_user(NOTATION$0, 0);
            if (notation == null) {
                return null;
            }
            return notation;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument
    public void setNotation(NotationDocument.Notation notation) {
        generatedSetterHelperImpl(notation, NOTATION$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument
    public NotationDocument.Notation addNewNotation() {
        NotationDocument.Notation notation;
        synchronized (monitor()) {
            check_orphaned();
            notation = (NotationDocument.Notation) get_store().add_element_user(NOTATION$0);
        }
        return notation;
    }

    public static class NotationImpl extends AnnotatedImpl implements NotationDocument.Notation {
        private static final QName NAME$0 = new QName("", "name");
        private static final QName PUBLIC$2 = new QName("", "public");
        private static final QName SYSTEM$4 = new QName("", "system");
        private static final long serialVersionUID = 1;

        public NotationImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public String getName() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$0);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public XmlNCName xgetName() {
            XmlNCName xmlNCNameFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlNCNameFind_attribute_user = get_store().find_attribute_user(NAME$0);
            }
            return xmlNCNameFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void setName(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$0;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void xsetName(XmlNCName xmlNCName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$0;
                XmlNCName xmlNCNameFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlNCNameFind_attribute_user == null) {
                    xmlNCNameFind_attribute_user = (XmlNCName) get_store().add_attribute_user(qName);
                }
                xmlNCNameFind_attribute_user.set(xmlNCName);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public String getPublic() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PUBLIC$2);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public Public xgetPublic() {
            Public r1;
            synchronized (monitor()) {
                check_orphaned();
                r1 = (Public) get_store().find_attribute_user(PUBLIC$2);
            }
            return r1;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public boolean isSetPublic() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(PUBLIC$2) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void setPublic(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PUBLIC$2;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void xsetPublic(Public r4) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PUBLIC$2;
                Public r1 = (Public) typeStore.find_attribute_user(qName);
                if (r1 == null) {
                    r1 = (Public) get_store().add_attribute_user(qName);
                }
                r1.set(r4);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void unsetPublic() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PUBLIC$2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public String getSystem() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SYSTEM$4);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public XmlAnyURI xgetSystem() {
            XmlAnyURI xmlAnyURIFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURIFind_attribute_user = get_store().find_attribute_user(SYSTEM$4);
            }
            return xmlAnyURIFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public boolean isSetSystem() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(SYSTEM$4) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void setSystem(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SYSTEM$4;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void xsetSystem(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SYSTEM$4;
                XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlAnyURIFind_attribute_user == null) {
                    xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURIFind_attribute_user.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument.Notation
        public void unsetSystem() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(SYSTEM$4);
            }
        }
    }
}
