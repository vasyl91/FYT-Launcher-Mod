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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface EnumerationDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(EnumerationDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("enumeration052edoctype");

    NoFixedFacet addNewEnumeration();

    NoFixedFacet getEnumeration();

    void setEnumeration(NoFixedFacet noFixedFacet);

    public static final class Factory {
        public static EnumerationDocument newInstance() {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().newInstance(EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument newInstance(XmlOptions xmlOptions) {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().newInstance(EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(String str) throws XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(str, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(str, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(File file) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(file, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(file, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(URL url) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(url, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(url, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(Reader reader) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(reader, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(reader, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(Node node) throws XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(node, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(node, EnumerationDocument.type, xmlOptions);
        }

        public static EnumerationDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, EnumerationDocument.type, (XmlOptions) null);
        }

        public static EnumerationDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (EnumerationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, EnumerationDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, EnumerationDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, EnumerationDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
