package com.microsoft.schemas.vml;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface STTrueFalse extends XmlString {
    public static final int INT_F = 2;
    public static final int INT_FALSE = 4;
    public static final int INT_T = 1;
    public static final int INT_TRUE = 3;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTrueFalse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttruefalse4ab9type");
    public static final Enum T = Enum.forString("t");
    public static final Enum F = Enum.forString("f");
    public static final Enum TRUE = Enum.forString("true");
    public static final Enum FALSE = Enum.forString("false");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_F = 2;
        static final int INT_FALSE = 4;
        static final int INT_T = 1;
        static final int INT_TRUE = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("t", 1), new Enum("f", 2), new Enum("true", 3), new Enum("false", 4)});

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

        public static STTrueFalse newInstance() {
            return POIXMLTypeLoader.newInstance(STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTrueFalse.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTrueFalse.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse newValue(Object obj) {
            return STTrueFalse.type.newValue(obj);
        }

        public static STTrueFalse parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTrueFalse.type, xmlOptions);
        }

        public static STTrueFalse parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTrueFalse.type, (XmlOptions) null);
        }

        public static STTrueFalse parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTrueFalse.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
