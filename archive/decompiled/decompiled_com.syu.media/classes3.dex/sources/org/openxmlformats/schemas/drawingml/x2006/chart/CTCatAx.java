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
public interface CTCatAx extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCatAx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcatax7159type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCatAx newInstance() {
            return (CTCatAx) POIXMLTypeLoader.newInstance(CTCatAx.type, (XmlOptions) null);
        }

        public static CTCatAx newInstance(XmlOptions xmlOptions) {
            return (CTCatAx) POIXMLTypeLoader.newInstance(CTCatAx.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCatAx.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCatAx.type, xmlOptions);
        }

        public static CTCatAx parse(File file) throws XmlException, IOException {
            return (CTCatAx) POIXMLTypeLoader.parse(file, CTCatAx.type, (XmlOptions) null);
        }

        public static CTCatAx parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCatAx) POIXMLTypeLoader.parse(file, CTCatAx.type, xmlOptions);
        }

        public static CTCatAx parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCatAx) POIXMLTypeLoader.parse(inputStream, CTCatAx.type, (XmlOptions) null);
        }

        public static CTCatAx parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCatAx) POIXMLTypeLoader.parse(inputStream, CTCatAx.type, xmlOptions);
        }

        public static CTCatAx parse(Reader reader) throws XmlException, IOException {
            return (CTCatAx) POIXMLTypeLoader.parse(reader, CTCatAx.type, (XmlOptions) null);
        }

        public static CTCatAx parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCatAx) POIXMLTypeLoader.parse(reader, CTCatAx.type, xmlOptions);
        }

        public static CTCatAx parse(String str) throws XmlException {
            return (CTCatAx) POIXMLTypeLoader.parse(str, CTCatAx.type, (XmlOptions) null);
        }

        public static CTCatAx parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCatAx) POIXMLTypeLoader.parse(str, CTCatAx.type, xmlOptions);
        }

        public static CTCatAx parse(URL url) throws XmlException, IOException {
            return (CTCatAx) POIXMLTypeLoader.parse(url, CTCatAx.type, (XmlOptions) null);
        }

        public static CTCatAx parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCatAx) POIXMLTypeLoader.parse(url, CTCatAx.type, xmlOptions);
        }

        public static CTCatAx parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCatAx) POIXMLTypeLoader.parse(xMLStreamReader, CTCatAx.type, (XmlOptions) null);
        }

        public static CTCatAx parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCatAx) POIXMLTypeLoader.parse(xMLStreamReader, CTCatAx.type, xmlOptions);
        }

        public static CTCatAx parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCatAx) POIXMLTypeLoader.parse(xMLInputStream, CTCatAx.type, (XmlOptions) null);
        }

        public static CTCatAx parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCatAx) POIXMLTypeLoader.parse(xMLInputStream, CTCatAx.type, xmlOptions);
        }

        public static CTCatAx parse(Node node) throws XmlException {
            return (CTCatAx) POIXMLTypeLoader.parse(node, CTCatAx.type, (XmlOptions) null);
        }

        public static CTCatAx parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCatAx) POIXMLTypeLoader.parse(node, CTCatAx.type, xmlOptions);
        }
    }

    CTBoolean addNewAuto();

    CTUnsignedInt addNewAxId();

    CTAxPos addNewAxPos();

    CTUnsignedInt addNewCrossAx();

    CTCrosses addNewCrosses();

    CTDouble addNewCrossesAt();

    CTBoolean addNewDelete();

    CTExtensionList addNewExtLst();

    CTLblAlgn addNewLblAlgn();

    CTLblOffset addNewLblOffset();

    CTChartLines addNewMajorGridlines();

    CTTickMark addNewMajorTickMark();

    CTChartLines addNewMinorGridlines();

    CTTickMark addNewMinorTickMark();

    CTBoolean addNewNoMultiLvlLbl();

    CTNumFmt addNewNumFmt();

    CTScaling addNewScaling();

    CTShapeProperties addNewSpPr();

    CTTickLblPos addNewTickLblPos();

    CTSkip addNewTickLblSkip();

    CTSkip addNewTickMarkSkip();

    CTTitle addNewTitle();

    CTTextBody addNewTxPr();

    CTBoolean getAuto();

    CTUnsignedInt getAxId();

    CTAxPos getAxPos();

    CTUnsignedInt getCrossAx();

    CTCrosses getCrosses();

    CTDouble getCrossesAt();

    CTBoolean getDelete();

    CTExtensionList getExtLst();

    CTLblAlgn getLblAlgn();

    CTLblOffset getLblOffset();

    CTChartLines getMajorGridlines();

    CTTickMark getMajorTickMark();

    CTChartLines getMinorGridlines();

    CTTickMark getMinorTickMark();

    CTBoolean getNoMultiLvlLbl();

    CTNumFmt getNumFmt();

    CTScaling getScaling();

    CTShapeProperties getSpPr();

    CTTickLblPos getTickLblPos();

    CTSkip getTickLblSkip();

    CTSkip getTickMarkSkip();

    CTTitle getTitle();

    CTTextBody getTxPr();

    boolean isSetAuto();

    boolean isSetCrosses();

    boolean isSetCrossesAt();

    boolean isSetDelete();

    boolean isSetExtLst();

    boolean isSetLblAlgn();

    boolean isSetLblOffset();

    boolean isSetMajorGridlines();

    boolean isSetMajorTickMark();

    boolean isSetMinorGridlines();

    boolean isSetMinorTickMark();

    boolean isSetNoMultiLvlLbl();

    boolean isSetNumFmt();

    boolean isSetSpPr();

    boolean isSetTickLblPos();

    boolean isSetTickLblSkip();

    boolean isSetTickMarkSkip();

    boolean isSetTitle();

    boolean isSetTxPr();

    void setAuto(CTBoolean cTBoolean);

    void setAxId(CTUnsignedInt cTUnsignedInt);

    void setAxPos(CTAxPos cTAxPos);

    void setCrossAx(CTUnsignedInt cTUnsignedInt);

    void setCrosses(CTCrosses cTCrosses);

    void setCrossesAt(CTDouble cTDouble);

    void setDelete(CTBoolean cTBoolean);

    void setExtLst(CTExtensionList cTExtensionList);

    void setLblAlgn(CTLblAlgn cTLblAlgn);

    void setLblOffset(CTLblOffset cTLblOffset);

    void setMajorGridlines(CTChartLines cTChartLines);

    void setMajorTickMark(CTTickMark cTTickMark);

    void setMinorGridlines(CTChartLines cTChartLines);

    void setMinorTickMark(CTTickMark cTTickMark);

    void setNoMultiLvlLbl(CTBoolean cTBoolean);

    void setNumFmt(CTNumFmt cTNumFmt);

    void setScaling(CTScaling cTScaling);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setTickLblPos(CTTickLblPos cTTickLblPos);

    void setTickLblSkip(CTSkip cTSkip);

    void setTickMarkSkip(CTSkip cTSkip);

    void setTitle(CTTitle cTTitle);

    void setTxPr(CTTextBody cTTextBody);

    void unsetAuto();

    void unsetCrosses();

    void unsetCrossesAt();

    void unsetDelete();

    void unsetExtLst();

    void unsetLblAlgn();

    void unsetLblOffset();

    void unsetMajorGridlines();

    void unsetMajorTickMark();

    void unsetMinorGridlines();

    void unsetMinorTickMark();

    void unsetNoMultiLvlLbl();

    void unsetNumFmt();

    void unsetSpPr();

    void unsetTickLblPos();

    void unsetTickLblSkip();

    void unsetTickMarkSkip();

    void unsetTitle();

    void unsetTxPr();
}
