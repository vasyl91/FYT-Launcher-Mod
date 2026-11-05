package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface STCfType extends XmlString {
    public static final int INT_ABOVE_AVERAGE = 18;
    public static final int INT_BEGINS_WITH = 11;
    public static final int INT_CELL_IS = 2;
    public static final int INT_COLOR_SCALE = 3;
    public static final int INT_CONTAINS_BLANKS = 13;
    public static final int INT_CONTAINS_ERRORS = 15;
    public static final int INT_CONTAINS_TEXT = 9;
    public static final int INT_DATA_BAR = 4;
    public static final int INT_DUPLICATE_VALUES = 8;
    public static final int INT_ENDS_WITH = 12;
    public static final int INT_EXPRESSION = 1;
    public static final int INT_ICON_SET = 5;
    public static final int INT_NOT_CONTAINS_BLANKS = 14;
    public static final int INT_NOT_CONTAINS_ERRORS = 16;
    public static final int INT_NOT_CONTAINS_TEXT = 10;
    public static final int INT_TIME_PERIOD = 17;
    public static final int INT_TOP_10 = 6;
    public static final int INT_UNIQUE_VALUES = 7;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STCfType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcftype8016type");
    public static final Enum EXPRESSION = Enum.forString("expression");
    public static final Enum CELL_IS = Enum.forString("cellIs");
    public static final Enum COLOR_SCALE = Enum.forString("colorScale");
    public static final Enum DATA_BAR = Enum.forString("dataBar");
    public static final Enum ICON_SET = Enum.forString("iconSet");
    public static final Enum TOP_10 = Enum.forString("top10");
    public static final Enum UNIQUE_VALUES = Enum.forString("uniqueValues");
    public static final Enum DUPLICATE_VALUES = Enum.forString("duplicateValues");
    public static final Enum CONTAINS_TEXT = Enum.forString("containsText");
    public static final Enum NOT_CONTAINS_TEXT = Enum.forString("notContainsText");
    public static final Enum BEGINS_WITH = Enum.forString("beginsWith");
    public static final Enum ENDS_WITH = Enum.forString("endsWith");
    public static final Enum CONTAINS_BLANKS = Enum.forString("containsBlanks");
    public static final Enum NOT_CONTAINS_BLANKS = Enum.forString("notContainsBlanks");
    public static final Enum CONTAINS_ERRORS = Enum.forString("containsErrors");
    public static final Enum NOT_CONTAINS_ERRORS = Enum.forString("notContainsErrors");
    public static final Enum TIME_PERIOD = Enum.forString("timePeriod");
    public static final Enum ABOVE_AVERAGE = Enum.forString("aboveAverage");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ABOVE_AVERAGE = 18;
        static final int INT_BEGINS_WITH = 11;
        static final int INT_CELL_IS = 2;
        static final int INT_COLOR_SCALE = 3;
        static final int INT_CONTAINS_BLANKS = 13;
        static final int INT_CONTAINS_ERRORS = 15;
        static final int INT_CONTAINS_TEXT = 9;
        static final int INT_DATA_BAR = 4;
        static final int INT_DUPLICATE_VALUES = 8;
        static final int INT_ENDS_WITH = 12;
        static final int INT_EXPRESSION = 1;
        static final int INT_ICON_SET = 5;
        static final int INT_NOT_CONTAINS_BLANKS = 14;
        static final int INT_NOT_CONTAINS_ERRORS = 16;
        static final int INT_NOT_CONTAINS_TEXT = 10;
        static final int INT_TIME_PERIOD = 17;
        static final int INT_TOP_10 = 6;
        static final int INT_UNIQUE_VALUES = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("expression", 1), new Enum("cellIs", 2), new Enum("colorScale", 3), new Enum("dataBar", 4), new Enum("iconSet", 5), new Enum("top10", 6), new Enum("uniqueValues", 7), new Enum("duplicateValues", 8), new Enum("containsText", 9), new Enum("notContainsText", 10), new Enum("beginsWith", 11), new Enum("endsWith", 12), new Enum("containsBlanks", 13), new Enum("notContainsBlanks", 14), new Enum("containsErrors", 15), new Enum("notContainsErrors", 16), new Enum("timePeriod", 17), new Enum("aboveAverage", 18)});

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

        public static STCfType newInstance() {
            return POIXMLTypeLoader.newInstance(STCfType.type, (XmlOptions) null);
        }

        public static STCfType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STCfType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCfType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCfType.type, xmlOptions);
        }

        public static STCfType newValue(Object obj) {
            return STCfType.type.newValue(obj);
        }

        public static STCfType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCfType.type, (XmlOptions) null);
        }

        public static STCfType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCfType.type, xmlOptions);
        }

        public static STCfType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCfType.type, (XmlOptions) null);
        }

        public static STCfType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCfType.type, xmlOptions);
        }

        public static STCfType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCfType.type, (XmlOptions) null);
        }

        public static STCfType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCfType.type, xmlOptions);
        }

        public static STCfType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCfType.type, (XmlOptions) null);
        }

        public static STCfType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCfType.type, xmlOptions);
        }

        public static STCfType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCfType.type, (XmlOptions) null);
        }

        public static STCfType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCfType.type, xmlOptions);
        }

        public static STCfType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCfType.type, (XmlOptions) null);
        }

        public static STCfType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCfType.type, xmlOptions);
        }

        public static STCfType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCfType.type, (XmlOptions) null);
        }

        public static STCfType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCfType.type, xmlOptions);
        }

        public static STCfType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCfType.type, (XmlOptions) null);
        }

        public static STCfType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCfType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
