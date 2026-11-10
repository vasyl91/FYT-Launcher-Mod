package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTRgbColor extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTRgbColor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrgbcolor95dftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTRgbColor newInstance() {
            return (CTRgbColor) POIXMLTypeLoader.newInstance(CTRgbColor.type, (XmlOptions) null);
        }

        public static CTRgbColor newInstance(XmlOptions xmlOptions) {
            return (CTRgbColor) POIXMLTypeLoader.newInstance(CTRgbColor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRgbColor.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRgbColor.type, xmlOptions);
        }

        public static CTRgbColor parse(File file) throws XmlException, IOException {
            return (CTRgbColor) POIXMLTypeLoader.parse(file, CTRgbColor.type, (XmlOptions) null);
        }

        public static CTRgbColor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRgbColor) POIXMLTypeLoader.parse(file, CTRgbColor.type, xmlOptions);
        }

        public static CTRgbColor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTRgbColor) POIXMLTypeLoader.parse(inputStream, CTRgbColor.type, (XmlOptions) null);
        }

        public static CTRgbColor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRgbColor) POIXMLTypeLoader.parse(inputStream, CTRgbColor.type, xmlOptions);
        }

        public static CTRgbColor parse(Reader reader) throws XmlException, IOException {
            return (CTRgbColor) POIXMLTypeLoader.parse(reader, CTRgbColor.type, (XmlOptions) null);
        }

        public static CTRgbColor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRgbColor) POIXMLTypeLoader.parse(reader, CTRgbColor.type, xmlOptions);
        }

        public static CTRgbColor parse(String str) throws XmlException {
            return (CTRgbColor) POIXMLTypeLoader.parse(str, CTRgbColor.type, (XmlOptions) null);
        }

        public static CTRgbColor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTRgbColor) POIXMLTypeLoader.parse(str, CTRgbColor.type, xmlOptions);
        }

        public static CTRgbColor parse(URL url) throws XmlException, IOException {
            return (CTRgbColor) POIXMLTypeLoader.parse(url, CTRgbColor.type, (XmlOptions) null);
        }

        public static CTRgbColor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTRgbColor) POIXMLTypeLoader.parse(url, CTRgbColor.type, xmlOptions);
        }

        public static CTRgbColor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTRgbColor) POIXMLTypeLoader.parse(xMLStreamReader, CTRgbColor.type, (XmlOptions) null);
        }

        public static CTRgbColor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTRgbColor) POIXMLTypeLoader.parse(xMLStreamReader, CTRgbColor.type, xmlOptions);
        }

        public static CTRgbColor parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTRgbColor) POIXMLTypeLoader.parse(xMLInputStream, CTRgbColor.type, (XmlOptions) null);
        }

        public static CTRgbColor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTRgbColor) POIXMLTypeLoader.parse(xMLInputStream, CTRgbColor.type, xmlOptions);
        }

        public static CTRgbColor parse(Node node) throws XmlException {
            return (CTRgbColor) POIXMLTypeLoader.parse(node, CTRgbColor.type, (XmlOptions) null);
        }

        public static CTRgbColor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTRgbColor) POIXMLTypeLoader.parse(node, CTRgbColor.type, xmlOptions);
        }
    }

    byte[] getRgb();

    boolean isSetRgb();

    void setRgb(byte[] bArr);

    void unsetRgb();

    STUnsignedIntHex xgetRgb();

    void xsetRgb(STUnsignedIntHex sTUnsignedIntHex);
}
