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
public interface CTGeomGuideList extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTGeomGuideList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgeomguidelist364ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGeomGuideList newInstance() {
            return (CTGeomGuideList) POIXMLTypeLoader.newInstance(CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList newInstance(XmlOptions xmlOptions) {
            return (CTGeomGuideList) POIXMLTypeLoader.newInstance(CTGeomGuideList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(File file) throws XmlException, IOException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(file, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(file, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(inputStream, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(inputStream, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(Reader reader) throws XmlException, IOException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(reader, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(reader, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(String str) throws XmlException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(str, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(str, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(URL url) throws XmlException, IOException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(url, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(url, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(xMLStreamReader, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(xMLStreamReader, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(xMLInputStream, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(xMLInputStream, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(Node node) throws XmlException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(node, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(node, CTGeomGuideList.type, xmlOptions);
        }
    }

    CTGeomGuide addNewGd();

    CTGeomGuide getGdArray(int i);

    CTGeomGuide[] getGdArray();

    List<CTGeomGuide> getGdList();

    CTGeomGuide insertNewGd(int i);

    void removeGd(int i);

    void setGdArray(int i, CTGeomGuide cTGeomGuide);

    void setGdArray(CTGeomGuide[] cTGeomGuideArr);

    int sizeOfGdArray();
}
