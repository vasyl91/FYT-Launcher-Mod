package org.w3.x2000.x09.xmldsig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface X509IssuerSerialType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(X509IssuerSerialType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("x509issuerserialtype7eb2type");

    public static final class Factory {
        private Factory() {
        }

        public static X509IssuerSerialType newInstance() {
            return (X509IssuerSerialType) POIXMLTypeLoader.newInstance(X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType newInstance(XmlOptions xmlOptions) {
            return (X509IssuerSerialType) POIXMLTypeLoader.newInstance(X509IssuerSerialType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(File file) throws XmlException, IOException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(file, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(file, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(InputStream inputStream) throws XmlException, IOException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(inputStream, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(inputStream, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(Reader reader) throws XmlException, IOException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(reader, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(reader, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(String str) throws XmlException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(str, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(str, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(URL url) throws XmlException, IOException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(url, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(url, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(xMLStreamReader, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(xMLStreamReader, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(xMLInputStream, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(xMLInputStream, X509IssuerSerialType.type, xmlOptions);
        }

        public static X509IssuerSerialType parse(Node node) throws XmlException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(node, X509IssuerSerialType.type, (XmlOptions) null);
        }

        public static X509IssuerSerialType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (X509IssuerSerialType) POIXMLTypeLoader.parse(node, X509IssuerSerialType.type, xmlOptions);
        }
    }

    String getX509IssuerName();

    BigInteger getX509SerialNumber();

    void setX509IssuerName(String str);

    void setX509SerialNumber(BigInteger bigInteger);

    XmlString xgetX509IssuerName();

    XmlInteger xgetX509SerialNumber();

    void xsetX509IssuerName(XmlString xmlString);

    void xsetX509SerialNumber(XmlInteger xmlInteger);
}
