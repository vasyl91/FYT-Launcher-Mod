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
public interface AttributeGroupDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(AttributeGroupDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("attributegroup4520doctype");

    NamedAttributeGroup addNewAttributeGroup();

    NamedAttributeGroup getAttributeGroup();

    void setAttributeGroup(NamedAttributeGroup namedAttributeGroup);

    public static final class Factory {
        public static AttributeGroupDocument newInstance() {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().newInstance(AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument newInstance(XmlOptions xmlOptions) {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().newInstance(AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(String str) throws XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(str, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(str, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(File file) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(file, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(file, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(URL url) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(url, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(url, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(Reader reader) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(reader, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(reader, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(Node node) throws XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(node, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(node, AttributeGroupDocument.type, xmlOptions);
        }

        public static AttributeGroupDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static AttributeGroupDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (AttributeGroupDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AttributeGroupDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeGroupDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AttributeGroupDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
