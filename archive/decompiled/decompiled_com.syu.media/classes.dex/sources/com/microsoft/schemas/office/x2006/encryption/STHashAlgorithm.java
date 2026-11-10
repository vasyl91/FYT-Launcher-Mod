package com.microsoft.schemas.office.x2006.encryption;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface STHashAlgorithm extends XmlToken {
    public static final int INT_MD_2 = 7;
    public static final int INT_MD_4 = 6;
    public static final int INT_MD_5 = 5;
    public static final int INT_RIPEMD_128 = 8;
    public static final int INT_RIPEMD_160 = 9;
    public static final int INT_SHA_1 = 1;
    public static final int INT_SHA_256 = 2;
    public static final int INT_SHA_384 = 3;
    public static final int INT_SHA_512 = 4;
    public static final int INT_WHIRLPOOL = 10;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STHashAlgorithm.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("sthashalgorithm65e3type");
    public static final Enum SHA_1 = Enum.forString("SHA1");
    public static final Enum SHA_256 = Enum.forString("SHA256");
    public static final Enum SHA_384 = Enum.forString("SHA384");
    public static final Enum SHA_512 = Enum.forString("SHA512");
    public static final Enum MD_5 = Enum.forString("MD5");
    public static final Enum MD_4 = Enum.forString("MD4");
    public static final Enum MD_2 = Enum.forString("MD2");
    public static final Enum RIPEMD_128 = Enum.forString("RIPEMD-128");
    public static final Enum RIPEMD_160 = Enum.forString("RIPEMD-160");
    public static final Enum WHIRLPOOL = Enum.forString("WHIRLPOOL");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_MD_2 = 7;
        static final int INT_MD_4 = 6;
        static final int INT_MD_5 = 5;
        static final int INT_RIPEMD_128 = 8;
        static final int INT_RIPEMD_160 = 9;
        static final int INT_SHA_1 = 1;
        static final int INT_SHA_256 = 2;
        static final int INT_SHA_384 = 3;
        static final int INT_SHA_512 = 4;
        static final int INT_WHIRLPOOL = 10;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("SHA1", 1), new Enum("SHA256", 2), new Enum("SHA384", 3), new Enum("SHA512", 4), new Enum("MD5", 5), new Enum("MD4", 6), new Enum("MD2", 7), new Enum("RIPEMD-128", 8), new Enum("RIPEMD-160", 9), new Enum("WHIRLPOOL", 10)});

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

        public static STHashAlgorithm newInstance() {
            return POIXMLTypeLoader.newInstance(STHashAlgorithm.type, (XmlOptions) null);
        }

        public static STHashAlgorithm newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STHashAlgorithm.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHashAlgorithm.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHashAlgorithm.type, xmlOptions);
        }

        public static STHashAlgorithm newValue(Object obj) {
            return STHashAlgorithm.type.newValue(obj);
        }

        public static STHashAlgorithm parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STHashAlgorithm.type, (XmlOptions) null);
        }

        public static STHashAlgorithm parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STHashAlgorithm.type, xmlOptions);
        }

        public static STHashAlgorithm parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STHashAlgorithm.type, (XmlOptions) null);
        }

        public static STHashAlgorithm parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STHashAlgorithm.type, xmlOptions);
        }

        public static STHashAlgorithm parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STHashAlgorithm.type, (XmlOptions) null);
        }

        public static STHashAlgorithm parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STHashAlgorithm.type, xmlOptions);
        }

        public static STHashAlgorithm parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STHashAlgorithm.type, (XmlOptions) null);
        }

        public static STHashAlgorithm parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STHashAlgorithm.type, xmlOptions);
        }

        public static STHashAlgorithm parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STHashAlgorithm.type, (XmlOptions) null);
        }

        public static STHashAlgorithm parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STHashAlgorithm.type, xmlOptions);
        }

        public static STHashAlgorithm parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STHashAlgorithm.type, (XmlOptions) null);
        }

        public static STHashAlgorithm parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STHashAlgorithm.type, xmlOptions);
        }

        public static STHashAlgorithm parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STHashAlgorithm.type, (XmlOptions) null);
        }

        public static STHashAlgorithm parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STHashAlgorithm.type, xmlOptions);
        }

        public static STHashAlgorithm parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STHashAlgorithm.type, (XmlOptions) null);
        }

        public static STHashAlgorithm parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STHashAlgorithm.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
