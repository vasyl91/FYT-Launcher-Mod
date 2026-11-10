package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.PageType;
import com.microsoft.schemas.office.visio.x2012.main.PagesType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class PagesTypeImpl extends XmlComplexContentImpl implements PagesType {
    private static final QName PAGE$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Page");

    public PagesTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public PageType addNewPage() {
        PageType pageTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            pageTypeAdd_element_user = get_store().add_element_user(PAGE$0);
        }
        return pageTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public PageType getPageArray(int i) {
        PageType pageTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            pageTypeFind_element_user = get_store().find_element_user(PAGE$0, i);
            if (pageTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return pageTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public PageType[] getPageArray() {
        PageType[] pageTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PAGE$0, arrayList);
            pageTypeArr = new PageType[arrayList.size()];
            arrayList.toArray(pageTypeArr);
        }
        return pageTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public List<PageType> getPageList() {
        1PageList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PageList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public PageType insertNewPage(int i) {
        PageType pageTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            pageTypeInsert_element_user = get_store().insert_element_user(PAGE$0, i);
        }
        return pageTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public void removePage(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGE$0, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public void setPageArray(int i, PageType pageType) {
        synchronized (monitor()) {
            check_orphaned();
            PageType pageTypeFind_element_user = get_store().find_element_user(PAGE$0, i);
            if (pageTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            pageTypeFind_element_user.set(pageType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public void setPageArray(PageType[] pageTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(pageTypeArr, PAGE$0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public int sizeOfPageArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PAGE$0);
        }
        return iCount_elements;
    }
}
