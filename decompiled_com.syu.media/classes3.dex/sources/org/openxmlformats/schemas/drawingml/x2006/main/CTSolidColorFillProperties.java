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
public interface CTSolidColorFillProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSolidColorFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsolidcolorfillproperties9cc9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSolidColorFillProperties newInstance() {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.newInstance(CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.newInstance(CTSolidColorFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(File file) throws XmlException, IOException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(file, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(file, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(inputStream, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(inputStream, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(Reader reader) throws XmlException, IOException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(reader, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(reader, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(String str) throws XmlException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(str, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(str, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(URL url) throws XmlException, IOException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(url, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(url, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(Node node) throws XmlException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(node, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(node, CTSolidColorFillProperties.type, xmlOptions);
        }
    }

    CTHslColor addNewHslClr();

    CTPresetColor addNewPrstClr();

    CTSchemeColor addNewSchemeClr();

    CTScRgbColor addNewScrgbClr();

    CTSRgbColor addNewSrgbClr();

    CTSystemColor addNewSysClr();

    CTHslColor getHslClr();

    CTPresetColor getPrstClr();

    CTSchemeColor getSchemeClr();

    CTScRgbColor getScrgbClr();

    CTSRgbColor getSrgbClr();

    CTSystemColor getSysClr();

    boolean isSetHslClr();

    boolean isSetPrstClr();

    boolean isSetSchemeClr();

    boolean isSetScrgbClr();

    boolean isSetSrgbClr();

    boolean isSetSysClr();

    void setHslClr(CTHslColor cTHslColor);

    void setPrstClr(CTPresetColor cTPresetColor);

    void setSchemeClr(CTSchemeColor cTSchemeColor);

    void setScrgbClr(CTScRgbColor cTScRgbColor);

    void setSrgbClr(CTSRgbColor cTSRgbColor);

    void setSysClr(CTSystemColor cTSystemColor);

    void unsetHslClr();

    void unsetPrstClr();

    void unsetSchemeClr();

    void unsetScrgbClr();

    void unsetSrgbClr();

    void unsetSysClr();
}
