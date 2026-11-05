package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.Group;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class GroupImpl extends AnnotatedImpl implements Group {
    private static final long serialVersionUID = 1;
    private static final QName ELEMENT$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "element");
    private static final QName GROUP$2 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "group");
    private static final QName ALL$4 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "all");
    private static final QName CHOICE$6 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "choice");
    private static final QName SEQUENCE$8 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "sequence");
    private static final QName ANY$10 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "any");
    private static final QName NAME$12 = new QName("", "name");
    private static final QName REF$14 = new QName("", "ref");
    private static final QName MINOCCURS$16 = new QName("", "minOccurs");
    private static final QName MAXOCCURS$18 = new QName("", "maxOccurs");

    public GroupImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public LocalElement[] getElementArray() {
        LocalElement[] localElementArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ELEMENT$0, arrayList);
            localElementArr = new LocalElement[arrayList.size()];
            arrayList.toArray(localElementArr);
        }
        return localElementArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public LocalElement getElementArray(int i) {
        LocalElement localElement;
        synchronized (monitor()) {
            check_orphaned();
            localElement = (LocalElement) get_store().find_element_user(ELEMENT$0, i);
            if (localElement == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return localElement;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfElementArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ELEMENT$0);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setElementArray(LocalElement[] localElementArr) {
        check_orphaned();
        arraySetterHelper(localElementArr, ELEMENT$0);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setElementArray(int i, LocalElement localElement) {
        generatedSetterHelperImpl(localElement, ELEMENT$0, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public LocalElement insertNewElement(int i) {
        LocalElement localElement;
        synchronized (monitor()) {
            check_orphaned();
            localElement = (LocalElement) get_store().insert_element_user(ELEMENT$0, i);
        }
        return localElement;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public LocalElement addNewElement() {
        LocalElement localElement;
        synchronized (monitor()) {
            check_orphaned();
            localElement = (LocalElement) get_store().add_element_user(ELEMENT$0);
        }
        return localElement;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeElement(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ELEMENT$0, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public GroupRef[] getGroupArray() {
        GroupRef[] groupRefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GROUP$2, arrayList);
            groupRefArr = new GroupRef[arrayList.size()];
            arrayList.toArray(groupRefArr);
        }
        return groupRefArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public GroupRef getGroupArray(int i) {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().find_element_user(GROUP$2, i);
            if (groupRef == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GROUP$2);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setGroupArray(GroupRef[] groupRefArr) {
        check_orphaned();
        arraySetterHelper(groupRefArr, GROUP$2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setGroupArray(int i, GroupRef groupRef) {
        generatedSetterHelperImpl(groupRef, GROUP$2, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public GroupRef insertNewGroup(int i) {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().insert_element_user(GROUP$2, i);
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public GroupRef addNewGroup() {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().add_element_user(GROUP$2);
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeGroup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUP$2, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All[] getAllArray() {
        All[] allArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALL$4, arrayList);
            allArr = new All[arrayList.size()];
            arrayList.toArray(allArr);
        }
        return allArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All getAllArray(int i) {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().find_element_user(ALL$4, i);
            if (all == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfAllArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ALL$4);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAllArray(All[] allArr) {
        check_orphaned();
        arraySetterHelper(allArr, ALL$4);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAllArray(int i, All all) {
        generatedSetterHelperImpl(all, ALL$4, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All insertNewAll(int i) {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().insert_element_user(ALL$4, i);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(ALL$4);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeAll(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALL$4, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup[] getChoiceArray() {
        ExplicitGroup[] explicitGroupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CHOICE$6, arrayList);
            explicitGroupArr = new ExplicitGroup[arrayList.size()];
            arrayList.toArray(explicitGroupArr);
        }
        return explicitGroupArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup getChoiceArray(int i) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().find_element_user(CHOICE$6, i);
            if (explicitGroup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfChoiceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CHOICE$6);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setChoiceArray(ExplicitGroup[] explicitGroupArr) {
        check_orphaned();
        arraySetterHelper(explicitGroupArr, CHOICE$6);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setChoiceArray(int i, ExplicitGroup explicitGroup) {
        generatedSetterHelperImpl(explicitGroup, CHOICE$6, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup insertNewChoice(int i) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().insert_element_user(CHOICE$6, i);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup addNewChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(CHOICE$6);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeChoice(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHOICE$6, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup[] getSequenceArray() {
        ExplicitGroup[] explicitGroupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SEQUENCE$8, arrayList);
            explicitGroupArr = new ExplicitGroup[arrayList.size()];
            arrayList.toArray(explicitGroupArr);
        }
        return explicitGroupArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup getSequenceArray(int i) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().find_element_user(SEQUENCE$8, i);
            if (explicitGroup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfSequenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SEQUENCE$8);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setSequenceArray(ExplicitGroup[] explicitGroupArr) {
        check_orphaned();
        arraySetterHelper(explicitGroupArr, SEQUENCE$8);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setSequenceArray(int i, ExplicitGroup explicitGroup) {
        generatedSetterHelperImpl(explicitGroup, SEQUENCE$8, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup insertNewSequence(int i) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().insert_element_user(SEQUENCE$8, i);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup addNewSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(SEQUENCE$8);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeSequence(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SEQUENCE$8, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AnyDocument.Any[] getAnyArray() {
        AnyDocument.Any[] anyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANY$10, arrayList);
            anyArr = new AnyDocument.Any[arrayList.size()];
            arrayList.toArray(anyArr);
        }
        return anyArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AnyDocument.Any getAnyArray(int i) {
        AnyDocument.Any any;
        synchronized (monitor()) {
            check_orphaned();
            any = (AnyDocument.Any) get_store().find_element_user(ANY$10, i);
            if (any == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return any;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfAnyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANY$10);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAnyArray(AnyDocument.Any[] anyArr) {
        check_orphaned();
        arraySetterHelper(anyArr, ANY$10);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAnyArray(int i, AnyDocument.Any any) {
        generatedSetterHelperImpl(any, ANY$10, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AnyDocument.Any insertNewAny(int i) {
        AnyDocument.Any any;
        synchronized (monitor()) {
            check_orphaned();
            any = (AnyDocument.Any) get_store().insert_element_user(ANY$10, i);
        }
        return any;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AnyDocument.Any addNewAny() {
        AnyDocument.Any any;
        synchronized (monitor()) {
            check_orphaned();
            any = (AnyDocument.Any) get_store().add_element_user(ANY$10);
        }
        return any;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeAny(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANY$10, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public XmlNCName xgetName() {
        XmlNCName xmlNCNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCNameFind_attribute_user = get_store().find_attribute_user(NAME$12);
        }
        return xmlNCNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$12) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$12;
            XmlNCName xmlNCNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlNCNameFind_attribute_user == null) {
                xmlNCNameFind_attribute_user = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCNameFind_attribute_user.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$12);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public QName getRef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REF$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public XmlQName xgetRef() {
        XmlQName xmlQNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlQNameFind_attribute_user = get_store().find_attribute_user(REF$14);
        }
        return xmlQNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public boolean isSetRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REF$14) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setRef(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = REF$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName2);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValueFind_attribute_user.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void xsetRef(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$14;
            XmlQName xmlQNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlQNameFind_attribute_user == null) {
                xmlQNameFind_attribute_user = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQNameFind_attribute_user.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void unsetRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REF$14);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public BigInteger getMinOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$16;
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public XmlNonNegativeInteger xgetMinOccurs() {
        XmlNonNegativeInteger xmlNonNegativeIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$16;
            xmlNonNegativeIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlNonNegativeIntegerFind_attribute_user == null) {
                xmlNonNegativeIntegerFind_attribute_user = (XmlNonNegativeInteger) get_default_attribute_value(qName);
            }
        }
        return xmlNonNegativeIntegerFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public boolean isSetMinOccurs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MINOCCURS$16) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setMinOccurs(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$16;
            XmlNonNegativeInteger xmlNonNegativeIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlNonNegativeIntegerFind_attribute_user == null) {
                xmlNonNegativeIntegerFind_attribute_user = (XmlNonNegativeInteger) get_store().add_attribute_user(qName);
            }
            xmlNonNegativeIntegerFind_attribute_user.set(xmlNonNegativeInteger);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void unsetMinOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MINOCCURS$16);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public Object getMaxOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$18;
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AllNNI xgetMaxOccurs() {
        AllNNI allNNI;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$18;
            allNNI = (AllNNI) typeStore.find_attribute_user(qName);
            if (allNNI == null) {
                allNNI = (AllNNI) get_default_attribute_value(qName);
            }
        }
        return allNNI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public boolean isSetMaxOccurs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MAXOCCURS$18) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setMaxOccurs(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void xsetMaxOccurs(AllNNI allNNI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$18;
            AllNNI allNNI2 = (AllNNI) typeStore.find_attribute_user(qName);
            if (allNNI2 == null) {
                allNNI2 = (AllNNI) get_store().add_attribute_user(qName);
            }
            allNNI2.set(allNNI);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void unsetMaxOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MAXOCCURS$18);
        }
    }
}
