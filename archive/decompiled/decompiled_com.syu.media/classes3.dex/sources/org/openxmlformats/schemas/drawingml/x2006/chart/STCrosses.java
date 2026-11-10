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
public interface STCrosses extends XmlString {
    public static final int INT_AUTO_ZERO = 1;
    public static final int INT_MAX = 2;
    public static final int INT_MIN = 3;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STCrosses.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcrosses3cc8type");
    public static final Enum AUTO_ZERO = Enum.forString("autoZero");
    public static final Enum MAX = Enum.forString("max");
    public static final Enum MIN = Enum.forString("min");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO_ZERO = 1;
        static final int INT_MAX = 2;
        static final int INT_MIN = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("autoZero", 1), new Enum("max", 2), new Enum("min", 3)});

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

        public static STCrosses newInstance() {
            return POIXMLTypeLoader.newInstance(STCrosses.type, (XmlOptions) null);
        }

        public static STCrosses newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STCrosses.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCrosses.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCrosses.type, xmlOptions);
        }

        public static STCrosses newValue(Object obj) {
            return STCrosses.type.newValue(obj);
        }

        public static STCrosses parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCrosses.type, (XmlOptions) null);
        }

        public static STCrosses parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCrosses.type, xmlOptions);
        }

        public static STCrosses parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCrosses.type, (XmlOptions) null);
        }

        public static STCrosses parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCrosses.type, xmlOptions);
        }

        public static STCrosses parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCrosses.type, (XmlOptions) null);
        }

        public static STCrosses parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCrosses.type, xmlOptions);
        }

        public static STCrosses parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCrosses.type, (XmlOptions) null);
        }

        public static STCrosses parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCrosses.type, xmlOptions);
        }

        public static STCrosses parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCrosses.type, (XmlOptions) null);
        }

        public static STCrosses parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCrosses.type, xmlOptions);
        }

        public static STCrosses parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCrosses.type, (XmlOptions) null);
        }

        public static STCrosses parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCrosses.type, xmlOptions);
        }

        public static STCrosses parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCrosses.type, (XmlOptions) null);
        }

        public static STCrosses parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCrosses.type, xmlOptions);
        }

        public static STCrosses parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCrosses.type, (XmlOptions) null);
        }

        public static STCrosses parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCrosses.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
