package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShortHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblOverlap;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTblPrBaseImpl extends XmlComplexContentImpl implements CTTblPrBase {
    private static final QName TBLSTYLE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblStyle");
    private static final QName TBLPPR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblpPr");
    private static final QName TBLOVERLAP$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblOverlap");
    private static final QName BIDIVISUAL$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bidiVisual");
    private static final QName TBLSTYLEROWBANDSIZE$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblStyleRowBandSize");
    private static final QName TBLSTYLECOLBANDSIZE$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblStyleColBandSize");
    private static final QName TBLW$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblW");
    private static final QName JC$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "jc");
    private static final QName TBLCELLSPACING$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellSpacing");
    private static final QName TBLIND$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblInd");
    private static final QName TBLBORDERS$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblBorders");
    private static final QName SHD$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
    private static final QName TBLLAYOUT$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblLayout");
    private static final QName TBLCELLMAR$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellMar");
    private static final QName TBLLOOK$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblLook");

    public CTTblPrBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTOnOff addNewBidiVisual() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(BIDIVISUAL$6);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTJc addNewJc() {
        CTJc cTJcAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTJcAdd_element_user = get_store().add_element_user(JC$14);
        }
        return cTJcAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTShd addNewShd() {
        CTShd cTShdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShdAdd_element_user = get_store().add_element_user(SHD$22);
        }
        return cTShdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblBorders addNewTblBorders() {
        CTTblBorders cTTblBordersAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblBordersAdd_element_user = get_store().add_element_user(TBLBORDERS$20);
        }
        return cTTblBordersAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblCellMar addNewTblCellMar() {
        CTTblCellMar cTTblCellMarAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblCellMarAdd_element_user = get_store().add_element_user(TBLCELLMAR$26);
        }
        return cTTblCellMarAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblWidth addNewTblCellSpacing() {
        CTTblWidth cTTblWidthAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidthAdd_element_user = get_store().add_element_user(TBLCELLSPACING$16);
        }
        return cTTblWidthAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblWidth addNewTblInd() {
        CTTblWidth cTTblWidthAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidthAdd_element_user = get_store().add_element_user(TBLIND$18);
        }
        return cTTblWidthAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblLayoutType addNewTblLayout() {
        CTTblLayoutType cTTblLayoutTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblLayoutTypeAdd_element_user = get_store().add_element_user(TBLLAYOUT$24);
        }
        return cTTblLayoutTypeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTShortHexNumber addNewTblLook() {
        CTShortHexNumber cTShortHexNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShortHexNumberAdd_element_user = get_store().add_element_user(TBLLOOK$28);
        }
        return cTShortHexNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblOverlap addNewTblOverlap() {
        CTTblOverlap cTTblOverlapAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblOverlapAdd_element_user = get_store().add_element_user(TBLOVERLAP$4);
        }
        return cTTblOverlapAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTString addNewTblStyle() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(TBLSTYLE$0);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTDecimalNumber addNewTblStyleColBandSize() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(TBLSTYLECOLBANDSIZE$10);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTDecimalNumber addNewTblStyleRowBandSize() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(TBLSTYLEROWBANDSIZE$8);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblWidth addNewTblW() {
        CTTblWidth cTTblWidthAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidthAdd_element_user = get_store().add_element_user(TBLW$12);
        }
        return cTTblWidthAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblPPr addNewTblpPr() {
        CTTblPPr cTTblPPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPPrAdd_element_user = get_store().add_element_user(TBLPPR$2);
        }
        return cTTblPPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTOnOff getBidiVisual() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(BIDIVISUAL$6, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTJc getJc() {
        synchronized (monitor()) {
            check_orphaned();
            CTJc cTJcFind_element_user = get_store().find_element_user(JC$14, 0);
            if (cTJcFind_element_user == null) {
                return null;
            }
            return cTJcFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTShd getShd() {
        synchronized (monitor()) {
            check_orphaned();
            CTShd cTShdFind_element_user = get_store().find_element_user(SHD$22, 0);
            if (cTShdFind_element_user == null) {
                return null;
            }
            return cTShdFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblBorders getTblBorders() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblBorders cTTblBordersFind_element_user = get_store().find_element_user(TBLBORDERS$20, 0);
            if (cTTblBordersFind_element_user == null) {
                return null;
            }
            return cTTblBordersFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblCellMar getTblCellMar() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblCellMar cTTblCellMarFind_element_user = get_store().find_element_user(TBLCELLMAR$26, 0);
            if (cTTblCellMarFind_element_user == null) {
                return null;
            }
            return cTTblCellMarFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblWidth getTblCellSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidthFind_element_user = get_store().find_element_user(TBLCELLSPACING$16, 0);
            if (cTTblWidthFind_element_user == null) {
                return null;
            }
            return cTTblWidthFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblWidth getTblInd() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidthFind_element_user = get_store().find_element_user(TBLIND$18, 0);
            if (cTTblWidthFind_element_user == null) {
                return null;
            }
            return cTTblWidthFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblLayoutType getTblLayout() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblLayoutType cTTblLayoutTypeFind_element_user = get_store().find_element_user(TBLLAYOUT$24, 0);
            if (cTTblLayoutTypeFind_element_user == null) {
                return null;
            }
            return cTTblLayoutTypeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTShortHexNumber getTblLook() {
        synchronized (monitor()) {
            check_orphaned();
            CTShortHexNumber cTShortHexNumberFind_element_user = get_store().find_element_user(TBLLOOK$28, 0);
            if (cTShortHexNumberFind_element_user == null) {
                return null;
            }
            return cTShortHexNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblOverlap getTblOverlap() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblOverlap cTTblOverlapFind_element_user = get_store().find_element_user(TBLOVERLAP$4, 0);
            if (cTTblOverlapFind_element_user == null) {
                return null;
            }
            return cTTblOverlapFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTString getTblStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(TBLSTYLE$0, 0);
            if (cTStringFind_element_user == null) {
                return null;
            }
            return cTStringFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTDecimalNumber getTblStyleColBandSize() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(TBLSTYLECOLBANDSIZE$10, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTDecimalNumber getTblStyleRowBandSize() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(TBLSTYLEROWBANDSIZE$8, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblWidth getTblW() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidthFind_element_user = get_store().find_element_user(TBLW$12, 0);
            if (cTTblWidthFind_element_user == null) {
                return null;
            }
            return cTTblWidthFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblPPr getTblpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblPPr cTTblPPrFind_element_user = get_store().find_element_user(TBLPPR$2, 0);
            if (cTTblPPrFind_element_user == null) {
                return null;
            }
            return cTTblPPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetBidiVisual() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BIDIVISUAL$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetJc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(JC$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetShd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHD$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblBorders() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLBORDERS$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblCellMar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLCELLMAR$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblCellSpacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLCELLSPACING$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblInd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLIND$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblLayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLLAYOUT$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblLook() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLLOOK$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblOverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLOVERLAP$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLSTYLE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblStyleColBandSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLSTYLECOLBANDSIZE$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblStyleRowBandSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLSTYLEROWBANDSIZE$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLW$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLPPR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setBidiVisual(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BIDIVISUAL$6;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setJc(CTJc cTJc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JC$14;
            CTJc cTJcFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTJcFind_element_user == null) {
                cTJcFind_element_user = (CTJc) get_store().add_element_user(qName);
            }
            cTJcFind_element_user.set(cTJc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setShd(CTShd cTShd) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHD$22;
            CTShd cTShdFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTShdFind_element_user == null) {
                cTShdFind_element_user = (CTShd) get_store().add_element_user(qName);
            }
            cTShdFind_element_user.set(cTShd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblBorders(CTTblBorders cTTblBorders) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLBORDERS$20;
            CTTblBorders cTTblBordersFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblBordersFind_element_user == null) {
                cTTblBordersFind_element_user = (CTTblBorders) get_store().add_element_user(qName);
            }
            cTTblBordersFind_element_user.set(cTTblBorders);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblCellMar(CTTblCellMar cTTblCellMar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLCELLMAR$26;
            CTTblCellMar cTTblCellMarFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblCellMarFind_element_user == null) {
                cTTblCellMarFind_element_user = (CTTblCellMar) get_store().add_element_user(qName);
            }
            cTTblCellMarFind_element_user.set(cTTblCellMar);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblCellSpacing(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLCELLSPACING$16;
            CTTblWidth cTTblWidthFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblWidthFind_element_user == null) {
                cTTblWidthFind_element_user = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidthFind_element_user.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblInd(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLIND$18;
            CTTblWidth cTTblWidthFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblWidthFind_element_user == null) {
                cTTblWidthFind_element_user = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidthFind_element_user.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblLayout(CTTblLayoutType cTTblLayoutType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLLAYOUT$24;
            CTTblLayoutType cTTblLayoutTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblLayoutTypeFind_element_user == null) {
                cTTblLayoutTypeFind_element_user = (CTTblLayoutType) get_store().add_element_user(qName);
            }
            cTTblLayoutTypeFind_element_user.set(cTTblLayoutType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblLook(CTShortHexNumber cTShortHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLLOOK$28;
            CTShortHexNumber cTShortHexNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTShortHexNumberFind_element_user == null) {
                cTShortHexNumberFind_element_user = (CTShortHexNumber) get_store().add_element_user(qName);
            }
            cTShortHexNumberFind_element_user.set(cTShortHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblOverlap(CTTblOverlap cTTblOverlap) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLOVERLAP$4;
            CTTblOverlap cTTblOverlapFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblOverlapFind_element_user == null) {
                cTTblOverlapFind_element_user = (CTTblOverlap) get_store().add_element_user(qName);
            }
            cTTblOverlapFind_element_user.set(cTTblOverlap);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblStyle(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLSTYLE$0;
            CTString cTStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTStringFind_element_user == null) {
                cTStringFind_element_user = (CTString) get_store().add_element_user(qName);
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblStyleColBandSize(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLSTYLECOLBANDSIZE$10;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblStyleRowBandSize(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLSTYLEROWBANDSIZE$8;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblW(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLW$12;
            CTTblWidth cTTblWidthFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblWidthFind_element_user == null) {
                cTTblWidthFind_element_user = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidthFind_element_user.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblpPr(CTTblPPr cTTblPPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLPPR$2;
            CTTblPPr cTTblPPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTblPPrFind_element_user == null) {
                cTTblPPrFind_element_user = (CTTblPPr) get_store().add_element_user(qName);
            }
            cTTblPPrFind_element_user.set(cTTblPPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetBidiVisual() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BIDIVISUAL$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetJc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(JC$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetShd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHD$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblBorders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLBORDERS$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblCellMar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLCELLMAR$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblCellSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLCELLSPACING$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblInd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLIND$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLLAYOUT$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblLook() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLLOOK$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblOverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLOVERLAP$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLSTYLE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblStyleColBandSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLSTYLECOLBANDSIZE$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblStyleRowBandSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLSTYLEROWBANDSIZE$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLW$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLPPR$2, 0);
        }
    }
}
