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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTOfficeStyleSheet extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTOfficeStyleSheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctofficestylesheetce25type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOfficeStyleSheet newInstance() {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.newInstance(CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet newInstance(XmlOptions xmlOptions) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.newInstance(CTOfficeStyleSheet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(File file) throws XmlException, IOException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(file, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(file, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(inputStream, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(inputStream, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(Reader reader) throws XmlException, IOException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(reader, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(reader, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(String str) throws XmlException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(str, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(str, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(URL url) throws XmlException, IOException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(url, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(url, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(xMLStreamReader, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(xMLStreamReader, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(xMLInputStream, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(xMLInputStream, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(Node node) throws XmlException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(node, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(node, CTOfficeStyleSheet.type, xmlOptions);
        }
    }

    CTCustomColorList addNewCustClrLst();

    CTOfficeArtExtensionList addNewExtLst();

    CTColorSchemeList addNewExtraClrSchemeLst();

    CTObjectStyleDefaults addNewObjectDefaults();

    CTBaseStyles addNewThemeElements();

    CTCustomColorList getCustClrLst();

    CTOfficeArtExtensionList getExtLst();

    CTColorSchemeList getExtraClrSchemeLst();

    String getName();

    CTObjectStyleDefaults getObjectDefaults();

    CTBaseStyles getThemeElements();

    boolean isSetCustClrLst();

    boolean isSetExtLst();

    boolean isSetExtraClrSchemeLst();

    boolean isSetName();

    boolean isSetObjectDefaults();

    void setCustClrLst(CTCustomColorList cTCustomColorList);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setExtraClrSchemeLst(CTColorSchemeList cTColorSchemeList);

    void setName(String str);

    void setObjectDefaults(CTObjectStyleDefaults cTObjectStyleDefaults);

    void setThemeElements(CTBaseStyles cTBaseStyles);

    void unsetCustClrLst();

    void unsetExtLst();

    void unsetExtraClrSchemeLst();

    void unsetName();

    void unsetObjectDefaults();

    XmlString xgetName();

    void xsetName(XmlString xmlString);
}
