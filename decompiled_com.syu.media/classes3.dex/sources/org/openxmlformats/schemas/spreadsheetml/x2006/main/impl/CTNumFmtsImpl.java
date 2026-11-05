package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTNumFmtsImpl extends XmlComplexContentImpl implements CTNumFmts {
    private static final QName NUMFMT$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "numFmt");
    private static final QName COUNT$2 = new QName("", "count");

    public CTNumFmtsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public CTNumFmt addNewNumFmt() {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().add_element_user(NUMFMT$0);
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public long getCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COUNT$2);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public CTNumFmt getNumFmtArray(int i) {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().find_element_user(NUMFMT$0, i);
            if (cTNumFmt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public CTNumFmt[] getNumFmtArray() {
        CTNumFmt[] cTNumFmtArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NUMFMT$0, arrayList);
            cTNumFmtArr = new CTNumFmt[arrayList.size()];
            arrayList.toArray(cTNumFmtArr);
        }
        return cTNumFmtArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public List<CTNumFmt> getNumFmtList() {
        1NumFmtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NumFmtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public CTNumFmt insertNewNumFmt(int i) {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().insert_element_user(NUMFMT$0, i);
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public void removeNumFmt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMFMT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public void setCount(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public void setNumFmtArray(int i, CTNumFmt cTNumFmt) {
        synchronized (monitor()) {
            check_orphaned();
            CTNumFmt cTNumFmt2 = (CTNumFmt) get_store().find_element_user(NUMFMT$0, i);
            if (cTNumFmt2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTNumFmt2.set(cTNumFmt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public void setNumFmtArray(CTNumFmt[] cTNumFmtArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTNumFmtArr, NUMFMT$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public int sizeOfNumFmtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(NUMFMT$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts
    public void xsetCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$2;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }
}
