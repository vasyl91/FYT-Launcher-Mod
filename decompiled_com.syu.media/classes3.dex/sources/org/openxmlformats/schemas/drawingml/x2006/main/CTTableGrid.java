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
public interface CTTableGrid extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTableGrid.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablegrid69a5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableGrid newInstance() {
            return (CTTableGrid) POIXMLTypeLoader.newInstance(CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid newInstance(XmlOptions xmlOptions) {
            return (CTTableGrid) POIXMLTypeLoader.newInstance(CTTableGrid.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableGrid.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(File file) throws XmlException, IOException {
            return (CTTableGrid) POIXMLTypeLoader.parse(file, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableGrid) POIXMLTypeLoader.parse(file, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableGrid) POIXMLTypeLoader.parse(inputStream, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableGrid) POIXMLTypeLoader.parse(inputStream, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(Reader reader) throws XmlException, IOException {
            return (CTTableGrid) POIXMLTypeLoader.parse(reader, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableGrid) POIXMLTypeLoader.parse(reader, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(String str) throws XmlException {
            return (CTTableGrid) POIXMLTypeLoader.parse(str, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableGrid) POIXMLTypeLoader.parse(str, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(URL url) throws XmlException, IOException {
            return (CTTableGrid) POIXMLTypeLoader.parse(url, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableGrid) POIXMLTypeLoader.parse(url, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableGrid) POIXMLTypeLoader.parse(xMLStreamReader, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableGrid) POIXMLTypeLoader.parse(xMLStreamReader, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTableGrid) POIXMLTypeLoader.parse(xMLInputStream, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTableGrid) POIXMLTypeLoader.parse(xMLInputStream, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(Node node) throws XmlException {
            return (CTTableGrid) POIXMLTypeLoader.parse(node, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableGrid) POIXMLTypeLoader.parse(node, CTTableGrid.type, xmlOptions);
        }
    }

    CTTableCol addNewGridCol();

    CTTableCol getGridColArray(int i);

    CTTableCol[] getGridColArray();

    List<CTTableCol> getGridColList();

    CTTableCol insertNewGridCol(int i);

    void removeGridCol(int i);

    void setGridColArray(int i, CTTableCol cTTableCol);

    void setGridColArray(CTTableCol[] cTTableColArr);

    int sizeOfGridColArray();
}
