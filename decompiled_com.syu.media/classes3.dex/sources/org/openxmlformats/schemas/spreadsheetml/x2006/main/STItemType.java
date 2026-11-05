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
public interface STItemType extends XmlString {
    public static final int INT_AVG = 5;
    public static final int INT_BLANK = 15;
    public static final int INT_COUNT = 9;
    public static final int INT_COUNT_A = 4;
    public static final int INT_DATA = 1;
    public static final int INT_DEFAULT = 2;
    public static final int INT_GRAND = 14;
    public static final int INT_MAX = 6;
    public static final int INT_MIN = 7;
    public static final int INT_PRODUCT = 8;
    public static final int INT_STD_DEV = 10;
    public static final int INT_STD_DEV_P = 11;
    public static final int INT_SUM = 3;
    public static final int INT_VAR = 12;
    public static final int INT_VAR_P = 13;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STItemType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stitemtype6186type");
    public static final Enum DATA = Enum.forString("data");
    public static final Enum DEFAULT = Enum.forString("default");
    public static final Enum SUM = Enum.forString("sum");
    public static final Enum COUNT_A = Enum.forString("countA");
    public static final Enum AVG = Enum.forString("avg");
    public static final Enum MAX = Enum.forString("max");
    public static final Enum MIN = Enum.forString("min");
    public static final Enum PRODUCT = Enum.forString("product");
    public static final Enum COUNT = Enum.forString("count");
    public static final Enum STD_DEV = Enum.forString("stdDev");
    public static final Enum STD_DEV_P = Enum.forString("stdDevP");
    public static final Enum VAR = Enum.forString("var");
    public static final Enum VAR_P = Enum.forString("varP");
    public static final Enum GRAND = Enum.forString("grand");
    public static final Enum BLANK = Enum.forString("blank");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AVG = 5;
        static final int INT_BLANK = 15;
        static final int INT_COUNT = 9;
        static final int INT_COUNT_A = 4;
        static final int INT_DATA = 1;
        static final int INT_DEFAULT = 2;
        static final int INT_GRAND = 14;
        static final int INT_MAX = 6;
        static final int INT_MIN = 7;
        static final int INT_PRODUCT = 8;
        static final int INT_STD_DEV = 10;
        static final int INT_STD_DEV_P = 11;
        static final int INT_SUM = 3;
        static final int INT_VAR = 12;
        static final int INT_VAR_P = 13;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("data", 1), new Enum("default", 2), new Enum("sum", 3), new Enum("countA", 4), new Enum("avg", 5), new Enum("max", 6), new Enum("min", 7), new Enum("product", 8), new Enum("count", 9), new Enum("stdDev", 10), new Enum("stdDevP", 11), new Enum("var", 12), new Enum("varP", 13), new Enum("grand", 14), new Enum("blank", 15)});

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

        public static STItemType newInstance() {
            return POIXMLTypeLoader.newInstance(STItemType.type, (XmlOptions) null);
        }

        public static STItemType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STItemType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STItemType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STItemType.type, xmlOptions);
        }

        public static STItemType newValue(Object obj) {
            return STItemType.type.newValue(obj);
        }

        public static STItemType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STItemType.type, (XmlOptions) null);
        }

        public static STItemType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STItemType.type, xmlOptions);
        }

        public static STItemType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STItemType.type, (XmlOptions) null);
        }

        public static STItemType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STItemType.type, xmlOptions);
        }

        public static STItemType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STItemType.type, (XmlOptions) null);
        }

        public static STItemType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STItemType.type, xmlOptions);
        }

        public static STItemType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STItemType.type, (XmlOptions) null);
        }

        public static STItemType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STItemType.type, xmlOptions);
        }

        public static STItemType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STItemType.type, (XmlOptions) null);
        }

        public static STItemType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STItemType.type, xmlOptions);
        }

        public static STItemType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STItemType.type, (XmlOptions) null);
        }

        public static STItemType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STItemType.type, xmlOptions);
        }

        public static STItemType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STItemType.type, (XmlOptions) null);
        }

        public static STItemType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STItemType.type, xmlOptions);
        }

        public static STItemType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STItemType.type, (XmlOptions) null);
        }

        public static STItemType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STItemType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
