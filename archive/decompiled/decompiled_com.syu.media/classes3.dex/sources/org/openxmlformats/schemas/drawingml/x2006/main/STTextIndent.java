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
public interface STTextIndent extends STCoordinate32 {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTextIndent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextindent16e4type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextIndent newInstance() {
            return POIXMLTypeLoader.newInstance(STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTextIndent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextIndent.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent newValue(Object obj) {
            return STTextIndent.type.newValue(obj);
        }

        public static STTextIndent parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextIndent.type, xmlOptions);
        }
    }
}
