package org.etsi.uri.x01903.v13;

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
import org.w3.x2000.x09.xmldsig.DigestMethodType;
import org.w3.x2000.x09.xmldsig.DigestValueType;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface DigestAlgAndValueType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(DigestAlgAndValueType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("digestalgandvaluetype234etype");

    public static final class Factory {
        private Factory() {
        }

        public static DigestAlgAndValueType newInstance() {
            return (DigestAlgAndValueType) POIXMLTypeLoader.newInstance(DigestAlgAndValueType.type, (XmlOptions) null);
        }

        public static DigestAlgAndValueType newInstance(XmlOptions xmlOptions) {
            return (DigestAlgAndValueType) POIXMLTypeLoader.newInstance(DigestAlgAndValueType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, DigestAlgAndValueType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, DigestAlgAndValueType.type, xmlOptions);
        }

        public static DigestAlgAndValueType parse(File file) throws XmlException, IOException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(file, DigestAlgAndValueType.type, (XmlOptions) null);
        }

        public static DigestAlgAndValueType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(file, DigestAlgAndValueType.type, xmlOptions);
        }

        public static DigestAlgAndValueType parse(InputStream inputStream) throws XmlException, IOException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(inputStream, DigestAlgAndValueType.type, (XmlOptions) null);
        }

        public static DigestAlgAndValueType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(inputStream, DigestAlgAndValueType.type, xmlOptions);
        }

        public static DigestAlgAndValueType parse(Reader reader) throws XmlException, IOException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(reader, DigestAlgAndValueType.type, (XmlOptions) null);
        }

        public static DigestAlgAndValueType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(reader, DigestAlgAndValueType.type, xmlOptions);
        }

        public static DigestAlgAndValueType parse(String str) throws XmlException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(str, DigestAlgAndValueType.type, (XmlOptions) null);
        }

        public static DigestAlgAndValueType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(str, DigestAlgAndValueType.type, xmlOptions);
        }

        public static DigestAlgAndValueType parse(URL url) throws XmlException, IOException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(url, DigestAlgAndValueType.type, (XmlOptions) null);
        }

        public static DigestAlgAndValueType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(url, DigestAlgAndValueType.type, xmlOptions);
        }

        public static DigestAlgAndValueType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(xMLStreamReader, DigestAlgAndValueType.type, (XmlOptions) null);
        }

        public static DigestAlgAndValueType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(xMLStreamReader, DigestAlgAndValueType.type, xmlOptions);
        }

        public static DigestAlgAndValueType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(xMLInputStream, DigestAlgAndValueType.type, (XmlOptions) null);
        }

        public static DigestAlgAndValueType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(xMLInputStream, DigestAlgAndValueType.type, xmlOptions);
        }

        public static DigestAlgAndValueType parse(Node node) throws XmlException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(node, DigestAlgAndValueType.type, (XmlOptions) null);
        }

        public static DigestAlgAndValueType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (DigestAlgAndValueType) POIXMLTypeLoader.parse(node, DigestAlgAndValueType.type, xmlOptions);
        }
    }

    DigestMethodType addNewDigestMethod();

    DigestMethodType getDigestMethod();

    byte[] getDigestValue();

    void setDigestMethod(DigestMethodType digestMethodType);

    void setDigestValue(byte[] bArr);

    DigestValueType xgetDigestValue();

    void xsetDigestValue(DigestValueType digestValueType);
}
