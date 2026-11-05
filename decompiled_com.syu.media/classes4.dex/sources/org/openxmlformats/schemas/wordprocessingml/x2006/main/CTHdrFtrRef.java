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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTHdrFtrRef extends CTRel {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTHdrFtrRef.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthdrftrref224dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTHdrFtrRef newInstance() {
            return (CTHdrFtrRef) POIXMLTypeLoader.newInstance(CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef newInstance(XmlOptions xmlOptions) {
            return (CTHdrFtrRef) POIXMLTypeLoader.newInstance(CTHdrFtrRef.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(File file) throws XmlException, IOException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(file, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(file, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(InputStream inputStream) throws XmlException, IOException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(inputStream, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(inputStream, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(Reader reader) throws XmlException, IOException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(reader, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(reader, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(String str) throws XmlException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(str, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(str, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(URL url) throws XmlException, IOException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(url, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(url, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(xMLStreamReader, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(xMLStreamReader, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(xMLInputStream, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(xMLInputStream, CTHdrFtrRef.type, xmlOptions);
        }

        public static CTHdrFtrRef parse(Node node) throws XmlException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(node, CTHdrFtrRef.type, (XmlOptions) null);
        }

        public static CTHdrFtrRef parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTHdrFtrRef) POIXMLTypeLoader.parse(node, CTHdrFtrRef.type, xmlOptions);
        }
    }

    STHdrFtr.Enum getType();

    void setType(STHdrFtr.Enum r1);

    STHdrFtr xgetType();

    void xsetType(STHdrFtr sTHdrFtr);
}
