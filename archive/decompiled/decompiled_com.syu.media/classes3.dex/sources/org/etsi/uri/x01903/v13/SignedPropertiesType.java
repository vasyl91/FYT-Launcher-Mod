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
public interface SignedPropertiesType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SignedPropertiesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("signedpropertiestype163dtype");

    public static final class Factory {
        private Factory() {
        }

        public static SignedPropertiesType newInstance() {
            return (SignedPropertiesType) POIXMLTypeLoader.newInstance(SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType newInstance(XmlOptions xmlOptions) {
            return (SignedPropertiesType) POIXMLTypeLoader.newInstance(SignedPropertiesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(File file) throws XmlException, IOException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(file, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(file, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(InputStream inputStream) throws XmlException, IOException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(inputStream, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(inputStream, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(Reader reader) throws XmlException, IOException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(reader, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(reader, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(String str) throws XmlException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(str, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(str, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(URL url) throws XmlException, IOException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(url, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(url, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(xMLStreamReader, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(xMLStreamReader, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(xMLInputStream, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(xMLInputStream, SignedPropertiesType.type, xmlOptions);
        }

        public static SignedPropertiesType parse(Node node) throws XmlException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(node, SignedPropertiesType.type, (XmlOptions) null);
        }

        public static SignedPropertiesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SignedPropertiesType) POIXMLTypeLoader.parse(node, SignedPropertiesType.type, xmlOptions);
        }
    }

    SignedDataObjectPropertiesType addNewSignedDataObjectProperties();

    SignedSignaturePropertiesType addNewSignedSignatureProperties();

    String getId();

    SignedDataObjectPropertiesType getSignedDataObjectProperties();

    SignedSignaturePropertiesType getSignedSignatureProperties();

    boolean isSetId();

    boolean isSetSignedDataObjectProperties();

    boolean isSetSignedSignatureProperties();

    void setId(String str);

    void setSignedDataObjectProperties(SignedDataObjectPropertiesType signedDataObjectPropertiesType);

    void setSignedSignatureProperties(SignedSignaturePropertiesType signedSignaturePropertiesType);

    void unsetId();

    void unsetSignedDataObjectProperties();

    void unsetSignedSignatureProperties();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
