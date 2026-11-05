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
public interface CTFontReference extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTFontReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfontreferencef5adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFontReference newInstance() {
            return (CTFontReference) POIXMLTypeLoader.newInstance(CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference newInstance(XmlOptions xmlOptions) {
            return (CTFontReference) POIXMLTypeLoader.newInstance(CTFontReference.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFontReference.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(File file) throws XmlException, IOException {
            return (CTFontReference) POIXMLTypeLoader.parse(file, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontReference) POIXMLTypeLoader.parse(file, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFontReference) POIXMLTypeLoader.parse(inputStream, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontReference) POIXMLTypeLoader.parse(inputStream, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(Reader reader) throws XmlException, IOException {
            return (CTFontReference) POIXMLTypeLoader.parse(reader, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontReference) POIXMLTypeLoader.parse(reader, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(String str) throws XmlException {
            return (CTFontReference) POIXMLTypeLoader.parse(str, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFontReference) POIXMLTypeLoader.parse(str, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(URL url) throws XmlException, IOException {
            return (CTFontReference) POIXMLTypeLoader.parse(url, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontReference) POIXMLTypeLoader.parse(url, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFontReference) POIXMLTypeLoader.parse(xMLStreamReader, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFontReference) POIXMLTypeLoader.parse(xMLStreamReader, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTFontReference) POIXMLTypeLoader.parse(xMLInputStream, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTFontReference) POIXMLTypeLoader.parse(xMLInputStream, CTFontReference.type, xmlOptions);
        }

        public static CTFontReference parse(Node node) throws XmlException {
            return (CTFontReference) POIXMLTypeLoader.parse(node, CTFontReference.type, (XmlOptions) null);
        }

        public static CTFontReference parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFontReference) POIXMLTypeLoader.parse(node, CTFontReference.type, xmlOptions);
        }
    }

    CTHslColor addNewHslClr();

    CTPresetColor addNewPrstClr();

    CTSchemeColor addNewSchemeClr();

    CTScRgbColor addNewScrgbClr();

    CTSRgbColor addNewSrgbClr();

    CTSystemColor addNewSysClr();

    CTHslColor getHslClr();

    STFontCollectionIndex.Enum getIdx();

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

    void setIdx(STFontCollectionIndex.Enum r1);

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

    STFontCollectionIndex xgetIdx();

    void xsetIdx(STFontCollectionIndex sTFontCollectionIndex);
}
