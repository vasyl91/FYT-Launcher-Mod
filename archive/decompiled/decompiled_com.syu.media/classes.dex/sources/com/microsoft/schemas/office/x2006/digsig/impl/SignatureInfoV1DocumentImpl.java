package com.microsoft.schemas.office.x2006.digsig.impl;

import com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1;
import com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class SignatureInfoV1DocumentImpl extends XmlComplexContentImpl implements SignatureInfoV1Document {
    private static final QName SIGNATUREINFOV1$0 = new QName("http://schemas.microsoft.com/office/2006/digsig", "SignatureInfoV1");

    public SignatureInfoV1DocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document
    public CTSignatureInfoV1 addNewSignatureInfoV1() {
        CTSignatureInfoV1 cTSignatureInfoV1Add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureInfoV1Add_element_user = get_store().add_element_user(SIGNATUREINFOV1$0);
        }
        return cTSignatureInfoV1Add_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document
    public CTSignatureInfoV1 getSignatureInfoV1() {
        synchronized (monitor()) {
            check_orphaned();
            CTSignatureInfoV1 cTSignatureInfoV1Find_element_user = get_store().find_element_user(SIGNATUREINFOV1$0, 0);
            if (cTSignatureInfoV1Find_element_user == null) {
                return null;
            }
            return cTSignatureInfoV1Find_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document
    public void setSignatureInfoV1(CTSignatureInfoV1 cTSignatureInfoV1) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREINFOV1$0;
            CTSignatureInfoV1 cTSignatureInfoV1Find_element_user = typeStore.find_element_user(qName, 0);
            if (cTSignatureInfoV1Find_element_user == null) {
                cTSignatureInfoV1Find_element_user = (CTSignatureInfoV1) get_store().add_element_user(qName);
            }
            cTSignatureInfoV1Find_element_user.set(cTSignatureInfoV1);
        }
    }
}
