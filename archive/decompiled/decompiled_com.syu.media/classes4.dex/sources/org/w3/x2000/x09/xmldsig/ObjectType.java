package org.w3.x2000.x09.xmldsig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface ObjectType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ObjectType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("objecttypec966type");

    public static final class Factory {
        private Factory() {
        }

        public static ObjectType newInstance() {
            return (ObjectType) POIXMLTypeLoader.newInstance(ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType newInstance(XmlOptions xmlOptions) {
            return (ObjectType) POIXMLTypeLoader.newInstance(ObjectType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ObjectType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(File file) throws XmlException, IOException {
            return (ObjectType) POIXMLTypeLoader.parse(file, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ObjectType) POIXMLTypeLoader.parse(file, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(InputStream inputStream) throws XmlException, IOException {
            return (ObjectType) POIXMLTypeLoader.parse(inputStream, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ObjectType) POIXMLTypeLoader.parse(inputStream, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(Reader reader) throws XmlException, IOException {
            return (ObjectType) POIXMLTypeLoader.parse(reader, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ObjectType) POIXMLTypeLoader.parse(reader, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(String str) throws XmlException {
            return (ObjectType) POIXMLTypeLoader.parse(str, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ObjectType) POIXMLTypeLoader.parse(str, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(URL url) throws XmlException, IOException {
            return (ObjectType) POIXMLTypeLoader.parse(url, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ObjectType) POIXMLTypeLoader.parse(url, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ObjectType) POIXMLTypeLoader.parse(xMLStreamReader, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ObjectType) POIXMLTypeLoader.parse(xMLStreamReader, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ObjectType) POIXMLTypeLoader.parse(xMLInputStream, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ObjectType) POIXMLTypeLoader.parse(xMLInputStream, ObjectType.type, xmlOptions);
        }

        public static ObjectType parse(Node node) throws XmlException {
            return (ObjectType) POIXMLTypeLoader.parse(node, ObjectType.type, (XmlOptions) null);
        }

        public static ObjectType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ObjectType) POIXMLTypeLoader.parse(node, ObjectType.type, xmlOptions);
        }
    }

    String getEncoding();

    String getId();

    String getMimeType();

    boolean isSetEncoding();

    boolean isSetId();

    boolean isSetMimeType();

    void setEncoding(String str);

    void setId(String str);

    void setMimeType(String str);

    void unsetEncoding();

    void unsetId();

    void unsetMimeType();

    XmlAnyURI xgetEncoding();

    XmlID xgetId();

    XmlString xgetMimeType();

    void xsetEncoding(XmlAnyURI xmlAnyURI);

    void xsetId(XmlID xmlID);

    void xsetMimeType(XmlString xmlString);
}
