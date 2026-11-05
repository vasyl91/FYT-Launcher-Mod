package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTDxfsImpl extends XmlComplexContentImpl implements CTDxfs {
    private static final QName DXF$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dxf");
    private static final QName COUNT$2 = new QName("", "count");

    public CTDxfsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public CTDxf addNewDxf() {
        CTDxf cTDxf;
        synchronized (monitor()) {
            check_orphaned();
            cTDxf = (CTDxf) get_store().add_element_user(DXF$0);
        }
        return cTDxf;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public CTDxf getDxfArray(int i) {
        CTDxf cTDxf;
        synchronized (monitor()) {
            check_orphaned();
            cTDxf = (CTDxf) get_store().find_element_user(DXF$0, i);
            if (cTDxf == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDxf;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public CTDxf[] getDxfArray() {
        CTDxf[] cTDxfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DXF$0, arrayList);
            cTDxfArr = new CTDxf[arrayList.size()];
            arrayList.toArray(cTDxfArr);
        }
        return cTDxfArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public List<CTDxf> getDxfList() {
        1DxfList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DxfList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public CTDxf insertNewDxf(int i) {
        CTDxf cTDxf;
        synchronized (monitor()) {
            check_orphaned();
            cTDxf = (CTDxf) get_store().insert_element_user(DXF$0, i);
        }
        return cTDxf;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public void removeDxf(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DXF$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public void setDxfArray(int i, CTDxf cTDxf) {
        synchronized (monitor()) {
            check_orphaned();
            CTDxf cTDxf2 = (CTDxf) get_store().find_element_user(DXF$0, i);
            if (cTDxf2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDxf2.set(cTDxf);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public void setDxfArray(CTDxf[] cTDxfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTDxfArr, DXF$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public int sizeOfDxfArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DXF$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs
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
