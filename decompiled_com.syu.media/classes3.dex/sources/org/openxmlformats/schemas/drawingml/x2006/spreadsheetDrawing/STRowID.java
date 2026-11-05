package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

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
public interface STRowID extends XmlInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STRowID.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("strowidf4cftype");

    public static final class Factory {
        private Factory() {
        }

        public static STRowID newInstance() {
            return POIXMLTypeLoader.newInstance(STRowID.type, (XmlOptions) null);
        }

        public static STRowID newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STRowID.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STRowID.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STRowID.type, xmlOptions);
        }

        public static STRowID newValue(Object obj) {
            return STRowID.type.newValue(obj);
        }

        public static STRowID parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STRowID.type, xmlOptions);
        }

        public static STRowID parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STRowID.type, xmlOptions);
        }

        public static STRowID parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STRowID.type, xmlOptions);
        }

        public static STRowID parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STRowID.type, xmlOptions);
        }

        public static STRowID parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STRowID.type, xmlOptions);
        }

        public static STRowID parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STRowID.type, xmlOptions);
        }

        public static STRowID parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STRowID.type, xmlOptions);
        }

        public static STRowID parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STRowID.type, (XmlOptions) null);
        }

        public static STRowID parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STRowID.type, xmlOptions);
        }
    }
}
