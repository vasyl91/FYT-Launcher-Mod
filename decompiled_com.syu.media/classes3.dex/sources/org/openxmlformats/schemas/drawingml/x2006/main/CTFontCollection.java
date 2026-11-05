package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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
public interface CTFontCollection extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTFontCollection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfontcollectiondd68type");

    public static final class Factory {
        private Factory() {
        }

        public static CTFontCollection newInstance() {
            return (CTFontCollection) POIXMLTypeLoader.newInstance(CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection newInstance(XmlOptions xmlOptions) {
            return (CTFontCollection) POIXMLTypeLoader.newInstance(CTFontCollection.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFontCollection.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(File file) throws XmlException, IOException {
            return (CTFontCollection) POIXMLTypeLoader.parse(file, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontCollection) POIXMLTypeLoader.parse(file, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(InputStream inputStream) throws XmlException, IOException {
            return (CTFontCollection) POIXMLTypeLoader.parse(inputStream, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontCollection) POIXMLTypeLoader.parse(inputStream, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(Reader reader) throws XmlException, IOException {
            return (CTFontCollection) POIXMLTypeLoader.parse(reader, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontCollection) POIXMLTypeLoader.parse(reader, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(String str) throws XmlException {
            return (CTFontCollection) POIXMLTypeLoader.parse(str, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTFontCollection) POIXMLTypeLoader.parse(str, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(URL url) throws XmlException, IOException {
            return (CTFontCollection) POIXMLTypeLoader.parse(url, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTFontCollection) POIXMLTypeLoader.parse(url, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTFontCollection) POIXMLTypeLoader.parse(xMLStreamReader, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTFontCollection) POIXMLTypeLoader.parse(xMLStreamReader, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTFontCollection) POIXMLTypeLoader.parse(xMLInputStream, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTFontCollection) POIXMLTypeLoader.parse(xMLInputStream, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(Node node) throws XmlException {
            return (CTFontCollection) POIXMLTypeLoader.parse(node, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTFontCollection) POIXMLTypeLoader.parse(node, CTFontCollection.type, xmlOptions);
        }
    }

    CTTextFont addNewCs();

    CTTextFont addNewEa();

    CTOfficeArtExtensionList addNewExtLst();

    CTSupplementalFont addNewFont();

    CTTextFont addNewLatin();

    CTTextFont getCs();

    CTTextFont getEa();

    CTOfficeArtExtensionList getExtLst();

    CTSupplementalFont getFontArray(int i);

    CTSupplementalFont[] getFontArray();

    List<CTSupplementalFont> getFontList();

    CTTextFont getLatin();

    CTSupplementalFont insertNewFont(int i);

    boolean isSetExtLst();

    void removeFont(int i);

    void setCs(CTTextFont cTTextFont);

    void setEa(CTTextFont cTTextFont);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFontArray(int i, CTSupplementalFont cTSupplementalFont);

    void setFontArray(CTSupplementalFont[] cTSupplementalFontArr);

    void setLatin(CTTextFont cTTextFont);

    int sizeOfFontArray();

    void unsetExtLst();
}
