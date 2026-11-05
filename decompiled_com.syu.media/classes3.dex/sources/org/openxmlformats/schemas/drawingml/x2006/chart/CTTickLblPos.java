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
public interface CTTickLblPos extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTickLblPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctticklblposff61type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTickLblPos newInstance() {
            return (CTTickLblPos) POIXMLTypeLoader.newInstance(CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos newInstance(XmlOptions xmlOptions) {
            return (CTTickLblPos) POIXMLTypeLoader.newInstance(CTTickLblPos.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTickLblPos.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(File file) throws XmlException, IOException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(file, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(file, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(inputStream, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(inputStream, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(Reader reader) throws XmlException, IOException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(reader, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(reader, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(String str) throws XmlException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(str, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(str, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(URL url) throws XmlException, IOException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(url, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(url, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(xMLStreamReader, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(xMLStreamReader, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(xMLInputStream, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(xMLInputStream, CTTickLblPos.type, xmlOptions);
        }

        public static CTTickLblPos parse(Node node) throws XmlException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(node, CTTickLblPos.type, (XmlOptions) null);
        }

        public static CTTickLblPos parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTickLblPos) POIXMLTypeLoader.parse(node, CTTickLblPos.type, xmlOptions);
        }
    }

    STTickLblPos.Enum getVal();

    boolean isSetVal();

    void setVal(STTickLblPos.Enum r1);

    void unsetVal();

    STTickLblPos xgetVal();

    void xsetVal(STTickLblPos sTTickLblPos);
}
