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
public interface CTAxPos extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTAxPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctaxposff69type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAxPos newInstance() {
            return (CTAxPos) POIXMLTypeLoader.newInstance(CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos newInstance(XmlOptions xmlOptions) {
            return (CTAxPos) POIXMLTypeLoader.newInstance(CTAxPos.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAxPos.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(File file) throws XmlException, IOException {
            return (CTAxPos) POIXMLTypeLoader.parse(file, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxPos) POIXMLTypeLoader.parse(file, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAxPos) POIXMLTypeLoader.parse(inputStream, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxPos) POIXMLTypeLoader.parse(inputStream, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(Reader reader) throws XmlException, IOException {
            return (CTAxPos) POIXMLTypeLoader.parse(reader, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxPos) POIXMLTypeLoader.parse(reader, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(String str) throws XmlException {
            return (CTAxPos) POIXMLTypeLoader.parse(str, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAxPos) POIXMLTypeLoader.parse(str, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(URL url) throws XmlException, IOException {
            return (CTAxPos) POIXMLTypeLoader.parse(url, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAxPos) POIXMLTypeLoader.parse(url, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAxPos) POIXMLTypeLoader.parse(xMLStreamReader, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAxPos) POIXMLTypeLoader.parse(xMLStreamReader, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTAxPos) POIXMLTypeLoader.parse(xMLInputStream, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTAxPos) POIXMLTypeLoader.parse(xMLInputStream, CTAxPos.type, xmlOptions);
        }

        public static CTAxPos parse(Node node) throws XmlException {
            return (CTAxPos) POIXMLTypeLoader.parse(node, CTAxPos.type, (XmlOptions) null);
        }

        public static CTAxPos parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAxPos) POIXMLTypeLoader.parse(node, CTAxPos.type, xmlOptions);
        }
    }

    STAxPos.Enum getVal();

    void setVal(STAxPos.Enum r1);

    STAxPos xgetVal();

    void xsetVal(STAxPos sTAxPos);
}
