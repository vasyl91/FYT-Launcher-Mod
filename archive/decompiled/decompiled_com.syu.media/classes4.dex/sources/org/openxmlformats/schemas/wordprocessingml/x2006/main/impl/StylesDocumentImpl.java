package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class StylesDocumentImpl extends XmlComplexContentImpl implements StylesDocument {
    private static final QName STYLES$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styles");

    public StylesDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument
    public CTStyles addNewStyles() {
        CTStyles cTStylesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStylesAdd_element_user = get_store().add_element_user(STYLES$0);
        }
        return cTStylesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument
    public CTStyles getStyles() {
        synchronized (monitor()) {
            check_orphaned();
            CTStyles cTStylesFind_element_user = get_store().find_element_user(STYLES$0, 0);
            if (cTStylesFind_element_user == null) {
                return null;
            }
            return cTStylesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument
    public void setStyles(CTStyles cTStyles) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLES$0;
            CTStyles cTStylesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTStylesFind_element_user == null) {
                cTStylesFind_element_user = (CTStyles) get_store().add_element_user(qName);
            }
            cTStylesFind_element_user.set(cTStyles);
        }
    }
}
