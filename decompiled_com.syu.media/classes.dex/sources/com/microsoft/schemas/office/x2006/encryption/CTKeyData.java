package com.microsoft.schemas.office.x2006.encryption;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface CTKeyData extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTKeyData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctkeydata6bdbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTKeyData newInstance() {
            return (CTKeyData) POIXMLTypeLoader.newInstance(CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData newInstance(XmlOptions xmlOptions) {
            return (CTKeyData) POIXMLTypeLoader.newInstance(CTKeyData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTKeyData.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(File file) throws XmlException, IOException {
            return (CTKeyData) POIXMLTypeLoader.parse(file, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyData) POIXMLTypeLoader.parse(file, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTKeyData) POIXMLTypeLoader.parse(inputStream, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyData) POIXMLTypeLoader.parse(inputStream, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(Reader reader) throws XmlException, IOException {
            return (CTKeyData) POIXMLTypeLoader.parse(reader, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyData) POIXMLTypeLoader.parse(reader, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(String str) throws XmlException {
            return (CTKeyData) POIXMLTypeLoader.parse(str, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyData) POIXMLTypeLoader.parse(str, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(URL url) throws XmlException, IOException {
            return (CTKeyData) POIXMLTypeLoader.parse(url, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyData) POIXMLTypeLoader.parse(url, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTKeyData) POIXMLTypeLoader.parse(xMLStreamReader, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyData) POIXMLTypeLoader.parse(xMLStreamReader, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTKeyData) POIXMLTypeLoader.parse(xMLInputStream, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTKeyData) POIXMLTypeLoader.parse(xMLInputStream, CTKeyData.type, xmlOptions);
        }

        public static CTKeyData parse(Node node) throws XmlException {
            return (CTKeyData) POIXMLTypeLoader.parse(node, CTKeyData.type, (XmlOptions) null);
        }

        public static CTKeyData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyData) POIXMLTypeLoader.parse(node, CTKeyData.type, xmlOptions);
        }
    }

    int getBlockSize();

    STCipherAlgorithm.Enum getCipherAlgorithm();

    STCipherChaining.Enum getCipherChaining();

    STHashAlgorithm.Enum getHashAlgorithm();

    int getHashSize();

    long getKeyBits();

    int getSaltSize();

    byte[] getSaltValue();

    void setBlockSize(int i);

    void setCipherAlgorithm(STCipherAlgorithm.Enum r1);

    void setCipherChaining(STCipherChaining.Enum r1);

    void setHashAlgorithm(STHashAlgorithm.Enum r1);

    void setHashSize(int i);

    void setKeyBits(long j);

    void setSaltSize(int i);

    void setSaltValue(byte[] bArr);

    STBlockSize xgetBlockSize();

    STCipherAlgorithm xgetCipherAlgorithm();

    STCipherChaining xgetCipherChaining();

    STHashAlgorithm xgetHashAlgorithm();

    STHashSize xgetHashSize();

    STKeyBits xgetKeyBits();

    STSaltSize xgetSaltSize();

    XmlBase64Binary xgetSaltValue();

    void xsetBlockSize(STBlockSize sTBlockSize);

    void xsetCipherAlgorithm(STCipherAlgorithm sTCipherAlgorithm);

    void xsetCipherChaining(STCipherChaining sTCipherChaining);

    void xsetHashAlgorithm(STHashAlgorithm sTHashAlgorithm);

    void xsetHashSize(STHashSize sTHashSize);

    void xsetKeyBits(STKeyBits sTKeyBits);

    void xsetSaltSize(STSaltSize sTSaltSize);

    void xsetSaltValue(XmlBase64Binary xmlBase64Binary);
}
