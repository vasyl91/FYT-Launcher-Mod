package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLevelSuffix;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLevelText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvlLegacy;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTLvlImpl extends XmlComplexContentImpl implements CTLvl {
    private static final QName START$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "start");
    private static final QName NUMFMT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numFmt");
    private static final QName LVLRESTART$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlRestart");
    private static final QName PSTYLE$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pStyle");
    private static final QName ISLGL$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "isLgl");
    private static final QName SUFF$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "suff");
    private static final QName LVLTEXT$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlText");
    private static final QName LVLPICBULLETID$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlPicBulletId");
    private static final QName LEGACY$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "legacy");
    private static final QName LVLJC$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlJc");
    private static final QName PPR$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPr");
    private static final QName RPR$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
    private static final QName ILVL$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ilvl");
    private static final QName TPLC$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tplc");
    private static final QName TENTATIVE$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tentative");

    public CTLvlImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTOnOff addNewIsLgl() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(ISLGL$8);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTLvlLegacy addNewLegacy() {
        CTLvlLegacy cTLvlLegacyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLvlLegacyAdd_element_user = get_store().add_element_user(LEGACY$16);
        }
        return cTLvlLegacyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTJc addNewLvlJc() {
        CTJc cTJcAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTJcAdd_element_user = get_store().add_element_user(LVLJC$18);
        }
        return cTJcAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTDecimalNumber addNewLvlPicBulletId() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(LVLPICBULLETID$14);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTDecimalNumber addNewLvlRestart() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(LVLRESTART$4);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTLevelText addNewLvlText() {
        CTLevelText cTLevelTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLevelTextAdd_element_user = get_store().add_element_user(LVLTEXT$12);
        }
        return cTLevelTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTNumFmt addNewNumFmt() {
        CTNumFmt cTNumFmtAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmtAdd_element_user = get_store().add_element_user(NUMFMT$2);
        }
        return cTNumFmtAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTPPr addNewPPr() {
        CTPPr cTPPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPPrAdd_element_user = get_store().add_element_user(PPR$20);
        }
        return cTPPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTString addNewPStyle() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(PSTYLE$6);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTRPr addNewRPr() {
        CTRPr cTRPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrAdd_element_user = get_store().add_element_user(RPR$22);
        }
        return cTRPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTDecimalNumber addNewStart() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(START$0);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTLevelSuffix addNewSuff() {
        CTLevelSuffix cTLevelSuffixAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLevelSuffixAdd_element_user = get_store().add_element_user(SUFF$10);
        }
        return cTLevelSuffixAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public BigInteger getIlvl() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ILVL$24);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTOnOff getIsLgl() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(ISLGL$8, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTLvlLegacy getLegacy() {
        synchronized (monitor()) {
            check_orphaned();
            CTLvlLegacy cTLvlLegacyFind_element_user = get_store().find_element_user(LEGACY$16, 0);
            if (cTLvlLegacyFind_element_user == null) {
                return null;
            }
            return cTLvlLegacyFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTJc getLvlJc() {
        synchronized (monitor()) {
            check_orphaned();
            CTJc cTJcFind_element_user = get_store().find_element_user(LVLJC$18, 0);
            if (cTJcFind_element_user == null) {
                return null;
            }
            return cTJcFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTDecimalNumber getLvlPicBulletId() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(LVLPICBULLETID$14, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTDecimalNumber getLvlRestart() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(LVLRESTART$4, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTLevelText getLvlText() {
        synchronized (monitor()) {
            check_orphaned();
            CTLevelText cTLevelTextFind_element_user = get_store().find_element_user(LVLTEXT$12, 0);
            if (cTLevelTextFind_element_user == null) {
                return null;
            }
            return cTLevelTextFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTNumFmt getNumFmt() {
        synchronized (monitor()) {
            check_orphaned();
            CTNumFmt cTNumFmtFind_element_user = get_store().find_element_user(NUMFMT$2, 0);
            if (cTNumFmtFind_element_user == null) {
                return null;
            }
            return cTNumFmtFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTPPr getPPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTPPr cTPPrFind_element_user = get_store().find_element_user(PPR$20, 0);
            if (cTPPrFind_element_user == null) {
                return null;
            }
            return cTPPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTString getPStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(PSTYLE$6, 0);
            if (cTStringFind_element_user == null) {
                return null;
            }
            return cTStringFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTRPr getRPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTRPr cTRPrFind_element_user = get_store().find_element_user(RPR$22, 0);
            if (cTRPrFind_element_user == null) {
                return null;
            }
            return cTRPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTDecimalNumber getStart() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(START$0, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTLevelSuffix getSuff() {
        synchronized (monitor()) {
            check_orphaned();
            CTLevelSuffix cTLevelSuffixFind_element_user = get_store().find_element_user(SUFF$10, 0);
            if (cTLevelSuffixFind_element_user == null) {
                return null;
            }
            return cTLevelSuffixFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public STOnOff.Enum getTentative() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TENTATIVE$28);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public byte[] getTplc() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TPLC$26);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetIsLgl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ISLGL$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetLegacy() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEGACY$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetLvlJc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVLJC$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetLvlPicBulletId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVLPICBULLETID$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetLvlRestart() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVLRESTART$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetLvlText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVLTEXT$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetNumFmt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMFMT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetPPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PPR$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetPStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PSTYLE$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPR$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetStart() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(START$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetSuff() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUFF$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetTentative() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TENTATIVE$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetTplc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TPLC$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setIlvl(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ILVL$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setIsLgl(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISLGL$8;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setLegacy(CTLvlLegacy cTLvlLegacy) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEGACY$16;
            CTLvlLegacy cTLvlLegacyFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLvlLegacyFind_element_user == null) {
                cTLvlLegacyFind_element_user = (CTLvlLegacy) get_store().add_element_user(qName);
            }
            cTLvlLegacyFind_element_user.set(cTLvlLegacy);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setLvlJc(CTJc cTJc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVLJC$18;
            CTJc cTJcFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTJcFind_element_user == null) {
                cTJcFind_element_user = (CTJc) get_store().add_element_user(qName);
            }
            cTJcFind_element_user.set(cTJc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setLvlPicBulletId(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVLPICBULLETID$14;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setLvlRestart(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVLRESTART$4;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setLvlText(CTLevelText cTLevelText) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVLTEXT$12;
            CTLevelText cTLevelTextFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLevelTextFind_element_user == null) {
                cTLevelTextFind_element_user = (CTLevelText) get_store().add_element_user(qName);
            }
            cTLevelTextFind_element_user.set(cTLevelText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setNumFmt(CTNumFmt cTNumFmt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMFMT$2;
            CTNumFmt cTNumFmtFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTNumFmtFind_element_user == null) {
                cTNumFmtFind_element_user = (CTNumFmt) get_store().add_element_user(qName);
            }
            cTNumFmtFind_element_user.set(cTNumFmt);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setPPr(CTPPr cTPPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PPR$20;
            CTPPr cTPPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPPrFind_element_user == null) {
                cTPPrFind_element_user = (CTPPr) get_store().add_element_user(qName);
            }
            cTPPrFind_element_user.set(cTPPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setPStyle(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PSTYLE$6;
            CTString cTStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTStringFind_element_user == null) {
                cTStringFind_element_user = (CTString) get_store().add_element_user(qName);
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setRPr(CTRPr cTRPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPR$22;
            CTRPr cTRPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRPrFind_element_user == null) {
                cTRPrFind_element_user = (CTRPr) get_store().add_element_user(qName);
            }
            cTRPrFind_element_user.set(cTRPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setStart(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = START$0;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setSuff(CTLevelSuffix cTLevelSuffix) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUFF$10;
            CTLevelSuffix cTLevelSuffixFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLevelSuffixFind_element_user == null) {
                cTLevelSuffixFind_element_user = (CTLevelSuffix) get_store().add_element_user(qName);
            }
            cTLevelSuffixFind_element_user.set(cTLevelSuffix);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setTentative(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TENTATIVE$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setTplc(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TPLC$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetIsLgl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ISLGL$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetLegacy() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEGACY$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetLvlJc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVLJC$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetLvlPicBulletId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVLPICBULLETID$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetLvlRestart() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVLRESTART$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetLvlText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVLTEXT$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetNumFmt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMFMT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetPPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PPR$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetPStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PSTYLE$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetStart() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(START$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetSuff() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUFF$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetTentative() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TENTATIVE$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetTplc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TPLC$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public STDecimalNumber xgetIlvl() {
        STDecimalNumber sTDecimalNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumberFind_attribute_user = get_store().find_attribute_user(ILVL$24);
        }
        return sTDecimalNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public STOnOff xgetTentative() {
        STOnOff sTOnOffFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOffFind_attribute_user = get_store().find_attribute_user(TENTATIVE$28);
        }
        return sTOnOffFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public STLongHexNumber xgetTplc() {
        STLongHexNumber sTLongHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumberFind_attribute_user = get_store().find_attribute_user(TPLC$26);
        }
        return sTLongHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void xsetIlvl(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ILVL$24;
            STDecimalNumber sTDecimalNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDecimalNumberFind_attribute_user == null) {
                sTDecimalNumberFind_attribute_user = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumberFind_attribute_user.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void xsetTentative(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TENTATIVE$28;
            STOnOff sTOnOffFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTOnOffFind_attribute_user == null) {
                sTOnOffFind_attribute_user = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOffFind_attribute_user.set((XmlObject) sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void xsetTplc(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TPLC$26;
            STLongHexNumber sTLongHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTLongHexNumberFind_attribute_user == null) {
                sTLongHexNumberFind_attribute_user = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumberFind_attribute_user.set(sTLongHexNumber);
        }
    }
}
