package org.openxmlformats.schemas.xpackage.x2006.digitalSignature.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.SignatureTimeDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class SignatureTimeDocumentImpl extends XmlComplexContentImpl implements SignatureTimeDocument {
    private static final QName SIGNATURETIME$0 = new QName("http://schemas.openxmlformats.org/package/2006/digital-signature", "SignatureTime");

    public SignatureTimeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.SignatureTimeDocument
    public CTSignatureTime addNewSignatureTime() {
        CTSignatureTime cTSignatureTimeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureTimeAdd_element_user = get_store().add_element_user(SIGNATURETIME$0);
        }
        return cTSignatureTimeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.SignatureTimeDocument
    public CTSignatureTime getSignatureTime() {
        synchronized (monitor()) {
            check_orphaned();
            CTSignatureTime cTSignatureTimeFind_element_user = get_store().find_element_user(SIGNATURETIME$0, 0);
            if (cTSignatureTimeFind_element_user == null) {
                return null;
            }
            return cTSignatureTimeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.xpackage.x2006.digitalSignature.SignatureTimeDocument
    public void setSignatureTime(CTSignatureTime cTSignatureTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATURETIME$0;
            CTSignatureTime cTSignatureTimeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSignatureTimeFind_element_user == null) {
                cTSignatureTimeFind_element_user = (CTSignatureTime) get_store().add_element_user(qName);
            }
            cTSignatureTimeFind_element_user.set(cTSignatureTime);
        }
    }
}
