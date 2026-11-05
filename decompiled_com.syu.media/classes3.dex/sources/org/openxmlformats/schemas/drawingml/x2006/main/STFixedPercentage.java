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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STFixedPercentage extends STPercentage {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STFixedPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stfixedpercentagef0cftype");

    public static final class Factory {
        private Factory() {
        }

        public static STFixedPercentage newInstance() {
            return POIXMLTypeLoader.newInstance(STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STFixedPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFixedPercentage.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage newValue(Object obj) {
            return STFixedPercentage.type.newValue(obj);
        }

        public static STFixedPercentage parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFixedPercentage.type, xmlOptions);
        }
    }
}
