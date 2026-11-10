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
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTPivotTableDefinition extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPivotTableDefinition.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpivottabledefinitionb188type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPivotTableDefinition newInstance() {
            return (CTPivotTableDefinition) POIXMLTypeLoader.newInstance(CTPivotTableDefinition.type, (XmlOptions) null);
        }

        public static CTPivotTableDefinition newInstance(XmlOptions xmlOptions) {
            return (CTPivotTableDefinition) POIXMLTypeLoader.newInstance(CTPivotTableDefinition.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPivotTableDefinition.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPivotTableDefinition.type, xmlOptions);
        }

        public static CTPivotTableDefinition parse(File file) throws XmlException, IOException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(file, CTPivotTableDefinition.type, (XmlOptions) null);
        }

        public static CTPivotTableDefinition parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(file, CTPivotTableDefinition.type, xmlOptions);
        }

        public static CTPivotTableDefinition parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(inputStream, CTPivotTableDefinition.type, (XmlOptions) null);
        }

        public static CTPivotTableDefinition parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(inputStream, CTPivotTableDefinition.type, xmlOptions);
        }

        public static CTPivotTableDefinition parse(Reader reader) throws XmlException, IOException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(reader, CTPivotTableDefinition.type, (XmlOptions) null);
        }

        public static CTPivotTableDefinition parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(reader, CTPivotTableDefinition.type, xmlOptions);
        }

        public static CTPivotTableDefinition parse(String str) throws XmlException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(str, CTPivotTableDefinition.type, (XmlOptions) null);
        }

        public static CTPivotTableDefinition parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(str, CTPivotTableDefinition.type, xmlOptions);
        }

        public static CTPivotTableDefinition parse(URL url) throws XmlException, IOException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(url, CTPivotTableDefinition.type, (XmlOptions) null);
        }

        public static CTPivotTableDefinition parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(url, CTPivotTableDefinition.type, xmlOptions);
        }

        public static CTPivotTableDefinition parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(xMLStreamReader, CTPivotTableDefinition.type, (XmlOptions) null);
        }

        public static CTPivotTableDefinition parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(xMLStreamReader, CTPivotTableDefinition.type, xmlOptions);
        }

        public static CTPivotTableDefinition parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(xMLInputStream, CTPivotTableDefinition.type, (XmlOptions) null);
        }

        public static CTPivotTableDefinition parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(xMLInputStream, CTPivotTableDefinition.type, xmlOptions);
        }

        public static CTPivotTableDefinition parse(Node node) throws XmlException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(node, CTPivotTableDefinition.type, (XmlOptions) null);
        }

        public static CTPivotTableDefinition parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotTableDefinition) POIXMLTypeLoader.parse(node, CTPivotTableDefinition.type, xmlOptions);
        }
    }

    CTChartFormats addNewChartFormats();

    CTColFields addNewColFields();

    CTColHierarchiesUsage addNewColHierarchiesUsage();

    CTColItems addNewColItems();

    CTConditionalFormats addNewConditionalFormats();

    CTDataFields addNewDataFields();

    CTExtensionList addNewExtLst();

    CTPivotFilters addNewFilters();

    CTFormats addNewFormats();

    CTLocation addNewLocation();

    CTPageFields addNewPageFields();

    CTPivotFields addNewPivotFields();

    CTPivotHierarchies addNewPivotHierarchies();

    CTPivotTableStyle addNewPivotTableStyleInfo();

    CTRowFields addNewRowFields();

    CTRowHierarchiesUsage addNewRowHierarchiesUsage();

    CTRowItems addNewRowItems();

    boolean getApplyAlignmentFormats();

    boolean getApplyBorderFormats();

    boolean getApplyFontFormats();

    boolean getApplyNumberFormats();

    boolean getApplyPatternFormats();

    boolean getApplyWidthHeightFormats();

    boolean getAsteriskTotals();

    long getAutoFormatId();

    long getCacheId();

    long getChartFormat();

    CTChartFormats getChartFormats();

    CTColFields getColFields();

    boolean getColGrandTotals();

    String getColHeaderCaption();

    CTColHierarchiesUsage getColHierarchiesUsage();

    CTColItems getColItems();

    boolean getCompact();

    boolean getCompactData();

    CTConditionalFormats getConditionalFormats();

    short getCreatedVersion();

    boolean getCustomListSort();

    String getDataCaption();

    CTDataFields getDataFields();

    boolean getDataOnRows();

    long getDataPosition();

    boolean getDisableFieldList();

    boolean getEditData();

    boolean getEnableDrill();

    boolean getEnableFieldProperties();

    boolean getEnableWizard();

    String getErrorCaption();

    CTExtensionList getExtLst();

    boolean getFieldListSortAscending();

    boolean getFieldPrintTitles();

    CTPivotFilters getFilters();

    CTFormats getFormats();

    String getGrandTotalCaption();

    boolean getGridDropZones();

    boolean getImmersive();

    long getIndent();

    boolean getItemPrintTitles();

    CTLocation getLocation();

    boolean getMdxSubqueries();

    boolean getMergeItem();

    short getMinRefreshableVersion();

    String getMissingCaption();

    boolean getMultipleFieldFilters();

    String getName();

    boolean getOutline();

    boolean getOutlineData();

    CTPageFields getPageFields();

    boolean getPageOverThenDown();

    String getPageStyle();

    long getPageWrap();

    CTPivotFields getPivotFields();

    CTPivotHierarchies getPivotHierarchies();

    String getPivotTableStyle();

    CTPivotTableStyle getPivotTableStyleInfo();

    boolean getPreserveFormatting();

    boolean getPrintDrill();

    boolean getPublished();

    CTRowFields getRowFields();

    boolean getRowGrandTotals();

    String getRowHeaderCaption();

    CTRowHierarchiesUsage getRowHierarchiesUsage();

    CTRowItems getRowItems();

    boolean getShowCalcMbrs();

    boolean getShowDataDropDown();

    boolean getShowDataTips();

    boolean getShowDrill();

    boolean getShowDropZones();

    boolean getShowEmptyCol();

    boolean getShowEmptyRow();

    boolean getShowError();

    boolean getShowHeaders();

    boolean getShowItems();

    boolean getShowMemberPropertyTips();

    boolean getShowMissing();

    boolean getShowMultipleLabel();

    boolean getSubtotalHiddenItems();

    String getTag();

    short getUpdatedVersion();

    boolean getUseAutoFormatting();

    String getVacatedStyle();

    boolean getVisualTotals();

    boolean isSetApplyAlignmentFormats();

    boolean isSetApplyBorderFormats();

    boolean isSetApplyFontFormats();

    boolean isSetApplyNumberFormats();

    boolean isSetApplyPatternFormats();

    boolean isSetApplyWidthHeightFormats();

    boolean isSetAsteriskTotals();

    boolean isSetAutoFormatId();

    boolean isSetChartFormat();

    boolean isSetChartFormats();

    boolean isSetColFields();

    boolean isSetColGrandTotals();

    boolean isSetColHeaderCaption();

    boolean isSetColHierarchiesUsage();

    boolean isSetColItems();

    boolean isSetCompact();

    boolean isSetCompactData();

    boolean isSetConditionalFormats();

    boolean isSetCreatedVersion();

    boolean isSetCustomListSort();

    boolean isSetDataFields();

    boolean isSetDataOnRows();

    boolean isSetDataPosition();

    boolean isSetDisableFieldList();

    boolean isSetEditData();

    boolean isSetEnableDrill();

    boolean isSetEnableFieldProperties();

    boolean isSetEnableWizard();

    boolean isSetErrorCaption();

    boolean isSetExtLst();

    boolean isSetFieldListSortAscending();

    boolean isSetFieldPrintTitles();

    boolean isSetFilters();

    boolean isSetFormats();

    boolean isSetGrandTotalCaption();

    boolean isSetGridDropZones();

    boolean isSetImmersive();

    boolean isSetIndent();

    boolean isSetItemPrintTitles();

    boolean isSetMdxSubqueries();

    boolean isSetMergeItem();

    boolean isSetMinRefreshableVersion();

    boolean isSetMissingCaption();

    boolean isSetMultipleFieldFilters();

    boolean isSetOutline();

    boolean isSetOutlineData();

    boolean isSetPageFields();

    boolean isSetPageOverThenDown();

    boolean isSetPageStyle();

    boolean isSetPageWrap();

    boolean isSetPivotFields();

    boolean isSetPivotHierarchies();

    boolean isSetPivotTableStyle();

    boolean isSetPivotTableStyleInfo();

    boolean isSetPreserveFormatting();

    boolean isSetPrintDrill();

    boolean isSetPublished();

    boolean isSetRowFields();

    boolean isSetRowGrandTotals();

    boolean isSetRowHeaderCaption();

    boolean isSetRowHierarchiesUsage();

    boolean isSetRowItems();

    boolean isSetShowCalcMbrs();

    boolean isSetShowDataDropDown();

    boolean isSetShowDataTips();

    boolean isSetShowDrill();

    boolean isSetShowDropZones();

    boolean isSetShowEmptyCol();

    boolean isSetShowEmptyRow();

    boolean isSetShowError();

    boolean isSetShowHeaders();

    boolean isSetShowItems();

    boolean isSetShowMemberPropertyTips();

    boolean isSetShowMissing();

    boolean isSetShowMultipleLabel();

    boolean isSetSubtotalHiddenItems();

    boolean isSetTag();

    boolean isSetUpdatedVersion();

    boolean isSetUseAutoFormatting();

    boolean isSetVacatedStyle();

    boolean isSetVisualTotals();

    void setApplyAlignmentFormats(boolean z);

    void setApplyBorderFormats(boolean z);

    void setApplyFontFormats(boolean z);

    void setApplyNumberFormats(boolean z);

    void setApplyPatternFormats(boolean z);

    void setApplyWidthHeightFormats(boolean z);

    void setAsteriskTotals(boolean z);

    void setAutoFormatId(long j);

    void setCacheId(long j);

    void setChartFormat(long j);

    void setChartFormats(CTChartFormats cTChartFormats);

    void setColFields(CTColFields cTColFields);

    void setColGrandTotals(boolean z);

    void setColHeaderCaption(String str);

    void setColHierarchiesUsage(CTColHierarchiesUsage cTColHierarchiesUsage);

    void setColItems(CTColItems cTColItems);

    void setCompact(boolean z);

    void setCompactData(boolean z);

    void setConditionalFormats(CTConditionalFormats cTConditionalFormats);

    void setCreatedVersion(short s);

    void setCustomListSort(boolean z);

    void setDataCaption(String str);

    void setDataFields(CTDataFields cTDataFields);

    void setDataOnRows(boolean z);

    void setDataPosition(long j);

    void setDisableFieldList(boolean z);

    void setEditData(boolean z);

    void setEnableDrill(boolean z);

    void setEnableFieldProperties(boolean z);

    void setEnableWizard(boolean z);

    void setErrorCaption(String str);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFieldListSortAscending(boolean z);

    void setFieldPrintTitles(boolean z);

    void setFilters(CTPivotFilters cTPivotFilters);

    void setFormats(CTFormats cTFormats);

    void setGrandTotalCaption(String str);

    void setGridDropZones(boolean z);

    void setImmersive(boolean z);

    void setIndent(long j);

    void setItemPrintTitles(boolean z);

    void setLocation(CTLocation cTLocation);

    void setMdxSubqueries(boolean z);

    void setMergeItem(boolean z);

    void setMinRefreshableVersion(short s);

    void setMissingCaption(String str);

    void setMultipleFieldFilters(boolean z);

    void setName(String str);

    void setOutline(boolean z);

    void setOutlineData(boolean z);

    void setPageFields(CTPageFields cTPageFields);

    void setPageOverThenDown(boolean z);

    void setPageStyle(String str);

    void setPageWrap(long j);

    void setPivotFields(CTPivotFields cTPivotFields);

    void setPivotHierarchies(CTPivotHierarchies cTPivotHierarchies);

    void setPivotTableStyle(String str);

    void setPivotTableStyleInfo(CTPivotTableStyle cTPivotTableStyle);

    void setPreserveFormatting(boolean z);

    void setPrintDrill(boolean z);

    void setPublished(boolean z);

    void setRowFields(CTRowFields cTRowFields);

    void setRowGrandTotals(boolean z);

    void setRowHeaderCaption(String str);

    void setRowHierarchiesUsage(CTRowHierarchiesUsage cTRowHierarchiesUsage);

    void setRowItems(CTRowItems cTRowItems);

    void setShowCalcMbrs(boolean z);

    void setShowDataDropDown(boolean z);

    void setShowDataTips(boolean z);

    void setShowDrill(boolean z);

    void setShowDropZones(boolean z);

    void setShowEmptyCol(boolean z);

    void setShowEmptyRow(boolean z);

    void setShowError(boolean z);

    void setShowHeaders(boolean z);

    void setShowItems(boolean z);

    void setShowMemberPropertyTips(boolean z);

    void setShowMissing(boolean z);

    void setShowMultipleLabel(boolean z);

    void setSubtotalHiddenItems(boolean z);

    void setTag(String str);

    void setUpdatedVersion(short s);

    void setUseAutoFormatting(boolean z);

    void setVacatedStyle(String str);

    void setVisualTotals(boolean z);

    void unsetApplyAlignmentFormats();

    void unsetApplyBorderFormats();

    void unsetApplyFontFormats();

    void unsetApplyNumberFormats();

    void unsetApplyPatternFormats();

    void unsetApplyWidthHeightFormats();

    void unsetAsteriskTotals();

    void unsetAutoFormatId();

    void unsetChartFormat();

    void unsetChartFormats();

    void unsetColFields();

    void unsetColGrandTotals();

    void unsetColHeaderCaption();

    void unsetColHierarchiesUsage();

    void unsetColItems();

    void unsetCompact();

    void unsetCompactData();

    void unsetConditionalFormats();

    void unsetCreatedVersion();

    void unsetCustomListSort();

    void unsetDataFields();

    void unsetDataOnRows();

    void unsetDataPosition();

    void unsetDisableFieldList();

    void unsetEditData();

    void unsetEnableDrill();

    void unsetEnableFieldProperties();

    void unsetEnableWizard();

    void unsetErrorCaption();

    void unsetExtLst();

    void unsetFieldListSortAscending();

    void unsetFieldPrintTitles();

    void unsetFilters();

    void unsetFormats();

    void unsetGrandTotalCaption();

    void unsetGridDropZones();

    void unsetImmersive();

    void unsetIndent();

    void unsetItemPrintTitles();

    void unsetMdxSubqueries();

    void unsetMergeItem();

    void unsetMinRefreshableVersion();

    void unsetMissingCaption();

    void unsetMultipleFieldFilters();

    void unsetOutline();

    void unsetOutlineData();

    void unsetPageFields();

    void unsetPageOverThenDown();

    void unsetPageStyle();

    void unsetPageWrap();

    void unsetPivotFields();

    void unsetPivotHierarchies();

    void unsetPivotTableStyle();

    void unsetPivotTableStyleInfo();

    void unsetPreserveFormatting();

    void unsetPrintDrill();

    void unsetPublished();

    void unsetRowFields();

    void unsetRowGrandTotals();

    void unsetRowHeaderCaption();

    void unsetRowHierarchiesUsage();

    void unsetRowItems();

    void unsetShowCalcMbrs();

    void unsetShowDataDropDown();

    void unsetShowDataTips();

    void unsetShowDrill();

    void unsetShowDropZones();

    void unsetShowEmptyCol();

    void unsetShowEmptyRow();

    void unsetShowError();

    void unsetShowHeaders();

    void unsetShowItems();

    void unsetShowMemberPropertyTips();

    void unsetShowMissing();

    void unsetShowMultipleLabel();

    void unsetSubtotalHiddenItems();

    void unsetTag();

    void unsetUpdatedVersion();

    void unsetUseAutoFormatting();

    void unsetVacatedStyle();

    void unsetVisualTotals();

    XmlBoolean xgetApplyAlignmentFormats();

    XmlBoolean xgetApplyBorderFormats();

    XmlBoolean xgetApplyFontFormats();

    XmlBoolean xgetApplyNumberFormats();

    XmlBoolean xgetApplyPatternFormats();

    XmlBoolean xgetApplyWidthHeightFormats();

    XmlBoolean xgetAsteriskTotals();

    XmlUnsignedInt xgetAutoFormatId();

    XmlUnsignedInt xgetCacheId();

    XmlUnsignedInt xgetChartFormat();

    XmlBoolean xgetColGrandTotals();

    STXstring xgetColHeaderCaption();

    XmlBoolean xgetCompact();

    XmlBoolean xgetCompactData();

    XmlUnsignedByte xgetCreatedVersion();

    XmlBoolean xgetCustomListSort();

    STXstring xgetDataCaption();

    XmlBoolean xgetDataOnRows();

    XmlUnsignedInt xgetDataPosition();

    XmlBoolean xgetDisableFieldList();

    XmlBoolean xgetEditData();

    XmlBoolean xgetEnableDrill();

    XmlBoolean xgetEnableFieldProperties();

    XmlBoolean xgetEnableWizard();

    STXstring xgetErrorCaption();

    XmlBoolean xgetFieldListSortAscending();

    XmlBoolean xgetFieldPrintTitles();

    STXstring xgetGrandTotalCaption();

    XmlBoolean xgetGridDropZones();

    XmlBoolean xgetImmersive();

    XmlUnsignedInt xgetIndent();

    XmlBoolean xgetItemPrintTitles();

    XmlBoolean xgetMdxSubqueries();

    XmlBoolean xgetMergeItem();

    XmlUnsignedByte xgetMinRefreshableVersion();

    STXstring xgetMissingCaption();

    XmlBoolean xgetMultipleFieldFilters();

    STXstring xgetName();

    XmlBoolean xgetOutline();

    XmlBoolean xgetOutlineData();

    XmlBoolean xgetPageOverThenDown();

    STXstring xgetPageStyle();

    XmlUnsignedInt xgetPageWrap();

    STXstring xgetPivotTableStyle();

    XmlBoolean xgetPreserveFormatting();

    XmlBoolean xgetPrintDrill();

    XmlBoolean xgetPublished();

    XmlBoolean xgetRowGrandTotals();

    STXstring xgetRowHeaderCaption();

    XmlBoolean xgetShowCalcMbrs();

    XmlBoolean xgetShowDataDropDown();

    XmlBoolean xgetShowDataTips();

    XmlBoolean xgetShowDrill();

    XmlBoolean xgetShowDropZones();

    XmlBoolean xgetShowEmptyCol();

    XmlBoolean xgetShowEmptyRow();

    XmlBoolean xgetShowError();

    XmlBoolean xgetShowHeaders();

    XmlBoolean xgetShowItems();

    XmlBoolean xgetShowMemberPropertyTips();

    XmlBoolean xgetShowMissing();

    XmlBoolean xgetShowMultipleLabel();

    XmlBoolean xgetSubtotalHiddenItems();

    STXstring xgetTag();

    XmlUnsignedByte xgetUpdatedVersion();

    XmlBoolean xgetUseAutoFormatting();

    STXstring xgetVacatedStyle();

    XmlBoolean xgetVisualTotals();

    void xsetApplyAlignmentFormats(XmlBoolean xmlBoolean);

    void xsetApplyBorderFormats(XmlBoolean xmlBoolean);

    void xsetApplyFontFormats(XmlBoolean xmlBoolean);

    void xsetApplyNumberFormats(XmlBoolean xmlBoolean);

    void xsetApplyPatternFormats(XmlBoolean xmlBoolean);

    void xsetApplyWidthHeightFormats(XmlBoolean xmlBoolean);

    void xsetAsteriskTotals(XmlBoolean xmlBoolean);

    void xsetAutoFormatId(XmlUnsignedInt xmlUnsignedInt);

    void xsetCacheId(XmlUnsignedInt xmlUnsignedInt);

    void xsetChartFormat(XmlUnsignedInt xmlUnsignedInt);

    void xsetColGrandTotals(XmlBoolean xmlBoolean);

    void xsetColHeaderCaption(STXstring sTXstring);

    void xsetCompact(XmlBoolean xmlBoolean);

    void xsetCompactData(XmlBoolean xmlBoolean);

    void xsetCreatedVersion(XmlUnsignedByte xmlUnsignedByte);

    void xsetCustomListSort(XmlBoolean xmlBoolean);

    void xsetDataCaption(STXstring sTXstring);

    void xsetDataOnRows(XmlBoolean xmlBoolean);

    void xsetDataPosition(XmlUnsignedInt xmlUnsignedInt);

    void xsetDisableFieldList(XmlBoolean xmlBoolean);

    void xsetEditData(XmlBoolean xmlBoolean);

    void xsetEnableDrill(XmlBoolean xmlBoolean);

    void xsetEnableFieldProperties(XmlBoolean xmlBoolean);

    void xsetEnableWizard(XmlBoolean xmlBoolean);

    void xsetErrorCaption(STXstring sTXstring);

    void xsetFieldListSortAscending(XmlBoolean xmlBoolean);

    void xsetFieldPrintTitles(XmlBoolean xmlBoolean);

    void xsetGrandTotalCaption(STXstring sTXstring);

    void xsetGridDropZones(XmlBoolean xmlBoolean);

    void xsetImmersive(XmlBoolean xmlBoolean);

    void xsetIndent(XmlUnsignedInt xmlUnsignedInt);

    void xsetItemPrintTitles(XmlBoolean xmlBoolean);

    void xsetMdxSubqueries(XmlBoolean xmlBoolean);

    void xsetMergeItem(XmlBoolean xmlBoolean);

    void xsetMinRefreshableVersion(XmlUnsignedByte xmlUnsignedByte);

    void xsetMissingCaption(STXstring sTXstring);

    void xsetMultipleFieldFilters(XmlBoolean xmlBoolean);

    void xsetName(STXstring sTXstring);

    void xsetOutline(XmlBoolean xmlBoolean);

    void xsetOutlineData(XmlBoolean xmlBoolean);

    void xsetPageOverThenDown(XmlBoolean xmlBoolean);

    void xsetPageStyle(STXstring sTXstring);

    void xsetPageWrap(XmlUnsignedInt xmlUnsignedInt);

    void xsetPivotTableStyle(STXstring sTXstring);

    void xsetPreserveFormatting(XmlBoolean xmlBoolean);

    void xsetPrintDrill(XmlBoolean xmlBoolean);

    void xsetPublished(XmlBoolean xmlBoolean);

    void xsetRowGrandTotals(XmlBoolean xmlBoolean);

    void xsetRowHeaderCaption(STXstring sTXstring);

    void xsetShowCalcMbrs(XmlBoolean xmlBoolean);

    void xsetShowDataDropDown(XmlBoolean xmlBoolean);

    void xsetShowDataTips(XmlBoolean xmlBoolean);

    void xsetShowDrill(XmlBoolean xmlBoolean);

    void xsetShowDropZones(XmlBoolean xmlBoolean);

    void xsetShowEmptyCol(XmlBoolean xmlBoolean);

    void xsetShowEmptyRow(XmlBoolean xmlBoolean);

    void xsetShowError(XmlBoolean xmlBoolean);

    void xsetShowHeaders(XmlBoolean xmlBoolean);

    void xsetShowItems(XmlBoolean xmlBoolean);

    void xsetShowMemberPropertyTips(XmlBoolean xmlBoolean);

    void xsetShowMissing(XmlBoolean xmlBoolean);

    void xsetShowMultipleLabel(XmlBoolean xmlBoolean);

    void xsetSubtotalHiddenItems(XmlBoolean xmlBoolean);

    void xsetTag(STXstring sTXstring);

    void xsetUpdatedVersion(XmlUnsignedByte xmlUnsignedByte);

    void xsetUseAutoFormatting(XmlBoolean xmlBoolean);

    void xsetVacatedStyle(STXstring sTXstring);

    void xsetVisualTotals(XmlBoolean xmlBoolean);
}
