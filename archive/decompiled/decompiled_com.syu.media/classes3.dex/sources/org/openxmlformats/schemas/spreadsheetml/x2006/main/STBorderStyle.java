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
public interface STBorderStyle extends XmlString {
    public static final int INT_DASHED = 4;
    public static final int INT_DASH_DOT = 10;
    public static final int INT_DASH_DOT_DOT = 12;
    public static final int INT_DOTTED = 5;
    public static final int INT_DOUBLE = 7;
    public static final int INT_HAIR = 8;
    public static final int INT_MEDIUM = 3;
    public static final int INT_MEDIUM_DASHED = 9;
    public static final int INT_MEDIUM_DASH_DOT = 11;
    public static final int INT_MEDIUM_DASH_DOT_DOT = 13;
    public static final int INT_NONE = 1;
    public static final int INT_SLANT_DASH_DOT = 14;
    public static final int INT_THICK = 6;
    public static final int INT_THIN = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STBorderStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stborderstylec774type");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum THIN = Enum.forString("thin");
    public static final Enum MEDIUM = Enum.forString("medium");
    public static final Enum DASHED = Enum.forString("dashed");
    public static final Enum DOTTED = Enum.forString("dotted");
    public static final Enum THICK = Enum.forString("thick");
    public static final Enum DOUBLE = Enum.forString("double");
    public static final Enum HAIR = Enum.forString("hair");
    public static final Enum MEDIUM_DASHED = Enum.forString("mediumDashed");
    public static final Enum DASH_DOT = Enum.forString("dashDot");
    public static final Enum MEDIUM_DASH_DOT = Enum.forString("mediumDashDot");
    public static final Enum DASH_DOT_DOT = Enum.forString("dashDotDot");
    public static final Enum MEDIUM_DASH_DOT_DOT = Enum.forString("mediumDashDotDot");
    public static final Enum SLANT_DASH_DOT = Enum.forString("slantDashDot");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DASHED = 4;
        static final int INT_DASH_DOT = 10;
        static final int INT_DASH_DOT_DOT = 12;
        static final int INT_DOTTED = 5;
        static final int INT_DOUBLE = 7;
        static final int INT_HAIR = 8;
        static final int INT_MEDIUM = 3;
        static final int INT_MEDIUM_DASHED = 9;
        static final int INT_MEDIUM_DASH_DOT = 11;
        static final int INT_MEDIUM_DASH_DOT_DOT = 13;
        static final int INT_NONE = 1;
        static final int INT_SLANT_DASH_DOT = 14;
        static final int INT_THICK = 6;
        static final int INT_THIN = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("thin", 2), new Enum("medium", 3), new Enum("dashed", 4), new Enum("dotted", 5), new Enum("thick", 6), new Enum("double", 7), new Enum("hair", 8), new Enum("mediumDashed", 9), new Enum("dashDot", 10), new Enum("mediumDashDot", 11), new Enum("dashDotDot", 12), new Enum("mediumDashDotDot", 13), new Enum("slantDashDot", 14)});

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

        public static STBorderStyle newInstance() {
            return POIXMLTypeLoader.newInstance(STBorderStyle.type, (XmlOptions) null);
        }

        public static STBorderStyle newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STBorderStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STBorderStyle.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STBorderStyle.type, xmlOptions);
        }

        public static STBorderStyle newValue(Object obj) {
            return STBorderStyle.type.newValue(obj);
        }

        public static STBorderStyle parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STBorderStyle.type, (XmlOptions) null);
        }

        public static STBorderStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STBorderStyle.type, xmlOptions);
        }

        public static STBorderStyle parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STBorderStyle.type, (XmlOptions) null);
        }

        public static STBorderStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STBorderStyle.type, xmlOptions);
        }

        public static STBorderStyle parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STBorderStyle.type, (XmlOptions) null);
        }

        public static STBorderStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STBorderStyle.type, xmlOptions);
        }

        public static STBorderStyle parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STBorderStyle.type, (XmlOptions) null);
        }

        public static STBorderStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STBorderStyle.type, xmlOptions);
        }

        public static STBorderStyle parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STBorderStyle.type, (XmlOptions) null);
        }

        public static STBorderStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STBorderStyle.type, xmlOptions);
        }

        public static STBorderStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STBorderStyle.type, (XmlOptions) null);
        }

        public static STBorderStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STBorderStyle.type, xmlOptions);
        }

        public static STBorderStyle parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STBorderStyle.type, (XmlOptions) null);
        }

        public static STBorderStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STBorderStyle.type, xmlOptions);
        }

        public static STBorderStyle parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STBorderStyle.type, (XmlOptions) null);
        }

        public static STBorderStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STBorderStyle.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
