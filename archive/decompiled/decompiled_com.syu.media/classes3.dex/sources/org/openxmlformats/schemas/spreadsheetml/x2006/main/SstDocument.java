package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface SstDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SstDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sstf81fdoctype");

    public static final class Factory {
        private Factory() {
        }

        public static SstDocument newInstance() {
            return (SstDocument) POIXMLTypeLoader.newInstance(SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument newInstance(XmlOptions xmlOptions) {
            return (SstDocument) POIXMLTypeLoader.newInstance(SstDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SstDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(File file) throws XmlException, IOException {
            return (SstDocument) POIXMLTypeLoader.parse(file, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SstDocument) POIXMLTypeLoader.parse(file, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (SstDocument) POIXMLTypeLoader.parse(inputStream, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SstDocument) POIXMLTypeLoader.parse(inputStream, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(Reader reader) throws XmlException, IOException {
            return (SstDocument) POIXMLTypeLoader.parse(reader, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SstDocument) POIXMLTypeLoader.parse(reader, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(String str) throws XmlException {
            return (SstDocument) POIXMLTypeLoader.parse(str, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SstDocument) POIXMLTypeLoader.parse(str, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(URL url) throws XmlException, IOException {
            return (SstDocument) POIXMLTypeLoader.parse(url, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SstDocument) POIXMLTypeLoader.parse(url, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SstDocument) POIXMLTypeLoader.parse(xMLStreamReader, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SstDocument) POIXMLTypeLoader.parse(xMLStreamReader, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SstDocument) POIXMLTypeLoader.parse(xMLInputStream, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SstDocument) POIXMLTypeLoader.parse(xMLInputStream, SstDocument.type, xmlOptions);
        }

        public static SstDocument parse(Node node) throws XmlException {
            return (SstDocument) POIXMLTypeLoader.parse(node, SstDocument.type, (XmlOptions) null);
        }

        public static SstDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SstDocument) POIXMLTypeLoader.parse(node, SstDocument.type, xmlOptions);
        }
    }

    CTSst addNewSst();

    CTSst getSst();

    void setSst(CTSst cTSst);
}
