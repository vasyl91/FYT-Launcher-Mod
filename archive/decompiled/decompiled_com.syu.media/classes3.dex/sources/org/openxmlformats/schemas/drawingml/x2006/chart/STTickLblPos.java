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
public interface STTickLblPos extends XmlString {
    public static final int INT_HIGH = 1;
    public static final int INT_LOW = 2;
    public static final int INT_NEXT_TO = 3;
    public static final int INT_NONE = 4;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTickLblPos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stticklblposc551type");
    public static final Enum HIGH = Enum.forString("high");
    public static final Enum LOW = Enum.forString("low");
    public static final Enum NEXT_TO = Enum.forString("nextTo");
    public static final Enum NONE = Enum.forString("none");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_HIGH = 1;
        static final int INT_LOW = 2;
        static final int INT_NEXT_TO = 3;
        static final int INT_NONE = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("high", 1), new Enum("low", 2), new Enum("nextTo", 3), new Enum("none", 4)});

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

        public static STTickLblPos newInstance() {
            return POIXMLTypeLoader.newInstance(STTickLblPos.type, (XmlOptions) null);
        }

        public static STTickLblPos newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTickLblPos.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTickLblPos.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTickLblPos.type, xmlOptions);
        }

        public static STTickLblPos newValue(Object obj) {
            return STTickLblPos.type.newValue(obj);
        }

        public static STTickLblPos parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTickLblPos.type, (XmlOptions) null);
        }

        public static STTickLblPos parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTickLblPos.type, xmlOptions);
        }

        public static STTickLblPos parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTickLblPos.type, (XmlOptions) null);
        }

        public static STTickLblPos parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTickLblPos.type, xmlOptions);
        }

        public static STTickLblPos parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTickLblPos.type, (XmlOptions) null);
        }

        public static STTickLblPos parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTickLblPos.type, xmlOptions);
        }

        public static STTickLblPos parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTickLblPos.type, (XmlOptions) null);
        }

        public static STTickLblPos parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTickLblPos.type, xmlOptions);
        }

        public static STTickLblPos parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTickLblPos.type, (XmlOptions) null);
        }

        public static STTickLblPos parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTickLblPos.type, xmlOptions);
        }

        public static STTickLblPos parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTickLblPos.type, (XmlOptions) null);
        }

        public static STTickLblPos parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTickLblPos.type, xmlOptions);
        }

        public static STTickLblPos parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTickLblPos.type, (XmlOptions) null);
        }

        public static STTickLblPos parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTickLblPos.type, xmlOptions);
        }

        public static STTickLblPos parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTickLblPos.type, (XmlOptions) null);
        }

        public static STTickLblPos parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTickLblPos.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
