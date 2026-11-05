package com.microsoft.schemas.vml;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface STStrokeJoinStyle extends XmlString {
    public static final int INT_BEVEL = 2;
    public static final int INT_MITER = 3;
    public static final int INT_ROUND = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STStrokeJoinStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ststrokejoinstyle3c13type");
    public static final Enum ROUND = Enum.forString("round");
    public static final Enum BEVEL = Enum.forString("bevel");
    public static final Enum MITER = Enum.forString("miter");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BEVEL = 2;
        static final int INT_MITER = 3;
        static final int INT_ROUND = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("round", 1), new Enum("bevel", 2), new Enum("miter", 3)});

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

        public static STStrokeJoinStyle newInstance() {
            return POIXMLTypeLoader.newInstance(STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STStrokeJoinStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle newValue(Object obj) {
            return STStrokeJoinStyle.type.newValue(obj);
        }

        public static STStrokeJoinStyle parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STStrokeJoinStyle.type, xmlOptions);
        }

        public static STStrokeJoinStyle parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STStrokeJoinStyle.type, (XmlOptions) null);
        }

        public static STStrokeJoinStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STStrokeJoinStyle.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
