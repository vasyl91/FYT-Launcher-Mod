package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SldMasterDocumentImpl extends XmlComplexContentImpl implements SldMasterDocument {
    private static final QName SLDMASTER$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sldMaster");

    public SldMasterDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument
    public CTSlideMaster addNewSldMaster() {
        CTSlideMaster cTSlideMaster;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMaster = (CTSlideMaster) get_store().add_element_user(SLDMASTER$0);
        }
        return cTSlideMaster;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument
    public CTSlideMaster getSldMaster() {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideMaster cTSlideMaster = (CTSlideMaster) get_store().find_element_user(SLDMASTER$0, 0);
            if (cTSlideMaster == null) {
                return null;
            }
            return cTSlideMaster;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument
    public void setSldMaster(CTSlideMaster cTSlideMaster) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SLDMASTER$0;
            CTSlideMaster cTSlideMaster2 = (CTSlideMaster) typeStore.find_element_user(qName, 0);
            if (cTSlideMaster2 == null) {
                cTSlideMaster2 = (CTSlideMaster) get_store().add_element_user(qName);
            }
            cTSlideMaster2.set(cTSlideMaster);
        }
    }
}
