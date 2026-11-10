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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface ThemeDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(ThemeDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("themefd26doctype");

    public static final class Factory {
        private Factory() {
        }

        public static ThemeDocument newInstance() {
            return (ThemeDocument) POIXMLTypeLoader.newInstance(ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument newInstance(XmlOptions xmlOptions) {
            return (ThemeDocument) POIXMLTypeLoader.newInstance(ThemeDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ThemeDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(File file) throws XmlException, IOException {
            return (ThemeDocument) POIXMLTypeLoader.parse(file, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ThemeDocument) POIXMLTypeLoader.parse(file, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (ThemeDocument) POIXMLTypeLoader.parse(inputStream, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ThemeDocument) POIXMLTypeLoader.parse(inputStream, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(Reader reader) throws XmlException, IOException {
            return (ThemeDocument) POIXMLTypeLoader.parse(reader, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ThemeDocument) POIXMLTypeLoader.parse(reader, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(String str) throws XmlException {
            return (ThemeDocument) POIXMLTypeLoader.parse(str, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (ThemeDocument) POIXMLTypeLoader.parse(str, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(URL url) throws XmlException, IOException {
            return (ThemeDocument) POIXMLTypeLoader.parse(url, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (ThemeDocument) POIXMLTypeLoader.parse(url, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (ThemeDocument) POIXMLTypeLoader.parse(xMLStreamReader, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (ThemeDocument) POIXMLTypeLoader.parse(xMLStreamReader, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (ThemeDocument) POIXMLTypeLoader.parse(xMLInputStream, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (ThemeDocument) POIXMLTypeLoader.parse(xMLInputStream, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(Node node) throws XmlException {
            return (ThemeDocument) POIXMLTypeLoader.parse(node, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (ThemeDocument) POIXMLTypeLoader.parse(node, ThemeDocument.type, xmlOptions);
        }
    }

    CTOfficeStyleSheet addNewTheme();

    CTOfficeStyleSheet getTheme();

    void setTheme(CTOfficeStyleSheet cTOfficeStyleSheet);
}
