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
public interface STMerge extends XmlString {
    public static final int INT_CONTINUE = 1;
    public static final int INT_RESTART = 2;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STMerge.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stmerge50aatype");
    public static final Enum CONTINUE = Enum.forString("continue");
    public static final Enum RESTART = Enum.forString("restart");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONTINUE = 1;
        static final int INT_RESTART = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("continue", 1), new Enum("restart", 2)});

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

        public static STMerge newInstance() {
            return POIXMLTypeLoader.newInstance(STMerge.type, (XmlOptions) null);
        }

        public static STMerge newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STMerge.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STMerge.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STMerge.type, xmlOptions);
        }

        public static STMerge newValue(Object obj) {
            return STMerge.type.newValue(obj);
        }

        public static STMerge parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STMerge.type, xmlOptions);
        }

        public static STMerge parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STMerge.type, xmlOptions);
        }

        public static STMerge parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STMerge.type, xmlOptions);
        }

        public static STMerge parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STMerge.type, xmlOptions);
        }

        public static STMerge parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STMerge.type, xmlOptions);
        }

        public static STMerge parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STMerge.type, xmlOptions);
        }

        public static STMerge parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STMerge.type, xmlOptions);
        }

        public static STMerge parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STMerge.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
