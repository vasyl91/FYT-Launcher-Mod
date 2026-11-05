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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTable extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTable.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttable736dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTable newInstance() {
            return (CTTable) POIXMLTypeLoader.newInstance(CTTable.type, (XmlOptions) null);
        }

        public static CTTable newInstance(XmlOptions xmlOptions) {
            return (CTTable) POIXMLTypeLoader.newInstance(CTTable.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTable.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTable.type, xmlOptions);
        }

        public static CTTable parse(File file) throws XmlException, IOException {
            return (CTTable) POIXMLTypeLoader.parse(file, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTable) POIXMLTypeLoader.parse(file, CTTable.type, xmlOptions);
        }

        public static CTTable parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTable) POIXMLTypeLoader.parse(inputStream, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTable) POIXMLTypeLoader.parse(inputStream, CTTable.type, xmlOptions);
        }

        public static CTTable parse(Reader reader) throws XmlException, IOException {
            return (CTTable) POIXMLTypeLoader.parse(reader, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTable) POIXMLTypeLoader.parse(reader, CTTable.type, xmlOptions);
        }

        public static CTTable parse(String str) throws XmlException {
            return (CTTable) POIXMLTypeLoader.parse(str, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTable) POIXMLTypeLoader.parse(str, CTTable.type, xmlOptions);
        }

        public static CTTable parse(URL url) throws XmlException, IOException {
            return (CTTable) POIXMLTypeLoader.parse(url, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTable) POIXMLTypeLoader.parse(url, CTTable.type, xmlOptions);
        }

        public static CTTable parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTable) POIXMLTypeLoader.parse(xMLStreamReader, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTable) POIXMLTypeLoader.parse(xMLStreamReader, CTTable.type, xmlOptions);
        }

        public static CTTable parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTable) POIXMLTypeLoader.parse(xMLInputStream, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTable) POIXMLTypeLoader.parse(xMLInputStream, CTTable.type, xmlOptions);
        }

        public static CTTable parse(Node node) throws XmlException {
            return (CTTable) POIXMLTypeLoader.parse(node, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTable) POIXMLTypeLoader.parse(node, CTTable.type, xmlOptions);
        }
    }

    CTAutoFilter addNewAutoFilter();

    CTExtensionList addNewExtLst();

    CTSortState addNewSortState();

    CTTableColumns addNewTableColumns();

    CTTableStyleInfo addNewTableStyleInfo();

    CTAutoFilter getAutoFilter();

    String getComment();

    long getConnectionId();

    String getDataCellStyle();

    long getDataDxfId();

    String getDisplayName();

    CTExtensionList getExtLst();

    long getHeaderRowBorderDxfId();

    String getHeaderRowCellStyle();

    long getHeaderRowCount();

    long getHeaderRowDxfId();

    long getId();

    boolean getInsertRow();

    boolean getInsertRowShift();

    String getName();

    boolean getPublished();

    String getRef();

    CTSortState getSortState();

    long getTableBorderDxfId();

    CTTableColumns getTableColumns();

    CTTableStyleInfo getTableStyleInfo();

    STTableType$Enum getTableType();

    long getTotalsRowBorderDxfId();

    String getTotalsRowCellStyle();

    long getTotalsRowCount();

    long getTotalsRowDxfId();

    boolean getTotalsRowShown();

    boolean isSetAutoFilter();

    boolean isSetComment();

    boolean isSetConnectionId();

    boolean isSetDataCellStyle();

    boolean isSetDataDxfId();

    boolean isSetExtLst();

    boolean isSetHeaderRowBorderDxfId();

    boolean isSetHeaderRowCellStyle();

    boolean isSetHeaderRowCount();

    boolean isSetHeaderRowDxfId();

    boolean isSetInsertRow();

    boolean isSetInsertRowShift();

    boolean isSetName();

    boolean isSetPublished();

    boolean isSetSortState();

    boolean isSetTableBorderDxfId();

    boolean isSetTableStyleInfo();

    boolean isSetTableType();

    boolean isSetTotalsRowBorderDxfId();

    boolean isSetTotalsRowCellStyle();

    boolean isSetTotalsRowCount();

    boolean isSetTotalsRowDxfId();

    boolean isSetTotalsRowShown();

    void setAutoFilter(CTAutoFilter cTAutoFilter);

    void setComment(String str);

    void setConnectionId(long j);

    void setDataCellStyle(String str);

    void setDataDxfId(long j);

    void setDisplayName(String str);

    void setExtLst(CTExtensionList cTExtensionList);

    void setHeaderRowBorderDxfId(long j);

    void setHeaderRowCellStyle(String str);

    void setHeaderRowCount(long j);

    void setHeaderRowDxfId(long j);

    void setId(long j);

    void setInsertRow(boolean z);

    void setInsertRowShift(boolean z);

    void setName(String str);

    void setPublished(boolean z);

    void setRef(String str);

    void setSortState(CTSortState cTSortState);

    void setTableBorderDxfId(long j);

    void setTableColumns(CTTableColumns cTTableColumns);

    void setTableStyleInfo(CTTableStyleInfo cTTableStyleInfo);

    void setTableType(STTableType$Enum sTTableType$Enum);

    void setTotalsRowBorderDxfId(long j);

    void setTotalsRowCellStyle(String str);

    void setTotalsRowCount(long j);

    void setTotalsRowDxfId(long j);

    void setTotalsRowShown(boolean z);

    void unsetAutoFilter();

    void unsetComment();

    void unsetConnectionId();

    void unsetDataCellStyle();

    void unsetDataDxfId();

    void unsetExtLst();

    void unsetHeaderRowBorderDxfId();

    void unsetHeaderRowCellStyle();

    void unsetHeaderRowCount();

    void unsetHeaderRowDxfId();

    void unsetInsertRow();

    void unsetInsertRowShift();

    void unsetName();

    void unsetPublished();

    void unsetSortState();

    void unsetTableBorderDxfId();

    void unsetTableStyleInfo();

    void unsetTableType();

    void unsetTotalsRowBorderDxfId();

    void unsetTotalsRowCellStyle();

    void unsetTotalsRowCount();

    void unsetTotalsRowDxfId();

    void unsetTotalsRowShown();

    STXstring xgetComment();

    XmlUnsignedInt xgetConnectionId();

    STXstring xgetDataCellStyle();

    STDxfId xgetDataDxfId();

    STXstring xgetDisplayName();

    STDxfId xgetHeaderRowBorderDxfId();

    STXstring xgetHeaderRowCellStyle();

    XmlUnsignedInt xgetHeaderRowCount();

    STDxfId xgetHeaderRowDxfId();

    XmlUnsignedInt xgetId();

    XmlBoolean xgetInsertRow();

    XmlBoolean xgetInsertRowShift();

    STXstring xgetName();

    XmlBoolean xgetPublished();

    STRef xgetRef();

    STDxfId xgetTableBorderDxfId();

    STTableType xgetTableType();

    STDxfId xgetTotalsRowBorderDxfId();

    STXstring xgetTotalsRowCellStyle();

    XmlUnsignedInt xgetTotalsRowCount();

    STDxfId xgetTotalsRowDxfId();

    XmlBoolean xgetTotalsRowShown();

    void xsetComment(STXstring sTXstring);

    void xsetConnectionId(XmlUnsignedInt xmlUnsignedInt);

    void xsetDataCellStyle(STXstring sTXstring);

    void xsetDataDxfId(STDxfId sTDxfId);

    void xsetDisplayName(STXstring sTXstring);

    void xsetHeaderRowBorderDxfId(STDxfId sTDxfId);

    void xsetHeaderRowCellStyle(STXstring sTXstring);

    void xsetHeaderRowCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetHeaderRowDxfId(STDxfId sTDxfId);

    void xsetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetInsertRow(XmlBoolean xmlBoolean);

    void xsetInsertRowShift(XmlBoolean xmlBoolean);

    void xsetName(STXstring sTXstring);

    void xsetPublished(XmlBoolean xmlBoolean);

    void xsetRef(STRef sTRef);

    void xsetTableBorderDxfId(STDxfId sTDxfId);

    void xsetTableType(STTableType sTTableType);

    void xsetTotalsRowBorderDxfId(STDxfId sTDxfId);

    void xsetTotalsRowCellStyle(STXstring sTXstring);

    void xsetTotalsRowCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetTotalsRowDxfId(STDxfId sTDxfId);

    void xsetTotalsRowShown(XmlBoolean xmlBoolean);
}
