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
public interface STAlgType extends XmlString {
    public static final int INT_TYPE_ANY = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STAlgType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stalgtype156ctype");
    public static final Enum TYPE_ANY = Enum.forString("typeAny");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_TYPE_ANY = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("typeAny", 1)});

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

        public static STAlgType newInstance() {
            return POIXMLTypeLoader.newInstance(STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STAlgType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAlgType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAlgType.type, xmlOptions);
        }

        public static STAlgType newValue(Object obj) {
            return STAlgType.type.newValue(obj);
        }

        public static STAlgType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STAlgType.type, xmlOptions);
        }

        public static STAlgType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STAlgType.type, (XmlOptions) null);
        }

        public static STAlgType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STAlgType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
