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
public interface CTSheetData extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSheetData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheetdata8408type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheetData newInstance() {
            return (CTSheetData) POIXMLTypeLoader.newInstance(CTSheetData.type, (XmlOptions) null);
        }

        public static CTSheetData newInstance(XmlOptions xmlOptions) {
            return (CTSheetData) POIXMLTypeLoader.newInstance(CTSheetData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSheetData.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSheetData.type, xmlOptions);
        }

        public static CTSheetData parse(File file) throws XmlException, IOException {
            return (CTSheetData) POIXMLTypeLoader.parse(file, CTSheetData.type, (XmlOptions) null);
        }

        public static CTSheetData parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetData) POIXMLTypeLoader.parse(file, CTSheetData.type, xmlOptions);
        }

        public static CTSheetData parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheetData) POIXMLTypeLoader.parse(inputStream, CTSheetData.type, (XmlOptions) null);
        }

        public static CTSheetData parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetData) POIXMLTypeLoader.parse(inputStream, CTSheetData.type, xmlOptions);
        }

        public static CTSheetData parse(Reader reader) throws XmlException, IOException {
            return (CTSheetData) POIXMLTypeLoader.parse(reader, CTSheetData.type, (XmlOptions) null);
        }

        public static CTSheetData parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetData) POIXMLTypeLoader.parse(reader, CTSheetData.type, xmlOptions);
        }

        public static CTSheetData parse(String str) throws XmlException {
            return (CTSheetData) POIXMLTypeLoader.parse(str, CTSheetData.type, (XmlOptions) null);
        }

        public static CTSheetData parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetData) POIXMLTypeLoader.parse(str, CTSheetData.type, xmlOptions);
        }

        public static CTSheetData parse(URL url) throws XmlException, IOException {
            return (CTSheetData) POIXMLTypeLoader.parse(url, CTSheetData.type, (XmlOptions) null);
        }

        public static CTSheetData parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetData) POIXMLTypeLoader.parse(url, CTSheetData.type, xmlOptions);
        }

        public static CTSheetData parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheetData) POIXMLTypeLoader.parse(xMLStreamReader, CTSheetData.type, (XmlOptions) null);
        }

        public static CTSheetData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetData) POIXMLTypeLoader.parse(xMLStreamReader, CTSheetData.type, xmlOptions);
        }

        public static CTSheetData parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSheetData) POIXMLTypeLoader.parse(xMLInputStream, CTSheetData.type, (XmlOptions) null);
        }

        public static CTSheetData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSheetData) POIXMLTypeLoader.parse(xMLInputStream, CTSheetData.type, xmlOptions);
        }

        public static CTSheetData parse(Node node) throws XmlException {
            return (CTSheetData) POIXMLTypeLoader.parse(node, CTSheetData.type, (XmlOptions) null);
        }

        public static CTSheetData parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetData) POIXMLTypeLoader.parse(node, CTSheetData.type, xmlOptions);
        }
    }

    CTRow addNewRow();

    CTRow getRowArray(int i);

    CTRow[] getRowArray();

    List<CTRow> getRowList();

    CTRow insertNewRow(int i);

    void removeRow(int i);

    void setRowArray(int i, CTRow cTRow);

    void setRowArray(CTRow[] cTRowArr);

    int sizeOfRowArray();
}
