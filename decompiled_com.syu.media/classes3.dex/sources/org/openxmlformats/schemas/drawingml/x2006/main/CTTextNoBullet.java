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
public interface CTTextNoBullet extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextNoBullet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextnobulleta08btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextNoBullet newInstance() {
            return (CTTextNoBullet) POIXMLTypeLoader.newInstance(CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet newInstance(XmlOptions xmlOptions) {
            return (CTTextNoBullet) POIXMLTypeLoader.newInstance(CTTextNoBullet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(File file) throws XmlException, IOException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(file, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(file, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(inputStream, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(inputStream, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(Reader reader) throws XmlException, IOException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(reader, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(reader, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(String str) throws XmlException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(str, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(str, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(URL url) throws XmlException, IOException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(url, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(url, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(xMLStreamReader, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(xMLStreamReader, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(xMLInputStream, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(xMLInputStream, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(Node node) throws XmlException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(node, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(node, CTTextNoBullet.type, xmlOptions);
        }
    }
}
