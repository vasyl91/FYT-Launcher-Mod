package com.microsoft.schemas.office.x2006.digsig;

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
public interface SignatureInfoV1Document extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(SignatureInfoV1Document.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("signatureinfov14a6bdoctype");

    public static final class Factory {
        private Factory() {
        }

        public static SignatureInfoV1Document newInstance() {
            return (SignatureInfoV1Document) POIXMLTypeLoader.newInstance(SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document newInstance(XmlOptions xmlOptions) {
            return (SignatureInfoV1Document) POIXMLTypeLoader.newInstance(SignatureInfoV1Document.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(File file) throws XmlException, IOException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(file, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(file, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(InputStream inputStream) throws XmlException, IOException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(inputStream, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(inputStream, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(Reader reader) throws XmlException, IOException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(reader, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(reader, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(String str) throws XmlException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(str, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(str, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(URL url) throws XmlException, IOException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(url, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(url, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(xMLStreamReader, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(xMLStreamReader, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(xMLInputStream, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(xMLInputStream, SignatureInfoV1Document.type, xmlOptions);
        }

        public static SignatureInfoV1Document parse(Node node) throws XmlException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(node, SignatureInfoV1Document.type, (XmlOptions) null);
        }

        public static SignatureInfoV1Document parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (SignatureInfoV1Document) POIXMLTypeLoader.parse(node, SignatureInfoV1Document.type, xmlOptions);
        }
    }

    CTSignatureInfoV1 addNewSignatureInfoV1();

    CTSignatureInfoV1 getSignatureInfoV1();

    void setSignatureInfoV1(CTSignatureInfoV1 cTSignatureInfoV1);
}
