package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.PageContentsDocument;
import com.microsoft.schemas.office.visio.x2012.main.PageContentsType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class PageContentsDocumentImpl extends XmlComplexContentImpl implements PageContentsDocument {
    private static final QName PAGECONTENTS$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "PageContents");

    public PageContentsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsDocument
    public PageContentsType addNewPageContents() {
        PageContentsType pageContentsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            pageContentsTypeAdd_element_user = get_store().add_element_user(PAGECONTENTS$0);
        }
        return pageContentsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsDocument
    public PageContentsType getPageContents() {
        synchronized (monitor()) {
            check_orphaned();
            PageContentsType pageContentsTypeFind_element_user = get_store().find_element_user(PAGECONTENTS$0, 0);
            if (pageContentsTypeFind_element_user == null) {
                return null;
            }
            return pageContentsTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsDocument
    public void setPageContents(PageContentsType pageContentsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGECONTENTS$0;
            PageContentsType pageContentsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (pageContentsTypeFind_element_user == null) {
                pageContentsTypeFind_element_user = (PageContentsType) get_store().add_element_user(qName);
            }
            pageContentsTypeFind_element_user.set(pageContentsType);
        }
    }
}
