package org.openxmlformats.schemas.drawingml.x2006.chart;

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
public interface STOrientation extends XmlString {
    public static final int INT_MAX_MIN = 1;
    public static final int INT_MIN_MAX = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STOrientation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("storientationc326type");
    public static final Enum MAX_MIN = Enum.forString("maxMin");
    public static final Enum MIN_MAX = Enum.forString("minMax");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_MAX_MIN = 1;
        static final int INT_MIN_MAX = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("maxMin", 1), new Enum("minMax", 2)});

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

        public static STOrientation newInstance() {
            return POIXMLTypeLoader.newInstance(STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STOrientation.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STOrientation.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STOrientation.type, xmlOptions);
        }

        public static STOrientation newValue(Object obj) {
            return STOrientation.type.newValue(obj);
        }

        public static STOrientation parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STOrientation.type, xmlOptions);
        }

        public static STOrientation parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STOrientation.type, (XmlOptions) null);
        }

        public static STOrientation parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STOrientation.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
