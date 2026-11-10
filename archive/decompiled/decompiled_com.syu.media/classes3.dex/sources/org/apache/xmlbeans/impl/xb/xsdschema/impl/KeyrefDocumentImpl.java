package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class KeyrefDocumentImpl extends XmlComplexContentImpl implements KeyrefDocument {
    private static final QName KEYREF$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "keyref");
    private static final long serialVersionUID = 1;

    public KeyrefDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument
    public KeyrefDocument.Keyref getKeyref() {
        synchronized (monitor()) {
            check_orphaned();
            KeyrefDocument.Keyref keyref = (KeyrefDocument.Keyref) get_store().find_element_user(KEYREF$0, 0);
            if (keyref == null) {
                return null;
            }
            return keyref;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument
    public void setKeyref(KeyrefDocument.Keyref keyref) {
        generatedSetterHelperImpl(keyref, KEYREF$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument
    public KeyrefDocument.Keyref addNewKeyref() {
        KeyrefDocument.Keyref keyref;
        synchronized (monitor()) {
            check_orphaned();
            keyref = (KeyrefDocument.Keyref) get_store().add_element_user(KEYREF$0);
        }
        return keyref;
    }

    public static class KeyrefImpl extends KeybaseImpl implements KeyrefDocument.Keyref {
        private static final QName REFER$0 = new QName("", "refer");
        private static final long serialVersionUID = 1;

        public KeyrefImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref
        public QName getRefer() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REFER$0);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getQNameValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref
        public XmlQName xgetRefer() {
            XmlQName xmlQNameFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlQNameFind_attribute_user = get_store().find_attribute_user(REFER$0);
            }
            return xmlQNameFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref
        public void setRefer(QName qName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName2 = REFER$0;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName2);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName2);
                }
                simpleValueFind_attribute_user.setQNameValue(qName);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref
        public void xsetRefer(XmlQName xmlQName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = REFER$0;
                XmlQName xmlQNameFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlQNameFind_attribute_user == null) {
                    xmlQNameFind_attribute_user = (XmlQName) get_store().add_attribute_user(qName);
                }
                xmlQNameFind_attribute_user.set(xmlQName);
            }
        }
    }
}
