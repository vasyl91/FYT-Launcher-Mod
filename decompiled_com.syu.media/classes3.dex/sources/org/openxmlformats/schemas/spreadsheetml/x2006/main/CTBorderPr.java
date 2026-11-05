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
public interface CTBorderPr extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTBorderPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctborderpre497type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBorderPr newInstance() {
            return (CTBorderPr) POIXMLTypeLoader.newInstance(CTBorderPr.type, (XmlOptions) null);
        }

        public static CTBorderPr newInstance(XmlOptions xmlOptions) {
            return (CTBorderPr) POIXMLTypeLoader.newInstance(CTBorderPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBorderPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBorderPr.type, xmlOptions);
        }

        public static CTBorderPr parse(File file) throws XmlException, IOException {
            return (CTBorderPr) POIXMLTypeLoader.parse(file, CTBorderPr.type, (XmlOptions) null);
        }

        public static CTBorderPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorderPr) POIXMLTypeLoader.parse(file, CTBorderPr.type, xmlOptions);
        }

        public static CTBorderPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBorderPr) POIXMLTypeLoader.parse(inputStream, CTBorderPr.type, (XmlOptions) null);
        }

        public static CTBorderPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorderPr) POIXMLTypeLoader.parse(inputStream, CTBorderPr.type, xmlOptions);
        }

        public static CTBorderPr parse(Reader reader) throws XmlException, IOException {
            return (CTBorderPr) POIXMLTypeLoader.parse(reader, CTBorderPr.type, (XmlOptions) null);
        }

        public static CTBorderPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorderPr) POIXMLTypeLoader.parse(reader, CTBorderPr.type, xmlOptions);
        }

        public static CTBorderPr parse(String str) throws XmlException {
            return (CTBorderPr) POIXMLTypeLoader.parse(str, CTBorderPr.type, (XmlOptions) null);
        }

        public static CTBorderPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBorderPr) POIXMLTypeLoader.parse(str, CTBorderPr.type, xmlOptions);
        }

        public static CTBorderPr parse(URL url) throws XmlException, IOException {
            return (CTBorderPr) POIXMLTypeLoader.parse(url, CTBorderPr.type, (XmlOptions) null);
        }

        public static CTBorderPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBorderPr) POIXMLTypeLoader.parse(url, CTBorderPr.type, xmlOptions);
        }

        public static CTBorderPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBorderPr) POIXMLTypeLoader.parse(xMLStreamReader, CTBorderPr.type, (XmlOptions) null);
        }

        public static CTBorderPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBorderPr) POIXMLTypeLoader.parse(xMLStreamReader, CTBorderPr.type, xmlOptions);
        }

        public static CTBorderPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTBorderPr) POIXMLTypeLoader.parse(xMLInputStream, CTBorderPr.type, (XmlOptions) null);
        }

        public static CTBorderPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTBorderPr) POIXMLTypeLoader.parse(xMLInputStream, CTBorderPr.type, xmlOptions);
        }

        public static CTBorderPr parse(Node node) throws XmlException {
            return (CTBorderPr) POIXMLTypeLoader.parse(node, CTBorderPr.type, (XmlOptions) null);
        }

        public static CTBorderPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBorderPr) POIXMLTypeLoader.parse(node, CTBorderPr.type, xmlOptions);
        }
    }

    CTColor addNewColor();

    CTColor getColor();

    STBorderStyle.Enum getStyle();

    boolean isSetColor();

    boolean isSetStyle();

    void setColor(CTColor cTColor);

    void setStyle(STBorderStyle.Enum r1);

    void unsetColor();

    void unsetStyle();

    STBorderStyle xgetStyle();

    void xsetStyle(STBorderStyle sTBorderStyle);
}
