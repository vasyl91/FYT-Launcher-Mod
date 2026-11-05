package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SingleXmlCellsDocumentImpl extends XmlComplexContentImpl implements SingleXmlCellsDocument {
    private static final QName SINGLEXMLCELLS$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "singleXmlCells");

    public SingleXmlCellsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument
    public CTSingleXmlCells addNewSingleXmlCells() {
        CTSingleXmlCells cTSingleXmlCells;
        synchronized (monitor()) {
            check_orphaned();
            cTSingleXmlCells = (CTSingleXmlCells) get_store().add_element_user(SINGLEXMLCELLS$0);
        }
        return cTSingleXmlCells;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument
    public CTSingleXmlCells getSingleXmlCells() {
        synchronized (monitor()) {
            check_orphaned();
            CTSingleXmlCells cTSingleXmlCells = (CTSingleXmlCells) get_store().find_element_user(SINGLEXMLCELLS$0, 0);
            if (cTSingleXmlCells == null) {
                return null;
            }
            return cTSingleXmlCells;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument
    public void setSingleXmlCells(CTSingleXmlCells cTSingleXmlCells) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SINGLEXMLCELLS$0;
            CTSingleXmlCells cTSingleXmlCells2 = (CTSingleXmlCells) typeStore.find_element_user(qName, 0);
            if (cTSingleXmlCells2 == null) {
                cTSingleXmlCells2 = (CTSingleXmlCells) get_store().add_element_user(qName);
            }
            cTSingleXmlCells2.set(cTSingleXmlCells);
        }
    }
}
