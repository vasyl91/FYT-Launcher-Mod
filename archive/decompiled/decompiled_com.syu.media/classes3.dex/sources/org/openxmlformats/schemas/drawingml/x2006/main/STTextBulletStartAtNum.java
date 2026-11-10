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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STTextBulletStartAtNum extends XmlInt {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTextBulletStartAtNum.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextbulletstartatnum562btype");

    public static final class Factory {
        private Factory() {
        }

        public static STTextBulletStartAtNum newInstance() {
            return POIXMLTypeLoader.newInstance(STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTextBulletStartAtNum.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum newValue(Object obj) {
            return STTextBulletStartAtNum.type.newValue(obj);
        }

        public static STTextBulletStartAtNum parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextBulletStartAtNum.type, xmlOptions);
        }
    }
}
