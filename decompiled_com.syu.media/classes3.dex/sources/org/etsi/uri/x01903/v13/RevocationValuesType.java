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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface RevocationValuesType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(RevocationValuesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("revocationvaluestype9a6etype");

    public static final class Factory {
        private Factory() {
        }

        public static RevocationValuesType newInstance() {
            return (RevocationValuesType) POIXMLTypeLoader.newInstance(RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType newInstance(XmlOptions xmlOptions) {
            return (RevocationValuesType) POIXMLTypeLoader.newInstance(RevocationValuesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, RevocationValuesType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(File file) throws XmlException, IOException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(file, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(file, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(InputStream inputStream) throws XmlException, IOException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(inputStream, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(inputStream, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(Reader reader) throws XmlException, IOException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(reader, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(reader, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(String str) throws XmlException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(str, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(str, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(URL url) throws XmlException, IOException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(url, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(url, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(xMLStreamReader, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(xMLStreamReader, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(xMLInputStream, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(xMLInputStream, RevocationValuesType.type, xmlOptions);
        }

        public static RevocationValuesType parse(Node node) throws XmlException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(node, RevocationValuesType.type, (XmlOptions) null);
        }

        public static RevocationValuesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (RevocationValuesType) POIXMLTypeLoader.parse(node, RevocationValuesType.type, xmlOptions);
        }
    }

    CRLValuesType addNewCRLValues();

    OCSPValuesType addNewOCSPValues();

    OtherCertStatusValuesType addNewOtherValues();

    CRLValuesType getCRLValues();

    String getId();

    OCSPValuesType getOCSPValues();

    OtherCertStatusValuesType getOtherValues();

    boolean isSetCRLValues();

    boolean isSetId();

    boolean isSetOCSPValues();

    boolean isSetOtherValues();

    void setCRLValues(CRLValuesType cRLValuesType);

    void setId(String str);

    void setOCSPValues(OCSPValuesType oCSPValuesType);

    void setOtherValues(OtherCertStatusValuesType otherCertStatusValuesType);

    void unsetCRLValues();

    void unsetId();

    void unsetOCSPValues();

    void unsetOtherValues();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
