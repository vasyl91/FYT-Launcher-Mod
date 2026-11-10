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
public interface TopLevelSimpleType extends SimpleType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TopLevelSimpleType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("toplevelsimpletypec958type");

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    void xsetName(XmlNCName xmlNCName);

    public static final class Factory {
        public static TopLevelSimpleType newInstance() {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().newInstance(TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType newInstance(XmlOptions xmlOptions) {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().newInstance(TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(String str) throws XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(str, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(str, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(File file) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(file, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(file, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(URL url) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(url, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(url, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(InputStream inputStream) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(Reader reader) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(reader, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(reader, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(Node node) throws XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(node, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(node, TopLevelSimpleType.type, xmlOptions);
        }

        public static TopLevelSimpleType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static TopLevelSimpleType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (TopLevelSimpleType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelSimpleType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelSimpleType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelSimpleType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
