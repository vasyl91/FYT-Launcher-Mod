package com.microsoft.schemas.office.x2006.digsig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface CTSignatureInfoV1 extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSignatureInfoV1.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctsignatureinfov13a5ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSignatureInfoV1 newInstance() {
            return (CTSignatureInfoV1) POIXMLTypeLoader.newInstance(CTSignatureInfoV1.type, (XmlOptions) null);
        }

        public static CTSignatureInfoV1 newInstance(XmlOptions xmlOptions) {
            return (CTSignatureInfoV1) POIXMLTypeLoader.newInstance(CTSignatureInfoV1.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSignatureInfoV1.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSignatureInfoV1.type, xmlOptions);
        }

        public static CTSignatureInfoV1 parse(File file) throws XmlException, IOException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(file, CTSignatureInfoV1.type, (XmlOptions) null);
        }

        public static CTSignatureInfoV1 parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(file, CTSignatureInfoV1.type, xmlOptions);
        }

        public static CTSignatureInfoV1 parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(inputStream, CTSignatureInfoV1.type, (XmlOptions) null);
        }

        public static CTSignatureInfoV1 parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(inputStream, CTSignatureInfoV1.type, xmlOptions);
        }

        public static CTSignatureInfoV1 parse(Reader reader) throws XmlException, IOException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(reader, CTSignatureInfoV1.type, (XmlOptions) null);
        }

        public static CTSignatureInfoV1 parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(reader, CTSignatureInfoV1.type, xmlOptions);
        }

        public static CTSignatureInfoV1 parse(String str) throws XmlException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(str, CTSignatureInfoV1.type, (XmlOptions) null);
        }

        public static CTSignatureInfoV1 parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(str, CTSignatureInfoV1.type, xmlOptions);
        }

        public static CTSignatureInfoV1 parse(URL url) throws XmlException, IOException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(url, CTSignatureInfoV1.type, (XmlOptions) null);
        }

        public static CTSignatureInfoV1 parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(url, CTSignatureInfoV1.type, xmlOptions);
        }

        public static CTSignatureInfoV1 parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(xMLStreamReader, CTSignatureInfoV1.type, (XmlOptions) null);
        }

        public static CTSignatureInfoV1 parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(xMLStreamReader, CTSignatureInfoV1.type, xmlOptions);
        }

        public static CTSignatureInfoV1 parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(xMLInputStream, CTSignatureInfoV1.type, (XmlOptions) null);
        }

        public static CTSignatureInfoV1 parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(xMLInputStream, CTSignatureInfoV1.type, xmlOptions);
        }

        public static CTSignatureInfoV1 parse(Node node) throws XmlException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(node, CTSignatureInfoV1.type, (XmlOptions) null);
        }

        public static CTSignatureInfoV1 parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSignatureInfoV1) POIXMLTypeLoader.parse(node, CTSignatureInfoV1.type, xmlOptions);
        }
    }

    String getApplicationVersion();

    int getColorDepth();

    String getDelegateSuggestedSigner();

    String getDelegateSuggestedSigner2();

    String getDelegateSuggestedSignerEmail();

    int getHorizontalResolution();

    String getManifestHashAlgorithm();

    int getMonitors();

    String getOfficeVersion();

    String getSetupID();

    String getSignatureComments();

    byte[] getSignatureImage();

    int getSignatureProviderDetails();

    String getSignatureProviderId();

    String getSignatureProviderUrl();

    String getSignatureText();

    int getSignatureType();

    int getVerticalResolution();

    String getWindowsVersion();

    boolean isSetDelegateSuggestedSigner();

    boolean isSetDelegateSuggestedSigner2();

    boolean isSetDelegateSuggestedSignerEmail();

    boolean isSetManifestHashAlgorithm();

    void setApplicationVersion(String str);

    void setColorDepth(int i);

    void setDelegateSuggestedSigner(String str);

    void setDelegateSuggestedSigner2(String str);

    void setDelegateSuggestedSignerEmail(String str);

    void setHorizontalResolution(int i);

    void setManifestHashAlgorithm(String str);

    void setMonitors(int i);

    void setOfficeVersion(String str);

    void setSetupID(String str);

    void setSignatureComments(String str);

    void setSignatureImage(byte[] bArr);

    void setSignatureProviderDetails(int i);

    void setSignatureProviderId(String str);

    void setSignatureProviderUrl(String str);

    void setSignatureText(String str);

    void setSignatureType(int i);

    void setVerticalResolution(int i);

    void setWindowsVersion(String str);

    void unsetDelegateSuggestedSigner();

    void unsetDelegateSuggestedSigner2();

    void unsetDelegateSuggestedSignerEmail();

    void unsetManifestHashAlgorithm();

    STVersion xgetApplicationVersion();

    STPositiveInteger xgetColorDepth();

    XmlString xgetDelegateSuggestedSigner();

    XmlString xgetDelegateSuggestedSigner2();

    XmlString xgetDelegateSuggestedSignerEmail();

    STPositiveInteger xgetHorizontalResolution();

    XmlAnyURI xgetManifestHashAlgorithm();

    STPositiveInteger xgetMonitors();

    STVersion xgetOfficeVersion();

    STUniqueIdentifierWithBraces xgetSetupID();

    STSignatureComments xgetSignatureComments();

    XmlBase64Binary xgetSignatureImage();

    XmlInt xgetSignatureProviderDetails();

    STUniqueIdentifierWithBraces xgetSignatureProviderId();

    STSignatureProviderUrl xgetSignatureProviderUrl();

    STSignatureText xgetSignatureText();

    STSignatureType xgetSignatureType();

    STPositiveInteger xgetVerticalResolution();

    STVersion xgetWindowsVersion();

    void xsetApplicationVersion(STVersion sTVersion);

    void xsetColorDepth(STPositiveInteger sTPositiveInteger);

    void xsetDelegateSuggestedSigner(XmlString xmlString);

    void xsetDelegateSuggestedSigner2(XmlString xmlString);

    void xsetDelegateSuggestedSignerEmail(XmlString xmlString);

    void xsetHorizontalResolution(STPositiveInteger sTPositiveInteger);

    void xsetManifestHashAlgorithm(XmlAnyURI xmlAnyURI);

    void xsetMonitors(STPositiveInteger sTPositiveInteger);

    void xsetOfficeVersion(STVersion sTVersion);

    void xsetSetupID(STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces);

    void xsetSignatureComments(STSignatureComments sTSignatureComments);

    void xsetSignatureImage(XmlBase64Binary xmlBase64Binary);

    void xsetSignatureProviderDetails(XmlInt xmlInt);

    void xsetSignatureProviderId(STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces);

    void xsetSignatureProviderUrl(STSignatureProviderUrl sTSignatureProviderUrl);

    void xsetSignatureText(STSignatureText sTSignatureText);

    void xsetSignatureType(STSignatureType sTSignatureType);

    void xsetVerticalResolution(STPositiveInteger sTPositiveInteger);

    void xsetWindowsVersion(STVersion sTVersion);
}
