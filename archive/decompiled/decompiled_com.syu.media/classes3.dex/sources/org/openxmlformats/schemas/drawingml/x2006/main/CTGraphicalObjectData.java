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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTGraphicalObjectData extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTGraphicalObjectData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgraphicalobjectdata66adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObjectData newInstance() {
            return (CTGraphicalObjectData) POIXMLTypeLoader.newInstance(CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.newInstance(CTGraphicalObjectData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(File file) throws XmlException, IOException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(file, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(file, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(Reader reader) throws XmlException, IOException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(reader, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(reader, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(String str) throws XmlException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(str, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(str, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(URL url) throws XmlException, IOException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(url, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(url, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(Node node) throws XmlException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(node, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(node, CTGraphicalObjectData.type, xmlOptions);
        }
    }

    String getUri();

    boolean isSetUri();

    void setUri(String str);

    void unsetUri();

    XmlToken xgetUri();

    void xsetUri(XmlToken xmlToken);
}
