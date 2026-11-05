package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
public interface CTSingleXmlCells extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSingleXmlCells.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsinglexmlcells5a6btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSingleXmlCells newInstance() {
            return (CTSingleXmlCells) POIXMLTypeLoader.newInstance(CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells newInstance(XmlOptions xmlOptions) {
            return (CTSingleXmlCells) POIXMLTypeLoader.newInstance(CTSingleXmlCells.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(File file) throws XmlException, IOException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(file, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(file, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(inputStream, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(inputStream, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(Reader reader) throws XmlException, IOException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(reader, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(reader, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(String str) throws XmlException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(str, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(str, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(URL url) throws XmlException, IOException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(url, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(url, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(xMLStreamReader, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(xMLStreamReader, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(xMLInputStream, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(xMLInputStream, CTSingleXmlCells.type, xmlOptions);
        }

        public static CTSingleXmlCells parse(Node node) throws XmlException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(node, CTSingleXmlCells.type, (XmlOptions) null);
        }

        public static CTSingleXmlCells parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSingleXmlCells) POIXMLTypeLoader.parse(node, CTSingleXmlCells.type, xmlOptions);
        }
    }

    CTSingleXmlCell addNewSingleXmlCell();

    CTSingleXmlCell getSingleXmlCellArray(int i);

    CTSingleXmlCell[] getSingleXmlCellArray();

    List<CTSingleXmlCell> getSingleXmlCellList();

    CTSingleXmlCell insertNewSingleXmlCell(int i);

    void removeSingleXmlCell(int i);

    void setSingleXmlCellArray(int i, CTSingleXmlCell cTSingleXmlCell);

    void setSingleXmlCellArray(CTSingleXmlCell[] cTSingleXmlCellArr);

    int sizeOfSingleXmlCellArray();
}
