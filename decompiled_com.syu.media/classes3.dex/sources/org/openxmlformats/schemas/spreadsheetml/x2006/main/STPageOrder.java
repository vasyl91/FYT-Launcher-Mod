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
public interface STPageOrder extends XmlString {
    public static final int INT_DOWN_THEN_OVER = 1;
    public static final int INT_OVER_THEN_DOWN = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STPageOrder.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stpageorderd2cetype");
    public static final Enum DOWN_THEN_OVER = Enum.forString("downThenOver");
    public static final Enum OVER_THEN_DOWN = Enum.forString("overThenDown");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DOWN_THEN_OVER = 1;
        static final int INT_OVER_THEN_DOWN = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("downThenOver", 1), new Enum("overThenDown", 2)});

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

        public static STPageOrder newInstance() {
            return POIXMLTypeLoader.newInstance(STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STPageOrder.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPageOrder.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder newValue(Object obj) {
            return STPageOrder.type.newValue(obj);
        }

        public static STPageOrder parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STPageOrder.type, xmlOptions);
        }

        public static STPageOrder parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STPageOrder.type, (XmlOptions) null);
        }

        public static STPageOrder parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STPageOrder.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
