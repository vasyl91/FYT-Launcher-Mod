package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ComplexTypeImpl extends AnnotatedImpl implements ComplexType {
    private static final long serialVersionUID = 1;
    private static final QName SIMPLECONTENT$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "simpleContent");
    private static final QName COMPLEXCONTENT$2 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "complexContent");
    private static final QName GROUP$4 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "group");
    private static final QName ALL$6 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "all");
    private static final QName CHOICE$8 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "choice");
    private static final QName SEQUENCE$10 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "sequence");
    private static final QName ATTRIBUTE$12 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "attribute");
    private static final QName ATTRIBUTEGROUP$14 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "attributeGroup");
    private static final QName ANYATTRIBUTE$16 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "anyAttribute");
    private static final QName NAME$18 = new QName("", "name");
    private static final QName MIXED$20 = new QName("", "mixed");
    private static final QName ABSTRACT$22 = new QName("", "abstract");
    private static final QName FINAL$24 = new QName("", "final");
    private static final QName BLOCK$26 = new QName("", "block");

    public ComplexTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean isSetSimpleContent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIMPLECONTENT$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setSimpleContent(SimpleContentDocument.SimpleContent simpleContent) {
        generatedSetterHelperImpl(simpleContent, SIMPLECONTENT$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public SimpleContentDocument.SimpleContent addNewSimpleContent() {
        SimpleContentDocument.SimpleContent simpleContent;
        synchronized (monitor()) {
            check_orphaned();
            simpleContent = (SimpleContentDocument.SimpleContent) get_store().add_element_user(SIMPLECONTENT$0);
        }
        return simpleContent;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void unsetSimpleContent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIMPLECONTENT$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public ComplexContentDocument.ComplexContent getComplexContent() {
        synchronized (monitor()) {
            check_orphaned();
            ComplexContentDocument.ComplexContent complexContent = (ComplexContentDocument.ComplexContent) get_store().find_element_user(COMPLEXCONTENT$2, 0);
            if (complexContent == null) {
                return null;
            }
            return complexContent;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean isSetComplexContent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COMPLEXCONTENT$2) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setComplexContent(ComplexContentDocument.ComplexContent complexContent) {
        generatedSetterHelperImpl(complexContent, COMPLEXCONTENT$2, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public ComplexContentDocument.ComplexContent addNewComplexContent() {
        ComplexContentDocument.ComplexContent complexContent;
        synchronized (monitor()) {
            check_orphaned();
            complexContent = (ComplexContentDocument.ComplexContent) get_store().add_element_user(COMPLEXCONTENT$2);
        }
        return complexContent;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void unsetComplexContent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMPLEXCONTENT$2, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public GroupRef getGroup() {
        synchronized (monitor()) {
            check_orphaned();
            GroupRef groupRef = (GroupRef) get_store().find_element_user(GROUP$4, 0);
            if (groupRef == null) {
                return null;
            }
            return groupRef;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean isSetGroup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GROUP$4) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setGroup(GroupRef groupRef) {
        generatedSetterHelperImpl(groupRef, GROUP$4, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public GroupRef addNewGroup() {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().add_element_user(GROUP$4);
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void unsetGroup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUP$4, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public All getAll() {
        synchronized (monitor()) {
            check_orphaned();
            All all = (All) get_store().find_element_user(ALL$6, 0);
            if (all == null) {
                return null;
            }
            return all;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean isSetAll() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ALL$6) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setAll(All all) {
        generatedSetterHelperImpl(all, ALL$6, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(ALL$6);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void unsetAll() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALL$6, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public ExplicitGroup getChoice() {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup = (ExplicitGroup) get_store().find_element_user(CHOICE$8, 0);
            if (explicitGroup == null) {
                return null;
            }
            return explicitGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean isSetChoice() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CHOICE$8) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setChoice(ExplicitGroup explicitGroup) {
        generatedSetterHelperImpl(explicitGroup, CHOICE$8, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public ExplicitGroup addNewChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(CHOICE$8);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void unsetChoice() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHOICE$8, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public ExplicitGroup getSequence() {
        synchronized (monitor()) {
            check_orphaned();
            ExplicitGroup explicitGroup = (ExplicitGroup) get_store().find_element_user(SEQUENCE$10, 0);
            if (explicitGroup == null) {
                return null;
            }
            return explicitGroup;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean isSetSequence() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SEQUENCE$10) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setSequence(ExplicitGroup explicitGroup) {
        generatedSetterHelperImpl(explicitGroup, SEQUENCE$10, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public ExplicitGroup addNewSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(SEQUENCE$10);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void unsetSequence() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SEQUENCE$10, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public Attribute[] getAttributeArray() {
        Attribute[] attributeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTE$12, arrayList);
            attributeArr = new Attribute[arrayList.size()];
            arrayList.toArray(attributeArr);
        }
        return attributeArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public Attribute getAttributeArray(int i) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().find_element_user(ATTRIBUTE$12, i);
            if (attribute == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public int sizeOfAttributeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ATTRIBUTE$12);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setAttributeArray(Attribute[] attributeArr) {
        check_orphaned();
        arraySetterHelper(attributeArr, ATTRIBUTE$12);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setAttributeArray(int i, Attribute attribute) {
        generatedSetterHelperImpl(attribute, ATTRIBUTE$12, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public Attribute insertNewAttribute(int i) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().insert_element_user(ATTRIBUTE$12, i);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public Attribute addNewAttribute() {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().add_element_user(ATTRIBUTE$12);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void removeAttribute(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTE$12, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public AttributeGroupRef[] getAttributeGroupArray() {
        AttributeGroupRef[] attributeGroupRefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTRIBUTEGROUP$14, arrayList);
            attributeGroupRefArr = new AttributeGroupRef[arrayList.size()];
            arrayList.toArray(attributeGroupRefArr);
        }
        return attributeGroupRefArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public AttributeGroupRef getAttributeGroupArray(int i) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().find_element_user(ATTRIBUTEGROUP$14, i);
            if (attributeGroupRef == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public int sizeOfAttributeGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ATTRIBUTEGROUP$14);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr) {
        check_orphaned();
        arraySetterHelper(attributeGroupRefArr, ATTRIBUTEGROUP$14);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setAttributeGroupArray(int i, AttributeGroupRef attributeGroupRef) {
        generatedSetterHelperImpl(attributeGroupRef, ATTRIBUTEGROUP$14, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public AttributeGroupRef insertNewAttributeGroup(int i) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().insert_element_user(ATTRIBUTEGROUP$14, i);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public AttributeGroupRef addNewAttributeGroup() {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().add_element_user(ATTRIBUTEGROUP$14);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void removeAttributeGroup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTRIBUTEGROUP$14, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public Wildcard getAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            Wildcard wildcard = (Wildcard) get_store().find_element_user(ANYATTRIBUTE$16, 0);
            if (wildcard == null) {
                return null;
            }
            return wildcard;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean isSetAnyAttribute() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ANYATTRIBUTE$16) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setAnyAttribute(Wildcard wildcard) {
        generatedSetterHelperImpl(wildcard, ANYATTRIBUTE$16, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public Wildcard addNewAnyAttribute() {
        Wildcard wildcard;
        synchronized (monitor()) {
            check_orphaned();
            wildcard = (Wildcard) get_store().add_element_user(ANYATTRIBUTE$16);
        }
        return wildcard;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void unsetAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANYATTRIBUTE$16, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$18);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public XmlNCName xgetName() {
        XmlNCName xmlNCNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCNameFind_attribute_user = get_store().find_attribute_user(NAME$18);
        }
        return xmlNCNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$18) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$18;
            XmlNCName xmlNCNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlNCNameFind_attribute_user == null) {
                xmlNCNameFind_attribute_user = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCNameFind_attribute_user.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$18);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean getMixed() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MIXED$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public XmlBoolean xgetMixed() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MIXED$20;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean isSetMixed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MIXED$20) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setMixed(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MIXED$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void xsetMixed(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MIXED$20;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void unsetMixed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MIXED$20);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean getAbstract() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACT$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public XmlBoolean xgetAbstract() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACT$22;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean isSetAbstract() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ABSTRACT$22) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setAbstract(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACT$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void xsetAbstract(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACT$22;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void unsetAbstract() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ABSTRACT$22);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public Object getFinal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FINAL$24);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public DerivationSet xgetFinal() {
        DerivationSet derivationSet;
        synchronized (monitor()) {
            check_orphaned();
            derivationSet = (DerivationSet) get_store().find_attribute_user(FINAL$24);
        }
        return derivationSet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean isSetFinal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FINAL$24) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setFinal(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FINAL$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void xsetFinal(DerivationSet derivationSet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FINAL$24;
            DerivationSet derivationSet2 = (DerivationSet) typeStore.find_attribute_user(qName);
            if (derivationSet2 == null) {
                derivationSet2 = (DerivationSet) get_store().add_attribute_user(qName);
            }
            derivationSet2.set(derivationSet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void unsetFinal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FINAL$24);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public Object getBlock() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BLOCK$26);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public DerivationSet xgetBlock() {
        DerivationSet derivationSet;
        synchronized (monitor()) {
            check_orphaned();
            derivationSet = (DerivationSet) get_store().find_attribute_user(BLOCK$26);
        }
        return derivationSet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public boolean isSetBlock() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BLOCK$26) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void setBlock(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOCK$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void xsetBlock(DerivationSet derivationSet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOCK$26;
            DerivationSet derivationSet2 = (DerivationSet) typeStore.find_attribute_user(qName);
            if (derivationSet2 == null) {
                derivationSet2 = (DerivationSet) get_store().add_attribute_user(qName);
            }
            derivationSet2.set(derivationSet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    public void unsetBlock() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BLOCK$26);
        }
    }
}
