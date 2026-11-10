package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class AttributeImpl extends AnnotatedImpl implements Attribute {
    private static final long serialVersionUID = 1;
    private static final QName SIMPLETYPE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "simpleType");
    private static final QName NAME$2 = new QName("", "name");
    private static final QName REF$4 = new QName("", "ref");
    private static final QName TYPE$6 = new QName("", JamXmlElements.TYPE);
    private static final QName USE$8 = new QName("", "use");
    private static final QName DEFAULT$10 = new QName("", "default");
    private static final QName FIXED$12 = new QName("", "fixed");
    private static final QName FORM$14 = new QName("", "form");

    public AttributeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public LocalSimpleType getSimpleType() {
        synchronized (monitor()) {
            check_orphaned();
            LocalSimpleType localSimpleType = (LocalSimpleType) get_store().find_element_user(SIMPLETYPE$0, 0);
            if (localSimpleType == null) {
                return null;
            }
            return localSimpleType;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetSimpleType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIMPLETYPE$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setSimpleType(LocalSimpleType localSimpleType) {
        generatedSetterHelperImpl(localSimpleType, SIMPLETYPE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public LocalSimpleType addNewSimpleType() {
        LocalSimpleType localSimpleType;
        synchronized (monitor()) {
            check_orphaned();
            localSimpleType = (LocalSimpleType) get_store().add_element_user(SIMPLETYPE$0);
        }
        return localSimpleType;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetSimpleType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIMPLETYPE$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public XmlNCName xgetName() {
        XmlNCName xmlNCNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCNameFind_attribute_user = get_store().find_attribute_user(NAME$2);
        }
        return xmlNCNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$2) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$2;
            XmlNCName xmlNCNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlNCNameFind_attribute_user == null) {
                xmlNCNameFind_attribute_user = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCNameFind_attribute_user.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public QName getRef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REF$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public XmlQName xgetRef() {
        XmlQName xmlQNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlQNameFind_attribute_user = get_store().find_attribute_user(REF$4);
        }
        return xmlQNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REF$4) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setRef(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = REF$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName2);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValueFind_attribute_user.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetRef(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$4;
            XmlQName xmlQNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlQNameFind_attribute_user == null) {
                xmlQNameFind_attribute_user = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQNameFind_attribute_user.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REF$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public QName getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TYPE$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public XmlQName xgetType() {
        XmlQName xmlQNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlQNameFind_attribute_user = get_store().find_attribute_user(TYPE$6);
        }
        return xmlQNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$6) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setType(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = TYPE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName2);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValueFind_attribute_user.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetType(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$6;
            XmlQName xmlQNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlQNameFind_attribute_user == null) {
                xmlQNameFind_attribute_user = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQNameFind_attribute_user.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public Attribute.Use.Enum getUse() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USE$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (Attribute.Use.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public Attribute.Use xgetUse() {
        Attribute.Use use;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USE$8;
            use = (Attribute.Use) typeStore.find_attribute_user(qName);
            if (use == null) {
                use = (Attribute.Use) get_default_attribute_value(qName);
            }
        }
        return use;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetUse() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USE$8) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setUse(Attribute.Use.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USE$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetUse(Attribute.Use use) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USE$8;
            Attribute.Use use2 = (Attribute.Use) typeStore.find_attribute_user(qName);
            if (use2 == null) {
                use2 = (Attribute.Use) get_store().add_attribute_user(qName);
            }
            use2.set((XmlObject) use);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetUse() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USE$8);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public String getDefault() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFAULT$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public XmlString xgetDefault() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(DEFAULT$10);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFAULT$10) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setDefault(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULT$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetDefault(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULT$10;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFAULT$10);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public String getFixed() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FIXED$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public XmlString xgetFixed() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(FIXED$12);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetFixed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIXED$12) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setFixed(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetFixed(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$12;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetFixed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIXED$12);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public FormChoice.Enum getForm() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FORM$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (FormChoice.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public FormChoice xgetForm() {
        FormChoice formChoice;
        synchronized (monitor()) {
            check_orphaned();
            formChoice = (FormChoice) get_store().find_attribute_user(FORM$14);
        }
        return formChoice;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public boolean isSetForm() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORM$14) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void setForm(FormChoice.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORM$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void xsetForm(FormChoice formChoice) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORM$14;
            FormChoice formChoice2 = (FormChoice) typeStore.find_attribute_user(qName);
            if (formChoice2 == null) {
                formChoice2 = (FormChoice) get_store().add_attribute_user(qName);
            }
            formChoice2.set((XmlObject) formChoice);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    public void unsetForm() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORM$14);
        }
    }

    public static class UseImpl extends JavaStringEnumerationHolderEx implements Attribute.Use {
        private static final long serialVersionUID = 1;

        public UseImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected UseImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }
}
