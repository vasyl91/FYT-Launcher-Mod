package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface SldLayoutDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SldLayoutDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sldlayout638edoctype");

    public static final class Factory {
        private Factory() {
        }

        public static SldLayoutDocument newInstance() {
            return (SldLayoutDocument) POIXMLTypeLoader.newInstance(SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument newInstance(XmlOptions xmlOptions) {
            return (SldLayoutDocument) POIXMLTypeLoader.newInstance(SldLayoutDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(File file) throws XmlException, IOException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(file, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(file, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(inputStream, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(inputStream, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(Reader reader) throws XmlException, IOException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(reader, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(reader, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(String str) throws XmlException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(str, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(str, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(URL url) throws XmlException, IOException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(url, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(url, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(xMLStreamReader, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(xMLStreamReader, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(xMLInputStream, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(xMLInputStream, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(Node node) throws XmlException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(node, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(node, SldLayoutDocument.type, xmlOptions);
        }
    }

    CTSlideLayout addNewSldLayout();

    CTSlideLayout getSldLayout();

    void setSldLayout(CTSlideLayout cTSlideLayout);
}
