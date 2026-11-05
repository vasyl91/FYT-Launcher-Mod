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
public interface STKeyBits extends XmlUnsignedInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STKeyBits.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stkeybitse527type");

    public static final class Factory {
        private Factory() {
        }

        public static STKeyBits newInstance() {
            return POIXMLTypeLoader.newInstance(STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STKeyBits.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STKeyBits.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits newValue(Object obj) {
            return STKeyBits.type.newValue(obj);
        }

        public static STKeyBits parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STKeyBits.type, xmlOptions);
        }

        public static STKeyBits parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STKeyBits.type, (XmlOptions) null);
        }

        public static STKeyBits parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STKeyBits.type, xmlOptions);
        }
    }
}
