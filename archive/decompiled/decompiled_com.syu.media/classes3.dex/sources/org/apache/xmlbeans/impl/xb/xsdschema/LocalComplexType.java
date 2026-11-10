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
public interface LocalComplexType extends ComplexType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(LocalComplexType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("localcomplextype6494type");

    public static final class Factory {
        public static LocalComplexType newInstance() {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().newInstance(LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType newInstance(XmlOptions xmlOptions) {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().newInstance(LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(String str) throws XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(str, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(str, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(File file) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(file, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(file, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(URL url) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(url, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(url, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(InputStream inputStream) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(inputStream, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(inputStream, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(Reader reader) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(reader, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(reader, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(Node node) throws XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(node, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(node, LocalComplexType.type, xmlOptions);
        }

        public static LocalComplexType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LocalComplexType.type, (XmlOptions) null);
        }

        public static LocalComplexType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (LocalComplexType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, LocalComplexType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LocalComplexType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, LocalComplexType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
