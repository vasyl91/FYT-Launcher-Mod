package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
import org.openxmlformats.schemas.drawingml.x2006.main.STFixedAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.STRectAlignment;
import org.openxmlformats.schemas.drawingml.x2006.main.STRectAlignment$Enum;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTOuterShadowEffectImpl extends XmlComplexContentImpl implements CTOuterShadowEffect {
    private static final QName SCRGBCLR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "scrgbClr");
    private static final QName SRGBCLR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "srgbClr");
    private static final QName HSLCLR$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hslClr");
    private static final QName SYSCLR$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "sysClr");
    private static final QName SCHEMECLR$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "schemeClr");
    private static final QName PRSTCLR$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "prstClr");
    private static final QName BLURRAD$12 = new QName("", "blurRad");
    private static final QName DIST$14 = new QName("", "dist");
    private static final QName DIR$16 = new QName("", "dir");
    private static final QName SX$18 = new QName("", "sx");
    private static final QName SY$20 = new QName("", "sy");
    private static final QName KX$22 = new QName("", "kx");
    private static final QName KY$24 = new QName("", "ky");
    private static final QName ALGN$26 = new QName("", "algn");
    private static final QName ROTWITHSHAPE$28 = new QName("", "rotWithShape");

    public CTOuterShadowEffectImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public CTHslColor addNewHslClr() {
        CTHslColor cTHslColor;
        synchronized (monitor()) {
            check_orphaned();
            cTHslColor = (CTHslColor) get_store().add_element_user(HSLCLR$4);
        }
        return cTHslColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public CTPresetColor addNewPrstClr() {
        CTPresetColor cTPresetColor;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetColor = (CTPresetColor) get_store().add_element_user(PRSTCLR$10);
        }
        return cTPresetColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public CTSchemeColor addNewSchemeClr() {
        CTSchemeColor cTSchemeColor;
        synchronized (monitor()) {
            check_orphaned();
            cTSchemeColor = (CTSchemeColor) get_store().add_element_user(SCHEMECLR$8);
        }
        return cTSchemeColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public CTScRgbColor addNewScrgbClr() {
        CTScRgbColor cTScRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTScRgbColor = (CTScRgbColor) get_store().add_element_user(SCRGBCLR$0);
        }
        return cTScRgbColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public CTSRgbColor addNewSrgbClr() {
        CTSRgbColor cTSRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTSRgbColor = (CTSRgbColor) get_store().add_element_user(SRGBCLR$2);
        }
        return cTSRgbColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public CTSystemColor addNewSysClr() {
        CTSystemColor cTSystemColor;
        synchronized (monitor()) {
            check_orphaned();
            cTSystemColor = (CTSystemColor) get_store().add_element_user(SYSCLR$6);
        }
        return cTSystemColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public STRectAlignment$Enum getAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGN$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STRectAlignment$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public long getBlurRad() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLURRAD$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public int getDir() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIR$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public long getDist() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIST$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public int getKx() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KX$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public int getKy() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KY$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean getRotWithShape() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTWITHSHAPE$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public int getSx() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SX$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public int getSy() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SY$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetAlgn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALGN$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetBlurRad() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BLURRAD$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetDir() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DIR$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetDist() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DIST$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetHslClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HSLCLR$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetKx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(KX$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetKy() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(KY$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetPrstClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRSTCLR$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetRotWithShape() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ROTWITHSHAPE$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetSchemeClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SCHEMECLR$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetScrgbClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SCRGBCLR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetSrgbClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SRGBCLR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetSx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SX$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetSy() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SY$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public boolean isSetSysClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SYSCLR$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void setAlgn(STRectAlignment$Enum sTRectAlignment$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGN$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTRectAlignment$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void setBlurRad(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLURRAD$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void setDir(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIR$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void setDist(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIST$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void setKx(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KX$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void setKy(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KY$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void setRotWithShape(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTWITHSHAPE$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void setSx(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SX$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void setSy(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SY$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALGN$26);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetBlurRad() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BLURRAD$12);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetDir() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DIR$16);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetDist() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DIST$14);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetHslClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HSLCLR$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetKx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(KX$22);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetKy() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(KY$24);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetPrstClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRSTCLR$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetRotWithShape() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ROTWITHSHAPE$28);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetSchemeClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCHEMECLR$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetScrgbClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCRGBCLR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetSrgbClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SRGBCLR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetSx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SX$18);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetSy() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SY$20);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void unsetSysClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SYSCLR$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public STRectAlignment xgetAlgn() {
        STRectAlignment sTRectAlignmentFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGN$26;
            sTRectAlignmentFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTRectAlignmentFind_attribute_user == null) {
                sTRectAlignmentFind_attribute_user = (STRectAlignment) get_default_attribute_value(qName);
            }
        }
        return sTRectAlignmentFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public STPositiveCoordinate xgetBlurRad() {
        STPositiveCoordinate sTPositiveCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLURRAD$12;
            sTPositiveCoordinate = (STPositiveCoordinate) typeStore.find_attribute_user(qName);
            if (sTPositiveCoordinate == null) {
                sTPositiveCoordinate = (STPositiveCoordinate) get_default_attribute_value(qName);
            }
        }
        return sTPositiveCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public STPositiveFixedAngle xgetDir() {
        STPositiveFixedAngle sTPositiveFixedAngle;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIR$16;
            sTPositiveFixedAngle = (STPositiveFixedAngle) typeStore.find_attribute_user(qName);
            if (sTPositiveFixedAngle == null) {
                sTPositiveFixedAngle = (STPositiveFixedAngle) get_default_attribute_value(qName);
            }
        }
        return sTPositiveFixedAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public STPositiveCoordinate xgetDist() {
        STPositiveCoordinate sTPositiveCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIST$14;
            sTPositiveCoordinate = (STPositiveCoordinate) typeStore.find_attribute_user(qName);
            if (sTPositiveCoordinate == null) {
                sTPositiveCoordinate = (STPositiveCoordinate) get_default_attribute_value(qName);
            }
        }
        return sTPositiveCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public STFixedAngle xgetKx() {
        STFixedAngle sTFixedAngleFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KX$22;
            sTFixedAngleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTFixedAngleFind_attribute_user == null) {
                sTFixedAngleFind_attribute_user = (STFixedAngle) get_default_attribute_value(qName);
            }
        }
        return sTFixedAngleFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public STFixedAngle xgetKy() {
        STFixedAngle sTFixedAngleFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KY$24;
            sTFixedAngleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTFixedAngleFind_attribute_user == null) {
                sTFixedAngleFind_attribute_user = (STFixedAngle) get_default_attribute_value(qName);
            }
        }
        return sTFixedAngleFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public XmlBoolean xgetRotWithShape() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTWITHSHAPE$28;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public STPercentage xgetSx() {
        STPercentage sTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SX$18;
            sTPercentage = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage == null) {
                sTPercentage = (STPercentage) get_default_attribute_value(qName);
            }
        }
        return sTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public STPercentage xgetSy() {
        STPercentage sTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SY$20;
            sTPercentage = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage == null) {
                sTPercentage = (STPercentage) get_default_attribute_value(qName);
            }
        }
        return sTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void xsetAlgn(STRectAlignment sTRectAlignment) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGN$26;
            STRectAlignment sTRectAlignmentFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTRectAlignmentFind_attribute_user == null) {
                sTRectAlignmentFind_attribute_user = (STRectAlignment) get_store().add_attribute_user(qName);
            }
            sTRectAlignmentFind_attribute_user.set(sTRectAlignment);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void xsetBlurRad(STPositiveCoordinate sTPositiveCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLURRAD$12;
            STPositiveCoordinate sTPositiveCoordinate2 = (STPositiveCoordinate) typeStore.find_attribute_user(qName);
            if (sTPositiveCoordinate2 == null) {
                sTPositiveCoordinate2 = (STPositiveCoordinate) get_store().add_attribute_user(qName);
            }
            sTPositiveCoordinate2.set(sTPositiveCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void xsetDir(STPositiveFixedAngle sTPositiveFixedAngle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIR$16;
            STPositiveFixedAngle sTPositiveFixedAngle2 = (STPositiveFixedAngle) typeStore.find_attribute_user(qName);
            if (sTPositiveFixedAngle2 == null) {
                sTPositiveFixedAngle2 = (STPositiveFixedAngle) get_store().add_attribute_user(qName);
            }
            sTPositiveFixedAngle2.set(sTPositiveFixedAngle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void xsetDist(STPositiveCoordinate sTPositiveCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIST$14;
            STPositiveCoordinate sTPositiveCoordinate2 = (STPositiveCoordinate) typeStore.find_attribute_user(qName);
            if (sTPositiveCoordinate2 == null) {
                sTPositiveCoordinate2 = (STPositiveCoordinate) get_store().add_attribute_user(qName);
            }
            sTPositiveCoordinate2.set(sTPositiveCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void xsetKx(STFixedAngle sTFixedAngle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KX$22;
            STFixedAngle sTFixedAngleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTFixedAngleFind_attribute_user == null) {
                sTFixedAngleFind_attribute_user = (STFixedAngle) get_store().add_attribute_user(qName);
            }
            sTFixedAngleFind_attribute_user.set(sTFixedAngle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void xsetKy(STFixedAngle sTFixedAngle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KY$24;
            STFixedAngle sTFixedAngleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTFixedAngleFind_attribute_user == null) {
                sTFixedAngleFind_attribute_user = (STFixedAngle) get_store().add_attribute_user(qName);
            }
            sTFixedAngleFind_attribute_user.set(sTFixedAngle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void xsetRotWithShape(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTWITHSHAPE$28;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void xsetSx(STPercentage sTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SX$18;
            STPercentage sTPercentage2 = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage2 == null) {
                sTPercentage2 = (STPercentage) get_store().add_attribute_user(qName);
            }
            sTPercentage2.set(sTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect
    public void xsetSy(STPercentage sTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SY$20;
            STPercentage sTPercentage2 = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage2 == null) {
                sTPercentage2 = (STPercentage) get_store().add_attribute_user(qName);
            }
            sTPercentage2.set(sTPercentage);
        }
    }
}
