package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface STCryptProv extends XmlString {
    public static final int INT_RSA_AES = 1;
    public static final int INT_RSA_FULL = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STCryptProv.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcryptprov6ccbtype");
    public static final Enum RSA_AES = Enum.forString("rsaAES");
    public static final Enum RSA_FULL = Enum.forString("rsaFull");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_RSA_AES = 1;
        static final int INT_RSA_FULL = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("rsaAES", 1), new Enum("rsaFull", 2)});

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

        public static STCryptProv newInstance() {
            return POIXMLTypeLoader.newInstance(STCryptProv.type, (XmlOptions) null);
        }

        public static STCryptProv newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STCryptProv.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCryptProv.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCryptProv.type, xmlOptions);
        }

        public static STCryptProv newValue(Object obj) {
            return STCryptProv.type.newValue(obj);
        }

        public static STCryptProv parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCryptProv.type, (XmlOptions) null);
        }

        public static STCryptProv parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCryptProv.type, xmlOptions);
        }

        public static STCryptProv parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCryptProv.type, (XmlOptions) null);
        }

        public static STCryptProv parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCryptProv.type, xmlOptions);
        }

        public static STCryptProv parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCryptProv.type, (XmlOptions) null);
        }

        public static STCryptProv parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCryptProv.type, xmlOptions);
        }

        public static STCryptProv parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCryptProv.type, (XmlOptions) null);
        }

        public static STCryptProv parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCryptProv.type, xmlOptions);
        }

        public static STCryptProv parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCryptProv.type, (XmlOptions) null);
        }

        public static STCryptProv parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCryptProv.type, xmlOptions);
        }

        public static STCryptProv parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCryptProv.type, (XmlOptions) null);
        }

        public static STCryptProv parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCryptProv.type, xmlOptions);
        }

        public static STCryptProv parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCryptProv.type, (XmlOptions) null);
        }

        public static STCryptProv parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCryptProv.type, xmlOptions);
        }

        public static STCryptProv parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCryptProv.type, (XmlOptions) null);
        }

        public static STCryptProv parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCryptProv.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
