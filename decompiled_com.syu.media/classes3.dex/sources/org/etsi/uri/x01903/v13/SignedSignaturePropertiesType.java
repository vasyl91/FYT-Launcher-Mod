package org.etsi.uri.x01903.v13;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface SignedSignaturePropertiesType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SignedSignaturePropertiesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("signedsignaturepropertiestype06abtype");

    public static final class Factory {
        private Factory() {
        }

        public static SignedSignaturePropertiesType newInstance() {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.newInstance(SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType newInstance(XmlOptions xmlOptions) {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.newInstance(SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(File file) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(file, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(file, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(InputStream inputStream) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(inputStream, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(inputStream, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(Reader reader) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(reader, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(reader, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(String str) throws XmlException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(str, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(str, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(URL url) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(url, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(url, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(xMLStreamReader, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(xMLStreamReader, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(xMLInputStream, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(xMLInputStream, SignedSignaturePropertiesType.type, xmlOptions);
        }

        public static SignedSignaturePropertiesType parse(Node node) throws XmlException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(node, SignedSignaturePropertiesType.type, (XmlOptions) null);
        }

        public static SignedSignaturePropertiesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SignedSignaturePropertiesType) POIXMLTypeLoader.parse(node, SignedSignaturePropertiesType.type, xmlOptions);
        }
    }

    SignaturePolicyIdentifierType addNewSignaturePolicyIdentifier();

    SignatureProductionPlaceType addNewSignatureProductionPlace();

    SignerRoleType addNewSignerRole();

    CertIDListType addNewSigningCertificate();

    String getId();

    SignaturePolicyIdentifierType getSignaturePolicyIdentifier();

    SignatureProductionPlaceType getSignatureProductionPlace();

    SignerRoleType getSignerRole();

    CertIDListType getSigningCertificate();

    Calendar getSigningTime();

    boolean isSetId();

    boolean isSetSignaturePolicyIdentifier();

    boolean isSetSignatureProductionPlace();

    boolean isSetSignerRole();

    boolean isSetSigningCertificate();

    boolean isSetSigningTime();

    void setId(String str);

    void setSignaturePolicyIdentifier(SignaturePolicyIdentifierType signaturePolicyIdentifierType);

    void setSignatureProductionPlace(SignatureProductionPlaceType signatureProductionPlaceType);

    void setSignerRole(SignerRoleType signerRoleType);

    void setSigningCertificate(CertIDListType certIDListType);

    void setSigningTime(Calendar calendar);

    void unsetId();

    void unsetSignaturePolicyIdentifier();

    void unsetSignatureProductionPlace();

    void unsetSignerRole();

    void unsetSigningCertificate();

    void unsetSigningTime();

    XmlID xgetId();

    XmlDateTime xgetSigningTime();

    void xsetId(XmlID xmlID);

    void xsetSigningTime(XmlDateTime xmlDateTime);
}
