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
public interface LocalElement extends Element {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(LocalElement.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("localelement2ce2type");

    public static final class Factory {
        public static LocalElement newInstance() {
            return (LocalElement) XmlBeans.getContextTypeLoader().newInstance(LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement newInstance(XmlOptions xmlOptions) {
            return (LocalElement) XmlBeans.getContextTypeLoader().newInstance(LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(String str) throws XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(str, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(str, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(File file) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(file, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(file, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(URL url) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(url, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(url, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(InputStream inputStream) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(inputStream, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(inputStream, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(Reader reader) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(reader, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(reader, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(Node node) throws XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(node, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(node, LocalElement.type, xmlOptions);
        }

        public static LocalElement parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LocalElement.type, (XmlOptions) null);
        }

        public static LocalElement parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (LocalElement) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LocalElement.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LocalElement.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LocalElement.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
