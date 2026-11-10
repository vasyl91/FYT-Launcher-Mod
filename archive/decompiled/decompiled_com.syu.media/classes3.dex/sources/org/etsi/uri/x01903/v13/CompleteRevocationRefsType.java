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
public interface CompleteRevocationRefsType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CompleteRevocationRefsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("completerevocationrefstyped8a5type");

    public static final class Factory {
        private Factory() {
        }

        public static CompleteRevocationRefsType newInstance() {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.newInstance(CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType newInstance(XmlOptions xmlOptions) {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.newInstance(CompleteRevocationRefsType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(File file) throws XmlException, IOException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(file, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(file, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(InputStream inputStream) throws XmlException, IOException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(inputStream, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(inputStream, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(Reader reader) throws XmlException, IOException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(reader, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(reader, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(String str) throws XmlException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(str, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(str, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(URL url) throws XmlException, IOException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(url, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(url, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(xMLStreamReader, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(xMLStreamReader, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(xMLInputStream, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(xMLInputStream, CompleteRevocationRefsType.type, xmlOptions);
        }

        public static CompleteRevocationRefsType parse(Node node) throws XmlException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(node, CompleteRevocationRefsType.type, (XmlOptions) null);
        }

        public static CompleteRevocationRefsType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CompleteRevocationRefsType) POIXMLTypeLoader.parse(node, CompleteRevocationRefsType.type, xmlOptions);
        }
    }

    CRLRefsType addNewCRLRefs();

    OCSPRefsType addNewOCSPRefs();

    OtherCertStatusRefsType addNewOtherRefs();

    CRLRefsType getCRLRefs();

    String getId();

    OCSPRefsType getOCSPRefs();

    OtherCertStatusRefsType getOtherRefs();

    boolean isSetCRLRefs();

    boolean isSetId();

    boolean isSetOCSPRefs();

    boolean isSetOtherRefs();

    void setCRLRefs(CRLRefsType cRLRefsType);

    void setId(String str);

    void setOCSPRefs(OCSPRefsType oCSPRefsType);

    void setOtherRefs(OtherCertStatusRefsType otherCertStatusRefsType);

    void unsetCRLRefs();

    void unsetId();

    void unsetOCSPRefs();

    void unsetOtherRefs();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
