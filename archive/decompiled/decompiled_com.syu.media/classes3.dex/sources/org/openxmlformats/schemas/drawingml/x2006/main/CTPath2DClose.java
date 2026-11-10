package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface CTPath2DClose extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPath2DClose.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpath2dclose09f2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DClose newInstance() {
            return (CTPath2DClose) POIXMLTypeLoader.newInstance(CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose newInstance(XmlOptions xmlOptions) {
            return (CTPath2DClose) POIXMLTypeLoader.newInstance(CTPath2DClose.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DClose.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(File file) throws XmlException, IOException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(file, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(file, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(inputStream, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(inputStream, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(Reader reader) throws XmlException, IOException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(reader, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(reader, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(String str) throws XmlException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(str, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(str, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(URL url) throws XmlException, IOException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(url, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(url, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(Node node) throws XmlException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(node, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DClose) POIXMLTypeLoader.parse(node, CTPath2DClose.type, xmlOptions);
        }
    }
}
