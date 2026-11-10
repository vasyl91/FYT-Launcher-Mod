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
public interface STDataValidationType extends XmlString {
    public static final int INT_CUSTOM = 8;
    public static final int INT_DATE = 5;
    public static final int INT_DECIMAL = 3;
    public static final int INT_LIST = 4;
    public static final int INT_NONE = 1;
    public static final int INT_TEXT_LENGTH = 7;
    public static final int INT_TIME = 6;
    public static final int INT_WHOLE = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STDataValidationType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdatavalidationtypeabf6type");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum WHOLE = Enum.forString("whole");
    public static final Enum DECIMAL = Enum.forString("decimal");
    public static final Enum LIST = Enum.forString("list");
    public static final Enum DATE = Enum.forString("date");
    public static final Enum TIME = Enum.forString("time");
    public static final Enum TEXT_LENGTH = Enum.forString("textLength");
    public static final Enum CUSTOM = Enum.forString("custom");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CUSTOM = 8;
        static final int INT_DATE = 5;
        static final int INT_DECIMAL = 3;
        static final int INT_LIST = 4;
        static final int INT_NONE = 1;
        static final int INT_TEXT_LENGTH = 7;
        static final int INT_TIME = 6;
        static final int INT_WHOLE = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("whole", 2), new Enum("decimal", 3), new Enum("list", 4), new Enum("date", 5), new Enum("time", 6), new Enum("textLength", 7), new Enum("custom", 8)});

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

        public static STDataValidationType newInstance() {
            return POIXMLTypeLoader.newInstance(STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STDataValidationType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDataValidationType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType newValue(Object obj) {
            return STDataValidationType.type.newValue(obj);
        }

        public static STDataValidationType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STDataValidationType.type, xmlOptions);
        }

        public static STDataValidationType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STDataValidationType.type, (XmlOptions) null);
        }

        public static STDataValidationType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STDataValidationType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
