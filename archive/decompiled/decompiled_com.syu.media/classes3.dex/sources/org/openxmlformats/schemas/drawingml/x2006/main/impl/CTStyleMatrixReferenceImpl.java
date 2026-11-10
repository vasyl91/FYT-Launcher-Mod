package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
import org.openxmlformats.schemas.drawingml.x2006.main.STStyleMatrixColumnIndex;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTStyleMatrixReferenceImpl extends XmlComplexContentImpl implements CTStyleMatrixReference {
    private static final QName SCRGBCLR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "scrgbClr");
    private static final QName SRGBCLR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "srgbClr");
    private static final QName HSLCLR$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hslClr");
    private static final QName SYSCLR$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "sysClr");
    private static final QName SCHEMECLR$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "schemeClr");
    private static final QName PRSTCLR$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "prstClr");
    private static final QName IDX$12 = new QName("", "idx");

    public CTStyleMatrixReferenceImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public CTHslColor addNewHslClr() {
        CTHslColor cTHslColor;
        synchronized (monitor()) {
            check_orphaned();
            cTHslColor = (CTHslColor) get_store().add_element_user(HSLCLR$4);
        }
        return cTHslColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public CTPresetColor addNewPrstClr() {
        CTPresetColor cTPresetColor;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetColor = (CTPresetColor) get_store().add_element_user(PRSTCLR$10);
        }
        return cTPresetColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public CTSchemeColor addNewSchemeClr() {
        CTSchemeColor cTSchemeColor;
        synchronized (monitor()) {
            check_orphaned();
            cTSchemeColor = (CTSchemeColor) get_store().add_element_user(SCHEMECLR$8);
        }
        return cTSchemeColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public CTScRgbColor addNewScrgbClr() {
        CTScRgbColor cTScRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTScRgbColor = (CTScRgbColor) get_store().add_element_user(SCRGBCLR$0);
        }
        return cTScRgbColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public CTSRgbColor addNewSrgbClr() {
        CTSRgbColor cTSRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTSRgbColor = (CTSRgbColor) get_store().add_element_user(SRGBCLR$2);
        }
        return cTSRgbColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public CTSystemColor addNewSysClr() {
        CTSystemColor cTSystemColor;
        synchronized (monitor()) {
            check_orphaned();
            cTSystemColor = (CTSystemColor) get_store().add_element_user(SYSCLR$6);
        }
        return cTSystemColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public CTHslColor getHslClr() {
        synchronized (monitor()) {
            check_orphaned();
            CTHslColor cTHslColor = (CTHslColor) get_store().find_element_user(HSLCLR$4, 0);
            if (cTHslColor == null) {
                return null;
            }
            return cTHslColor;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public long getIdx() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(IDX$12);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public CTPresetColor getPrstClr() {
        synchronized (monitor()) {
            check_orphaned();
            CTPresetColor cTPresetColor = (CTPresetColor) get_store().find_element_user(PRSTCLR$10, 0);
            if (cTPresetColor == null) {
                return null;
            }
            return cTPresetColor;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public CTSchemeColor getSchemeClr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSchemeColor cTSchemeColor = (CTSchemeColor) get_store().find_element_user(SCHEMECLR$8, 0);
            if (cTSchemeColor == null) {
                return null;
            }
            return cTSchemeColor;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public CTScRgbColor getScrgbClr() {
        synchronized (monitor()) {
            check_orphaned();
            CTScRgbColor cTScRgbColor = (CTScRgbColor) get_store().find_element_user(SCRGBCLR$0, 0);
            if (cTScRgbColor == null) {
                return null;
            }
            return cTScRgbColor;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public CTSRgbColor getSrgbClr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSRgbColor cTSRgbColor = (CTSRgbColor) get_store().find_element_user(SRGBCLR$2, 0);
            if (cTSRgbColor == null) {
                return null;
            }
            return cTSRgbColor;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public CTSystemColor getSysClr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSystemColor cTSystemColor = (CTSystemColor) get_store().find_element_user(SYSCLR$6, 0);
            if (cTSystemColor == null) {
                return null;
            }
            return cTSystemColor;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public boolean isSetHslClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HSLCLR$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public boolean isSetPrstClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRSTCLR$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public boolean isSetSchemeClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SCHEMECLR$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public boolean isSetScrgbClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SCRGBCLR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public boolean isSetSrgbClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SRGBCLR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public boolean isSetSysClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SYSCLR$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void setHslClr(CTHslColor cTHslColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HSLCLR$4;
            CTHslColor cTHslColor2 = (CTHslColor) typeStore.find_element_user(qName, 0);
            if (cTHslColor2 == null) {
                cTHslColor2 = (CTHslColor) get_store().add_element_user(qName);
            }
            cTHslColor2.set(cTHslColor);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void setIdx(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void setPrstClr(CTPresetColor cTPresetColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRSTCLR$10;
            CTPresetColor cTPresetColor2 = (CTPresetColor) typeStore.find_element_user(qName, 0);
            if (cTPresetColor2 == null) {
                cTPresetColor2 = (CTPresetColor) get_store().add_element_user(qName);
            }
            cTPresetColor2.set(cTPresetColor);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void setSchemeClr(CTSchemeColor cTSchemeColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCHEMECLR$8;
            CTSchemeColor cTSchemeColor2 = (CTSchemeColor) typeStore.find_element_user(qName, 0);
            if (cTSchemeColor2 == null) {
                cTSchemeColor2 = (CTSchemeColor) get_store().add_element_user(qName);
            }
            cTSchemeColor2.set(cTSchemeColor);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void setScrgbClr(CTScRgbColor cTScRgbColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCRGBCLR$0;
            CTScRgbColor cTScRgbColor2 = (CTScRgbColor) typeStore.find_element_user(qName, 0);
            if (cTScRgbColor2 == null) {
                cTScRgbColor2 = (CTScRgbColor) get_store().add_element_user(qName);
            }
            cTScRgbColor2.set(cTScRgbColor);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void setSrgbClr(CTSRgbColor cTSRgbColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SRGBCLR$2;
            CTSRgbColor cTSRgbColor2 = (CTSRgbColor) typeStore.find_element_user(qName, 0);
            if (cTSRgbColor2 == null) {
                cTSRgbColor2 = (CTSRgbColor) get_store().add_element_user(qName);
            }
            cTSRgbColor2.set(cTSRgbColor);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void setSysClr(CTSystemColor cTSystemColor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SYSCLR$6;
            CTSystemColor cTSystemColor2 = (CTSystemColor) typeStore.find_element_user(qName, 0);
            if (cTSystemColor2 == null) {
                cTSystemColor2 = (CTSystemColor) get_store().add_element_user(qName);
            }
            cTSystemColor2.set(cTSystemColor);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void unsetHslClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HSLCLR$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void unsetPrstClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRSTCLR$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void unsetSchemeClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCHEMECLR$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void unsetScrgbClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCRGBCLR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void unsetSrgbClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SRGBCLR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void unsetSysClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SYSCLR$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public STStyleMatrixColumnIndex xgetIdx() {
        STStyleMatrixColumnIndex sTStyleMatrixColumnIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTStyleMatrixColumnIndex = (STStyleMatrixColumnIndex) get_store().find_attribute_user(IDX$12);
        }
        return sTStyleMatrixColumnIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference
    public void xsetIdx(STStyleMatrixColumnIndex sTStyleMatrixColumnIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$12;
            STStyleMatrixColumnIndex sTStyleMatrixColumnIndex2 = (STStyleMatrixColumnIndex) typeStore.find_attribute_user(qName);
            if (sTStyleMatrixColumnIndex2 == null) {
                sTStyleMatrixColumnIndex2 = (STStyleMatrixColumnIndex) get_store().add_attribute_user(qName);
            }
            sTStyleMatrixColumnIndex2.set(sTStyleMatrixColumnIndex);
        }
    }
}
