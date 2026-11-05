package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STLogBase extends XmlDouble {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STLogBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlogbase11a1type");

    public static final class Factory {
        private Factory() {
        }

        public static STLogBase newInstance() {
            return POIXMLTypeLoader.newInstance(STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STLogBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLogBase.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLogBase.type, xmlOptions);
        }

        public static STLogBase newValue(Object obj) {
            return STLogBase.type.newValue(obj);
        }

        public static STLogBase parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLogBase.type, xmlOptions);
        }

        public static STLogBase parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLogBase.type, (XmlOptions) null);
        }

        public static STLogBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLogBase.type, xmlOptions);
        }
    }
}
