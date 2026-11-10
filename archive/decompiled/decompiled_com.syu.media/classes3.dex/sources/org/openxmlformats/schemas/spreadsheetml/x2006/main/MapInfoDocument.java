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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface MapInfoDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(MapInfoDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("mapinfo5715doctype");

    public static final class Factory {
        private Factory() {
        }

        public static MapInfoDocument newInstance() {
            return (MapInfoDocument) POIXMLTypeLoader.newInstance(MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument newInstance(XmlOptions xmlOptions) {
            return (MapInfoDocument) POIXMLTypeLoader.newInstance(MapInfoDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, MapInfoDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(File file) throws XmlException, IOException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(file, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(file, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(inputStream, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(inputStream, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(Reader reader) throws XmlException, IOException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(reader, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(reader, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(String str) throws XmlException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(str, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(str, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(URL url) throws XmlException, IOException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(url, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(url, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(xMLStreamReader, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(xMLStreamReader, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(xMLInputStream, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(xMLInputStream, MapInfoDocument.type, xmlOptions);
        }

        public static MapInfoDocument parse(Node node) throws XmlException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(node, MapInfoDocument.type, (XmlOptions) null);
        }

        public static MapInfoDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (MapInfoDocument) POIXMLTypeLoader.parse(node, MapInfoDocument.type, xmlOptions);
        }
    }

    CTMapInfo addNewMapInfo();

    CTMapInfo getMapInfo();

    void setMapInfo(CTMapInfo cTMapInfo);
}
