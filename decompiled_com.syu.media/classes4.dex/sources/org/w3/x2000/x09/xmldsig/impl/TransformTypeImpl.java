package org.w3.x2000.x09.xmldsig.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.TransformType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class TransformTypeImpl extends XmlComplexContentImpl implements TransformType {
    private static final QName XPATH$0 = new QName("http://www.w3.org/2000/09/xmldsig#", "XPath");
    private static final QName ALGORITHM$2 = new QName("", "Algorithm");

    public TransformTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public XmlString addNewXPath() {
        XmlString xmlStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringAdd_element_user = get_store().add_element_user(XPATH$0);
        }
        return xmlStringAdd_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void addXPath(String str) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().add_element_user(XPATH$0).setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public String getAlgorithm() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALGORITHM$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public String getXPathArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(XPATH$0, i);
            if (simpleValueFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValueFind_element_user.getStringValue();
        }
        return stringValue;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public String[] getXPathArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(XPATH$0, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public List<String> getXPathList() {
        1XPathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1XPathList(this);
        }
        return r1;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public XmlString insertNewXPath(int i) {
        XmlString xmlStringInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringInsert_element_user = get_store().insert_element_user(XPATH$0, i);
        }
        return xmlStringInsert_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void insertXPath(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().insert_element_user(XPATH$0, i).setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void removeXPath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(XPATH$0, i);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void setAlgorithm(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGORITHM$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void setXPathArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(XPATH$0, i);
            if (simpleValueFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void setXPathArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, XPATH$0);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public int sizeOfXPathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(XPATH$0);
        }
        return iCount_elements;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public XmlAnyURI xgetAlgorithm() {
        XmlAnyURI xmlAnyURIFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIFind_attribute_user = get_store().find_attribute_user(ALGORITHM$2);
        }
        return xmlAnyURIFind_attribute_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public XmlString xgetXPathArray(int i) {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(XPATH$0, i);
            if (xmlStringFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlStringFind_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public XmlString[] xgetXPathArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(XPATH$0, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public List<XmlString> xgetXPathList() {
        2XPathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2XPathList(this);
        }
        return r1;
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void xsetAlgorithm(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGORITHM$2;
            XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlAnyURIFind_attribute_user == null) {
                xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURIFind_attribute_user.set(xmlAnyURI);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void xsetXPathArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlStringFind_element_user = get_store().find_element_user(XPATH$0, i);
            if (xmlStringFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.TransformType
    public void xsetXPathArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, XPATH$0);
        }
    }
}
