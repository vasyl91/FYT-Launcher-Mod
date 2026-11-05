package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.StyleSheetDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StyleSheetDocumentImpl extends XmlComplexContentImpl implements StyleSheetDocument {
    private static final QName STYLESHEET$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "styleSheet");

    public StyleSheetDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.StyleSheetDocument
    public CTStylesheet addNewStyleSheet() {
        CTStylesheet cTStylesheet;
        synchronized (monitor()) {
            check_orphaned();
            cTStylesheet = (CTStylesheet) get_store().add_element_user(STYLESHEET$0);
        }
        return cTStylesheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.StyleSheetDocument
    public CTStylesheet getStyleSheet() {
        synchronized (monitor()) {
            check_orphaned();
            CTStylesheet cTStylesheet = (CTStylesheet) get_store().find_element_user(STYLESHEET$0, 0);
            if (cTStylesheet == null) {
                return null;
            }
            return cTStylesheet;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.StyleSheetDocument
    public void setStyleSheet(CTStylesheet cTStylesheet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLESHEET$0;
            CTStylesheet cTStylesheet2 = (CTStylesheet) typeStore.find_element_user(qName, 0);
            if (cTStylesheet2 == null) {
                cTStylesheet2 = (CTStylesheet) get_store().add_element_user(qName);
            }
            cTStylesheet2.set(cTStylesheet);
        }
    }
}
