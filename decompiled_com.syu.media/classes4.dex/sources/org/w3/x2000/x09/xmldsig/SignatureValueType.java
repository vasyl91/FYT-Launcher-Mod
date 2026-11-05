package org.w3.x2000.x09.xmldsig;

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
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface SignatureValueType extends XmlBase64Binary {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SignatureValueType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("signaturevaluetype58cctype");

    public static final class Factory {
        private Factory() {
        }

        public static SignatureValueType newInstance() {
            return POIXMLTypeLoader.newInstance(SignatureValueType.type, (XmlOptions) null);
        }

        public static SignatureValueType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(SignatureValueType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SignatureValueType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SignatureValueType.type, xmlOptions);
        }

        public static SignatureValueType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, SignatureValueType.type, (XmlOptions) null);
        }

        public static SignatureValueType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, SignatureValueType.type, xmlOptions);
        }

        public static SignatureValueType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, SignatureValueType.type, (XmlOptions) null);
        }

        public static SignatureValueType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, SignatureValueType.type, xmlOptions);
        }

        public static SignatureValueType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, SignatureValueType.type, (XmlOptions) null);
        }

        public static SignatureValueType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, SignatureValueType.type, xmlOptions);
        }

        public static SignatureValueType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, SignatureValueType.type, (XmlOptions) null);
        }

        public static SignatureValueType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, SignatureValueType.type, xmlOptions);
        }

        public static SignatureValueType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, SignatureValueType.type, (XmlOptions) null);
        }

        public static SignatureValueType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, SignatureValueType.type, xmlOptions);
        }

        public static SignatureValueType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, SignatureValueType.type, (XmlOptions) null);
        }

        public static SignatureValueType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, SignatureValueType.type, xmlOptions);
        }

        public static SignatureValueType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, SignatureValueType.type, (XmlOptions) null);
        }

        public static SignatureValueType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, SignatureValueType.type, xmlOptions);
        }

        public static SignatureValueType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, SignatureValueType.type, (XmlOptions) null);
        }

        public static SignatureValueType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, SignatureValueType.type, xmlOptions);
        }
    }

    String getId();

    boolean isSetId();

    void setId(String str);

    void unsetId();

    XmlID xgetId();

    void xsetId(XmlID xmlID);
}
