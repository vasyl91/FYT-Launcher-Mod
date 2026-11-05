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
public interface CTPath2DList extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPath2DList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpath2dlistb010type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DList newInstance() {
            return (CTPath2DList) POIXMLTypeLoader.newInstance(CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList newInstance(XmlOptions xmlOptions) {
            return (CTPath2DList) POIXMLTypeLoader.newInstance(CTPath2DList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DList.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(File file) throws XmlException, IOException {
            return (CTPath2DList) POIXMLTypeLoader.parse(file, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DList) POIXMLTypeLoader.parse(file, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPath2DList) POIXMLTypeLoader.parse(inputStream, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DList) POIXMLTypeLoader.parse(inputStream, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(Reader reader) throws XmlException, IOException {
            return (CTPath2DList) POIXMLTypeLoader.parse(reader, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DList) POIXMLTypeLoader.parse(reader, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(String str) throws XmlException {
            return (CTPath2DList) POIXMLTypeLoader.parse(str, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DList) POIXMLTypeLoader.parse(str, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(URL url) throws XmlException, IOException {
            return (CTPath2DList) POIXMLTypeLoader.parse(url, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPath2DList) POIXMLTypeLoader.parse(url, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPath2DList) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DList) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPath2DList) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPath2DList) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(Node node) throws XmlException {
            return (CTPath2DList) POIXMLTypeLoader.parse(node, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPath2DList) POIXMLTypeLoader.parse(node, CTPath2DList.type, xmlOptions);
        }
    }

    CTPath2D addNewPath();

    CTPath2D getPathArray(int i);

    CTPath2D[] getPathArray();

    List<CTPath2D> getPathList();

    CTPath2D insertNewPath(int i);

    void removePath(int i);

    void setPathArray(int i, CTPath2D cTPath2D);

    void setPathArray(CTPath2D[] cTPath2DArr);

    int sizeOfPathArray();
}
