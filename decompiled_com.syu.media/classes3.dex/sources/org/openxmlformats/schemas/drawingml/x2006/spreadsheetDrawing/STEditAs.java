package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

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
public interface STEditAs extends XmlToken {
    public static final int INT_ABSOLUTE = 3;
    public static final int INT_ONE_CELL = 2;
    public static final int INT_TWO_CELL = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STEditAs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("steditasad40type");
    public static final Enum TWO_CELL = Enum.forString("twoCell");
    public static final Enum ONE_CELL = Enum.forString("oneCell");
    public static final Enum ABSOLUTE = Enum.forString("absolute");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ABSOLUTE = 3;
        static final int INT_ONE_CELL = 2;
        static final int INT_TWO_CELL = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("twoCell", 1), new Enum("oneCell", 2), new Enum("absolute", 3)});

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

        public static STEditAs newInstance() {
            return POIXMLTypeLoader.newInstance(STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STEditAs.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STEditAs.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STEditAs.type, xmlOptions);
        }

        public static STEditAs newValue(Object obj) {
            return STEditAs.type.newValue(obj);
        }

        public static STEditAs parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STEditAs.type, xmlOptions);
        }

        public static STEditAs parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STEditAs.type, (XmlOptions) null);
        }

        public static STEditAs parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STEditAs.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
