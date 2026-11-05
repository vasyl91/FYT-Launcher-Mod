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
public interface STPositiveFixedPercentage extends STPercentage {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STPositiveFixedPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpositivefixedpercentagee756type");

    public static final class Factory {
        private Factory() {
        }

        public static STPositiveFixedPercentage newInstance() {
            return POIXMLTypeLoader.newInstance(STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STPositiveFixedPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage newValue(Object obj) {
            return STPositiveFixedPercentage.type.newValue(obj);
        }

        public static STPositiveFixedPercentage parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STPositiveFixedPercentage.type, xmlOptions);
        }
    }
}
