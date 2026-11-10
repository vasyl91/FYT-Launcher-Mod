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
public interface CTPath2DLineTo extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPath2DLineTo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpath2dlineto4f41type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DLineTo newInstance() {
            return (CTPath2DLineTo) POIXMLTypeLoader.newInstance(CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo newInstance(XmlOptions xmlOptions) {
            return (CTPath2DLineTo) POIXMLTypeLoader.newInstance(CTPath2DLineTo.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(File file) throws XmlException, IOException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(file, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(file, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(inputStream, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(inputStream, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(Reader reader) throws XmlException, IOException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(reader, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(reader, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(String str) throws XmlException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(str, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(str, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(URL url) throws XmlException, IOException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(url, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(url, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(Node node) throws XmlException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(node, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(node, CTPath2DLineTo.type, xmlOptions);
        }
    }

    CTAdjPoint2D addNewPt();

    CTAdjPoint2D getPt();

    void setPt(CTAdjPoint2D cTAdjPoint2D);
}
