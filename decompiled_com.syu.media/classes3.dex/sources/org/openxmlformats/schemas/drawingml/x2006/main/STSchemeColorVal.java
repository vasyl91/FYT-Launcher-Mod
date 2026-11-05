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
public interface STSchemeColorVal extends XmlToken {
    public static final int INT_ACCENT_1 = 5;
    public static final int INT_ACCENT_2 = 6;
    public static final int INT_ACCENT_3 = 7;
    public static final int INT_ACCENT_4 = 8;
    public static final int INT_ACCENT_5 = 9;
    public static final int INT_ACCENT_6 = 10;
    public static final int INT_BG_1 = 1;
    public static final int INT_BG_2 = 3;
    public static final int INT_DK_1 = 14;
    public static final int INT_DK_2 = 16;
    public static final int INT_FOL_HLINK = 12;
    public static final int INT_HLINK = 11;
    public static final int INT_LT_1 = 15;
    public static final int INT_LT_2 = 17;
    public static final int INT_PH_CLR = 13;
    public static final int INT_TX_1 = 2;
    public static final int INT_TX_2 = 4;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STSchemeColorVal.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stschemecolorval722etype");
    public static final Enum BG_1 = Enum.forString("bg1");
    public static final Enum TX_1 = Enum.forString("tx1");
    public static final Enum BG_2 = Enum.forString("bg2");
    public static final Enum TX_2 = Enum.forString("tx2");
    public static final Enum ACCENT_1 = Enum.forString("accent1");
    public static final Enum ACCENT_2 = Enum.forString("accent2");
    public static final Enum ACCENT_3 = Enum.forString("accent3");
    public static final Enum ACCENT_4 = Enum.forString("accent4");
    public static final Enum ACCENT_5 = Enum.forString("accent5");
    public static final Enum ACCENT_6 = Enum.forString("accent6");
    public static final Enum HLINK = Enum.forString("hlink");
    public static final Enum FOL_HLINK = Enum.forString("folHlink");
    public static final Enum PH_CLR = Enum.forString("phClr");
    public static final Enum DK_1 = Enum.forString("dk1");
    public static final Enum LT_1 = Enum.forString("lt1");
    public static final Enum DK_2 = Enum.forString("dk2");
    public static final Enum LT_2 = Enum.forString("lt2");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ACCENT_1 = 5;
        static final int INT_ACCENT_2 = 6;
        static final int INT_ACCENT_3 = 7;
        static final int INT_ACCENT_4 = 8;
        static final int INT_ACCENT_5 = 9;
        static final int INT_ACCENT_6 = 10;
        static final int INT_BG_1 = 1;
        static final int INT_BG_2 = 3;
        static final int INT_DK_1 = 14;
        static final int INT_DK_2 = 16;
        static final int INT_FOL_HLINK = 12;
        static final int INT_HLINK = 11;
        static final int INT_LT_1 = 15;
        static final int INT_LT_2 = 17;
        static final int INT_PH_CLR = 13;
        static final int INT_TX_1 = 2;
        static final int INT_TX_2 = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("bg1", 1), new Enum("tx1", 2), new Enum("bg2", 3), new Enum("tx2", 4), new Enum("accent1", 5), new Enum("accent2", 6), new Enum("accent3", 7), new Enum("accent4", 8), new Enum("accent5", 9), new Enum("accent6", 10), new Enum("hlink", 11), new Enum("folHlink", 12), new Enum("phClr", 13), new Enum("dk1", 14), new Enum("lt1", 15), new Enum("dk2", 16), new Enum("lt2", 17)});

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

        public static STSchemeColorVal newInstance() {
            return POIXMLTypeLoader.newInstance(STSchemeColorVal.type, (XmlOptions) null);
        }

        public static STSchemeColorVal newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STSchemeColorVal.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSchemeColorVal.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSchemeColorVal.type, xmlOptions);
        }

        public static STSchemeColorVal newValue(Object obj) {
            return STSchemeColorVal.type.newValue(obj);
        }

        public static STSchemeColorVal parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STSchemeColorVal.type, (XmlOptions) null);
        }

        public static STSchemeColorVal parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STSchemeColorVal.type, xmlOptions);
        }

        public static STSchemeColorVal parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STSchemeColorVal.type, (XmlOptions) null);
        }

        public static STSchemeColorVal parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STSchemeColorVal.type, xmlOptions);
        }

        public static STSchemeColorVal parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STSchemeColorVal.type, (XmlOptions) null);
        }

        public static STSchemeColorVal parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STSchemeColorVal.type, xmlOptions);
        }

        public static STSchemeColorVal parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STSchemeColorVal.type, (XmlOptions) null);
        }

        public static STSchemeColorVal parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STSchemeColorVal.type, xmlOptions);
        }

        public static STSchemeColorVal parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STSchemeColorVal.type, (XmlOptions) null);
        }

        public static STSchemeColorVal parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STSchemeColorVal.type, xmlOptions);
        }

        public static STSchemeColorVal parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STSchemeColorVal.type, (XmlOptions) null);
        }

        public static STSchemeColorVal parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STSchemeColorVal.type, xmlOptions);
        }

        public static STSchemeColorVal parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STSchemeColorVal.type, (XmlOptions) null);
        }

        public static STSchemeColorVal parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STSchemeColorVal.type, xmlOptions);
        }

        public static STSchemeColorVal parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STSchemeColorVal.type, (XmlOptions) null);
        }

        public static STSchemeColorVal parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STSchemeColorVal.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
