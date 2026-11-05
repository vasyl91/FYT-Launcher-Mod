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
public interface CTAutoFilter extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTAutoFilter.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctautofiltera8d0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAutoFilter newInstance() {
            return (CTAutoFilter) POIXMLTypeLoader.newInstance(CTAutoFilter.type, (XmlOptions) null);
        }

        public static CTAutoFilter newInstance(XmlOptions xmlOptions) {
            return (CTAutoFilter) POIXMLTypeLoader.newInstance(CTAutoFilter.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAutoFilter.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAutoFilter.type, xmlOptions);
        }

        public static CTAutoFilter parse(File file) throws XmlException, IOException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(file, CTAutoFilter.type, (XmlOptions) null);
        }

        public static CTAutoFilter parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(file, CTAutoFilter.type, xmlOptions);
        }

        public static CTAutoFilter parse(InputStream inputStream) throws XmlException, IOException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(inputStream, CTAutoFilter.type, (XmlOptions) null);
        }

        public static CTAutoFilter parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(inputStream, CTAutoFilter.type, xmlOptions);
        }

        public static CTAutoFilter parse(Reader reader) throws XmlException, IOException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(reader, CTAutoFilter.type, (XmlOptions) null);
        }

        public static CTAutoFilter parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(reader, CTAutoFilter.type, xmlOptions);
        }

        public static CTAutoFilter parse(String str) throws XmlException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(str, CTAutoFilter.type, (XmlOptions) null);
        }

        public static CTAutoFilter parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(str, CTAutoFilter.type, xmlOptions);
        }

        public static CTAutoFilter parse(URL url) throws XmlException, IOException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(url, CTAutoFilter.type, (XmlOptions) null);
        }

        public static CTAutoFilter parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(url, CTAutoFilter.type, xmlOptions);
        }

        public static CTAutoFilter parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(xMLStreamReader, CTAutoFilter.type, (XmlOptions) null);
        }

        public static CTAutoFilter parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(xMLStreamReader, CTAutoFilter.type, xmlOptions);
        }

        public static CTAutoFilter parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(xMLInputStream, CTAutoFilter.type, (XmlOptions) null);
        }

        public static CTAutoFilter parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(xMLInputStream, CTAutoFilter.type, xmlOptions);
        }

        public static CTAutoFilter parse(Node node) throws XmlException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(node, CTAutoFilter.type, (XmlOptions) null);
        }

        public static CTAutoFilter parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTAutoFilter) POIXMLTypeLoader.parse(node, CTAutoFilter.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTFilterColumn addNewFilterColumn();

    CTSortState addNewSortState();

    CTExtensionList getExtLst();

    CTFilterColumn getFilterColumnArray(int i);

    CTFilterColumn[] getFilterColumnArray();

    List<CTFilterColumn> getFilterColumnList();

    String getRef();

    CTSortState getSortState();

    CTFilterColumn insertNewFilterColumn(int i);

    boolean isSetExtLst();

    boolean isSetRef();

    boolean isSetSortState();

    void removeFilterColumn(int i);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFilterColumnArray(int i, CTFilterColumn cTFilterColumn);

    void setFilterColumnArray(CTFilterColumn[] cTFilterColumnArr);

    void setRef(String str);

    void setSortState(CTSortState cTSortState);

    int sizeOfFilterColumnArray();

    void unsetExtLst();

    void unsetRef();

    void unsetSortState();

    STRef xgetRef();

    void xsetRef(STRef sTRef);
}
