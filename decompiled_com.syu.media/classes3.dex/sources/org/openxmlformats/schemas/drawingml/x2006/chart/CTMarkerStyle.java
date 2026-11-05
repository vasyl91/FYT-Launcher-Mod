package org.openxmlformats.schemas.drawingml.x2006.chart;

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
public interface CTMarkerStyle extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTMarkerStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmarkerstyle1f6ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTMarkerStyle newInstance() {
            return (CTMarkerStyle) POIXMLTypeLoader.newInstance(CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle newInstance(XmlOptions xmlOptions) {
            return (CTMarkerStyle) POIXMLTypeLoader.newInstance(CTMarkerStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(File file) throws XmlException, IOException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(file, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(file, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(InputStream inputStream) throws XmlException, IOException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(inputStream, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(inputStream, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(Reader reader) throws XmlException, IOException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(reader, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(reader, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(String str) throws XmlException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(str, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(str, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(URL url) throws XmlException, IOException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(url, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(url, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(xMLInputStream, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(xMLInputStream, CTMarkerStyle.type, xmlOptions);
        }

        public static CTMarkerStyle parse(Node node) throws XmlException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(node, CTMarkerStyle.type, (XmlOptions) null);
        }

        public static CTMarkerStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTMarkerStyle) POIXMLTypeLoader.parse(node, CTMarkerStyle.type, xmlOptions);
        }
    }

    STMarkerStyle.Enum getVal();

    void setVal(STMarkerStyle.Enum r1);

    STMarkerStyle xgetVal();

    void xsetVal(STMarkerStyle sTMarkerStyle);
}
