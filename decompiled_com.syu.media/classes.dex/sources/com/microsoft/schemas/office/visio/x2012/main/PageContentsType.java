package com.microsoft.schemas.office.visio.x2012.main;

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
public interface PageContentsType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(PageContentsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("pagecontentstypea5d0type");

    public static final class Factory {
        private Factory() {
        }

        public static PageContentsType newInstance() {
            return (PageContentsType) POIXMLTypeLoader.newInstance(PageContentsType.type, (XmlOptions) null);
        }

        public static PageContentsType newInstance(XmlOptions xmlOptions) {
            return (PageContentsType) POIXMLTypeLoader.newInstance(PageContentsType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PageContentsType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PageContentsType.type, xmlOptions);
        }

        public static PageContentsType parse(File file) throws XmlException, IOException {
            return (PageContentsType) POIXMLTypeLoader.parse(file, PageContentsType.type, (XmlOptions) null);
        }

        public static PageContentsType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PageContentsType) POIXMLTypeLoader.parse(file, PageContentsType.type, xmlOptions);
        }

        public static PageContentsType parse(InputStream inputStream) throws XmlException, IOException {
            return (PageContentsType) POIXMLTypeLoader.parse(inputStream, PageContentsType.type, (XmlOptions) null);
        }

        public static PageContentsType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PageContentsType) POIXMLTypeLoader.parse(inputStream, PageContentsType.type, xmlOptions);
        }

        public static PageContentsType parse(Reader reader) throws XmlException, IOException {
            return (PageContentsType) POIXMLTypeLoader.parse(reader, PageContentsType.type, (XmlOptions) null);
        }

        public static PageContentsType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PageContentsType) POIXMLTypeLoader.parse(reader, PageContentsType.type, xmlOptions);
        }

        public static PageContentsType parse(String str) throws XmlException {
            return (PageContentsType) POIXMLTypeLoader.parse(str, PageContentsType.type, (XmlOptions) null);
        }

        public static PageContentsType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (PageContentsType) POIXMLTypeLoader.parse(str, PageContentsType.type, xmlOptions);
        }

        public static PageContentsType parse(URL url) throws XmlException, IOException {
            return (PageContentsType) POIXMLTypeLoader.parse(url, PageContentsType.type, (XmlOptions) null);
        }

        public static PageContentsType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (PageContentsType) POIXMLTypeLoader.parse(url, PageContentsType.type, xmlOptions);
        }

        public static PageContentsType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (PageContentsType) POIXMLTypeLoader.parse(xMLStreamReader, PageContentsType.type, (XmlOptions) null);
        }

        public static PageContentsType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (PageContentsType) POIXMLTypeLoader.parse(xMLStreamReader, PageContentsType.type, xmlOptions);
        }

        public static PageContentsType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (PageContentsType) POIXMLTypeLoader.parse(xMLInputStream, PageContentsType.type, (XmlOptions) null);
        }

        public static PageContentsType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (PageContentsType) POIXMLTypeLoader.parse(xMLInputStream, PageContentsType.type, xmlOptions);
        }

        public static PageContentsType parse(Node node) throws XmlException {
            return (PageContentsType) POIXMLTypeLoader.parse(node, PageContentsType.type, (XmlOptions) null);
        }

        public static PageContentsType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (PageContentsType) POIXMLTypeLoader.parse(node, PageContentsType.type, xmlOptions);
        }
    }

    ConnectsType addNewConnects();

    ShapesType addNewShapes();

    ConnectsType getConnects();

    ShapesType getShapes();

    boolean isSetConnects();

    boolean isSetShapes();

    void setConnects(ConnectsType connectsType);

    void setShapes(ShapesType shapesType);

    void unsetConnects();

    void unsetShapes();
}
