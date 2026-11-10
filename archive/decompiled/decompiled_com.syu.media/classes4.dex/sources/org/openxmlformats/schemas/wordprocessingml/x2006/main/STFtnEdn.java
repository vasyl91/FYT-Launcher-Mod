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
public interface STFtnEdn extends XmlString {
    public static final int INT_CONTINUATION_NOTICE = 4;
    public static final int INT_CONTINUATION_SEPARATOR = 3;
    public static final int INT_NORMAL = 1;
    public static final int INT_SEPARATOR = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STFtnEdn.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stftnednd4c9type");
    public static final Enum NORMAL = Enum.forString("normal");
    public static final Enum SEPARATOR = Enum.forString("separator");
    public static final Enum CONTINUATION_SEPARATOR = Enum.forString("continuationSeparator");
    public static final Enum CONTINUATION_NOTICE = Enum.forString("continuationNotice");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONTINUATION_NOTICE = 4;
        static final int INT_CONTINUATION_SEPARATOR = 3;
        static final int INT_NORMAL = 1;
        static final int INT_SEPARATOR = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("normal", 1), new Enum("separator", 2), new Enum("continuationSeparator", 3), new Enum("continuationNotice", 4)});

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

        public static STFtnEdn newInstance() {
            return POIXMLTypeLoader.newInstance(STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STFtnEdn.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFtnEdn.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn newValue(Object obj) {
            return STFtnEdn.type.newValue(obj);
        }

        public static STFtnEdn parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STFtnEdn.type, xmlOptions);
        }

        public static STFtnEdn parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFtnEdn.type, (XmlOptions) null);
        }

        public static STFtnEdn parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STFtnEdn.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
