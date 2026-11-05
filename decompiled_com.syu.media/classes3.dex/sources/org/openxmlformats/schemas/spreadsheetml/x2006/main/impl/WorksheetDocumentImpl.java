package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class WorksheetDocumentImpl extends XmlComplexContentImpl implements WorksheetDocument {
    private static final QName WORKSHEET$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "worksheet");

    public WorksheetDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument
    public CTWorksheet addNewWorksheet() {
        CTWorksheet cTWorksheet;
        synchronized (monitor()) {
            check_orphaned();
            cTWorksheet = (CTWorksheet) get_store().add_element_user(WORKSHEET$0);
        }
        return cTWorksheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument
    public CTWorksheet getWorksheet() {
        synchronized (monitor()) {
            check_orphaned();
            CTWorksheet cTWorksheet = (CTWorksheet) get_store().find_element_user(WORKSHEET$0, 0);
            if (cTWorksheet == null) {
                return null;
            }
            return cTWorksheet;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument
    public void setWorksheet(CTWorksheet cTWorksheet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WORKSHEET$0;
            CTWorksheet cTWorksheet2 = (CTWorksheet) typeStore.find_element_user(qName, 0);
            if (cTWorksheet2 == null) {
                cTWorksheet2 = (CTWorksheet) get_store().add_element_user(qName);
            }
            cTWorksheet2.set(cTWorksheet);
        }
    }
}
