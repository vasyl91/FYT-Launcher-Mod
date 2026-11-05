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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTGraphicalObject extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTGraphicalObject.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgraphicalobject1ce3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObject newInstance() {
            return (CTGraphicalObject) POIXMLTypeLoader.newInstance(CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObject) POIXMLTypeLoader.newInstance(CTGraphicalObject.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(File file) throws XmlException, IOException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(file, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(file, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(inputStream, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(inputStream, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(Reader reader) throws XmlException, IOException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(reader, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(reader, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(String str) throws XmlException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(str, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(str, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(URL url) throws XmlException, IOException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(url, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(url, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(Node node) throws XmlException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(node, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(node, CTGraphicalObject.type, xmlOptions);
        }
    }

    CTGraphicalObjectData addNewGraphicData();

    CTGraphicalObjectData getGraphicData();

    void setGraphicData(CTGraphicalObjectData cTGraphicalObjectData);
}
