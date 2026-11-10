package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlurEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillOverlayEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGlowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInnerShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTReflectionEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSoftEdgesEffect;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTEffectListImpl extends XmlComplexContentImpl implements CTEffectList {
    private static final QName BLUR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blur");
    private static final QName FILLOVERLAY$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fillOverlay");
    private static final QName GLOW$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "glow");
    private static final QName INNERSHDW$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "innerShdw");
    private static final QName OUTERSHDW$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "outerShdw");
    private static final QName PRSTSHDW$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "prstShdw");
    private static final QName REFLECTION$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "reflection");
    private static final QName SOFTEDGE$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "softEdge");

    public CTEffectListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTBlurEffect addNewBlur() {
        CTBlurEffect cTBlurEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlurEffectAdd_element_user = get_store().add_element_user(BLUR$0);
        }
        return cTBlurEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTFillOverlayEffect addNewFillOverlay() {
        CTFillOverlayEffect cTFillOverlayEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillOverlayEffectAdd_element_user = get_store().add_element_user(FILLOVERLAY$2);
        }
        return cTFillOverlayEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTGlowEffect addNewGlow() {
        CTGlowEffect cTGlowEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGlowEffectAdd_element_user = get_store().add_element_user(GLOW$4);
        }
        return cTGlowEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTInnerShadowEffect addNewInnerShdw() {
        CTInnerShadowEffect cTInnerShadowEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInnerShadowEffectAdd_element_user = get_store().add_element_user(INNERSHDW$6);
        }
        return cTInnerShadowEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTOuterShadowEffect addNewOuterShdw() {
        CTOuterShadowEffect cTOuterShadowEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTOuterShadowEffect = (CTOuterShadowEffect) get_store().add_element_user(OUTERSHDW$8);
        }
        return cTOuterShadowEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTPresetShadowEffect addNewPrstShdw() {
        CTPresetShadowEffect cTPresetShadowEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetShadowEffectAdd_element_user = get_store().add_element_user(PRSTSHDW$10);
        }
        return cTPresetShadowEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTReflectionEffect addNewReflection() {
        CTReflectionEffect cTReflectionEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTReflectionEffectAdd_element_user = get_store().add_element_user(REFLECTION$12);
        }
        return cTReflectionEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTSoftEdgesEffect addNewSoftEdge() {
        CTSoftEdgesEffect cTSoftEdgesEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSoftEdgesEffectAdd_element_user = get_store().add_element_user(SOFTEDGE$14);
        }
        return cTSoftEdgesEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTBlurEffect getBlur() {
        synchronized (monitor()) {
            check_orphaned();
            CTBlurEffect cTBlurEffectFind_element_user = get_store().find_element_user(BLUR$0, 0);
            if (cTBlurEffectFind_element_user == null) {
                return null;
            }
            return cTBlurEffectFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTFillOverlayEffect getFillOverlay() {
        synchronized (monitor()) {
            check_orphaned();
            CTFillOverlayEffect cTFillOverlayEffectFind_element_user = get_store().find_element_user(FILLOVERLAY$2, 0);
            if (cTFillOverlayEffectFind_element_user == null) {
                return null;
            }
            return cTFillOverlayEffectFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTGlowEffect getGlow() {
        synchronized (monitor()) {
            check_orphaned();
            CTGlowEffect cTGlowEffectFind_element_user = get_store().find_element_user(GLOW$4, 0);
            if (cTGlowEffectFind_element_user == null) {
                return null;
            }
            return cTGlowEffectFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTInnerShadowEffect getInnerShdw() {
        synchronized (monitor()) {
            check_orphaned();
            CTInnerShadowEffect cTInnerShadowEffectFind_element_user = get_store().find_element_user(INNERSHDW$6, 0);
            if (cTInnerShadowEffectFind_element_user == null) {
                return null;
            }
            return cTInnerShadowEffectFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTOuterShadowEffect getOuterShdw() {
        synchronized (monitor()) {
            check_orphaned();
            CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect) get_store().find_element_user(OUTERSHDW$8, 0);
            if (cTOuterShadowEffect == null) {
                return null;
            }
            return cTOuterShadowEffect;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTPresetShadowEffect getPrstShdw() {
        synchronized (monitor()) {
            check_orphaned();
            CTPresetShadowEffect cTPresetShadowEffectFind_element_user = get_store().find_element_user(PRSTSHDW$10, 0);
            if (cTPresetShadowEffectFind_element_user == null) {
                return null;
            }
            return cTPresetShadowEffectFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTReflectionEffect getReflection() {
        synchronized (monitor()) {
            check_orphaned();
            CTReflectionEffect cTReflectionEffectFind_element_user = get_store().find_element_user(REFLECTION$12, 0);
            if (cTReflectionEffectFind_element_user == null) {
                return null;
            }
            return cTReflectionEffectFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public CTSoftEdgesEffect getSoftEdge() {
        synchronized (monitor()) {
            check_orphaned();
            CTSoftEdgesEffect cTSoftEdgesEffectFind_element_user = get_store().find_element_user(SOFTEDGE$14, 0);
            if (cTSoftEdgesEffectFind_element_user == null) {
                return null;
            }
            return cTSoftEdgesEffectFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetBlur() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLUR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetFillOverlay() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FILLOVERLAY$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetGlow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GLOW$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetInnerShdw() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INNERSHDW$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetOuterShdw() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OUTERSHDW$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetPrstShdw() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRSTSHDW$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetReflection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(REFLECTION$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public boolean isSetSoftEdge() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SOFTEDGE$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setBlur(CTBlurEffect cTBlurEffect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLUR$0;
            CTBlurEffect cTBlurEffectFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTBlurEffectFind_element_user == null) {
                cTBlurEffectFind_element_user = (CTBlurEffect) get_store().add_element_user(qName);
            }
            cTBlurEffectFind_element_user.set(cTBlurEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setFillOverlay(CTFillOverlayEffect cTFillOverlayEffect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLOVERLAY$2;
            CTFillOverlayEffect cTFillOverlayEffectFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFillOverlayEffectFind_element_user == null) {
                cTFillOverlayEffectFind_element_user = (CTFillOverlayEffect) get_store().add_element_user(qName);
            }
            cTFillOverlayEffectFind_element_user.set(cTFillOverlayEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setGlow(CTGlowEffect cTGlowEffect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GLOW$4;
            CTGlowEffect cTGlowEffectFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTGlowEffectFind_element_user == null) {
                cTGlowEffectFind_element_user = (CTGlowEffect) get_store().add_element_user(qName);
            }
            cTGlowEffectFind_element_user.set(cTGlowEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setInnerShdw(CTInnerShadowEffect cTInnerShadowEffect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INNERSHDW$6;
            CTInnerShadowEffect cTInnerShadowEffectFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTInnerShadowEffectFind_element_user == null) {
                cTInnerShadowEffectFind_element_user = (CTInnerShadowEffect) get_store().add_element_user(qName);
            }
            cTInnerShadowEffectFind_element_user.set(cTInnerShadowEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setOuterShdw(CTOuterShadowEffect cTOuterShadowEffect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OUTERSHDW$8;
            CTOuterShadowEffect cTOuterShadowEffect2 = (CTOuterShadowEffect) typeStore.find_element_user(qName, 0);
            if (cTOuterShadowEffect2 == null) {
                cTOuterShadowEffect2 = (CTOuterShadowEffect) get_store().add_element_user(qName);
            }
            cTOuterShadowEffect2.set(cTOuterShadowEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setPrstShdw(CTPresetShadowEffect cTPresetShadowEffect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRSTSHDW$10;
            CTPresetShadowEffect cTPresetShadowEffectFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPresetShadowEffectFind_element_user == null) {
                cTPresetShadowEffectFind_element_user = (CTPresetShadowEffect) get_store().add_element_user(qName);
            }
            cTPresetShadowEffectFind_element_user.set(cTPresetShadowEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setReflection(CTReflectionEffect cTReflectionEffect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFLECTION$12;
            CTReflectionEffect cTReflectionEffectFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTReflectionEffectFind_element_user == null) {
                cTReflectionEffectFind_element_user = (CTReflectionEffect) get_store().add_element_user(qName);
            }
            cTReflectionEffectFind_element_user.set(cTReflectionEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void setSoftEdge(CTSoftEdgesEffect cTSoftEdgesEffect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SOFTEDGE$14;
            CTSoftEdgesEffect cTSoftEdgesEffectFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSoftEdgesEffectFind_element_user == null) {
                cTSoftEdgesEffectFind_element_user = (CTSoftEdgesEffect) get_store().add_element_user(qName);
            }
            cTSoftEdgesEffectFind_element_user.set(cTSoftEdgesEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetBlur() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLUR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetFillOverlay() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILLOVERLAY$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetGlow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GLOW$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetInnerShdw() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INNERSHDW$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetOuterShdw() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OUTERSHDW$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetPrstShdw() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRSTSHDW$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetReflection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REFLECTION$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList
    public void unsetSoftEdge() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SOFTEDGE$14, 0);
        }
    }
}
