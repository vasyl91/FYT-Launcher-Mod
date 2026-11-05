package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.MastersDocument;
import com.microsoft.schemas.office.visio.x2012.main.MastersType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class MastersDocumentImpl extends XmlComplexContentImpl implements MastersDocument {
    private static final QName MASTERS$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Masters");

    public MastersDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersDocument
    public MastersType addNewMasters() {
        MastersType mastersTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            mastersTypeAdd_element_user = get_store().add_element_user(MASTERS$0);
        }
        return mastersTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersDocument
    public MastersType getMasters() {
        synchronized (monitor()) {
            check_orphaned();
            MastersType mastersTypeFind_element_user = get_store().find_element_user(MASTERS$0, 0);
            if (mastersTypeFind_element_user == null) {
                return null;
            }
            return mastersTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MastersDocument
    public void setMasters(MastersType mastersType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MASTERS$0;
            MastersType mastersTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (mastersTypeFind_element_user == null) {
                mastersTypeFind_element_user = (MastersType) get_store().add_element_user(qName);
            }
            mastersTypeFind_element_user.set(mastersType);
        }
    }
}
