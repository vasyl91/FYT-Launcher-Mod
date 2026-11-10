package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTDateAx extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTDateAx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdateaxbdd7type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDateAx newInstance() {
            return (CTDateAx) POIXMLTypeLoader.newInstance(CTDateAx.type, (XmlOptions) null);
        }

        public static CTDateAx newInstance(XmlOptions xmlOptions) {
            return (CTDateAx) POIXMLTypeLoader.newInstance(CTDateAx.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDateAx.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDateAx.type, xmlOptions);
        }

        public static CTDateAx parse(File file) throws XmlException, IOException {
            return (CTDateAx) POIXMLTypeLoader.parse(file, CTDateAx.type, (XmlOptions) null);
        }

        public static CTDateAx parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDateAx) POIXMLTypeLoader.parse(file, CTDateAx.type, xmlOptions);
        }

        public static CTDateAx parse(InputStream inputStream) throws XmlException, IOException {
            return (CTDateAx) POIXMLTypeLoader.parse(inputStream, CTDateAx.type, (XmlOptions) null);
        }

        public static CTDateAx parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDateAx) POIXMLTypeLoader.parse(inputStream, CTDateAx.type, xmlOptions);
        }

        public static CTDateAx parse(Reader reader) throws XmlException, IOException {
            return (CTDateAx) POIXMLTypeLoader.parse(reader, CTDateAx.type, (XmlOptions) null);
        }

        public static CTDateAx parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDateAx) POIXMLTypeLoader.parse(reader, CTDateAx.type, xmlOptions);
        }

        public static CTDateAx parse(String str) throws XmlException {
            return (CTDateAx) POIXMLTypeLoader.parse(str, CTDateAx.type, (XmlOptions) null);
        }

        public static CTDateAx parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTDateAx) POIXMLTypeLoader.parse(str, CTDateAx.type, xmlOptions);
        }

        public static CTDateAx parse(URL url) throws XmlException, IOException {
            return (CTDateAx) POIXMLTypeLoader.parse(url, CTDateAx.type, (XmlOptions) null);
        }

        public static CTDateAx parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTDateAx) POIXMLTypeLoader.parse(url, CTDateAx.type, xmlOptions);
        }

        public static CTDateAx parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTDateAx) POIXMLTypeLoader.parse(xMLStreamReader, CTDateAx.type, (XmlOptions) null);
        }

        public static CTDateAx parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTDateAx) POIXMLTypeLoader.parse(xMLStreamReader, CTDateAx.type, xmlOptions);
        }

        public static CTDateAx parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTDateAx) POIXMLTypeLoader.parse(xMLInputStream, CTDateAx.type, (XmlOptions) null);
        }

        public static CTDateAx parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTDateAx) POIXMLTypeLoader.parse(xMLInputStream, CTDateAx.type, xmlOptions);
        }

        public static CTDateAx parse(Node node) throws XmlException {
            return (CTDateAx) POIXMLTypeLoader.parse(node, CTDateAx.type, (XmlOptions) null);
        }

        public static CTDateAx parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTDateAx) POIXMLTypeLoader.parse(node, CTDateAx.type, xmlOptions);
        }
    }

    CTBoolean addNewAuto();

    CTUnsignedInt addNewAxId();

    CTAxPos addNewAxPos();

    CTTimeUnit addNewBaseTimeUnit();

    CTUnsignedInt addNewCrossAx();

    CTCrosses addNewCrosses();

    CTDouble addNewCrossesAt();

    CTBoolean addNewDelete();

    CTExtensionList addNewExtLst();

    CTLblOffset addNewLblOffset();

    CTChartLines addNewMajorGridlines();

    CTTickMark addNewMajorTickMark();

    CTTimeUnit addNewMajorTimeUnit();

    CTAxisUnit addNewMajorUnit();

    CTChartLines addNewMinorGridlines();

    CTTickMark addNewMinorTickMark();

    CTTimeUnit addNewMinorTimeUnit();

    CTAxisUnit addNewMinorUnit();

    CTNumFmt addNewNumFmt();

    CTScaling addNewScaling();

    CTShapeProperties addNewSpPr();

    CTTickLblPos addNewTickLblPos();

    CTTitle addNewTitle();

    CTTextBody addNewTxPr();

    CTBoolean getAuto();

    CTUnsignedInt getAxId();

    CTAxPos getAxPos();

    CTTimeUnit getBaseTimeUnit();

    CTUnsignedInt getCrossAx();

    CTCrosses getCrosses();

    CTDouble getCrossesAt();

    CTBoolean getDelete();

    CTExtensionList getExtLst();

    CTLblOffset getLblOffset();

    CTChartLines getMajorGridlines();

    CTTickMark getMajorTickMark();

    CTTimeUnit getMajorTimeUnit();

    CTAxisUnit getMajorUnit();

    CTChartLines getMinorGridlines();

    CTTickMark getMinorTickMark();

    CTTimeUnit getMinorTimeUnit();

    CTAxisUnit getMinorUnit();

    CTNumFmt getNumFmt();

    CTScaling getScaling();

    CTShapeProperties getSpPr();

    CTTickLblPos getTickLblPos();

    CTTitle getTitle();

    CTTextBody getTxPr();

    boolean isSetAuto();

    boolean isSetBaseTimeUnit();

    boolean isSetCrosses();

    boolean isSetCrossesAt();

    boolean isSetDelete();

    boolean isSetExtLst();

    boolean isSetLblOffset();

    boolean isSetMajorGridlines();

    boolean isSetMajorTickMark();

    boolean isSetMajorTimeUnit();

    boolean isSetMajorUnit();

    boolean isSetMinorGridlines();

    boolean isSetMinorTickMark();

    boolean isSetMinorTimeUnit();

    boolean isSetMinorUnit();

    boolean isSetNumFmt();

    boolean isSetSpPr();

    boolean isSetTickLblPos();

    boolean isSetTitle();

    boolean isSetTxPr();

    void setAuto(CTBoolean cTBoolean);

    void setAxId(CTUnsignedInt cTUnsignedInt);

    void setAxPos(CTAxPos cTAxPos);

    void setBaseTimeUnit(CTTimeUnit cTTimeUnit);

    void setCrossAx(CTUnsignedInt cTUnsignedInt);

    void setCrosses(CTCrosses cTCrosses);

    void setCrossesAt(CTDouble cTDouble);

    void setDelete(CTBoolean cTBoolean);

    void setExtLst(CTExtensionList cTExtensionList);

    void setLblOffset(CTLblOffset cTLblOffset);

    void setMajorGridlines(CTChartLines cTChartLines);

    void setMajorTickMark(CTTickMark cTTickMark);

    void setMajorTimeUnit(CTTimeUnit cTTimeUnit);

    void setMajorUnit(CTAxisUnit cTAxisUnit);

    void setMinorGridlines(CTChartLines cTChartLines);

    void setMinorTickMark(CTTickMark cTTickMark);

    void setMinorTimeUnit(CTTimeUnit cTTimeUnit);

    void setMinorUnit(CTAxisUnit cTAxisUnit);

    void setNumFmt(CTNumFmt cTNumFmt);

    void setScaling(CTScaling cTScaling);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setTickLblPos(CTTickLblPos cTTickLblPos);

    void setTitle(CTTitle cTTitle);

    void setTxPr(CTTextBody cTTextBody);

    void unsetAuto();

    void unsetBaseTimeUnit();

    void unsetCrosses();

    void unsetCrossesAt();

    void unsetDelete();

    void unsetExtLst();

    void unsetLblOffset();

    void unsetMajorGridlines();

    void unsetMajorTickMark();

    void unsetMajorTimeUnit();

    void unsetMajorUnit();

    void unsetMinorGridlines();

    void unsetMinorTickMark();

    void unsetMinorTimeUnit();

    void unsetMinorUnit();

    void unsetNumFmt();

    void unsetSpPr();

    void unsetTickLblPos();

    void unsetTitle();

    void unsetTxPr();
}
