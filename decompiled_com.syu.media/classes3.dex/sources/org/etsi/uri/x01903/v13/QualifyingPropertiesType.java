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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface QualifyingPropertiesType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(QualifyingPropertiesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("qualifyingpropertiestype9e16type");

    public static final class Factory {
        private Factory() {
        }

        public static QualifyingPropertiesType newInstance() {
            return (QualifyingPropertiesType) POIXMLTypeLoader.newInstance(QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType newInstance(XmlOptions xmlOptions) {
            return (QualifyingPropertiesType) POIXMLTypeLoader.newInstance(QualifyingPropertiesType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(File file) throws XmlException, IOException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(file, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(file, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(InputStream inputStream) throws XmlException, IOException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(inputStream, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(inputStream, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(Reader reader) throws XmlException, IOException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(reader, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(reader, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(String str) throws XmlException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(str, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(str, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(URL url) throws XmlException, IOException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(url, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(url, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(xMLStreamReader, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(xMLStreamReader, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(xMLInputStream, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(xMLInputStream, QualifyingPropertiesType.type, xmlOptions);
        }

        public static QualifyingPropertiesType parse(Node node) throws XmlException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(node, QualifyingPropertiesType.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (QualifyingPropertiesType) POIXMLTypeLoader.parse(node, QualifyingPropertiesType.type, xmlOptions);
        }
    }

    SignedPropertiesType addNewSignedProperties();

    UnsignedPropertiesType addNewUnsignedProperties();

    String getId();

    SignedPropertiesType getSignedProperties();

    String getTarget();

    UnsignedPropertiesType getUnsignedProperties();

    boolean isSetId();

    boolean isSetSignedProperties();

    boolean isSetUnsignedProperties();

    void setId(String str);

    void setSignedProperties(SignedPropertiesType signedPropertiesType);

    void setTarget(String str);

    void setUnsignedProperties(UnsignedPropertiesType unsignedPropertiesType);

    void unsetId();

    void unsetSignedProperties();

    void unsetUnsignedProperties();

    XmlID xgetId();

    XmlAnyURI xgetTarget();

    void xsetId(XmlID xmlID);

    void xsetTarget(XmlAnyURI xmlAnyURI);
}
