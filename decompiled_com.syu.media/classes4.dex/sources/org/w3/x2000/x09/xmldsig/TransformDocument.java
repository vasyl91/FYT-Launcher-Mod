package org.w3.x2000.x09.xmldsig;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface TransformDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(TransformDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("transforme335doctype");

    public static final class Factory {
        private Factory() {
        }

        public static TransformDocument newInstance() {
            return (TransformDocument) POIXMLTypeLoader.newInstance(TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument newInstance(XmlOptions xmlOptions) {
            return (TransformDocument) POIXMLTypeLoader.newInstance(TransformDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, TransformDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(File file) throws XmlException, IOException {
            return (TransformDocument) POIXMLTypeLoader.parse(file, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformDocument) POIXMLTypeLoader.parse(file, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (TransformDocument) POIXMLTypeLoader.parse(inputStream, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformDocument) POIXMLTypeLoader.parse(inputStream, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(Reader reader) throws XmlException, IOException {
            return (TransformDocument) POIXMLTypeLoader.parse(reader, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformDocument) POIXMLTypeLoader.parse(reader, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(String str) throws XmlException {
            return (TransformDocument) POIXMLTypeLoader.parse(str, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TransformDocument) POIXMLTypeLoader.parse(str, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(URL url) throws XmlException, IOException {
            return (TransformDocument) POIXMLTypeLoader.parse(url, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TransformDocument) POIXMLTypeLoader.parse(url, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TransformDocument) POIXMLTypeLoader.parse(xMLStreamReader, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TransformDocument) POIXMLTypeLoader.parse(xMLStreamReader, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (TransformDocument) POIXMLTypeLoader.parse(xMLInputStream, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (TransformDocument) POIXMLTypeLoader.parse(xMLInputStream, TransformDocument.type, xmlOptions);
        }

        public static TransformDocument parse(Node node) throws XmlException {
            return (TransformDocument) POIXMLTypeLoader.parse(node, TransformDocument.type, (XmlOptions) null);
        }

        public static TransformDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TransformDocument) POIXMLTypeLoader.parse(node, TransformDocument.type, xmlOptions);
        }
    }

    TransformType addNewTransform();

    TransformType getTransform();

    void setTransform(TransformType transformType);
}
