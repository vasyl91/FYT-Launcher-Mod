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
public interface CTTcPrBase extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTcPrBase.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttcprbase93e6type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTcPrBase newInstance() {
            return (CTTcPrBase) POIXMLTypeLoader.newInstance(CTTcPrBase.type, (XmlOptions) null);
        }

        public static CTTcPrBase newInstance(XmlOptions xmlOptions) {
            return (CTTcPrBase) POIXMLTypeLoader.newInstance(CTTcPrBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTcPrBase.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTcPrBase.type, xmlOptions);
        }

        public static CTTcPrBase parse(File file) throws XmlException, IOException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(file, CTTcPrBase.type, (XmlOptions) null);
        }

        public static CTTcPrBase parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(file, CTTcPrBase.type, xmlOptions);
        }

        public static CTTcPrBase parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(inputStream, CTTcPrBase.type, (XmlOptions) null);
        }

        public static CTTcPrBase parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(inputStream, CTTcPrBase.type, xmlOptions);
        }

        public static CTTcPrBase parse(Reader reader) throws XmlException, IOException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(reader, CTTcPrBase.type, (XmlOptions) null);
        }

        public static CTTcPrBase parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(reader, CTTcPrBase.type, xmlOptions);
        }

        public static CTTcPrBase parse(String str) throws XmlException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(str, CTTcPrBase.type, (XmlOptions) null);
        }

        public static CTTcPrBase parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(str, CTTcPrBase.type, xmlOptions);
        }

        public static CTTcPrBase parse(URL url) throws XmlException, IOException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(url, CTTcPrBase.type, (XmlOptions) null);
        }

        public static CTTcPrBase parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(url, CTTcPrBase.type, xmlOptions);
        }

        public static CTTcPrBase parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTcPrBase.type, (XmlOptions) null);
        }

        public static CTTcPrBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTcPrBase.type, xmlOptions);
        }

        public static CTTcPrBase parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(xMLInputStream, CTTcPrBase.type, (XmlOptions) null);
        }

        public static CTTcPrBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(xMLInputStream, CTTcPrBase.type, xmlOptions);
        }

        public static CTTcPrBase parse(Node node) throws XmlException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(node, CTTcPrBase.type, (XmlOptions) null);
        }

        public static CTTcPrBase parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTcPrBase) POIXMLTypeLoader.parse(node, CTTcPrBase.type, xmlOptions);
        }
    }

    CTCnf addNewCnfStyle();

    CTDecimalNumber addNewGridSpan();

    CTHMerge addNewHMerge();

    CTOnOff addNewHideMark();

    CTOnOff addNewNoWrap();

    CTShd addNewShd();

    CTTcBorders addNewTcBorders();

    CTOnOff addNewTcFitText();

    CTTcMar addNewTcMar();

    CTTblWidth addNewTcW();

    CTTextDirection addNewTextDirection();

    CTVerticalJc addNewVAlign();

    CTVMerge addNewVMerge();

    CTCnf getCnfStyle();

    CTDecimalNumber getGridSpan();

    CTHMerge getHMerge();

    CTOnOff getHideMark();

    CTOnOff getNoWrap();

    CTShd getShd();

    CTTcBorders getTcBorders();

    CTOnOff getTcFitText();

    CTTcMar getTcMar();

    CTTblWidth getTcW();

    CTTextDirection getTextDirection();

    CTVerticalJc getVAlign();

    CTVMerge getVMerge();

    boolean isSetCnfStyle();

    boolean isSetGridSpan();

    boolean isSetHMerge();

    boolean isSetHideMark();

    boolean isSetNoWrap();

    boolean isSetShd();

    boolean isSetTcBorders();

    boolean isSetTcFitText();

    boolean isSetTcMar();

    boolean isSetTcW();

    boolean isSetTextDirection();

    boolean isSetVAlign();

    boolean isSetVMerge();

    void setCnfStyle(CTCnf cTCnf);

    void setGridSpan(CTDecimalNumber cTDecimalNumber);

    void setHMerge(CTHMerge cTHMerge);

    void setHideMark(CTOnOff cTOnOff);

    void setNoWrap(CTOnOff cTOnOff);

    void setShd(CTShd cTShd);

    void setTcBorders(CTTcBorders cTTcBorders);

    void setTcFitText(CTOnOff cTOnOff);

    void setTcMar(CTTcMar cTTcMar);

    void setTcW(CTTblWidth cTTblWidth);

    void setTextDirection(CTTextDirection cTTextDirection);

    void setVAlign(CTVerticalJc cTVerticalJc);

    void setVMerge(CTVMerge cTVMerge);

    void unsetCnfStyle();

    void unsetGridSpan();

    void unsetHMerge();

    void unsetHideMark();

    void unsetNoWrap();

    void unsetShd();

    void unsetTcBorders();

    void unsetTcFitText();

    void unsetTcMar();

    void unsetTcW();

    void unsetTextDirection();

    void unsetVAlign();

    void unsetVMerge();
}
