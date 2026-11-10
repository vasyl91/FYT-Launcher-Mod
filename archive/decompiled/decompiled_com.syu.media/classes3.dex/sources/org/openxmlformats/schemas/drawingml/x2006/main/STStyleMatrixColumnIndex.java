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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STStyleMatrixColumnIndex extends XmlUnsignedInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STStyleMatrixColumnIndex.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ststylematrixcolumnindex1755type");

    public static final class Factory {
        private Factory() {
        }

        public static STStyleMatrixColumnIndex newInstance() {
            return POIXMLTypeLoader.newInstance(STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex newValue(Object obj) {
            return STStyleMatrixColumnIndex.type.newValue(obj);
        }

        public static STStyleMatrixColumnIndex parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STStyleMatrixColumnIndex.type, xmlOptions);
        }

        public static STStyleMatrixColumnIndex parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STStyleMatrixColumnIndex.type, (XmlOptions) null);
        }

        public static STStyleMatrixColumnIndex parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STStyleMatrixColumnIndex.type, xmlOptions);
        }
    }
}
