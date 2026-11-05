package com.microsoft.schemas.office.office;

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
public interface STInsetMode extends XmlString {
    public static final int INT_AUTO = 1;
    public static final int INT_CUSTOM = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STInsetMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stinsetmode3b89type");
    public static final Enum AUTO = Enum.forString("auto");
    public static final Enum CUSTOM = Enum.forString("custom");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 1;
        static final int INT_CUSTOM = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("auto", 1), new Enum("custom", 2)});

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

        public static STInsetMode newInstance() {
            return POIXMLTypeLoader.newInstance(STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STInsetMode.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STInsetMode.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode newValue(Object obj) {
            return STInsetMode.type.newValue(obj);
        }

        public static STInsetMode parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STInsetMode.type, xmlOptions);
        }

        public static STInsetMode parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STInsetMode.type, (XmlOptions) null);
        }

        public static STInsetMode parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STInsetMode.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
