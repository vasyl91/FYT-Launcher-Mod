package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTVerticalAlignRun extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTVerticalAlignRun.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctverticalalignruncb8ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTVerticalAlignRun newInstance() {
            return (CTVerticalAlignRun) POIXMLTypeLoader.newInstance(CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun newInstance(XmlOptions xmlOptions) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.newInstance(CTVerticalAlignRun.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(File file) throws XmlException, IOException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(file, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(file, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(InputStream inputStream) throws XmlException, IOException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(inputStream, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(inputStream, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(Reader reader) throws XmlException, IOException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(reader, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(reader, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(String str) throws XmlException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(str, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(str, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(URL url) throws XmlException, IOException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(url, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(url, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(xMLStreamReader, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(xMLStreamReader, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(xMLInputStream, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(xMLInputStream, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(Node node) throws XmlException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(node, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(node, CTVerticalAlignRun.type, xmlOptions);
        }
    }

    STVerticalAlignRun.Enum getVal();

    void setVal(STVerticalAlignRun.Enum r1);

    STVerticalAlignRun xgetVal();

    void xsetVal(STVerticalAlignRun sTVerticalAlignRun);
}
