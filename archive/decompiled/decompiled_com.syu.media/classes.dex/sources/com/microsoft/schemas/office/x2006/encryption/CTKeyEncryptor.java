package com.microsoft.schemas.office.x2006.encryption;

import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface CTKeyEncryptor extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTKeyEncryptor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctkeyencryptor1205type");

    public static final class Factory {
        private Factory() {
        }

        public static CTKeyEncryptor newInstance() {
            return (CTKeyEncryptor) POIXMLTypeLoader.newInstance(CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor newInstance(XmlOptions xmlOptions) {
            return (CTKeyEncryptor) POIXMLTypeLoader.newInstance(CTKeyEncryptor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(File file) throws XmlException, IOException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(file, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(file, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(inputStream, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(inputStream, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(Reader reader) throws XmlException, IOException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(reader, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(reader, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(String str) throws XmlException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(str, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(str, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(URL url) throws XmlException, IOException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(url, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(url, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(xMLStreamReader, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(xMLStreamReader, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(xMLInputStream, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(xMLInputStream, CTKeyEncryptor.type, xmlOptions);
        }

        public static CTKeyEncryptor parse(Node node) throws XmlException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(node, CTKeyEncryptor.type, (XmlOptions) null);
        }

        public static CTKeyEncryptor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTKeyEncryptor) POIXMLTypeLoader.parse(node, CTKeyEncryptor.type, xmlOptions);
        }
    }

    public interface Uri extends XmlToken {
        public static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE = 2;
        public static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD = 1;
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Uri.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("uribad9attrtype");
        public static final Enum HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD = Enum.forString("http://schemas.microsoft.com/office/2006/keyEncryptor/password");
        public static final Enum HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE = Enum.forString("http://schemas.microsoft.com/office/2006/keyEncryptor/certificate");

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE = 2;
            static final int INT_HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("http://schemas.microsoft.com/office/2006/keyEncryptor/password", 1), new Enum("http://schemas.microsoft.com/office/2006/keyEncryptor/certificate", 2)});

            private Enum(String str, int i) {
                super(str, i);
            }

            public static Enum forInt(int i) {
                return (Enum) table.forInt(i);
            }

            public static Enum forString(String str) {
                return (Enum) table.forString(str);
            }

            private Object readResolve() {
                return forInt(intValue());
            }
        }

        public static final class Factory {
            private Factory() {
            }

            public static Uri newInstance() {
                return POIXMLTypeLoader.newInstance(Uri.type, (XmlOptions) null);
            }

            public static Uri newInstance(XmlOptions xmlOptions) {
                return POIXMLTypeLoader.newInstance(Uri.type, xmlOptions);
            }

            public static Uri newValue(Object obj) {
                return Uri.type.newValue(obj);
            }
        }

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);
    }

    CTCertificateKeyEncryptor addNewEncryptedCertificateKey();

    CTPasswordKeyEncryptor addNewEncryptedPasswordKey();

    CTCertificateKeyEncryptor getEncryptedCertificateKey();

    CTPasswordKeyEncryptor getEncryptedPasswordKey();

    Uri.Enum getUri();

    boolean isSetEncryptedCertificateKey();

    boolean isSetEncryptedPasswordKey();

    boolean isSetUri();

    void setEncryptedCertificateKey(CTCertificateKeyEncryptor cTCertificateKeyEncryptor);

    void setEncryptedPasswordKey(CTPasswordKeyEncryptor cTPasswordKeyEncryptor);

    void setUri(Uri.Enum r1);

    void unsetEncryptedCertificateKey();

    void unsetEncryptedPasswordKey();

    void unsetUri();

    Uri xgetUri();

    void xsetUri(Uri uri);
}
