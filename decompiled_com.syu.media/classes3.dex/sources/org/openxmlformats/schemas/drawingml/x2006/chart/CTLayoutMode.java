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
public interface CTLayoutMode extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLayoutMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlayoutmode53eftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLayoutMode newInstance() {
            return (CTLayoutMode) POIXMLTypeLoader.newInstance(CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode newInstance(XmlOptions xmlOptions) {
            return (CTLayoutMode) POIXMLTypeLoader.newInstance(CTLayoutMode.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLayoutMode.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(File file) throws XmlException, IOException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(file, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(file, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(inputStream, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(inputStream, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(Reader reader) throws XmlException, IOException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(reader, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(reader, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(String str) throws XmlException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(str, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(str, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(URL url) throws XmlException, IOException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(url, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(url, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(xMLStreamReader, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(xMLStreamReader, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(xMLInputStream, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(xMLInputStream, CTLayoutMode.type, xmlOptions);
        }

        public static CTLayoutMode parse(Node node) throws XmlException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(node, CTLayoutMode.type, (XmlOptions) null);
        }

        public static CTLayoutMode parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLayoutMode) POIXMLTypeLoader.parse(node, CTLayoutMode.type, xmlOptions);
        }
    }

    STLayoutMode.Enum getVal();

    boolean isSetVal();

    void setVal(STLayoutMode.Enum r1);

    void unsetVal();

    STLayoutMode xgetVal();

    void xsetVal(STLayoutMode sTLayoutMode);
}
