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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTChart extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTChart.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctchartc108type");

    public static final class Factory {
        private Factory() {
        }

        public static CTChart newInstance() {
            return (CTChart) POIXMLTypeLoader.newInstance(CTChart.type, (XmlOptions) null);
        }

        public static CTChart newInstance(XmlOptions xmlOptions) {
            return (CTChart) POIXMLTypeLoader.newInstance(CTChart.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTChart.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTChart.type, xmlOptions);
        }

        public static CTChart parse(File file) throws XmlException, IOException {
            return (CTChart) POIXMLTypeLoader.parse(file, CTChart.type, (XmlOptions) null);
        }

        public static CTChart parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTChart) POIXMLTypeLoader.parse(file, CTChart.type, xmlOptions);
        }

        public static CTChart parse(InputStream inputStream) throws XmlException, IOException {
            return (CTChart) POIXMLTypeLoader.parse(inputStream, CTChart.type, (XmlOptions) null);
        }

        public static CTChart parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTChart) POIXMLTypeLoader.parse(inputStream, CTChart.type, xmlOptions);
        }

        public static CTChart parse(Reader reader) throws XmlException, IOException {
            return (CTChart) POIXMLTypeLoader.parse(reader, CTChart.type, (XmlOptions) null);
        }

        public static CTChart parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTChart) POIXMLTypeLoader.parse(reader, CTChart.type, xmlOptions);
        }

        public static CTChart parse(String str) throws XmlException {
            return (CTChart) POIXMLTypeLoader.parse(str, CTChart.type, (XmlOptions) null);
        }

        public static CTChart parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTChart) POIXMLTypeLoader.parse(str, CTChart.type, xmlOptions);
        }

        public static CTChart parse(URL url) throws XmlException, IOException {
            return (CTChart) POIXMLTypeLoader.parse(url, CTChart.type, (XmlOptions) null);
        }

        public static CTChart parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTChart) POIXMLTypeLoader.parse(url, CTChart.type, xmlOptions);
        }

        public static CTChart parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTChart) POIXMLTypeLoader.parse(xMLStreamReader, CTChart.type, (XmlOptions) null);
        }

        public static CTChart parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTChart) POIXMLTypeLoader.parse(xMLStreamReader, CTChart.type, xmlOptions);
        }

        public static CTChart parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTChart) POIXMLTypeLoader.parse(xMLInputStream, CTChart.type, (XmlOptions) null);
        }

        public static CTChart parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTChart) POIXMLTypeLoader.parse(xMLInputStream, CTChart.type, xmlOptions);
        }

        public static CTChart parse(Node node) throws XmlException {
            return (CTChart) POIXMLTypeLoader.parse(node, CTChart.type, (XmlOptions) null);
        }

        public static CTChart parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTChart) POIXMLTypeLoader.parse(node, CTChart.type, xmlOptions);
        }
    }

    CTBoolean addNewAutoTitleDeleted();

    CTSurface addNewBackWall();

    CTDispBlanksAs addNewDispBlanksAs();

    CTExtensionList addNewExtLst();

    CTSurface addNewFloor();

    CTLegend addNewLegend();

    CTPivotFmts addNewPivotFmts();

    CTPlotArea addNewPlotArea();

    CTBoolean addNewPlotVisOnly();

    CTBoolean addNewShowDLblsOverMax();

    CTSurface addNewSideWall();

    CTTitle addNewTitle();

    CTView3D addNewView3D();

    CTBoolean getAutoTitleDeleted();

    CTSurface getBackWall();

    CTDispBlanksAs getDispBlanksAs();

    CTExtensionList getExtLst();

    CTSurface getFloor();

    CTLegend getLegend();

    CTPivotFmts getPivotFmts();

    CTPlotArea getPlotArea();

    CTBoolean getPlotVisOnly();

    CTBoolean getShowDLblsOverMax();

    CTSurface getSideWall();

    CTTitle getTitle();

    CTView3D getView3D();

    boolean isSetAutoTitleDeleted();

    boolean isSetBackWall();

    boolean isSetDispBlanksAs();

    boolean isSetExtLst();

    boolean isSetFloor();

    boolean isSetLegend();

    boolean isSetPivotFmts();

    boolean isSetPlotVisOnly();

    boolean isSetShowDLblsOverMax();

    boolean isSetSideWall();

    boolean isSetTitle();

    boolean isSetView3D();

    void setAutoTitleDeleted(CTBoolean cTBoolean);

    void setBackWall(CTSurface cTSurface);

    void setDispBlanksAs(CTDispBlanksAs cTDispBlanksAs);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFloor(CTSurface cTSurface);

    void setLegend(CTLegend cTLegend);

    void setPivotFmts(CTPivotFmts cTPivotFmts);

    void setPlotArea(CTPlotArea cTPlotArea);

    void setPlotVisOnly(CTBoolean cTBoolean);

    void setShowDLblsOverMax(CTBoolean cTBoolean);

    void setSideWall(CTSurface cTSurface);

    void setTitle(CTTitle cTTitle);

    void setView3D(CTView3D cTView3D);

    void unsetAutoTitleDeleted();

    void unsetBackWall();

    void unsetDispBlanksAs();

    void unsetExtLst();

    void unsetFloor();

    void unsetLegend();

    void unsetPivotFmts();

    void unsetPlotVisOnly();

    void unsetShowDLblsOverMax();

    void unsetSideWall();

    void unsetTitle();

    void unsetView3D();
}
