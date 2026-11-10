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
public interface CTTableRow extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTableRow.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablerow4ac7type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableRow newInstance() {
            return (CTTableRow) POIXMLTypeLoader.newInstance(CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow newInstance(XmlOptions xmlOptions) {
            return (CTTableRow) POIXMLTypeLoader.newInstance(CTTableRow.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableRow.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(File file) throws XmlException, IOException {
            return (CTTableRow) POIXMLTypeLoader.parse(file, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableRow) POIXMLTypeLoader.parse(file, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableRow) POIXMLTypeLoader.parse(inputStream, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableRow) POIXMLTypeLoader.parse(inputStream, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(Reader reader) throws XmlException, IOException {
            return (CTTableRow) POIXMLTypeLoader.parse(reader, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableRow) POIXMLTypeLoader.parse(reader, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(String str) throws XmlException {
            return (CTTableRow) POIXMLTypeLoader.parse(str, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableRow) POIXMLTypeLoader.parse(str, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(URL url) throws XmlException, IOException {
            return (CTTableRow) POIXMLTypeLoader.parse(url, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableRow) POIXMLTypeLoader.parse(url, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableRow) POIXMLTypeLoader.parse(xMLStreamReader, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableRow) POIXMLTypeLoader.parse(xMLStreamReader, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTableRow) POIXMLTypeLoader.parse(xMLInputStream, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTableRow) POIXMLTypeLoader.parse(xMLInputStream, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(Node node) throws XmlException {
            return (CTTableRow) POIXMLTypeLoader.parse(node, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableRow) POIXMLTypeLoader.parse(node, CTTableRow.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTTableCell addNewTc();

    CTOfficeArtExtensionList getExtLst();

    long getH();

    CTTableCell getTcArray(int i);

    CTTableCell[] getTcArray();

    List<CTTableCell> getTcList();

    CTTableCell insertNewTc(int i);

    boolean isSetExtLst();

    void removeTc(int i);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setH(long j);

    void setTcArray(int i, CTTableCell cTTableCell);

    void setTcArray(CTTableCell[] cTTableCellArr);

    int sizeOfTcArray();

    void unsetExtLst();

    STCoordinate xgetH();

    void xsetH(STCoordinate sTCoordinate);
}
