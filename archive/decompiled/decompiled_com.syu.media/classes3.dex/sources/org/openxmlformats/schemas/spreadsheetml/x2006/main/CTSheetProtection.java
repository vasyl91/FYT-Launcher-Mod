package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTSheetProtection extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTSheetProtection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheetprotection22f7type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSheetProtection newInstance() {
            return (CTSheetProtection) POIXMLTypeLoader.newInstance(CTSheetProtection.type, (XmlOptions) null);
        }

        public static CTSheetProtection newInstance(XmlOptions xmlOptions) {
            return (CTSheetProtection) POIXMLTypeLoader.newInstance(CTSheetProtection.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSheetProtection.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSheetProtection.type, xmlOptions);
        }

        public static CTSheetProtection parse(File file) throws XmlException, IOException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(file, CTSheetProtection.type, (XmlOptions) null);
        }

        public static CTSheetProtection parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(file, CTSheetProtection.type, xmlOptions);
        }

        public static CTSheetProtection parse(InputStream inputStream) throws XmlException, IOException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(inputStream, CTSheetProtection.type, (XmlOptions) null);
        }

        public static CTSheetProtection parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(inputStream, CTSheetProtection.type, xmlOptions);
        }

        public static CTSheetProtection parse(Reader reader) throws XmlException, IOException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(reader, CTSheetProtection.type, (XmlOptions) null);
        }

        public static CTSheetProtection parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(reader, CTSheetProtection.type, xmlOptions);
        }

        public static CTSheetProtection parse(String str) throws XmlException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(str, CTSheetProtection.type, (XmlOptions) null);
        }

        public static CTSheetProtection parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(str, CTSheetProtection.type, xmlOptions);
        }

        public static CTSheetProtection parse(URL url) throws XmlException, IOException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(url, CTSheetProtection.type, (XmlOptions) null);
        }

        public static CTSheetProtection parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(url, CTSheetProtection.type, xmlOptions);
        }

        public static CTSheetProtection parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(xMLStreamReader, CTSheetProtection.type, (XmlOptions) null);
        }

        public static CTSheetProtection parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(xMLStreamReader, CTSheetProtection.type, xmlOptions);
        }

        public static CTSheetProtection parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(xMLInputStream, CTSheetProtection.type, (XmlOptions) null);
        }

        public static CTSheetProtection parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(xMLInputStream, CTSheetProtection.type, xmlOptions);
        }

        public static CTSheetProtection parse(Node node) throws XmlException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(node, CTSheetProtection.type, (XmlOptions) null);
        }

        public static CTSheetProtection parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTSheetProtection) POIXMLTypeLoader.parse(node, CTSheetProtection.type, xmlOptions);
        }
    }

    boolean getAutoFilter();

    boolean getDeleteColumns();

    boolean getDeleteRows();

    boolean getFormatCells();

    boolean getFormatColumns();

    boolean getFormatRows();

    boolean getInsertColumns();

    boolean getInsertHyperlinks();

    boolean getInsertRows();

    boolean getObjects();

    byte[] getPassword();

    boolean getPivotTables();

    boolean getScenarios();

    boolean getSelectLockedCells();

    boolean getSelectUnlockedCells();

    boolean getSheet();

    boolean getSort();

    boolean isSetAutoFilter();

    boolean isSetDeleteColumns();

    boolean isSetDeleteRows();

    boolean isSetFormatCells();

    boolean isSetFormatColumns();

    boolean isSetFormatRows();

    boolean isSetInsertColumns();

    boolean isSetInsertHyperlinks();

    boolean isSetInsertRows();

    boolean isSetObjects();

    boolean isSetPassword();

    boolean isSetPivotTables();

    boolean isSetScenarios();

    boolean isSetSelectLockedCells();

    boolean isSetSelectUnlockedCells();

    boolean isSetSheet();

    boolean isSetSort();

    void setAutoFilter(boolean z);

    void setDeleteColumns(boolean z);

    void setDeleteRows(boolean z);

    void setFormatCells(boolean z);

    void setFormatColumns(boolean z);

    void setFormatRows(boolean z);

    void setInsertColumns(boolean z);

    void setInsertHyperlinks(boolean z);

    void setInsertRows(boolean z);

    void setObjects(boolean z);

    void setPassword(byte[] bArr);

    void setPivotTables(boolean z);

    void setScenarios(boolean z);

    void setSelectLockedCells(boolean z);

    void setSelectUnlockedCells(boolean z);

    void setSheet(boolean z);

    void setSort(boolean z);

    void unsetAutoFilter();

    void unsetDeleteColumns();

    void unsetDeleteRows();

    void unsetFormatCells();

    void unsetFormatColumns();

    void unsetFormatRows();

    void unsetInsertColumns();

    void unsetInsertHyperlinks();

    void unsetInsertRows();

    void unsetObjects();

    void unsetPassword();

    void unsetPivotTables();

    void unsetScenarios();

    void unsetSelectLockedCells();

    void unsetSelectUnlockedCells();

    void unsetSheet();

    void unsetSort();

    XmlBoolean xgetAutoFilter();

    XmlBoolean xgetDeleteColumns();

    XmlBoolean xgetDeleteRows();

    XmlBoolean xgetFormatCells();

    XmlBoolean xgetFormatColumns();

    XmlBoolean xgetFormatRows();

    XmlBoolean xgetInsertColumns();

    XmlBoolean xgetInsertHyperlinks();

    XmlBoolean xgetInsertRows();

    XmlBoolean xgetObjects();

    STUnsignedShortHex xgetPassword();

    XmlBoolean xgetPivotTables();

    XmlBoolean xgetScenarios();

    XmlBoolean xgetSelectLockedCells();

    XmlBoolean xgetSelectUnlockedCells();

    XmlBoolean xgetSheet();

    XmlBoolean xgetSort();

    void xsetAutoFilter(XmlBoolean xmlBoolean);

    void xsetDeleteColumns(XmlBoolean xmlBoolean);

    void xsetDeleteRows(XmlBoolean xmlBoolean);

    void xsetFormatCells(XmlBoolean xmlBoolean);

    void xsetFormatColumns(XmlBoolean xmlBoolean);

    void xsetFormatRows(XmlBoolean xmlBoolean);

    void xsetInsertColumns(XmlBoolean xmlBoolean);

    void xsetInsertHyperlinks(XmlBoolean xmlBoolean);

    void xsetInsertRows(XmlBoolean xmlBoolean);

    void xsetObjects(XmlBoolean xmlBoolean);

    void xsetPassword(STUnsignedShortHex sTUnsignedShortHex);

    void xsetPivotTables(XmlBoolean xmlBoolean);

    void xsetScenarios(XmlBoolean xmlBoolean);

    void xsetSelectLockedCells(XmlBoolean xmlBoolean);

    void xsetSelectUnlockedCells(XmlBoolean xmlBoolean);

    void xsetSheet(XmlBoolean xmlBoolean);

    void xsetSort(XmlBoolean xmlBoolean);
}
