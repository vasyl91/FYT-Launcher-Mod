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
public interface STHashSize extends XmlUnsignedInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STHashSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("sthashsize605btype");

    public static final class Factory {
        private Factory() {
        }

        public static STHashSize newInstance() {
            return POIXMLTypeLoader.newInstance(STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STHashSize.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHashSize.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHashSize.type, xmlOptions);
        }

        public static STHashSize newValue(Object obj) {
            return STHashSize.type.newValue(obj);
        }

        public static STHashSize parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STHashSize.type, xmlOptions);
        }

        public static STHashSize parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STHashSize.type, (XmlOptions) null);
        }

        public static STHashSize parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STHashSize.type, xmlOptions);
        }
    }

    int getIntValue();

    int intValue();

    void set(int i);

    void setIntValue(int i);
}
