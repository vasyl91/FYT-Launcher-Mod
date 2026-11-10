package com.microsoft.schemas.office.x2006.encryption;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface STSaltSize extends XmlUnsignedInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STSaltSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stsaltsizee7a3type");

    public static final class Factory {
        private Factory() {
        }

        public static STSaltSize newInstance() {
            return POIXMLTypeLoader.newInstance(STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STSaltSize.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSaltSize.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize newValue(Object obj) {
            return STSaltSize.type.newValue(obj);
        }

        public static STSaltSize parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STSaltSize.type, xmlOptions);
        }

        public static STSaltSize parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STSaltSize.type, (XmlOptions) null);
        }

        public static STSaltSize parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STSaltSize.type, xmlOptions);
        }
    }

    int getIntValue();

    int intValue();

    void set(int i);

    void setIntValue(int i);
}
