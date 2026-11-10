package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.PagesDocument;
import com.microsoft.schemas.office.visio.x2012.main.PagesType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class PagesDocumentImpl extends XmlComplexContentImpl implements PagesDocument {
    private static final QName PAGES$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Pages");

    public PagesDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesDocument
    public PagesType addNewPages() {
        PagesType pagesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            pagesTypeAdd_element_user = get_store().add_element_user(PAGES$0);
        }
        return pagesTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesDocument
    public PagesType getPages() {
        synchronized (monitor()) {
            check_orphaned();
            PagesType pagesTypeFind_element_user = get_store().find_element_user(PAGES$0, 0);
            if (pagesTypeFind_element_user == null) {
                return null;
            }
            return pagesTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesDocument
    public void setPages(PagesType pagesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGES$0;
            PagesType pagesTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (pagesTypeFind_element_user == null) {
                pagesTypeFind_element_user = (PagesType) get_store().add_element_user(qName);
            }
            pagesTypeFind_element_user.set(pagesType);
        }
    }
}
