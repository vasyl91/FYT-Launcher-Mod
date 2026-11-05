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
public interface STLineEndWidth extends XmlToken {
    public static final int INT_LG = 3;
    public static final int INT_MED = 2;
    public static final int INT_SM = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STLineEndWidth.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stlineendwidth16aatype");
    public static final Enum SM = Enum.forString("sm");
    public static final Enum MED = Enum.forString("med");
    public static final Enum LG = Enum.forString("lg");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_LG = 3;
        static final int INT_MED = 2;
        static final int INT_SM = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("sm", 1), new Enum("med", 2), new Enum("lg", 3)});

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

        public static STLineEndWidth newInstance() {
            return POIXMLTypeLoader.newInstance(STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STLineEndWidth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineEndWidth.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth newValue(Object obj) {
            return STLineEndWidth.type.newValue(obj);
        }

        public static STLineEndWidth parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STLineEndWidth.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
