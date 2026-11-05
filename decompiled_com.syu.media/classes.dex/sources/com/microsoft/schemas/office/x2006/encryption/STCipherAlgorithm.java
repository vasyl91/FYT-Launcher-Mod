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
public interface STCipherAlgorithm extends XmlToken {
    public static final int INT_AES = 1;
    public static final int INT_DES = 4;
    public static final int INT_DESX = 5;
    public static final int INT_RC_2 = 2;
    public static final int INT_RC_4 = 3;
    public static final int INT_X_3_DES = 6;
    public static final int INT_X_3_DES_112 = 7;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STCipherAlgorithm.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stcipheralgorithme346type");
    public static final Enum AES = Enum.forString("AES");
    public static final Enum RC_2 = Enum.forString("RC2");
    public static final Enum RC_4 = Enum.forString("RC4");
    public static final Enum DES = Enum.forString("DES");
    public static final Enum DESX = Enum.forString("DESX");
    public static final Enum X_3_DES = Enum.forString("3DES");
    public static final Enum X_3_DES_112 = Enum.forString("3DES_112");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AES = 1;
        static final int INT_DES = 4;
        static final int INT_DESX = 5;
        static final int INT_RC_2 = 2;
        static final int INT_RC_4 = 3;
        static final int INT_X_3_DES = 6;
        static final int INT_X_3_DES_112 = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("AES", 1), new Enum("RC2", 2), new Enum("RC4", 3), new Enum("DES", 4), new Enum("DESX", 5), new Enum("3DES", 6), new Enum("3DES_112", 7)});

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

        public static STCipherAlgorithm newInstance() {
            return POIXMLTypeLoader.newInstance(STCipherAlgorithm.type, (XmlOptions) null);
        }

        public static STCipherAlgorithm newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STCipherAlgorithm.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCipherAlgorithm.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCipherAlgorithm.type, xmlOptions);
        }

        public static STCipherAlgorithm newValue(Object obj) {
            return STCipherAlgorithm.type.newValue(obj);
        }

        public static STCipherAlgorithm parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCipherAlgorithm.type, (XmlOptions) null);
        }

        public static STCipherAlgorithm parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCipherAlgorithm.type, xmlOptions);
        }

        public static STCipherAlgorithm parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCipherAlgorithm.type, (XmlOptions) null);
        }

        public static STCipherAlgorithm parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCipherAlgorithm.type, xmlOptions);
        }

        public static STCipherAlgorithm parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCipherAlgorithm.type, (XmlOptions) null);
        }

        public static STCipherAlgorithm parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCipherAlgorithm.type, xmlOptions);
        }

        public static STCipherAlgorithm parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCipherAlgorithm.type, (XmlOptions) null);
        }

        public static STCipherAlgorithm parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCipherAlgorithm.type, xmlOptions);
        }

        public static STCipherAlgorithm parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCipherAlgorithm.type, (XmlOptions) null);
        }

        public static STCipherAlgorithm parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCipherAlgorithm.type, xmlOptions);
        }

        public static STCipherAlgorithm parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCipherAlgorithm.type, (XmlOptions) null);
        }

        public static STCipherAlgorithm parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCipherAlgorithm.type, xmlOptions);
        }

        public static STCipherAlgorithm parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCipherAlgorithm.type, (XmlOptions) null);
        }

        public static STCipherAlgorithm parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCipherAlgorithm.type, xmlOptions);
        }

        public static STCipherAlgorithm parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCipherAlgorithm.type, (XmlOptions) null);
        }

        public static STCipherAlgorithm parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCipherAlgorithm.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
