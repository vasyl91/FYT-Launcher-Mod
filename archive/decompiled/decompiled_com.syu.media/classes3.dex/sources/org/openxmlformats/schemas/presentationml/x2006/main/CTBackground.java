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
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode$Enum;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTBackground extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTBackground.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbackground36f7type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBackground newInstance() {
            return (CTBackground) POIXMLTypeLoader.newInstance(CTBackground.type, (XmlOptions) null);
        }

        public static CTBackground newInstance(XmlOptions xmlOptions) {
            return (CTBackground) POIXMLTypeLoader.newInstance(CTBackground.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBackground.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBackground.type, xmlOptions);
        }

        public static CTBackground parse(File file) throws XmlException, IOException {
            return (CTBackground) POIXMLTypeLoader.parse(file, CTBackground.type, (XmlOptions) null);
        }

        public static CTBackground parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBackground) POIXMLTypeLoader.parse(file, CTBackground.type, xmlOptions);
        }

        public static CTBackground parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBackground) POIXMLTypeLoader.parse(inputStream, CTBackground.type, (XmlOptions) null);
        }

        public static CTBackground parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBackground) POIXMLTypeLoader.parse(inputStream, CTBackground.type, xmlOptions);
        }

        public static CTBackground parse(Reader reader) throws XmlException, IOException {
            return (CTBackground) POIXMLTypeLoader.parse(reader, CTBackground.type, (XmlOptions) null);
        }

        public static CTBackground parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBackground) POIXMLTypeLoader.parse(reader, CTBackground.type, xmlOptions);
        }

        public static CTBackground parse(String str) throws XmlException {
            return (CTBackground) POIXMLTypeLoader.parse(str, CTBackground.type, (XmlOptions) null);
        }

        public static CTBackground parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBackground) POIXMLTypeLoader.parse(str, CTBackground.type, xmlOptions);
        }

        public static CTBackground parse(URL url) throws XmlException, IOException {
            return (CTBackground) POIXMLTypeLoader.parse(url, CTBackground.type, (XmlOptions) null);
        }

        public static CTBackground parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBackground) POIXMLTypeLoader.parse(url, CTBackground.type, xmlOptions);
        }

        public static CTBackground parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBackground) POIXMLTypeLoader.parse(xMLStreamReader, CTBackground.type, (XmlOptions) null);
        }

        public static CTBackground parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBackground) POIXMLTypeLoader.parse(xMLStreamReader, CTBackground.type, xmlOptions);
        }

        public static CTBackground parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTBackground) POIXMLTypeLoader.parse(xMLInputStream, CTBackground.type, (XmlOptions) null);
        }

        public static CTBackground parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTBackground) POIXMLTypeLoader.parse(xMLInputStream, CTBackground.type, xmlOptions);
        }

        public static CTBackground parse(Node node) throws XmlException {
            return (CTBackground) POIXMLTypeLoader.parse(node, CTBackground.type, (XmlOptions) null);
        }

        public static CTBackground parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBackground) POIXMLTypeLoader.parse(node, CTBackground.type, xmlOptions);
        }
    }

    CTBackgroundProperties addNewBgPr();

    CTStyleMatrixReference addNewBgRef();

    CTBackgroundProperties getBgPr();

    CTStyleMatrixReference getBgRef();

    STBlackWhiteMode$Enum getBwMode();

    boolean isSetBgPr();

    boolean isSetBgRef();

    boolean isSetBwMode();

    void setBgPr(CTBackgroundProperties cTBackgroundProperties);

    void setBgRef(CTStyleMatrixReference cTStyleMatrixReference);

    void setBwMode(STBlackWhiteMode$Enum sTBlackWhiteMode$Enum);

    void unsetBgPr();

    void unsetBgRef();

    void unsetBwMode();

    STBlackWhiteMode xgetBwMode();

    void xsetBwMode(STBlackWhiteMode sTBlackWhiteMode);
}
