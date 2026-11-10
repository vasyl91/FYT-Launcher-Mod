package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STDrawingElementId extends XmlUnsignedInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STDrawingElementId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdrawingelementid75a4type");

    public static final class Factory {
        private Factory() {
        }

        public static STDrawingElementId newInstance() {
            return POIXMLTypeLoader.newInstance(STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STDrawingElementId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDrawingElementId.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId newValue(Object obj) {
            return STDrawingElementId.type.newValue(obj);
        }

        public static STDrawingElementId parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STDrawingElementId.type, xmlOptions);
        }
    }
}
