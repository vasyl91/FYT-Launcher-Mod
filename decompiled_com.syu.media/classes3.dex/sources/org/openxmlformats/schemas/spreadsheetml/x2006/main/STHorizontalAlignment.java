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
public interface STHorizontalAlignment extends XmlString {
    public static final int INT_CENTER = 3;
    public static final int INT_CENTER_CONTINUOUS = 7;
    public static final int INT_DISTRIBUTED = 8;
    public static final int INT_FILL = 5;
    public static final int INT_GENERAL = 1;
    public static final int INT_JUSTIFY = 6;
    public static final int INT_LEFT = 2;
    public static final int INT_RIGHT = 4;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STHorizontalAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sthorizontalalignmentf92etype");
    public static final Enum GENERAL = Enum.forString("general");
    public static final Enum LEFT = Enum.forString("left");
    public static final Enum CENTER = Enum.forString("center");
    public static final Enum RIGHT = Enum.forString("right");
    public static final Enum FILL = Enum.forString("fill");
    public static final Enum JUSTIFY = Enum.forString("justify");
    public static final Enum CENTER_CONTINUOUS = Enum.forString("centerContinuous");
    public static final Enum DISTRIBUTED = Enum.forString("distributed");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CENTER = 3;
        static final int INT_CENTER_CONTINUOUS = 7;
        static final int INT_DISTRIBUTED = 8;
        static final int INT_FILL = 5;
        static final int INT_GENERAL = 1;
        static final int INT_JUSTIFY = 6;
        static final int INT_LEFT = 2;
        static final int INT_RIGHT = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("general", 1), new Enum("left", 2), new Enum("center", 3), new Enum("right", 4), new Enum("fill", 5), new Enum("justify", 6), new Enum("centerContinuous", 7), new Enum("distributed", 8)});

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

        public static STHorizontalAlignment newInstance() {
            return POIXMLTypeLoader.newInstance(STHorizontalAlignment.type, (XmlOptions) null);
        }

        public static STHorizontalAlignment newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STHorizontalAlignment.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHorizontalAlignment.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHorizontalAlignment.type, xmlOptions);
        }

        public static STHorizontalAlignment newValue(Object obj) {
            return STHorizontalAlignment.type.newValue(obj);
        }

        public static STHorizontalAlignment parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STHorizontalAlignment.type, (XmlOptions) null);
        }

        public static STHorizontalAlignment parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STHorizontalAlignment.type, xmlOptions);
        }

        public static STHorizontalAlignment parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STHorizontalAlignment.type, (XmlOptions) null);
        }

        public static STHorizontalAlignment parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STHorizontalAlignment.type, xmlOptions);
        }

        public static STHorizontalAlignment parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STHorizontalAlignment.type, (XmlOptions) null);
        }

        public static STHorizontalAlignment parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STHorizontalAlignment.type, xmlOptions);
        }

        public static STHorizontalAlignment parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STHorizontalAlignment.type, (XmlOptions) null);
        }

        public static STHorizontalAlignment parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STHorizontalAlignment.type, xmlOptions);
        }

        public static STHorizontalAlignment parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STHorizontalAlignment.type, (XmlOptions) null);
        }

        public static STHorizontalAlignment parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STHorizontalAlignment.type, xmlOptions);
        }

        public static STHorizontalAlignment parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STHorizontalAlignment.type, (XmlOptions) null);
        }

        public static STHorizontalAlignment parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STHorizontalAlignment.type, xmlOptions);
        }

        public static STHorizontalAlignment parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STHorizontalAlignment.type, (XmlOptions) null);
        }

        public static STHorizontalAlignment parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STHorizontalAlignment.type, xmlOptions);
        }

        public static STHorizontalAlignment parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STHorizontalAlignment.type, (XmlOptions) null);
        }

        public static STHorizontalAlignment parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STHorizontalAlignment.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
