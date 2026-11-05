package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class KeybaseImpl extends AnnotatedImpl implements Keybase {
    private static final long serialVersionUID = 1;
    private static final QName SELECTOR$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "selector");
    private static final QName FIELD$2 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, JamXmlElements.FIELD);
    private static final QName NAME$4 = new QName("", "name");

    public KeybaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void setSelector(SelectorDocument.Selector selector) {
        generatedSetterHelperImpl(selector, SELECTOR$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public SelectorDocument.Selector addNewSelector() {
        SelectorDocument.Selector selector;
        synchronized (monitor()) {
            check_orphaned();
            selector = (SelectorDocument.Selector) get_store().add_element_user(SELECTOR$0);
        }
        return selector;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public FieldDocument.Field[] getFieldArray() {
        FieldDocument.Field[] fieldArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FIELD$2, arrayList);
            fieldArr = new FieldDocument.Field[arrayList.size()];
            arrayList.toArray(fieldArr);
        }
        return fieldArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public FieldDocument.Field getFieldArray(int i) {
        FieldDocument.Field field;
        synchronized (monitor()) {
            check_orphaned();
            field = (FieldDocument.Field) get_store().find_element_user(FIELD$2, i);
            if (field == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return field;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public int sizeOfFieldArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FIELD$2);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void setFieldArray(FieldDocument.Field[] fieldArr) {
        check_orphaned();
        arraySetterHelper(fieldArr, FIELD$2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void setFieldArray(int i, FieldDocument.Field field) {
        generatedSetterHelperImpl(field, FIELD$2, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public FieldDocument.Field insertNewField(int i) {
        FieldDocument.Field field;
        synchronized (monitor()) {
            check_orphaned();
            field = (FieldDocument.Field) get_store().insert_element_user(FIELD$2, i);
        }
        return field;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public FieldDocument.Field addNewField() {
        FieldDocument.Field field;
        synchronized (monitor()) {
            check_orphaned();
            field = (FieldDocument.Field) get_store().add_element_user(FIELD$2);
        }
        return field;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void removeField(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FIELD$2, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public XmlNCName xgetName() {
        XmlNCName xmlNCNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCNameFind_attribute_user = get_store().find_attribute_user(NAME$4);
        }
        return xmlNCNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Keybase
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$4;
            XmlNCName xmlNCNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlNCNameFind_attribute_user == null) {
                xmlNCNameFind_attribute_user = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCNameFind_attribute_user.set(xmlNCName);
        }
    }
}
