package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STAdjCoordinate extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STAdjCoordinate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stadjcoordinated920type");

    public static final class Factory {
        private Factory() {
        }

        public static STAdjCoordinate newInstance() {
            return POIXMLTypeLoader.newInstance(STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STAdjCoordinate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate newValue(Object obj) {
            return (STAdjCoordinate) STAdjCoordinate.type.newValue(obj);
        }

        public static STAdjCoordinate parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STAdjCoordinate.type, xmlOptions);
        }
    }

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);
}
