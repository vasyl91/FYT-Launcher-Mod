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
public interface CTWorksheet extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTWorksheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctworksheet530dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTWorksheet newInstance() {
            return (CTWorksheet) POIXMLTypeLoader.newInstance(CTWorksheet.type, (XmlOptions) null);
        }

        public static CTWorksheet newInstance(XmlOptions xmlOptions) {
            return (CTWorksheet) POIXMLTypeLoader.newInstance(CTWorksheet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTWorksheet.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTWorksheet.type, xmlOptions);
        }

        public static CTWorksheet parse(File file) throws XmlException, IOException {
            return (CTWorksheet) POIXMLTypeLoader.parse(file, CTWorksheet.type, (XmlOptions) null);
        }

        public static CTWorksheet parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorksheet) POIXMLTypeLoader.parse(file, CTWorksheet.type, xmlOptions);
        }

        public static CTWorksheet parse(InputStream inputStream) throws XmlException, IOException {
            return (CTWorksheet) POIXMLTypeLoader.parse(inputStream, CTWorksheet.type, (XmlOptions) null);
        }

        public static CTWorksheet parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorksheet) POIXMLTypeLoader.parse(inputStream, CTWorksheet.type, xmlOptions);
        }

        public static CTWorksheet parse(Reader reader) throws XmlException, IOException {
            return (CTWorksheet) POIXMLTypeLoader.parse(reader, CTWorksheet.type, (XmlOptions) null);
        }

        public static CTWorksheet parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorksheet) POIXMLTypeLoader.parse(reader, CTWorksheet.type, xmlOptions);
        }

        public static CTWorksheet parse(String str) throws XmlException {
            return (CTWorksheet) POIXMLTypeLoader.parse(str, CTWorksheet.type, (XmlOptions) null);
        }

        public static CTWorksheet parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTWorksheet) POIXMLTypeLoader.parse(str, CTWorksheet.type, xmlOptions);
        }

        public static CTWorksheet parse(URL url) throws XmlException, IOException {
            return (CTWorksheet) POIXMLTypeLoader.parse(url, CTWorksheet.type, (XmlOptions) null);
        }

        public static CTWorksheet parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorksheet) POIXMLTypeLoader.parse(url, CTWorksheet.type, xmlOptions);
        }

        public static CTWorksheet parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTWorksheet) POIXMLTypeLoader.parse(xMLStreamReader, CTWorksheet.type, (XmlOptions) null);
        }

        public static CTWorksheet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTWorksheet) POIXMLTypeLoader.parse(xMLStreamReader, CTWorksheet.type, xmlOptions);
        }

        public static CTWorksheet parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTWorksheet) POIXMLTypeLoader.parse(xMLInputStream, CTWorksheet.type, (XmlOptions) null);
        }

        public static CTWorksheet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTWorksheet) POIXMLTypeLoader.parse(xMLInputStream, CTWorksheet.type, xmlOptions);
        }

        public static CTWorksheet parse(Node node) throws XmlException {
            return (CTWorksheet) POIXMLTypeLoader.parse(node, CTWorksheet.type, (XmlOptions) null);
        }

        public static CTWorksheet parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTWorksheet) POIXMLTypeLoader.parse(node, CTWorksheet.type, xmlOptions);
        }
    }

    CTAutoFilter addNewAutoFilter();

    CTCellWatches addNewCellWatches();

    CTPageBreak addNewColBreaks();

    CTCols addNewCols();

    CTConditionalFormatting addNewConditionalFormatting();

    CTControls addNewControls();

    CTCustomProperties addNewCustomProperties();

    CTCustomSheetViews addNewCustomSheetViews();

    CTDataConsolidate addNewDataConsolidate();

    CTDataValidations addNewDataValidations();

    CTSheetDimension addNewDimension();

    CTDrawing addNewDrawing();

    CTExtensionList addNewExtLst();

    CTHeaderFooter addNewHeaderFooter();

    CTHyperlinks addNewHyperlinks();

    CTIgnoredErrors addNewIgnoredErrors();

    CTLegacyDrawing addNewLegacyDrawing();

    CTLegacyDrawing addNewLegacyDrawingHF();

    CTMergeCells addNewMergeCells();

    CTOleObjects addNewOleObjects();

    CTPageMargins addNewPageMargins();

    CTPageSetup addNewPageSetup();

    CTPhoneticPr addNewPhoneticPr();

    CTSheetBackgroundPicture addNewPicture();

    CTPrintOptions addNewPrintOptions();

    CTProtectedRanges addNewProtectedRanges();

    CTPageBreak addNewRowBreaks();

    CTScenarios addNewScenarios();

    CTSheetCalcPr addNewSheetCalcPr();

    CTSheetData addNewSheetData();

    CTSheetFormatPr addNewSheetFormatPr();

    CTSheetPr addNewSheetPr();

    CTSheetProtection addNewSheetProtection();

    CTSheetViews addNewSheetViews();

    CTSmartTags addNewSmartTags();

    CTSortState addNewSortState();

    CTTableParts addNewTableParts();

    CTWebPublishItems addNewWebPublishItems();

    CTAutoFilter getAutoFilter();

    CTCellWatches getCellWatches();

    CTPageBreak getColBreaks();

    CTCols getColsArray(int i);

    CTCols[] getColsArray();

    List<CTCols> getColsList();

    CTConditionalFormatting getConditionalFormattingArray(int i);

    CTConditionalFormatting[] getConditionalFormattingArray();

    List<CTConditionalFormatting> getConditionalFormattingList();

    CTControls getControls();

    CTCustomProperties getCustomProperties();

    CTCustomSheetViews getCustomSheetViews();

    CTDataConsolidate getDataConsolidate();

    CTDataValidations getDataValidations();

    CTSheetDimension getDimension();

    CTDrawing getDrawing();

    CTExtensionList getExtLst();

    CTHeaderFooter getHeaderFooter();

    CTHyperlinks getHyperlinks();

    CTIgnoredErrors getIgnoredErrors();

    CTLegacyDrawing getLegacyDrawing();

    CTLegacyDrawing getLegacyDrawingHF();

    CTMergeCells getMergeCells();

    CTOleObjects getOleObjects();

    CTPageMargins getPageMargins();

    CTPageSetup getPageSetup();

    CTPhoneticPr getPhoneticPr();

    CTSheetBackgroundPicture getPicture();

    CTPrintOptions getPrintOptions();

    CTProtectedRanges getProtectedRanges();

    CTPageBreak getRowBreaks();

    CTScenarios getScenarios();

    CTSheetCalcPr getSheetCalcPr();

    CTSheetData getSheetData();

    CTSheetFormatPr getSheetFormatPr();

    CTSheetPr getSheetPr();

    CTSheetProtection getSheetProtection();

    CTSheetViews getSheetViews();

    CTSmartTags getSmartTags();

    CTSortState getSortState();

    CTTableParts getTableParts();

    CTWebPublishItems getWebPublishItems();

    CTCols insertNewCols(int i);

    CTConditionalFormatting insertNewConditionalFormatting(int i);

    boolean isSetAutoFilter();

    boolean isSetCellWatches();

    boolean isSetColBreaks();

    boolean isSetControls();

    boolean isSetCustomProperties();

    boolean isSetCustomSheetViews();

    boolean isSetDataConsolidate();

    boolean isSetDataValidations();

    boolean isSetDimension();

    boolean isSetDrawing();

    boolean isSetExtLst();

    boolean isSetHeaderFooter();

    boolean isSetHyperlinks();

    boolean isSetIgnoredErrors();

    boolean isSetLegacyDrawing();

    boolean isSetLegacyDrawingHF();

    boolean isSetMergeCells();

    boolean isSetOleObjects();

    boolean isSetPageMargins();

    boolean isSetPageSetup();

    boolean isSetPhoneticPr();

    boolean isSetPicture();

    boolean isSetPrintOptions();

    boolean isSetProtectedRanges();

    boolean isSetRowBreaks();

    boolean isSetScenarios();

    boolean isSetSheetCalcPr();

    boolean isSetSheetFormatPr();

    boolean isSetSheetPr();

    boolean isSetSheetProtection();

    boolean isSetSheetViews();

    boolean isSetSmartTags();

    boolean isSetSortState();

    boolean isSetTableParts();

    boolean isSetWebPublishItems();

    void removeCols(int i);

    void removeConditionalFormatting(int i);

    void setAutoFilter(CTAutoFilter cTAutoFilter);

    void setCellWatches(CTCellWatches cTCellWatches);

    void setColBreaks(CTPageBreak cTPageBreak);

    void setColsArray(int i, CTCols cTCols);

    void setColsArray(CTCols[] cTColsArr);

    void setConditionalFormattingArray(int i, CTConditionalFormatting cTConditionalFormatting);

    void setConditionalFormattingArray(CTConditionalFormatting[] cTConditionalFormattingArr);

    void setControls(CTControls cTControls);

    void setCustomProperties(CTCustomProperties cTCustomProperties);

    void setCustomSheetViews(CTCustomSheetViews cTCustomSheetViews);

    void setDataConsolidate(CTDataConsolidate cTDataConsolidate);

    void setDataValidations(CTDataValidations cTDataValidations);

    void setDimension(CTSheetDimension cTSheetDimension);

    void setDrawing(CTDrawing cTDrawing);

    void setExtLst(CTExtensionList cTExtensionList);

    void setHeaderFooter(CTHeaderFooter cTHeaderFooter);

    void setHyperlinks(CTHyperlinks cTHyperlinks);

    void setIgnoredErrors(CTIgnoredErrors cTIgnoredErrors);

    void setLegacyDrawing(CTLegacyDrawing cTLegacyDrawing);

    void setLegacyDrawingHF(CTLegacyDrawing cTLegacyDrawing);

    void setMergeCells(CTMergeCells cTMergeCells);

    void setOleObjects(CTOleObjects cTOleObjects);

    void setPageMargins(CTPageMargins cTPageMargins);

    void setPageSetup(CTPageSetup cTPageSetup);

    void setPhoneticPr(CTPhoneticPr cTPhoneticPr);

    void setPicture(CTSheetBackgroundPicture cTSheetBackgroundPicture);

    void setPrintOptions(CTPrintOptions cTPrintOptions);

    void setProtectedRanges(CTProtectedRanges cTProtectedRanges);

    void setRowBreaks(CTPageBreak cTPageBreak);

    void setScenarios(CTScenarios cTScenarios);

    void setSheetCalcPr(CTSheetCalcPr cTSheetCalcPr);

    void setSheetData(CTSheetData cTSheetData);

    void setSheetFormatPr(CTSheetFormatPr cTSheetFormatPr);

    void setSheetPr(CTSheetPr cTSheetPr);

    void setSheetProtection(CTSheetProtection cTSheetProtection);

    void setSheetViews(CTSheetViews cTSheetViews);

    void setSmartTags(CTSmartTags cTSmartTags);

    void setSortState(CTSortState cTSortState);

    void setTableParts(CTTableParts cTTableParts);

    void setWebPublishItems(CTWebPublishItems cTWebPublishItems);

    int sizeOfColsArray();

    int sizeOfConditionalFormattingArray();

    void unsetAutoFilter();

    void unsetCellWatches();

    void unsetColBreaks();

    void unsetControls();

    void unsetCustomProperties();

    void unsetCustomSheetViews();

    void unsetDataConsolidate();

    void unsetDataValidations();

    void unsetDimension();

    void unsetDrawing();

    void unsetExtLst();

    void unsetHeaderFooter();

    void unsetHyperlinks();

    void unsetIgnoredErrors();

    void unsetLegacyDrawing();

    void unsetLegacyDrawingHF();

    void unsetMergeCells();

    void unsetOleObjects();

    void unsetPageMargins();

    void unsetPageSetup();

    void unsetPhoneticPr();

    void unsetPicture();

    void unsetPrintOptions();

    void unsetProtectedRanges();

    void unsetRowBreaks();

    void unsetScenarios();

    void unsetSheetCalcPr();

    void unsetSheetFormatPr();

    void unsetSheetPr();

    void unsetSheetProtection();

    void unsetSheetViews();

    void unsetSmartTags();

    void unsetSortState();

    void unsetTableParts();

    void unsetWebPublishItems();
}
