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
public interface STTextAlignType extends XmlToken {
    public static final int INT_CTR = 2;
    public static final int INT_DIST = 6;
    public static final int INT_JUST = 4;
    public static final int INT_JUST_LOW = 5;
    public static final int INT_L = 1;
    public static final int INT_R = 3;
    public static final int INT_THAI_DIST = 7;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTextAlignType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextaligntypebc93type");
    public static final Enum L = Enum.forString("l");
    public static final Enum CTR = Enum.forString("ctr");
    public static final Enum R = Enum.forString("r");
    public static final Enum JUST = Enum.forString("just");
    public static final Enum JUST_LOW = Enum.forString("justLow");
    public static final Enum DIST = Enum.forString("dist");
    public static final Enum THAI_DIST = Enum.forString("thaiDist");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CTR = 2;
        static final int INT_DIST = 6;
        static final int INT_JUST = 4;
        static final int INT_JUST_LOW = 5;
        static final int INT_L = 1;
        static final int INT_R = 3;
        static final int INT_THAI_DIST = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("l", 1), new Enum("ctr", 2), new Enum("r", 3), new Enum("just", 4), new Enum("justLow", 5), new Enum("dist", 6), new Enum("thaiDist", 7)});

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

        public static STTextAlignType newInstance() {
            return POIXMLTypeLoader.newInstance(STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTextAlignType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextAlignType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType newValue(Object obj) {
            return STTextAlignType.type.newValue(obj);
        }

        public static STTextAlignType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextAlignType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
