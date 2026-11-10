package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCnf;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTcPrBaseImpl extends XmlComplexContentImpl implements CTTcPrBase {
    private static final QName CNFSTYLE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cnfStyle");
    private static final QName TCW$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcW");
    private static final QName GRIDSPAN$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridSpan");
    private static final QName HMERGE$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hMerge");
    private static final QName VMERGE$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vMerge");
    private static final QName TCBORDERS$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcBorders");
    private static final QName SHD$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
    private static final QName NOWRAP$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noWrap");
    private static final QName TCMAR$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcMar");
    private static final QName TEXTDIRECTION$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textDirection");
    private static final QName TCFITTEXT$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcFitText");
    private static final QName VALIGN$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vAlign");
    private static final QName HIDEMARK$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hideMark");

    public CTTcPrBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTCnf addNewCnfStyle() {
        CTCnf cTCnfAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCnfAdd_element_user = get_store().add_element_user(CNFSTYLE$0);
        }
        return cTCnfAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTDecimalNumber addNewGridSpan() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(GRIDSPAN$4);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTHMerge addNewHMerge() {
        CTHMerge cTHMergeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHMergeAdd_element_user = get_store().add_element_user(HMERGE$6);
        }
        return cTHMergeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff addNewHideMark() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(HIDEMARK$24);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff addNewNoWrap() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(NOWRAP$14);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTShd addNewShd() {
        CTShd cTShdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShdAdd_element_user = get_store().add_element_user(SHD$12);
        }
        return cTShdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTcBorders addNewTcBorders() {
        CTTcBorders cTTcBordersAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTcBordersAdd_element_user = get_store().add_element_user(TCBORDERS$10);
        }
        return cTTcBordersAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff addNewTcFitText() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(TCFITTEXT$20);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTcMar addNewTcMar() {
        CTTcMar cTTcMarAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTcMarAdd_element_user = get_store().add_element_user(TCMAR$16);
        }
        return cTTcMarAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTblWidth addNewTcW() {
        CTTblWidth cTTblWidthAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidthAdd_element_user = get_store().add_element_user(TCW$2);
        }
        return cTTblWidthAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTextDirection addNewTextDirection() {
        CTTextDirection cTTextDirectionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextDirectionAdd_element_user = get_store().add_element_user(TEXTDIRECTION$18);
        }
        return cTTextDirectionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTVerticalJc addNewVAlign() {
        CTVerticalJc cTVerticalJcAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalJcAdd_element_user = get_store().add_element_user(VALIGN$22);
        }
        return cTVerticalJcAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTVMerge addNewVMerge() {
        CTVMerge cTVMergeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTVMergeAdd_element_user = get_store().add_element_user(VMERGE$8);
        }
        return cTVMergeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTCnf getCnfStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTCnf cTCnfFind_element_user = get_store().find_element_user(CNFSTYLE$0, 0);
            if (cTCnfFind_element_user == null) {
                return null;
            }
            return cTCnfFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTDecimalNumber getGridSpan() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(GRIDSPAN$4, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTHMerge getHMerge() {
        synchronized (monitor()) {
            check_orphaned();
            CTHMerge cTHMergeFind_element_user = get_store().find_element_user(HMERGE$6, 0);
            if (cTHMergeFind_element_user == null) {
                return null;
            }
            return cTHMergeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff getHideMark() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(HIDEMARK$24, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff getNoWrap() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(NOWRAP$14, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTShd getShd() {
        synchronized (monitor()) {
            check_orphaned();
            CTShd cTShdFind_element_user = get_store().find_element_user(SHD$12, 0);
            if (cTShdFind_element_user == null) {
                return null;
            }
            return cTShdFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTcBorders getTcBorders() {
        synchronized (monitor()) {
            check_orphaned();
            CTTcBorders cTTcBordersFind_element_user = get_store().find_element_user(TCBORDERS$10, 0);
            if (cTTcBordersFind_element_user == null) {
                return null;
            }
            return cTTcBordersFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff getTcFitText() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(TCFITTEXT$20, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTcMar getTcMar() {
        synchronized (monitor()) {
            check_orphaned();
            CTTcMar cTTcMarFind_element_user = get_store().find_element_user(TCMAR$16, 0);
            if (cTTcMarFind_element_user == null) {
                return null;
            }
            return cTTcMarFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTblWidth getTcW() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidthFind_element_user = get_store().find_element_user(TCW$2, 0);
            if (cTTblWidthFind_element_user == null) {
                return null;
            }
            return cTTblWidthFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTextDirection getTextDirection() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextDirection cTTextDirectionFind_element_user = get_store().find_element_user(TEXTDIRECTION$18, 0);
            if (cTTextDirectionFind_element_user == null) {
                return null;
            }
            return cTTextDirectionFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTVerticalJc getVAlign() {
        synchronized (monitor()) {
            check_orphaned();
            CTVerticalJc cTVerticalJcFind_element_user = get_store().find_element_user(VALIGN$22, 0);
            if (cTVerticalJcFind_element_user == null) {
                return null;
            }
            return cTVerticalJcFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTVMerge getVMerge() {
        synchronized (monitor()) {
            check_orphaned();
            CTVMerge cTVMergeFind_element_user = get_store().find_element_user(VMERGE$8, 0);
            if (cTVMergeFind_element_user == null) {
                return null;
            }
            return cTVMergeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetCnfStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CNFSTYLE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetGridSpan() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRIDSPAN$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetHMerge() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HMERGE$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetHideMark() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HIDEMARK$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetNoWrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOWRAP$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetShd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHD$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTcBorders() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TCBORDERS$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTcFitText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TCFITTEXT$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTcMar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TCMAR$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTcW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TCW$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTextDirection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TEXTDIRECTION$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetVAlign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VALIGN$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetVMerge() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VMERGE$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setCnfStyle(CTCnf cTCnf) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNFSTYLE$0;
            CTCnf cTCnfFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCnfFind_element_user == null) {
                cTCnfFind_element_user = (CTCnf) get_store().add_element_user(qName);
            }
            cTCnfFind_element_user.set(cTCnf);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setGridSpan(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRIDSPAN$4;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setHMerge(CTHMerge cTHMerge) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HMERGE$6;
            CTHMerge cTHMergeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHMergeFind_element_user == null) {
                cTHMergeFind_element_user = (CTHMerge) get_store().add_element_user(qName);
            }
            cTHMergeFind_element_user.set(cTHMerge);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setHideMark(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDEMARK$24;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setNoWrap(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOWRAP$14;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setShd(CTShd cTShd) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHD$12;
            CTShd cTShdFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTShdFind_element_user == null) {
                cTShdFind_element_user = (CTShd) get_store().add_element_user(qName);
            }
            cTShdFind_element_user.set(cTShd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTcBorders(CTTcBorders cTTcBorders) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TCBORDERS$10;
            CTTcBorders cTTcBordersFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTcBordersFind_element_user == null) {
                cTTcBordersFind_element_user = (CTTcBorders) get_store().add_element_user(qName);
            }
            cTTcBordersFind_element_user.set(cTTcBorders);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTcFitText(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TCFITTEXT$20;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTcMar(CTTcMar cTTcMar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TCMAR$16;
            CTTcMar cTTcMarFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTcMarFind_element_user == null) {
                cTTcMarFind_element_user = (CTTcMar) get_store().add_element_user(qName);
            }
            cTTcMarFind_element_user.set(cTTcMar);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTcW(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TCW$2;
            CTTblWidth cTTblWidthFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblWidthFind_element_user == null) {
                cTTblWidthFind_element_user = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidthFind_element_user.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTextDirection(CTTextDirection cTTextDirection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTDIRECTION$18;
            CTTextDirection cTTextDirectionFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTextDirectionFind_element_user == null) {
                cTTextDirectionFind_element_user = (CTTextDirection) get_store().add_element_user(qName);
            }
            cTTextDirectionFind_element_user.set(cTTextDirection);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setVAlign(CTVerticalJc cTVerticalJc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VALIGN$22;
            CTVerticalJc cTVerticalJcFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTVerticalJcFind_element_user == null) {
                cTVerticalJcFind_element_user = (CTVerticalJc) get_store().add_element_user(qName);
            }
            cTVerticalJcFind_element_user.set(cTVerticalJc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setVMerge(CTVMerge cTVMerge) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VMERGE$8;
            CTVMerge cTVMergeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTVMergeFind_element_user == null) {
                cTVMergeFind_element_user = (CTVMerge) get_store().add_element_user(qName);
            }
            cTVMergeFind_element_user.set(cTVMerge);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetCnfStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CNFSTYLE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetGridSpan() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRIDSPAN$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetHMerge() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HMERGE$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetHideMark() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HIDEMARK$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetNoWrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOWRAP$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetShd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHD$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTcBorders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TCBORDERS$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTcFitText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TCFITTEXT$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTcMar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TCMAR$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTcW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TCW$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTextDirection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDIRECTION$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetVAlign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VALIGN$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetVMerge() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VMERGE$8, 0);
        }
    }
}
