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
public interface STDocProtect extends XmlString {
    public static final int INT_COMMENTS = 3;
    public static final int INT_FORMS = 5;
    public static final int INT_NONE = 1;
    public static final int INT_READ_ONLY = 2;
    public static final int INT_TRACKED_CHANGES = 4;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STDocProtect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdocprotect5801type");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum READ_ONLY = Enum.forString("readOnly");
    public static final Enum COMMENTS = Enum.forString("comments");
    public static final Enum TRACKED_CHANGES = Enum.forString("trackedChanges");
    public static final Enum FORMS = Enum.forString("forms");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_COMMENTS = 3;
        static final int INT_FORMS = 5;
        static final int INT_NONE = 1;
        static final int INT_READ_ONLY = 2;
        static final int INT_TRACKED_CHANGES = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("readOnly", 2), new Enum("comments", 3), new Enum("trackedChanges", 4), new Enum("forms", 5)});

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

        public static STDocProtect newInstance() {
            return POIXMLTypeLoader.newInstance(STDocProtect.type, (XmlOptions) null);
        }

        public static STDocProtect newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STDocProtect.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDocProtect.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDocProtect.type, xmlOptions);
        }

        public static STDocProtect newValue(Object obj) {
            return STDocProtect.type.newValue(obj);
        }

        public static STDocProtect parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STDocProtect.type, (XmlOptions) null);
        }

        public static STDocProtect parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STDocProtect.type, xmlOptions);
        }

        public static STDocProtect parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STDocProtect.type, (XmlOptions) null);
        }

        public static STDocProtect parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STDocProtect.type, xmlOptions);
        }

        public static STDocProtect parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STDocProtect.type, (XmlOptions) null);
        }

        public static STDocProtect parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STDocProtect.type, xmlOptions);
        }

        public static STDocProtect parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STDocProtect.type, (XmlOptions) null);
        }

        public static STDocProtect parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STDocProtect.type, xmlOptions);
        }

        public static STDocProtect parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STDocProtect.type, (XmlOptions) null);
        }

        public static STDocProtect parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STDocProtect.type, xmlOptions);
        }

        public static STDocProtect parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STDocProtect.type, (XmlOptions) null);
        }

        public static STDocProtect parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STDocProtect.type, xmlOptions);
        }

        public static STDocProtect parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STDocProtect.type, (XmlOptions) null);
        }

        public static STDocProtect parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STDocProtect.type, xmlOptions);
        }

        public static STDocProtect parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STDocProtect.type, (XmlOptions) null);
        }

        public static STDocProtect parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STDocProtect.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
