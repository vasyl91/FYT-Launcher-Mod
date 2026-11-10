package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTStyles extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTStyles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstyles8506type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStyles newInstance() {
            return (CTStyles) POIXMLTypeLoader.newInstance(CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles newInstance(XmlOptions xmlOptions) {
            return (CTStyles) POIXMLTypeLoader.newInstance(CTStyles.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStyles.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(File file) throws XmlException, IOException {
            return (CTStyles) POIXMLTypeLoader.parse(file, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyles) POIXMLTypeLoader.parse(file, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStyles) POIXMLTypeLoader.parse(inputStream, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyles) POIXMLTypeLoader.parse(inputStream, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(Reader reader) throws XmlException, IOException {
            return (CTStyles) POIXMLTypeLoader.parse(reader, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyles) POIXMLTypeLoader.parse(reader, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(String str) throws XmlException {
            return (CTStyles) POIXMLTypeLoader.parse(str, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStyles) POIXMLTypeLoader.parse(str, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(URL url) throws XmlException, IOException {
            return (CTStyles) POIXMLTypeLoader.parse(url, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyles) POIXMLTypeLoader.parse(url, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStyles) POIXMLTypeLoader.parse(xMLStreamReader, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStyles) POIXMLTypeLoader.parse(xMLStreamReader, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTStyles) POIXMLTypeLoader.parse(xMLInputStream, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTStyles) POIXMLTypeLoader.parse(xMLInputStream, CTStyles.type, xmlOptions);
        }

        public static CTStyles parse(Node node) throws XmlException {
            return (CTStyles) POIXMLTypeLoader.parse(node, CTStyles.type, (XmlOptions) null);
        }

        public static CTStyles parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStyles) POIXMLTypeLoader.parse(node, CTStyles.type, xmlOptions);
        }
    }

    CTDocDefaults addNewDocDefaults();

    CTLatentStyles addNewLatentStyles();

    CTStyle addNewStyle();

    CTDocDefaults getDocDefaults();

    CTLatentStyles getLatentStyles();

    CTStyle getStyleArray(int i);

    CTStyle[] getStyleArray();

    List<CTStyle> getStyleList();

    CTStyle insertNewStyle(int i);

    boolean isSetDocDefaults();

    boolean isSetLatentStyles();

    void removeStyle(int i);

    void setDocDefaults(CTDocDefaults cTDocDefaults);

    void setLatentStyles(CTLatentStyles cTLatentStyles);

    void setStyleArray(int i, CTStyle cTStyle);

    void setStyleArray(CTStyle[] cTStyleArr);

    int sizeOfStyleArray();

    void unsetDocDefaults();

    void unsetLatentStyles();
}
