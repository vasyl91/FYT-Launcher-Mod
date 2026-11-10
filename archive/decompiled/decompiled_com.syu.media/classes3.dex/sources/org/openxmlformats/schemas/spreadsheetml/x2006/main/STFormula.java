package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface STFormula extends STXstring {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STFormula.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stformula7e35type");

    public static final class Factory {
        private Factory() {
        }

        public static STFormula newInstance() {
            return POIXMLTypeLoader.newInstance(STFormula.type, (XmlOptions) null);
        }

        public static STFormula newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STFormula.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFormula.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFormula.type, xmlOptions);
        }

        public static STFormula newValue(Object obj) {
            return STFormula.type.newValue(obj);
        }

        public static STFormula parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFormula.type, (XmlOptions) null);
        }

        public static STFormula parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFormula.type, xmlOptions);
        }

        public static STFormula parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFormula.type, (XmlOptions) null);
        }

        public static STFormula parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFormula.type, xmlOptions);
        }

        public static STFormula parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFormula.type, (XmlOptions) null);
        }

        public static STFormula parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFormula.type, xmlOptions);
        }

        public static STFormula parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFormula.type, (XmlOptions) null);
        }

        public static STFormula parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFormula.type, xmlOptions);
        }

        public static STFormula parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFormula.type, (XmlOptions) null);
        }

        public static STFormula parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFormula.type, xmlOptions);
        }

        public static STFormula parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFormula.type, (XmlOptions) null);
        }

        public static STFormula parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFormula.type, xmlOptions);
        }

        public static STFormula parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFormula.type, (XmlOptions) null);
        }

        public static STFormula parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFormula.type, xmlOptions);
        }

        public static STFormula parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFormula.type, (XmlOptions) null);
        }

        public static STFormula parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFormula.type, xmlOptions);
        }
    }
}
