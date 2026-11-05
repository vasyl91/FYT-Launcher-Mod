package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLang;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyAlign;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTRubyPrImpl extends XmlComplexContentImpl implements CTRubyPr {
    private static final QName RUBYALIGN$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rubyAlign");
    private static final QName HPS$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hps");
    private static final QName HPSRAISE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hpsRaise");
    private static final QName HPSBASETEXT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hpsBaseText");
    private static final QName LID$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lid");
    private static final QName DIRTY$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dirty");

    public CTRubyPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTOnOff addNewDirty() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(DIRTY$10);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTHpsMeasure addNewHps() {
        CTHpsMeasure cTHpsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasureAdd_element_user = get_store().add_element_user(HPS$2);
        }
        return cTHpsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTHpsMeasure addNewHpsBaseText() {
        CTHpsMeasure cTHpsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasureAdd_element_user = get_store().add_element_user(HPSBASETEXT$6);
        }
        return cTHpsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTHpsMeasure addNewHpsRaise() {
        CTHpsMeasure cTHpsMeasureAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasureAdd_element_user = get_store().add_element_user(HPSRAISE$4);
        }
        return cTHpsMeasureAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTLang addNewLid() {
        CTLang cTLangAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLangAdd_element_user = get_store().add_element_user(LID$8);
        }
        return cTLangAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTRubyAlign addNewRubyAlign() {
        CTRubyAlign cTRubyAlignAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyAlignAdd_element_user = get_store().add_element_user(RUBYALIGN$0);
        }
        return cTRubyAlignAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTOnOff getDirty() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(DIRTY$10, 0);
            if (cTOnOffFind_element_user == null) {
                return null;
            }
            return cTOnOffFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTHpsMeasure getHps() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasureFind_element_user = get_store().find_element_user(HPS$2, 0);
            if (cTHpsMeasureFind_element_user == null) {
                return null;
            }
            return cTHpsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTHpsMeasure getHpsBaseText() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasureFind_element_user = get_store().find_element_user(HPSBASETEXT$6, 0);
            if (cTHpsMeasureFind_element_user == null) {
                return null;
            }
            return cTHpsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTHpsMeasure getHpsRaise() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasureFind_element_user = get_store().find_element_user(HPSRAISE$4, 0);
            if (cTHpsMeasureFind_element_user == null) {
                return null;
            }
            return cTHpsMeasureFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTLang getLid() {
        synchronized (monitor()) {
            check_orphaned();
            CTLang cTLangFind_element_user = get_store().find_element_user(LID$8, 0);
            if (cTLangFind_element_user == null) {
                return null;
            }
            return cTLangFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public CTRubyAlign getRubyAlign() {
        synchronized (monitor()) {
            check_orphaned();
            CTRubyAlign cTRubyAlignFind_element_user = get_store().find_element_user(RUBYALIGN$0, 0);
            if (cTRubyAlignFind_element_user == null) {
                return null;
            }
            return cTRubyAlignFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public boolean isSetDirty() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DIRTY$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void setDirty(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIRTY$10;
            CTOnOff cTOnOffFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTOnOffFind_element_user == null) {
                cTOnOffFind_element_user = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void setHps(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HPS$2;
            CTHpsMeasure cTHpsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHpsMeasureFind_element_user == null) {
                cTHpsMeasureFind_element_user = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasureFind_element_user.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void setHpsBaseText(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HPSBASETEXT$6;
            CTHpsMeasure cTHpsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHpsMeasureFind_element_user == null) {
                cTHpsMeasureFind_element_user = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasureFind_element_user.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void setHpsRaise(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HPSRAISE$4;
            CTHpsMeasure cTHpsMeasureFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHpsMeasureFind_element_user == null) {
                cTHpsMeasureFind_element_user = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasureFind_element_user.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void setLid(CTLang cTLang) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LID$8;
            CTLang cTLangFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLangFind_element_user == null) {
                cTLangFind_element_user = (CTLang) get_store().add_element_user(qName);
            }
            cTLangFind_element_user.set(cTLang);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void setRubyAlign(CTRubyAlign cTRubyAlign) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RUBYALIGN$0;
            CTRubyAlign cTRubyAlignFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRubyAlignFind_element_user == null) {
                cTRubyAlignFind_element_user = (CTRubyAlign) get_store().add_element_user(qName);
            }
            cTRubyAlignFind_element_user.set(cTRubyAlign);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr
    public void unsetDirty() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DIRTY$10, 0);
        }
    }
}
