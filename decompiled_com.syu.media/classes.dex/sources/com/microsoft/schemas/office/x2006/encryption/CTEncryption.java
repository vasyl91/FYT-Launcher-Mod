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
public interface CTEncryption extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTEncryption.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctencryption365ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTEncryption newInstance() {
            return (CTEncryption) POIXMLTypeLoader.newInstance(CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption newInstance(XmlOptions xmlOptions) {
            return (CTEncryption) POIXMLTypeLoader.newInstance(CTEncryption.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEncryption.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(File file) throws XmlException, IOException {
            return (CTEncryption) POIXMLTypeLoader.parse(file, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEncryption) POIXMLTypeLoader.parse(file, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(InputStream inputStream) throws XmlException, IOException {
            return (CTEncryption) POIXMLTypeLoader.parse(inputStream, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEncryption) POIXMLTypeLoader.parse(inputStream, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(Reader reader) throws XmlException, IOException {
            return (CTEncryption) POIXMLTypeLoader.parse(reader, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEncryption) POIXMLTypeLoader.parse(reader, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(String str) throws XmlException {
            return (CTEncryption) POIXMLTypeLoader.parse(str, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTEncryption) POIXMLTypeLoader.parse(str, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(URL url) throws XmlException, IOException {
            return (CTEncryption) POIXMLTypeLoader.parse(url, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTEncryption) POIXMLTypeLoader.parse(url, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTEncryption) POIXMLTypeLoader.parse(xMLStreamReader, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTEncryption) POIXMLTypeLoader.parse(xMLStreamReader, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTEncryption) POIXMLTypeLoader.parse(xMLInputStream, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTEncryption) POIXMLTypeLoader.parse(xMLInputStream, CTEncryption.type, xmlOptions);
        }

        public static CTEncryption parse(Node node) throws XmlException {
            return (CTEncryption) POIXMLTypeLoader.parse(node, CTEncryption.type, (XmlOptions) null);
        }

        public static CTEncryption parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTEncryption) POIXMLTypeLoader.parse(node, CTEncryption.type, xmlOptions);
        }
    }

    CTDataIntegrity addNewDataIntegrity();

    CTKeyData addNewKeyData();

    CTKeyEncryptors addNewKeyEncryptors();

    CTDataIntegrity getDataIntegrity();

    CTKeyData getKeyData();

    CTKeyEncryptors getKeyEncryptors();

    void setDataIntegrity(CTDataIntegrity cTDataIntegrity);

    void setKeyData(CTKeyData cTKeyData);

    void setKeyEncryptors(CTKeyEncryptors cTKeyEncryptors);
}
