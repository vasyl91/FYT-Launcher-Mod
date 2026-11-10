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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTextCharBullet extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextCharBullet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextcharbullet3c20type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextCharBullet newInstance() {
            return (CTTextCharBullet) POIXMLTypeLoader.newInstance(CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet newInstance(XmlOptions xmlOptions) {
            return (CTTextCharBullet) POIXMLTypeLoader.newInstance(CTTextCharBullet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(File file) throws XmlException, IOException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(file, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(file, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(inputStream, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(inputStream, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(Reader reader) throws XmlException, IOException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(reader, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(reader, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(String str) throws XmlException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(str, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(str, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(URL url) throws XmlException, IOException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(url, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(url, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(xMLStreamReader, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(xMLStreamReader, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(xMLInputStream, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(xMLInputStream, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(Node node) throws XmlException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(node, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(node, CTTextCharBullet.type, xmlOptions);
        }
    }

    String getChar();

    void setChar(String str);

    XmlString xgetChar();

    void xsetChar(XmlString xmlString);
}
