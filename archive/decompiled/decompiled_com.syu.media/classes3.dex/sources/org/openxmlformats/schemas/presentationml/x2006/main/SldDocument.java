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
public interface SldDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SldDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sld1b98doctype");

    public static final class Factory {
        private Factory() {
        }

        public static SldDocument newInstance() {
            return (SldDocument) POIXMLTypeLoader.newInstance(SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument newInstance(XmlOptions xmlOptions) {
            return (SldDocument) POIXMLTypeLoader.newInstance(SldDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SldDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(File file) throws XmlException, IOException {
            return (SldDocument) POIXMLTypeLoader.parse(file, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldDocument) POIXMLTypeLoader.parse(file, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SldDocument) POIXMLTypeLoader.parse(inputStream, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldDocument) POIXMLTypeLoader.parse(inputStream, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(Reader reader) throws XmlException, IOException {
            return (SldDocument) POIXMLTypeLoader.parse(reader, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldDocument) POIXMLTypeLoader.parse(reader, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(String str) throws XmlException {
            return (SldDocument) POIXMLTypeLoader.parse(str, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SldDocument) POIXMLTypeLoader.parse(str, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(URL url) throws XmlException, IOException {
            return (SldDocument) POIXMLTypeLoader.parse(url, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SldDocument) POIXMLTypeLoader.parse(url, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SldDocument) POIXMLTypeLoader.parse(xMLStreamReader, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SldDocument) POIXMLTypeLoader.parse(xMLStreamReader, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SldDocument) POIXMLTypeLoader.parse(xMLInputStream, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SldDocument) POIXMLTypeLoader.parse(xMLInputStream, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(Node node) throws XmlException {
            return (SldDocument) POIXMLTypeLoader.parse(node, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SldDocument) POIXMLTypeLoader.parse(node, SldDocument.type, xmlOptions);
        }
    }

    CTSlide addNewSld();

    CTSlide getSld();

    void setSld(CTSlide cTSlide);
}
