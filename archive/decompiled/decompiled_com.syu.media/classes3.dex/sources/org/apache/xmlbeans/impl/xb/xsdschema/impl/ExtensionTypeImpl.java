package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ExtensionTypeImpl extends AnnotatedImpl implements ExtensionType {
    private static final long serialVersionUID = 1;
    private static final QName GROUP$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "group");
    private static final QName ALL$2 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "all");
    private static final QName CHOICE$4 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "choice");
    private static final QName SEQUENCE$6 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "sequence");
    private static final QName ATTRIBUTE$8 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "attribute");
    private static final QName ATTRIBUTEGROUP$10 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "attributeGroup");
    private static final QName ANYATTRIBUTE$12 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "anyAttribute");
    private static final QName BASE$14 = new QName("", "base");

    public ExtensionTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public GroupRef getGroup() {
        synchronized (monitor()) {
            check_orphaned();
            GroupRef groupRef = (GroupRef) get_store().find_element_user(GROUP$0, 0);
            if (groupRef == null) {
                return null;
            }
            return groupRef;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public boolean isSetGroup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GROUP$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setGroup(GroupRef groupRef) {
        generatedSetterHelperImpl(groupRef, GROUP$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public GroupRef addNewGroup() {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().add_element_user(GROUP$0);
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void unsetGroup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUP$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public All getAll() {
        synchronized (monitor()) {
            check_orphaned();
            All all = (All) get_store().find_element_user(ALL$2, 0);
            if (all == null) {
                return null;
            }
            return all;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public boolean isSetAll() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ALL$2) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setAll(All all) {
        generatedSetterHelperImpl(all, ALL$2, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(ALL$2);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void unsetAll() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALL$2, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public ExplicitGroup getChoice() {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup = (ExplicitGroup) get_store().find_element_user(CHOICE$4, 0);
            if (explicitGroup == null) {
                return null;
            }
            return explicitGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public boolean isSetChoice() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CHOICE$4) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setChoice(ExplicitGroup explicitGroup) {
        generatedSetterHelperImpl(explicitGroup, CHOICE$4, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public ExplicitGroup addNewChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(CHOICE$4);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void unsetChoice() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHOICE$4, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public ExplicitGroup getSequence() {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup = (ExplicitGroup) get_store().find_element_user(SEQUENCE$6, 0);
            if (explicitGroup == null) {
                return null;
            }
            return explicitGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public boolean isSetSequence() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SEQUENCE$6) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setSequence(ExplicitGroup explicitGroup) {
        generatedSetterHelperImpl(explicitGroup, SEQUENCE$6, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public ExplicitGroup addNewSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(SEQUENCE$6);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void unsetSequence() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SEQUENCE$6, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public Attribute[] getAttributeArray() {
        Attribute[] attributeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTE$8, arrayList);
            attributeArr = new Attribute[arrayList.size()];
            arrayList.toArray(attributeArr);
        }
        return attributeArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public Attribute getAttributeArray(int i) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().find_element_user(ATTRIBUTE$8, i);
            if (attribute == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public int sizeOfAttributeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ATTRIBUTE$8);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setAttributeArray(Attribute[] attributeArr) {
        check_orphaned();
        arraySetterHelper(attributeArr, ATTRIBUTE$8);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setAttributeArray(int i, Attribute attribute) {
        generatedSetterHelperImpl(attribute, ATTRIBUTE$8, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public Attribute insertNewAttribute(int i) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().insert_element_user(ATTRIBUTE$8, i);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public Attribute addNewAttribute() {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().add_element_user(ATTRIBUTE$8);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void removeAttribute(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTE$8, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public AttributeGroupRef[] getAttributeGroupArray() {
        AttributeGroupRef[] attributeGroupRefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTEGROUP$10, arrayList);
            attributeGroupRefArr = new AttributeGroupRef[arrayList.size()];
            arrayList.toArray(attributeGroupRefArr);
        }
        return attributeGroupRefArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public AttributeGroupRef getAttributeGroupArray(int i) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().find_element_user(ATTRIBUTEGROUP$10, i);
            if (attributeGroupRef == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public int sizeOfAttributeGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ATTRIBUTEGROUP$10);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr) {
        check_orphaned();
        arraySetterHelper(attributeGroupRefArr, ATTRIBUTEGROUP$10);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setAttributeGroupArray(int i, AttributeGroupRef attributeGroupRef) {
        generatedSetterHelperImpl(attributeGroupRef, ATTRIBUTEGROUP$10, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public AttributeGroupRef insertNewAttributeGroup(int i) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().insert_element_user(ATTRIBUTEGROUP$10, i);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public AttributeGroupRef addNewAttributeGroup() {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().add_element_user(ATTRIBUTEGROUP$10);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void removeAttributeGroup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEGROUP$10, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public Wildcard getAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            Wildcard wildcard = (Wildcard) get_store().find_element_user(ANYATTRIBUTE$12, 0);
            if (wildcard == null) {
                return null;
            }
            return wildcard;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public boolean isSetAnyAttribute() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ANYATTRIBUTE$12) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setAnyAttribute(Wildcard wildcard) {
        generatedSetterHelperImpl(wildcard, ANYATTRIBUTE$12, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public Wildcard addNewAnyAttribute() {
        Wildcard wildcard;
        synchronized (monitor()) {
            check_orphaned();
            wildcard = (Wildcard) get_store().add_element_user(ANYATTRIBUTE$12);
        }
        return wildcard;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void unsetAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANYATTRIBUTE$12, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public QName getBase() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BASE$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public XmlQName xgetBase() {
        XmlQName xmlQNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlQNameFind_attribute_user = get_store().find_attribute_user(BASE$14);
        }
        return xmlQNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void setBase(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = BASE$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName2);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValueFind_attribute_user.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType
    public void xsetBase(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BASE$14;
            XmlQName xmlQNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlQNameFind_attribute_user == null) {
                xmlQNameFind_attribute_user = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQNameFind_attribute_user.set(xmlQName);
        }
    }
}
