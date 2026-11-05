package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTHyperlinksImpl extends XmlComplexContentImpl implements CTHyperlinks {
    private static final QName HYPERLINK$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "hyperlink");

    public CTHyperlinksImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public CTHyperlink addNewHyperlink() {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().add_element_user(HYPERLINK$0);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public CTHyperlink getHyperlinkArray(int i) {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().find_element_user(HYPERLINK$0, i);
            if (cTHyperlink == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public CTHyperlink[] getHyperlinkArray() {
        CTHyperlink[] cTHyperlinkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HYPERLINK$0, arrayList);
            cTHyperlinkArr = new CTHyperlink[arrayList.size()];
            arrayList.toArray(cTHyperlinkArr);
        }
        return cTHyperlinkArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public List<CTHyperlink> getHyperlinkList() {
        1HyperlinkList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HyperlinkList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public CTHyperlink insertNewHyperlink(int i) {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().insert_element_user(HYPERLINK$0, i);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public void removeHyperlink(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HYPERLINK$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public void setHyperlinkArray(int i, CTHyperlink cTHyperlink) {
        synchronized (monitor()) {
            check_orphaned();
            CTHyperlink cTHyperlink2 = (CTHyperlink) get_store().find_element_user(HYPERLINK$0, i);
            if (cTHyperlink2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTHyperlink2.set(cTHyperlink);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTHyperlinkArr, HYPERLINK$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public int sizeOfHyperlinkArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(HYPERLINK$0);
        }
        return iCount_elements;
    }
}
