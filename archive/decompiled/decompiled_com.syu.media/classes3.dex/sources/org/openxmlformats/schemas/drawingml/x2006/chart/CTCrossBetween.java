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
public interface CTCrossBetween extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCrossBetween.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcrossbetweeneb14type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCrossBetween newInstance() {
            return (CTCrossBetween) POIXMLTypeLoader.newInstance(CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween newInstance(XmlOptions xmlOptions) {
            return (CTCrossBetween) POIXMLTypeLoader.newInstance(CTCrossBetween.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCrossBetween.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(File file) throws XmlException, IOException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(file, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(file, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(inputStream, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(inputStream, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(Reader reader) throws XmlException, IOException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(reader, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(reader, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(String str) throws XmlException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(str, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(str, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(URL url) throws XmlException, IOException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(url, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(url, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(xMLStreamReader, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(xMLStreamReader, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(xMLInputStream, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(xMLInputStream, CTCrossBetween.type, xmlOptions);
        }

        public static CTCrossBetween parse(Node node) throws XmlException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(node, CTCrossBetween.type, (XmlOptions) null);
        }

        public static CTCrossBetween parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCrossBetween) POIXMLTypeLoader.parse(node, CTCrossBetween.type, xmlOptions);
        }
    }

    STCrossBetween.Enum getVal();

    void setVal(STCrossBetween.Enum r1);

    STCrossBetween xgetVal();

    void xsetVal(STCrossBetween sTCrossBetween);
}
