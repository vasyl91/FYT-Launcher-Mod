package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTDialogsheetImpl extends XmlComplexContentImpl implements CTDialogsheet {
    private static final QName SHEETPR$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetPr");
    private static final QName SHEETVIEWS$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetViews");
    private static final QName SHEETFORMATPR$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetFormatPr");
    private static final QName SHEETPROTECTION$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetProtection");
    private static final QName CUSTOMSHEETVIEWS$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customSheetViews");
    private static final QName PRINTOPTIONS$10 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "printOptions");
    private static final QName PAGEMARGINS$12 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageMargins");
    private static final QName PAGESETUP$14 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pageSetup");
    private static final QName HEADERFOOTER$16 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "headerFooter");
    private static final QName DRAWING$18 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "drawing");
    private static final QName LEGACYDRAWING$20 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawing");
    private static final QName LEGACYDRAWINGHF$22 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "legacyDrawingHF");
    private static final QName OLEOBJECTS$24 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "oleObjects");
    private static final QName EXTLST$26 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");

    public CTDialogsheetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTCustomSheetViews addNewCustomSheetViews() {
        CTCustomSheetViews cTCustomSheetViewsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomSheetViewsAdd_element_user = get_store().add_element_user(CUSTOMSHEETVIEWS$8);
        }
        return cTCustomSheetViewsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTDrawing addNewDrawing() {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawing = (CTDrawing) get_store().add_element_user(DRAWING$18);
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$26);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTHeaderFooter addNewHeaderFooter() {
        CTHeaderFooter cTHeaderFooter;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooter = (CTHeaderFooter) get_store().add_element_user(HEADERFOOTER$16);
        }
        return cTHeaderFooter;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTLegacyDrawing addNewLegacyDrawing() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().add_element_user(LEGACYDRAWING$20);
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTLegacyDrawing addNewLegacyDrawingHF() {
        CTLegacyDrawing cTLegacyDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTLegacyDrawing = (CTLegacyDrawing) get_store().add_element_user(LEGACYDRAWINGHF$22);
        }
        return cTLegacyDrawing;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTOleObjects addNewOleObjects() {
        CTOleObjects cTOleObjects;
        synchronized (monitor()) {
            check_orphaned();
            cTOleObjects = (CTOleObjects) get_store().add_element_user(OLEOBJECTS$24);
        }
        return cTOleObjects;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTPageMargins addNewPageMargins() {
        CTPageMargins cTPageMargins;
        synchronized (monitor()) {
            check_orphaned();
            cTPageMargins = (CTPageMargins) get_store().add_element_user(PAGEMARGINS$12);
        }
        return cTPageMargins;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTPageSetup addNewPageSetup() {
        CTPageSetup cTPageSetup;
        synchronized (monitor()) {
            check_orphaned();
            cTPageSetup = (CTPageSetup) get_store().add_element_user(PAGESETUP$14);
        }
        return cTPageSetup;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTPrintOptions addNewPrintOptions() {
        CTPrintOptions cTPrintOptions;
        synchronized (monitor()) {
            check_orphaned();
            cTPrintOptions = (CTPrintOptions) get_store().add_element_user(PRINTOPTIONS$10);
        }
        return cTPrintOptions;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTSheetFormatPr addNewSheetFormatPr() {
        CTSheetFormatPr cTSheetFormatPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetFormatPr = (CTSheetFormatPr) get_store().add_element_user(SHEETFORMATPR$4);
        }
        return cTSheetFormatPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTSheetPr addNewSheetPr() {
        CTSheetPr cTSheetPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetPr = (CTSheetPr) get_store().add_element_user(SHEETPR$0);
        }
        return cTSheetPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTSheetProtection addNewSheetProtection() {
        CTSheetProtection cTSheetProtection;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetProtection = (CTSheetProtection) get_store().add_element_user(SHEETPROTECTION$6);
        }
        return cTSheetProtection;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTSheetViews addNewSheetViews() {
        CTSheetViews cTSheetViews;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetViews = (CTSheetViews) get_store().add_element_user(SHEETVIEWS$2);
        }
        return cTSheetViews;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTCustomSheetViews getCustomSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomSheetViews cTCustomSheetViewsFind_element_user = get_store().find_element_user(CUSTOMSHEETVIEWS$8, 0);
            if (cTCustomSheetViewsFind_element_user == null) {
                return null;
            }
            return cTCustomSheetViewsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTDrawing getDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            CTDrawing cTDrawing = (CTDrawing) get_store().find_element_user(DRAWING$18, 0);
            if (cTDrawing == null) {
                return null;
            }
            return cTDrawing;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$26, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTHeaderFooter getHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            CTHeaderFooter cTHeaderFooter = (CTHeaderFooter) get_store().find_element_user(HEADERFOOTER$16, 0);
            if (cTHeaderFooter == null) {
                return null;
            }
            return cTHeaderFooter;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTLegacyDrawing getLegacyDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            CTLegacyDrawing cTLegacyDrawing = (CTLegacyDrawing) get_store().find_element_user(LEGACYDRAWING$20, 0);
            if (cTLegacyDrawing == null) {
                return null;
            }
            return cTLegacyDrawing;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTLegacyDrawing getLegacyDrawingHF() {
        synchronized (monitor()) {
            check_orphaned();
            CTLegacyDrawing cTLegacyDrawing = (CTLegacyDrawing) get_store().find_element_user(LEGACYDRAWINGHF$22, 0);
            if (cTLegacyDrawing == null) {
                return null;
            }
            return cTLegacyDrawing;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTOleObjects getOleObjects() {
        synchronized (monitor()) {
            check_orphaned();
            CTOleObjects cTOleObjects = (CTOleObjects) get_store().find_element_user(OLEOBJECTS$24, 0);
            if (cTOleObjects == null) {
                return null;
            }
            return cTOleObjects;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTPageMargins getPageMargins() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageMargins cTPageMargins = (CTPageMargins) get_store().find_element_user(PAGEMARGINS$12, 0);
            if (cTPageMargins == null) {
                return null;
            }
            return cTPageMargins;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTPageSetup getPageSetup() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageSetup cTPageSetup = (CTPageSetup) get_store().find_element_user(PAGESETUP$14, 0);
            if (cTPageSetup == null) {
                return null;
            }
            return cTPageSetup;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTPrintOptions getPrintOptions() {
        synchronized (monitor()) {
            check_orphaned();
            CTPrintOptions cTPrintOptions = (CTPrintOptions) get_store().find_element_user(PRINTOPTIONS$10, 0);
            if (cTPrintOptions == null) {
                return null;
            }
            return cTPrintOptions;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTSheetFormatPr getSheetFormatPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetFormatPr cTSheetFormatPr = (CTSheetFormatPr) get_store().find_element_user(SHEETFORMATPR$4, 0);
            if (cTSheetFormatPr == null) {
                return null;
            }
            return cTSheetFormatPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTSheetProtection getSheetProtection() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetProtection cTSheetProtection = (CTSheetProtection) get_store().find_element_user(SHEETPROTECTION$6, 0);
            if (cTSheetProtection == null) {
                return null;
            }
            return cTSheetProtection;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public CTSheetViews getSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheetViews cTSheetViews = (CTSheetViews) get_store().find_element_user(SHEETVIEWS$2, 0);
            if (cTSheetViews == null) {
                return null;
            }
            return cTSheetViews;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetCustomSheetViews() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTOMSHEETVIEWS$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetDrawing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DRAWING$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetHeaderFooter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HEADERFOOTER$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetLegacyDrawing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEGACYDRAWING$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetLegacyDrawingHF() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEGACYDRAWINGHF$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetOleObjects() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OLEOBJECTS$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetPageMargins() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGEMARGINS$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetPageSetup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGESETUP$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetPrintOptions() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRINTOPTIONS$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetSheetFormatPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETFORMATPR$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetSheetPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetSheetProtection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETPROTECTION$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public boolean isSetSheetViews() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHEETVIEWS$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setCustomSheetViews(CTCustomSheetViews cTCustomSheetViews) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTOMSHEETVIEWS$8;
            CTCustomSheetViews cTCustomSheetViewsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCustomSheetViewsFind_element_user == null) {
                cTCustomSheetViewsFind_element_user = (CTCustomSheetViews) get_store().add_element_user(qName);
            }
            cTCustomSheetViewsFind_element_user.set(cTCustomSheetViews);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setDrawing(CTDrawing cTDrawing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DRAWING$18;
            CTDrawing cTDrawing2 = (CTDrawing) typeStore.find_element_user(qName, 0);
            if (cTDrawing2 == null) {
                cTDrawing2 = (CTDrawing) get_store().add_element_user(qName);
            }
            cTDrawing2.set(cTDrawing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$26;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setHeaderFooter(CTHeaderFooter cTHeaderFooter) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADERFOOTER$16;
            CTHeaderFooter cTHeaderFooter2 = (CTHeaderFooter) typeStore.find_element_user(qName, 0);
            if (cTHeaderFooter2 == null) {
                cTHeaderFooter2 = (CTHeaderFooter) get_store().add_element_user(qName);
            }
            cTHeaderFooter2.set(cTHeaderFooter);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setLegacyDrawing(CTLegacyDrawing cTLegacyDrawing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEGACYDRAWING$20;
            CTLegacyDrawing cTLegacyDrawing2 = (CTLegacyDrawing) typeStore.find_element_user(qName, 0);
            if (cTLegacyDrawing2 == null) {
                cTLegacyDrawing2 = (CTLegacyDrawing) get_store().add_element_user(qName);
            }
            cTLegacyDrawing2.set(cTLegacyDrawing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setLegacyDrawingHF(CTLegacyDrawing cTLegacyDrawing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEGACYDRAWINGHF$22;
            CTLegacyDrawing cTLegacyDrawing2 = (CTLegacyDrawing) typeStore.find_element_user(qName, 0);
            if (cTLegacyDrawing2 == null) {
                cTLegacyDrawing2 = (CTLegacyDrawing) get_store().add_element_user(qName);
            }
            cTLegacyDrawing2.set(cTLegacyDrawing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setOleObjects(CTOleObjects cTOleObjects) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEOBJECTS$24;
            CTOleObjects cTOleObjects2 = (CTOleObjects) typeStore.find_element_user(qName, 0);
            if (cTOleObjects2 == null) {
                cTOleObjects2 = (CTOleObjects) get_store().add_element_user(qName);
            }
            cTOleObjects2.set(cTOleObjects);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setPageMargins(CTPageMargins cTPageMargins) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGEMARGINS$12;
            CTPageMargins cTPageMargins2 = (CTPageMargins) typeStore.find_element_user(qName, 0);
            if (cTPageMargins2 == null) {
                cTPageMargins2 = (CTPageMargins) get_store().add_element_user(qName);
            }
            cTPageMargins2.set(cTPageMargins);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setPageSetup(CTPageSetup cTPageSetup) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGESETUP$14;
            CTPageSetup cTPageSetup2 = (CTPageSetup) typeStore.find_element_user(qName, 0);
            if (cTPageSetup2 == null) {
                cTPageSetup2 = (CTPageSetup) get_store().add_element_user(qName);
            }
            cTPageSetup2.set(cTPageSetup);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setPrintOptions(CTPrintOptions cTPrintOptions) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINTOPTIONS$10;
            CTPrintOptions cTPrintOptions2 = (CTPrintOptions) typeStore.find_element_user(qName, 0);
            if (cTPrintOptions2 == null) {
                cTPrintOptions2 = (CTPrintOptions) get_store().add_element_user(qName);
            }
            cTPrintOptions2.set(cTPrintOptions);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setSheetFormatPr(CTSheetFormatPr cTSheetFormatPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETFORMATPR$4;
            CTSheetFormatPr cTSheetFormatPr2 = (CTSheetFormatPr) typeStore.find_element_user(qName, 0);
            if (cTSheetFormatPr2 == null) {
                cTSheetFormatPr2 = (CTSheetFormatPr) get_store().add_element_user(qName);
            }
            cTSheetFormatPr2.set(cTSheetFormatPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setSheetProtection(CTSheetProtection cTSheetProtection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETPROTECTION$6;
            CTSheetProtection cTSheetProtection2 = (CTSheetProtection) typeStore.find_element_user(qName, 0);
            if (cTSheetProtection2 == null) {
                cTSheetProtection2 = (CTSheetProtection) get_store().add_element_user(qName);
            }
            cTSheetProtection2.set(cTSheetProtection);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void setSheetViews(CTSheetViews cTSheetViews) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETVIEWS$2;
            CTSheetViews cTSheetViews2 = (CTSheetViews) typeStore.find_element_user(qName, 0);
            if (cTSheetViews2 == null) {
                cTSheetViews2 = (CTSheetViews) get_store().add_element_user(qName);
            }
            cTSheetViews2.set(cTSheetViews);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetCustomSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMSHEETVIEWS$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DRAWING$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HEADERFOOTER$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetLegacyDrawing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEGACYDRAWING$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetLegacyDrawingHF() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEGACYDRAWINGHF$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetOleObjects() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OLEOBJECTS$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetPageMargins() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGEMARGINS$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetPageSetup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGESETUP$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetPrintOptions() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRINTOPTIONS$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetSheetFormatPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETFORMATPR$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetSheetPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetSheetProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETPROTECTION$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet
    public void unsetSheetViews() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHEETVIEWS$2, 0);
        }
    }
}
