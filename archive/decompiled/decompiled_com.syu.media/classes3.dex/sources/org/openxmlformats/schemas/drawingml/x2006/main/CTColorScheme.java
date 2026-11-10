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
public interface CTColorScheme extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTColorScheme.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcolorscheme0e99type");

    public static final class Factory {
        private Factory() {
        }

        public static CTColorScheme newInstance() {
            return (CTColorScheme) POIXMLTypeLoader.newInstance(CTColorScheme.type, (XmlOptions) null);
        }

        public static CTColorScheme newInstance(XmlOptions xmlOptions) {
            return (CTColorScheme) POIXMLTypeLoader.newInstance(CTColorScheme.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTColorScheme.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTColorScheme.type, xmlOptions);
        }

        public static CTColorScheme parse(File file) throws XmlException, IOException {
            return (CTColorScheme) POIXMLTypeLoader.parse(file, CTColorScheme.type, (XmlOptions) null);
        }

        public static CTColorScheme parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorScheme) POIXMLTypeLoader.parse(file, CTColorScheme.type, xmlOptions);
        }

        public static CTColorScheme parse(InputStream inputStream) throws XmlException, IOException {
            return (CTColorScheme) POIXMLTypeLoader.parse(inputStream, CTColorScheme.type, (XmlOptions) null);
        }

        public static CTColorScheme parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorScheme) POIXMLTypeLoader.parse(inputStream, CTColorScheme.type, xmlOptions);
        }

        public static CTColorScheme parse(Reader reader) throws XmlException, IOException {
            return (CTColorScheme) POIXMLTypeLoader.parse(reader, CTColorScheme.type, (XmlOptions) null);
        }

        public static CTColorScheme parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorScheme) POIXMLTypeLoader.parse(reader, CTColorScheme.type, xmlOptions);
        }

        public static CTColorScheme parse(String str) throws XmlException {
            return (CTColorScheme) POIXMLTypeLoader.parse(str, CTColorScheme.type, (XmlOptions) null);
        }

        public static CTColorScheme parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTColorScheme) POIXMLTypeLoader.parse(str, CTColorScheme.type, xmlOptions);
        }

        public static CTColorScheme parse(URL url) throws XmlException, IOException {
            return (CTColorScheme) POIXMLTypeLoader.parse(url, CTColorScheme.type, (XmlOptions) null);
        }

        public static CTColorScheme parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTColorScheme) POIXMLTypeLoader.parse(url, CTColorScheme.type, xmlOptions);
        }

        public static CTColorScheme parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTColorScheme) POIXMLTypeLoader.parse(xMLStreamReader, CTColorScheme.type, (XmlOptions) null);
        }

        public static CTColorScheme parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTColorScheme) POIXMLTypeLoader.parse(xMLStreamReader, CTColorScheme.type, xmlOptions);
        }

        public static CTColorScheme parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTColorScheme) POIXMLTypeLoader.parse(xMLInputStream, CTColorScheme.type, (XmlOptions) null);
        }

        public static CTColorScheme parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTColorScheme) POIXMLTypeLoader.parse(xMLInputStream, CTColorScheme.type, xmlOptions);
        }

        public static CTColorScheme parse(Node node) throws XmlException {
            return (CTColorScheme) POIXMLTypeLoader.parse(node, CTColorScheme.type, (XmlOptions) null);
        }

        public static CTColorScheme parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTColorScheme) POIXMLTypeLoader.parse(node, CTColorScheme.type, xmlOptions);
        }
    }

    CTColor addNewAccent1();

    CTColor addNewAccent2();

    CTColor addNewAccent3();

    CTColor addNewAccent4();

    CTColor addNewAccent5();

    CTColor addNewAccent6();

    CTColor addNewDk1();

    CTColor addNewDk2();

    CTOfficeArtExtensionList addNewExtLst();

    CTColor addNewFolHlink();

    CTColor addNewHlink();

    CTColor addNewLt1();

    CTColor addNewLt2();

    CTColor getAccent1();

    CTColor getAccent2();

    CTColor getAccent3();

    CTColor getAccent4();

    CTColor getAccent5();

    CTColor getAccent6();

    CTColor getDk1();

    CTColor getDk2();

    CTOfficeArtExtensionList getExtLst();

    CTColor getFolHlink();

    CTColor getHlink();

    CTColor getLt1();

    CTColor getLt2();

    String getName();

    boolean isSetExtLst();

    void setAccent1(CTColor cTColor);

    void setAccent2(CTColor cTColor);

    void setAccent3(CTColor cTColor);

    void setAccent4(CTColor cTColor);

    void setAccent5(CTColor cTColor);

    void setAccent6(CTColor cTColor);

    void setDk1(CTColor cTColor);

    void setDk2(CTColor cTColor);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFolHlink(CTColor cTColor);

    void setHlink(CTColor cTColor);

    void setLt1(CTColor cTColor);

    void setLt2(CTColor cTColor);

    void setName(String str);

    void unsetExtLst();

    XmlString xgetName();

    void xsetName(XmlString xmlString);
}
