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
public interface CTLegendPos extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLegendPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlegendpos053ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLegendPos newInstance() {
            return (CTLegendPos) POIXMLTypeLoader.newInstance(CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos newInstance(XmlOptions xmlOptions) {
            return (CTLegendPos) POIXMLTypeLoader.newInstance(CTLegendPos.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLegendPos.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(File file) throws XmlException, IOException {
            return (CTLegendPos) POIXMLTypeLoader.parse(file, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegendPos) POIXMLTypeLoader.parse(file, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLegendPos) POIXMLTypeLoader.parse(inputStream, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegendPos) POIXMLTypeLoader.parse(inputStream, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(Reader reader) throws XmlException, IOException {
            return (CTLegendPos) POIXMLTypeLoader.parse(reader, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegendPos) POIXMLTypeLoader.parse(reader, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(String str) throws XmlException {
            return (CTLegendPos) POIXMLTypeLoader.parse(str, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLegendPos) POIXMLTypeLoader.parse(str, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(URL url) throws XmlException, IOException {
            return (CTLegendPos) POIXMLTypeLoader.parse(url, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLegendPos) POIXMLTypeLoader.parse(url, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLegendPos) POIXMLTypeLoader.parse(xMLStreamReader, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLegendPos) POIXMLTypeLoader.parse(xMLStreamReader, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLegendPos) POIXMLTypeLoader.parse(xMLInputStream, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLegendPos) POIXMLTypeLoader.parse(xMLInputStream, CTLegendPos.type, xmlOptions);
        }

        public static CTLegendPos parse(Node node) throws XmlException {
            return (CTLegendPos) POIXMLTypeLoader.parse(node, CTLegendPos.type, (XmlOptions) null);
        }

        public static CTLegendPos parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLegendPos) POIXMLTypeLoader.parse(node, CTLegendPos.type, xmlOptions);
        }
    }

    STLegendPos.Enum getVal();

    boolean isSetVal();

    void setVal(STLegendPos.Enum r1);

    void unsetVal();

    STLegendPos xgetVal();

    void xsetVal(STLegendPos sTLegendPos);
}
