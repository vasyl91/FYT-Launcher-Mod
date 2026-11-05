package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.BlockSet;
import org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ElementImpl extends AnnotatedImpl implements Element {
    private static final long serialVersionUID = 1;
    private static final QName SIMPLETYPE$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "simpleType");
    private static final QName COMPLEXTYPE$2 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "complexType");
    private static final QName UNIQUE$4 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "unique");
    private static final QName KEY$6 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "key");
    private static final QName KEYREF$8 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "keyref");
    private static final QName NAME$10 = new QName("", "name");
    private static final QName REF$12 = new QName("", "ref");
    private static final QName TYPE$14 = new QName("", JamXmlElements.TYPE);
    private static final QName SUBSTITUTIONGROUP$16 = new QName("", "substitutionGroup");
    private static final QName MINOCCURS$18 = new QName("", "minOccurs");
    private static final QName MAXOCCURS$20 = new QName("", "maxOccurs");
    private static final QName DEFAULT$22 = new QName("", "default");
    private static final QName FIXED$24 = new QName("", "fixed");
    private static final QName NILLABLE$26 = new QName("", "nillable");
    private static final QName ABSTRACT$28 = new QName("", "abstract");
    private static final QName FINAL$30 = new QName("", "final");
    private static final QName BLOCK$32 = new QName("", "block");
    private static final QName FORM$34 = new QName("", "form");

    public ElementImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetSimpleType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIMPLETYPE$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setSimpleType(LocalSimpleType localSimpleType) {
        generatedSetterHelperImpl(localSimpleType, SIMPLETYPE$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public LocalSimpleType addNewSimpleType() {
        LocalSimpleType localSimpleType;
        synchronized (monitor()) {
            check_orphaned();
            localSimpleType = (LocalSimpleType) get_store().add_element_user(SIMPLETYPE$0);
        }
        return localSimpleType;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetSimpleType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIMPLETYPE$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public LocalComplexType getComplexType() {
        synchronized (monitor()) {
            check_orphaned();
            LocalComplexType localComplexType = (LocalComplexType) get_store().find_element_user(COMPLEXTYPE$2, 0);
            if (localComplexType == null) {
                return null;
            }
            return localComplexType;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetComplexType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COMPLEXTYPE$2) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setComplexType(LocalComplexType localComplexType) {
        generatedSetterHelperImpl(localComplexType, COMPLEXTYPE$2, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public LocalComplexType addNewComplexType() {
        LocalComplexType localComplexType;
        synchronized (monitor()) {
            check_orphaned();
            localComplexType = (LocalComplexType) get_store().add_element_user(COMPLEXTYPE$2);
        }
        return localComplexType;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetComplexType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMPLEXTYPE$2, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase[] getUniqueArray() {
        Keybase[] keybaseArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(UNIQUE$4, arrayList);
            keybaseArr = new Keybase[arrayList.size()];
            arrayList.toArray(keybaseArr);
        }
        return keybaseArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase getUniqueArray(int i) {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().find_element_user(UNIQUE$4, i);
            if (keybase == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public int sizeOfUniqueArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(UNIQUE$4);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setUniqueArray(Keybase[] keybaseArr) {
        check_orphaned();
        arraySetterHelper(keybaseArr, UNIQUE$4);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setUniqueArray(int i, Keybase keybase) {
        generatedSetterHelperImpl(keybase, UNIQUE$4, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase insertNewUnique(int i) {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().insert_element_user(UNIQUE$4, i);
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase addNewUnique() {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().add_element_user(UNIQUE$4);
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void removeUnique(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UNIQUE$4, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase[] getKeyArray() {
        Keybase[] keybaseArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(KEY$6, arrayList);
            keybaseArr = new Keybase[arrayList.size()];
            arrayList.toArray(keybaseArr);
        }
        return keybaseArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase getKeyArray(int i) {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().find_element_user(KEY$6, i);
            if (keybase == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public int sizeOfKeyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(KEY$6);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setKeyArray(Keybase[] keybaseArr) {
        check_orphaned();
        arraySetterHelper(keybaseArr, KEY$6);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setKeyArray(int i, Keybase keybase) {
        generatedSetterHelperImpl(keybase, KEY$6, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase insertNewKey(int i) {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().insert_element_user(KEY$6, i);
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Keybase addNewKey() {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().add_element_user(KEY$6);
        }
        return keybase;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void removeKey(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KEY$6, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public KeyrefDocument.Keyref[] getKeyrefArray() {
        KeyrefDocument.Keyref[] keyrefArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(KEYREF$8, arrayList);
            keyrefArr = new KeyrefDocument.Keyref[arrayList.size()];
            arrayList.toArray(keyrefArr);
        }
        return keyrefArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public KeyrefDocument.Keyref getKeyrefArray(int i) {
        KeyrefDocument.Keyref keyref;
        synchronized (monitor()) {
            check_orphaned();
            keyref = (KeyrefDocument.Keyref) get_store().find_element_user(KEYREF$8, i);
            if (keyref == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return keyref;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public int sizeOfKeyrefArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(KEYREF$8);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setKeyrefArray(KeyrefDocument.Keyref[] keyrefArr) {
        check_orphaned();
        arraySetterHelper(keyrefArr, KEYREF$8);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setKeyrefArray(int i, KeyrefDocument.Keyref keyref) {
        generatedSetterHelperImpl(keyref, KEYREF$8, i, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public KeyrefDocument.Keyref insertNewKeyref(int i) {
        KeyrefDocument.Keyref keyref;
        synchronized (monitor()) {
            check_orphaned();
            keyref = (KeyrefDocument.Keyref) get_store().insert_element_user(KEYREF$8, i);
        }
        return keyref;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public KeyrefDocument.Keyref addNewKeyref() {
        KeyrefDocument.Keyref keyref;
        synchronized (monitor()) {
            check_orphaned();
            keyref = (KeyrefDocument.Keyref) get_store().add_element_user(KEYREF$8);
        }
        return keyref;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void removeKeyref(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KEYREF$8, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlNCName xgetName() {
        XmlNCName xmlNCNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCNameFind_attribute_user = get_store().find_attribute_user(NAME$10);
        }
        return xmlNCNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$10) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$10;
            XmlNCName xmlNCNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlNCNameFind_attribute_user == null) {
                xmlNCNameFind_attribute_user = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCNameFind_attribute_user.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$10);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public QName getRef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REF$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlQName xgetRef() {
        XmlQName xmlQNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlQNameFind_attribute_user = get_store().find_attribute_user(REF$12);
        }
        return xmlQNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REF$12) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setRef(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = REF$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName2);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValueFind_attribute_user.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetRef(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$12;
            XmlQName xmlQNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlQNameFind_attribute_user == null) {
                xmlQNameFind_attribute_user = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQNameFind_attribute_user.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REF$12);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public QName getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TYPE$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlQName xgetType() {
        XmlQName xmlQNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlQNameFind_attribute_user = get_store().find_attribute_user(TYPE$14);
        }
        return xmlQNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$14) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setType(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = TYPE$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName2);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValueFind_attribute_user.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetType(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$14;
            XmlQName xmlQNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlQNameFind_attribute_user == null) {
                xmlQNameFind_attribute_user = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQNameFind_attribute_user.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$14);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public QName getSubstitutionGroup() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SUBSTITUTIONGROUP$16);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getQNameValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlQName xgetSubstitutionGroup() {
        XmlQName xmlQNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlQNameFind_attribute_user = get_store().find_attribute_user(SUBSTITUTIONGROUP$16);
        }
        return xmlQNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetSubstitutionGroup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SUBSTITUTIONGROUP$16) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setSubstitutionGroup(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName2 = SUBSTITUTIONGROUP$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName2);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName2);
            }
            simpleValueFind_attribute_user.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetSubstitutionGroup(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUBSTITUTIONGROUP$16;
            XmlQName xmlQNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlQNameFind_attribute_user == null) {
                xmlQNameFind_attribute_user = (XmlQName) get_store().add_attribute_user(qName);
            }
            xmlQNameFind_attribute_user.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetSubstitutionGroup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SUBSTITUTIONGROUP$16);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public BigInteger getMinOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$18;
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlNonNegativeInteger xgetMinOccurs() {
        XmlNonNegativeInteger xmlNonNegativeIntegerFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$18;
            xmlNonNegativeIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlNonNegativeIntegerFind_attribute_user == null) {
                xmlNonNegativeIntegerFind_attribute_user = (XmlNonNegativeInteger) get_default_attribute_value(qName);
            }
        }
        return xmlNonNegativeIntegerFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetMinOccurs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MINOCCURS$18) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setMinOccurs(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINOCCURS$18;
            XmlNonNegativeInteger xmlNonNegativeIntegerFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlNonNegativeIntegerFind_attribute_user == null) {
                xmlNonNegativeIntegerFind_attribute_user = (XmlNonNegativeInteger) get_store().add_attribute_user(qName);
            }
            xmlNonNegativeIntegerFind_attribute_user.set(xmlNonNegativeInteger);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetMinOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MINOCCURS$18);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Object getMaxOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$20;
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public AllNNI xgetMaxOccurs() {
        AllNNI allNNI;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$20;
            allNNI = (AllNNI) typeStore.find_attribute_user(qName);
            if (allNNI == null) {
                allNNI = (AllNNI) get_default_attribute_value(qName);
            }
        }
        return allNNI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetMaxOccurs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MAXOCCURS$20) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setMaxOccurs(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetMaxOccurs(AllNNI allNNI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXOCCURS$20;
            AllNNI allNNI2 = (AllNNI) typeStore.find_attribute_user(qName);
            if (allNNI2 == null) {
                allNNI2 = (AllNNI) get_store().add_attribute_user(qName);
            }
            allNNI2.set(allNNI);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetMaxOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MAXOCCURS$20);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public String getDefault() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFAULT$22);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlString xgetDefault() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(DEFAULT$22);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFAULT$22) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setDefault(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULT$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetDefault(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULT$22;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFAULT$22);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public String getFixed() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FIXED$24);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlString xgetFixed() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(FIXED$24);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetFixed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIXED$24) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setFixed(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetFixed(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$24;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetFixed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIXED$24);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean getNillable() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NILLABLE$26;
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlBoolean xgetNillable() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NILLABLE$26;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetNillable() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NILLABLE$26) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setNillable(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NILLABLE$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetNillable(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NILLABLE$26;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetNillable() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NILLABLE$26);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean getAbstract() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACT$28;
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public XmlBoolean xgetAbstract() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACT$28;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetAbstract() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ABSTRACT$28) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setAbstract(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACT$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetAbstract(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACT$28;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetAbstract() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ABSTRACT$28);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Object getFinal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FINAL$30);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public DerivationSet xgetFinal() {
        DerivationSet derivationSet;
        synchronized (monitor()) {
            check_orphaned();
            derivationSet = (DerivationSet) get_store().find_attribute_user(FINAL$30);
        }
        return derivationSet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetFinal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FINAL$30) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setFinal(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FINAL$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetFinal(DerivationSet derivationSet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FINAL$30;
            DerivationSet derivationSet2 = (DerivationSet) typeStore.find_attribute_user(qName);
            if (derivationSet2 == null) {
                derivationSet2 = (DerivationSet) get_store().add_attribute_user(qName);
            }
            derivationSet2.set(derivationSet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetFinal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FINAL$30);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public Object getBlock() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BLOCK$32);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getObjectValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public BlockSet xgetBlock() {
        BlockSet blockSet;
        synchronized (monitor()) {
            check_orphaned();
            blockSet = (BlockSet) get_store().find_attribute_user(BLOCK$32);
        }
        return blockSet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetBlock() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BLOCK$32) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setBlock(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOCK$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetBlock(BlockSet blockSet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOCK$32;
            BlockSet blockSet2 = (BlockSet) typeStore.find_attribute_user(qName);
            if (blockSet2 == null) {
                blockSet2 = (BlockSet) get_store().add_attribute_user(qName);
            }
            blockSet2.set(blockSet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetBlock() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BLOCK$32);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public FormChoice.Enum getForm() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FORM$34);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (FormChoice.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public FormChoice xgetForm() {
        FormChoice formChoice;
        synchronized (monitor()) {
            check_orphaned();
            formChoice = (FormChoice) get_store().find_attribute_user(FORM$34);
        }
        return formChoice;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public boolean isSetForm() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORM$34) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void setForm(FormChoice.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORM$34;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void xsetForm(FormChoice formChoice) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORM$34;
            FormChoice formChoice2 = (FormChoice) typeStore.find_attribute_user(qName);
            if (formChoice2 == null) {
                formChoice2 = (FormChoice) get_store().add_attribute_user(qName);
            }
            formChoice2.set((XmlObject) formChoice);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    public void unsetForm() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORM$34);
        }
    }
}
