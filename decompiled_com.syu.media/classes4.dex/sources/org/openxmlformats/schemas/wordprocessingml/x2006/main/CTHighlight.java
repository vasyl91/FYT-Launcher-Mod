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
public interface CTHighlight extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTHighlight.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthighlight071etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTHighlight newInstance() {
            return (CTHighlight) POIXMLTypeLoader.newInstance(CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight newInstance(XmlOptions xmlOptions) {
            return (CTHighlight) POIXMLTypeLoader.newInstance(CTHighlight.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHighlight.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(File file) throws XmlException, IOException {
            return (CTHighlight) POIXMLTypeLoader.parse(file, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHighlight) POIXMLTypeLoader.parse(file, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHighlight) POIXMLTypeLoader.parse(inputStream, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHighlight) POIXMLTypeLoader.parse(inputStream, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(Reader reader) throws XmlException, IOException {
            return (CTHighlight) POIXMLTypeLoader.parse(reader, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHighlight) POIXMLTypeLoader.parse(reader, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(String str) throws XmlException {
            return (CTHighlight) POIXMLTypeLoader.parse(str, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHighlight) POIXMLTypeLoader.parse(str, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(URL url) throws XmlException, IOException {
            return (CTHighlight) POIXMLTypeLoader.parse(url, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHighlight) POIXMLTypeLoader.parse(url, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHighlight) POIXMLTypeLoader.parse(xMLStreamReader, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHighlight) POIXMLTypeLoader.parse(xMLStreamReader, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTHighlight) POIXMLTypeLoader.parse(xMLInputStream, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTHighlight) POIXMLTypeLoader.parse(xMLInputStream, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(Node node) throws XmlException {
            return (CTHighlight) POIXMLTypeLoader.parse(node, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHighlight) POIXMLTypeLoader.parse(node, CTHighlight.type, xmlOptions);
        }
    }

    STHighlightColor.Enum getVal();

    void setVal(STHighlightColor.Enum r1);

    STHighlightColor xgetVal();

    void xsetVal(STHighlightColor sTHighlightColor);
}
