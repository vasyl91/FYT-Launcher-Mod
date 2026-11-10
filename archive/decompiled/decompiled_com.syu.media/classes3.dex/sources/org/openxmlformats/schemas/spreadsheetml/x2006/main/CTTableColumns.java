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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTableColumns extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTableColumns.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablecolumnsebb8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableColumns newInstance() {
            return (CTTableColumns) POIXMLTypeLoader.newInstance(CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns newInstance(XmlOptions xmlOptions) {
            return (CTTableColumns) POIXMLTypeLoader.newInstance(CTTableColumns.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableColumns.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(File file) throws XmlException, IOException {
            return (CTTableColumns) POIXMLTypeLoader.parse(file, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumns) POIXMLTypeLoader.parse(file, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableColumns) POIXMLTypeLoader.parse(inputStream, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumns) POIXMLTypeLoader.parse(inputStream, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(Reader reader) throws XmlException, IOException {
            return (CTTableColumns) POIXMLTypeLoader.parse(reader, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumns) POIXMLTypeLoader.parse(reader, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(String str) throws XmlException {
            return (CTTableColumns) POIXMLTypeLoader.parse(str, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableColumns) POIXMLTypeLoader.parse(str, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(URL url) throws XmlException, IOException {
            return (CTTableColumns) POIXMLTypeLoader.parse(url, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumns) POIXMLTypeLoader.parse(url, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableColumns) POIXMLTypeLoader.parse(xMLStreamReader, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableColumns) POIXMLTypeLoader.parse(xMLStreamReader, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTableColumns) POIXMLTypeLoader.parse(xMLInputStream, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTableColumns) POIXMLTypeLoader.parse(xMLInputStream, CTTableColumns.type, xmlOptions);
        }

        public static CTTableColumns parse(Node node) throws XmlException {
            return (CTTableColumns) POIXMLTypeLoader.parse(node, CTTableColumns.type, (XmlOptions) null);
        }

        public static CTTableColumns parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableColumns) POIXMLTypeLoader.parse(node, CTTableColumns.type, xmlOptions);
        }
    }

    CTTableColumn addNewTableColumn();

    long getCount();

    CTTableColumn getTableColumnArray(int i);

    CTTableColumn[] getTableColumnArray();

    List<CTTableColumn> getTableColumnList();

    CTTableColumn insertNewTableColumn(int i);

    boolean isSetCount();

    void removeTableColumn(int i);

    void setCount(long j);

    void setTableColumnArray(int i, CTTableColumn cTTableColumn);

    void setTableColumnArray(CTTableColumn[] cTTableColumnArr);

    int sizeOfTableColumnArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
