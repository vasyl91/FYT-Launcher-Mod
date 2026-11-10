package com.microsoft.schemas.office.x2006.encryption;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface CTDataIntegrity extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTDataIntegrity.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctdataintegrity6eb5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDataIntegrity newInstance() {
            return (CTDataIntegrity) POIXMLTypeLoader.newInstance(CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity newInstance(XmlOptions xmlOptions) {
            return (CTDataIntegrity) POIXMLTypeLoader.newInstance(CTDataIntegrity.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(File file) throws XmlException, IOException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(file, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(file, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(inputStream, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(inputStream, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(Reader reader) throws XmlException, IOException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(reader, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(reader, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(String str) throws XmlException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(str, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(str, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(URL url) throws XmlException, IOException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(url, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(url, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(xMLStreamReader, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(xMLStreamReader, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(xMLInputStream, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(xMLInputStream, CTDataIntegrity.type, xmlOptions);
        }

        public static CTDataIntegrity parse(Node node) throws XmlException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(node, CTDataIntegrity.type, (XmlOptions) null);
        }

        public static CTDataIntegrity parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDataIntegrity) POIXMLTypeLoader.parse(node, CTDataIntegrity.type, xmlOptions);
        }
    }

    byte[] getEncryptedHmacKey();

    byte[] getEncryptedHmacValue();

    void setEncryptedHmacKey(byte[] bArr);

    void setEncryptedHmacValue(byte[] bArr);

    XmlBase64Binary xgetEncryptedHmacKey();

    XmlBase64Binary xgetEncryptedHmacValue();

    void xsetEncryptedHmacKey(XmlBase64Binary xmlBase64Binary);

    void xsetEncryptedHmacValue(XmlBase64Binary xmlBase64Binary);
}
