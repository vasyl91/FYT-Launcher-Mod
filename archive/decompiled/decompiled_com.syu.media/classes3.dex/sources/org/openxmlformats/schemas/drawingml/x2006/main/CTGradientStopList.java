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
public interface CTGradientStopList extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTGradientStopList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgradientstoplist7eabtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGradientStopList newInstance() {
            return (CTGradientStopList) POIXMLTypeLoader.newInstance(CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList newInstance(XmlOptions xmlOptions) {
            return (CTGradientStopList) POIXMLTypeLoader.newInstance(CTGradientStopList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGradientStopList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(File file) throws XmlException, IOException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(file, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(file, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(inputStream, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(inputStream, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(Reader reader) throws XmlException, IOException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(reader, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(reader, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(String str) throws XmlException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(str, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(str, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(URL url) throws XmlException, IOException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(url, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(url, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(xMLStreamReader, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(xMLStreamReader, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(xMLInputStream, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(xMLInputStream, CTGradientStopList.type, xmlOptions);
        }

        public static CTGradientStopList parse(Node node) throws XmlException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(node, CTGradientStopList.type, (XmlOptions) null);
        }

        public static CTGradientStopList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGradientStopList) POIXMLTypeLoader.parse(node, CTGradientStopList.type, xmlOptions);
        }
    }

    CTGradientStop addNewGs();

    CTGradientStop getGsArray(int i);

    CTGradientStop[] getGsArray();

    List<CTGradientStop> getGsList();

    CTGradientStop insertNewGs(int i);

    void removeGs(int i);

    void setGsArray(int i, CTGradientStop cTGradientStop);

    void setGsArray(CTGradientStop[] cTGradientStopArr);

    int sizeOfGsArray();
}
