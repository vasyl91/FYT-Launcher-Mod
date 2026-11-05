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
public interface STLayoutMode extends XmlString {
    public static final int INT_EDGE = 1;
    public static final int INT_FACTOR = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STLayoutMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlayoutmode19dftype");
    public static final Enum EDGE = Enum.forString("edge");
    public static final Enum FACTOR = Enum.forString("factor");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EDGE = 1;
        static final int INT_FACTOR = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("edge", 1), new Enum("factor", 2)});

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

        public static STLayoutMode newInstance() {
            return POIXMLTypeLoader.newInstance(STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STLayoutMode.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLayoutMode.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode newValue(Object obj) {
            return STLayoutMode.type.newValue(obj);
        }

        public static STLayoutMode parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLayoutMode.type, xmlOptions);
        }

        public static STLayoutMode parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLayoutMode.type, (XmlOptions) null);
        }

        public static STLayoutMode parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLayoutMode.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
