package org.openxmlformats.schemas.drawingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STTextCapsType extends XmlToken {
    public static final int INT_ALL = 3;
    public static final int INT_NONE = 1;
    public static final int INT_SMALL = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTextCapsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextcapstyped233type");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum SMALL = Enum.forString("small");
    public static final Enum ALL = Enum.forString("all");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ALL = 3;
        static final int INT_NONE = 1;
        static final int INT_SMALL = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("small", 2), new Enum("all", 3)});

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

        public static STTextCapsType newInstance() {
            return POIXMLTypeLoader.newInstance(STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTextCapsType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextCapsType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType newValue(Object obj) {
            return STTextCapsType.type.newValue(obj);
        }

        public static STTextCapsType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextCapsType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
