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
public interface STTextUnderlineType extends XmlToken {
    public static final int INT_DASH = 8;
    public static final int INT_DASH_HEAVY = 9;
    public static final int INT_DASH_LONG = 10;
    public static final int INT_DASH_LONG_HEAVY = 11;
    public static final int INT_DBL = 4;
    public static final int INT_DOTTED = 6;
    public static final int INT_DOTTED_HEAVY = 7;
    public static final int INT_DOT_DASH = 12;
    public static final int INT_DOT_DASH_HEAVY = 13;
    public static final int INT_DOT_DOT_DASH = 14;
    public static final int INT_DOT_DOT_DASH_HEAVY = 15;
    public static final int INT_HEAVY = 5;
    public static final int INT_NONE = 1;
    public static final int INT_SNG = 3;
    public static final int INT_WAVY = 16;
    public static final int INT_WAVY_DBL = 18;
    public static final int INT_WAVY_HEAVY = 17;
    public static final int INT_WORDS = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STTextUnderlineType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextunderlinetype469atype");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum WORDS = Enum.forString("words");
    public static final Enum SNG = Enum.forString("sng");
    public static final Enum DBL = Enum.forString("dbl");
    public static final Enum HEAVY = Enum.forString("heavy");
    public static final Enum DOTTED = Enum.forString("dotted");
    public static final Enum DOTTED_HEAVY = Enum.forString("dottedHeavy");
    public static final Enum DASH = Enum.forString("dash");
    public static final Enum DASH_HEAVY = Enum.forString("dashHeavy");
    public static final Enum DASH_LONG = Enum.forString("dashLong");
    public static final Enum DASH_LONG_HEAVY = Enum.forString("dashLongHeavy");
    public static final Enum DOT_DASH = Enum.forString("dotDash");
    public static final Enum DOT_DASH_HEAVY = Enum.forString("dotDashHeavy");
    public static final Enum DOT_DOT_DASH = Enum.forString("dotDotDash");
    public static final Enum DOT_DOT_DASH_HEAVY = Enum.forString("dotDotDashHeavy");
    public static final Enum WAVY = Enum.forString("wavy");
    public static final Enum WAVY_HEAVY = Enum.forString("wavyHeavy");
    public static final Enum WAVY_DBL = Enum.forString("wavyDbl");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DASH = 8;
        static final int INT_DASH_HEAVY = 9;
        static final int INT_DASH_LONG = 10;
        static final int INT_DASH_LONG_HEAVY = 11;
        static final int INT_DBL = 4;
        static final int INT_DOTTED = 6;
        static final int INT_DOTTED_HEAVY = 7;
        static final int INT_DOT_DASH = 12;
        static final int INT_DOT_DASH_HEAVY = 13;
        static final int INT_DOT_DOT_DASH = 14;
        static final int INT_DOT_DOT_DASH_HEAVY = 15;
        static final int INT_HEAVY = 5;
        static final int INT_NONE = 1;
        static final int INT_SNG = 3;
        static final int INT_WAVY = 16;
        static final int INT_WAVY_DBL = 18;
        static final int INT_WAVY_HEAVY = 17;
        static final int INT_WORDS = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("words", 2), new Enum("sng", 3), new Enum("dbl", 4), new Enum("heavy", 5), new Enum("dotted", 6), new Enum("dottedHeavy", 7), new Enum("dash", 8), new Enum("dashHeavy", 9), new Enum("dashLong", 10), new Enum("dashLongHeavy", 11), new Enum("dotDash", 12), new Enum("dotDashHeavy", 13), new Enum("dotDotDash", 14), new Enum("dotDotDashHeavy", 15), new Enum("wavy", 16), new Enum("wavyHeavy", 17), new Enum("wavyDbl", 18)});

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

        public static STTextUnderlineType newInstance() {
            return POIXMLTypeLoader.newInstance(STTextUnderlineType.type, (XmlOptions) null);
        }

        public static STTextUnderlineType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STTextUnderlineType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextUnderlineType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextUnderlineType.type, xmlOptions);
        }

        public static STTextUnderlineType newValue(Object obj) {
            return STTextUnderlineType.type.newValue(obj);
        }

        public static STTextUnderlineType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextUnderlineType.type, (XmlOptions) null);
        }

        public static STTextUnderlineType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STTextUnderlineType.type, xmlOptions);
        }

        public static STTextUnderlineType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextUnderlineType.type, (XmlOptions) null);
        }

        public static STTextUnderlineType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STTextUnderlineType.type, xmlOptions);
        }

        public static STTextUnderlineType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextUnderlineType.type, (XmlOptions) null);
        }

        public static STTextUnderlineType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STTextUnderlineType.type, xmlOptions);
        }

        public static STTextUnderlineType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextUnderlineType.type, (XmlOptions) null);
        }

        public static STTextUnderlineType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STTextUnderlineType.type, xmlOptions);
        }

        public static STTextUnderlineType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextUnderlineType.type, (XmlOptions) null);
        }

        public static STTextUnderlineType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STTextUnderlineType.type, xmlOptions);
        }

        public static STTextUnderlineType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextUnderlineType.type, (XmlOptions) null);
        }

        public static STTextUnderlineType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STTextUnderlineType.type, xmlOptions);
        }

        public static STTextUnderlineType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextUnderlineType.type, (XmlOptions) null);
        }

        public static STTextUnderlineType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STTextUnderlineType.type, xmlOptions);
        }

        public static STTextUnderlineType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextUnderlineType.type, (XmlOptions) null);
        }

        public static STTextUnderlineType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STTextUnderlineType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
