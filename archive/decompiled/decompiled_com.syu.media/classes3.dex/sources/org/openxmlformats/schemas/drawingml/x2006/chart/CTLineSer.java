package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTLineSer extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTLineSer.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlineserd01atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLineSer newInstance() {
            return (CTLineSer) POIXMLTypeLoader.newInstance(CTLineSer.type, (XmlOptions) null);
        }

        public static CTLineSer newInstance(XmlOptions xmlOptions) {
            return (CTLineSer) POIXMLTypeLoader.newInstance(CTLineSer.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineSer.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineSer.type, xmlOptions);
        }

        public static CTLineSer parse(File file) throws XmlException, IOException {
            return (CTLineSer) POIXMLTypeLoader.parse(file, CTLineSer.type, (XmlOptions) null);
        }

        public static CTLineSer parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineSer) POIXMLTypeLoader.parse(file, CTLineSer.type, xmlOptions);
        }

        public static CTLineSer parse(InputStream inputStream) throws XmlException, IOException {
            return (CTLineSer) POIXMLTypeLoader.parse(inputStream, CTLineSer.type, (XmlOptions) null);
        }

        public static CTLineSer parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineSer) POIXMLTypeLoader.parse(inputStream, CTLineSer.type, xmlOptions);
        }

        public static CTLineSer parse(Reader reader) throws XmlException, IOException {
            return (CTLineSer) POIXMLTypeLoader.parse(reader, CTLineSer.type, (XmlOptions) null);
        }

        public static CTLineSer parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineSer) POIXMLTypeLoader.parse(reader, CTLineSer.type, xmlOptions);
        }

        public static CTLineSer parse(String str) throws XmlException {
            return (CTLineSer) POIXMLTypeLoader.parse(str, CTLineSer.type, (XmlOptions) null);
        }

        public static CTLineSer parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTLineSer) POIXMLTypeLoader.parse(str, CTLineSer.type, xmlOptions);
        }

        public static CTLineSer parse(URL url) throws XmlException, IOException {
            return (CTLineSer) POIXMLTypeLoader.parse(url, CTLineSer.type, (XmlOptions) null);
        }

        public static CTLineSer parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTLineSer) POIXMLTypeLoader.parse(url, CTLineSer.type, xmlOptions);
        }

        public static CTLineSer parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTLineSer) POIXMLTypeLoader.parse(xMLStreamReader, CTLineSer.type, (XmlOptions) null);
        }

        public static CTLineSer parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTLineSer) POIXMLTypeLoader.parse(xMLStreamReader, CTLineSer.type, xmlOptions);
        }

        public static CTLineSer parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTLineSer) POIXMLTypeLoader.parse(xMLInputStream, CTLineSer.type, (XmlOptions) null);
        }

        public static CTLineSer parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTLineSer) POIXMLTypeLoader.parse(xMLInputStream, CTLineSer.type, xmlOptions);
        }

        public static CTLineSer parse(Node node) throws XmlException {
            return (CTLineSer) POIXMLTypeLoader.parse(node, CTLineSer.type, (XmlOptions) null);
        }

        public static CTLineSer parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTLineSer) POIXMLTypeLoader.parse(node, CTLineSer.type, xmlOptions);
        }
    }

    CTAxDataSource addNewCat();

    CTDLbls addNewDLbls();

    CTDPt addNewDPt();

    CTErrBars addNewErrBars();

    CTExtensionList addNewExtLst();

    CTUnsignedInt addNewIdx();

    CTMarker addNewMarker();

    CTUnsignedInt addNewOrder();

    CTBoolean addNewSmooth();

    CTShapeProperties addNewSpPr();

    CTTrendline addNewTrendline();

    CTSerTx addNewTx();

    CTNumDataSource addNewVal();

    CTAxDataSource getCat();

    CTDLbls getDLbls();

    CTDPt getDPtArray(int i);

    CTDPt[] getDPtArray();

    List<CTDPt> getDPtList();

    CTErrBars getErrBars();

    CTExtensionList getExtLst();

    CTUnsignedInt getIdx();

    CTMarker getMarker();

    CTUnsignedInt getOrder();

    CTBoolean getSmooth();

    CTShapeProperties getSpPr();

    CTTrendline getTrendlineArray(int i);

    CTTrendline[] getTrendlineArray();

    List<CTTrendline> getTrendlineList();

    CTSerTx getTx();

    CTNumDataSource getVal();

    CTDPt insertNewDPt(int i);

    CTTrendline insertNewTrendline(int i);

    boolean isSetCat();

    boolean isSetDLbls();

    boolean isSetErrBars();

    boolean isSetExtLst();

    boolean isSetMarker();

    boolean isSetSmooth();

    boolean isSetSpPr();

    boolean isSetTx();

    boolean isSetVal();

    void removeDPt(int i);

    void removeTrendline(int i);

    void setCat(CTAxDataSource cTAxDataSource);

    void setDLbls(CTDLbls cTDLbls);

    void setDPtArray(int i, CTDPt cTDPt);

    void setDPtArray(CTDPt[] cTDPtArr);

    void setErrBars(CTErrBars cTErrBars);

    void setExtLst(CTExtensionList cTExtensionList);

    void setIdx(CTUnsignedInt cTUnsignedInt);

    void setMarker(CTMarker cTMarker);

    void setOrder(CTUnsignedInt cTUnsignedInt);

    void setSmooth(CTBoolean cTBoolean);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setTrendlineArray(int i, CTTrendline cTTrendline);

    void setTrendlineArray(CTTrendline[] cTTrendlineArr);

    void setTx(CTSerTx cTSerTx);

    void setVal(CTNumDataSource cTNumDataSource);

    int sizeOfDPtArray();

    int sizeOfTrendlineArray();

    void unsetCat();

    void unsetDLbls();

    void unsetErrBars();

    void unsetExtLst();

    void unsetMarker();

    void unsetSmooth();

    void unsetSpPr();

    void unsetTx();

    void unsetVal();
}
