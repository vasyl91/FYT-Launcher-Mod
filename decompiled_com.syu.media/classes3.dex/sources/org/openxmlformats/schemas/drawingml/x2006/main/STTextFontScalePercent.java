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
public interface STTextFontScalePercent extends STPercentage {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTextFontScalePercent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextfontscalepercente6c2type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextFontScalePercent newInstance() {
            return POIXMLTypeLoader.newInstance(STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTextFontScalePercent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent newValue(Object obj) {
            return STTextFontScalePercent.type.newValue(obj);
        }

        public static STTextFontScalePercent parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextFontScalePercent.type, xmlOptions);
        }
    }
}
