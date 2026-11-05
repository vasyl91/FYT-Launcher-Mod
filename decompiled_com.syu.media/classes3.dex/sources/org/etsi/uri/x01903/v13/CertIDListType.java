package org.etsi.uri.x01903.v13;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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
public interface CertIDListType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CertIDListType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("certidlisttype488btype");

    public static final class Factory {
        private Factory() {
        }

        public static CertIDListType newInstance() {
            return (CertIDListType) POIXMLTypeLoader.newInstance(CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType newInstance(XmlOptions xmlOptions) {
            return (CertIDListType) POIXMLTypeLoader.newInstance(CertIDListType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CertIDListType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(File file) throws XmlException, IOException {
            return (CertIDListType) POIXMLTypeLoader.parse(file, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDListType) POIXMLTypeLoader.parse(file, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(InputStream inputStream) throws XmlException, IOException {
            return (CertIDListType) POIXMLTypeLoader.parse(inputStream, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDListType) POIXMLTypeLoader.parse(inputStream, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(Reader reader) throws XmlException, IOException {
            return (CertIDListType) POIXMLTypeLoader.parse(reader, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDListType) POIXMLTypeLoader.parse(reader, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(String str) throws XmlException {
            return (CertIDListType) POIXMLTypeLoader.parse(str, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CertIDListType) POIXMLTypeLoader.parse(str, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(URL url) throws XmlException, IOException {
            return (CertIDListType) POIXMLTypeLoader.parse(url, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CertIDListType) POIXMLTypeLoader.parse(url, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CertIDListType) POIXMLTypeLoader.parse(xMLStreamReader, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CertIDListType) POIXMLTypeLoader.parse(xMLStreamReader, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CertIDListType) POIXMLTypeLoader.parse(xMLInputStream, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CertIDListType) POIXMLTypeLoader.parse(xMLInputStream, CertIDListType.type, xmlOptions);
        }

        public static CertIDListType parse(Node node) throws XmlException {
            return (CertIDListType) POIXMLTypeLoader.parse(node, CertIDListType.type, (XmlOptions) null);
        }

        public static CertIDListType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CertIDListType) POIXMLTypeLoader.parse(node, CertIDListType.type, xmlOptions);
        }
    }

    CertIDType addNewCert();

    CertIDType getCertArray(int i);

    CertIDType[] getCertArray();

    List<CertIDType> getCertList();

    CertIDType insertNewCert(int i);

    void removeCert(int i);

    void setCertArray(int i, CertIDType certIDType);

    void setCertArray(CertIDType[] certIDTypeArr);

    int sizeOfCertArray();
}
