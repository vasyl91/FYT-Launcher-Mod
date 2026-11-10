package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChangeNumbering;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTNumPrImpl extends XmlComplexContentImpl implements CTNumPr {
    private static final QName ILVL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ilvl");
    private static final QName NUMID$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numId");
    private static final QName NUMBERINGCHANGE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numberingChange");
    private static final QName INS$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");

    public CTNumPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTDecimalNumber addNewIlvl() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(ILVL$0);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTTrackChange addNewIns() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(INS$6);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTDecimalNumber addNewNumId() {
        CTDecimalNumber cTDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumberAdd_element_user = get_store().add_element_user(NUMID$2);
        }
        return cTDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTTrackChangeNumbering addNewNumberingChange() {
        CTTrackChangeNumbering cTTrackChangeNumberingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeNumberingAdd_element_user = get_store().add_element_user(NUMBERINGCHANGE$4);
        }
        return cTTrackChangeNumberingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTDecimalNumber getIlvl() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(ILVL$0, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTTrackChange getIns() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(INS$6, 0);
            if (cTTrackChangeFind_element_user == null) {
                return null;
            }
            return cTTrackChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTDecimalNumber getNumId() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumberFind_element_user = get_store().find_element_user(NUMID$2, 0);
            if (cTDecimalNumberFind_element_user == null) {
                return null;
            }
            return cTDecimalNumberFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTTrackChangeNumbering getNumberingChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChangeNumbering cTTrackChangeNumberingFind_element_user = get_store().find_element_user(NUMBERINGCHANGE$4, 0);
            if (cTTrackChangeNumberingFind_element_user == null) {
                return null;
            }
            return cTTrackChangeNumberingFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public boolean isSetIlvl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ILVL$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public boolean isSetIns() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INS$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public boolean isSetNumId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMID$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public boolean isSetNumberingChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMBERINGCHANGE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void setIlvl(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ILVL$0;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void setIns(CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INS$6;
            CTTrackChange cTTrackChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTrackChangeFind_element_user == null) {
                cTTrackChangeFind_element_user = (CTTrackChange) get_store().add_element_user(qName);
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void setNumId(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMID$2;
            CTDecimalNumber cTDecimalNumberFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDecimalNumberFind_element_user == null) {
                cTDecimalNumberFind_element_user = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumberFind_element_user.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void setNumberingChange(CTTrackChangeNumbering cTTrackChangeNumbering) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMBERINGCHANGE$4;
            CTTrackChangeNumbering cTTrackChangeNumberingFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTrackChangeNumberingFind_element_user == null) {
                cTTrackChangeNumberingFind_element_user = (CTTrackChangeNumbering) get_store().add_element_user(qName);
            }
            cTTrackChangeNumberingFind_element_user.set(cTTrackChangeNumbering);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void unsetIlvl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ILVL$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void unsetIns() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void unsetNumId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMID$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void unsetNumberingChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMBERINGCHANGE$4, 0);
        }
    }
}
