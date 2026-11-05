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
public interface STConnectType extends XmlString {
    public static final int INT_CUSTOM = 4;
    public static final int INT_NONE = 1;
    public static final int INT_RECT = 2;
    public static final int INT_SEGMENTS = 3;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STConnectType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stconnecttype97adtype");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum RECT = Enum.forString("rect");
    public static final Enum SEGMENTS = Enum.forString("segments");
    public static final Enum CUSTOM = Enum.forString("custom");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CUSTOM = 4;
        static final int INT_NONE = 1;
        static final int INT_RECT = 2;
        static final int INT_SEGMENTS = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("rect", 2), new Enum("segments", 3), new Enum("custom", 4)});

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

        public static STConnectType newInstance() {
            return POIXMLTypeLoader.newInstance(STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STConnectType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STConnectType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STConnectType.type, xmlOptions);
        }

        public static STConnectType newValue(Object obj) {
            return STConnectType.type.newValue(obj);
        }

        public static STConnectType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STConnectType.type, xmlOptions);
        }

        public static STConnectType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STConnectType.type, (XmlOptions) null);
        }

        public static STConnectType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STConnectType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
