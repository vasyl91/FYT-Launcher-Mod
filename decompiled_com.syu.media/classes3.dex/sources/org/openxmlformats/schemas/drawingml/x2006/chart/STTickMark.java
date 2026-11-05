package org.openxmlformats.schemas.drawingml.x2006.chart;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STTickMark extends XmlString {
    public static final int INT_CROSS = 1;
    public static final int INT_IN = 2;
    public static final int INT_NONE = 3;
    public static final int INT_OUT = 4;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTickMark.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttickmark69e2type");
    public static final Enum CROSS = Enum.forString("cross");
    public static final Enum IN = Enum.forString("in");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum OUT = Enum.forString("out");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CROSS = 1;
        static final int INT_IN = 2;
        static final int INT_NONE = 3;
        static final int INT_OUT = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("cross", 1), new Enum("in", 2), new Enum("none", 3), new Enum("out", 4)});

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

        public static STTickMark newInstance() {
            return POIXMLTypeLoader.newInstance(STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTickMark.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTickMark.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTickMark.type, xmlOptions);
        }

        public static STTickMark newValue(Object obj) {
            return STTickMark.type.newValue(obj);
        }

        public static STTickMark parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTickMark.type, xmlOptions);
        }

        public static STTickMark parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTickMark.type, (XmlOptions) null);
        }

        public static STTickMark parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTickMark.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
