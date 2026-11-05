package com.microsoft.schemas.office.x2006.keyEncryptor.password;

import com.microsoft.schemas.office.x2006.encryption.STBlockSize;
import com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STCipherChaining;
import com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STHashSize;
import com.microsoft.schemas.office.x2006.encryption.STKeyBits;
import com.microsoft.schemas.office.x2006.encryption.STSaltSize;
import com.microsoft.schemas.office.x2006.encryption.STSpinCount;
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
public interface CTPasswordKeyEncryptor extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPasswordKeyEncryptor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctpasswordkeyencryptorde24type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPasswordKeyEncryptor newInstance() {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.newInstance(CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor newInstance(XmlOptions xmlOptions) {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.newInstance(CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(File file) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(file, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(file, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(inputStream, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(inputStream, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(Reader reader) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(reader, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(reader, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(String str) throws XmlException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(str, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(str, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(URL url) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(url, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(url, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(xMLStreamReader, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(xMLStreamReader, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(xMLInputStream, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(xMLInputStream, CTPasswordKeyEncryptor.type, xmlOptions);
        }

        public static CTPasswordKeyEncryptor parse(Node node) throws XmlException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(node, CTPasswordKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTPasswordKeyEncryptor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPasswordKeyEncryptor) POIXMLTypeLoader.parse(node, CTPasswordKeyEncryptor.type, xmlOptions);
        }
    }

    int getBlockSize();

    STCipherAlgorithm.Enum getCipherAlgorithm();

    STCipherChaining.Enum getCipherChaining();

    byte[] getEncryptedKeyValue();

    byte[] getEncryptedVerifierHashInput();

    byte[] getEncryptedVerifierHashValue();

    STHashAlgorithm.Enum getHashAlgorithm();

    int getHashSize();

    long getKeyBits();

    int getSaltSize();

    byte[] getSaltValue();

    int getSpinCount();

    void setBlockSize(int i);

    void setCipherAlgorithm(STCipherAlgorithm.Enum r1);

    void setCipherChaining(STCipherChaining.Enum r1);

    void setEncryptedKeyValue(byte[] bArr);

    void setEncryptedVerifierHashInput(byte[] bArr);

    void setEncryptedVerifierHashValue(byte[] bArr);

    void setHashAlgorithm(STHashAlgorithm.Enum r1);

    void setHashSize(int i);

    void setKeyBits(long j);

    void setSaltSize(int i);

    void setSaltValue(byte[] bArr);

    void setSpinCount(int i);

    STBlockSize xgetBlockSize();

    STCipherAlgorithm xgetCipherAlgorithm();

    STCipherChaining xgetCipherChaining();

    XmlBase64Binary xgetEncryptedKeyValue();

    XmlBase64Binary xgetEncryptedVerifierHashInput();

    XmlBase64Binary xgetEncryptedVerifierHashValue();

    STHashAlgorithm xgetHashAlgorithm();

    STHashSize xgetHashSize();

    STKeyBits xgetKeyBits();

    STSaltSize xgetSaltSize();

    XmlBase64Binary xgetSaltValue();

    STSpinCount xgetSpinCount();

    void xsetBlockSize(STBlockSize sTBlockSize);

    void xsetCipherAlgorithm(STCipherAlgorithm sTCipherAlgorithm);

    void xsetCipherChaining(STCipherChaining sTCipherChaining);

    void xsetEncryptedKeyValue(XmlBase64Binary xmlBase64Binary);

    void xsetEncryptedVerifierHashInput(XmlBase64Binary xmlBase64Binary);

    void xsetEncryptedVerifierHashValue(XmlBase64Binary xmlBase64Binary);

    void xsetHashAlgorithm(STHashAlgorithm sTHashAlgorithm);

    void xsetHashSize(STHashSize sTHashSize);

    void xsetKeyBits(STKeyBits sTKeyBits);

    void xsetSaltSize(STSaltSize sTSaltSize);

    void xsetSaltValue(XmlBase64Binary xmlBase64Binary);

    void xsetSpinCount(STSpinCount sTSpinCount);
}
