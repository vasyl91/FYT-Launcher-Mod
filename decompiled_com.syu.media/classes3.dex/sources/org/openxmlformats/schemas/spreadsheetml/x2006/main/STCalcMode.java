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
public interface STCalcMode extends XmlString {
    public static final int INT_AUTO = 2;
    public static final int INT_AUTO_NO_TABLE = 3;
    public static final int INT_MANUAL = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STCalcMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcalcmode5e71type");
    public static final Enum MANUAL = Enum.forString("manual");
    public static final Enum AUTO = Enum.forString("auto");
    public static final Enum AUTO_NO_TABLE = Enum.forString("autoNoTable");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 2;
        static final int INT_AUTO_NO_TABLE = 3;
        static final int INT_MANUAL = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("manual", 1), new Enum("auto", 2), new Enum("autoNoTable", 3)});

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

        public static STCalcMode newInstance() {
            return POIXMLTypeLoader.newInstance(STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STCalcMode.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCalcMode.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode newValue(Object obj) {
            return STCalcMode.type.newValue(obj);
        }

        public static STCalcMode parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCalcMode.type, xmlOptions);
        }

        public static STCalcMode parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCalcMode.type, (XmlOptions) null);
        }

        public static STCalcMode parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCalcMode.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
