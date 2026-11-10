package org.apache.xmlbeans.impl.xb.substwsdl.impl;

import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument;
import org.apache.xmlbeans.impl.xb.substwsdl.TImport;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class DefinitionsDocumentImpl extends XmlComplexContentImpl implements DefinitionsDocument {
    private static final QName DEFINITIONS$0 = new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "definitions");
    private static final long serialVersionUID = 1;

    public DefinitionsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument
    public DefinitionsDocument.Definitions getDefinitions() {
        synchronized (monitor()) {
            check_orphaned();
            DefinitionsDocument.Definitions definitions = (DefinitionsDocument.Definitions) get_store().find_element_user(DEFINITIONS$0, 0);
            if (definitions == null) {
                return null;
            }
            return definitions;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument
    public void setDefinitions(DefinitionsDocument.Definitions definitions) {
        generatedSetterHelperImpl(definitions, DEFINITIONS$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument
    public DefinitionsDocument.Definitions addNewDefinitions() {
        DefinitionsDocument.Definitions definitions;
        synchronized (monitor()) {
            check_orphaned();
            definitions = (DefinitionsDocument.Definitions) get_store().add_element_user(DEFINITIONS$0);
        }
        return definitions;
    }

    public static class DefinitionsImpl extends XmlComplexContentImpl implements DefinitionsDocument.Definitions {
        private static final long serialVersionUID = 1;
        private static final QName IMPORT$0 = new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "import");
        private static final QName TYPES$2 = new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "types");
        private static final QName MESSAGE$4 = new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "message");
        private static final QName BINDING$6 = new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "binding");
        private static final QName PORTTYPE$8 = new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "portType");
        private static final QName SERVICE$10 = new QName("http://www.apache.org/internal/xmlbeans/wsdlsubst", "service");

        public DefinitionsImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public TImport[] getImportArray() {
            TImport[] tImportArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(IMPORT$0, arrayList);
                tImportArr = new TImport[arrayList.size()];
                arrayList.toArray(tImportArr);
            }
            return tImportArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public TImport getImportArray(int i) {
            TImport tImport;
            synchronized (monitor()) {
                check_orphaned();
                tImport = (TImport) get_store().find_element_user(IMPORT$0, i);
                if (tImport == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return tImport;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfImportArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(IMPORT$0);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setImportArray(TImport[] tImportArr) {
            check_orphaned();
            arraySetterHelper(tImportArr, IMPORT$0);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setImportArray(int i, TImport tImport) {
            generatedSetterHelperImpl(tImport, IMPORT$0, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public TImport insertNewImport(int i) {
            TImport tImport;
            synchronized (monitor()) {
                check_orphaned();
                tImport = (TImport) get_store().insert_element_user(IMPORT$0, i);
            }
            return tImport;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public TImport addNewImport() {
            TImport tImport;
            synchronized (monitor()) {
                check_orphaned();
                tImport = (TImport) get_store().add_element_user(IMPORT$0);
            }
            return tImport;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeImport(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(IMPORT$0, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getTypesArray() {
            XmlObject[] xmlObjectArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(TYPES$2, arrayList);
                xmlObjectArr = new XmlObject[arrayList.size()];
                arrayList.toArray(xmlObjectArr);
            }
            return xmlObjectArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getTypesArray(int i) {
            XmlObject xmlObjectFind_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectFind_element_user = get_store().find_element_user(TYPES$2, i);
                if (xmlObjectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return xmlObjectFind_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfTypesArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(TYPES$2);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setTypesArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, TYPES$2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setTypesArray(int i, XmlObject xmlObject) {
            generatedSetterHelperImpl(xmlObject, TYPES$2, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewTypes(int i) {
            XmlObject xmlObjectInsert_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectInsert_element_user = get_store().insert_element_user(TYPES$2, i);
            }
            return xmlObjectInsert_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewTypes() {
            XmlObject xmlObjectAdd_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectAdd_element_user = get_store().add_element_user(TYPES$2);
            }
            return xmlObjectAdd_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeTypes(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(TYPES$2, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getMessageArray() {
            XmlObject[] xmlObjectArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(MESSAGE$4, arrayList);
                xmlObjectArr = new XmlObject[arrayList.size()];
                arrayList.toArray(xmlObjectArr);
            }
            return xmlObjectArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getMessageArray(int i) {
            XmlObject xmlObjectFind_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectFind_element_user = get_store().find_element_user(MESSAGE$4, i);
                if (xmlObjectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return xmlObjectFind_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfMessageArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(MESSAGE$4);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setMessageArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, MESSAGE$4);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setMessageArray(int i, XmlObject xmlObject) {
            generatedSetterHelperImpl(xmlObject, MESSAGE$4, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewMessage(int i) {
            XmlObject xmlObjectInsert_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectInsert_element_user = get_store().insert_element_user(MESSAGE$4, i);
            }
            return xmlObjectInsert_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewMessage() {
            XmlObject xmlObjectAdd_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectAdd_element_user = get_store().add_element_user(MESSAGE$4);
            }
            return xmlObjectAdd_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeMessage(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(MESSAGE$4, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getBindingArray() {
            XmlObject[] xmlObjectArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(BINDING$6, arrayList);
                xmlObjectArr = new XmlObject[arrayList.size()];
                arrayList.toArray(xmlObjectArr);
            }
            return xmlObjectArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getBindingArray(int i) {
            XmlObject xmlObjectFind_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectFind_element_user = get_store().find_element_user(BINDING$6, i);
                if (xmlObjectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return xmlObjectFind_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfBindingArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(BINDING$6);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setBindingArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, BINDING$6);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setBindingArray(int i, XmlObject xmlObject) {
            generatedSetterHelperImpl(xmlObject, BINDING$6, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewBinding(int i) {
            XmlObject xmlObjectInsert_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectInsert_element_user = get_store().insert_element_user(BINDING$6, i);
            }
            return xmlObjectInsert_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewBinding() {
            XmlObject xmlObjectAdd_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectAdd_element_user = get_store().add_element_user(BINDING$6);
            }
            return xmlObjectAdd_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeBinding(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(BINDING$6, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getPortTypeArray() {
            XmlObject[] xmlObjectArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(PORTTYPE$8, arrayList);
                xmlObjectArr = new XmlObject[arrayList.size()];
                arrayList.toArray(xmlObjectArr);
            }
            return xmlObjectArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getPortTypeArray(int i) {
            XmlObject xmlObjectFind_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectFind_element_user = get_store().find_element_user(PORTTYPE$8, i);
                if (xmlObjectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return xmlObjectFind_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfPortTypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PORTTYPE$8);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setPortTypeArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, PORTTYPE$8);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setPortTypeArray(int i, XmlObject xmlObject) {
            generatedSetterHelperImpl(xmlObject, PORTTYPE$8, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewPortType(int i) {
            XmlObject xmlObjectInsert_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectInsert_element_user = get_store().insert_element_user(PORTTYPE$8, i);
            }
            return xmlObjectInsert_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewPortType() {
            XmlObject xmlObjectAdd_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectAdd_element_user = get_store().add_element_user(PORTTYPE$8);
            }
            return xmlObjectAdd_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removePortType(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PORTTYPE$8, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject[] getServiceArray() {
            XmlObject[] xmlObjectArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(SERVICE$10, arrayList);
                xmlObjectArr = new XmlObject[arrayList.size()];
                arrayList.toArray(xmlObjectArr);
            }
            return xmlObjectArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject getServiceArray(int i) {
            XmlObject xmlObjectFind_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectFind_element_user = get_store().find_element_user(SERVICE$10, i);
                if (xmlObjectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return xmlObjectFind_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public int sizeOfServiceArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(SERVICE$10);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setServiceArray(XmlObject[] xmlObjectArr) {
            check_orphaned();
            arraySetterHelper(xmlObjectArr, SERVICE$10);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void setServiceArray(int i, XmlObject xmlObject) {
            generatedSetterHelperImpl(xmlObject, SERVICE$10, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject insertNewService(int i) {
            XmlObject xmlObjectInsert_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectInsert_element_user = get_store().insert_element_user(SERVICE$10, i);
            }
            return xmlObjectInsert_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public XmlObject addNewService() {
            XmlObject xmlObjectAdd_element_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlObjectAdd_element_user = get_store().add_element_user(SERVICE$10);
            }
            return xmlObjectAdd_element_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument.Definitions
        public void removeService(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(SERVICE$10, i);
            }
        }
    }
}
