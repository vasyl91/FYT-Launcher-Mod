package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STPercentage extends XmlInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpercentage0a85type");

    public static final class Factory {
        private Factory() {
        }

        public static STPercentage newInstance() {
            return POIXMLTypeLoader.newInstance(STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPercentage.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPercentage.type, xmlOptions);
        }

        public static STPercentage newValue(Object obj) {
            return STPercentage.type.newValue(obj);
        }

        public static STPercentage parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STPercentage.type, xmlOptions);
        }
    }
}
