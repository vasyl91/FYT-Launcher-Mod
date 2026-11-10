package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTGradientFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTFillImpl extends XmlComplexContentImpl implements CTFill {
    private static final QName PATTERNFILL$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "patternFill");
    private static final QName GRADIENTFILL$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "gradientFill");

    public CTFillImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill
    public CTGradientFill addNewGradientFill() {
        CTGradientFill cTGradientFillAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillAdd_element_user = get_store().add_element_user(GRADIENTFILL$2);
        }
        return cTGradientFillAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill
    public CTPatternFill addNewPatternFill() {
        CTPatternFill cTPatternFill;
        synchronized (monitor()) {
            check_orphaned();
            cTPatternFill = (CTPatternFill) get_store().add_element_user(PATTERNFILL$0);
        }
        return cTPatternFill;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill
    public CTGradientFill getGradientFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTGradientFill cTGradientFillFind_element_user = get_store().find_element_user(GRADIENTFILL$2, 0);
            if (cTGradientFillFind_element_user == null) {
                return null;
            }
            return cTGradientFillFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill
    public CTPatternFill getPatternFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTPatternFill cTPatternFill = (CTPatternFill) get_store().find_element_user(PATTERNFILL$0, 0);
            if (cTPatternFill == null) {
                return null;
            }
            return cTPatternFill;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill
    public boolean isSetGradientFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRADIENTFILL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill
    public boolean isSetPatternFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PATTERNFILL$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill
    public void setGradientFill(CTGradientFill cTGradientFill) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRADIENTFILL$2;
            CTGradientFill cTGradientFillFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTGradientFillFind_element_user == null) {
                cTGradientFillFind_element_user = (CTGradientFill) get_store().add_element_user(qName);
            }
            cTGradientFillFind_element_user.set(cTGradientFill);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill
    public void setPatternFill(CTPatternFill cTPatternFill) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATTERNFILL$0;
            CTPatternFill cTPatternFill2 = (CTPatternFill) typeStore.find_element_user(qName, 0);
            if (cTPatternFill2 == null) {
                cTPatternFill2 = (CTPatternFill) get_store().add_element_user(qName);
            }
            cTPatternFill2.set(cTPatternFill);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill
    public void unsetGradientFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRADIENTFILL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill
    public void unsetPatternFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATTERNFILL$0, 0);
        }
    }
}
