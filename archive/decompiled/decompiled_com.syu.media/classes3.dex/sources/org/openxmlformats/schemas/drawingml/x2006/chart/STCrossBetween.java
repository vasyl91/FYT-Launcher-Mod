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
public interface STCrossBetween extends XmlString {
    public static final int INT_BETWEEN = 1;
    public static final int INT_MID_CAT = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STCrossBetween.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcrossbetweenf504type");
    public static final Enum BETWEEN = Enum.forString("between");
    public static final Enum MID_CAT = Enum.forString("midCat");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BETWEEN = 1;
        static final int INT_MID_CAT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("between", 1), new Enum("midCat", 2)});

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

        public static STCrossBetween newInstance() {
            return POIXMLTypeLoader.newInstance(STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STCrossBetween.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCrossBetween.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween newValue(Object obj) {
            return STCrossBetween.type.newValue(obj);
        }

        public static STCrossBetween parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCrossBetween.type, xmlOptions);
        }

        public static STCrossBetween parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCrossBetween.type, (XmlOptions) null);
        }

        public static STCrossBetween parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCrossBetween.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
