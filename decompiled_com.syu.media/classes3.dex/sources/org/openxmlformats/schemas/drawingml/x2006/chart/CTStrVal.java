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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTStrVal extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTStrVal.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstrval86cctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTStrVal newInstance() {
            return (CTStrVal) POIXMLTypeLoader.newInstance(CTStrVal.type, (XmlOptions) null);
        }

        public static CTStrVal newInstance(XmlOptions xmlOptions) {
            return (CTStrVal) POIXMLTypeLoader.newInstance(CTStrVal.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStrVal.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStrVal.type, xmlOptions);
        }

        public static CTStrVal parse(File file) throws XmlException, IOException {
            return (CTStrVal) POIXMLTypeLoader.parse(file, CTStrVal.type, (XmlOptions) null);
        }

        public static CTStrVal parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStrVal) POIXMLTypeLoader.parse(file, CTStrVal.type, xmlOptions);
        }

        public static CTStrVal parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStrVal) POIXMLTypeLoader.parse(inputStream, CTStrVal.type, (XmlOptions) null);
        }

        public static CTStrVal parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStrVal) POIXMLTypeLoader.parse(inputStream, CTStrVal.type, xmlOptions);
        }

        public static CTStrVal parse(Reader reader) throws XmlException, IOException {
            return (CTStrVal) POIXMLTypeLoader.parse(reader, CTStrVal.type, (XmlOptions) null);
        }

        public static CTStrVal parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStrVal) POIXMLTypeLoader.parse(reader, CTStrVal.type, xmlOptions);
        }

        public static CTStrVal parse(String str) throws XmlException {
            return (CTStrVal) POIXMLTypeLoader.parse(str, CTStrVal.type, (XmlOptions) null);
        }

        public static CTStrVal parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStrVal) POIXMLTypeLoader.parse(str, CTStrVal.type, xmlOptions);
        }

        public static CTStrVal parse(URL url) throws XmlException, IOException {
            return (CTStrVal) POIXMLTypeLoader.parse(url, CTStrVal.type, (XmlOptions) null);
        }

        public static CTStrVal parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStrVal) POIXMLTypeLoader.parse(url, CTStrVal.type, xmlOptions);
        }

        public static CTStrVal parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStrVal) POIXMLTypeLoader.parse(xMLStreamReader, CTStrVal.type, (XmlOptions) null);
        }

        public static CTStrVal parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStrVal) POIXMLTypeLoader.parse(xMLStreamReader, CTStrVal.type, xmlOptions);
        }

        public static CTStrVal parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTStrVal) POIXMLTypeLoader.parse(xMLInputStream, CTStrVal.type, (XmlOptions) null);
        }

        public static CTStrVal parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTStrVal) POIXMLTypeLoader.parse(xMLInputStream, CTStrVal.type, xmlOptions);
        }

        public static CTStrVal parse(Node node) throws XmlException {
            return (CTStrVal) POIXMLTypeLoader.parse(node, CTStrVal.type, (XmlOptions) null);
        }

        public static CTStrVal parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStrVal) POIXMLTypeLoader.parse(node, CTStrVal.type, xmlOptions);
        }
    }

    long getIdx();

    String getV();

    void setIdx(long j);

    void setV(String str);

    XmlUnsignedInt xgetIdx();

    STXstring xgetV();

    void xsetIdx(XmlUnsignedInt xmlUnsignedInt);

    void xsetV(STXstring sTXstring);
}
