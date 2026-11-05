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
public interface CTPivotField extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTPivotField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpivotfieldf961type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPivotField newInstance() {
            return (CTPivotField) POIXMLTypeLoader.newInstance(CTPivotField.type, (XmlOptions) null);
        }

        public static CTPivotField newInstance(XmlOptions xmlOptions) {
            return (CTPivotField) POIXMLTypeLoader.newInstance(CTPivotField.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPivotField.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPivotField.type, xmlOptions);
        }

        public static CTPivotField parse(File file) throws XmlException, IOException {
            return (CTPivotField) POIXMLTypeLoader.parse(file, CTPivotField.type, (XmlOptions) null);
        }

        public static CTPivotField parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotField) POIXMLTypeLoader.parse(file, CTPivotField.type, xmlOptions);
        }

        public static CTPivotField parse(InputStream inputStream) throws XmlException, IOException {
            return (CTPivotField) POIXMLTypeLoader.parse(inputStream, CTPivotField.type, (XmlOptions) null);
        }

        public static CTPivotField parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotField) POIXMLTypeLoader.parse(inputStream, CTPivotField.type, xmlOptions);
        }

        public static CTPivotField parse(Reader reader) throws XmlException, IOException {
            return (CTPivotField) POIXMLTypeLoader.parse(reader, CTPivotField.type, (XmlOptions) null);
        }

        public static CTPivotField parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotField) POIXMLTypeLoader.parse(reader, CTPivotField.type, xmlOptions);
        }

        public static CTPivotField parse(String str) throws XmlException {
            return (CTPivotField) POIXMLTypeLoader.parse(str, CTPivotField.type, (XmlOptions) null);
        }

        public static CTPivotField parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotField) POIXMLTypeLoader.parse(str, CTPivotField.type, xmlOptions);
        }

        public static CTPivotField parse(URL url) throws XmlException, IOException {
            return (CTPivotField) POIXMLTypeLoader.parse(url, CTPivotField.type, (XmlOptions) null);
        }

        public static CTPivotField parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTPivotField) POIXMLTypeLoader.parse(url, CTPivotField.type, xmlOptions);
        }

        public static CTPivotField parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTPivotField) POIXMLTypeLoader.parse(xMLStreamReader, CTPivotField.type, (XmlOptions) null);
        }

        public static CTPivotField parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotField) POIXMLTypeLoader.parse(xMLStreamReader, CTPivotField.type, xmlOptions);
        }

        public static CTPivotField parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTPivotField) POIXMLTypeLoader.parse(xMLInputStream, CTPivotField.type, (XmlOptions) null);
        }

        public static CTPivotField parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTPivotField) POIXMLTypeLoader.parse(xMLInputStream, CTPivotField.type, xmlOptions);
        }

        public static CTPivotField parse(Node node) throws XmlException {
            return (CTPivotField) POIXMLTypeLoader.parse(node, CTPivotField.type, (XmlOptions) null);
        }

        public static CTPivotField parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTPivotField) POIXMLTypeLoader.parse(node, CTPivotField.type, xmlOptions);
        }
    }

    CTAutoSortScope addNewAutoSortScope();

    CTExtensionList addNewExtLst();

    CTItems addNewItems();

    boolean getAllDrilled();

    boolean getAutoShow();

    CTAutoSortScope getAutoSortScope();

    boolean getAvgSubtotal();

    STAxis.Enum getAxis();

    boolean getCompact();

    boolean getCountASubtotal();

    boolean getCountSubtotal();

    boolean getDataField();

    boolean getDataSourceSort();

    boolean getDefaultAttributeDrillState();

    boolean getDefaultSubtotal();

    boolean getDragOff();

    boolean getDragToCol();

    boolean getDragToData();

    boolean getDragToPage();

    boolean getDragToRow();

    CTExtensionList getExtLst();

    boolean getHiddenLevel();

    boolean getHideNewItems();

    boolean getIncludeNewItemsInFilter();

    boolean getInsertBlankRow();

    boolean getInsertPageBreak();

    long getItemPageCount();

    CTItems getItems();

    boolean getMaxSubtotal();

    boolean getMeasureFilter();

    boolean getMinSubtotal();

    boolean getMultipleItemSelectionAllowed();

    String getName();

    boolean getNonAutoSortDefault();

    long getNumFmtId();

    boolean getOutline();

    boolean getProductSubtotal();

    long getRankBy();

    boolean getServerField();

    boolean getShowAll();

    boolean getShowDropDowns();

    boolean getShowPropAsCaption();

    boolean getShowPropCell();

    boolean getShowPropTip();

    STFieldSortType$Enum getSortType();

    boolean getStdDevPSubtotal();

    boolean getStdDevSubtotal();

    String getSubtotalCaption();

    boolean getSubtotalTop();

    boolean getSumSubtotal();

    boolean getTopAutoShow();

    String getUniqueMemberProperty();

    boolean getVarPSubtotal();

    boolean getVarSubtotal();

    boolean isSetAllDrilled();

    boolean isSetAutoShow();

    boolean isSetAutoSortScope();

    boolean isSetAvgSubtotal();

    boolean isSetAxis();

    boolean isSetCompact();

    boolean isSetCountASubtotal();

    boolean isSetCountSubtotal();

    boolean isSetDataField();

    boolean isSetDataSourceSort();

    boolean isSetDefaultAttributeDrillState();

    boolean isSetDefaultSubtotal();

    boolean isSetDragOff();

    boolean isSetDragToCol();

    boolean isSetDragToData();

    boolean isSetDragToPage();

    boolean isSetDragToRow();

    boolean isSetExtLst();

    boolean isSetHiddenLevel();

    boolean isSetHideNewItems();

    boolean isSetIncludeNewItemsInFilter();

    boolean isSetInsertBlankRow();

    boolean isSetInsertPageBreak();

    boolean isSetItemPageCount();

    boolean isSetItems();

    boolean isSetMaxSubtotal();

    boolean isSetMeasureFilter();

    boolean isSetMinSubtotal();

    boolean isSetMultipleItemSelectionAllowed();

    boolean isSetName();

    boolean isSetNonAutoSortDefault();

    boolean isSetNumFmtId();

    boolean isSetOutline();

    boolean isSetProductSubtotal();

    boolean isSetRankBy();

    boolean isSetServerField();

    boolean isSetShowAll();

    boolean isSetShowDropDowns();

    boolean isSetShowPropAsCaption();

    boolean isSetShowPropCell();

    boolean isSetShowPropTip();

    boolean isSetSortType();

    boolean isSetStdDevPSubtotal();

    boolean isSetStdDevSubtotal();

    boolean isSetSubtotalCaption();

    boolean isSetSubtotalTop();

    boolean isSetSumSubtotal();

    boolean isSetTopAutoShow();

    boolean isSetUniqueMemberProperty();

    boolean isSetVarPSubtotal();

    boolean isSetVarSubtotal();

    void setAllDrilled(boolean z);

    void setAutoShow(boolean z);

    void setAutoSortScope(CTAutoSortScope cTAutoSortScope);

    void setAvgSubtotal(boolean z);

    void setAxis(STAxis.Enum r1);

    void setCompact(boolean z);

    void setCountASubtotal(boolean z);

    void setCountSubtotal(boolean z);

    void setDataField(boolean z);

    void setDataSourceSort(boolean z);

    void setDefaultAttributeDrillState(boolean z);

    void setDefaultSubtotal(boolean z);

    void setDragOff(boolean z);

    void setDragToCol(boolean z);

    void setDragToData(boolean z);

    void setDragToPage(boolean z);

    void setDragToRow(boolean z);

    void setExtLst(CTExtensionList cTExtensionList);

    void setHiddenLevel(boolean z);

    void setHideNewItems(boolean z);

    void setIncludeNewItemsInFilter(boolean z);

    void setInsertBlankRow(boolean z);

    void setInsertPageBreak(boolean z);

    void setItemPageCount(long j);

    void setItems(CTItems cTItems);

    void setMaxSubtotal(boolean z);

    void setMeasureFilter(boolean z);

    void setMinSubtotal(boolean z);

    void setMultipleItemSelectionAllowed(boolean z);

    void setName(String str);

    void setNonAutoSortDefault(boolean z);

    void setNumFmtId(long j);

    void setOutline(boolean z);

    void setProductSubtotal(boolean z);

    void setRankBy(long j);

    void setServerField(boolean z);

    void setShowAll(boolean z);

    void setShowDropDowns(boolean z);

    void setShowPropAsCaption(boolean z);

    void setShowPropCell(boolean z);

    void setShowPropTip(boolean z);

    void setSortType(STFieldSortType$Enum sTFieldSortType$Enum);

    void setStdDevPSubtotal(boolean z);

    void setStdDevSubtotal(boolean z);

    void setSubtotalCaption(String str);

    void setSubtotalTop(boolean z);

    void setSumSubtotal(boolean z);

    void setTopAutoShow(boolean z);

    void setUniqueMemberProperty(String str);

    void setVarPSubtotal(boolean z);

    void setVarSubtotal(boolean z);

    void unsetAllDrilled();

    void unsetAutoShow();

    void unsetAutoSortScope();

    void unsetAvgSubtotal();

    void unsetAxis();

    void unsetCompact();

    void unsetCountASubtotal();

    void unsetCountSubtotal();

    void unsetDataField();

    void unsetDataSourceSort();

    void unsetDefaultAttributeDrillState();

    void unsetDefaultSubtotal();

    void unsetDragOff();

    void unsetDragToCol();

    void unsetDragToData();

    void unsetDragToPage();

    void unsetDragToRow();

    void unsetExtLst();

    void unsetHiddenLevel();

    void unsetHideNewItems();

    void unsetIncludeNewItemsInFilter();

    void unsetInsertBlankRow();

    void unsetInsertPageBreak();

    void unsetItemPageCount();

    void unsetItems();

    void unsetMaxSubtotal();

    void unsetMeasureFilter();

    void unsetMinSubtotal();

    void unsetMultipleItemSelectionAllowed();

    void unsetName();

    void unsetNonAutoSortDefault();

    void unsetNumFmtId();

    void unsetOutline();

    void unsetProductSubtotal();

    void unsetRankBy();

    void unsetServerField();

    void unsetShowAll();

    void unsetShowDropDowns();

    void unsetShowPropAsCaption();

    void unsetShowPropCell();

    void unsetShowPropTip();

    void unsetSortType();

    void unsetStdDevPSubtotal();

    void unsetStdDevSubtotal();

    void unsetSubtotalCaption();

    void unsetSubtotalTop();

    void unsetSumSubtotal();

    void unsetTopAutoShow();

    void unsetUniqueMemberProperty();

    void unsetVarPSubtotal();

    void unsetVarSubtotal();

    XmlBoolean xgetAllDrilled();

    XmlBoolean xgetAutoShow();

    XmlBoolean xgetAvgSubtotal();

    STAxis xgetAxis();

    XmlBoolean xgetCompact();

    XmlBoolean xgetCountASubtotal();

    XmlBoolean xgetCountSubtotal();

    XmlBoolean xgetDataField();

    XmlBoolean xgetDataSourceSort();

    XmlBoolean xgetDefaultAttributeDrillState();

    XmlBoolean xgetDefaultSubtotal();

    XmlBoolean xgetDragOff();

    XmlBoolean xgetDragToCol();

    XmlBoolean xgetDragToData();

    XmlBoolean xgetDragToPage();

    XmlBoolean xgetDragToRow();

    XmlBoolean xgetHiddenLevel();

    XmlBoolean xgetHideNewItems();

    XmlBoolean xgetIncludeNewItemsInFilter();

    XmlBoolean xgetInsertBlankRow();

    XmlBoolean xgetInsertPageBreak();

    XmlUnsignedInt xgetItemPageCount();

    XmlBoolean xgetMaxSubtotal();

    XmlBoolean xgetMeasureFilter();

    XmlBoolean xgetMinSubtotal();

    XmlBoolean xgetMultipleItemSelectionAllowed();

    STXstring xgetName();

    XmlBoolean xgetNonAutoSortDefault();

    STNumFmtId xgetNumFmtId();

    XmlBoolean xgetOutline();

    XmlBoolean xgetProductSubtotal();

    XmlUnsignedInt xgetRankBy();

    XmlBoolean xgetServerField();

    XmlBoolean xgetShowAll();

    XmlBoolean xgetShowDropDowns();

    XmlBoolean xgetShowPropAsCaption();

    XmlBoolean xgetShowPropCell();

    XmlBoolean xgetShowPropTip();

    STFieldSortType xgetSortType();

    XmlBoolean xgetStdDevPSubtotal();

    XmlBoolean xgetStdDevSubtotal();

    STXstring xgetSubtotalCaption();

    XmlBoolean xgetSubtotalTop();

    XmlBoolean xgetSumSubtotal();

    XmlBoolean xgetTopAutoShow();

    STXstring xgetUniqueMemberProperty();

    XmlBoolean xgetVarPSubtotal();

    XmlBoolean xgetVarSubtotal();

    void xsetAllDrilled(XmlBoolean xmlBoolean);

    void xsetAutoShow(XmlBoolean xmlBoolean);

    void xsetAvgSubtotal(XmlBoolean xmlBoolean);

    void xsetAxis(STAxis sTAxis);

    void xsetCompact(XmlBoolean xmlBoolean);

    void xsetCountASubtotal(XmlBoolean xmlBoolean);

    void xsetCountSubtotal(XmlBoolean xmlBoolean);

    void xsetDataField(XmlBoolean xmlBoolean);

    void xsetDataSourceSort(XmlBoolean xmlBoolean);

    void xsetDefaultAttributeDrillState(XmlBoolean xmlBoolean);

    void xsetDefaultSubtotal(XmlBoolean xmlBoolean);

    void xsetDragOff(XmlBoolean xmlBoolean);

    void xsetDragToCol(XmlBoolean xmlBoolean);

    void xsetDragToData(XmlBoolean xmlBoolean);

    void xsetDragToPage(XmlBoolean xmlBoolean);

    void xsetDragToRow(XmlBoolean xmlBoolean);

    void xsetHiddenLevel(XmlBoolean xmlBoolean);

    void xsetHideNewItems(XmlBoolean xmlBoolean);

    void xsetIncludeNewItemsInFilter(XmlBoolean xmlBoolean);

    void xsetInsertBlankRow(XmlBoolean xmlBoolean);

    void xsetInsertPageBreak(XmlBoolean xmlBoolean);

    void xsetItemPageCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetMaxSubtotal(XmlBoolean xmlBoolean);

    void xsetMeasureFilter(XmlBoolean xmlBoolean);

    void xsetMinSubtotal(XmlBoolean xmlBoolean);

    void xsetMultipleItemSelectionAllowed(XmlBoolean xmlBoolean);

    void xsetName(STXstring sTXstring);

    void xsetNonAutoSortDefault(XmlBoolean xmlBoolean);

    void xsetNumFmtId(STNumFmtId sTNumFmtId);

    void xsetOutline(XmlBoolean xmlBoolean);

    void xsetProductSubtotal(XmlBoolean xmlBoolean);

    void xsetRankBy(XmlUnsignedInt xmlUnsignedInt);

    void xsetServerField(XmlBoolean xmlBoolean);

    void xsetShowAll(XmlBoolean xmlBoolean);

    void xsetShowDropDowns(XmlBoolean xmlBoolean);

    void xsetShowPropAsCaption(XmlBoolean xmlBoolean);

    void xsetShowPropCell(XmlBoolean xmlBoolean);

    void xsetShowPropTip(XmlBoolean xmlBoolean);

    void xsetSortType(STFieldSortType sTFieldSortType);

    void xsetStdDevPSubtotal(XmlBoolean xmlBoolean);

    void xsetStdDevSubtotal(XmlBoolean xmlBoolean);

    void xsetSubtotalCaption(STXstring sTXstring);

    void xsetSubtotalTop(XmlBoolean xmlBoolean);

    void xsetSumSubtotal(XmlBoolean xmlBoolean);

    void xsetTopAutoShow(XmlBoolean xmlBoolean);

    void xsetUniqueMemberProperty(STXstring sTXstring);

    void xsetVarPSubtotal(XmlBoolean xmlBoolean);

    void xsetVarSubtotal(XmlBoolean xmlBoolean);
}
