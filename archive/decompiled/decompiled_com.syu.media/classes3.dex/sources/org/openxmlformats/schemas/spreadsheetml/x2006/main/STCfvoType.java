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
public interface STCfvoType extends XmlString {
    public static final int INT_FORMULA = 5;
    public static final int INT_MAX = 3;
    public static final int INT_MIN = 4;
    public static final int INT_NUM = 1;
    public static final int INT_PERCENT = 2;
    public static final int INT_PERCENTILE = 6;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STCfvoType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcfvotypeeb0ftype");
    public static final Enum NUM = Enum.forString("num");
    public static final Enum PERCENT = Enum.forString("percent");
    public static final Enum MAX = Enum.forString("max");
    public static final Enum MIN = Enum.forString("min");
    public static final Enum FORMULA = Enum.forString("formula");
    public static final Enum PERCENTILE = Enum.forString("percentile");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FORMULA = 5;
        static final int INT_MAX = 3;
        static final int INT_MIN = 4;
        static final int INT_NUM = 1;
        static final int INT_PERCENT = 2;
        static final int INT_PERCENTILE = 6;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("num", 1), new Enum("percent", 2), new Enum("max", 3), new Enum("min", 4), new Enum("formula", 5), new Enum("percentile", 6)});

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

        public static STCfvoType newInstance() {
            return POIXMLTypeLoader.newInstance(STCfvoType.type, (XmlOptions) null);
        }

        public static STCfvoType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STCfvoType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCfvoType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCfvoType.type, xmlOptions);
        }

        public static STCfvoType newValue(Object obj) {
            return STCfvoType.type.newValue(obj);
        }

        public static STCfvoType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCfvoType.type, (XmlOptions) null);
        }

        public static STCfvoType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCfvoType.type, xmlOptions);
        }

        public static STCfvoType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCfvoType.type, (XmlOptions) null);
        }

        public static STCfvoType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCfvoType.type, xmlOptions);
        }

        public static STCfvoType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCfvoType.type, (XmlOptions) null);
        }

        public static STCfvoType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCfvoType.type, xmlOptions);
        }

        public static STCfvoType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCfvoType.type, (XmlOptions) null);
        }

        public static STCfvoType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCfvoType.type, xmlOptions);
        }

        public static STCfvoType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCfvoType.type, (XmlOptions) null);
        }

        public static STCfvoType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCfvoType.type, xmlOptions);
        }

        public static STCfvoType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCfvoType.type, (XmlOptions) null);
        }

        public static STCfvoType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCfvoType.type, xmlOptions);
        }

        public static STCfvoType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCfvoType.type, (XmlOptions) null);
        }

        public static STCfvoType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCfvoType.type, xmlOptions);
        }

        public static STCfvoType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCfvoType.type, (XmlOptions) null);
        }

        public static STCfvoType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCfvoType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
