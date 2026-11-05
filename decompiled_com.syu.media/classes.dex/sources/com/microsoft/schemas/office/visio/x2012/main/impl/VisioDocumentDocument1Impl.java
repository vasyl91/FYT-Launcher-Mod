package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentDocument1;
import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class VisioDocumentDocument1Impl extends XmlComplexContentImpl implements VisioDocumentDocument1 {
    private static final QName VISIODOCUMENT$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "VisioDocument");

    public VisioDocumentDocument1Impl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentDocument1
    public VisioDocumentType addNewVisioDocument() {
        VisioDocumentType visioDocumentTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            visioDocumentTypeAdd_element_user = get_store().add_element_user(VISIODOCUMENT$0);
        }
        return visioDocumentTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentDocument1
    public VisioDocumentType getVisioDocument() {
        synchronized (monitor()) {
            check_orphaned();
            VisioDocumentType visioDocumentTypeFind_element_user = get_store().find_element_user(VISIODOCUMENT$0, 0);
            if (visioDocumentTypeFind_element_user == null) {
                return null;
            }
            return visioDocumentTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentDocument1
    public void setVisioDocument(VisioDocumentType visioDocumentType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VISIODOCUMENT$0;
            VisioDocumentType visioDocumentTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (visioDocumentTypeFind_element_user == null) {
                visioDocumentTypeFind_element_user = (VisioDocumentType) get_store().add_element_user(qName);
            }
            visioDocumentTypeFind_element_user.set(visioDocumentType);
        }
    }
}
