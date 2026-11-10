package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTDocDefaultsImpl extends XmlComplexContentImpl implements CTDocDefaults {
    private static final QName RPRDEFAULT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPrDefault");
    private static final QName PPRDEFAULT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPrDefault");

    public CTDocDefaultsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public CTPPrDefault addNewPPrDefault() {
        CTPPrDefault cTPPrDefaultAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPPrDefaultAdd_element_user = get_store().add_element_user(PPRDEFAULT$2);
        }
        return cTPPrDefaultAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public CTRPrDefault addNewRPrDefault() {
        CTRPrDefault cTRPrDefaultAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrDefaultAdd_element_user = get_store().add_element_user(RPRDEFAULT$0);
        }
        return cTRPrDefaultAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public CTPPrDefault getPPrDefault() {
        synchronized (monitor()) {
            check_orphaned();
            CTPPrDefault cTPPrDefaultFind_element_user = get_store().find_element_user(PPRDEFAULT$2, 0);
            if (cTPPrDefaultFind_element_user == null) {
                return null;
            }
            return cTPPrDefaultFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public CTRPrDefault getRPrDefault() {
        synchronized (monitor()) {
            check_orphaned();
            CTRPrDefault cTRPrDefaultFind_element_user = get_store().find_element_user(RPRDEFAULT$0, 0);
            if (cTRPrDefaultFind_element_user == null) {
                return null;
            }
            return cTRPrDefaultFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public boolean isSetPPrDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PPRDEFAULT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public boolean isSetRPrDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPRDEFAULT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public void setPPrDefault(CTPPrDefault cTPPrDefault) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PPRDEFAULT$2;
            CTPPrDefault cTPPrDefaultFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPPrDefaultFind_element_user == null) {
                cTPPrDefaultFind_element_user = (CTPPrDefault) get_store().add_element_user(qName);
            }
            cTPPrDefaultFind_element_user.set(cTPPrDefault);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public void setRPrDefault(CTRPrDefault cTRPrDefault) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPRDEFAULT$0;
            CTRPrDefault cTRPrDefaultFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRPrDefaultFind_element_user == null) {
                cTRPrDefaultFind_element_user = (CTRPrDefault) get_store().add_element_user(qName);
            }
            cTRPrDefaultFind_element_user.set(cTRPrDefault);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public void unsetPPrDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PPRDEFAULT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public void unsetRPrDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPRDEFAULT$0, 0);
        }
    }
}
