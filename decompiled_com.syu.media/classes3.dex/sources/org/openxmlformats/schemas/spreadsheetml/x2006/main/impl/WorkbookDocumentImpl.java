package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class WorkbookDocumentImpl extends XmlComplexContentImpl implements WorkbookDocument {
    private static final QName WORKBOOK$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "workbook");

    public WorkbookDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument
    public CTWorkbook addNewWorkbook() {
        CTWorkbook cTWorkbook;
        synchronized (monitor()) {
            check_orphaned();
            cTWorkbook = (CTWorkbook) get_store().add_element_user(WORKBOOK$0);
        }
        return cTWorkbook;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument
    public CTWorkbook getWorkbook() {
        synchronized (monitor()) {
            check_orphaned();
            CTWorkbook cTWorkbook = (CTWorkbook) get_store().find_element_user(WORKBOOK$0, 0);
            if (cTWorkbook == null) {
                return null;
            }
            return cTWorkbook;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument
    public void setWorkbook(CTWorkbook cTWorkbook) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WORKBOOK$0;
            CTWorkbook cTWorkbook2 = (CTWorkbook) typeStore.find_element_user(qName, 0);
            if (cTWorkbook2 == null) {
                cTWorkbook2 = (CTWorkbook) get_store().add_element_user(qName);
            }
            cTWorkbook2.set(cTWorkbook);
        }
    }
}
