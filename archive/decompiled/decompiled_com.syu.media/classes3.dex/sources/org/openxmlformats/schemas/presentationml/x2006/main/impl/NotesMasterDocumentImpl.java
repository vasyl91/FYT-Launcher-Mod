package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class NotesMasterDocumentImpl extends XmlComplexContentImpl implements NotesMasterDocument {
    private static final QName NOTESMASTER$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "notesMaster");

    public NotesMasterDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument
    public CTNotesMaster addNewNotesMaster() {
        CTNotesMaster cTNotesMaster;
        synchronized (monitor()) {
            check_orphaned();
            cTNotesMaster = (CTNotesMaster) get_store().add_element_user(NOTESMASTER$0);
        }
        return cTNotesMaster;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument
    public CTNotesMaster getNotesMaster() {
        synchronized (monitor()) {
            check_orphaned();
            CTNotesMaster cTNotesMaster = (CTNotesMaster) get_store().find_element_user(NOTESMASTER$0, 0);
            if (cTNotesMaster == null) {
                return null;
            }
            return cTNotesMaster;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument
    public void setNotesMaster(CTNotesMaster cTNotesMaster) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOTESMASTER$0;
            CTNotesMaster cTNotesMaster2 = (CTNotesMaster) typeStore.find_element_user(qName, 0);
            if (cTNotesMaster2 == null) {
                cTNotesMaster2 = (CTNotesMaster) get_store().add_element_user(qName);
            }
            cTNotesMaster2.set(cTNotesMaster);
        }
    }
}
