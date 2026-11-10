package org.apache.xmlbeans.impl.xb.xsdownload.impl;

import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class DownloadedSchemaEntryImpl extends XmlComplexContentImpl implements DownloadedSchemaEntry {
    private static final long serialVersionUID = 1;
    private static final QName FILENAME$0 = new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "filename");
    private static final QName SHA1$2 = new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "sha1");
    private static final QName SCHEMALOCATION$4 = new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "schemaLocation");
    private static final QName NAMESPACE$6 = new QName("http://www.bea.com/2003/01/xmlbean/xsdownload", "namespace");

    public DownloadedSchemaEntryImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String getFilename() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(FILENAME$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlToken xgetFilename() {
        XmlToken xmlTokenFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlTokenFind_element_user = get_store().find_element_user(FILENAME$0, 0);
        }
        return xmlTokenFind_element_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setFilename(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILENAME$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetFilename(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILENAME$0;
            XmlToken xmlTokenFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlTokenFind_element_user == null) {
                xmlTokenFind_element_user = (XmlToken) get_store().add_element_user(qName);
            }
            xmlTokenFind_element_user.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String getSha1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SHA1$2, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlToken xgetSha1() {
        XmlToken xmlTokenFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlTokenFind_element_user = get_store().find_element_user(SHA1$2, 0);
        }
        return xmlTokenFind_element_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setSha1(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHA1$2;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetSha1(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHA1$2;
            XmlToken xmlTokenFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlTokenFind_element_user == null) {
                xmlTokenFind_element_user = (XmlToken) get_store().add_element_user(qName);
            }
            xmlTokenFind_element_user.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String[] getSchemaLocationArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCHEMALOCATION$4, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String getSchemaLocationArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SCHEMALOCATION$4, i);
            if (simpleValueFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValueFind_element_user.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI[] xgetSchemaLocationArray() {
        XmlAnyURI[] xmlAnyURIArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCHEMALOCATION$4, arrayList);
            xmlAnyURIArr = new XmlAnyURI[arrayList.size()];
            arrayList.toArray(xmlAnyURIArr);
        }
        return xmlAnyURIArr;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI xgetSchemaLocationArray(int i) {
        XmlAnyURI xmlAnyURIFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIFind_element_user = get_store().find_element_user(SCHEMALOCATION$4, i);
            if (xmlAnyURIFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlAnyURIFind_element_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public int sizeOfSchemaLocationArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SCHEMALOCATION$4);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setSchemaLocationArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, SCHEMALOCATION$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setSchemaLocationArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SCHEMALOCATION$4, i);
            if (simpleValueFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetSchemaLocationArray(XmlAnyURI[] xmlAnyURIArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) xmlAnyURIArr, SCHEMALOCATION$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetSchemaLocationArray(int i, XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            XmlAnyURI xmlAnyURIFind_element_user = get_store().find_element_user(SCHEMALOCATION$4, i);
            if (xmlAnyURIFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlAnyURIFind_element_user.set(xmlAnyURI);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void insertSchemaLocation(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().insert_element_user(SCHEMALOCATION$4, i).setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void addSchemaLocation(String str) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().add_element_user(SCHEMALOCATION$4).setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI insertNewSchemaLocation(int i) {
        XmlAnyURI xmlAnyURIInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIInsert_element_user = get_store().insert_element_user(SCHEMALOCATION$4, i);
        }
        return xmlAnyURIInsert_element_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI addNewSchemaLocation() {
        XmlAnyURI xmlAnyURIAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIAdd_element_user = get_store().add_element_user(SCHEMALOCATION$4);
        }
        return xmlAnyURIAdd_element_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void removeSchemaLocation(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCHEMALOCATION$4, i);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public String getNamespace() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(NAMESPACE$6, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public XmlAnyURI xgetNamespace() {
        XmlAnyURI xmlAnyURIFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIFind_element_user = get_store().find_element_user(NAMESPACE$6, 0);
        }
        return xmlAnyURIFind_element_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public boolean isSetNamespace() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NAMESPACE$6) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void setNamespace(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMESPACE$6;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void xsetNamespace(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMESPACE$6;
            XmlAnyURI xmlAnyURIFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlAnyURIFind_element_user == null) {
                xmlAnyURIFind_element_user = (XmlAnyURI) get_store().add_element_user(qName);
            }
            xmlAnyURIFind_element_user.set(xmlAnyURI);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry
    public void unsetNamespace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NAMESPACE$6, 0);
        }
    }
}
