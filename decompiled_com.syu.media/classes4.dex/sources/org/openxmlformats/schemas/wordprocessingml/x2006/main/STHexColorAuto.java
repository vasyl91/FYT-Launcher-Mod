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
public interface STHexColorAuto extends XmlString {
    public static final int INT_AUTO = 1;
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(STHexColorAuto.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sthexcolorauto3ce1type");
    public static final Enum AUTO = Enum.forString("auto");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("auto", 1)});

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

        public static STHexColorAuto newInstance() {
            return POIXMLTypeLoader.newInstance(STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(STHexColorAuto.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHexColorAuto.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto newValue(Object obj) {
            return STHexColorAuto.type.newValue(obj);
        }

        public static STHexColorAuto parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, STHexColorAuto.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
