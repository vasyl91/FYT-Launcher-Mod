package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTAbstractNum extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTAbstractNum.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctabstractnum588etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTAbstractNum newInstance() {
            return (CTAbstractNum) POIXMLTypeLoader.newInstance(CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum newInstance(XmlOptions xmlOptions) {
            return (CTAbstractNum) POIXMLTypeLoader.newInstance(CTAbstractNum.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAbstractNum.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(File file) throws XmlException, IOException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(file, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(file, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(inputStream, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(inputStream, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(Reader reader) throws XmlException, IOException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(reader, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(reader, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(String str) throws XmlException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(str, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(str, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(URL url) throws XmlException, IOException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(url, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(url, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(xMLStreamReader, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(xMLStreamReader, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(xMLInputStream, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(xMLInputStream, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(Node node) throws XmlException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(node, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAbstractNum) POIXMLTypeLoader.parse(node, CTAbstractNum.type, xmlOptions);
        }
    }

    CTLvl addNewLvl();

    CTMultiLevelType addNewMultiLevelType();

    CTString addNewName();

    CTLongHexNumber addNewNsid();

    CTString addNewNumStyleLink();

    CTString addNewStyleLink();

    CTLongHexNumber addNewTmpl();

    BigInteger getAbstractNumId();

    CTLvl getLvlArray(int i);

    CTLvl[] getLvlArray();

    List<CTLvl> getLvlList();

    CTMultiLevelType getMultiLevelType();

    CTString getName();

    CTLongHexNumber getNsid();

    CTString getNumStyleLink();

    CTString getStyleLink();

    CTLongHexNumber getTmpl();

    CTLvl insertNewLvl(int i);

    boolean isSetMultiLevelType();

    boolean isSetName();

    boolean isSetNsid();

    boolean isSetNumStyleLink();

    boolean isSetStyleLink();

    boolean isSetTmpl();

    void removeLvl(int i);

    void setAbstractNumId(BigInteger bigInteger);

    void setLvlArray(int i, CTLvl cTLvl);

    void setLvlArray(CTLvl[] cTLvlArr);

    void setMultiLevelType(CTMultiLevelType cTMultiLevelType);

    void setName(CTString cTString);

    void setNsid(CTLongHexNumber cTLongHexNumber);

    void setNumStyleLink(CTString cTString);

    void setStyleLink(CTString cTString);

    void setTmpl(CTLongHexNumber cTLongHexNumber);

    int sizeOfLvlArray();

    void unsetMultiLevelType();

    void unsetName();

    void unsetNsid();

    void unsetNumStyleLink();

    void unsetStyleLink();

    void unsetTmpl();

    STDecimalNumber xgetAbstractNumId();

    void xsetAbstractNumId(STDecimalNumber sTDecimalNumber);
}
