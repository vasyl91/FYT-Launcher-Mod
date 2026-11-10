package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface STVerticalAlignment extends XmlString {
    public static final int INT_BOTTOM = 3;
    public static final int INT_CENTER = 2;
    public static final int INT_DISTRIBUTED = 5;
    public static final int INT_JUSTIFY = 4;
    public static final int INT_TOP = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STVerticalAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stverticalalignmentd35ctype");
    public static final Enum TOP = Enum.forString("top");
    public static final Enum CENTER = Enum.forString("center");
    public static final Enum BOTTOM = Enum.forString("bottom");
    public static final Enum JUSTIFY = Enum.forString("justify");
    public static final Enum DISTRIBUTED = Enum.forString("distributed");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTTOM = 3;
        static final int INT_CENTER = 2;
        static final int INT_DISTRIBUTED = 5;
        static final int INT_JUSTIFY = 4;
        static final int INT_TOP = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("top", 1), new Enum("center", 2), new Enum("bottom", 3), new Enum("justify", 4), new Enum("distributed", 5)});

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

        public static STVerticalAlignment newInstance() {
            return POIXMLTypeLoader.newInstance(STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STVerticalAlignment.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment newValue(Object obj) {
            return STVerticalAlignment.type.newValue(obj);
        }

        public static STVerticalAlignment parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STVerticalAlignment.type, xmlOptions);
        }

        public static STVerticalAlignment parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STVerticalAlignment.type, (XmlOptions) null);
        }

        public static STVerticalAlignment parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STVerticalAlignment.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
