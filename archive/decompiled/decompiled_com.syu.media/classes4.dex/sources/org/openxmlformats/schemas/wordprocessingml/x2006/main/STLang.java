package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface STLang extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STLang.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlanga02atype");

    public static final class Factory {
        private Factory() {
        }

        public static STLang newInstance() {
            return POIXMLTypeLoader.newInstance(STLang.type, (XmlOptions) null);
        }

        public static STLang newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STLang.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLang.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLang.type, xmlOptions);
        }

        public static STLang newValue(Object obj) {
            return (STLang) STLang.type.newValue(obj);
        }

        public static STLang parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLang.type, (XmlOptions) null);
        }

        public static STLang parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLang.type, xmlOptions);
        }

        public static STLang parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLang.type, (XmlOptions) null);
        }

        public static STLang parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLang.type, xmlOptions);
        }

        public static STLang parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLang.type, (XmlOptions) null);
        }

        public static STLang parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLang.type, xmlOptions);
        }

        public static STLang parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLang.type, (XmlOptions) null);
        }

        public static STLang parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLang.type, xmlOptions);
        }

        public static STLang parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLang.type, (XmlOptions) null);
        }

        public static STLang parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLang.type, xmlOptions);
        }

        public static STLang parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLang.type, (XmlOptions) null);
        }

        public static STLang parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLang.type, xmlOptions);
        }

        public static STLang parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLang.type, (XmlOptions) null);
        }

        public static STLang parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLang.type, xmlOptions);
        }

        public static STLang parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLang.type, (XmlOptions) null);
        }

        public static STLang parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLang.type, xmlOptions);
        }
    }

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);
}
