package org.etsi.uri.x01903.v13;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface XAdESTimeStampType extends GenericTimeStampType {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(XAdESTimeStampType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("xadestimestamptypeaedbtype");

    public static final class Factory {
        private Factory() {
        }

        public static XAdESTimeStampType newInstance() {
            return (XAdESTimeStampType) POIXMLTypeLoader.newInstance(XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType newInstance(XmlOptions xmlOptions) {
            return (XAdESTimeStampType) POIXMLTypeLoader.newInstance(XAdESTimeStampType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(File file) throws XmlException, IOException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(file, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(file, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(InputStream inputStream) throws XmlException, IOException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(inputStream, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(inputStream, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(Reader reader) throws XmlException, IOException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(reader, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(reader, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(String str) throws XmlException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(str, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(str, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(URL url) throws XmlException, IOException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(url, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(url, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(xMLStreamReader, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(xMLStreamReader, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(xMLInputStream, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(xMLInputStream, XAdESTimeStampType.type, xmlOptions);
        }

        public static XAdESTimeStampType parse(Node node) throws XmlException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(node, XAdESTimeStampType.type, (XmlOptions) null);
        }

        public static XAdESTimeStampType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (XAdESTimeStampType) POIXMLTypeLoader.parse(node, XAdESTimeStampType.type, xmlOptions);
        }
    }
}
