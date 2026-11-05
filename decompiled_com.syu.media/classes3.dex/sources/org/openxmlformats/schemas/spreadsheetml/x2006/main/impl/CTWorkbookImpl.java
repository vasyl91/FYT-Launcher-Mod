package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFileRecoveryPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFileSharing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFileVersion;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleSize;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSmartTagPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSmartTagTypes;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWebPublishObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWebPublishing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTWorkbookImpl extends XmlComplexContentImpl implements CTWorkbook {
    private static final QName FILEVERSION$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fileVersion");
    private static final QName FILESHARING$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fileSharing");
    private static final QName WORKBOOKPR$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "workbookPr");
    private static final QName WORKBOOKPROTECTION$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "workbookProtection");
    private static final QName BOOKVIEWS$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "bookViews");
    private static final QName SHEETS$10 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheets");
    private static final QName FUNCTIONGROUPS$12 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "functionGroups");
    private static final QName EXTERNALREFERENCES$14 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "externalReferences");
    private static final QName DEFINEDNAMES$16 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "definedNames");
    private static final QName CALCPR$18 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "calcPr");
    private static final QName OLESIZE$20 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "oleSize");
    private static final QName CUSTOMWORKBOOKVIEWS$22 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customWorkbookViews");
    private static final QName PIVOTCACHES$24 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pivotCaches");
    private static final QName SMARTTAGPR$26 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "smartTagPr");
    private static final QName SMARTTAGTYPES$28 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "smartTagTypes");
    private static final QName WEBPUBLISHING$30 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "webPublishing");
    private static final QName FILERECOVERYPR$32 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fileRecoveryPr");
    private static final QName WEBPUBLISHOBJECTS$34 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "webPublishObjects");
    private static final QName EXTLST$36 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");

    public CTWorkbookImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTBookViews addNewBookViews() {
        CTBookViews cTBookViews;
        synchronized (monitor()) {
            check_orphaned();
            cTBookViews = (CTBookViews) get_store().add_element_user(BOOKVIEWS$8);
        }
        return cTBookViews;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTCalcPr addNewCalcPr() {
        CTCalcPr cTCalcPr;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcPr = (CTCalcPr) get_store().add_element_user(CALCPR$18);
        }
        return cTCalcPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTCustomWorkbookViews addNewCustomWorkbookViews() {
        CTCustomWorkbookViews cTCustomWorkbookViewsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomWorkbookViewsAdd_element_user = get_store().add_element_user(CUSTOMWORKBOOKVIEWS$22);
        }
        return cTCustomWorkbookViewsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTDefinedNames addNewDefinedNames() {
        CTDefinedNames cTDefinedNames;
        synchronized (monitor()) {
            check_orphaned();
            cTDefinedNames = (CTDefinedNames) get_store().add_element_user(DEFINEDNAMES$16);
        }
        return cTDefinedNames;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$36);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTExternalReferences addNewExternalReferences() {
        CTExternalReferences cTExternalReferences;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalReferences = (CTExternalReferences) get_store().add_element_user(EXTERNALREFERENCES$14);
        }
        return cTExternalReferences;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileRecoveryPr addNewFileRecoveryPr() {
        CTFileRecoveryPr cTFileRecoveryPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFileRecoveryPrAdd_element_user = get_store().add_element_user(FILERECOVERYPR$32);
        }
        return cTFileRecoveryPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileSharing addNewFileSharing() {
        CTFileSharing cTFileSharingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFileSharingAdd_element_user = get_store().add_element_user(FILESHARING$2);
        }
        return cTFileSharingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileVersion addNewFileVersion() {
        CTFileVersion cTFileVersionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFileVersionAdd_element_user = get_store().add_element_user(FILEVERSION$0);
        }
        return cTFileVersionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFunctionGroups addNewFunctionGroups() {
        CTFunctionGroups cTFunctionGroupsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFunctionGroupsAdd_element_user = get_store().add_element_user(FUNCTIONGROUPS$12);
        }
        return cTFunctionGroupsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTOleSize addNewOleSize() {
        CTOleSize cTOleSizeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOleSizeAdd_element_user = get_store().add_element_user(OLESIZE$20);
        }
        return cTOleSizeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTPivotCaches addNewPivotCaches() {
        CTPivotCaches cTPivotCaches;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotCaches = (CTPivotCaches) get_store().add_element_user(PIVOTCACHES$24);
        }
        return cTPivotCaches;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTSheets addNewSheets() {
        CTSheets cTSheets;
        synchronized (monitor()) {
            check_orphaned();
            cTSheets = (CTSheets) get_store().add_element_user(SHEETS$10);
        }
        return cTSheets;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTSmartTagPr addNewSmartTagPr() {
        CTSmartTagPr cTSmartTagPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagPrAdd_element_user = get_store().add_element_user(SMARTTAGPR$26);
        }
        return cTSmartTagPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTSmartTagTypes addNewSmartTagTypes() {
        CTSmartTagTypes cTSmartTagTypesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagTypesAdd_element_user = get_store().add_element_user(SMARTTAGTYPES$28);
        }
        return cTSmartTagTypesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWebPublishObjects addNewWebPublishObjects() {
        CTWebPublishObjects cTWebPublishObjectsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWebPublishObjectsAdd_element_user = get_store().add_element_user(WEBPUBLISHOBJECTS$34);
        }
        return cTWebPublishObjectsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWebPublishing addNewWebPublishing() {
        CTWebPublishing cTWebPublishingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWebPublishingAdd_element_user = get_store().add_element_user(WEBPUBLISHING$30);
        }
        return cTWebPublishingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWorkbookPr addNewWorkbookPr() {
        CTWorkbookPr cTWorkbookPr;
        synchronized (monitor()) {
            check_orphaned();
            cTWorkbookPr = (CTWorkbookPr) get_store().add_element_user(WORKBOOKPR$4);
        }
        return cTWorkbookPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWorkbookProtection addNewWorkbookProtection() {
        CTWorkbookProtection cTWorkbookProtection;
        synchronized (monitor()) {
            check_orphaned();
            cTWorkbookProtection = (CTWorkbookProtection) get_store().add_element_user(WORKBOOKPROTECTION$6);
        }
        return cTWorkbookProtection;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTBookViews getBookViews() {
        synchronized (monitor()) {
            check_orphaned();
            CTBookViews cTBookViews = (CTBookViews) get_store().find_element_user(BOOKVIEWS$8, 0);
            if (cTBookViews == null) {
                return null;
            }
            return cTBookViews;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTCalcPr getCalcPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTCalcPr cTCalcPr = (CTCalcPr) get_store().find_element_user(CALCPR$18, 0);
            if (cTCalcPr == null) {
                return null;
            }
            return cTCalcPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTCustomWorkbookViews getCustomWorkbookViews() {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomWorkbookViews cTCustomWorkbookViewsFind_element_user = get_store().find_element_user(CUSTOMWORKBOOKVIEWS$22, 0);
            if (cTCustomWorkbookViewsFind_element_user == null) {
                return null;
            }
            return cTCustomWorkbookViewsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTDefinedNames getDefinedNames() {
        synchronized (monitor()) {
            check_orphaned();
            CTDefinedNames cTDefinedNames = (CTDefinedNames) get_store().find_element_user(DEFINEDNAMES$16, 0);
            if (cTDefinedNames == null) {
                return null;
            }
            return cTDefinedNames;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$36, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTExternalReferences getExternalReferences() {
        synchronized (monitor()) {
            check_orphaned();
            CTExternalReferences cTExternalReferences = (CTExternalReferences) get_store().find_element_user(EXTERNALREFERENCES$14, 0);
            if (cTExternalReferences == null) {
                return null;
            }
            return cTExternalReferences;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileRecoveryPr getFileRecoveryPrArray(int i) {
        CTFileRecoveryPr cTFileRecoveryPrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFileRecoveryPrFind_element_user = get_store().find_element_user(FILERECOVERYPR$32, i);
            if (cTFileRecoveryPrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFileRecoveryPrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileRecoveryPr[] getFileRecoveryPrArray() {
        CTFileRecoveryPr[] cTFileRecoveryPrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FILERECOVERYPR$32, arrayList);
            cTFileRecoveryPrArr = new CTFileRecoveryPr[arrayList.size()];
            arrayList.toArray(cTFileRecoveryPrArr);
        }
        return cTFileRecoveryPrArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public List<CTFileRecoveryPr> getFileRecoveryPrList() {
        1FileRecoveryPrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FileRecoveryPrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileSharing getFileSharing() {
        synchronized (monitor()) {
            check_orphaned();
            CTFileSharing cTFileSharingFind_element_user = get_store().find_element_user(FILESHARING$2, 0);
            if (cTFileSharingFind_element_user == null) {
                return null;
            }
            return cTFileSharingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileVersion getFileVersion() {
        synchronized (monitor()) {
            check_orphaned();
            CTFileVersion cTFileVersionFind_element_user = get_store().find_element_user(FILEVERSION$0, 0);
            if (cTFileVersionFind_element_user == null) {
                return null;
            }
            return cTFileVersionFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFunctionGroups getFunctionGroups() {
        synchronized (monitor()) {
            check_orphaned();
            CTFunctionGroups cTFunctionGroupsFind_element_user = get_store().find_element_user(FUNCTIONGROUPS$12, 0);
            if (cTFunctionGroupsFind_element_user == null) {
                return null;
            }
            return cTFunctionGroupsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTOleSize getOleSize() {
        synchronized (monitor()) {
            check_orphaned();
            CTOleSize cTOleSizeFind_element_user = get_store().find_element_user(OLESIZE$20, 0);
            if (cTOleSizeFind_element_user == null) {
                return null;
            }
            return cTOleSizeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTPivotCaches getPivotCaches() {
        synchronized (monitor()) {
            check_orphaned();
            CTPivotCaches cTPivotCaches = (CTPivotCaches) get_store().find_element_user(PIVOTCACHES$24, 0);
            if (cTPivotCaches == null) {
                return null;
            }
            return cTPivotCaches;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTSheets getSheets() {
        synchronized (monitor()) {
            check_orphaned();
            CTSheets cTSheets = (CTSheets) get_store().find_element_user(SHEETS$10, 0);
            if (cTSheets == null) {
                return null;
            }
            return cTSheets;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTSmartTagPr getSmartTagPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSmartTagPr cTSmartTagPrFind_element_user = get_store().find_element_user(SMARTTAGPR$26, 0);
            if (cTSmartTagPrFind_element_user == null) {
                return null;
            }
            return cTSmartTagPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTSmartTagTypes getSmartTagTypes() {
        synchronized (monitor()) {
            check_orphaned();
            CTSmartTagTypes cTSmartTagTypesFind_element_user = get_store().find_element_user(SMARTTAGTYPES$28, 0);
            if (cTSmartTagTypesFind_element_user == null) {
                return null;
            }
            return cTSmartTagTypesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWebPublishObjects getWebPublishObjects() {
        synchronized (monitor()) {
            check_orphaned();
            CTWebPublishObjects cTWebPublishObjectsFind_element_user = get_store().find_element_user(WEBPUBLISHOBJECTS$34, 0);
            if (cTWebPublishObjectsFind_element_user == null) {
                return null;
            }
            return cTWebPublishObjectsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWebPublishing getWebPublishing() {
        synchronized (monitor()) {
            check_orphaned();
            CTWebPublishing cTWebPublishingFind_element_user = get_store().find_element_user(WEBPUBLISHING$30, 0);
            if (cTWebPublishingFind_element_user == null) {
                return null;
            }
            return cTWebPublishingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWorkbookPr getWorkbookPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTWorkbookPr cTWorkbookPr = (CTWorkbookPr) get_store().find_element_user(WORKBOOKPR$4, 0);
            if (cTWorkbookPr == null) {
                return null;
            }
            return cTWorkbookPr;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTWorkbookProtection getWorkbookProtection() {
        synchronized (monitor()) {
            check_orphaned();
            CTWorkbookProtection cTWorkbookProtection = (CTWorkbookProtection) get_store().find_element_user(WORKBOOKPROTECTION$6, 0);
            if (cTWorkbookProtection == null) {
                return null;
            }
            return cTWorkbookProtection;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public CTFileRecoveryPr insertNewFileRecoveryPr(int i) {
        CTFileRecoveryPr cTFileRecoveryPrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFileRecoveryPrInsert_element_user = get_store().insert_element_user(FILERECOVERYPR$32, i);
        }
        return cTFileRecoveryPrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetBookViews() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOOKVIEWS$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetCalcPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CALCPR$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetCustomWorkbookViews() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTOMWORKBOOKVIEWS$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetDefinedNames() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DEFINEDNAMES$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$36) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetExternalReferences() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTERNALREFERENCES$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetFileSharing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FILESHARING$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetFileVersion() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FILEVERSION$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetFunctionGroups() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FUNCTIONGROUPS$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetOleSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OLESIZE$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetPivotCaches() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PIVOTCACHES$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetSmartTagPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SMARTTAGPR$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetSmartTagTypes() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SMARTTAGTYPES$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetWebPublishObjects() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WEBPUBLISHOBJECTS$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetWebPublishing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WEBPUBLISHING$30) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetWorkbookPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WORKBOOKPR$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public boolean isSetWorkbookProtection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WORKBOOKPROTECTION$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void removeFileRecoveryPr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILERECOVERYPR$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setBookViews(CTBookViews cTBookViews) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOOKVIEWS$8;
            CTBookViews cTBookViews2 = (CTBookViews) typeStore.find_element_user(qName, 0);
            if (cTBookViews2 == null) {
                cTBookViews2 = (CTBookViews) get_store().add_element_user(qName);
            }
            cTBookViews2.set(cTBookViews);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setCalcPr(CTCalcPr cTCalcPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CALCPR$18;
            CTCalcPr cTCalcPr2 = (CTCalcPr) typeStore.find_element_user(qName, 0);
            if (cTCalcPr2 == null) {
                cTCalcPr2 = (CTCalcPr) get_store().add_element_user(qName);
            }
            cTCalcPr2.set(cTCalcPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setCustomWorkbookViews(CTCustomWorkbookViews cTCustomWorkbookViews) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTOMWORKBOOKVIEWS$22;
            CTCustomWorkbookViews cTCustomWorkbookViewsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCustomWorkbookViewsFind_element_user == null) {
                cTCustomWorkbookViewsFind_element_user = (CTCustomWorkbookViews) get_store().add_element_user(qName);
            }
            cTCustomWorkbookViewsFind_element_user.set(cTCustomWorkbookViews);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setDefinedNames(CTDefinedNames cTDefinedNames) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFINEDNAMES$16;
            CTDefinedNames cTDefinedNames2 = (CTDefinedNames) typeStore.find_element_user(qName, 0);
            if (cTDefinedNames2 == null) {
                cTDefinedNames2 = (CTDefinedNames) get_store().add_element_user(qName);
            }
            cTDefinedNames2.set(cTDefinedNames);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$36;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setExternalReferences(CTExternalReferences cTExternalReferences) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTERNALREFERENCES$14;
            CTExternalReferences cTExternalReferences2 = (CTExternalReferences) typeStore.find_element_user(qName, 0);
            if (cTExternalReferences2 == null) {
                cTExternalReferences2 = (CTExternalReferences) get_store().add_element_user(qName);
            }
            cTExternalReferences2.set(cTExternalReferences);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setFileRecoveryPrArray(int i, CTFileRecoveryPr cTFileRecoveryPr) {
        synchronized (monitor()) {
            check_orphaned();
            CTFileRecoveryPr cTFileRecoveryPrFind_element_user = get_store().find_element_user(FILERECOVERYPR$32, i);
            if (cTFileRecoveryPrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFileRecoveryPrFind_element_user.set(cTFileRecoveryPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setFileRecoveryPrArray(CTFileRecoveryPr[] cTFileRecoveryPrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTFileRecoveryPrArr, FILERECOVERYPR$32);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setFileSharing(CTFileSharing cTFileSharing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILESHARING$2;
            CTFileSharing cTFileSharingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFileSharingFind_element_user == null) {
                cTFileSharingFind_element_user = (CTFileSharing) get_store().add_element_user(qName);
            }
            cTFileSharingFind_element_user.set(cTFileSharing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setFileVersion(CTFileVersion cTFileVersion) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILEVERSION$0;
            CTFileVersion cTFileVersionFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFileVersionFind_element_user == null) {
                cTFileVersionFind_element_user = (CTFileVersion) get_store().add_element_user(qName);
            }
            cTFileVersionFind_element_user.set(cTFileVersion);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setFunctionGroups(CTFunctionGroups cTFunctionGroups) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FUNCTIONGROUPS$12;
            CTFunctionGroups cTFunctionGroupsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFunctionGroupsFind_element_user == null) {
                cTFunctionGroupsFind_element_user = (CTFunctionGroups) get_store().add_element_user(qName);
            }
            cTFunctionGroupsFind_element_user.set(cTFunctionGroups);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setOleSize(CTOleSize cTOleSize) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLESIZE$20;
            CTOleSize cTOleSizeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOleSizeFind_element_user == null) {
                cTOleSizeFind_element_user = (CTOleSize) get_store().add_element_user(qName);
            }
            cTOleSizeFind_element_user.set(cTOleSize);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setPivotCaches(CTPivotCaches cTPivotCaches) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOTCACHES$24;
            CTPivotCaches cTPivotCaches2 = (CTPivotCaches) typeStore.find_element_user(qName, 0);
            if (cTPivotCaches2 == null) {
                cTPivotCaches2 = (CTPivotCaches) get_store().add_element_user(qName);
            }
            cTPivotCaches2.set(cTPivotCaches);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setSheets(CTSheets cTSheets) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHEETS$10;
            CTSheets cTSheets2 = (CTSheets) typeStore.find_element_user(qName, 0);
            if (cTSheets2 == null) {
                cTSheets2 = (CTSheets) get_store().add_element_user(qName);
            }
            cTSheets2.set(cTSheets);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setSmartTagPr(CTSmartTagPr cTSmartTagPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SMARTTAGPR$26;
            CTSmartTagPr cTSmartTagPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSmartTagPrFind_element_user == null) {
                cTSmartTagPrFind_element_user = (CTSmartTagPr) get_store().add_element_user(qName);
            }
            cTSmartTagPrFind_element_user.set(cTSmartTagPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setSmartTagTypes(CTSmartTagTypes cTSmartTagTypes) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SMARTTAGTYPES$28;
            CTSmartTagTypes cTSmartTagTypesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSmartTagTypesFind_element_user == null) {
                cTSmartTagTypesFind_element_user = (CTSmartTagTypes) get_store().add_element_user(qName);
            }
            cTSmartTagTypesFind_element_user.set(cTSmartTagTypes);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setWebPublishObjects(CTWebPublishObjects cTWebPublishObjects) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WEBPUBLISHOBJECTS$34;
            CTWebPublishObjects cTWebPublishObjectsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTWebPublishObjectsFind_element_user == null) {
                cTWebPublishObjectsFind_element_user = (CTWebPublishObjects) get_store().add_element_user(qName);
            }
            cTWebPublishObjectsFind_element_user.set(cTWebPublishObjects);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setWebPublishing(CTWebPublishing cTWebPublishing) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WEBPUBLISHING$30;
            CTWebPublishing cTWebPublishingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTWebPublishingFind_element_user == null) {
                cTWebPublishingFind_element_user = (CTWebPublishing) get_store().add_element_user(qName);
            }
            cTWebPublishingFind_element_user.set(cTWebPublishing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setWorkbookPr(CTWorkbookPr cTWorkbookPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WORKBOOKPR$4;
            CTWorkbookPr cTWorkbookPr2 = (CTWorkbookPr) typeStore.find_element_user(qName, 0);
            if (cTWorkbookPr2 == null) {
                cTWorkbookPr2 = (CTWorkbookPr) get_store().add_element_user(qName);
            }
            cTWorkbookPr2.set(cTWorkbookPr);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void setWorkbookProtection(CTWorkbookProtection cTWorkbookProtection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WORKBOOKPROTECTION$6;
            CTWorkbookProtection cTWorkbookProtection2 = (CTWorkbookProtection) typeStore.find_element_user(qName, 0);
            if (cTWorkbookProtection2 == null) {
                cTWorkbookProtection2 = (CTWorkbookProtection) get_store().add_element_user(qName);
            }
            cTWorkbookProtection2.set(cTWorkbookProtection);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public int sizeOfFileRecoveryPrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FILERECOVERYPR$32);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetBookViews() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKVIEWS$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetCalcPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALCPR$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetCustomWorkbookViews() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMWORKBOOKVIEWS$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetDefinedNames() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEFINEDNAMES$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$36, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetExternalReferences() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTERNALREFERENCES$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetFileSharing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILESHARING$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetFileVersion() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILEVERSION$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetFunctionGroups() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FUNCTIONGROUPS$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetOleSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OLESIZE$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetPivotCaches() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PIVOTCACHES$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetSmartTagPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMARTTAGPR$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetSmartTagTypes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMARTTAGTYPES$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetWebPublishObjects() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WEBPUBLISHOBJECTS$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetWebPublishing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WEBPUBLISHING$30, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetWorkbookPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WORKBOOKPR$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook
    public void unsetWorkbookProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WORKBOOKPROTECTION$6, 0);
        }
    }
}
