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
public interface STOnOff extends XmlString {
    public static final int INT_FALSE = 2;
    public static final int INT_OFF = 4;
    public static final int INT_ON = 3;
    public static final int INT_TRUE = 1;
    public static final int INT_X_0 = 5;
    public static final int INT_X_1 = 6;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STOnOff.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stonofffcd2type");
    public static final Enum TRUE = Enum.forString("true");
    public static final Enum FALSE = Enum.forString("false");
    public static final Enum ON = Enum.forString("on");
    public static final Enum OFF = Enum.forString("off");
    public static final Enum X_0 = Enum.forString("0");
    public static final Enum X_1 = Enum.forString("1");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FALSE = 2;
        static final int INT_OFF = 4;
        static final int INT_ON = 3;
        static final int INT_TRUE = 1;
        static final int INT_X_0 = 5;
        static final int INT_X_1 = 6;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("true", 1), new Enum("false", 2), new Enum("on", 3), new Enum("off", 4), new Enum("0", 5), new Enum("1", 6)});

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

        public static STOnOff newInstance() {
            return POIXMLTypeLoader.newInstance(STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STOnOff.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STOnOff.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STOnOff.type, xmlOptions);
        }

        public static STOnOff newValue(Object obj) {
            return STOnOff.type.newValue(obj);
        }

        public static STOnOff parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STOnOff.type, xmlOptions);
        }

        public static STOnOff parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STOnOff.type, (XmlOptions) null);
        }

        public static STOnOff parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STOnOff.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
