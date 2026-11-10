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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTFonts extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTFonts.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfonts6623type");

    public static final class Factory {
        private Factory() {
        }

        public static CTFonts newInstance() {
            return (CTFonts) POIXMLTypeLoader.newInstance(CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts newInstance(XmlOptions xmlOptions) {
            return (CTFonts) POIXMLTypeLoader.newInstance(CTFonts.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFonts.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(File file) throws XmlException, IOException {
            return (CTFonts) POIXMLTypeLoader.parse(file, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFonts) POIXMLTypeLoader.parse(file, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFonts) POIXMLTypeLoader.parse(inputStream, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFonts) POIXMLTypeLoader.parse(inputStream, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(Reader reader) throws XmlException, IOException {
            return (CTFonts) POIXMLTypeLoader.parse(reader, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFonts) POIXMLTypeLoader.parse(reader, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(String str) throws XmlException {
            return (CTFonts) POIXMLTypeLoader.parse(str, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFonts) POIXMLTypeLoader.parse(str, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(URL url) throws XmlException, IOException {
            return (CTFonts) POIXMLTypeLoader.parse(url, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFonts) POIXMLTypeLoader.parse(url, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFonts) POIXMLTypeLoader.parse(xMLStreamReader, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFonts) POIXMLTypeLoader.parse(xMLStreamReader, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTFonts) POIXMLTypeLoader.parse(xMLInputStream, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTFonts) POIXMLTypeLoader.parse(xMLInputStream, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(Node node) throws XmlException {
            return (CTFonts) POIXMLTypeLoader.parse(node, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFonts) POIXMLTypeLoader.parse(node, CTFonts.type, xmlOptions);
        }
    }

    CTFont addNewFont();

    long getCount();

    CTFont getFontArray(int i);

    CTFont[] getFontArray();

    List<CTFont> getFontList();

    CTFont insertNewFont(int i);

    boolean isSetCount();

    void removeFont(int i);

    void setCount(long j);

    void setFontArray(int i, CTFont cTFont);

    void setFontArray(CTFont[] cTFontArr);

    int sizeOfFontArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
