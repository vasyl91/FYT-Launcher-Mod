package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTDigSigBlob extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTDigSigBlob.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdigsigblob73c9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDigSigBlob newInstance() {
            return (CTDigSigBlob) POIXMLTypeLoader.newInstance(CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob newInstance(XmlOptions xmlOptions) {
            return (CTDigSigBlob) POIXMLTypeLoader.newInstance(CTDigSigBlob.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(File file) throws XmlException, IOException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(file, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(file, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(inputStream, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(inputStream, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(Reader reader) throws XmlException, IOException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(reader, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(reader, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(String str) throws XmlException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(str, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(str, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(URL url) throws XmlException, IOException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(url, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(url, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(xMLStreamReader, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(xMLStreamReader, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(xMLInputStream, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(xMLInputStream, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(Node node) throws XmlException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(node, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(node, CTDigSigBlob.type, xmlOptions);
        }
    }

    byte[] getBlob();

    void setBlob(byte[] bArr);

    XmlBase64Binary xgetBlob();

    void xsetBlob(XmlBase64Binary xmlBase64Binary);
}
