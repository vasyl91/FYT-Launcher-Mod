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
public interface STCellFormulaType extends XmlString {
    public static final int INT_ARRAY = 2;
    public static final int INT_DATA_TABLE = 3;
    public static final int INT_NORMAL = 1;
    public static final int INT_SHARED = 4;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STCellFormulaType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcellformulatypee2cdtype");
    public static final Enum NORMAL = Enum.forString("normal");
    public static final Enum ARRAY = Enum.forString("array");
    public static final Enum DATA_TABLE = Enum.forString("dataTable");
    public static final Enum SHARED = Enum.forString("shared");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ARRAY = 2;
        static final int INT_DATA_TABLE = 3;
        static final int INT_NORMAL = 1;
        static final int INT_SHARED = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("normal", 1), new Enum("array", 2), new Enum("dataTable", 3), new Enum("shared", 4)});

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

        public static STCellFormulaType newInstance() {
            return POIXMLTypeLoader.newInstance(STCellFormulaType.type, (XmlOptions) null);
        }

        public static STCellFormulaType newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STCellFormulaType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCellFormulaType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCellFormulaType.type, xmlOptions);
        }

        public static STCellFormulaType newValue(Object obj) {
            return STCellFormulaType.type.newValue(obj);
        }

        public static STCellFormulaType parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCellFormulaType.type, (XmlOptions) null);
        }

        public static STCellFormulaType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STCellFormulaType.type, xmlOptions);
        }

        public static STCellFormulaType parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCellFormulaType.type, (XmlOptions) null);
        }

        public static STCellFormulaType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STCellFormulaType.type, xmlOptions);
        }

        public static STCellFormulaType parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCellFormulaType.type, (XmlOptions) null);
        }

        public static STCellFormulaType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STCellFormulaType.type, xmlOptions);
        }

        public static STCellFormulaType parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCellFormulaType.type, (XmlOptions) null);
        }

        public static STCellFormulaType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STCellFormulaType.type, xmlOptions);
        }

        public static STCellFormulaType parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCellFormulaType.type, (XmlOptions) null);
        }

        public static STCellFormulaType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STCellFormulaType.type, xmlOptions);
        }

        public static STCellFormulaType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCellFormulaType.type, (XmlOptions) null);
        }

        public static STCellFormulaType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STCellFormulaType.type, xmlOptions);
        }

        public static STCellFormulaType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCellFormulaType.type, (XmlOptions) null);
        }

        public static STCellFormulaType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STCellFormulaType.type, xmlOptions);
        }

        public static STCellFormulaType parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCellFormulaType.type, (XmlOptions) null);
        }

        public static STCellFormulaType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STCellFormulaType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
