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
public interface CTPositiveSize2D extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPositiveSize2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpositivesize2d0147type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPositiveSize2D newInstance() {
            return (CTPositiveSize2D) POIXMLTypeLoader.newInstance(CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D newInstance(XmlOptions xmlOptions) {
            return (CTPositiveSize2D) POIXMLTypeLoader.newInstance(CTPositiveSize2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(File file) throws XmlException, IOException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(file, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(file, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(inputStream, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(inputStream, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(Reader reader) throws XmlException, IOException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(reader, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(reader, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(String str) throws XmlException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(str, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(str, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(URL url) throws XmlException, IOException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(url, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(url, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(xMLStreamReader, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(xMLStreamReader, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(xMLInputStream, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(xMLInputStream, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(Node node) throws XmlException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(node, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(node, CTPositiveSize2D.type, xmlOptions);
        }
    }

    long getCx();

    long getCy();

    void setCx(long j);

    void setCy(long j);

    STPositiveCoordinate xgetCx();

    STPositiveCoordinate xgetCy();

    void xsetCx(STPositiveCoordinate sTPositiveCoordinate);

    void xsetCy(STPositiveCoordinate sTPositiveCoordinate);
}
