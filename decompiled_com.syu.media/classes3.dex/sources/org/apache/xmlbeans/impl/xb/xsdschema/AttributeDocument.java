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
public interface AttributeDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(AttributeDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attributeedb9doctype");

    TopLevelAttribute addNewAttribute();

    TopLevelAttribute getAttribute();

    void setAttribute(TopLevelAttribute topLevelAttribute);

    public static final class Factory {
        public static AttributeDocument newInstance() {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().newInstance(AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument newInstance(XmlOptions xmlOptions) {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().newInstance(AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(String str) throws XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(str, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(str, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(File file) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(file, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(file, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(URL url) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(url, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(url, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(Reader reader) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(reader, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(reader, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(Node node) throws XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(node, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(node, AttributeDocument.type, xmlOptions);
        }

        public static AttributeDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeDocument.type, (XmlOptions) null);
        }

        public static AttributeDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (AttributeDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
