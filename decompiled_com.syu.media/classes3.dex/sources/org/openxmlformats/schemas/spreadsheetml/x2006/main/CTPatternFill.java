package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface CTPatternFill extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPatternFill.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpatternfill7452type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPatternFill newInstance() {
            return (CTPatternFill) POIXMLTypeLoader.newInstance(CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill newInstance(XmlOptions xmlOptions) {
            return (CTPatternFill) POIXMLTypeLoader.newInstance(CTPatternFill.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPatternFill.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(File file) throws XmlException, IOException {
            return (CTPatternFill) POIXMLTypeLoader.parse(file, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPatternFill) POIXMLTypeLoader.parse(file, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPatternFill) POIXMLTypeLoader.parse(inputStream, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPatternFill) POIXMLTypeLoader.parse(inputStream, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(Reader reader) throws XmlException, IOException {
            return (CTPatternFill) POIXMLTypeLoader.parse(reader, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPatternFill) POIXMLTypeLoader.parse(reader, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(String str) throws XmlException {
            return (CTPatternFill) POIXMLTypeLoader.parse(str, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPatternFill) POIXMLTypeLoader.parse(str, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(URL url) throws XmlException, IOException {
            return (CTPatternFill) POIXMLTypeLoader.parse(url, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPatternFill) POIXMLTypeLoader.parse(url, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPatternFill) POIXMLTypeLoader.parse(xMLStreamReader, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPatternFill) POIXMLTypeLoader.parse(xMLStreamReader, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPatternFill) POIXMLTypeLoader.parse(xMLInputStream, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPatternFill) POIXMLTypeLoader.parse(xMLInputStream, CTPatternFill.type, xmlOptions);
        }

        public static CTPatternFill parse(Node node) throws XmlException {
            return (CTPatternFill) POIXMLTypeLoader.parse(node, CTPatternFill.type, (XmlOptions) null);
        }

        public static CTPatternFill parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPatternFill) POIXMLTypeLoader.parse(node, CTPatternFill.type, xmlOptions);
        }
    }

    CTColor addNewBgColor();

    CTColor addNewFgColor();

    CTColor getBgColor();

    CTColor getFgColor();

    STPatternType.Enum getPatternType();

    boolean isSetBgColor();

    boolean isSetFgColor();

    boolean isSetPatternType();

    void setBgColor(CTColor cTColor);

    void setFgColor(CTColor cTColor);

    void setPatternType(STPatternType.Enum r1);

    void unsetBgColor();

    void unsetFgColor();

    void unsetPatternType();

    STPatternType xgetPatternType();

    void xsetPatternType(STPatternType sTPatternType);
}
