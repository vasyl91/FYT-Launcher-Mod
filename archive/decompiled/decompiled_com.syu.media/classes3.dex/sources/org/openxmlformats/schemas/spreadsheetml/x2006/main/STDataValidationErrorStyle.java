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
public interface STDataValidationErrorStyle extends XmlString {
    public static final int INT_INFORMATION = 3;
    public static final int INT_STOP = 1;
    public static final int INT_WARNING = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STDataValidationErrorStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdatavalidationerrorstyleca85type");
    public static final Enum STOP = Enum.forString("stop");
    public static final Enum WARNING = Enum.forString("warning");
    public static final Enum INFORMATION = Enum.forString("information");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_INFORMATION = 3;
        static final int INT_STOP = 1;
        static final int INT_WARNING = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("stop", 1), new Enum("warning", 2), new Enum("information", 3)});

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

        public static STDataValidationErrorStyle newInstance() {
            return POIXMLTypeLoader.newInstance(STDataValidationErrorStyle.type, (XmlOptions) null);
        }

        public static STDataValidationErrorStyle newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STDataValidationErrorStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDataValidationErrorStyle.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDataValidationErrorStyle.type, xmlOptions);
        }

        public static STDataValidationErrorStyle newValue(Object obj) {
            return STDataValidationErrorStyle.type.newValue(obj);
        }

        public static STDataValidationErrorStyle parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STDataValidationErrorStyle.type, (XmlOptions) null);
        }

        public static STDataValidationErrorStyle parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STDataValidationErrorStyle.type, xmlOptions);
        }

        public static STDataValidationErrorStyle parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STDataValidationErrorStyle.type, (XmlOptions) null);
        }

        public static STDataValidationErrorStyle parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STDataValidationErrorStyle.type, xmlOptions);
        }

        public static STDataValidationErrorStyle parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STDataValidationErrorStyle.type, (XmlOptions) null);
        }

        public static STDataValidationErrorStyle parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STDataValidationErrorStyle.type, xmlOptions);
        }

        public static STDataValidationErrorStyle parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STDataValidationErrorStyle.type, (XmlOptions) null);
        }

        public static STDataValidationErrorStyle parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STDataValidationErrorStyle.type, xmlOptions);
        }

        public static STDataValidationErrorStyle parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STDataValidationErrorStyle.type, (XmlOptions) null);
        }

        public static STDataValidationErrorStyle parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STDataValidationErrorStyle.type, xmlOptions);
        }

        public static STDataValidationErrorStyle parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STDataValidationErrorStyle.type, (XmlOptions) null);
        }

        public static STDataValidationErrorStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STDataValidationErrorStyle.type, xmlOptions);
        }

        public static STDataValidationErrorStyle parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STDataValidationErrorStyle.type, (XmlOptions) null);
        }

        public static STDataValidationErrorStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STDataValidationErrorStyle.type, xmlOptions);
        }

        public static STDataValidationErrorStyle parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STDataValidationErrorStyle.type, (XmlOptions) null);
        }

        public static STDataValidationErrorStyle parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STDataValidationErrorStyle.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
