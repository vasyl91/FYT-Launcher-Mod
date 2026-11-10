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
public interface CTGroupFillProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTGroupFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgroupfillpropertiesec66type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGroupFillProperties newInstance() {
            return (CTGroupFillProperties) POIXMLTypeLoader.newInstance(CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTGroupFillProperties) POIXMLTypeLoader.newInstance(CTGroupFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(File file) throws XmlException, IOException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(file, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(file, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(inputStream, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(inputStream, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(Reader reader) throws XmlException, IOException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(reader, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(reader, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(String str) throws XmlException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(str, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(str, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(URL url) throws XmlException, IOException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(url, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(url, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(Node node) throws XmlException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(node, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(node, CTGroupFillProperties.type, xmlOptions);
        }
    }
}
