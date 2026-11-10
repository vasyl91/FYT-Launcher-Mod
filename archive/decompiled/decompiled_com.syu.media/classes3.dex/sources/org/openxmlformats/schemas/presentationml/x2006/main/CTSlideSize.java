package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface CTSlideSize extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSlideSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslidesizeb0fdtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideSize newInstance() {
            return (CTSlideSize) POIXMLTypeLoader.newInstance(CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize newInstance(XmlOptions xmlOptions) {
            return (CTSlideSize) POIXMLTypeLoader.newInstance(CTSlideSize.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideSize.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(File file) throws XmlException, IOException {
            return (CTSlideSize) POIXMLTypeLoader.parse(file, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideSize) POIXMLTypeLoader.parse(file, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSlideSize) POIXMLTypeLoader.parse(inputStream, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideSize) POIXMLTypeLoader.parse(inputStream, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(Reader reader) throws XmlException, IOException {
            return (CTSlideSize) POIXMLTypeLoader.parse(reader, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideSize) POIXMLTypeLoader.parse(reader, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(String str) throws XmlException {
            return (CTSlideSize) POIXMLTypeLoader.parse(str, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideSize) POIXMLTypeLoader.parse(str, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(URL url) throws XmlException, IOException {
            return (CTSlideSize) POIXMLTypeLoader.parse(url, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSlideSize) POIXMLTypeLoader.parse(url, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSlideSize) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideSize) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSlideSize) POIXMLTypeLoader.parse(xMLInputStream, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSlideSize) POIXMLTypeLoader.parse(xMLInputStream, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(Node node) throws XmlException {
            return (CTSlideSize) POIXMLTypeLoader.parse(node, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSlideSize) POIXMLTypeLoader.parse(node, CTSlideSize.type, xmlOptions);
        }
    }

    int getCx();

    int getCy();

    STSlideSizeType$Enum getType();

    boolean isSetType();

    void setCx(int i);

    void setCy(int i);

    void setType(STSlideSizeType$Enum sTSlideSizeType$Enum);

    void unsetType();

    STSlideSizeCoordinate xgetCx();

    STSlideSizeCoordinate xgetCy();

    STSlideSizeType xgetType();

    void xsetCx(STSlideSizeCoordinate sTSlideSizeCoordinate);

    void xsetCy(STSlideSizeCoordinate sTSlideSizeCoordinate);

    void xsetType(STSlideSizeType sTSlideSizeType);
}
