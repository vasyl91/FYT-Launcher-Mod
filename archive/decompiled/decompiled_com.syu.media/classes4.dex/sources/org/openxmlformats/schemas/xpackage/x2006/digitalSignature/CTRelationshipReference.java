package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTRelationshipReference extends XmlString {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTRelationshipReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctrelationshipreferencee68ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTRelationshipReference newInstance() {
            return POIXMLTypeLoader.newInstance(CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(CTRelationshipReference.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, CTRelationshipReference.type, xmlOptions);
        }

        public static CTRelationshipReference parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, CTRelationshipReference.type, (XmlOptions) null);
        }

        public static CTRelationshipReference parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, CTRelationshipReference.type, xmlOptions);
        }
    }

    String getSourceId();

    void setSourceId(String str);

    XmlString xgetSourceId();

    void xsetSourceId(XmlString xmlString);
}
