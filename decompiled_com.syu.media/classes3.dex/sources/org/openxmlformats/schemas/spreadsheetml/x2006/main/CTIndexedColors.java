package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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
public interface CTIndexedColors extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTIndexedColors.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctindexedcolorsa0a0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTIndexedColors newInstance() {
            return (CTIndexedColors) POIXMLTypeLoader.newInstance(CTIndexedColors.type, (XmlOptions) null);
        }

        public static CTIndexedColors newInstance(XmlOptions xmlOptions) {
            return (CTIndexedColors) POIXMLTypeLoader.newInstance(CTIndexedColors.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTIndexedColors.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTIndexedColors.type, xmlOptions);
        }

        public static CTIndexedColors parse(File file) throws XmlException, IOException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(file, CTIndexedColors.type, (XmlOptions) null);
        }

        public static CTIndexedColors parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(file, CTIndexedColors.type, xmlOptions);
        }

        public static CTIndexedColors parse(InputStream inputStream) throws XmlException, IOException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(inputStream, CTIndexedColors.type, (XmlOptions) null);
        }

        public static CTIndexedColors parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(inputStream, CTIndexedColors.type, xmlOptions);
        }

        public static CTIndexedColors parse(Reader reader) throws XmlException, IOException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(reader, CTIndexedColors.type, (XmlOptions) null);
        }

        public static CTIndexedColors parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(reader, CTIndexedColors.type, xmlOptions);
        }

        public static CTIndexedColors parse(String str) throws XmlException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(str, CTIndexedColors.type, (XmlOptions) null);
        }

        public static CTIndexedColors parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(str, CTIndexedColors.type, xmlOptions);
        }

        public static CTIndexedColors parse(URL url) throws XmlException, IOException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(url, CTIndexedColors.type, (XmlOptions) null);
        }

        public static CTIndexedColors parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(url, CTIndexedColors.type, xmlOptions);
        }

        public static CTIndexedColors parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(xMLStreamReader, CTIndexedColors.type, (XmlOptions) null);
        }

        public static CTIndexedColors parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(xMLStreamReader, CTIndexedColors.type, xmlOptions);
        }

        public static CTIndexedColors parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(xMLInputStream, CTIndexedColors.type, (XmlOptions) null);
        }

        public static CTIndexedColors parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(xMLInputStream, CTIndexedColors.type, xmlOptions);
        }

        public static CTIndexedColors parse(Node node) throws XmlException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(node, CTIndexedColors.type, (XmlOptions) null);
        }

        public static CTIndexedColors parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTIndexedColors) POIXMLTypeLoader.parse(node, CTIndexedColors.type, xmlOptions);
        }
    }

    CTRgbColor addNewRgbColor();

    CTRgbColor getRgbColorArray(int i);

    CTRgbColor[] getRgbColorArray();

    List<CTRgbColor> getRgbColorList();

    CTRgbColor insertNewRgbColor(int i);

    void removeRgbColor(int i);

    void setRgbColorArray(int i, CTRgbColor cTRgbColor);

    void setRgbColorArray(CTRgbColor[] cTRgbColorArr);

    int sizeOfRgbColorArray();
}
