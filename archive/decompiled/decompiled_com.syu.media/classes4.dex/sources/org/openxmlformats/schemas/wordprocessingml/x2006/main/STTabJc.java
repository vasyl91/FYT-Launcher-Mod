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
public interface STTabJc extends XmlString {
    public static final int INT_BAR = 6;
    public static final int INT_CENTER = 3;
    public static final int INT_CLEAR = 1;
    public static final int INT_DECIMAL = 5;
    public static final int INT_LEFT = 2;
    public static final int INT_NUM = 7;
    public static final int INT_RIGHT = 4;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTabJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttabjc10f4type");
    public static final Enum CLEAR = Enum.forString("clear");
    public static final Enum LEFT = Enum.forString("left");
    public static final Enum CENTER = Enum.forString("center");
    public static final Enum RIGHT = Enum.forString("right");
    public static final Enum DECIMAL = Enum.forString("decimal");
    public static final Enum BAR = Enum.forString("bar");
    public static final Enum NUM = Enum.forString("num");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BAR = 6;
        static final int INT_CENTER = 3;
        static final int INT_CLEAR = 1;
        static final int INT_DECIMAL = 5;
        static final int INT_LEFT = 2;
        static final int INT_NUM = 7;
        static final int INT_RIGHT = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("clear", 1), new Enum("left", 2), new Enum("center", 3), new Enum("right", 4), new Enum("decimal", 5), new Enum("bar", 6), new Enum("num", 7)});

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

        public static STTabJc newInstance() {
            return POIXMLTypeLoader.newInstance(STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTabJc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTabJc.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTabJc.type, xmlOptions);
        }

        public static STTabJc newValue(Object obj) {
            return STTabJc.type.newValue(obj);
        }

        public static STTabJc parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTabJc.type, xmlOptions);
        }

        public static STTabJc parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTabJc.type, (XmlOptions) null);
        }

        public static STTabJc parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTabJc.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
