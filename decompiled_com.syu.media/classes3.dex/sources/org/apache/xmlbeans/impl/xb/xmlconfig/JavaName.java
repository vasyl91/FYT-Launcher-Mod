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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface JavaName extends XmlToken {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(JavaName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLCONFIG").resolveHandle("javanamee640type");

    public static final class Factory {
        public static JavaName newValue(Object obj) {
            return JavaName.type.newValue(obj);
        }

        public static JavaName newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(JavaName.type, (XmlOptions) null);
        }

        public static JavaName newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(JavaName.type, xmlOptions);
        }

        public static JavaName parse(String str) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(str, JavaName.type, xmlOptions);
        }

        public static JavaName parse(File file) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(file, JavaName.type, xmlOptions);
        }

        public static JavaName parse(URL url) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(url, JavaName.type, xmlOptions);
        }

        public static JavaName parse(InputStream inputStream) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(inputStream, JavaName.type, xmlOptions);
        }

        public static JavaName parse(Reader reader) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return XmlBeans.getContextTypeLoader().parse(reader, JavaName.type, xmlOptions);
        }

        public static JavaName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, JavaName.type, xmlOptions);
        }

        public static JavaName parse(Node node) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return XmlBeans.getContextTypeLoader().parse(node, JavaName.type, xmlOptions);
        }

        public static JavaName parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, JavaName.type, (XmlOptions) null);
        }

        public static JavaName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, JavaName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, JavaName.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, JavaName.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
