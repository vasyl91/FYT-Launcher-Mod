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
public interface SimpleExplicitGroup extends ExplicitGroup {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SimpleExplicitGroup.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simpleexplicitgroup428ctype");

    public static final class Factory {
        public static SimpleExplicitGroup newInstance() {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().newInstance(SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup newInstance(XmlOptions xmlOptions) {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().newInstance(SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(String str) throws XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(str, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(str, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(File file) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(file, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(file, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(URL url) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(url, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(url, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(InputStream inputStream) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(Reader reader) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(reader, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(reader, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(Node node) throws XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(node, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(node, SimpleExplicitGroup.type, xmlOptions);
        }

        public static SimpleExplicitGroup parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static SimpleExplicitGroup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SimpleExplicitGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleExplicitGroup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleExplicitGroup.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleExplicitGroup.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
