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
public interface CTPatternFillProperties extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPatternFillProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpatternfillproperties3637type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPatternFillProperties newInstance() {
            return (CTPatternFillProperties) POIXMLTypeLoader.newInstance(CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTPatternFillProperties) POIXMLTypeLoader.newInstance(CTPatternFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(File file) throws XmlException, IOException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(file, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(file, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(inputStream, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(inputStream, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(Reader reader) throws XmlException, IOException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(reader, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(reader, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(String str) throws XmlException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(str, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(str, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(URL url) throws XmlException, IOException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(url, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(url, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(Node node) throws XmlException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(node, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(node, CTPatternFillProperties.type, xmlOptions);
        }
    }

    CTColor addNewBgClr();

    CTColor addNewFgClr();

    CTColor getBgClr();

    CTColor getFgClr();

    STPresetPatternVal.Enum getPrst();

    boolean isSetBgClr();

    boolean isSetFgClr();

    boolean isSetPrst();

    void setBgClr(CTColor cTColor);

    void setFgClr(CTColor cTColor);

    void setPrst(STPresetPatternVal.Enum r1);

    void unsetBgClr();

    void unsetFgClr();

    void unsetPrst();

    STPresetPatternVal xgetPrst();

    void xsetPrst(STPresetPatternVal sTPresetPatternVal);
}
