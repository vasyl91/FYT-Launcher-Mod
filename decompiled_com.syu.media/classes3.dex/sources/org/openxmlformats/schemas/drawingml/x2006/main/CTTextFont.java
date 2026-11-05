package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTextFont extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTextFont.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextfont92b7type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextFont newInstance() {
            return (CTTextFont) POIXMLTypeLoader.newInstance(CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont newInstance(XmlOptions xmlOptions) {
            return (CTTextFont) POIXMLTypeLoader.newInstance(CTTextFont.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextFont.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(File file) throws XmlException, IOException {
            return (CTTextFont) POIXMLTypeLoader.parse(file, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextFont) POIXMLTypeLoader.parse(file, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTextFont) POIXMLTypeLoader.parse(inputStream, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextFont) POIXMLTypeLoader.parse(inputStream, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(Reader reader) throws XmlException, IOException {
            return (CTTextFont) POIXMLTypeLoader.parse(reader, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextFont) POIXMLTypeLoader.parse(reader, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(String str) throws XmlException {
            return (CTTextFont) POIXMLTypeLoader.parse(str, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTextFont) POIXMLTypeLoader.parse(str, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(URL url) throws XmlException, IOException {
            return (CTTextFont) POIXMLTypeLoader.parse(url, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTextFont) POIXMLTypeLoader.parse(url, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTextFont) POIXMLTypeLoader.parse(xMLStreamReader, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTextFont) POIXMLTypeLoader.parse(xMLStreamReader, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTextFont) POIXMLTypeLoader.parse(xMLInputStream, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTextFont) POIXMLTypeLoader.parse(xMLInputStream, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(Node node) throws XmlException {
            return (CTTextFont) POIXMLTypeLoader.parse(node, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTextFont) POIXMLTypeLoader.parse(node, CTTextFont.type, xmlOptions);
        }
    }

    byte getCharset();

    byte[] getPanose();

    byte getPitchFamily();

    String getTypeface();

    boolean isSetCharset();

    boolean isSetPanose();

    boolean isSetPitchFamily();

    boolean isSetTypeface();

    void setCharset(byte b);

    void setPanose(byte[] bArr);

    void setPitchFamily(byte b);

    void setTypeface(String str);

    void unsetCharset();

    void unsetPanose();

    void unsetPitchFamily();

    void unsetTypeface();

    XmlByte xgetCharset();

    STPanose xgetPanose();

    XmlByte xgetPitchFamily();

    STTextTypeface xgetTypeface();

    void xsetCharset(XmlByte xmlByte);

    void xsetPanose(STPanose sTPanose);

    void xsetPitchFamily(XmlByte xmlByte);

    void xsetTypeface(STTextTypeface sTTextTypeface);
}
