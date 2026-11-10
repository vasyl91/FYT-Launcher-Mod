package org.apache.xmlbeans.impl.xb.ltgfmt.impl;

import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class TestCaseImpl extends XmlComplexContentImpl implements TestCase {
    private static final long serialVersionUID = 1;
    private static final QName DESCRIPTION$0 = new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "description");
    private static final QName FILES$2 = new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "files");
    private static final QName ID$4 = new QName("", "id");
    private static final QName ORIGIN$6 = new QName("", "origin");
    private static final QName MODIFIED$8 = new QName("", "modified");

    public TestCaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public String getDescription() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(DESCRIPTION$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public XmlString xgetDescription() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(DESCRIPTION$0, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean isSetDescription() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DESCRIPTION$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setDescription(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DESCRIPTION$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void xsetDescription(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DESCRIPTION$0;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void unsetDescription() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DESCRIPTION$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public TestCase.Files getFiles() {
        synchronized (monitor()) {
            check_orphaned();
            TestCase.Files files = (TestCase.Files) get_store().find_element_user(FILES$2, 0);
            if (files == null) {
                return null;
            }
            return files;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setFiles(TestCase.Files files) {
        generatedSetterHelperImpl(files, FILES$2, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public TestCase.Files addNewFiles() {
        TestCase.Files files;
        synchronized (monitor()) {
            check_orphaned();
            files = (TestCase.Files) get_store().add_element_user(FILES$2);
        }
        return files;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$4);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$4) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$4;
            XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIDFind_attribute_user == null) {
                xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlIDFind_attribute_user.set(xmlID);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$4);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public String getOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ORIGIN$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public XmlToken xgetOrigin() {
        XmlToken xmlTokenFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlTokenFind_attribute_user = get_store().find_attribute_user(ORIGIN$6);
        }
        return xmlTokenFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean isSetOrigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ORIGIN$6) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setOrigin(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIGIN$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void xsetOrigin(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIGIN$6;
            XmlToken xmlTokenFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlTokenFind_attribute_user == null) {
                xmlTokenFind_attribute_user = (XmlToken) get_store().add_attribute_user(qName);
            }
            xmlTokenFind_attribute_user.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void unsetOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ORIGIN$6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean getModified() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MODIFIED$8);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public XmlBoolean xgetModified() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(MODIFIED$8);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public boolean isSetModified() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MODIFIED$8) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void setModified(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MODIFIED$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void xsetModified(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MODIFIED$8;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
    public void unsetModified() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MODIFIED$8);
        }
    }

    public static class FilesImpl extends XmlComplexContentImpl implements TestCase.Files {
        private static final QName FILE$0 = new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "file");
        private static final long serialVersionUID = 1;

        public FilesImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public FileDesc[] getFileArray() {
            FileDesc[] fileDescArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(FILE$0, arrayList);
                fileDescArr = new FileDesc[arrayList.size()];
                arrayList.toArray(fileDescArr);
            }
            return fileDescArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public FileDesc getFileArray(int i) {
            FileDesc fileDesc;
            synchronized (monitor()) {
                check_orphaned();
                fileDesc = (FileDesc) get_store().find_element_user(FILE$0, i);
                if (fileDesc == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return fileDesc;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public int sizeOfFileArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(FILE$0);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public void setFileArray(FileDesc[] fileDescArr) {
            check_orphaned();
            arraySetterHelper(fileDescArr, FILE$0);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public void setFileArray(int i, FileDesc fileDesc) {
            generatedSetterHelperImpl(fileDesc, FILE$0, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public FileDesc insertNewFile(int i) {
            FileDesc fileDesc;
            synchronized (monitor()) {
                check_orphaned();
                fileDesc = (FileDesc) get_store().insert_element_user(FILE$0, i);
            }
            return fileDesc;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public FileDesc addNewFile() {
            FileDesc fileDesc;
            synchronized (monitor()) {
                check_orphaned();
                fileDesc = (FileDesc) get_store().add_element_user(FILE$0);
            }
            return fileDesc;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files
        public void removeFile(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(FILE$0, i);
            }
        }
    }
}
