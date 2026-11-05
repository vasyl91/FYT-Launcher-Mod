package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface STBrType extends XmlString {
    public static final int INT_COLUMN = 2;
    public static final int INT_PAGE = 1;
    public static final int INT_TEXT_WRAPPING = 3;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STBrType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stbrtypeb52etype");
    public static final Enum PAGE = Enum.forString("page");
    public static final Enum COLUMN = Enum.forString("column");
    public static final Enum TEXT_WRAPPING = Enum.forString("textWrapping");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_COLUMN = 2;
        static final int INT_PAGE = 1;
        static final int INT_TEXT_WRAPPING = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("page", 1), new Enum("column", 2), new Enum("textWrapping", 3)});

        private Enum(String str, int i) {
            super(str, i);
        }

        public static Enum forInt(int i) {
            return (Enum) table.forInt(i);
        }

        public static Enum forString(String str) {
            return (Enum) table.forString(str);
        }

        private Object readResolve() {
            return forInt(intValue());
        }
    }

    public static final class Factory {
        private Factory() {
        }

        public static STBrType newInstance() {
            return POIXMLTypeLoader.newInstance(STBrType.type, (XmlOptions) null);
        }

        public static STBrType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STBrType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STBrType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STBrType.type, xmlOptions);
        }

        public static STBrType newValue(Object obj) {
            return STBrType.type.newValue(obj);
        }

        public static STBrType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STBrType.type, xmlOptions);
        }

        public static STBrType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STBrType.type, xmlOptions);
        }

        public static STBrType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STBrType.type, xmlOptions);
        }

        public static STBrType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STBrType.type, xmlOptions);
        }

        public static STBrType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STBrType.type, xmlOptions);
        }

        public static STBrType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STBrType.type, xmlOptions);
        }

        public static STBrType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STBrType.type, xmlOptions);
        }

        public static STBrType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STBrType.type, (XmlOptions) null);
        }

        public static STBrType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STBrType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
