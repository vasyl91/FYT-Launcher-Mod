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
public interface ComplexTypeDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ComplexTypeDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("complextype83cbdoctype");

    TopLevelComplexType addNewComplexType();

    TopLevelComplexType getComplexType();

    void setComplexType(TopLevelComplexType topLevelComplexType);

    public static final class Factory {
        public static ComplexTypeDocument newInstance() {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().newInstance(ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument newInstance(XmlOptions xmlOptions) {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().newInstance(ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(String str) throws XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(str, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(str, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(File file) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(file, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(file, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(URL url) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(url, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(url, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(Reader reader) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(reader, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(reader, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(Node node) throws XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(node, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(node, ComplexTypeDocument.type, xmlOptions);
        }

        public static ComplexTypeDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static ComplexTypeDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ComplexTypeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, ComplexTypeDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ComplexTypeDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, ComplexTypeDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
