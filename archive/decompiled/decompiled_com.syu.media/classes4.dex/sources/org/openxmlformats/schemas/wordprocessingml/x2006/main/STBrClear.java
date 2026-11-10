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
public interface STBrClear extends XmlString {
    public static final int INT_ALL = 4;
    public static final int INT_LEFT = 2;
    public static final int INT_NONE = 1;
    public static final int INT_RIGHT = 3;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STBrClear.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stbrclearb1e5type");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum LEFT = Enum.forString("left");
    public static final Enum RIGHT = Enum.forString("right");
    public static final Enum ALL = Enum.forString("all");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ALL = 4;
        static final int INT_LEFT = 2;
        static final int INT_NONE = 1;
        static final int INT_RIGHT = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("left", 2), new Enum("right", 3), new Enum("all", 4)});

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

        public static STBrClear newInstance() {
            return POIXMLTypeLoader.newInstance(STBrClear.type, (XmlOptions) null);
        }

        public static STBrClear newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STBrClear.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STBrClear.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STBrClear.type, xmlOptions);
        }

        public static STBrClear newValue(Object obj) {
            return STBrClear.type.newValue(obj);
        }

        public static STBrClear parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STBrClear.type, (XmlOptions) null);
        }

        public static STBrClear parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STBrClear.type, xmlOptions);
        }

        public static STBrClear parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STBrClear.type, (XmlOptions) null);
        }

        public static STBrClear parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STBrClear.type, xmlOptions);
        }

        public static STBrClear parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STBrClear.type, (XmlOptions) null);
        }

        public static STBrClear parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STBrClear.type, xmlOptions);
        }

        public static STBrClear parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STBrClear.type, (XmlOptions) null);
        }

        public static STBrClear parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STBrClear.type, xmlOptions);
        }

        public static STBrClear parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STBrClear.type, (XmlOptions) null);
        }

        public static STBrClear parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STBrClear.type, xmlOptions);
        }

        public static STBrClear parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STBrClear.type, (XmlOptions) null);
        }

        public static STBrClear parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STBrClear.type, xmlOptions);
        }

        public static STBrClear parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STBrClear.type, (XmlOptions) null);
        }

        public static STBrClear parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STBrClear.type, xmlOptions);
        }

        public static STBrClear parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STBrClear.type, (XmlOptions) null);
        }

        public static STBrClear parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STBrClear.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
