package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface CTTblPrExBase extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTblPrExBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblprexbasee7eetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblPrExBase newInstance() {
            return (CTTblPrExBase) POIXMLTypeLoader.newInstance(CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase newInstance(XmlOptions xmlOptions) {
            return (CTTblPrExBase) POIXMLTypeLoader.newInstance(CTTblPrExBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(File file) throws XmlException, IOException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(file, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(file, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(inputStream, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(inputStream, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(Reader reader) throws XmlException, IOException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(reader, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(reader, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(String str) throws XmlException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(str, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(str, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(URL url) throws XmlException, IOException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(url, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(url, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(xMLInputStream, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(xMLInputStream, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(Node node) throws XmlException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(node, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(node, CTTblPrExBase.type, xmlOptions);
        }
    }

    CTJc addNewJc();

    CTShd addNewShd();

    CTTblBorders addNewTblBorders();

    CTTblCellMar addNewTblCellMar();

    CTTblWidth addNewTblCellSpacing();

    CTTblWidth addNewTblInd();

    CTTblLayoutType addNewTblLayout();

    CTShortHexNumber addNewTblLook();

    CTTblWidth addNewTblW();

    CTJc getJc();

    CTShd getShd();

    CTTblBorders getTblBorders();

    CTTblCellMar getTblCellMar();

    CTTblWidth getTblCellSpacing();

    CTTblWidth getTblInd();

    CTTblLayoutType getTblLayout();

    CTShortHexNumber getTblLook();

    CTTblWidth getTblW();

    boolean isSetJc();

    boolean isSetShd();

    boolean isSetTblBorders();

    boolean isSetTblCellMar();

    boolean isSetTblCellSpacing();

    boolean isSetTblInd();

    boolean isSetTblLayout();

    boolean isSetTblLook();

    boolean isSetTblW();

    void setJc(CTJc cTJc);

    void setShd(CTShd cTShd);

    void setTblBorders(CTTblBorders cTTblBorders);

    void setTblCellMar(CTTblCellMar cTTblCellMar);

    void setTblCellSpacing(CTTblWidth cTTblWidth);

    void setTblInd(CTTblWidth cTTblWidth);

    void setTblLayout(CTTblLayoutType cTTblLayoutType);

    void setTblLook(CTShortHexNumber cTShortHexNumber);

    void setTblW(CTTblWidth cTTblWidth);

    void unsetJc();

    void unsetShd();

    void unsetTblBorders();

    void unsetTblCellMar();

    void unsetTblCellSpacing();

    void unsetTblInd();

    void unsetTblLayout();

    void unsetTblLook();

    void unsetTblW();
}
