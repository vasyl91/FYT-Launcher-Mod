package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ConfigDocumentImpl extends XmlComplexContentImpl implements ConfigDocument {
    private static final QName CONFIG$0 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "config");
    private static final long serialVersionUID = 1;

    public ConfigDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument
    public ConfigDocument.Config getConfig() {
        synchronized (monitor()) {
            check_orphaned();
            ConfigDocument.Config config = (ConfigDocument.Config) get_store().find_element_user(CONFIG$0, 0);
            if (config == null) {
                return null;
            }
            return config;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument
    public void setConfig(ConfigDocument.Config config) {
        generatedSetterHelperImpl(config, CONFIG$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument
    public ConfigDocument.Config addNewConfig() {
        ConfigDocument.Config config;
        synchronized (monitor()) {
            check_orphaned();
            config = (ConfigDocument.Config) get_store().add_element_user(CONFIG$0);
        }
        return config;
    }

    public static class ConfigImpl extends XmlComplexContentImpl implements ConfigDocument.Config {
        private static final long serialVersionUID = 1;
        private static final QName NAMESPACE$0 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "namespace");
        private static final QName QNAME$2 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "qname");
        private static final QName EXTENSION$4 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "extension");
        private static final QName USERTYPE$6 = new QName("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "usertype");

        public ConfigImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Nsconfig[] getNamespaceArray() {
            Nsconfig[] nsconfigArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(NAMESPACE$0, arrayList);
                nsconfigArr = new Nsconfig[arrayList.size()];
                arrayList.toArray(nsconfigArr);
            }
            return nsconfigArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Nsconfig getNamespaceArray(int i) {
            Nsconfig nsconfig;
            synchronized (monitor()) {
                check_orphaned();
                nsconfig = (Nsconfig) get_store().find_element_user(NAMESPACE$0, i);
                if (nsconfig == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return nsconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public int sizeOfNamespaceArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(NAMESPACE$0);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setNamespaceArray(Nsconfig[] nsconfigArr) {
            check_orphaned();
            arraySetterHelper(nsconfigArr, NAMESPACE$0);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setNamespaceArray(int i, Nsconfig nsconfig) {
            generatedSetterHelperImpl(nsconfig, NAMESPACE$0, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Nsconfig insertNewNamespace(int i) {
            Nsconfig nsconfig;
            synchronized (monitor()) {
                check_orphaned();
                nsconfig = (Nsconfig) get_store().insert_element_user(NAMESPACE$0, i);
            }
            return nsconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Nsconfig addNewNamespace() {
            Nsconfig nsconfig;
            synchronized (monitor()) {
                check_orphaned();
                nsconfig = (Nsconfig) get_store().add_element_user(NAMESPACE$0);
            }
            return nsconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void removeNamespace(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(NAMESPACE$0, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Qnameconfig[] getQnameArray() {
            Qnameconfig[] qnameconfigArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(QNAME$2, arrayList);
                qnameconfigArr = new Qnameconfig[arrayList.size()];
                arrayList.toArray(qnameconfigArr);
            }
            return qnameconfigArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Qnameconfig getQnameArray(int i) {
            Qnameconfig qnameconfig;
            synchronized (monitor()) {
                check_orphaned();
                qnameconfig = (Qnameconfig) get_store().find_element_user(QNAME$2, i);
                if (qnameconfig == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return qnameconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public int sizeOfQnameArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(QNAME$2);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setQnameArray(Qnameconfig[] qnameconfigArr) {
            check_orphaned();
            arraySetterHelper(qnameconfigArr, QNAME$2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setQnameArray(int i, Qnameconfig qnameconfig) {
            generatedSetterHelperImpl(qnameconfig, QNAME$2, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Qnameconfig insertNewQname(int i) {
            Qnameconfig qnameconfig;
            synchronized (monitor()) {
                check_orphaned();
                qnameconfig = (Qnameconfig) get_store().insert_element_user(QNAME$2, i);
            }
            return qnameconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Qnameconfig addNewQname() {
            Qnameconfig qnameconfig;
            synchronized (monitor()) {
                check_orphaned();
                qnameconfig = (Qnameconfig) get_store().add_element_user(QNAME$2);
            }
            return qnameconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void removeQname(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(QNAME$2, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Extensionconfig[] getExtensionArray() {
            Extensionconfig[] extensionconfigArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(EXTENSION$4, arrayList);
                extensionconfigArr = new Extensionconfig[arrayList.size()];
                arrayList.toArray(extensionconfigArr);
            }
            return extensionconfigArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Extensionconfig getExtensionArray(int i) {
            Extensionconfig extensionconfig;
            synchronized (monitor()) {
                check_orphaned();
                extensionconfig = (Extensionconfig) get_store().find_element_user(EXTENSION$4, i);
                if (extensionconfig == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return extensionconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public int sizeOfExtensionArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(EXTENSION$4);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setExtensionArray(Extensionconfig[] extensionconfigArr) {
            check_orphaned();
            arraySetterHelper(extensionconfigArr, EXTENSION$4);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setExtensionArray(int i, Extensionconfig extensionconfig) {
            generatedSetterHelperImpl(extensionconfig, EXTENSION$4, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Extensionconfig insertNewExtension(int i) {
            Extensionconfig extensionconfig;
            synchronized (monitor()) {
                check_orphaned();
                extensionconfig = (Extensionconfig) get_store().insert_element_user(EXTENSION$4, i);
            }
            return extensionconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Extensionconfig addNewExtension() {
            Extensionconfig extensionconfig;
            synchronized (monitor()) {
                check_orphaned();
                extensionconfig = (Extensionconfig) get_store().add_element_user(EXTENSION$4);
            }
            return extensionconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void removeExtension(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(EXTENSION$4, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Usertypeconfig[] getUsertypeArray() {
            Usertypeconfig[] usertypeconfigArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(USERTYPE$6, arrayList);
                usertypeconfigArr = new Usertypeconfig[arrayList.size()];
                arrayList.toArray(usertypeconfigArr);
            }
            return usertypeconfigArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Usertypeconfig getUsertypeArray(int i) {
            Usertypeconfig usertypeconfig;
            synchronized (monitor()) {
                check_orphaned();
                usertypeconfig = (Usertypeconfig) get_store().find_element_user(USERTYPE$6, i);
                if (usertypeconfig == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return usertypeconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public int sizeOfUsertypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(USERTYPE$6);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setUsertypeArray(Usertypeconfig[] usertypeconfigArr) {
            check_orphaned();
            arraySetterHelper(usertypeconfigArr, USERTYPE$6);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void setUsertypeArray(int i, Usertypeconfig usertypeconfig) {
            generatedSetterHelperImpl(usertypeconfig, USERTYPE$6, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Usertypeconfig insertNewUsertype(int i) {
            Usertypeconfig usertypeconfig;
            synchronized (monitor()) {
                check_orphaned();
                usertypeconfig = (Usertypeconfig) get_store().insert_element_user(USERTYPE$6, i);
            }
            return usertypeconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public Usertypeconfig addNewUsertype() {
            Usertypeconfig usertypeconfig;
            synchronized (monitor()) {
                check_orphaned();
                usertypeconfig = (Usertypeconfig) get_store().add_element_user(USERTYPE$6);
            }
            return usertypeconfig;
        }

        @Override // org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config
        public void removeUsertype(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(USERTYPE$6, i);
            }
        }
    }
}
