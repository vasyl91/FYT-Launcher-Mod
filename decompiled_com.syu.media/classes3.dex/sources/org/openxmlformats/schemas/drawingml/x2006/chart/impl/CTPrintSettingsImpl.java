package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTHeaderFooter;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageSetup;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRelId;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPrintSettingsImpl extends XmlComplexContentImpl implements CTPrintSettings {
    private static final QName HEADERFOOTER$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "headerFooter");
    private static final QName PAGEMARGINS$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "pageMargins");
    private static final QName PAGESETUP$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "pageSetup");
    private static final QName LEGACYDRAWINGHF$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "legacyDrawingHF");

    public CTPrintSettingsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public CTHeaderFooter addNewHeaderFooter() {
        CTHeaderFooter cTHeaderFooter;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooter = (CTHeaderFooter) get_store().add_element_user(HEADERFOOTER$0);
        }
        return cTHeaderFooter;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public CTRelId addNewLegacyDrawingHF() {
        CTRelId cTRelIdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelIdAdd_element_user = get_store().add_element_user(LEGACYDRAWINGHF$6);
        }
        return cTRelIdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public CTPageMargins addNewPageMargins() {
        CTPageMargins cTPageMargins;
        synchronized (monitor()) {
            check_orphaned();
            cTPageMargins = (CTPageMargins) get_store().add_element_user(PAGEMARGINS$2);
        }
        return cTPageMargins;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public CTPageSetup addNewPageSetup() {
        CTPageSetup cTPageSetup;
        synchronized (monitor()) {
            check_orphaned();
            cTPageSetup = (CTPageSetup) get_store().add_element_user(PAGESETUP$4);
        }
        return cTPageSetup;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public CTHeaderFooter getHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            CTHeaderFooter cTHeaderFooter = (CTHeaderFooter) get_store().find_element_user(HEADERFOOTER$0, 0);
            if (cTHeaderFooter == null) {
                return null;
            }
            return cTHeaderFooter;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public CTRelId getLegacyDrawingHF() {
        synchronized (monitor()) {
            check_orphaned();
            CTRelId cTRelIdFind_element_user = get_store().find_element_user(LEGACYDRAWINGHF$6, 0);
            if (cTRelIdFind_element_user == null) {
                return null;
            }
            return cTRelIdFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public CTPageMargins getPageMargins() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageMargins cTPageMargins = (CTPageMargins) get_store().find_element_user(PAGEMARGINS$2, 0);
            if (cTPageMargins == null) {
                return null;
            }
            return cTPageMargins;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public CTPageSetup getPageSetup() {
        synchronized (monitor()) {
            check_orphaned();
            CTPageSetup cTPageSetup = (CTPageSetup) get_store().find_element_user(PAGESETUP$4, 0);
            if (cTPageSetup == null) {
                return null;
            }
            return cTPageSetup;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public boolean isSetHeaderFooter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HEADERFOOTER$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public boolean isSetLegacyDrawingHF() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEGACYDRAWINGHF$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public boolean isSetPageMargins() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGEMARGINS$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public boolean isSetPageSetup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGESETUP$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public void setHeaderFooter(CTHeaderFooter cTHeaderFooter) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADERFOOTER$0;
            CTHeaderFooter cTHeaderFooter2 = (CTHeaderFooter) typeStore.find_element_user(qName, 0);
            if (cTHeaderFooter2 == null) {
                cTHeaderFooter2 = (CTHeaderFooter) get_store().add_element_user(qName);
            }
            cTHeaderFooter2.set(cTHeaderFooter);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public void setLegacyDrawingHF(CTRelId cTRelId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEGACYDRAWINGHF$6;
            CTRelId cTRelIdFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRelIdFind_element_user == null) {
                cTRelIdFind_element_user = (CTRelId) get_store().add_element_user(qName);
            }
            cTRelIdFind_element_user.set(cTRelId);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public void setPageMargins(CTPageMargins cTPageMargins) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGEMARGINS$2;
            CTPageMargins cTPageMargins2 = (CTPageMargins) typeStore.find_element_user(qName, 0);
            if (cTPageMargins2 == null) {
                cTPageMargins2 = (CTPageMargins) get_store().add_element_user(qName);
            }
            cTPageMargins2.set(cTPageMargins);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public void setPageSetup(CTPageSetup cTPageSetup) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGESETUP$4;
            CTPageSetup cTPageSetup2 = (CTPageSetup) typeStore.find_element_user(qName, 0);
            if (cTPageSetup2 == null) {
                cTPageSetup2 = (CTPageSetup) get_store().add_element_user(qName);
            }
            cTPageSetup2.set(cTPageSetup);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public void unsetHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HEADERFOOTER$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public void unsetLegacyDrawingHF() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEGACYDRAWINGHF$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public void unsetPageMargins() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGEMARGINS$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings
    public void unsetPageSetup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGESETUP$4, 0);
        }
    }
}
