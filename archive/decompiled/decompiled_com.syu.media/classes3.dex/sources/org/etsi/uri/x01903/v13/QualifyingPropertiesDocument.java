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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface QualifyingPropertiesDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(QualifyingPropertiesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("qualifyingproperties53ccdoctype");

    public static final class Factory {
        private Factory() {
        }

        public static QualifyingPropertiesDocument newInstance() {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.newInstance(QualifyingPropertiesDocument.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesDocument newInstance(XmlOptions xmlOptions) {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.newInstance(QualifyingPropertiesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, QualifyingPropertiesDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, QualifyingPropertiesDocument.type, xmlOptions);
        }

        public static QualifyingPropertiesDocument parse(File file) throws XmlException, IOException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(file, QualifyingPropertiesDocument.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(file, QualifyingPropertiesDocument.type, xmlOptions);
        }

        public static QualifyingPropertiesDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(inputStream, QualifyingPropertiesDocument.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(inputStream, QualifyingPropertiesDocument.type, xmlOptions);
        }

        public static QualifyingPropertiesDocument parse(Reader reader) throws XmlException, IOException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(reader, QualifyingPropertiesDocument.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(reader, QualifyingPropertiesDocument.type, xmlOptions);
        }

        public static QualifyingPropertiesDocument parse(String str) throws XmlException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(str, QualifyingPropertiesDocument.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(str, QualifyingPropertiesDocument.type, xmlOptions);
        }

        public static QualifyingPropertiesDocument parse(URL url) throws XmlException, IOException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(url, QualifyingPropertiesDocument.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(url, QualifyingPropertiesDocument.type, xmlOptions);
        }

        public static QualifyingPropertiesDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(xMLStreamReader, QualifyingPropertiesDocument.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(xMLStreamReader, QualifyingPropertiesDocument.type, xmlOptions);
        }

        public static QualifyingPropertiesDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(xMLInputStream, QualifyingPropertiesDocument.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(xMLInputStream, QualifyingPropertiesDocument.type, xmlOptions);
        }

        public static QualifyingPropertiesDocument parse(Node node) throws XmlException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(node, QualifyingPropertiesDocument.type, (XmlOptions) null);
        }

        public static QualifyingPropertiesDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (QualifyingPropertiesDocument) POIXMLTypeLoader.parse(node, QualifyingPropertiesDocument.type, xmlOptions);
        }
    }

    QualifyingPropertiesType addNewQualifyingProperties();

    QualifyingPropertiesType getQualifyingProperties();

    void setQualifyingProperties(QualifyingPropertiesType qualifyingPropertiesType);
}
