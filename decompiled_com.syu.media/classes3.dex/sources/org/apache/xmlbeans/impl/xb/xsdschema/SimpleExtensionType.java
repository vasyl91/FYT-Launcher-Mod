package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface SimpleExtensionType extends ExtensionType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SimpleExtensionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simpleextensiontypee0detype");

    public static final class Factory {
        public static SimpleExtensionType newInstance() {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().newInstance(SimpleExtensionType.type, (XmlOptions) null);
        }

        public static SimpleExtensionType newInstance(XmlOptions xmlOptions) {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().newInstance(SimpleExtensionType.type, xmlOptions);
        }

        public static SimpleExtensionType parse(String str) throws XmlException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(str, SimpleExtensionType.type, (XmlOptions) null);
        }

        public static SimpleExtensionType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(str, SimpleExtensionType.type, xmlOptions);
        }

        public static SimpleExtensionType parse(File file) throws XmlException, IOException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(file, SimpleExtensionType.type, (XmlOptions) null);
        }

        public static SimpleExtensionType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(file, SimpleExtensionType.type, xmlOptions);
        }

        public static SimpleExtensionType parse(URL url) throws XmlException, IOException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(url, SimpleExtensionType.type, (XmlOptions) null);
        }

        public static SimpleExtensionType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(url, SimpleExtensionType.type, xmlOptions);
        }

        public static SimpleExtensionType parse(InputStream inputStream) throws XmlException, IOException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleExtensionType.type, (XmlOptions) null);
        }

        public static SimpleExtensionType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleExtensionType.type, xmlOptions);
        }

        public static SimpleExtensionType parse(Reader reader) throws XmlException, IOException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(reader, SimpleExtensionType.type, (XmlOptions) null);
        }

        public static SimpleExtensionType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(reader, SimpleExtensionType.type, xmlOptions);
        }

        public static SimpleExtensionType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleExtensionType.type, (XmlOptions) null);
        }

        public static SimpleExtensionType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleExtensionType.type, xmlOptions);
        }

        public static SimpleExtensionType parse(Node node) throws XmlException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(node, SimpleExtensionType.type, (XmlOptions) null);
        }

        public static SimpleExtensionType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(node, SimpleExtensionType.type, xmlOptions);
        }

        public static SimpleExtensionType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleExtensionType.type, (XmlOptions) null);
        }

        public static SimpleExtensionType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SimpleExtensionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleExtensionType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleExtensionType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleExtensionType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
