package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataConsolidate;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidations;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTScenarios;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetBackgroundPicture;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetDimension;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSmartTags;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWebPublishItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTWorksheetImpl extends XmlComplexContentImpl implements CTWorksheet {
    private static final QName SHEETPR$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetPr");
    private static final QName DIMENSION$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dimension");
    private static final QName SHEETVIEWS$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetViews");
    private static final QName SHEETFORMATPR$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetFormatPr");
    private static final QName COLS$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cols");
    private static final QName SHEETDATA$10 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetData");
    private static final QName SHEETCALCPR$12 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetCalcPr");
    private static final QName SHEETPROTECTION$14 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetProtection");
    private static final QName PROTECTEDRANGES$16 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "protectedRanges");
    private static final QName SCENARIOS$18 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "scenarios");
    private static final QName AUTOFILTER$20 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "autoFilter");
    private static final QName SORTSTATE$22 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sortState");
    private static final QName DATACONSOLIDATE$24 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dataConsolidate");
    private static final QName CUSTOMSHEETVIEWS$26 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customSheetViews");
    private static final QName MERGECELLS$28 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "mergeCells");
    private static final QName PHONETICPR$30 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "phoneticPr");
    private static final QName CONDITIONALFORMATTING$32 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "conditionalFormatting");
    private static final QName DATAVALIDATIONS$34 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dataValidations");
    private static final QName HYPERLINKS$36 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "hyperlinks");
    private static final QName PRINTOPTIONS$38 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "printOptions");
    private static final QName PAGEMARGINS$40 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageMargins");
    private static final QName PAGESETUP$42 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageSetup");
    private static final QName HEADERFOOTER$44 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "headerFooter");
    private static final QName ROWBREAKS$46 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rowBreaks");
    private static final QName COLBREAKS$48 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "colBreaks");
    private static final QName CUSTOMPROPERTIES$50 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customProperties");
    private static final QName CELLWATCHES$52 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cellWatches");
    private static final QName IGNOREDERRORS$54 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "ignoredErrors");
    private static final QName SMARTTAGS$56 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "smartTags");
    private static final QName DRAWING$58 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "drawing");
    private static final QName LEGACYDRAWING$60 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawing");
    private static final QName LEGACYDRAWINGHF$62 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawingHF");
    private static final QName PICTURE$64 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "picture");
    private static final QName OLEOBJECTS$66 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "oleObjects");
    private static final QName CONTROLS$68 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "controls");
    private static final QName WEBPUBLISHITEMS$70 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "webPublishItems");
    private static final QName TABLEPARTS$72 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tableParts");
    private static final QName EXTLST$74 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");

    public CTWorksheetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTAutoFilter addNewAutoFilter() {
        CTAutoFilter cTAutoFilter;
        synchronized (monitor()) {
            check_orphaned();
            cTAutoFilter = (CTAutoFilter) get_store().add_element_user(AUTOFILTER$20);
        }
        return cTAutoFilter;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCellWatches addNewCellWatches() {
        CTCellWatches cTCellWatchesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCellWatchesAdd_element_user = get_store().add_element_user(CELLWATCHES$52);
        }
        return cTCellWatchesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageBreak addNewColBreaks() {
        CTPageBreak cTPageBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBreak = (CTPageBreak) get_store().add_element_user(COLBREAKS$48);
        }
        return cTPageBreak;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCols addNewCols() {
        CTCols cTCols;
        synchronized (monitor()) {
            check_orphaned();
            cTCols = (CTCols) get_store().add_element_user(COLS$8);
        }
        return cTCols;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTConditionalFormatting addNewConditionalFormatting() {
        CTConditionalFormatting cTConditionalFormatting;
        synchronized (monitor()) {
            check_orphaned();
            cTConditionalFormatting = (CTConditionalFormatting) get_store().add_element_user(CONDITIONALFORMATTING$32);
        }
        return cTConditionalFormatting;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTControls addNewControls() {
        CTControls cTControlsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTControlsAdd_element_user = get_store().add_element_user(CONTROLS$68);
        }
        return cTControlsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCustomProperties addNewCustomProperties() {
        CTCustomProperties cTCustomPropertiesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomPropertiesAdd_element_user = get_store().add_element_user(CUSTOMPROPERTIES$50);
        }
        return cTCustomPropertiesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCustomSheetViews addNewCustomSheetViews() {
        CTCustomSheetViews cTCustomSheetViewsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomSheetViewsAdd_element_user = get_store().add_element_user(CUSTOMSHEETVIEWS$26);
        }
        return cTCustomSheetViewsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDataConsolidate addNewDataConsolidate() {
        CTDataConsolidate cTDataConsolidateAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDataConsolidateAdd_element_user = get_store().add_element_user(DATACONSOLIDATE$24);
        }
        return cTDataConsolidateAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDataValidations addNewDataValidations() {
        CTDataValidations cTDataValidations;
        synchronized (monitor()) {
            check_orphaned();
            cTDataValidations = (CTDataValidations) get_store().add_element_user(DATAVALIDATIONS$34);
        }
        return cTDataValidations;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetDimension addNewDimension() {
        CTSheetDimension cTSheetDimension;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetDimension = (CTSheetDimension) get_store().add_element_user(DIMENSION$2);
        }
        return cTSheetDimension;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDrawing addNewDrawing() {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawing = (CTDrawing) get_store().add_element_user(DRAWING$58);
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$74);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTHeaderFooter addNewHeaderFooter() {
        CTHeaderFooter cTHeaderFooter;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooter = (CTHeaderFooter) get_store().add_element_user(HEADERFOOTER$44);
        }
        return cTHeaderFooter;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTHyperlinks addNewHyperlinks() {
        CTHyperlinks cTHyperlinks;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlinks = (CTHyperlinks) get_store().add_element_user(HYPERLINKS$36);
        }
        return cTHyperlinks;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTIgnoredErrors addNewIgnoredErrors() {
        CTIgnoredErrors cTIgnoredErrors;
        synchronized (monitor()) {
            check_orphaned();
            cTIgnoredErrors = (CTIgnoredErrors) get_store().add_element_user(IGNOREDERRORS$54);
        }
        return cTIgnoredErrors;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTLegacyDrawing addNewLegacyDrawing() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().add_element_user(LEGACYDRAWING$60);
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTLegacyDrawing addNewLegacyDrawingHF() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().add_element_user(LEGACYDRAWINGHF$62);
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTMergeCells addNewMergeCells() {
        CTMergeCells cTMergeCells;
        synchronized (monitor()) {
            check_orphaned();
            cTMergeCells = (CTMergeCells) get_store().add_element_user(MERGECELLS$28);
        }
        return cTMergeCells;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTOleObjects addNewOleObjects() {
        CTOleObjects cTOleObjects;
        synchronized (monitor()) {
            check_orphaned();
            cTOleObjects = (CTOleObjects) get_store().add_element_user(OLEOBJECTS$66);
        }
        return cTOleObjects;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageMargins addNewPageMargins() {
        CTPageMargins cTPageMargins;
        synchronized (monitor()) {
            check_orphaned();
            cTPageMargins = (CTPageMargins) get_store().add_element_user(PAGEMARGINS$40);
        }
        return cTPageMargins;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageSetup addNewPageSetup() {
        CTPageSetup cTPageSetup;
        synchronized (monitor()) {
            check_orphaned();
            cTPageSetup = (CTPageSetup) get_store().add_element_user(PAGESETUP$42);
        }
        return cTPageSetup;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPhoneticPr addNewPhoneticPr() {
        CTPhoneticPr cTPhoneticPr;
        synchronized (monitor()) {
            check_orphaned();
            cTPhoneticPr = (CTPhoneticPr) get_store().add_element_user(PHONETICPR$30);
        }
        return cTPhoneticPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetBackgroundPicture addNewPicture() {
        CTSheetBackgroundPicture cTSheetBackgroundPictureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetBackgroundPictureAdd_element_user = get_store().add_element_user(PICTURE$64);
        }
        return cTSheetBackgroundPictureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPrintOptions addNewPrintOptions() {
        CTPrintOptions cTPrintOptions;
        synchronized (monitor()) {
            check_orphaned();
            cTPrintOptions = (CTPrintOptions) get_store().add_element_user(PRINTOPTIONS$38);
        }
        return cTPrintOptions;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTProtectedRanges addNewProtectedRanges() {
        CTProtectedRanges cTProtectedRangesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProtectedRangesAdd_element_user = get_store().add_element_user(PROTECTEDRANGES$16);
        }
        return cTProtectedRangesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageBreak addNewRowBreaks() {
        CTPageBreak cTPageBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTPageBreak = (CTPageBreak) get_store().add_element_user(ROWBREAKS$46);
        }
        return cTPageBreak;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTScenarios addNewScenarios() {
        CTScenarios cTScenariosAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTScenariosAdd_element_user = get_store().add_element_user(SCENARIOS$18);
        }
        return cTScenariosAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetCalcPr addNewSheetCalcPr() {
        CTSheetCalcPr cTSheetCalcPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetCalcPr = (CTSheetCalcPr) get_store().add_element_user(SHEETCALCPR$12);
        }
        return cTSheetCalcPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetData addNewSheetData() {
        CTSheetData cTSheetData;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetData = (CTSheetData) get_store().add_element_user(SHEETDATA$10);
        }
        return cTSheetData;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetFormatPr addNewSheetFormatPr() {
        CTSheetFormatPr cTSheetFormatPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetFormatPr = (CTSheetFormatPr) get_store().add_element_user(SHEETFORMATPR$6);
        }
        return cTSheetFormatPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetPr addNewSheetPr() {
        CTSheetPr cTSheetPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetPr = (CTSheetPr) get_store().add_element_user(SHEETPR$0);
        }
        return cTSheetPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetProtection addNewSheetProtection() {
        CTSheetProtection cTSheetProtection;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetProtection = (CTSheetProtection) get_store().add_element_user(SHEETPROTECTION$14);
        }
        return cTSheetProtection;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetViews addNewSheetViews() {
        CTSheetViews cTSheetViews;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetViews = (CTSheetViews) get_store().add_element_user(SHEETVIEWS$4);
        }
        return cTSheetViews;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSmartTags addNewSmartTags() {
        CTSmartTags cTSmartTagsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagsAdd_element_user = get_store().add_element_user(SMARTTAGS$56);
        }
        return cTSmartTagsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSortState addNewSortState() {
        CTSortState cTSortStateAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSortStateAdd_element_user = get_store().add_element_user(SORTSTATE$22);
        }
        return cTSortStateAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTTableParts addNewTableParts() {
        CTTableParts cTTableParts;
        synchronized (monitor()) {
            check_orphaned();
            cTTableParts = (CTTableParts) get_store().add_element_user(TABLEPARTS$72);
        }
        return cTTableParts;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTWebPublishItems addNewWebPublishItems() {
        CTWebPublishItems cTWebPublishItemsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWebPublishItemsAdd_element_user = get_store().add_element_user(WEBPUBLISHITEMS$70);
        }
        return cTWebPublishItemsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTAutoFilter getAutoFilter() {
        synchronized (monitor()) {
            check_orphaned();
            CTAutoFilter cTAutoFilter = (CTAutoFilter) get_store().find_element_user(AUTOFILTER$20, 0);
            if (cTAutoFilter == null) {
                return null;
            }
            return cTAutoFilter;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCellWatches getCellWatches() {
        synchronized (monitor()) {
            check_orphaned();
            CTCellWatches cTCellWatchesFind_element_user = get_store().find_element_user(CELLWATCHES$52, 0);
            if (cTCellWatchesFind_element_user == null) {
                return null;
            }
            return cTCellWatchesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageBreak getColBreaks() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageBreak cTPageBreak = (CTPageBreak) get_store().find_element_user(COLBREAKS$48, 0);
            if (cTPageBreak == null) {
                return null;
            }
            return cTPageBreak;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCols getColsArray(int i) {
        CTCols cTCols;
        synchronized (monitor()) {
            check_orphaned();
            cTCols = (CTCols) get_store().find_element_user(COLS$8, i);
            if (cTCols == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCols;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCols[] getColsArray() {
        CTCols[] cTColsArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COLS$8, arrayList);
            cTColsArr = new CTCols[arrayList.size()];
            arrayList.toArray(cTColsArr);
        }
        return cTColsArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public List<CTCols> getColsList() {
        1ColsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ColsList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTConditionalFormatting getConditionalFormattingArray(int i) {
        CTConditionalFormatting cTConditionalFormatting;
        synchronized (monitor()) {
            check_orphaned();
            cTConditionalFormatting = (CTConditionalFormatting) get_store().find_element_user(CONDITIONALFORMATTING$32, i);
            if (cTConditionalFormatting == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTConditionalFormatting;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTConditionalFormatting[] getConditionalFormattingArray() {
        CTConditionalFormatting[] cTConditionalFormattingArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CONDITIONALFORMATTING$32, arrayList);
            cTConditionalFormattingArr = new CTConditionalFormatting[arrayList.size()];
            arrayList.toArray(cTConditionalFormattingArr);
        }
        return cTConditionalFormattingArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public List<CTConditionalFormatting> getConditionalFormattingList() {
        1ConditionalFormattingList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ConditionalFormattingList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTControls getControls() {
        synchronized (monitor()) {
            check_orphaned();
            CTControls cTControlsFind_element_user = get_store().find_element_user(CONTROLS$68, 0);
            if (cTControlsFind_element_user == null) {
                return null;
            }
            return cTControlsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCustomProperties getCustomProperties() {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomProperties cTCustomPropertiesFind_element_user = get_store().find_element_user(CUSTOMPROPERTIES$50, 0);
            if (cTCustomPropertiesFind_element_user == null) {
                return null;
            }
            return cTCustomPropertiesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCustomSheetViews getCustomSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomSheetViews cTCustomSheetViewsFind_element_user = get_store().find_element_user(CUSTOMSHEETVIEWS$26, 0);
            if (cTCustomSheetViewsFind_element_user == null) {
                return null;
            }
            return cTCustomSheetViewsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDataConsolidate getDataConsolidate() {
        synchronized (monitor()) {
            check_orphaned();
            CTDataConsolidate cTDataConsolidateFind_element_user = get_store().find_element_user(DATACONSOLIDATE$24, 0);
            if (cTDataConsolidateFind_element_user == null) {
                return null;
            }
            return cTDataConsolidateFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDataValidations getDataValidations() {
        synchronized (monitor()) {
            check_orphaned();
            CTDataValidations cTDataValidations = (CTDataValidations) get_store().find_element_user(DATAVALIDATIONS$34, 0);
            if (cTDataValidations == null) {
                return null;
            }
            return cTDataValidations;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetDimension getDimension() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetDimension cTSheetDimension = (CTSheetDimension) get_store().find_element_user(DIMENSION$2, 0);
            if (cTSheetDimension == null) {
                return null;
            }
            return cTSheetDimension;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTDrawing getDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            CTDrawing cTDrawing = (CTDrawing) get_store().find_element_user(DRAWING$58, 0);
            if (cTDrawing == null) {
                return null;
            }
            return cTDrawing;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$74, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTHeaderFooter getHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            CTHeaderFooter cTHeaderFooter = (CTHeaderFooter) get_store().find_element_user(HEADERFOOTER$44, 0);
            if (cTHeaderFooter == null) {
                return null;
            }
            return cTHeaderFooter;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTHyperlinks getHyperlinks() {
        synchronized (monitor()) {
            check_orphaned();
            CTHyperlinks cTHyperlinks = (CTHyperlinks) get_store().find_element_user(HYPERLINKS$36, 0);
            if (cTHyperlinks == null) {
                return null;
            }
            return cTHyperlinks;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTIgnoredErrors getIgnoredErrors() {
        synchronized (monitor()) {
            check_orphaned();
            CTIgnoredErrors cTIgnoredErrors = (CTIgnoredErrors) get_store().find_element_user(IGNOREDERRORS$54, 0);
            if (cTIgnoredErrors == null) {
                return null;
            }
            return cTIgnoredErrors;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTLegacyDrawing getLegacyDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            CTLegacyDrawing cTLegacyDrawing = (CTLegacyDrawing) get_store().find_element_user(LEGACYDRAWING$60, 0);
            if (cTLegacyDrawing == null) {
                return null;
            }
            return cTLegacyDrawing;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTLegacyDrawing getLegacyDrawingHF() {
        synchronized (monitor()) {
            check_orphaned();
            CTLegacyDrawing cTLegacyDrawing = (CTLegacyDrawing) get_store().find_element_user(LEGACYDRAWINGHF$62, 0);
            if (cTLegacyDrawing == null) {
                return null;
            }
            return cTLegacyDrawing;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTMergeCells getMergeCells() {
        synchronized (monitor()) {
            check_orphaned();
            CTMergeCells cTMergeCells = (CTMergeCells) get_store().find_element_user(MERGECELLS$28, 0);
            if (cTMergeCells == null) {
                return null;
            }
            return cTMergeCells;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTOleObjects getOleObjects() {
        synchronized (monitor()) {
            check_orphaned();
            CTOleObjects cTOleObjects = (CTOleObjects) get_store().find_element_user(OLEOBJECTS$66, 0);
            if (cTOleObjects == null) {
                return null;
            }
            return cTOleObjects;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageMargins getPageMargins() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageMargins cTPageMargins = (CTPageMargins) get_store().find_element_user(PAGEMARGINS$40, 0);
            if (cTPageMargins == null) {
                return null;
            }
            return cTPageMargins;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageSetup getPageSetup() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageSetup cTPageSetup = (CTPageSetup) get_store().find_element_user(PAGESETUP$42, 0);
            if (cTPageSetup == null) {
                return null;
            }
            return cTPageSetup;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPhoneticPr getPhoneticPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTPhoneticPr cTPhoneticPr = (CTPhoneticPr) get_store().find_element_user(PHONETICPR$30, 0);
            if (cTPhoneticPr == null) {
                return null;
            }
            return cTPhoneticPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetBackgroundPicture getPicture() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetBackgroundPicture cTSheetBackgroundPictureFind_element_user = get_store().find_element_user(PICTURE$64, 0);
            if (cTSheetBackgroundPictureFind_element_user == null) {
                return null;
            }
            return cTSheetBackgroundPictureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPrintOptions getPrintOptions() {
        synchronized (monitor()) {
            check_orphaned();
            CTPrintOptions cTPrintOptions = (CTPrintOptions) get_store().find_element_user(PRINTOPTIONS$38, 0);
            if (cTPrintOptions == null) {
                return null;
            }
            return cTPrintOptions;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTProtectedRanges getProtectedRanges() {
        synchronized (monitor()) {
            check_orphaned();
            CTProtectedRanges cTProtectedRangesFind_element_user = get_store().find_element_user(PROTECTEDRANGES$16, 0);
            if (cTProtectedRangesFind_element_user == null) {
                return null;
            }
            return cTProtectedRangesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTPageBreak getRowBreaks() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageBreak cTPageBreak = (CTPageBreak) get_store().find_element_user(ROWBREAKS$46, 0);
            if (cTPageBreak == null) {
                return null;
            }
            return cTPageBreak;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTScenarios getScenarios() {
        synchronized (monitor()) {
            check_orphaned();
            CTScenarios cTScenariosFind_element_user = get_store().find_element_user(SCENARIOS$18, 0);
            if (cTScenariosFind_element_user == null) {
                return null;
            }
            return cTScenariosFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetCalcPr getSheetCalcPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetCalcPr cTSheetCalcPr = (CTSheetCalcPr) get_store().find_element_user(SHEETCALCPR$12, 0);
            if (cTSheetCalcPr == null) {
                return null;
            }
            return cTSheetCalcPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetData getSheetData() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetData cTSheetData = (CTSheetData) get_store().find_element_user(SHEETDATA$10, 0);
            if (cTSheetData == null) {
                return null;
            }
            return cTSheetData;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetFormatPr getSheetFormatPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetFormatPr cTSheetFormatPr = (CTSheetFormatPr) get_store().find_element_user(SHEETFORMATPR$6, 0);
            if (cTSheetFormatPr == null) {
                return null;
            }
            return cTSheetFormatPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetPr getSheetPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetPr cTSheetPr = (CTSheetPr) get_store().find_element_user(SHEETPR$0, 0);
            if (cTSheetPr == null) {
                return null;
            }
            return cTSheetPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetProtection getSheetProtection() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetProtection cTSheetProtection = (CTSheetProtection) get_store().find_element_user(SHEETPROTECTION$14, 0);
            if (cTSheetProtection == null) {
                return null;
            }
            return cTSheetProtection;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSheetViews getSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetViews cTSheetViews = (CTSheetViews) get_store().find_element_user(SHEETVIEWS$4, 0);
            if (cTSheetViews == null) {
                return null;
            }
            return cTSheetViews;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSmartTags getSmartTags() {
        synchronized (monitor()) {
            check_orphaned();
            CTSmartTags cTSmartTagsFind_element_user = get_store().find_element_user(SMARTTAGS$56, 0);
            if (cTSmartTagsFind_element_user == null) {
                return null;
            }
            return cTSmartTagsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTSortState getSortState() {
        synchronized (monitor()) {
            check_orphaned();
            CTSortState cTSortStateFind_element_user = get_store().find_element_user(SORTSTATE$22, 0);
            if (cTSortStateFind_element_user == null) {
                return null;
            }
            return cTSortStateFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTTableParts getTableParts() {
        synchronized (monitor()) {
            check_orphaned();
            CTTableParts cTTableParts = (CTTableParts) get_store().find_element_user(TABLEPARTS$72, 0);
            if (cTTableParts == null) {
                return null;
            }
            return cTTableParts;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTWebPublishItems getWebPublishItems() {
        synchronized (monitor()) {
            check_orphaned();
            CTWebPublishItems cTWebPublishItemsFind_element_user = get_store().find_element_user(WEBPUBLISHITEMS$70, 0);
            if (cTWebPublishItemsFind_element_user == null) {
                return null;
            }
            return cTWebPublishItemsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTCols insertNewCols(int i) {
        CTCols cTCols;
        synchronized (monitor()) {
            check_orphaned();
            cTCols = (CTCols) get_store().insert_element_user(COLS$8, i);
        }
        return cTCols;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public CTConditionalFormatting insertNewConditionalFormatting(int i) {
        CTConditionalFormatting cTConditionalFormatting;
        synchronized (monitor()) {
            check_orphaned();
            cTConditionalFormatting = (CTConditionalFormatting) get_store().insert_element_user(CONDITIONALFORMATTING$32, i);
        }
        return cTConditionalFormatting;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetAutoFilter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUTOFILTER$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetCellWatches() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CELLWATCHES$52) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetColBreaks() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COLBREAKS$48) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetControls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CONTROLS$68) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetCustomProperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTOMPROPERTIES$50) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetCustomSheetViews() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTOMSHEETVIEWS$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetDataConsolidate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DATACONSOLIDATE$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetDataValidations() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DATAVALIDATIONS$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetDimension() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DIMENSION$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetDrawing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DRAWING$58) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$74) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetHeaderFooter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HEADERFOOTER$44) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetHyperlinks() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HYPERLINKS$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetIgnoredErrors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(IGNOREDERRORS$54) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetLegacyDrawing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEGACYDRAWING$60) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetLegacyDrawingHF() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEGACYDRAWINGHF$62) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetMergeCells() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MERGECELLS$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetOleObjects() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OLEOBJECTS$66) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetPageMargins() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGEMARGINS$40) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetPageSetup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGESETUP$42) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetPhoneticPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PHONETICPR$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetPicture() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PICTURE$64) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetPrintOptions() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRINTOPTIONS$38) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetProtectedRanges() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROTECTEDRANGES$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetRowBreaks() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ROWBREAKS$46) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetScenarios() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SCENARIOS$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSheetCalcPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETCALCPR$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSheetFormatPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETFORMATPR$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSheetPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSheetProtection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETPROTECTION$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSheetViews() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETVIEWS$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSmartTags() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SMARTTAGS$56) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetSortState() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SORTSTATE$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetTableParts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TABLEPARTS$72) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public boolean isSetWebPublishItems() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WEBPUBLISHITEMS$70) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void removeCols(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLS$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void removeConditionalFormatting(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONDITIONALFORMATTING$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setAutoFilter(CTAutoFilter cTAutoFilter) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTOFILTER$20;
            CTAutoFilter cTAutoFilter2 = (CTAutoFilter) typeStore.find_element_user(qName, 0);
            if (cTAutoFilter2 == null) {
                cTAutoFilter2 = (CTAutoFilter) get_store().add_element_user(qName);
            }
            cTAutoFilter2.set(cTAutoFilter);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setCellWatches(CTCellWatches cTCellWatches) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CELLWATCHES$52;
            CTCellWatches cTCellWatchesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCellWatchesFind_element_user == null) {
                cTCellWatchesFind_element_user = (CTCellWatches) get_store().add_element_user(qName);
            }
            cTCellWatchesFind_element_user.set(cTCellWatches);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setColBreaks(CTPageBreak cTPageBreak) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLBREAKS$48;
            CTPageBreak cTPageBreak2 = (CTPageBreak) typeStore.find_element_user(qName, 0);
            if (cTPageBreak2 == null) {
                cTPageBreak2 = (CTPageBreak) get_store().add_element_user(qName);
            }
            cTPageBreak2.set(cTPageBreak);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setColsArray(int i, CTCols cTCols) {
        synchronized (monitor()) {
            check_orphaned();
            CTCols cTCols2 = (CTCols) get_store().find_element_user(COLS$8, i);
            if (cTCols2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCols2.set(cTCols);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setColsArray(CTCols[] cTColsArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTColsArr, COLS$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setConditionalFormattingArray(int i, CTConditionalFormatting cTConditionalFormatting) {
        synchronized (monitor()) {
            check_orphaned();
            CTConditionalFormatting cTConditionalFormatting2 = (CTConditionalFormatting) get_store().find_element_user(CONDITIONALFORMATTING$32, i);
            if (cTConditionalFormatting2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTConditionalFormatting2.set(cTConditionalFormatting);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setConditionalFormattingArray(CTConditionalFormatting[] cTConditionalFormattingArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTConditionalFormattingArr, CONDITIONALFORMATTING$32);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setControls(CTControls cTControls) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTROLS$68;
            CTControls cTControlsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTControlsFind_element_user == null) {
                cTControlsFind_element_user = (CTControls) get_store().add_element_user(qName);
            }
            cTControlsFind_element_user.set(cTControls);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setCustomProperties(CTCustomProperties cTCustomProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTOMPROPERTIES$50;
            CTCustomProperties cTCustomPropertiesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCustomPropertiesFind_element_user == null) {
                cTCustomPropertiesFind_element_user = (CTCustomProperties) get_store().add_element_user(qName);
            }
            cTCustomPropertiesFind_element_user.set(cTCustomProperties);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setCustomSheetViews(CTCustomSheetViews cTCustomSheetViews) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTOMSHEETVIEWS$26;
            CTCustomSheetViews cTCustomSheetViewsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCustomSheetViewsFind_element_user == null) {
                cTCustomSheetViewsFind_element_user = (CTCustomSheetViews) get_store().add_element_user(qName);
            }
            cTCustomSheetViewsFind_element_user.set(cTCustomSheetViews);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setDataConsolidate(CTDataConsolidate cTDataConsolidate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATACONSOLIDATE$24;
            CTDataConsolidate cTDataConsolidateFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDataConsolidateFind_element_user == null) {
                cTDataConsolidateFind_element_user = (CTDataConsolidate) get_store().add_element_user(qName);
            }
            cTDataConsolidateFind_element_user.set(cTDataConsolidate);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setDataValidations(CTDataValidations cTDataValidations) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATAVALIDATIONS$34;
            CTDataValidations cTDataValidations2 = (CTDataValidations) typeStore.find_element_user(qName, 0);
            if (cTDataValidations2 == null) {
                cTDataValidations2 = (CTDataValidations) get_store().add_element_user(qName);
            }
            cTDataValidations2.set(cTDataValidations);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setDimension(CTSheetDimension cTSheetDimension) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIMENSION$2;
            CTSheetDimension cTSheetDimension2 = (CTSheetDimension) typeStore.find_element_user(qName, 0);
            if (cTSheetDimension2 == null) {
                cTSheetDimension2 = (CTSheetDimension) get_store().add_element_user(qName);
            }
            cTSheetDimension2.set(cTSheetDimension);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setDrawing(CTDrawing cTDrawing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DRAWING$58;
            CTDrawing cTDrawing2 = (CTDrawing) typeStore.find_element_user(qName, 0);
            if (cTDrawing2 == null) {
                cTDrawing2 = (CTDrawing) get_store().add_element_user(qName);
            }
            cTDrawing2.set(cTDrawing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$74;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setHeaderFooter(CTHeaderFooter cTHeaderFooter) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADERFOOTER$44;
            CTHeaderFooter cTHeaderFooter2 = (CTHeaderFooter) typeStore.find_element_user(qName, 0);
            if (cTHeaderFooter2 == null) {
                cTHeaderFooter2 = (CTHeaderFooter) get_store().add_element_user(qName);
            }
            cTHeaderFooter2.set(cTHeaderFooter);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setHyperlinks(CTHyperlinks cTHyperlinks) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HYPERLINKS$36;
            CTHyperlinks cTHyperlinks2 = (CTHyperlinks) typeStore.find_element_user(qName, 0);
            if (cTHyperlinks2 == null) {
                cTHyperlinks2 = (CTHyperlinks) get_store().add_element_user(qName);
            }
            cTHyperlinks2.set(cTHyperlinks);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setIgnoredErrors(CTIgnoredErrors cTIgnoredErrors) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IGNOREDERRORS$54;
            CTIgnoredErrors cTIgnoredErrors2 = (CTIgnoredErrors) typeStore.find_element_user(qName, 0);
            if (cTIgnoredErrors2 == null) {
                cTIgnoredErrors2 = (CTIgnoredErrors) get_store().add_element_user(qName);
            }
            cTIgnoredErrors2.set(cTIgnoredErrors);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setLegacyDrawing(CTLegacyDrawing cTLegacyDrawing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEGACYDRAWING$60;
            CTLegacyDrawing cTLegacyDrawing2 = (CTLegacyDrawing) typeStore.find_element_user(qName, 0);
            if (cTLegacyDrawing2 == null) {
                cTLegacyDrawing2 = (CTLegacyDrawing) get_store().add_element_user(qName);
            }
            cTLegacyDrawing2.set(cTLegacyDrawing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setLegacyDrawingHF(CTLegacyDrawing cTLegacyDrawing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEGACYDRAWINGHF$62;
            CTLegacyDrawing cTLegacyDrawing2 = (CTLegacyDrawing) typeStore.find_element_user(qName, 0);
            if (cTLegacyDrawing2 == null) {
                cTLegacyDrawing2 = (CTLegacyDrawing) get_store().add_element_user(qName);
            }
            cTLegacyDrawing2.set(cTLegacyDrawing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setMergeCells(CTMergeCells cTMergeCells) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MERGECELLS$28;
            CTMergeCells cTMergeCells2 = (CTMergeCells) typeStore.find_element_user(qName, 0);
            if (cTMergeCells2 == null) {
                cTMergeCells2 = (CTMergeCells) get_store().add_element_user(qName);
            }
            cTMergeCells2.set(cTMergeCells);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setOleObjects(CTOleObjects cTOleObjects) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEOBJECTS$66;
            CTOleObjects cTOleObjects2 = (CTOleObjects) typeStore.find_element_user(qName, 0);
            if (cTOleObjects2 == null) {
                cTOleObjects2 = (CTOleObjects) get_store().add_element_user(qName);
            }
            cTOleObjects2.set(cTOleObjects);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setPageMargins(CTPageMargins cTPageMargins) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGEMARGINS$40;
            CTPageMargins cTPageMargins2 = (CTPageMargins) typeStore.find_element_user(qName, 0);
            if (cTPageMargins2 == null) {
                cTPageMargins2 = (CTPageMargins) get_store().add_element_user(qName);
            }
            cTPageMargins2.set(cTPageMargins);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setPageSetup(CTPageSetup cTPageSetup) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGESETUP$42;
            CTPageSetup cTPageSetup2 = (CTPageSetup) typeStore.find_element_user(qName, 0);
            if (cTPageSetup2 == null) {
                cTPageSetup2 = (CTPageSetup) get_store().add_element_user(qName);
            }
            cTPageSetup2.set(cTPageSetup);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setPhoneticPr(CTPhoneticPr cTPhoneticPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PHONETICPR$30;
            CTPhoneticPr cTPhoneticPr2 = (CTPhoneticPr) typeStore.find_element_user(qName, 0);
            if (cTPhoneticPr2 == null) {
                cTPhoneticPr2 = (CTPhoneticPr) get_store().add_element_user(qName);
            }
            cTPhoneticPr2.set(cTPhoneticPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setPicture(CTSheetBackgroundPicture cTSheetBackgroundPicture) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PICTURE$64;
            CTSheetBackgroundPicture cTSheetBackgroundPictureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSheetBackgroundPictureFind_element_user == null) {
                cTSheetBackgroundPictureFind_element_user = (CTSheetBackgroundPicture) get_store().add_element_user(qName);
            }
            cTSheetBackgroundPictureFind_element_user.set(cTSheetBackgroundPicture);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setPrintOptions(CTPrintOptions cTPrintOptions) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINTOPTIONS$38;
            CTPrintOptions cTPrintOptions2 = (CTPrintOptions) typeStore.find_element_user(qName, 0);
            if (cTPrintOptions2 == null) {
                cTPrintOptions2 = (CTPrintOptions) get_store().add_element_user(qName);
            }
            cTPrintOptions2.set(cTPrintOptions);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setProtectedRanges(CTProtectedRanges cTProtectedRanges) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROTECTEDRANGES$16;
            CTProtectedRanges cTProtectedRangesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTProtectedRangesFind_element_user == null) {
                cTProtectedRangesFind_element_user = (CTProtectedRanges) get_store().add_element_user(qName);
            }
            cTProtectedRangesFind_element_user.set(cTProtectedRanges);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setRowBreaks(CTPageBreak cTPageBreak) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROWBREAKS$46;
            CTPageBreak cTPageBreak2 = (CTPageBreak) typeStore.find_element_user(qName, 0);
            if (cTPageBreak2 == null) {
                cTPageBreak2 = (CTPageBreak) get_store().add_element_user(qName);
            }
            cTPageBreak2.set(cTPageBreak);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setScenarios(CTScenarios cTScenarios) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCENARIOS$18;
            CTScenarios cTScenariosFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTScenariosFind_element_user == null) {
                cTScenariosFind_element_user = (CTScenarios) get_store().add_element_user(qName);
            }
            cTScenariosFind_element_user.set(cTScenarios);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSheetCalcPr(CTSheetCalcPr cTSheetCalcPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETCALCPR$12;
            CTSheetCalcPr cTSheetCalcPr2 = (CTSheetCalcPr) typeStore.find_element_user(qName, 0);
            if (cTSheetCalcPr2 == null) {
                cTSheetCalcPr2 = (CTSheetCalcPr) get_store().add_element_user(qName);
            }
            cTSheetCalcPr2.set(cTSheetCalcPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSheetData(CTSheetData cTSheetData) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETDATA$10;
            CTSheetData cTSheetData2 = (CTSheetData) typeStore.find_element_user(qName, 0);
            if (cTSheetData2 == null) {
                cTSheetData2 = (CTSheetData) get_store().add_element_user(qName);
            }
            cTSheetData2.set(cTSheetData);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSheetFormatPr(CTSheetFormatPr cTSheetFormatPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETFORMATPR$6;
            CTSheetFormatPr cTSheetFormatPr2 = (CTSheetFormatPr) typeStore.find_element_user(qName, 0);
            if (cTSheetFormatPr2 == null) {
                cTSheetFormatPr2 = (CTSheetFormatPr) get_store().add_element_user(qName);
            }
            cTSheetFormatPr2.set(cTSheetFormatPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSheetPr(CTSheetPr cTSheetPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETPR$0;
            CTSheetPr cTSheetPr2 = (CTSheetPr) typeStore.find_element_user(qName, 0);
            if (cTSheetPr2 == null) {
                cTSheetPr2 = (CTSheetPr) get_store().add_element_user(qName);
            }
            cTSheetPr2.set(cTSheetPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSheetProtection(CTSheetProtection cTSheetProtection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETPROTECTION$14;
            CTSheetProtection cTSheetProtection2 = (CTSheetProtection) typeStore.find_element_user(qName, 0);
            if (cTSheetProtection2 == null) {
                cTSheetProtection2 = (CTSheetProtection) get_store().add_element_user(qName);
            }
            cTSheetProtection2.set(cTSheetProtection);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSheetViews(CTSheetViews cTSheetViews) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETVIEWS$4;
            CTSheetViews cTSheetViews2 = (CTSheetViews) typeStore.find_element_user(qName, 0);
            if (cTSheetViews2 == null) {
                cTSheetViews2 = (CTSheetViews) get_store().add_element_user(qName);
            }
            cTSheetViews2.set(cTSheetViews);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSmartTags(CTSmartTags cTSmartTags) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SMARTTAGS$56;
            CTSmartTags cTSmartTagsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSmartTagsFind_element_user == null) {
                cTSmartTagsFind_element_user = (CTSmartTags) get_store().add_element_user(qName);
            }
            cTSmartTagsFind_element_user.set(cTSmartTags);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setSortState(CTSortState cTSortState) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SORTSTATE$22;
            CTSortState cTSortStateFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSortStateFind_element_user == null) {
                cTSortStateFind_element_user = (CTSortState) get_store().add_element_user(qName);
            }
            cTSortStateFind_element_user.set(cTSortState);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setTableParts(CTTableParts cTTableParts) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLEPARTS$72;
            CTTableParts cTTableParts2 = (CTTableParts) typeStore.find_element_user(qName, 0);
            if (cTTableParts2 == null) {
                cTTableParts2 = (CTTableParts) get_store().add_element_user(qName);
            }
            cTTableParts2.set(cTTableParts);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void setWebPublishItems(CTWebPublishItems cTWebPublishItems) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WEBPUBLISHITEMS$70;
            CTWebPublishItems cTWebPublishItemsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTWebPublishItemsFind_element_user == null) {
                cTWebPublishItemsFind_element_user = (CTWebPublishItems) get_store().add_element_user(qName);
            }
            cTWebPublishItemsFind_element_user.set(cTWebPublishItems);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public int sizeOfColsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COLS$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public int sizeOfConditionalFormattingArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CONDITIONALFORMATTING$32);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetAutoFilter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOFILTER$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetCellWatches() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CELLWATCHES$52, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetColBreaks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLBREAKS$48, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetControls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONTROLS$68, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetCustomProperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMPROPERTIES$50, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetCustomSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMSHEETVIEWS$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetDataConsolidate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATACONSOLIDATE$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetDataValidations() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DATAVALIDATIONS$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetDimension() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DIMENSION$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DRAWING$58, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$74, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HEADERFOOTER$44, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetHyperlinks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HYPERLINKS$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetIgnoredErrors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IGNOREDERRORS$54, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetLegacyDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEGACYDRAWING$60, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetLegacyDrawingHF() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEGACYDRAWINGHF$62, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetMergeCells() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MERGECELLS$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetOleObjects() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OLEOBJECTS$66, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetPageMargins() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGEMARGINS$40, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetPageSetup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGESETUP$42, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetPhoneticPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PHONETICPR$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetPicture() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PICTURE$64, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetPrintOptions() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRINTOPTIONS$38, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetProtectedRanges() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROTECTEDRANGES$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetRowBreaks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ROWBREAKS$46, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetScenarios() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCENARIOS$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSheetCalcPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETCALCPR$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSheetFormatPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETFORMATPR$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSheetPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSheetProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETPROTECTION$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETVIEWS$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSmartTags() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMARTTAGS$56, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetSortState() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SORTSTATE$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetTableParts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABLEPARTS$72, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet
    public void unsetWebPublishItems() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WEBPUBLISHITEMS$70, 0);
        }
    }
}
