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
public interface CTTextBulletSizePercent extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextBulletSizePercent.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextbulletsizepercent9b26type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextBulletSizePercent newInstance() {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.newInstance(CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent newInstance(XmlOptions xmlOptions) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.newInstance(CTTextBulletSizePercent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(File file) throws XmlException, IOException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(file, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(file, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(inputStream, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(inputStream, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(Reader reader) throws XmlException, IOException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(reader, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(reader, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(String str) throws XmlException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(str, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(str, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(URL url) throws XmlException, IOException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(url, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(url, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(xMLStreamReader, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(xMLStreamReader, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(xMLInputStream, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(xMLInputStream, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(Node node) throws XmlException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(node, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(node, CTTextBulletSizePercent.type, xmlOptions);
        }
    }

    int getVal();

    boolean isSetVal();

    void setVal(int i);

    void unsetVal();

    STTextBulletSizePercent xgetVal();

    void xsetVal(STTextBulletSizePercent sTTextBulletSizePercent);
}
