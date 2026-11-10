package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SelectorDocumentImpl extends XmlComplexContentImpl implements SelectorDocument {
    private static final QName SELECTOR$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "selector");
    private static final long serialVersionUID = 1;

    public SelectorDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument
    public SelectorDocument.Selector getSelector() {
        synchronized (monitor()) {
            check_orphaned();
            SelectorDocument.Selector selector = (SelectorDocument.Selector) get_store().find_element_user(SELECTOR$0, 0);
            if (selector == null) {
                return null;
            }
            return selector;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument
    public void setSelector(SelectorDocument.Selector selector) {
        generatedSetterHelperImpl(selector, SELECTOR$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument
    public SelectorDocument.Selector addNewSelector() {
        SelectorDocument.Selector selector;
        synchronized (monitor()) {
            check_orphaned();
            selector = (SelectorDocument.Selector) get_store().add_element_user(SELECTOR$0);
        }
        return selector;
    }

    public static class SelectorImpl extends AnnotatedImpl implements SelectorDocument.Selector {
        private static final QName XPATH$0 = new QName("", "xpath");
        private static final long serialVersionUID = 1;

        public SelectorImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument.Selector
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

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument.Selector
        public SelectorDocument.Selector.Xpath xgetXpath() {
            SelectorDocument.Selector.Xpath xpath;
            synchronized (monitor()) {
                check_orphaned();
                xpath = (SelectorDocument.Selector.Xpath) get_store().find_attribute_user(XPATH$0);
            }
            return xpath;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument.Selector
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

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument.Selector
        public void xsetXpath(SelectorDocument.Selector.Xpath xpath) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = XPATH$0;
                SelectorDocument.Selector.Xpath xpath2 = (SelectorDocument.Selector.Xpath) typeStore.find_attribute_user(qName);
                if (xpath2 == null) {
                    xpath2 = (SelectorDocument.Selector.Xpath) get_store().add_attribute_user(qName);
                }
                xpath2.set(xpath);
            }
        }

        public static class XpathImpl extends JavaStringHolderEx implements SelectorDocument.Selector.Xpath {
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
