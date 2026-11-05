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
public interface CTPath2DCubicBezierTo extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPath2DCubicBezierTo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpath2dcubicbezierto5a1etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DCubicBezierTo newInstance() {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.newInstance(CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo newInstance(XmlOptions xmlOptions) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.newInstance(CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(File file) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(file, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(file, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(inputStream, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(inputStream, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(Reader reader) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(reader, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(reader, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(String str) throws XmlException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(str, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(str, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(URL url) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(url, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(url, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(Node node) throws XmlException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(node, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(node, CTPath2DCubicBezierTo.type, xmlOptions);
        }
    }

    CTAdjPoint2D addNewPt();

    CTAdjPoint2D getPtArray(int i);

    CTAdjPoint2D[] getPtArray();

    List<CTAdjPoint2D> getPtList();

    CTAdjPoint2D insertNewPt(int i);

    void removePt(int i);

    void setPtArray(int i, CTAdjPoint2D cTAdjPoint2D);

    void setPtArray(CTAdjPoint2D[] cTAdjPoint2DArr);

    int sizeOfPtArray();
}
