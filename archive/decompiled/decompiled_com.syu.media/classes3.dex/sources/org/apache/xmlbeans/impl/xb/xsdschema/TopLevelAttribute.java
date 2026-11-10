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
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface TopLevelAttribute extends Attribute {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TopLevelAttribute.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("toplevelattributeb338type");

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    void xsetName(XmlNCName xmlNCName);

    public static final class Factory {
        public static TopLevelAttribute newInstance() {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().newInstance(TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute newInstance(XmlOptions xmlOptions) {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().newInstance(TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(String str) throws XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(str, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(str, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(File file) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(file, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(file, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(URL url) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(url, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(url, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(InputStream inputStream) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(Reader reader) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(reader, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(reader, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(Node node) throws XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(node, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(node, TopLevelAttribute.type, xmlOptions);
        }

        public static TopLevelAttribute parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static TopLevelAttribute parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (TopLevelAttribute) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelAttribute.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelAttribute.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelAttribute.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
