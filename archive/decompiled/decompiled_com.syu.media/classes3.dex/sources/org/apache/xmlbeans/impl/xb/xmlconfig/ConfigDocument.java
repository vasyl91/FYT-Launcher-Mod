package org.apache.xmlbeans.impl.xb.xmlconfig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface ConfigDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ConfigDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("config4185doctype");

    Config addNewConfig();

    Config getConfig();

    void setConfig(Config config);

    public interface Config extends XmlObject {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Config.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("configf467elemtype");

        Extensionconfig addNewExtension();

        Nsconfig addNewNamespace();

        Qnameconfig addNewQname();

        Usertypeconfig addNewUsertype();

        Extensionconfig getExtensionArray(int i);

        Extensionconfig[] getExtensionArray();

        Nsconfig getNamespaceArray(int i);

        Nsconfig[] getNamespaceArray();

        Qnameconfig getQnameArray(int i);

        Qnameconfig[] getQnameArray();

        Usertypeconfig getUsertypeArray(int i);

        Usertypeconfig[] getUsertypeArray();

        Extensionconfig insertNewExtension(int i);

        Nsconfig insertNewNamespace(int i);

        Qnameconfig insertNewQname(int i);

        Usertypeconfig insertNewUsertype(int i);

        void removeExtension(int i);

        void removeNamespace(int i);

        void removeQname(int i);

        void removeUsertype(int i);

        void setExtensionArray(int i, Extensionconfig extensionconfig);

        void setExtensionArray(Extensionconfig[] extensionconfigArr);

        void setNamespaceArray(int i, Nsconfig nsconfig);

        void setNamespaceArray(Nsconfig[] nsconfigArr);

        void setQnameArray(int i, Qnameconfig qnameconfig);

        void setQnameArray(Qnameconfig[] qnameconfigArr);

        void setUsertypeArray(int i, Usertypeconfig usertypeconfig);

        void setUsertypeArray(Usertypeconfig[] usertypeconfigArr);

        int sizeOfExtensionArray();

        int sizeOfNamespaceArray();

        int sizeOfQnameArray();

        int sizeOfUsertypeArray();

        public static final class Factory {
            public static Config newInstance() {
                return (Config) XmlBeans.getContextTypeLoader().newInstance(Config.type, (XmlOptions) null);
            }

            public static Config newInstance(XmlOptions xmlOptions) {
                return (Config) XmlBeans.getContextTypeLoader().newInstance(Config.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static ConfigDocument newInstance() {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().newInstance(ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument newInstance(XmlOptions xmlOptions) {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().newInstance(ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(String str) throws XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(str, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(str, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(File file) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(file, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(file, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(URL url) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(url, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(url, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(Reader reader) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(reader, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(reader, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(Node node) throws XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(node, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(node, ConfigDocument.type, xmlOptions);
        }

        public static ConfigDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ConfigDocument.type, (XmlOptions) null);
        }

        public static ConfigDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ConfigDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ConfigDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ConfigDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ConfigDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
