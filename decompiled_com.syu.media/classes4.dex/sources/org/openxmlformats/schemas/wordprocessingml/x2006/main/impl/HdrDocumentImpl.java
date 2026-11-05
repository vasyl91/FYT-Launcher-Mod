package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class HdrDocumentImpl extends XmlComplexContentImpl implements HdrDocument {
    private static final QName HDR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hdr");

    public HdrDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument
    public CTHdrFtr addNewHdr() {
        CTHdrFtr cTHdrFtrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtrAdd_element_user = get_store().add_element_user(HDR$0);
        }
        return cTHdrFtrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument
    public CTHdrFtr getHdr() {
        synchronized (monitor()) {
            check_orphaned();
            CTHdrFtr cTHdrFtrFind_element_user = get_store().find_element_user(HDR$0, 0);
            if (cTHdrFtrFind_element_user == null) {
                return null;
            }
            return cTHdrFtrFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument
    public void setHdr(CTHdrFtr cTHdrFtr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HDR$0;
            CTHdrFtr cTHdrFtrFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTHdrFtrFind_element_user == null) {
                cTHdrFtrFind_element_user = (CTHdrFtr) get_store().add_element_user(qName);
            }
            cTHdrFtrFind_element_user.set(cTHdrFtr);
        }
    }
}
