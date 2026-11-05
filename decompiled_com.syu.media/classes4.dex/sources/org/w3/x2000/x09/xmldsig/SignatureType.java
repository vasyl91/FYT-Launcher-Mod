package org.w3.x2000.x09.xmldsig;

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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface SignatureType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SignatureType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("signaturetype0a3ftype");

    public static final class Factory {
        private Factory() {
        }

        public static SignatureType newInstance() {
            return (SignatureType) POIXMLTypeLoader.newInstance(SignatureType.type, (XmlOptions) null);
        }

        public static SignatureType newInstance(XmlOptions xmlOptions) {
            return (SignatureType) POIXMLTypeLoader.newInstance(SignatureType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SignatureType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SignatureType.type, xmlOptions);
        }

        public static SignatureType parse(File file) throws XmlException, IOException {
            return (SignatureType) POIXMLTypeLoader.parse(file, SignatureType.type, (XmlOptions) null);
        }

        public static SignatureType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureType) POIXMLTypeLoader.parse(file, SignatureType.type, xmlOptions);
        }

        public static SignatureType parse(InputStream inputStream) throws XmlException, IOException {
            return (SignatureType) POIXMLTypeLoader.parse(inputStream, SignatureType.type, (XmlOptions) null);
        }

        public static SignatureType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureType) POIXMLTypeLoader.parse(inputStream, SignatureType.type, xmlOptions);
        }

        public static SignatureType parse(Reader reader) throws XmlException, IOException {
            return (SignatureType) POIXMLTypeLoader.parse(reader, SignatureType.type, (XmlOptions) null);
        }

        public static SignatureType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureType) POIXMLTypeLoader.parse(reader, SignatureType.type, xmlOptions);
        }

        public static SignatureType parse(String str) throws XmlException {
            return (SignatureType) POIXMLTypeLoader.parse(str, SignatureType.type, (XmlOptions) null);
        }

        public static SignatureType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SignatureType) POIXMLTypeLoader.parse(str, SignatureType.type, xmlOptions);
        }

        public static SignatureType parse(URL url) throws XmlException, IOException {
            return (SignatureType) POIXMLTypeLoader.parse(url, SignatureType.type, (XmlOptions) null);
        }

        public static SignatureType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureType) POIXMLTypeLoader.parse(url, SignatureType.type, xmlOptions);
        }

        public static SignatureType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SignatureType) POIXMLTypeLoader.parse(xMLStreamReader, SignatureType.type, (XmlOptions) null);
        }

        public static SignatureType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SignatureType) POIXMLTypeLoader.parse(xMLStreamReader, SignatureType.type, xmlOptions);
        }

        public static SignatureType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SignatureType) POIXMLTypeLoader.parse(xMLInputStream, SignatureType.type, (XmlOptions) null);
        }

        public static SignatureType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SignatureType) POIXMLTypeLoader.parse(xMLInputStream, SignatureType.type, xmlOptions);
        }

        public static SignatureType parse(Node node) throws XmlException {
            return (SignatureType) POIXMLTypeLoader.parse(node, SignatureType.type, (XmlOptions) null);
        }

        public static SignatureType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SignatureType) POIXMLTypeLoader.parse(node, SignatureType.type, xmlOptions);
        }
    }

    KeyInfoType addNewKeyInfo();

    ObjectType addNewObject();

    SignatureValueType addNewSignatureValue();

    SignedInfoType addNewSignedInfo();

    String getId();

    KeyInfoType getKeyInfo();

    ObjectType getObjectArray(int i);

    ObjectType[] getObjectArray();

    List<ObjectType> getObjectList();

    SignatureValueType getSignatureValue();

    SignedInfoType getSignedInfo();

    ObjectType insertNewObject(int i);

    boolean isSetId();

    boolean isSetKeyInfo();

    void removeObject(int i);

    void setId(String str);

    void setKeyInfo(KeyInfoType keyInfoType);

    void setObjectArray(int i, ObjectType objectType);

    void setObjectArray(ObjectType[] objectTypeArr);

    void setSignatureValue(SignatureValueType signatureValueType);

    void setSignedInfo(SignedInfoType signedInfoType);

    int sizeOfObjectArray();

    void unsetId();

    void unsetKeyInfo();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
