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
public interface STSpinCount extends XmlUnsignedInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STSpinCount.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stspincount544ftype");

    public static final class Factory {
        private Factory() {
        }

        public static STSpinCount newInstance() {
            return POIXMLTypeLoader.newInstance(STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STSpinCount.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSpinCount.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount newValue(Object obj) {
            return STSpinCount.type.newValue(obj);
        }

        public static STSpinCount parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STSpinCount.type, xmlOptions);
        }

        public static STSpinCount parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STSpinCount.type, (XmlOptions) null);
        }

        public static STSpinCount parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STSpinCount.type, xmlOptions);
        }
    }

    int getIntValue();

    int intValue();

    void set(int i);

    void setIntValue(int i);
}
