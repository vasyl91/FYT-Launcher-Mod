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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTPath2D extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPath2D.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpath2d73d2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2D newInstance() {
            return (CTPath2D) POIXMLTypeLoader.newInstance(CTPath2D.type, (XmlOptions) null);
        }

        public static CTPath2D newInstance(XmlOptions xmlOptions) {
            return (CTPath2D) POIXMLTypeLoader.newInstance(CTPath2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2D.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2D.type, xmlOptions);
        }

        public static CTPath2D parse(File file) throws XmlException, IOException {
            return (CTPath2D) POIXMLTypeLoader.parse(file, CTPath2D.type, (XmlOptions) null);
        }

        public static CTPath2D parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2D) POIXMLTypeLoader.parse(file, CTPath2D.type, xmlOptions);
        }

        public static CTPath2D parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPath2D) POIXMLTypeLoader.parse(inputStream, CTPath2D.type, (XmlOptions) null);
        }

        public static CTPath2D parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2D) POIXMLTypeLoader.parse(inputStream, CTPath2D.type, xmlOptions);
        }

        public static CTPath2D parse(Reader reader) throws XmlException, IOException {
            return (CTPath2D) POIXMLTypeLoader.parse(reader, CTPath2D.type, (XmlOptions) null);
        }

        public static CTPath2D parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2D) POIXMLTypeLoader.parse(reader, CTPath2D.type, xmlOptions);
        }

        public static CTPath2D parse(String str) throws XmlException {
            return (CTPath2D) POIXMLTypeLoader.parse(str, CTPath2D.type, (XmlOptions) null);
        }

        public static CTPath2D parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2D) POIXMLTypeLoader.parse(str, CTPath2D.type, xmlOptions);
        }

        public static CTPath2D parse(URL url) throws XmlException, IOException {
            return (CTPath2D) POIXMLTypeLoader.parse(url, CTPath2D.type, (XmlOptions) null);
        }

        public static CTPath2D parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2D) POIXMLTypeLoader.parse(url, CTPath2D.type, xmlOptions);
        }

        public static CTPath2D parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPath2D) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2D.type, (XmlOptions) null);
        }

        public static CTPath2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2D) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2D.type, xmlOptions);
        }

        public static CTPath2D parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPath2D) POIXMLTypeLoader.parse(xMLInputStream, CTPath2D.type, (XmlOptions) null);
        }

        public static CTPath2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPath2D) POIXMLTypeLoader.parse(xMLInputStream, CTPath2D.type, xmlOptions);
        }

        public static CTPath2D parse(Node node) throws XmlException {
            return (CTPath2D) POIXMLTypeLoader.parse(node, CTPath2D.type, (XmlOptions) null);
        }

        public static CTPath2D parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2D) POIXMLTypeLoader.parse(node, CTPath2D.type, xmlOptions);
        }
    }

    CTPath2DArcTo addNewArcTo();

    CTPath2DClose addNewClose();

    CTPath2DCubicBezierTo addNewCubicBezTo();

    CTPath2DLineTo addNewLnTo();

    CTPath2DMoveTo addNewMoveTo();

    CTPath2DQuadBezierTo addNewQuadBezTo();

    CTPath2DArcTo getArcToArray(int i);

    CTPath2DArcTo[] getArcToArray();

    List<CTPath2DArcTo> getArcToList();

    CTPath2DClose getCloseArray(int i);

    CTPath2DClose[] getCloseArray();

    List<CTPath2DClose> getCloseList();

    CTPath2DCubicBezierTo getCubicBezToArray(int i);

    CTPath2DCubicBezierTo[] getCubicBezToArray();

    List<CTPath2DCubicBezierTo> getCubicBezToList();

    boolean getExtrusionOk();

    STPathFillMode$Enum getFill();

    long getH();

    CTPath2DLineTo getLnToArray(int i);

    CTPath2DLineTo[] getLnToArray();

    List<CTPath2DLineTo> getLnToList();

    CTPath2DMoveTo getMoveToArray(int i);

    CTPath2DMoveTo[] getMoveToArray();

    List<CTPath2DMoveTo> getMoveToList();

    CTPath2DQuadBezierTo getQuadBezToArray(int i);

    CTPath2DQuadBezierTo[] getQuadBezToArray();

    List<CTPath2DQuadBezierTo> getQuadBezToList();

    boolean getStroke();

    long getW();

    CTPath2DArcTo insertNewArcTo(int i);

    CTPath2DClose insertNewClose(int i);

    CTPath2DCubicBezierTo insertNewCubicBezTo(int i);

    CTPath2DLineTo insertNewLnTo(int i);

    CTPath2DMoveTo insertNewMoveTo(int i);

    CTPath2DQuadBezierTo insertNewQuadBezTo(int i);

    boolean isSetExtrusionOk();

    boolean isSetFill();

    boolean isSetH();

    boolean isSetStroke();

    boolean isSetW();

    void removeArcTo(int i);

    void removeClose(int i);

    void removeCubicBezTo(int i);

    void removeLnTo(int i);

    void removeMoveTo(int i);

    void removeQuadBezTo(int i);

    void setArcToArray(int i, CTPath2DArcTo cTPath2DArcTo);

    void setArcToArray(CTPath2DArcTo[] cTPath2DArcToArr);

    void setCloseArray(int i, CTPath2DClose cTPath2DClose);

    void setCloseArray(CTPath2DClose[] cTPath2DCloseArr);

    void setCubicBezToArray(int i, CTPath2DCubicBezierTo cTPath2DCubicBezierTo);

    void setCubicBezToArray(CTPath2DCubicBezierTo[] cTPath2DCubicBezierToArr);

    void setExtrusionOk(boolean z);

    void setFill(STPathFillMode$Enum sTPathFillMode$Enum);

    void setH(long j);

    void setLnToArray(int i, CTPath2DLineTo cTPath2DLineTo);

    void setLnToArray(CTPath2DLineTo[] cTPath2DLineToArr);

    void setMoveToArray(int i, CTPath2DMoveTo cTPath2DMoveTo);

    void setMoveToArray(CTPath2DMoveTo[] cTPath2DMoveToArr);

    void setQuadBezToArray(int i, CTPath2DQuadBezierTo cTPath2DQuadBezierTo);

    void setQuadBezToArray(CTPath2DQuadBezierTo[] cTPath2DQuadBezierToArr);

    void setStroke(boolean z);

    void setW(long j);

    int sizeOfArcToArray();

    int sizeOfCloseArray();

    int sizeOfCubicBezToArray();

    int sizeOfLnToArray();

    int sizeOfMoveToArray();

    int sizeOfQuadBezToArray();

    void unsetExtrusionOk();

    void unsetFill();

    void unsetH();

    void unsetStroke();

    void unsetW();

    XmlBoolean xgetExtrusionOk();

    STPathFillMode xgetFill();

    STPositiveCoordinate xgetH();

    XmlBoolean xgetStroke();

    STPositiveCoordinate xgetW();

    void xsetExtrusionOk(XmlBoolean xmlBoolean);

    void xsetFill(STPathFillMode sTPathFillMode);

    void xsetH(STPositiveCoordinate sTPositiveCoordinate);

    void xsetStroke(XmlBoolean xmlBoolean);

    void xsetW(STPositiveCoordinate sTPositiveCoordinate);
}
