package com.microsoft.schemas.office.x2006.encryption;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface CTKeyEncryptors extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTKeyEncryptors.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctkeyencryptorsa09ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTKeyEncryptors newInstance() {
            return (CTKeyEncryptors) POIXMLTypeLoader.newInstance(CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors newInstance(XmlOptions xmlOptions) {
            return (CTKeyEncryptors) POIXMLTypeLoader.newInstance(CTKeyEncryptors.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(File file) throws XmlException, IOException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(file, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(file, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(InputStream inputStream) throws XmlException, IOException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(inputStream, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(inputStream, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(Reader reader) throws XmlException, IOException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(reader, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(reader, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(String str) throws XmlException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(str, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(str, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(URL url) throws XmlException, IOException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(url, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(url, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(xMLStreamReader, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(xMLStreamReader, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(xMLInputStream, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(xMLInputStream, CTKeyEncryptors.type, xmlOptions);
        }

        public static CTKeyEncryptors parse(Node node) throws XmlException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(node, CTKeyEncryptors.type, (XmlOptions) null);
        }

        public static CTKeyEncryptors parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyEncryptors) POIXMLTypeLoader.parse(node, CTKeyEncryptors.type, xmlOptions);
        }
    }

    CTKeyEncryptor addNewKeyEncryptor();

    CTKeyEncryptor getKeyEncryptorArray(int i);

    CTKeyEncryptor[] getKeyEncryptorArray();

    List<CTKeyEncryptor> getKeyEncryptorList();

    CTKeyEncryptor insertNewKeyEncryptor(int i);

    void removeKeyEncryptor(int i);

    void setKeyEncryptorArray(int i, CTKeyEncryptor cTKeyEncryptor);

    void setKeyEncryptorArray(CTKeyEncryptor[] cTKeyEncryptorArr);

    int sizeOfKeyEncryptorArray();
}
