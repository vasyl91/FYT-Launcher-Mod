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
public interface CTAdjustHandleList extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTAdjustHandleList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctadjusthandlelistfdb0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAdjustHandleList newInstance() {
            return (CTAdjustHandleList) POIXMLTypeLoader.newInstance(CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList newInstance(XmlOptions xmlOptions) {
            return (CTAdjustHandleList) POIXMLTypeLoader.newInstance(CTAdjustHandleList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(File file) throws XmlException, IOException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(file, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(file, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(inputStream, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(inputStream, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(Reader reader) throws XmlException, IOException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(reader, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(reader, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(String str) throws XmlException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(str, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(str, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(URL url) throws XmlException, IOException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(url, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(url, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(xMLStreamReader, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(xMLStreamReader, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(xMLInputStream, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(xMLInputStream, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(Node node) throws XmlException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(node, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(node, CTAdjustHandleList.type, xmlOptions);
        }
    }

    CTPolarAdjustHandle addNewAhPolar();

    CTXYAdjustHandle addNewAhXY();

    CTPolarAdjustHandle getAhPolarArray(int i);

    CTPolarAdjustHandle[] getAhPolarArray();

    List<CTPolarAdjustHandle> getAhPolarList();

    CTXYAdjustHandle getAhXYArray(int i);

    CTXYAdjustHandle[] getAhXYArray();

    List<CTXYAdjustHandle> getAhXYList();

    CTPolarAdjustHandle insertNewAhPolar(int i);

    CTXYAdjustHandle insertNewAhXY(int i);

    void removeAhPolar(int i);

    void removeAhXY(int i);

    void setAhPolarArray(int i, CTPolarAdjustHandle cTPolarAdjustHandle);

    void setAhPolarArray(CTPolarAdjustHandle[] cTPolarAdjustHandleArr);

    void setAhXYArray(int i, CTXYAdjustHandle cTXYAdjustHandle);

    void setAhXYArray(CTXYAdjustHandle[] cTXYAdjustHandleArr);

    int sizeOfAhPolarArray();

    int sizeOfAhXYArray();
}
