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
public interface CTNoFillProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTNoFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnofillpropertiesbf92type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNoFillProperties newInstance() {
            return (CTNoFillProperties) POIXMLTypeLoader.newInstance(CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTNoFillProperties) POIXMLTypeLoader.newInstance(CTNoFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(File file) throws XmlException, IOException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(file, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(file, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(inputStream, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(inputStream, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(Reader reader) throws XmlException, IOException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(reader, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(reader, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(String str) throws XmlException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(str, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(str, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(URL url) throws XmlException, IOException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(url, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(url, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(Node node) throws XmlException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(node, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(node, CTNoFillProperties.type, xmlOptions);
        }
    }
}
