package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTComplementTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGammaTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGrayscaleTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInverseGammaTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInverseTransform;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositivePercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
import org.openxmlformats.schemas.drawingml.x2006.main.STHexBinary3;
import org.openxmlformats.schemas.drawingml.x2006.main.STSystemColorVal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSystemColorImpl extends XmlComplexContentImpl implements CTSystemColor {
    private static final QName TINT$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tint");
    private static final QName SHADE$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "shade");
    private static final QName COMP$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "comp");
    private static final QName INV$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "inv");
    private static final QName GRAY$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gray");
    private static final QName ALPHA$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alpha");
    private static final QName ALPHAOFF$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaOff");
    private static final QName ALPHAMOD$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaMod");
    private static final QName HUE$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hue");
    private static final QName HUEOFF$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hueOff");
    private static final QName HUEMOD$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hueMod");
    private static final QName SAT$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "sat");
    private static final QName SATOFF$24 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "satOff");
    private static final QName SATMOD$26 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "satMod");
    private static final QName LUM$28 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lum");
    private static final QName LUMOFF$30 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lumOff");
    private static final QName LUMMOD$32 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lumMod");
    private static final QName RED$34 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "red");
    private static final QName REDOFF$36 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "redOff");
    private static final QName REDMOD$38 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "redMod");
    private static final QName GREEN$40 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "green");
    private static final QName GREENOFF$42 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "greenOff");
    private static final QName GREENMOD$44 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "greenMod");
    private static final QName BLUE$46 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blue");
    private static final QName BLUEOFF$48 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blueOff");
    private static final QName BLUEMOD$50 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blueMod");
    private static final QName GAMMA$52 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gamma");
    private static final QName INVGAMMA$54 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "invGamma");
    private static final QName VAL$56 = new QName("", "val");
    private static final QName LASTCLR$58 = new QName("", "lastClr");

    public CTSystemColorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedPercentage addNewAlpha() {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().add_element_user(ALPHA$10);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositivePercentage addNewAlphaMod() {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().add_element_user(ALPHAMOD$14);
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTFixedPercentage addNewAlphaOff() {
        CTFixedPercentage cTFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTFixedPercentage = (CTFixedPercentage) get_store().add_element_user(ALPHAOFF$12);
        }
        return cTFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewBlue() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(BLUE$46);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewBlueMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(BLUEMOD$50);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewBlueOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(BLUEOFF$48);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTComplementTransform addNewComp() {
        CTComplementTransform cTComplementTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTComplementTransformAdd_element_user = get_store().add_element_user(COMP$4);
        }
        return cTComplementTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTGammaTransform addNewGamma() {
        CTGammaTransform cTGammaTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGammaTransformAdd_element_user = get_store().add_element_user(GAMMA$52);
        }
        return cTGammaTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTGrayscaleTransform addNewGray() {
        CTGrayscaleTransform cTGrayscaleTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleTransformAdd_element_user = get_store().add_element_user(GRAY$8);
        }
        return cTGrayscaleTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewGreen() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(GREEN$40);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewGreenMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(GREENMOD$44);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewGreenOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(GREENOFF$42);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedAngle addNewHue() {
        CTPositiveFixedAngle cTPositiveFixedAngleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedAngleAdd_element_user = get_store().add_element_user(HUE$16);
        }
        return cTPositiveFixedAngleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositivePercentage addNewHueMod() {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().add_element_user(HUEMOD$20);
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTAngle addNewHueOff() {
        CTAngle cTAngleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAngleAdd_element_user = get_store().add_element_user(HUEOFF$18);
        }
        return cTAngleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTInverseTransform addNewInv() {
        CTInverseTransform cTInverseTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseTransformAdd_element_user = get_store().add_element_user(INV$6);
        }
        return cTInverseTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTInverseGammaTransform addNewInvGamma() {
        CTInverseGammaTransform cTInverseGammaTransformAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseGammaTransformAdd_element_user = get_store().add_element_user(INVGAMMA$54);
        }
        return cTInverseGammaTransformAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewLum() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(LUM$28);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewLumMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(LUMMOD$32);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewLumOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(LUMOFF$30);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewRed() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(RED$34);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewRedMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(REDMOD$38);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewRedOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(REDOFF$36);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewSat() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(SAT$22);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewSatMod() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(SATMOD$26);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage addNewSatOff() {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().add_element_user(SATOFF$24);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedPercentage addNewShade() {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().add_element_user(SHADE$2);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedPercentage addNewTint() {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().add_element_user(TINT$0);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedPercentage getAlphaArray(int i) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().find_element_user(ALPHA$10, i);
            if (cTPositiveFixedPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedPercentage[] getAlphaArray() {
        CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALPHA$10, arrayList);
            cTPositiveFixedPercentageArr = new CTPositiveFixedPercentage[arrayList.size()];
            arrayList.toArray(cTPositiveFixedPercentageArr);
        }
        return cTPositiveFixedPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPositiveFixedPercentage> getAlphaList() {
        1AlphaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AlphaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositivePercentage getAlphaModArray(int i) {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().find_element_user(ALPHAMOD$14, i);
            if (cTPositivePercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositivePercentage[] getAlphaModArray() {
        CTPositivePercentage[] cTPositivePercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALPHAMOD$14, arrayList);
            cTPositivePercentageArr = new CTPositivePercentage[arrayList.size()];
            arrayList.toArray(cTPositivePercentageArr);
        }
        return cTPositivePercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPositivePercentage> getAlphaModList() {
        1AlphaModList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AlphaModList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTFixedPercentage getAlphaOffArray(int i) {
        CTFixedPercentage cTFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTFixedPercentage = (CTFixedPercentage) get_store().find_element_user(ALPHAOFF$12, i);
            if (cTFixedPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTFixedPercentage[] getAlphaOffArray() {
        CTFixedPercentage[] cTFixedPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALPHAOFF$12, arrayList);
            cTFixedPercentageArr = new CTFixedPercentage[arrayList.size()];
            arrayList.toArray(cTFixedPercentageArr);
        }
        return cTFixedPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTFixedPercentage> getAlphaOffList() {
        1AlphaOffList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AlphaOffList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getBlueArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(BLUE$46, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getBlueArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BLUE$46, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getBlueList() {
        1BlueList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BlueList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getBlueModArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(BLUEMOD$50, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getBlueModArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BLUEMOD$50, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getBlueModList() {
        1BlueModList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BlueModList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getBlueOffArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(BLUEOFF$48, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getBlueOffArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BLUEOFF$48, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getBlueOffList() {
        1BlueOffList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BlueOffList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTComplementTransform getCompArray(int i) {
        CTComplementTransform cTComplementTransformFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTComplementTransformFind_element_user = get_store().find_element_user(COMP$4, i);
            if (cTComplementTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTComplementTransformFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTComplementTransform[] getCompArray() {
        CTComplementTransform[] cTComplementTransformArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMP$4, arrayList);
            cTComplementTransformArr = new CTComplementTransform[arrayList.size()];
            arrayList.toArray(cTComplementTransformArr);
        }
        return cTComplementTransformArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTComplementTransform> getCompList() {
        1CompList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CompList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTGammaTransform getGammaArray(int i) {
        CTGammaTransform cTGammaTransformFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGammaTransformFind_element_user = get_store().find_element_user(GAMMA$52, i);
            if (cTGammaTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGammaTransformFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTGammaTransform[] getGammaArray() {
        CTGammaTransform[] cTGammaTransformArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GAMMA$52, arrayList);
            cTGammaTransformArr = new CTGammaTransform[arrayList.size()];
            arrayList.toArray(cTGammaTransformArr);
        }
        return cTGammaTransformArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTGammaTransform> getGammaList() {
        1GammaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GammaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTGrayscaleTransform getGrayArray(int i) {
        CTGrayscaleTransform cTGrayscaleTransformFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleTransformFind_element_user = get_store().find_element_user(GRAY$8, i);
            if (cTGrayscaleTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGrayscaleTransformFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTGrayscaleTransform[] getGrayArray() {
        CTGrayscaleTransform[] cTGrayscaleTransformArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GRAY$8, arrayList);
            cTGrayscaleTransformArr = new CTGrayscaleTransform[arrayList.size()];
            arrayList.toArray(cTGrayscaleTransformArr);
        }
        return cTGrayscaleTransformArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTGrayscaleTransform> getGrayList() {
        1GrayList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GrayList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getGreenArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(GREEN$40, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getGreenArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GREEN$40, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getGreenList() {
        1GreenList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GreenList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getGreenModArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(GREENMOD$44, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getGreenModArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GREENMOD$44, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getGreenModList() {
        1GreenModList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GreenModList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getGreenOffArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(GREENOFF$42, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getGreenOffArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GREENOFF$42, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getGreenOffList() {
        1GreenOffList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GreenOffList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedAngle getHueArray(int i) {
        CTPositiveFixedAngle cTPositiveFixedAngleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedAngleFind_element_user = get_store().find_element_user(HUE$16, i);
            if (cTPositiveFixedAngleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPositiveFixedAngleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedAngle[] getHueArray() {
        CTPositiveFixedAngle[] cTPositiveFixedAngleArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HUE$16, arrayList);
            cTPositiveFixedAngleArr = new CTPositiveFixedAngle[arrayList.size()];
            arrayList.toArray(cTPositiveFixedAngleArr);
        }
        return cTPositiveFixedAngleArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPositiveFixedAngle> getHueList() {
        1HueList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HueList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositivePercentage getHueModArray(int i) {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().find_element_user(HUEMOD$20, i);
            if (cTPositivePercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositivePercentage[] getHueModArray() {
        CTPositivePercentage[] cTPositivePercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HUEMOD$20, arrayList);
            cTPositivePercentageArr = new CTPositivePercentage[arrayList.size()];
            arrayList.toArray(cTPositivePercentageArr);
        }
        return cTPositivePercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPositivePercentage> getHueModList() {
        1HueModList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HueModList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTAngle getHueOffArray(int i) {
        CTAngle cTAngleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAngleFind_element_user = get_store().find_element_user(HUEOFF$18, i);
            if (cTAngleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAngleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTAngle[] getHueOffArray() {
        CTAngle[] cTAngleArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HUEOFF$18, arrayList);
            cTAngleArr = new CTAngle[arrayList.size()];
            arrayList.toArray(cTAngleArr);
        }
        return cTAngleArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTAngle> getHueOffList() {
        1HueOffList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HueOffList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTInverseTransform getInvArray(int i) {
        CTInverseTransform cTInverseTransformFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseTransformFind_element_user = get_store().find_element_user(INV$6, i);
            if (cTInverseTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTInverseTransformFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTInverseTransform[] getInvArray() {
        CTInverseTransform[] cTInverseTransformArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INV$6, arrayList);
            cTInverseTransformArr = new CTInverseTransform[arrayList.size()];
            arrayList.toArray(cTInverseTransformArr);
        }
        return cTInverseTransformArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTInverseGammaTransform getInvGammaArray(int i) {
        CTInverseGammaTransform cTInverseGammaTransformFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseGammaTransformFind_element_user = get_store().find_element_user(INVGAMMA$54, i);
            if (cTInverseGammaTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTInverseGammaTransformFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTInverseGammaTransform[] getInvGammaArray() {
        CTInverseGammaTransform[] cTInverseGammaTransformArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INVGAMMA$54, arrayList);
            cTInverseGammaTransformArr = new CTInverseGammaTransform[arrayList.size()];
            arrayList.toArray(cTInverseGammaTransformArr);
        }
        return cTInverseGammaTransformArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTInverseGammaTransform> getInvGammaList() {
        1InvGammaList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InvGammaList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTInverseTransform> getInvList() {
        1InvList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InvList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public byte[] getLastClr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LASTCLR$58);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getLumArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(LUM$28, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getLumArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LUM$28, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getLumList() {
        1LumList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LumList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getLumModArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(LUMMOD$32, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getLumModArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LUMMOD$32, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getLumModList() {
        1LumModList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LumModList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getLumOffArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(LUMOFF$30, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getLumOffArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LUMOFF$30, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getLumOffList() {
        1LumOffList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LumOffList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getRedArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(RED$34, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getRedArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RED$34, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getRedList() {
        1RedList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RedList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getRedModArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(REDMOD$38, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getRedModArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(REDMOD$38, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getRedModList() {
        1RedModList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RedModList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getRedOffArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(REDOFF$36, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getRedOffArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(REDOFF$36, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getRedOffList() {
        1RedOffList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RedOffList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getSatArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(SAT$22, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getSatArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SAT$22, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getSatList() {
        1SatList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SatList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getSatModArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(SATMOD$26, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getSatModArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SATMOD$26, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getSatModList() {
        1SatModList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SatModList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage getSatOffArray(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().find_element_user(SATOFF$24, i);
            if (cTPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage[] getSatOffArray() {
        CTPercentage[] cTPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SATOFF$24, arrayList);
            cTPercentageArr = new CTPercentage[arrayList.size()];
            arrayList.toArray(cTPercentageArr);
        }
        return cTPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPercentage> getSatOffList() {
        1SatOffList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SatOffList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedPercentage getShadeArray(int i) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().find_element_user(SHADE$2, i);
            if (cTPositiveFixedPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedPercentage[] getShadeArray() {
        CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHADE$2, arrayList);
            cTPositiveFixedPercentageArr = new CTPositiveFixedPercentage[arrayList.size()];
            arrayList.toArray(cTPositiveFixedPercentageArr);
        }
        return cTPositiveFixedPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPositiveFixedPercentage> getShadeList() {
        1ShadeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShadeList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedPercentage getTintArray(int i) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().find_element_user(TINT$0, i);
            if (cTPositiveFixedPercentage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedPercentage[] getTintArray() {
        CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TINT$0, arrayList);
            cTPositiveFixedPercentageArr = new CTPositiveFixedPercentage[arrayList.size()];
            arrayList.toArray(cTPositiveFixedPercentageArr);
        }
        return cTPositiveFixedPercentageArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public List<CTPositiveFixedPercentage> getTintList() {
        1TintList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TintList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public STSystemColorVal.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VAL$56);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STSystemColorVal.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedPercentage insertNewAlpha(int i) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().insert_element_user(ALPHA$10, i);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositivePercentage insertNewAlphaMod(int i) {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().insert_element_user(ALPHAMOD$14, i);
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTFixedPercentage insertNewAlphaOff(int i) {
        CTFixedPercentage cTFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTFixedPercentage = (CTFixedPercentage) get_store().insert_element_user(ALPHAOFF$12, i);
        }
        return cTFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewBlue(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(BLUE$46, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewBlueMod(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(BLUEMOD$50, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewBlueOff(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(BLUEOFF$48, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTComplementTransform insertNewComp(int i) {
        CTComplementTransform cTComplementTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTComplementTransformInsert_element_user = get_store().insert_element_user(COMP$4, i);
        }
        return cTComplementTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTGammaTransform insertNewGamma(int i) {
        CTGammaTransform cTGammaTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGammaTransformInsert_element_user = get_store().insert_element_user(GAMMA$52, i);
        }
        return cTGammaTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTGrayscaleTransform insertNewGray(int i) {
        CTGrayscaleTransform cTGrayscaleTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleTransformInsert_element_user = get_store().insert_element_user(GRAY$8, i);
        }
        return cTGrayscaleTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewGreen(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(GREEN$40, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewGreenMod(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(GREENMOD$44, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewGreenOff(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(GREENOFF$42, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedAngle insertNewHue(int i) {
        CTPositiveFixedAngle cTPositiveFixedAngleInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedAngleInsert_element_user = get_store().insert_element_user(HUE$16, i);
        }
        return cTPositiveFixedAngleInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositivePercentage insertNewHueMod(int i) {
        CTPositivePercentage cTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositivePercentage = (CTPositivePercentage) get_store().insert_element_user(HUEMOD$20, i);
        }
        return cTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTAngle insertNewHueOff(int i) {
        CTAngle cTAngleInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAngleInsert_element_user = get_store().insert_element_user(HUEOFF$18, i);
        }
        return cTAngleInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTInverseTransform insertNewInv(int i) {
        CTInverseTransform cTInverseTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseTransformInsert_element_user = get_store().insert_element_user(INV$6, i);
        }
        return cTInverseTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTInverseGammaTransform insertNewInvGamma(int i) {
        CTInverseGammaTransform cTInverseGammaTransformInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInverseGammaTransformInsert_element_user = get_store().insert_element_user(INVGAMMA$54, i);
        }
        return cTInverseGammaTransformInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewLum(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(LUM$28, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewLumMod(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(LUMMOD$32, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewLumOff(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(LUMOFF$30, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewRed(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(RED$34, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewRedMod(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(REDMOD$38, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewRedOff(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(REDOFF$36, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewSat(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(SAT$22, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewSatMod(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(SATMOD$26, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPercentage insertNewSatOff(int i) {
        CTPercentage cTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPercentage = (CTPercentage) get_store().insert_element_user(SATOFF$24, i);
        }
        return cTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedPercentage insertNewShade(int i) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().insert_element_user(SHADE$2, i);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public CTPositiveFixedPercentage insertNewTint(int i) {
        CTPositiveFixedPercentage cTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveFixedPercentage = (CTPositiveFixedPercentage) get_store().insert_element_user(TINT$0, i);
        }
        return cTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public boolean isSetLastClr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LASTCLR$58) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeAlpha(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALPHA$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeAlphaMod(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALPHAMOD$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeAlphaOff(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALPHAOFF$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeBlue(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLUE$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeBlueMod(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLUEMOD$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeBlueOff(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLUEOFF$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeComp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMP$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeGamma(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GAMMA$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeGray(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRAY$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeGreen(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GREEN$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeGreenMod(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GREENMOD$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeGreenOff(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GREENOFF$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeHue(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HUE$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeHueMod(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HUEMOD$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeHueOff(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HUEOFF$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeInv(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INV$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeInvGamma(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INVGAMMA$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeLum(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LUM$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeLumMod(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LUMMOD$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeLumOff(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LUMOFF$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeRed(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RED$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeRedMod(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REDMOD$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeRedOff(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REDOFF$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeSat(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SAT$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeSatMod(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SATMOD$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeSatOff(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SATOFF$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeShade(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADE$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void removeTint(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TINT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setAlphaArray(int i, CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPositiveFixedPercentage cTPositiveFixedPercentage2 = (CTPositiveFixedPercentage) get_store().find_element_user(ALPHA$10, i);
            if (cTPositiveFixedPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPositiveFixedPercentage2.set(cTPositiveFixedPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setAlphaArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPositiveFixedPercentageArr, ALPHA$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setAlphaModArray(int i, CTPositivePercentage cTPositivePercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPositivePercentage cTPositivePercentage2 = (CTPositivePercentage) get_store().find_element_user(ALPHAMOD$14, i);
            if (cTPositivePercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPositivePercentage2.set(cTPositivePercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setAlphaModArray(CTPositivePercentage[] cTPositivePercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPositivePercentageArr, ALPHAMOD$14);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setAlphaOffArray(int i, CTFixedPercentage cTFixedPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTFixedPercentage cTFixedPercentage2 = (CTFixedPercentage) get_store().find_element_user(ALPHAOFF$12, i);
            if (cTFixedPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFixedPercentage2.set(cTFixedPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setAlphaOffArray(CTFixedPercentage[] cTFixedPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFixedPercentageArr, ALPHAOFF$12);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setBlueArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(BLUE$46, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setBlueArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, BLUE$46);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setBlueModArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(BLUEMOD$50, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setBlueModArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, BLUEMOD$50);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setBlueOffArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(BLUEOFF$48, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setBlueOffArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, BLUEOFF$48);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setCompArray(int i, CTComplementTransform cTComplementTransform) {
        synchronized (monitor()) {
            check_orphaned();
            CTComplementTransform cTComplementTransformFind_element_user = get_store().find_element_user(COMP$4, i);
            if (cTComplementTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTComplementTransformFind_element_user.set(cTComplementTransform);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setCompArray(CTComplementTransform[] cTComplementTransformArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTComplementTransformArr, COMP$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setGammaArray(int i, CTGammaTransform cTGammaTransform) {
        synchronized (monitor()) {
            check_orphaned();
            CTGammaTransform cTGammaTransformFind_element_user = get_store().find_element_user(GAMMA$52, i);
            if (cTGammaTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTGammaTransformFind_element_user.set(cTGammaTransform);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setGammaArray(CTGammaTransform[] cTGammaTransformArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTGammaTransformArr, GAMMA$52);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setGrayArray(int i, CTGrayscaleTransform cTGrayscaleTransform) {
        synchronized (monitor()) {
            check_orphaned();
            CTGrayscaleTransform cTGrayscaleTransformFind_element_user = get_store().find_element_user(GRAY$8, i);
            if (cTGrayscaleTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTGrayscaleTransformFind_element_user.set(cTGrayscaleTransform);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setGrayArray(CTGrayscaleTransform[] cTGrayscaleTransformArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTGrayscaleTransformArr, GRAY$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setGreenArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(GREEN$40, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setGreenArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, GREEN$40);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setGreenModArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(GREENMOD$44, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setGreenModArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, GREENMOD$44);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setGreenOffArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(GREENOFF$42, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setGreenOffArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, GREENOFF$42);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setHueArray(int i, CTPositiveFixedAngle cTPositiveFixedAngle) {
        synchronized (monitor()) {
            check_orphaned();
            CTPositiveFixedAngle cTPositiveFixedAngleFind_element_user = get_store().find_element_user(HUE$16, i);
            if (cTPositiveFixedAngleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPositiveFixedAngleFind_element_user.set(cTPositiveFixedAngle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setHueArray(CTPositiveFixedAngle[] cTPositiveFixedAngleArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPositiveFixedAngleArr, HUE$16);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setHueModArray(int i, CTPositivePercentage cTPositivePercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPositivePercentage cTPositivePercentage2 = (CTPositivePercentage) get_store().find_element_user(HUEMOD$20, i);
            if (cTPositivePercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPositivePercentage2.set(cTPositivePercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setHueModArray(CTPositivePercentage[] cTPositivePercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPositivePercentageArr, HUEMOD$20);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setHueOffArray(int i, CTAngle cTAngle) {
        synchronized (monitor()) {
            check_orphaned();
            CTAngle cTAngleFind_element_user = get_store().find_element_user(HUEOFF$18, i);
            if (cTAngleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTAngleFind_element_user.set(cTAngle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setHueOffArray(CTAngle[] cTAngleArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAngleArr, HUEOFF$18);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setInvArray(int i, CTInverseTransform cTInverseTransform) {
        synchronized (monitor()) {
            check_orphaned();
            CTInverseTransform cTInverseTransformFind_element_user = get_store().find_element_user(INV$6, i);
            if (cTInverseTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTInverseTransformFind_element_user.set(cTInverseTransform);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setInvArray(CTInverseTransform[] cTInverseTransformArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTInverseTransformArr, INV$6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setInvGammaArray(int i, CTInverseGammaTransform cTInverseGammaTransform) {
        synchronized (monitor()) {
            check_orphaned();
            CTInverseGammaTransform cTInverseGammaTransformFind_element_user = get_store().find_element_user(INVGAMMA$54, i);
            if (cTInverseGammaTransformFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTInverseGammaTransformFind_element_user.set(cTInverseGammaTransform);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setInvGammaArray(CTInverseGammaTransform[] cTInverseGammaTransformArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTInverseGammaTransformArr, INVGAMMA$54);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setLastClr(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LASTCLR$58;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setLumArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(LUM$28, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setLumArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, LUM$28);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setLumModArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(LUMMOD$32, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setLumModArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, LUMMOD$32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setLumOffArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(LUMOFF$30, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setLumOffArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, LUMOFF$30);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setRedArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(RED$34, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setRedArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, RED$34);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setRedModArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(REDMOD$38, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setRedModArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, REDMOD$38);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setRedOffArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(REDOFF$36, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setRedOffArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, REDOFF$36);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setSatArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(SAT$22, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setSatArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, SAT$22);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setSatModArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(SATMOD$26, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setSatModArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, SATMOD$26);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setSatOffArray(int i, CTPercentage cTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPercentage cTPercentage2 = (CTPercentage) get_store().find_element_user(SATOFF$24, i);
            if (cTPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPercentage2.set(cTPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setSatOffArray(CTPercentage[] cTPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPercentageArr, SATOFF$24);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setShadeArray(int i, CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPositiveFixedPercentage cTPositiveFixedPercentage2 = (CTPositiveFixedPercentage) get_store().find_element_user(SHADE$2, i);
            if (cTPositiveFixedPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPositiveFixedPercentage2.set(cTPositiveFixedPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setShadeArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPositiveFixedPercentageArr, SHADE$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setTintArray(int i, CTPositiveFixedPercentage cTPositiveFixedPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            CTPositiveFixedPercentage cTPositiveFixedPercentage2 = (CTPositiveFixedPercentage) get_store().find_element_user(TINT$0, i);
            if (cTPositiveFixedPercentage2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPositiveFixedPercentage2.set(cTPositiveFixedPercentage);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setTintArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPositiveFixedPercentageArr, TINT$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void setVal(STSystemColorVal.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$56;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfAlphaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ALPHA$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfAlphaModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ALPHAMOD$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfAlphaOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ALPHAOFF$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfBlueArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BLUE$46);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfBlueModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BLUEMOD$50);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfBlueOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BLUEOFF$48);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfCompArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMP$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfGammaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GAMMA$52);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfGrayArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GRAY$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfGreenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GREEN$40);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfGreenModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GREENMOD$44);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfGreenOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GREENOFF$42);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfHueArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(HUE$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfHueModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(HUEMOD$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfHueOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(HUEOFF$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfInvArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INV$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfInvGammaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INVGAMMA$54);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfLumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LUM$28);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfLumModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LUMMOD$32);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfLumOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LUMOFF$30);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfRedArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(RED$34);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfRedModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(REDMOD$38);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfRedOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(REDOFF$36);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfSatArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SAT$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfSatModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SATMOD$26);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfSatOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SATOFF$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfShadeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHADE$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public int sizeOfTintArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TINT$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void unsetLastClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LASTCLR$58);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public STHexBinary3 xgetLastClr() {
        STHexBinary3 sTHexBinary3;
        synchronized (monitor()) {
            check_orphaned();
            sTHexBinary3 = (STHexBinary3) get_store().find_attribute_user(LASTCLR$58);
        }
        return sTHexBinary3;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public STSystemColorVal xgetVal() {
        STSystemColorVal sTSystemColorVal;
        synchronized (monitor()) {
            check_orphaned();
            sTSystemColorVal = (STSystemColorVal) get_store().find_attribute_user(VAL$56);
        }
        return sTSystemColorVal;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void xsetLastClr(STHexBinary3 sTHexBinary3) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LASTCLR$58;
            STHexBinary3 sTHexBinary4 = (STHexBinary3) typeStore.find_attribute_user(qName);
            if (sTHexBinary4 == null) {
                sTHexBinary4 = (STHexBinary3) get_store().add_attribute_user(qName);
            }
            sTHexBinary4.set(sTHexBinary3);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor
    public void xsetVal(STSystemColorVal sTSystemColorVal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$56;
            STSystemColorVal sTSystemColorVal2 = (STSystemColorVal) typeStore.find_attribute_user(qName);
            if (sTSystemColorVal2 == null) {
                sTSystemColorVal2 = (STSystemColorVal) get_store().add_attribute_user(qName);
            }
            sTSystemColorVal2.set((XmlObject) sTSystemColorVal);
        }
    }
}
