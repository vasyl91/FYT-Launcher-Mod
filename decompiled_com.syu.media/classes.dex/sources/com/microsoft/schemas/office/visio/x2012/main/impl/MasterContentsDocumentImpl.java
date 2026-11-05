package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.MasterContentsDocument;
import com.microsoft.schemas.office.visio.x2012.main.PageContentsType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class MasterContentsDocumentImpl extends XmlComplexContentImpl implements MasterContentsDocument {
    private static final QName MASTERCONTENTS$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "MasterContents");

    public MasterContentsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterContentsDocument
    public PageContentsType addNewMasterContents() {
        PageContentsType pageContentsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            pageContentsTypeAdd_element_user = get_store().add_element_user(MASTERCONTENTS$0);
        }
        return pageContentsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterContentsDocument
    public PageContentsType getMasterContents() {
        synchronized (monitor()) {
            check_orphaned();
            PageContentsType pageContentsTypeFind_element_user = get_store().find_element_user(MASTERCONTENTS$0, 0);
            if (pageContentsTypeFind_element_user == null) {
                return null;
            }
            return pageContentsTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterContentsDocument
    public void setMasterContents(PageContentsType pageContentsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MASTERCONTENTS$0;
            PageContentsType pageContentsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (pageContentsTypeFind_element_user == null) {
                pageContentsTypeFind_element_user = (PageContentsType) get_store().add_element_user(qName);
            }
            pageContentsTypeFind_element_user.set(pageContentsType);
        }
    }
}
