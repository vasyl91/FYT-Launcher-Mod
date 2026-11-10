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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STCellStyleXfId extends XmlUnsignedInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STCellStyleXfId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcellstylexfid70c7type");

    public static final class Factory {
        private Factory() {
        }

        public static STCellStyleXfId newInstance() {
            return POIXMLTypeLoader.newInstance(STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STCellStyleXfId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId newValue(Object obj) {
            return STCellStyleXfId.type.newValue(obj);
        }

        public static STCellStyleXfId parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCellStyleXfId.type, xmlOptions);
        }

        public static STCellStyleXfId parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCellStyleXfId.type, (XmlOptions) null);
        }

        public static STCellStyleXfId parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCellStyleXfId.type, xmlOptions);
        }
    }
}
