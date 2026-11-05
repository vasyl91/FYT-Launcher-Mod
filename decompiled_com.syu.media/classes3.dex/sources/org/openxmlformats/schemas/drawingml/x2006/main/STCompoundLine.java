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
public interface STCompoundLine extends XmlToken {
    public static final int INT_DBL = 2;
    public static final int INT_SNG = 1;
    public static final int INT_THICK_THIN = 3;
    public static final int INT_THIN_THICK = 4;
    public static final int INT_TRI = 5;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STCompoundLine.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcompoundline712atype");
    public static final Enum SNG = Enum.forString("sng");
    public static final Enum DBL = Enum.forString("dbl");
    public static final Enum THICK_THIN = Enum.forString("thickThin");
    public static final Enum THIN_THICK = Enum.forString("thinThick");
    public static final Enum TRI = Enum.forString("tri");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DBL = 2;
        static final int INT_SNG = 1;
        static final int INT_THICK_THIN = 3;
        static final int INT_THIN_THICK = 4;
        static final int INT_TRI = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("sng", 1), new Enum("dbl", 2), new Enum("thickThin", 3), new Enum("thinThick", 4), new Enum("tri", 5)});

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

        public static STCompoundLine newInstance() {
            return POIXMLTypeLoader.newInstance(STCompoundLine.type, (XmlOptions) null);
        }

        public static STCompoundLine newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STCompoundLine.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCompoundLine.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCompoundLine.type, xmlOptions);
        }

        public static STCompoundLine newValue(Object obj) {
            return STCompoundLine.type.newValue(obj);
        }

        public static STCompoundLine parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCompoundLine.type, (XmlOptions) null);
        }

        public static STCompoundLine parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCompoundLine.type, xmlOptions);
        }

        public static STCompoundLine parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCompoundLine.type, (XmlOptions) null);
        }

        public static STCompoundLine parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCompoundLine.type, xmlOptions);
        }

        public static STCompoundLine parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCompoundLine.type, (XmlOptions) null);
        }

        public static STCompoundLine parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCompoundLine.type, xmlOptions);
        }

        public static STCompoundLine parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCompoundLine.type, (XmlOptions) null);
        }

        public static STCompoundLine parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCompoundLine.type, xmlOptions);
        }

        public static STCompoundLine parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCompoundLine.type, (XmlOptions) null);
        }

        public static STCompoundLine parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCompoundLine.type, xmlOptions);
        }

        public static STCompoundLine parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCompoundLine.type, (XmlOptions) null);
        }

        public static STCompoundLine parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCompoundLine.type, xmlOptions);
        }

        public static STCompoundLine parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCompoundLine.type, (XmlOptions) null);
        }

        public static STCompoundLine parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCompoundLine.type, xmlOptions);
        }

        public static STCompoundLine parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCompoundLine.type, (XmlOptions) null);
        }

        public static STCompoundLine parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCompoundLine.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
