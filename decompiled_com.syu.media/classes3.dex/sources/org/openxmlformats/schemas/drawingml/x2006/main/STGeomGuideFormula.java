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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STGeomGuideFormula extends XmlString {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STGeomGuideFormula.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stgeomguideformula4b51type");

    public static final class Factory {
        private Factory() {
        }

        public static STGeomGuideFormula newInstance() {
            return POIXMLTypeLoader.newInstance(STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STGeomGuideFormula.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula newValue(Object obj) {
            return STGeomGuideFormula.type.newValue(obj);
        }

        public static STGeomGuideFormula parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STGeomGuideFormula.type, xmlOptions);
        }
    }
}
