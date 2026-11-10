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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface Extensionconfig extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Extensionconfig.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("extensionconfig2ac2type");

    Interface addNewInterface();

    PrePostSet addNewPrePostSet();

    Object getFor();

    Interface getInterfaceArray(int i);

    Interface[] getInterfaceArray();

    PrePostSet getPrePostSet();

    Interface insertNewInterface(int i);

    boolean isSetFor();

    boolean isSetPrePostSet();

    void removeInterface(int i);

    void setFor(Object obj);

    void setInterfaceArray(int i, Interface r2);

    void setInterfaceArray(Interface[] interfaceArr);

    void setPrePostSet(PrePostSet prePostSet);

    int sizeOfInterfaceArray();

    void unsetFor();

    void unsetPrePostSet();

    JavaNameList xgetFor();

    void xsetFor(JavaNameList javaNameList);

    public interface Interface extends XmlObject {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Interface.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("interface02a7elemtype");

        String getName();

        String getStaticHandler();

        boolean isSetName();

        void setName(String str);

        void setStaticHandler(String str);

        void unsetName();

        XmlString xgetName();

        XmlString xgetStaticHandler();

        void xsetName(XmlString xmlString);

        void xsetStaticHandler(XmlString xmlString);

        public static final class Factory {
            public static Interface newInstance() {
                return (Interface) XmlBeans.getContextTypeLoader().newInstance(Interface.type, (XmlOptions) null);
            }

            public static Interface newInstance(XmlOptions xmlOptions) {
                return (Interface) XmlBeans.getContextTypeLoader().newInstance(Interface.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public interface PrePostSet extends XmlObject {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(PrePostSet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("prepostset5c9delemtype");

        String getStaticHandler();

        void setStaticHandler(String str);

        XmlString xgetStaticHandler();

        void xsetStaticHandler(XmlString xmlString);

        public static final class Factory {
            public static PrePostSet newInstance() {
                return (PrePostSet) XmlBeans.getContextTypeLoader().newInstance(PrePostSet.type, (XmlOptions) null);
            }

            public static PrePostSet newInstance(XmlOptions xmlOptions) {
                return (PrePostSet) XmlBeans.getContextTypeLoader().newInstance(PrePostSet.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static Extensionconfig newInstance() {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().newInstance(Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig newInstance(XmlOptions xmlOptions) {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().newInstance(Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(String str) throws XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(str, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(str, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(File file) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(file, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(file, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(URL url) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(url, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(url, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(InputStream inputStream) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(inputStream, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(inputStream, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(Reader reader) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(reader, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(reader, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(Node node) throws XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(node, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(node, Extensionconfig.type, xmlOptions);
        }

        public static Extensionconfig parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Extensionconfig.type, (XmlOptions) null);
        }

        public static Extensionconfig parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (Extensionconfig) XmlBeans.getContextTypeLoader().parse(xMLInputStream, Extensionconfig.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Extensionconfig.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Extensionconfig.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
