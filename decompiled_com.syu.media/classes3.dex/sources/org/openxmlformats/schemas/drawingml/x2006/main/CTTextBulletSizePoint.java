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
public interface CTTextBulletSizePoint extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextBulletSizePoint.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextbulletsizepointe4f1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextBulletSizePoint newInstance() {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.newInstance(CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint newInstance(XmlOptions xmlOptions) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.newInstance(CTTextBulletSizePoint.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(File file) throws XmlException, IOException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(file, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(file, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(inputStream, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(inputStream, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(Reader reader) throws XmlException, IOException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(reader, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(reader, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(String str) throws XmlException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(str, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(str, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(URL url) throws XmlException, IOException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(url, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(url, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(xMLStreamReader, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(xMLStreamReader, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(xMLInputStream, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(xMLInputStream, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(Node node) throws XmlException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(node, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(node, CTTextBulletSizePoint.type, xmlOptions);
        }
    }

    int getVal();

    boolean isSetVal();

    void setVal(int i);

    void unsetVal();

    STTextFontSize xgetVal();

    void xsetVal(STTextFontSize sTTextFontSize);
}
