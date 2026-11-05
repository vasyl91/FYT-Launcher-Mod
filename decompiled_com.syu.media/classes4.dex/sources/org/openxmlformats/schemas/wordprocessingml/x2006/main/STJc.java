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
public interface STJc extends XmlString {
    public static final int INT_BOTH = 4;
    public static final int INT_CENTER = 2;
    public static final int INT_DISTRIBUTE = 6;
    public static final int INT_HIGH_KASHIDA = 8;
    public static final int INT_LEFT = 1;
    public static final int INT_LOW_KASHIDA = 9;
    public static final int INT_MEDIUM_KASHIDA = 5;
    public static final int INT_NUM_TAB = 7;
    public static final int INT_RIGHT = 3;
    public static final int INT_THAI_DISTRIBUTE = 10;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STJc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stjc977ftype");
    public static final Enum LEFT = Enum.forString("left");
    public static final Enum CENTER = Enum.forString("center");
    public static final Enum RIGHT = Enum.forString("right");
    public static final Enum BOTH = Enum.forString("both");
    public static final Enum MEDIUM_KASHIDA = Enum.forString("mediumKashida");
    public static final Enum DISTRIBUTE = Enum.forString("distribute");
    public static final Enum NUM_TAB = Enum.forString("numTab");
    public static final Enum HIGH_KASHIDA = Enum.forString("highKashida");
    public static final Enum LOW_KASHIDA = Enum.forString("lowKashida");
    public static final Enum THAI_DISTRIBUTE = Enum.forString("thaiDistribute");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTH = 4;
        static final int INT_CENTER = 2;
        static final int INT_DISTRIBUTE = 6;
        static final int INT_HIGH_KASHIDA = 8;
        static final int INT_LEFT = 1;
        static final int INT_LOW_KASHIDA = 9;
        static final int INT_MEDIUM_KASHIDA = 5;
        static final int INT_NUM_TAB = 7;
        static final int INT_RIGHT = 3;
        static final int INT_THAI_DISTRIBUTE = 10;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("left", 1), new Enum("center", 2), new Enum("right", 3), new Enum("both", 4), new Enum("mediumKashida", 5), new Enum("distribute", 6), new Enum("numTab", 7), new Enum("highKashida", 8), new Enum("lowKashida", 9), new Enum("thaiDistribute", 10)});

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

        public static STJc newInstance() {
            return POIXMLTypeLoader.newInstance(STJc.type, (XmlOptions) null);
        }

        public static STJc newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STJc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STJc.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STJc.type, xmlOptions);
        }

        public static STJc newValue(Object obj) {
            return STJc.type.newValue(obj);
        }

        public static STJc parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STJc.type, xmlOptions);
        }

        public static STJc parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STJc.type, xmlOptions);
        }

        public static STJc parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STJc.type, xmlOptions);
        }

        public static STJc parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STJc.type, xmlOptions);
        }

        public static STJc parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STJc.type, xmlOptions);
        }

        public static STJc parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STJc.type, xmlOptions);
        }

        public static STJc parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STJc.type, xmlOptions);
        }

        public static STJc parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STJc.type, (XmlOptions) null);
        }

        public static STJc parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STJc.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
