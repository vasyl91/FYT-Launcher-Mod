package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTPPrImpl extends CTPPrBaseImpl implements CTPPr {
    private static final QName RPR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
    private static final QName SECTPR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sectPr");
    private static final QName PPRCHANGE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPrChange");

    public CTPPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public CTPPrChange addNewPPrChange() {
        CTPPrChange cTPPrChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPPrChangeAdd_element_user = get_store().add_element_user(PPRCHANGE$4);
        }
        return cTPPrChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public CTParaRPr addNewRPr() {
        CTParaRPr cTParaRPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTParaRPrAdd_element_user = get_store().add_element_user(RPR$0);
        }
        return cTParaRPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public CTSectPr addNewSectPr() {
        CTSectPr cTSectPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSectPrAdd_element_user = get_store().add_element_user(SECTPR$2);
        }
        return cTSectPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public CTPPrChange getPPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTPPrChange cTPPrChangeFind_element_user = get_store().find_element_user(PPRCHANGE$4, 0);
            if (cTPPrChangeFind_element_user == null) {
                return null;
            }
            return cTPPrChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public CTParaRPr getRPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTParaRPr cTParaRPrFind_element_user = get_store().find_element_user(RPR$0, 0);
            if (cTParaRPrFind_element_user == null) {
                return null;
            }
            return cTParaRPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public CTSectPr getSectPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSectPr cTSectPrFind_element_user = get_store().find_element_user(SECTPR$2, 0);
            if (cTSectPrFind_element_user == null) {
                return null;
            }
            return cTSectPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public boolean isSetPPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PPRCHANGE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public boolean isSetRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public boolean isSetSectPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SECTPR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public void setPPrChange(CTPPrChange cTPPrChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PPRCHANGE$4;
            CTPPrChange cTPPrChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPPrChangeFind_element_user == null) {
                cTPPrChangeFind_element_user = (CTPPrChange) get_store().add_element_user(qName);
            }
            cTPPrChangeFind_element_user.set(cTPPrChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public void setRPr(CTParaRPr cTParaRPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPR$0;
            CTParaRPr cTParaRPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTParaRPrFind_element_user == null) {
                cTParaRPrFind_element_user = (CTParaRPr) get_store().add_element_user(qName);
            }
            cTParaRPrFind_element_user.set(cTParaRPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public void setSectPr(CTSectPr cTSectPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SECTPR$2;
            CTSectPr cTSectPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSectPrFind_element_user == null) {
                cTSectPrFind_element_user = (CTSectPr) get_store().add_element_user(qName);
            }
            cTSectPrFind_element_user.set(cTSectPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public void unsetPPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PPRCHANGE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr
    public void unsetSectPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SECTPR$2, 0);
        }
    }
}
