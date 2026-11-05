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
public interface CTVerticalJc extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTVerticalJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctverticaljca439type");

    public static final class Factory {
        private Factory() {
        }

        public static CTVerticalJc newInstance() {
            return (CTVerticalJc) POIXMLTypeLoader.newInstance(CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc newInstance(XmlOptions xmlOptions) {
            return (CTVerticalJc) POIXMLTypeLoader.newInstance(CTVerticalJc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVerticalJc.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(File file) throws XmlException, IOException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(file, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(file, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(InputStream inputStream) throws XmlException, IOException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(inputStream, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(inputStream, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(Reader reader) throws XmlException, IOException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(reader, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(reader, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(String str) throws XmlException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(str, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(str, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(URL url) throws XmlException, IOException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(url, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(url, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(xMLStreamReader, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(xMLStreamReader, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(xMLInputStream, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(xMLInputStream, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(Node node) throws XmlException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(node, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTVerticalJc) POIXMLTypeLoader.parse(node, CTVerticalJc.type, xmlOptions);
        }
    }

    STVerticalJc.Enum getVal();

    void setVal(STVerticalJc.Enum r1);

    STVerticalJc xgetVal();

    void xsetVal(STVerticalJc sTVerticalJc);
}
