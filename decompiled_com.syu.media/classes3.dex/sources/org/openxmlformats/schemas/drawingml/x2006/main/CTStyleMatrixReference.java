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
public interface CTStyleMatrixReference extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTStyleMatrixReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstylematrixreference6ef4type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStyleMatrixReference newInstance() {
            return (CTStyleMatrixReference) POIXMLTypeLoader.newInstance(CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference newInstance(XmlOptions xmlOptions) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.newInstance(CTStyleMatrixReference.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(File file) throws XmlException, IOException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(file, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(file, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(InputStream inputStream) throws XmlException, IOException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(inputStream, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(inputStream, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(Reader reader) throws XmlException, IOException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(reader, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(reader, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(String str) throws XmlException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(str, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(str, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(URL url) throws XmlException, IOException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(url, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(url, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(xMLStreamReader, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(xMLStreamReader, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(xMLInputStream, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(xMLInputStream, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(Node node) throws XmlException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(node, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(node, CTStyleMatrixReference.type, xmlOptions);
        }
    }

    CTHslColor addNewHslClr();

    CTPresetColor addNewPrstClr();

    CTSchemeColor addNewSchemeClr();

    CTScRgbColor addNewScrgbClr();

    CTSRgbColor addNewSrgbClr();

    CTSystemColor addNewSysClr();

    CTHslColor getHslClr();

    long getIdx();

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

    void setIdx(long j);

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

    STStyleMatrixColumnIndex xgetIdx();

    void xsetIdx(STStyleMatrixColumnIndex sTStyleMatrixColumnIndex);
}
