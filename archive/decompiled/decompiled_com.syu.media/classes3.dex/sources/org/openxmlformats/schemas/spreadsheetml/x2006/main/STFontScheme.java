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
public interface STFontScheme extends XmlString {
    public static final int INT_MAJOR = 2;
    public static final int INT_MINOR = 3;
    public static final int INT_NONE = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STFontScheme.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stfontschemef36dtype");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum MAJOR = Enum.forString("major");
    public static final Enum MINOR = Enum.forString("minor");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_MAJOR = 2;
        static final int INT_MINOR = 3;
        static final int INT_NONE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("major", 2), new Enum("minor", 3)});

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

        public static STFontScheme newInstance() {
            return POIXMLTypeLoader.newInstance(STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STFontScheme.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFontScheme.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme newValue(Object obj) {
            return STFontScheme.type.newValue(obj);
        }

        public static STFontScheme parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFontScheme.type, xmlOptions);
        }

        public static STFontScheme parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFontScheme.type, (XmlOptions) null);
        }

        public static STFontScheme parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFontScheme.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
