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
public interface STStyleType extends XmlString {
    public static final int INT_CHARACTER = 2;
    public static final int INT_NUMBERING = 4;
    public static final int INT_PARAGRAPH = 1;
    public static final int INT_TABLE = 3;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STStyleType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ststyletypec2b7type");
    public static final Enum PARAGRAPH = Enum.forString("paragraph");
    public static final Enum CHARACTER = Enum.forString("character");
    public static final Enum TABLE = Enum.forString("table");
    public static final Enum NUMBERING = Enum.forString("numbering");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CHARACTER = 2;
        static final int INT_NUMBERING = 4;
        static final int INT_PARAGRAPH = 1;
        static final int INT_TABLE = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("paragraph", 1), new Enum("character", 2), new Enum("table", 3), new Enum("numbering", 4)});

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

        public static STStyleType newInstance() {
            return POIXMLTypeLoader.newInstance(STStyleType.type, (XmlOptions) null);
        }

        public static STStyleType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STStyleType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STStyleType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STStyleType.type, xmlOptions);
        }

        public static STStyleType newValue(Object obj) {
            return STStyleType.type.newValue(obj);
        }

        public static STStyleType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STStyleType.type, (XmlOptions) null);
        }

        public static STStyleType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STStyleType.type, xmlOptions);
        }

        public static STStyleType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STStyleType.type, (XmlOptions) null);
        }

        public static STStyleType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STStyleType.type, xmlOptions);
        }

        public static STStyleType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STStyleType.type, (XmlOptions) null);
        }

        public static STStyleType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STStyleType.type, xmlOptions);
        }

        public static STStyleType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STStyleType.type, (XmlOptions) null);
        }

        public static STStyleType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STStyleType.type, xmlOptions);
        }

        public static STStyleType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STStyleType.type, (XmlOptions) null);
        }

        public static STStyleType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STStyleType.type, xmlOptions);
        }

        public static STStyleType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STStyleType.type, (XmlOptions) null);
        }

        public static STStyleType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STStyleType.type, xmlOptions);
        }

        public static STStyleType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STStyleType.type, (XmlOptions) null);
        }

        public static STStyleType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STStyleType.type, xmlOptions);
        }

        public static STStyleType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STStyleType.type, (XmlOptions) null);
        }

        public static STStyleType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STStyleType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
