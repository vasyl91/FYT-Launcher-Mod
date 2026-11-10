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
public interface STCellComments extends XmlString {
    public static final int INT_AS_DISPLAYED = 2;
    public static final int INT_AT_END = 3;
    public static final int INT_NONE = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STCellComments.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcellcomments7e4ftype");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum AS_DISPLAYED = Enum.forString("asDisplayed");
    public static final Enum AT_END = Enum.forString("atEnd");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AS_DISPLAYED = 2;
        static final int INT_AT_END = 3;
        static final int INT_NONE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("asDisplayed", 2), new Enum("atEnd", 3)});

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

        public static STCellComments newInstance() {
            return POIXMLTypeLoader.newInstance(STCellComments.type, (XmlOptions) null);
        }

        public static STCellComments newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STCellComments.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCellComments.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCellComments.type, xmlOptions);
        }

        public static STCellComments newValue(Object obj) {
            return STCellComments.type.newValue(obj);
        }

        public static STCellComments parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCellComments.type, (XmlOptions) null);
        }

        public static STCellComments parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCellComments.type, xmlOptions);
        }

        public static STCellComments parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCellComments.type, (XmlOptions) null);
        }

        public static STCellComments parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCellComments.type, xmlOptions);
        }

        public static STCellComments parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCellComments.type, (XmlOptions) null);
        }

        public static STCellComments parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCellComments.type, xmlOptions);
        }

        public static STCellComments parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCellComments.type, (XmlOptions) null);
        }

        public static STCellComments parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCellComments.type, xmlOptions);
        }

        public static STCellComments parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCellComments.type, (XmlOptions) null);
        }

        public static STCellComments parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCellComments.type, xmlOptions);
        }

        public static STCellComments parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCellComments.type, (XmlOptions) null);
        }

        public static STCellComments parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCellComments.type, xmlOptions);
        }

        public static STCellComments parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCellComments.type, (XmlOptions) null);
        }

        public static STCellComments parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCellComments.type, xmlOptions);
        }

        public static STCellComments parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCellComments.type, (XmlOptions) null);
        }

        public static STCellComments parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCellComments.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
