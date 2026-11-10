package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTStylesImpl extends XmlComplexContentImpl implements CTStyles {
    private static final QName DOCDEFAULTS$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docDefaults");
    private static final QName LATENTSTYLES$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "latentStyles");
    private static final QName STYLE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "style");

    public CTStylesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public CTDocDefaults addNewDocDefaults() {
        CTDocDefaults cTDocDefaultsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDocDefaultsAdd_element_user = get_store().add_element_user(DOCDEFAULTS$0);
        }
        return cTDocDefaultsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public CTLatentStyles addNewLatentStyles() {
        CTLatentStyles cTLatentStylesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLatentStylesAdd_element_user = get_store().add_element_user(LATENTSTYLES$2);
        }
        return cTLatentStylesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public CTStyle addNewStyle() {
        CTStyle cTStyleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleAdd_element_user = get_store().add_element_user(STYLE$4);
        }
        return cTStyleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public CTDocDefaults getDocDefaults() {
        synchronized (monitor()) {
            check_orphaned();
            CTDocDefaults cTDocDefaultsFind_element_user = get_store().find_element_user(DOCDEFAULTS$0, 0);
            if (cTDocDefaultsFind_element_user == null) {
                return null;
            }
            return cTDocDefaultsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public CTLatentStyles getLatentStyles() {
        synchronized (monitor()) {
            check_orphaned();
            CTLatentStyles cTLatentStylesFind_element_user = get_store().find_element_user(LATENTSTYLES$2, 0);
            if (cTLatentStylesFind_element_user == null) {
                return null;
            }
            return cTLatentStylesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public CTStyle getStyleArray(int i) {
        CTStyle cTStyleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleFind_element_user = get_store().find_element_user(STYLE$4, i);
            if (cTStyleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStyleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public CTStyle[] getStyleArray() {
        CTStyle[] cTStyleArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(STYLE$4, arrayList);
            cTStyleArr = new CTStyle[arrayList.size()];
            arrayList.toArray(cTStyleArr);
        }
        return cTStyleArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public List<CTStyle> getStyleList() {
        1StyleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1StyleList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public CTStyle insertNewStyle(int i) {
        CTStyle cTStyleInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleInsert_element_user = get_store().insert_element_user(STYLE$4, i);
        }
        return cTStyleInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public boolean isSetDocDefaults() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DOCDEFAULTS$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public boolean isSetLatentStyles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LATENTSTYLES$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public void removeStyle(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STYLE$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public void setDocDefaults(CTDocDefaults cTDocDefaults) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCDEFAULTS$0;
            CTDocDefaults cTDocDefaultsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDocDefaultsFind_element_user == null) {
                cTDocDefaultsFind_element_user = (CTDocDefaults) get_store().add_element_user(qName);
            }
            cTDocDefaultsFind_element_user.set(cTDocDefaults);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public void setLatentStyles(CTLatentStyles cTLatentStyles) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LATENTSTYLES$2;
            CTLatentStyles cTLatentStylesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLatentStylesFind_element_user == null) {
                cTLatentStylesFind_element_user = (CTLatentStyles) get_store().add_element_user(qName);
            }
            cTLatentStylesFind_element_user.set(cTLatentStyles);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public void setStyleArray(int i, CTStyle cTStyle) {
        synchronized (monitor()) {
            check_orphaned();
            CTStyle cTStyleFind_element_user = get_store().find_element_user(STYLE$4, i);
            if (cTStyleFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTStyleFind_element_user.set(cTStyle);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public void setStyleArray(CTStyle[] cTStyleArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTStyleArr, STYLE$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public int sizeOfStyleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(STYLE$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public void unsetDocDefaults() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCDEFAULTS$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles
    public void unsetLatentStyles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LATENTSTYLES$2, 0);
        }
    }
}
