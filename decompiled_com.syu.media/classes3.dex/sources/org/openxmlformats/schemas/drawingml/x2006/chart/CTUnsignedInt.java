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
public interface CTUnsignedInt extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTUnsignedInt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctunsignedinte8ectype");

    public static final class Factory {
        private Factory() {
        }

        public static CTUnsignedInt newInstance() {
            return (CTUnsignedInt) POIXMLTypeLoader.newInstance(CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt newInstance(XmlOptions xmlOptions) {
            return (CTUnsignedInt) POIXMLTypeLoader.newInstance(CTUnsignedInt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(File file) throws XmlException, IOException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(file, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(file, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(InputStream inputStream) throws XmlException, IOException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(inputStream, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(inputStream, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(Reader reader) throws XmlException, IOException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(reader, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(reader, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(String str) throws XmlException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(str, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(str, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(URL url) throws XmlException, IOException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(url, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(url, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(xMLStreamReader, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(xMLStreamReader, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(xMLInputStream, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(xMLInputStream, CTUnsignedInt.type, xmlOptions);
        }

        public static CTUnsignedInt parse(Node node) throws XmlException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(node, CTUnsignedInt.type, (XmlOptions) null);
        }

        public static CTUnsignedInt parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTUnsignedInt) POIXMLTypeLoader.parse(node, CTUnsignedInt.type, xmlOptions);
        }
    }

    long getVal();

    void setVal(long j);

    XmlUnsignedInt xgetVal();

    void xsetVal(XmlUnsignedInt xmlUnsignedInt);
}
