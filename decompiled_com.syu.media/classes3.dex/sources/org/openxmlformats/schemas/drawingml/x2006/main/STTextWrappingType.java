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
public interface STTextWrappingType extends XmlToken {
    public static final int INT_NONE = 1;
    public static final int INT_SQUARE = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTextWrappingType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextwrappingtype4b4etype");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum SQUARE = Enum.forString("square");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_NONE = 1;
        static final int INT_SQUARE = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("square", 2)});

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

        public static STTextWrappingType newInstance() {
            return POIXMLTypeLoader.newInstance(STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTextWrappingType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextWrappingType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType newValue(Object obj) {
            return STTextWrappingType.type.newValue(obj);
        }

        public static STTextWrappingType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextWrappingType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
