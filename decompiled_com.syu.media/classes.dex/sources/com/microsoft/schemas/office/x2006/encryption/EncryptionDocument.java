package com.microsoft.schemas.office.x2006.encryption;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface EncryptionDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(EncryptionDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("encryptione8b3doctype");

    public static final class Factory {
        private Factory() {
        }

        public static EncryptionDocument newInstance() {
            return (EncryptionDocument) POIXMLTypeLoader.newInstance(EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument newInstance(XmlOptions xmlOptions) {
            return (EncryptionDocument) POIXMLTypeLoader.newInstance(EncryptionDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, EncryptionDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(File file) throws XmlException, IOException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(file, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(file, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(inputStream, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(inputStream, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(Reader reader) throws XmlException, IOException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(reader, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(reader, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(String str) throws XmlException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(str, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(str, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(URL url) throws XmlException, IOException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(url, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(url, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(xMLStreamReader, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(xMLStreamReader, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(xMLInputStream, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(xMLInputStream, EncryptionDocument.type, xmlOptions);
        }

        public static EncryptionDocument parse(Node node) throws XmlException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(node, EncryptionDocument.type, (XmlOptions) null);
        }

        public static EncryptionDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (EncryptionDocument) POIXMLTypeLoader.parse(node, EncryptionDocument.type, xmlOptions);
        }
    }

    CTEncryption addNewEncryption();

    CTEncryption getEncryption();

    void setEncryption(CTEncryption cTEncryption);
}
