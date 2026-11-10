package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class TableDocumentImpl extends XmlComplexContentImpl implements TableDocument {
    private static final QName TABLE$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "table");

    public TableDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument
    public CTTable addNewTable() {
        CTTable cTTable;
        synchronized (monitor()) {
            check_orphaned();
            cTTable = (CTTable) get_store().add_element_user(TABLE$0);
        }
        return cTTable;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument
    public CTTable getTable() {
        synchronized (monitor()) {
            check_orphaned();
            CTTable cTTable = (CTTable) get_store().find_element_user(TABLE$0, 0);
            if (cTTable == null) {
                return null;
            }
            return cTTable;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.TableDocument
    public void setTable(CTTable cTTable) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLE$0;
            CTTable cTTable2 = (CTTable) typeStore.find_element_user(qName, 0);
            if (cTTable2 == null) {
                cTTable2 = (CTTable) get_store().add_element_user(qName);
            }
            cTTable2.set(cTTable);
        }
    }
}
