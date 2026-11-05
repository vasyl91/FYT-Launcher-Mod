package org.etsi.uri.x01903.v13;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3.x2000.x09.xmldsig.X509IssuerSerialType;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CertIDType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CertIDType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("certidtypee64dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CertIDType newInstance() {
            return (CertIDType) POIXMLTypeLoader.newInstance(CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType newInstance(XmlOptions xmlOptions) {
            return (CertIDType) POIXMLTypeLoader.newInstance(CertIDType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CertIDType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(File file) throws XmlException, IOException {
            return (CertIDType) POIXMLTypeLoader.parse(file, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDType) POIXMLTypeLoader.parse(file, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(InputStream inputStream) throws XmlException, IOException {
            return (CertIDType) POIXMLTypeLoader.parse(inputStream, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDType) POIXMLTypeLoader.parse(inputStream, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(Reader reader) throws XmlException, IOException {
            return (CertIDType) POIXMLTypeLoader.parse(reader, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDType) POIXMLTypeLoader.parse(reader, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(String str) throws XmlException {
            return (CertIDType) POIXMLTypeLoader.parse(str, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CertIDType) POIXMLTypeLoader.parse(str, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(URL url) throws XmlException, IOException {
            return (CertIDType) POIXMLTypeLoader.parse(url, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDType) POIXMLTypeLoader.parse(url, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CertIDType) POIXMLTypeLoader.parse(xMLStreamReader, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CertIDType) POIXMLTypeLoader.parse(xMLStreamReader, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CertIDType) POIXMLTypeLoader.parse(xMLInputStream, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CertIDType) POIXMLTypeLoader.parse(xMLInputStream, CertIDType.type, xmlOptions);
        }

        public static CertIDType parse(Node node) throws XmlException {
            return (CertIDType) POIXMLTypeLoader.parse(node, CertIDType.type, (XmlOptions) null);
        }

        public static CertIDType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CertIDType) POIXMLTypeLoader.parse(node, CertIDType.type, xmlOptions);
        }
    }

    DigestAlgAndValueType addNewCertDigest();

    X509IssuerSerialType addNewIssuerSerial();

    DigestAlgAndValueType getCertDigest();

    X509IssuerSerialType getIssuerSerial();

    String getURI();

    boolean isSetURI();

    void setCertDigest(DigestAlgAndValueType digestAlgAndValueType);

    void setIssuerSerial(X509IssuerSerialType x509IssuerSerialType);

    void setURI(String str);

    void unsetURI();

    XmlAnyURI xgetURI();

    void xsetURI(XmlAnyURI xmlAnyURI);
}
