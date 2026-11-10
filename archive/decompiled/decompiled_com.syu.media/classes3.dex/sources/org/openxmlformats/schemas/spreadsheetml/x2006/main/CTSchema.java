package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTSchema extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSchema.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctschema0e6atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSchema newInstance() {
            return (CTSchema) POIXMLTypeLoader.newInstance(CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema newInstance(XmlOptions xmlOptions) {
            return (CTSchema) POIXMLTypeLoader.newInstance(CTSchema.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSchema.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(File file) throws XmlException, IOException {
            return (CTSchema) POIXMLTypeLoader.parse(file, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSchema) POIXMLTypeLoader.parse(file, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSchema) POIXMLTypeLoader.parse(inputStream, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSchema) POIXMLTypeLoader.parse(inputStream, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(Reader reader) throws XmlException, IOException {
            return (CTSchema) POIXMLTypeLoader.parse(reader, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSchema) POIXMLTypeLoader.parse(reader, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(String str) throws XmlException {
            return (CTSchema) POIXMLTypeLoader.parse(str, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSchema) POIXMLTypeLoader.parse(str, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(URL url) throws XmlException, IOException {
            return (CTSchema) POIXMLTypeLoader.parse(url, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSchema) POIXMLTypeLoader.parse(url, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSchema) POIXMLTypeLoader.parse(xMLStreamReader, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSchema) POIXMLTypeLoader.parse(xMLStreamReader, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSchema) POIXMLTypeLoader.parse(xMLInputStream, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSchema) POIXMLTypeLoader.parse(xMLInputStream, CTSchema.type, xmlOptions);
        }

        public static CTSchema parse(Node node) throws XmlException {
            return (CTSchema) POIXMLTypeLoader.parse(node, CTSchema.type, (XmlOptions) null);
        }

        public static CTSchema parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSchema) POIXMLTypeLoader.parse(node, CTSchema.type, xmlOptions);
        }
    }

    String getID();

    String getNamespace();

    String getSchemaRef();

    boolean isSetNamespace();

    boolean isSetSchemaRef();

    void setID(String str);

    void setNamespace(String str);

    void setSchemaRef(String str);

    void unsetNamespace();

    void unsetSchemaRef();

    XmlString xgetID();

    XmlString xgetNamespace();

    XmlString xgetSchemaRef();

    void xsetID(XmlString xmlString);

    void xsetNamespace(XmlString xmlString);

    void xsetSchemaRef(XmlString xmlString);
}
