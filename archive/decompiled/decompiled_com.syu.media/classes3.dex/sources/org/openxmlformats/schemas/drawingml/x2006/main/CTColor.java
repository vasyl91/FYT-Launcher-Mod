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
public interface CTColor extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTColor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcolorb114type");

    public static final class Factory {
        private Factory() {
        }

        public static CTColor newInstance() {
            return (CTColor) POIXMLTypeLoader.newInstance(CTColor.type, (XmlOptions) null);
        }

        public static CTColor newInstance(XmlOptions xmlOptions) {
            return (CTColor) POIXMLTypeLoader.newInstance(CTColor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTColor.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTColor.type, xmlOptions);
        }

        public static CTColor parse(File file) throws XmlException, IOException {
            return (CTColor) POIXMLTypeLoader.parse(file, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColor) POIXMLTypeLoader.parse(file, CTColor.type, xmlOptions);
        }

        public static CTColor parse(InputStream inputStream) throws XmlException, IOException {
            return (CTColor) POIXMLTypeLoader.parse(inputStream, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColor) POIXMLTypeLoader.parse(inputStream, CTColor.type, xmlOptions);
        }

        public static CTColor parse(Reader reader) throws XmlException, IOException {
            return (CTColor) POIXMLTypeLoader.parse(reader, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColor) POIXMLTypeLoader.parse(reader, CTColor.type, xmlOptions);
        }

        public static CTColor parse(String str) throws XmlException {
            return (CTColor) POIXMLTypeLoader.parse(str, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTColor) POIXMLTypeLoader.parse(str, CTColor.type, xmlOptions);
        }

        public static CTColor parse(URL url) throws XmlException, IOException {
            return (CTColor) POIXMLTypeLoader.parse(url, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColor) POIXMLTypeLoader.parse(url, CTColor.type, xmlOptions);
        }

        public static CTColor parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTColor) POIXMLTypeLoader.parse(xMLStreamReader, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTColor) POIXMLTypeLoader.parse(xMLStreamReader, CTColor.type, xmlOptions);
        }

        public static CTColor parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTColor) POIXMLTypeLoader.parse(xMLInputStream, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTColor) POIXMLTypeLoader.parse(xMLInputStream, CTColor.type, xmlOptions);
        }

        public static CTColor parse(Node node) throws XmlException {
            return (CTColor) POIXMLTypeLoader.parse(node, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTColor) POIXMLTypeLoader.parse(node, CTColor.type, xmlOptions);
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
