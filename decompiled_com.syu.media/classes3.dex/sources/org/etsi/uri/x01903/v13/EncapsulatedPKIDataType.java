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
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface EncapsulatedPKIDataType extends XmlBase64Binary {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(EncapsulatedPKIDataType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("encapsulatedpkidatatype4081type");

    public static final class Factory {
        private Factory() {
        }

        public static EncapsulatedPKIDataType newInstance() {
            return POIXMLTypeLoader.newInstance(EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, EncapsulatedPKIDataType.type, xmlOptions);
        }

        public static EncapsulatedPKIDataType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, EncapsulatedPKIDataType.type, (XmlOptions) null);
        }

        public static EncapsulatedPKIDataType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, EncapsulatedPKIDataType.type, xmlOptions);
        }
    }

    String getEncoding();

    String getId();

    boolean isSetEncoding();

    boolean isSetId();

    void setEncoding(String str);

    void setId(String str);

    void unsetEncoding();

    void unsetId();

    XmlAnyURI xgetEncoding();

    XmlID xgetId();

    void xsetEncoding(XmlAnyURI xmlAnyURI);

    void xsetId(XmlID xmlID);
}
