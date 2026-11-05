package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyPr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTRubyImpl extends XmlComplexContentImpl implements CTRuby {
    private static final QName RUBYPR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rubyPr");
    private static final QName RT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rt");
    private static final QName RUBYBASE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rubyBase");

    public CTRubyImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public CTRubyContent addNewRt() {
        CTRubyContent cTRubyContentAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyContentAdd_element_user = get_store().add_element_user(RT$2);
        }
        return cTRubyContentAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public CTRubyContent addNewRubyBase() {
        CTRubyContent cTRubyContentAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyContentAdd_element_user = get_store().add_element_user(RUBYBASE$4);
        }
        return cTRubyContentAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public CTRubyPr addNewRubyPr() {
        CTRubyPr cTRubyPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRubyPrAdd_element_user = get_store().add_element_user(RUBYPR$0);
        }
        return cTRubyPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public CTRubyContent getRt() {
        synchronized (monitor()) {
            check_orphaned();
            CTRubyContent cTRubyContentFind_element_user = get_store().find_element_user(RT$2, 0);
            if (cTRubyContentFind_element_user == null) {
                return null;
            }
            return cTRubyContentFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public CTRubyContent getRubyBase() {
        synchronized (monitor()) {
            check_orphaned();
            CTRubyContent cTRubyContentFind_element_user = get_store().find_element_user(RUBYBASE$4, 0);
            if (cTRubyContentFind_element_user == null) {
                return null;
            }
            return cTRubyContentFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public CTRubyPr getRubyPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTRubyPr cTRubyPrFind_element_user = get_store().find_element_user(RUBYPR$0, 0);
            if (cTRubyPrFind_element_user == null) {
                return null;
            }
            return cTRubyPrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public void setRt(CTRubyContent cTRubyContent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RT$2;
            CTRubyContent cTRubyContentFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRubyContentFind_element_user == null) {
                cTRubyContentFind_element_user = (CTRubyContent) get_store().add_element_user(qName);
            }
            cTRubyContentFind_element_user.set(cTRubyContent);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public void setRubyBase(CTRubyContent cTRubyContent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RUBYBASE$4;
            CTRubyContent cTRubyContentFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRubyContentFind_element_user == null) {
                cTRubyContentFind_element_user = (CTRubyContent) get_store().add_element_user(qName);
            }
            cTRubyContentFind_element_user.set(cTRubyContent);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby
    public void setRubyPr(CTRubyPr cTRubyPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RUBYPR$0;
            CTRubyPr cTRubyPrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTRubyPrFind_element_user == null) {
                cTRubyPrFind_element_user = (CTRubyPr) get_store().add_element_user(qName);
            }
            cTRubyPrFind_element_user.set(cTRubyPr);
        }
    }
}
