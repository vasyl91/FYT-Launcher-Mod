package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STPathShadeType extends XmlToken {
    public static final int INT_CIRCLE = 2;
    public static final int INT_RECT = 3;
    public static final int INT_SHAPE = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STPathShadeType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpathshadetype93c3type");
    public static final Enum SHAPE = Enum.forString("shape");
    public static final Enum CIRCLE = Enum.forString("circle");
    public static final Enum RECT = Enum.forString("rect");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CIRCLE = 2;
        static final int INT_RECT = 3;
        static final int INT_SHAPE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("shape", 1), new Enum("circle", 2), new Enum("rect", 3)});

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

        public static STPathShadeType newInstance() {
            return POIXMLTypeLoader.newInstance(STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STPathShadeType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPathShadeType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType newValue(Object obj) {
            return STPathShadeType.type.newValue(obj);
        }

        public static STPathShadeType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STPathShadeType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
