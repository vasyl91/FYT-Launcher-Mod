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
public interface CTTblPrBase extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTblPrBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblprbaseeba1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblPrBase newInstance() {
            return (CTTblPrBase) POIXMLTypeLoader.newInstance(CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase newInstance(XmlOptions xmlOptions) {
            return (CTTblPrBase) POIXMLTypeLoader.newInstance(CTTblPrBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPrBase.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(File file) throws XmlException, IOException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(file, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(file, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(inputStream, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(inputStream, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(Reader reader) throws XmlException, IOException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(reader, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(reader, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(String str) throws XmlException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(str, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(str, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(URL url) throws XmlException, IOException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(url, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(url, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(xMLInputStream, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(xMLInputStream, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(Node node) throws XmlException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(node, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTblPrBase) POIXMLTypeLoader.parse(node, CTTblPrBase.type, xmlOptions);
        }
    }

    CTOnOff addNewBidiVisual();

    CTJc addNewJc();

    CTShd addNewShd();

    CTTblBorders addNewTblBorders();

    CTTblCellMar addNewTblCellMar();

    CTTblWidth addNewTblCellSpacing();

    CTTblWidth addNewTblInd();

    CTTblLayoutType addNewTblLayout();

    CTShortHexNumber addNewTblLook();

    CTTblOverlap addNewTblOverlap();

    CTString addNewTblStyle();

    CTDecimalNumber addNewTblStyleColBandSize();

    CTDecimalNumber addNewTblStyleRowBandSize();

    CTTblWidth addNewTblW();

    CTTblPPr addNewTblpPr();

    CTOnOff getBidiVisual();

    CTJc getJc();

    CTShd getShd();

    CTTblBorders getTblBorders();

    CTTblCellMar getTblCellMar();

    CTTblWidth getTblCellSpacing();

    CTTblWidth getTblInd();

    CTTblLayoutType getTblLayout();

    CTShortHexNumber getTblLook();

    CTTblOverlap getTblOverlap();

    CTString getTblStyle();

    CTDecimalNumber getTblStyleColBandSize();

    CTDecimalNumber getTblStyleRowBandSize();

    CTTblWidth getTblW();

    CTTblPPr getTblpPr();

    boolean isSetBidiVisual();

    boolean isSetJc();

    boolean isSetShd();

    boolean isSetTblBorders();

    boolean isSetTblCellMar();

    boolean isSetTblCellSpacing();

    boolean isSetTblInd();

    boolean isSetTblLayout();

    boolean isSetTblLook();

    boolean isSetTblOverlap();

    boolean isSetTblStyle();

    boolean isSetTblStyleColBandSize();

    boolean isSetTblStyleRowBandSize();

    boolean isSetTblW();

    boolean isSetTblpPr();

    void setBidiVisual(CTOnOff cTOnOff);

    void setJc(CTJc cTJc);

    void setShd(CTShd cTShd);

    void setTblBorders(CTTblBorders cTTblBorders);

    void setTblCellMar(CTTblCellMar cTTblCellMar);

    void setTblCellSpacing(CTTblWidth cTTblWidth);

    void setTblInd(CTTblWidth cTTblWidth);

    void setTblLayout(CTTblLayoutType cTTblLayoutType);

    void setTblLook(CTShortHexNumber cTShortHexNumber);

    void setTblOverlap(CTTblOverlap cTTblOverlap);

    void setTblStyle(CTString cTString);

    void setTblStyleColBandSize(CTDecimalNumber cTDecimalNumber);

    void setTblStyleRowBandSize(CTDecimalNumber cTDecimalNumber);

    void setTblW(CTTblWidth cTTblWidth);

    void setTblpPr(CTTblPPr cTTblPPr);

    void unsetBidiVisual();

    void unsetJc();

    void unsetShd();

    void unsetTblBorders();

    void unsetTblCellMar();

    void unsetTblCellSpacing();

    void unsetTblInd();

    void unsetTblLayout();

    void unsetTblLook();

    void unsetTblOverlap();

    void unsetTblStyle();

    void unsetTblStyleColBandSize();

    void unsetTblStyleRowBandSize();

    void unsetTblW();

    void unsetTblpPr();
}
