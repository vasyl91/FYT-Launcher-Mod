package com.microsoft.schemas.office.x2006.keyEncryptor.certificate;

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
public interface CTCertificateKeyEncryptor extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCertificateKeyEncryptor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctcertificatekeyencryptor1a80type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCertificateKeyEncryptor newInstance() {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.newInstance(CTCertificateKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTCertificateKeyEncryptor newInstance(XmlOptions xmlOptions) {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.newInstance(CTCertificateKeyEncryptor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCertificateKeyEncryptor.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCertificateKeyEncryptor.type, xmlOptions);
        }

        public static CTCertificateKeyEncryptor parse(File file) throws XmlException, IOException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(file, CTCertificateKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTCertificateKeyEncryptor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(file, CTCertificateKeyEncryptor.type, xmlOptions);
        }

        public static CTCertificateKeyEncryptor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(inputStream, CTCertificateKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTCertificateKeyEncryptor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(inputStream, CTCertificateKeyEncryptor.type, xmlOptions);
        }

        public static CTCertificateKeyEncryptor parse(Reader reader) throws XmlException, IOException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(reader, CTCertificateKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTCertificateKeyEncryptor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(reader, CTCertificateKeyEncryptor.type, xmlOptions);
        }

        public static CTCertificateKeyEncryptor parse(String str) throws XmlException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(str, CTCertificateKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTCertificateKeyEncryptor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(str, CTCertificateKeyEncryptor.type, xmlOptions);
        }

        public static CTCertificateKeyEncryptor parse(URL url) throws XmlException, IOException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(url, CTCertificateKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTCertificateKeyEncryptor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(url, CTCertificateKeyEncryptor.type, xmlOptions);
        }

        public static CTCertificateKeyEncryptor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(xMLStreamReader, CTCertificateKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTCertificateKeyEncryptor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(xMLStreamReader, CTCertificateKeyEncryptor.type, xmlOptions);
        }

        public static CTCertificateKeyEncryptor parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(xMLInputStream, CTCertificateKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTCertificateKeyEncryptor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(xMLInputStream, CTCertificateKeyEncryptor.type, xmlOptions);
        }

        public static CTCertificateKeyEncryptor parse(Node node) throws XmlException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(node, CTCertificateKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTCertificateKeyEncryptor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCertificateKeyEncryptor) POIXMLTypeLoader.parse(node, CTCertificateKeyEncryptor.type, xmlOptions);
        }
    }

    byte[] getCertVerifier();

    byte[] getEncryptedKeyValue();

    byte[] getX509Certificate();

    void setCertVerifier(byte[] bArr);

    void setEncryptedKeyValue(byte[] bArr);

    void setX509Certificate(byte[] bArr);

    XmlBase64Binary xgetCertVerifier();

    XmlBase64Binary xgetEncryptedKeyValue();

    XmlBase64Binary xgetX509Certificate();

    void xsetCertVerifier(XmlBase64Binary xmlBase64Binary);

    void xsetEncryptedKeyValue(XmlBase64Binary xmlBase64Binary);

    void xsetX509Certificate(XmlBase64Binary xmlBase64Binary);
}
