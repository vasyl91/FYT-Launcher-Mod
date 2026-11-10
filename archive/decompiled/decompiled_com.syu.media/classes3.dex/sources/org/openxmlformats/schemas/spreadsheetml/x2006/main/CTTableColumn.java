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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTTableColumn extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTTableColumn.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablecolumn08a3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableColumn newInstance() {
            return (CTTableColumn) POIXMLTypeLoader.newInstance(CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn newInstance(XmlOptions xmlOptions) {
            return (CTTableColumn) POIXMLTypeLoader.newInstance(CTTableColumn.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableColumn.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(File file) throws XmlException, IOException {
            return (CTTableColumn) POIXMLTypeLoader.parse(file, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumn) POIXMLTypeLoader.parse(file, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(InputStream inputStream) throws XmlException, IOException {
            return (CTTableColumn) POIXMLTypeLoader.parse(inputStream, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumn) POIXMLTypeLoader.parse(inputStream, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(Reader reader) throws XmlException, IOException {
            return (CTTableColumn) POIXMLTypeLoader.parse(reader, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumn) POIXMLTypeLoader.parse(reader, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(String str) throws XmlException {
            return (CTTableColumn) POIXMLTypeLoader.parse(str, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTTableColumn) POIXMLTypeLoader.parse(str, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(URL url) throws XmlException, IOException {
            return (CTTableColumn) POIXMLTypeLoader.parse(url, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTTableColumn) POIXMLTypeLoader.parse(url, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTTableColumn) POIXMLTypeLoader.parse(xMLStreamReader, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTTableColumn) POIXMLTypeLoader.parse(xMLStreamReader, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTTableColumn) POIXMLTypeLoader.parse(xMLInputStream, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTTableColumn) POIXMLTypeLoader.parse(xMLInputStream, CTTableColumn.type, xmlOptions);
        }

        public static CTTableColumn parse(Node node) throws XmlException {
            return (CTTableColumn) POIXMLTypeLoader.parse(node, CTTableColumn.type, (XmlOptions) null);
        }

        public static CTTableColumn parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTTableColumn) POIXMLTypeLoader.parse(node, CTTableColumn.type, xmlOptions);
        }
    }

    CTTableFormula addNewCalculatedColumnFormula();

    CTExtensionList addNewExtLst();

    CTTableFormula addNewTotalsRowFormula();

    CTXmlColumnPr addNewXmlColumnPr();

    CTTableFormula getCalculatedColumnFormula();

    String getDataCellStyle();

    long getDataDxfId();

    CTExtensionList getExtLst();

    String getHeaderRowCellStyle();

    long getHeaderRowDxfId();

    long getId();

    String getName();

    long getQueryTableFieldId();

    String getTotalsRowCellStyle();

    long getTotalsRowDxfId();

    CTTableFormula getTotalsRowFormula();

    STTotalsRowFunction$Enum getTotalsRowFunction();

    String getTotalsRowLabel();

    String getUniqueName();

    CTXmlColumnPr getXmlColumnPr();

    boolean isSetCalculatedColumnFormula();

    boolean isSetDataCellStyle();

    boolean isSetDataDxfId();

    boolean isSetExtLst();

    boolean isSetHeaderRowCellStyle();

    boolean isSetHeaderRowDxfId();

    boolean isSetQueryTableFieldId();

    boolean isSetTotalsRowCellStyle();

    boolean isSetTotalsRowDxfId();

    boolean isSetTotalsRowFormula();

    boolean isSetTotalsRowFunction();

    boolean isSetTotalsRowLabel();

    boolean isSetUniqueName();

    boolean isSetXmlColumnPr();

    void setCalculatedColumnFormula(CTTableFormula cTTableFormula);

    void setDataCellStyle(String str);

    void setDataDxfId(long j);

    void setExtLst(CTExtensionList cTExtensionList);

    void setHeaderRowCellStyle(String str);

    void setHeaderRowDxfId(long j);

    void setId(long j);

    void setName(String str);

    void setQueryTableFieldId(long j);

    void setTotalsRowCellStyle(String str);

    void setTotalsRowDxfId(long j);

    void setTotalsRowFormula(CTTableFormula cTTableFormula);

    void setTotalsRowFunction(STTotalsRowFunction$Enum sTTotalsRowFunction$Enum);

    void setTotalsRowLabel(String str);

    void setUniqueName(String str);

    void setXmlColumnPr(CTXmlColumnPr cTXmlColumnPr);

    void unsetCalculatedColumnFormula();

    void unsetDataCellStyle();

    void unsetDataDxfId();

    void unsetExtLst();

    void unsetHeaderRowCellStyle();

    void unsetHeaderRowDxfId();

    void unsetQueryTableFieldId();

    void unsetTotalsRowCellStyle();

    void unsetTotalsRowDxfId();

    void unsetTotalsRowFormula();

    void unsetTotalsRowFunction();

    void unsetTotalsRowLabel();

    void unsetUniqueName();

    void unsetXmlColumnPr();

    STXstring xgetDataCellStyle();

    STDxfId xgetDataDxfId();

    STXstring xgetHeaderRowCellStyle();

    STDxfId xgetHeaderRowDxfId();

    XmlUnsignedInt xgetId();

    STXstring xgetName();

    XmlUnsignedInt xgetQueryTableFieldId();

    STXstring xgetTotalsRowCellStyle();

    STDxfId xgetTotalsRowDxfId();

    STTotalsRowFunction xgetTotalsRowFunction();

    STXstring xgetTotalsRowLabel();

    STXstring xgetUniqueName();

    void xsetDataCellStyle(STXstring sTXstring);

    void xsetDataDxfId(STDxfId sTDxfId);

    void xsetHeaderRowCellStyle(STXstring sTXstring);

    void xsetHeaderRowDxfId(STDxfId sTDxfId);

    void xsetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(STXstring sTXstring);

    void xsetQueryTableFieldId(XmlUnsignedInt xmlUnsignedInt);

    void xsetTotalsRowCellStyle(STXstring sTXstring);

    void xsetTotalsRowDxfId(STDxfId sTDxfId);

    void xsetTotalsRowFunction(STTotalsRowFunction sTTotalsRowFunction);

    void xsetTotalsRowLabel(STXstring sTXstring);

    void xsetUniqueName(STXstring sTXstring);
}
