package org.w3.x2000.x09.xmldsig.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.DigestMethodType;
import org.w3.x2000.x09.xmldsig.DigestValueType;
import org.w3.x2000.x09.xmldsig.ReferenceType;
import org.w3.x2000.x09.xmldsig.TransformsType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class ReferenceTypeImpl extends XmlComplexContentImpl implements ReferenceType {
    private static final QName TRANSFORMS$0 = new QName("http://www.w3.org/2000/09/xmldsig#", "Transforms");
    private static final QName DIGESTMETHOD$2 = new QName("http://www.w3.org/2000/09/xmldsig#", "DigestMethod");
    private static final QName DIGESTVALUE$4 = new QName("http://www.w3.org/2000/09/xmldsig#", "DigestValue");
    private static final QName ID$6 = new QName("", "Id");
    private static final QName URI$8 = new QName("", "URI");
    private static final QName TYPE$10 = new QName("", "Type");

    public ReferenceTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public DigestMethodType addNewDigestMethod() {
        DigestMethodType digestMethodTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            digestMethodTypeAdd_element_user = get_store().add_element_user(DIGESTMETHOD$2);
        }
        return digestMethodTypeAdd_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public TransformsType addNewTransforms() {
        TransformsType transformsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            transformsTypeAdd_element_user = get_store().add_element_user(TRANSFORMS$0);
        }
        return transformsTypeAdd_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public DigestMethodType getDigestMethod() {
        synchronized (monitor()) {
            check_orphaned();
            DigestMethodType digestMethodTypeFind_element_user = get_store().find_element_user(DIGESTMETHOD$2, 0);
            if (digestMethodTypeFind_element_user == null) {
                return null;
            }
            return digestMethodTypeFind_element_user;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public byte[] getDigestValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(DIGESTVALUE$4, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public TransformsType getTransforms() {
        synchronized (monitor()) {
            check_orphaned();
            TransformsType transformsTypeFind_element_user = get_store().find_element_user(TRANSFORMS$0, 0);
            if (transformsTypeFind_element_user == null) {
                return null;
            }
            return transformsTypeFind_element_user;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public String getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TYPE$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public String getURI() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(URI$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$6) != null;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public boolean isSetTransforms() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TRANSFORMS$0) != 0;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$10) != null;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public boolean isSetURI() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$8) != null;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void setDigestMethod(DigestMethodType digestMethodType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTMETHOD$2;
            DigestMethodType digestMethodTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (digestMethodTypeFind_element_user == null) {
                digestMethodTypeFind_element_user = (DigestMethodType) get_store().add_element_user(qName);
            }
            digestMethodTypeFind_element_user.set(digestMethodType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void setDigestValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTVALUE$4;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void setTransforms(TransformsType transformsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSFORMS$0;
            TransformsType transformsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (transformsTypeFind_element_user == null) {
                transformsTypeFind_element_user = (TransformsType) get_store().add_element_user(qName);
            }
            transformsTypeFind_element_user.set(transformsType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void setType(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void setURI(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$6);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void unsetTransforms() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRANSFORMS$0, 0);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$10);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void unsetURI() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$8);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public DigestValueType xgetDigestValue() {
        DigestValueType digestValueTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            digestValueTypeFind_element_user = get_store().find_element_user(DIGESTVALUE$4, 0);
        }
        return digestValueTypeFind_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$6);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public XmlAnyURI xgetType() {
        XmlAnyURI xmlAnyURIFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIFind_attribute_user = get_store().find_attribute_user(TYPE$10);
        }
        return xmlAnyURIFind_attribute_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public XmlAnyURI xgetURI() {
        XmlAnyURI xmlAnyURIFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIFind_attribute_user = get_store().find_attribute_user(URI$8);
        }
        return xmlAnyURIFind_attribute_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void xsetDigestValue(DigestValueType digestValueType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTVALUE$4;
            DigestValueType digestValueTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (digestValueTypeFind_element_user == null) {
                digestValueTypeFind_element_user = (DigestValueType) get_store().add_element_user(qName);
            }
            digestValueTypeFind_element_user.set(digestValueType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIDFind_attribute_user == null) {
                xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlIDFind_attribute_user.set(xmlID);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void xsetType(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$10;
            XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlAnyURIFind_attribute_user == null) {
                xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURIFind_attribute_user.set(xmlAnyURI);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void xsetURI(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$8;
            XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlAnyURIFind_attribute_user == null) {
                xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURIFind_attribute_user.set(xmlAnyURI);
        }
    }
}
