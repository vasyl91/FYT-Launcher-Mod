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
public interface TopLevelElement extends Element {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TopLevelElement.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("toplevelelement98d8type");

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Element
    void xsetName(XmlNCName xmlNCName);

    public static final class Factory {
        public static TopLevelElement newInstance() {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().newInstance(TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement newInstance(XmlOptions xmlOptions) {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().newInstance(TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(String str) throws XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(str, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(str, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(File file) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(file, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(file, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(URL url) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(url, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(url, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(InputStream inputStream) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(inputStream, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(Reader reader) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(reader, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(reader, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(Node node) throws XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(node, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(node, TopLevelElement.type, xmlOptions);
        }

        public static TopLevelElement parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelElement.type, (XmlOptions) null);
        }

        public static TopLevelElement parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (TopLevelElement) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TopLevelElement.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelElement.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TopLevelElement.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
