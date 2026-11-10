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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface Public extends XmlToken {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Public.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("publicf3catype");

    public static final class Factory {
        public static Public newValue(Object obj) {
            return Public.type.newValue(obj);
        }

        public static Public newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(Public.type, (XmlOptions) null);
        }

        public static Public newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(Public.type, xmlOptions);
        }

        public static Public parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, Public.type, (XmlOptions) null);
        }

        public static Public parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, Public.type, xmlOptions);
        }

        public static Public parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, Public.type, (XmlOptions) null);
        }

        public static Public parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, Public.type, xmlOptions);
        }

        public static Public parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, Public.type, (XmlOptions) null);
        }

        public static Public parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, Public.type, xmlOptions);
        }

        public static Public parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, Public.type, (XmlOptions) null);
        }

        public static Public parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, Public.type, xmlOptions);
        }

        public static Public parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, Public.type, (XmlOptions) null);
        }

        public static Public parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, Public.type, xmlOptions);
        }

        public static Public parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Public.type, (XmlOptions) null);
        }

        public static Public parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, Public.type, xmlOptions);
        }

        public static Public parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, Public.type, (XmlOptions) null);
        }

        public static Public parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, Public.type, xmlOptions);
        }

        public static Public parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, Public.type, (XmlOptions) null);
        }

        public static Public parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, Public.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Public.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, Public.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
