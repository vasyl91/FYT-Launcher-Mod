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
public interface LocalSimpleType extends SimpleType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(LocalSimpleType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("localsimpletype410etype");

    public static final class Factory {
        public static LocalSimpleType newInstance() {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().newInstance(LocalSimpleType.type, (XmlOptions) null);
        }

        public static LocalSimpleType newInstance(XmlOptions xmlOptions) {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().newInstance(LocalSimpleType.type, xmlOptions);
        }

        public static LocalSimpleType parse(String str) throws XmlException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(str, LocalSimpleType.type, (XmlOptions) null);
        }

        public static LocalSimpleType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(str, LocalSimpleType.type, xmlOptions);
        }

        public static LocalSimpleType parse(File file) throws XmlException, IOException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(file, LocalSimpleType.type, (XmlOptions) null);
        }

        public static LocalSimpleType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(file, LocalSimpleType.type, xmlOptions);
        }

        public static LocalSimpleType parse(URL url) throws XmlException, IOException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(url, LocalSimpleType.type, (XmlOptions) null);
        }

        public static LocalSimpleType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(url, LocalSimpleType.type, xmlOptions);
        }

        public static LocalSimpleType parse(InputStream inputStream) throws XmlException, IOException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(inputStream, LocalSimpleType.type, (XmlOptions) null);
        }

        public static LocalSimpleType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(inputStream, LocalSimpleType.type, xmlOptions);
        }

        public static LocalSimpleType parse(Reader reader) throws XmlException, IOException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(reader, LocalSimpleType.type, (XmlOptions) null);
        }

        public static LocalSimpleType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(reader, LocalSimpleType.type, xmlOptions);
        }

        public static LocalSimpleType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LocalSimpleType.type, (XmlOptions) null);
        }

        public static LocalSimpleType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LocalSimpleType.type, xmlOptions);
        }

        public static LocalSimpleType parse(Node node) throws XmlException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(node, LocalSimpleType.type, (XmlOptions) null);
        }

        public static LocalSimpleType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(node, LocalSimpleType.type, xmlOptions);
        }

        public static LocalSimpleType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LocalSimpleType.type, (XmlOptions) null);
        }

        public static LocalSimpleType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (LocalSimpleType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LocalSimpleType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LocalSimpleType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LocalSimpleType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
