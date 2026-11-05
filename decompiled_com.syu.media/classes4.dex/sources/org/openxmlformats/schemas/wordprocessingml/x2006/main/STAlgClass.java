package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface STAlgClass extends XmlString {
    public static final int INT_HASH = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STAlgClass.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stalgclass061ctype");
    public static final Enum HASH = Enum.forString("hash");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_HASH = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("hash", 1)});

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

        public static STAlgClass newInstance() {
            return POIXMLTypeLoader.newInstance(STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STAlgClass.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAlgClass.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass newValue(Object obj) {
            return STAlgClass.type.newValue(obj);
        }

        public static STAlgClass parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STAlgClass.type, xmlOptions);
        }

        public static STAlgClass parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STAlgClass.type, (XmlOptions) null);
        }

        public static STAlgClass parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STAlgClass.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
