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
public interface CTEmptyElement extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTEmptyElement.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctemptyelement05catype");

    public static final class Factory {
        private Factory() {
        }

        public static CTEmptyElement newInstance() {
            return (CTEmptyElement) POIXMLTypeLoader.newInstance(CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement newInstance(XmlOptions xmlOptions) {
            return (CTEmptyElement) POIXMLTypeLoader.newInstance(CTEmptyElement.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEmptyElement.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(File file) throws XmlException, IOException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(file, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(file, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(InputStream inputStream) throws XmlException, IOException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(inputStream, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(inputStream, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(Reader reader) throws XmlException, IOException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(reader, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(reader, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(String str) throws XmlException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(str, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(str, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(URL url) throws XmlException, IOException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(url, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(url, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(xMLStreamReader, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(xMLStreamReader, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(xMLInputStream, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(xMLInputStream, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(Node node) throws XmlException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(node, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTEmptyElement) POIXMLTypeLoader.parse(node, CTEmptyElement.type, xmlOptions);
        }
    }
}
