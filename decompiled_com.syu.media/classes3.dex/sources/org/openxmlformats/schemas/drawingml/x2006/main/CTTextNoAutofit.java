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
public interface CTTextNoAutofit extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextNoAutofit.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextnoautofit1045type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextNoAutofit newInstance() {
            return (CTTextNoAutofit) POIXMLTypeLoader.newInstance(CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit newInstance(XmlOptions xmlOptions) {
            return (CTTextNoAutofit) POIXMLTypeLoader.newInstance(CTTextNoAutofit.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(File file) throws XmlException, IOException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(file, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(file, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(inputStream, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(inputStream, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(Reader reader) throws XmlException, IOException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(reader, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(reader, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(String str) throws XmlException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(str, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(str, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(URL url) throws XmlException, IOException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(url, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(url, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(xMLStreamReader, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(xMLStreamReader, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(xMLInputStream, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(xMLInputStream, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(Node node) throws XmlException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(node, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(node, CTTextNoAutofit.type, xmlOptions);
        }
    }
}
