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
public interface STBlockSize extends XmlUnsignedInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STBlockSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stblocksize2e10type");

    public static final class Factory {
        private Factory() {
        }

        public static STBlockSize newInstance() {
            return POIXMLTypeLoader.newInstance(STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STBlockSize.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STBlockSize.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize newValue(Object obj) {
            return STBlockSize.type.newValue(obj);
        }

        public static STBlockSize parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STBlockSize.type, xmlOptions);
        }

        public static STBlockSize parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STBlockSize.type, (XmlOptions) null);
        }

        public static STBlockSize parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STBlockSize.type, xmlOptions);
        }
    }

    int getIntValue();

    int intValue();

    void set(int i);

    void setIntValue(int i);
}
