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
public interface SimpleRestrictionType extends RestrictionType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SimpleRestrictionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("simplerestrictiontypeeab1type");

    public static final class Factory {
        public static SimpleRestrictionType newInstance() {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().newInstance(SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType newInstance(XmlOptions xmlOptions) {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().newInstance(SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(String str) throws XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(str, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(str, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(File file) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(file, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(file, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(URL url) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(url, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(url, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(InputStream inputStream) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(inputStream, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(Reader reader) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(reader, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(reader, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(Node node) throws XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(node, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(node, SimpleRestrictionType.type, xmlOptions);
        }

        public static SimpleRestrictionType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static SimpleRestrictionType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SimpleRestrictionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, SimpleRestrictionType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleRestrictionType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, SimpleRestrictionType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
