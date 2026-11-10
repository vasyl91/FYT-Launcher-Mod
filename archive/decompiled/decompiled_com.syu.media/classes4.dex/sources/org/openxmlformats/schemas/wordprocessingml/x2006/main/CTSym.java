package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTSym extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSym.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsym0dabtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSym newInstance() {
            return (CTSym) POIXMLTypeLoader.newInstance(CTSym.type, (XmlOptions) null);
        }

        public static CTSym newInstance(XmlOptions xmlOptions) {
            return (CTSym) POIXMLTypeLoader.newInstance(CTSym.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSym.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSym.type, xmlOptions);
        }

        public static CTSym parse(File file) throws XmlException, IOException {
            return (CTSym) POIXMLTypeLoader.parse(file, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSym) POIXMLTypeLoader.parse(file, CTSym.type, xmlOptions);
        }

        public static CTSym parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSym) POIXMLTypeLoader.parse(inputStream, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSym) POIXMLTypeLoader.parse(inputStream, CTSym.type, xmlOptions);
        }

        public static CTSym parse(Reader reader) throws XmlException, IOException {
            return (CTSym) POIXMLTypeLoader.parse(reader, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSym) POIXMLTypeLoader.parse(reader, CTSym.type, xmlOptions);
        }

        public static CTSym parse(String str) throws XmlException {
            return (CTSym) POIXMLTypeLoader.parse(str, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSym) POIXMLTypeLoader.parse(str, CTSym.type, xmlOptions);
        }

        public static CTSym parse(URL url) throws XmlException, IOException {
            return (CTSym) POIXMLTypeLoader.parse(url, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSym) POIXMLTypeLoader.parse(url, CTSym.type, xmlOptions);
        }

        public static CTSym parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSym) POIXMLTypeLoader.parse(xMLStreamReader, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSym) POIXMLTypeLoader.parse(xMLStreamReader, CTSym.type, xmlOptions);
        }

        public static CTSym parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSym) POIXMLTypeLoader.parse(xMLInputStream, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSym) POIXMLTypeLoader.parse(xMLInputStream, CTSym.type, xmlOptions);
        }

        public static CTSym parse(Node node) throws XmlException {
            return (CTSym) POIXMLTypeLoader.parse(node, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSym) POIXMLTypeLoader.parse(node, CTSym.type, xmlOptions);
        }
    }

    byte[] getChar();

    String getFont();

    boolean isSetChar();

    boolean isSetFont();

    void setChar(byte[] bArr);

    void setFont(String str);

    void unsetChar();

    void unsetFont();

    STShortHexNumber xgetChar();

    STString xgetFont();

    void xsetChar(STShortHexNumber sTShortHexNumber);

    void xsetFont(STString sTString);
}
