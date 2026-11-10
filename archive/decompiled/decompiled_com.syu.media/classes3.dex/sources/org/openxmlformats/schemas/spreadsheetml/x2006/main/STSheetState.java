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
public interface STSheetState extends XmlString {
    public static final int INT_HIDDEN = 2;
    public static final int INT_VERY_HIDDEN = 3;
    public static final int INT_VISIBLE = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STSheetState.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stsheetstate158btype");
    public static final Enum VISIBLE = Enum.forString("visible");
    public static final Enum HIDDEN = Enum.forString("hidden");
    public static final Enum VERY_HIDDEN = Enum.forString("veryHidden");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_HIDDEN = 2;
        static final int INT_VERY_HIDDEN = 3;
        static final int INT_VISIBLE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("visible", 1), new Enum("hidden", 2), new Enum("veryHidden", 3)});

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

        public static STSheetState newInstance() {
            return POIXMLTypeLoader.newInstance(STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STSheetState.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSheetState.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSheetState.type, xmlOptions);
        }

        public static STSheetState newValue(Object obj) {
            return STSheetState.type.newValue(obj);
        }

        public static STSheetState parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STSheetState.type, xmlOptions);
        }

        public static STSheetState parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STSheetState.type, (XmlOptions) null);
        }

        public static STSheetState parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STSheetState.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
