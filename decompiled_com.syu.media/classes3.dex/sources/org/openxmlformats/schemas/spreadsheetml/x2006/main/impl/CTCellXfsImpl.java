package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCellXfsImpl extends XmlComplexContentImpl implements CTCellXfs {
    private static final QName XF$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "xf");
    private static final QName COUNT$2 = new QName("", "count");

    public CTCellXfsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
    public CTXf addNewXf() {
        CTXf cTXf;
        synchronized (monitor()) {
            check_orphaned();
            cTXf = (CTXf) get_store().add_element_user(XF$0);
        }
        return cTXf;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
    public CTXf getXfArray(int i) {
        CTXf cTXf;
        synchronized (monitor()) {
            check_orphaned();
            cTXf = (CTXf) get_store().find_element_user(XF$0, i);
            if (cTXf == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTXf;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
    public CTXf[] getXfArray() {
        CTXf[] cTXfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(XF$0, arrayList);
            cTXfArr = new CTXf[arrayList.size()];
            arrayList.toArray(cTXfArr);
        }
        return cTXfArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
    public List<CTXf> getXfList() {
        1XfList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1XfList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
    public CTXf insertNewXf(int i) {
        CTXf cTXf;
        synchronized (monitor()) {
            check_orphaned();
            cTXf = (CTXf) get_store().insert_element_user(XF$0, i);
        }
        return cTXf;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
    public void removeXf(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(XF$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
    public void setXfArray(int i, CTXf cTXf) {
        synchronized (monitor()) {
            check_orphaned();
            CTXf cTXf2 = (CTXf) get_store().find_element_user(XF$0, i);
            if (cTXf2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTXf2.set(cTXf);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
    public void setXfArray(CTXf[] cTXfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTXfArr, XF$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
    public int sizeOfXfArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(XF$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs
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
