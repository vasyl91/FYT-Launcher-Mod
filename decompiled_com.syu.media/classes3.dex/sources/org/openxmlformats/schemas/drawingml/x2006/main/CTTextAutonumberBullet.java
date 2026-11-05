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
public interface CTTextAutonumberBullet extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextAutonumberBullet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextautonumberbulletd602type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextAutonumberBullet newInstance() {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.newInstance(CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet newInstance(XmlOptions xmlOptions) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.newInstance(CTTextAutonumberBullet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(File file) throws XmlException, IOException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(file, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(file, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(inputStream, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(inputStream, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(Reader reader) throws XmlException, IOException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(reader, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(reader, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(String str) throws XmlException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(str, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(str, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(URL url) throws XmlException, IOException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(url, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(url, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(xMLStreamReader, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(xMLStreamReader, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(xMLInputStream, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(xMLInputStream, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(Node node) throws XmlException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(node, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(node, CTTextAutonumberBullet.type, xmlOptions);
        }
    }

    int getStartAt();

    STTextAutonumberScheme.Enum getType();

    boolean isSetStartAt();

    void setStartAt(int i);

    void setType(STTextAutonumberScheme.Enum r1);

    void unsetStartAt();

    STTextBulletStartAtNum xgetStartAt();

    STTextAutonumberScheme xgetType();

    void xsetStartAt(STTextBulletStartAtNum sTTextBulletStartAtNum);

    void xsetType(STTextAutonumberScheme sTTextAutonumberScheme);
}
