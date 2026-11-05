package com.microsoft.schemas.office.visio.x2012.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface VisioDocumentType extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(VisioDocumentType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("visiodocumenttypebfcatype");

    public static final class Factory {
        private Factory() {
        }

        public static VisioDocumentType newInstance() {
            return (VisioDocumentType) POIXMLTypeLoader.newInstance(VisioDocumentType.type, (XmlOptions) null);
        }

        public static VisioDocumentType newInstance(XmlOptions xmlOptions) {
            return (VisioDocumentType) POIXMLTypeLoader.newInstance(VisioDocumentType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, VisioDocumentType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, VisioDocumentType.type, xmlOptions);
        }

        public static VisioDocumentType parse(File file) throws XmlException, IOException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(file, VisioDocumentType.type, (XmlOptions) null);
        }

        public static VisioDocumentType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(file, VisioDocumentType.type, xmlOptions);
        }

        public static VisioDocumentType parse(InputStream inputStream) throws XmlException, IOException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(inputStream, VisioDocumentType.type, (XmlOptions) null);
        }

        public static VisioDocumentType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(inputStream, VisioDocumentType.type, xmlOptions);
        }

        public static VisioDocumentType parse(Reader reader) throws XmlException, IOException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(reader, VisioDocumentType.type, (XmlOptions) null);
        }

        public static VisioDocumentType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(reader, VisioDocumentType.type, xmlOptions);
        }

        public static VisioDocumentType parse(String str) throws XmlException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(str, VisioDocumentType.type, (XmlOptions) null);
        }

        public static VisioDocumentType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(str, VisioDocumentType.type, xmlOptions);
        }

        public static VisioDocumentType parse(URL url) throws XmlException, IOException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(url, VisioDocumentType.type, (XmlOptions) null);
        }

        public static VisioDocumentType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(url, VisioDocumentType.type, xmlOptions);
        }

        public static VisioDocumentType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(xMLStreamReader, VisioDocumentType.type, (XmlOptions) null);
        }

        public static VisioDocumentType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(xMLStreamReader, VisioDocumentType.type, xmlOptions);
        }

        public static VisioDocumentType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(xMLInputStream, VisioDocumentType.type, (XmlOptions) null);
        }

        public static VisioDocumentType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(xMLInputStream, VisioDocumentType.type, xmlOptions);
        }

        public static VisioDocumentType parse(Node node) throws XmlException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(node, VisioDocumentType.type, (XmlOptions) null);
        }

        public static VisioDocumentType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (VisioDocumentType) POIXMLTypeLoader.parse(node, VisioDocumentType.type, xmlOptions);
        }
    }

    ColorsType addNewColors();

    DocumentSettingsType addNewDocumentSettings();

    DocumentSheetType addNewDocumentSheet();

    EventListType addNewEventList();

    FaceNamesType addNewFaceNames();

    HeaderFooterType addNewHeaderFooter();

    PublishSettingsType addNewPublishSettings();

    StyleSheetsType addNewStyleSheets();

    ColorsType getColors();

    DocumentSettingsType getDocumentSettings();

    DocumentSheetType getDocumentSheet();

    EventListType getEventList();

    FaceNamesType getFaceNames();

    HeaderFooterType getHeaderFooter();

    PublishSettingsType getPublishSettings();

    StyleSheetsType getStyleSheets();

    boolean isSetColors();

    boolean isSetDocumentSettings();

    boolean isSetDocumentSheet();

    boolean isSetEventList();

    boolean isSetFaceNames();

    boolean isSetHeaderFooter();

    boolean isSetPublishSettings();

    boolean isSetStyleSheets();

    void setColors(ColorsType colorsType);

    void setDocumentSettings(DocumentSettingsType documentSettingsType);

    void setDocumentSheet(DocumentSheetType documentSheetType);

    void setEventList(EventListType eventListType);

    void setFaceNames(FaceNamesType faceNamesType);

    void setHeaderFooter(HeaderFooterType headerFooterType);

    void setPublishSettings(PublishSettingsType publishSettingsType);

    void setStyleSheets(StyleSheetsType styleSheetsType);

    void unsetColors();

    void unsetDocumentSettings();

    void unsetDocumentSheet();

    void unsetEventList();

    void unsetFaceNames();

    void unsetHeaderFooter();

    void unsetPublishSettings();

    void unsetStyleSheets();
}
