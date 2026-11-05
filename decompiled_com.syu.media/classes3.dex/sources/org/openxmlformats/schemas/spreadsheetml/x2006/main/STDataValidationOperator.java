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
public interface STDataValidationOperator extends XmlString {
    public static final int INT_BETWEEN = 1;
    public static final int INT_EQUAL = 3;
    public static final int INT_GREATER_THAN = 7;
    public static final int INT_GREATER_THAN_OR_EQUAL = 8;
    public static final int INT_LESS_THAN = 5;
    public static final int INT_LESS_THAN_OR_EQUAL = 6;
    public static final int INT_NOT_BETWEEN = 2;
    public static final int INT_NOT_EQUAL = 4;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STDataValidationOperator.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdatavalidationoperatore0e0type");
    public static final Enum BETWEEN = Enum.forString("between");
    public static final Enum NOT_BETWEEN = Enum.forString("notBetween");
    public static final Enum EQUAL = Enum.forString("equal");
    public static final Enum NOT_EQUAL = Enum.forString("notEqual");
    public static final Enum LESS_THAN = Enum.forString("lessThan");
    public static final Enum LESS_THAN_OR_EQUAL = Enum.forString("lessThanOrEqual");
    public static final Enum GREATER_THAN = Enum.forString("greaterThan");
    public static final Enum GREATER_THAN_OR_EQUAL = Enum.forString("greaterThanOrEqual");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BETWEEN = 1;
        static final int INT_EQUAL = 3;
        static final int INT_GREATER_THAN = 7;
        static final int INT_GREATER_THAN_OR_EQUAL = 8;
        static final int INT_LESS_THAN = 5;
        static final int INT_LESS_THAN_OR_EQUAL = 6;
        static final int INT_NOT_BETWEEN = 2;
        static final int INT_NOT_EQUAL = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("between", 1), new Enum("notBetween", 2), new Enum("equal", 3), new Enum("notEqual", 4), new Enum("lessThan", 5), new Enum("lessThanOrEqual", 6), new Enum("greaterThan", 7), new Enum("greaterThanOrEqual", 8)});

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

        public static STDataValidationOperator newInstance() {
            return POIXMLTypeLoader.newInstance(STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STDataValidationOperator.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator newValue(Object obj) {
            return STDataValidationOperator.type.newValue(obj);
        }

        public static STDataValidationOperator parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STDataValidationOperator.type, xmlOptions);
        }

        public static STDataValidationOperator parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STDataValidationOperator.type, (XmlOptions) null);
        }

        public static STDataValidationOperator parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STDataValidationOperator.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
