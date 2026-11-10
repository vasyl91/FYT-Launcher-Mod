package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.STGuid;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTableStyleListImpl extends XmlComplexContentImpl implements CTTableStyleList {
    private static final QName TBLSTYLE$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tblStyle");
    private static final QName DEF$2 = new QName("", "def");

    public CTTableStyleListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public CTTableStyle addNewTblStyle() {
        CTTableStyle cTTableStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyle = (CTTableStyle) get_store().add_element_user(TBLSTYLE$0);
        }
        return cTTableStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public String getDef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEF$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public CTTableStyle getTblStyleArray(int i) {
        CTTableStyle cTTableStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyle = (CTTableStyle) get_store().find_element_user(TBLSTYLE$0, i);
            if (cTTableStyle == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTableStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public CTTableStyle[] getTblStyleArray() {
        CTTableStyle[] cTTableStyleArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TBLSTYLE$0, arrayList);
            cTTableStyleArr = new CTTableStyle[arrayList.size()];
            arrayList.toArray(cTTableStyleArr);
        }
        return cTTableStyleArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public List<CTTableStyle> getTblStyleList() {
        1TblStyleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TblStyleList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public CTTableStyle insertNewTblStyle(int i) {
        CTTableStyle cTTableStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyle = (CTTableStyle) get_store().insert_element_user(TBLSTYLE$0, i);
        }
        return cTTableStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public void removeTblStyle(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLSTYLE$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public void setDef(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEF$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public void setTblStyleArray(int i, CTTableStyle cTTableStyle) {
        synchronized (monitor()) {
            check_orphaned();
            CTTableStyle cTTableStyle2 = (CTTableStyle) get_store().find_element_user(TBLSTYLE$0, i);
            if (cTTableStyle2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTableStyle2.set(cTTableStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public void setTblStyleArray(CTTableStyle[] cTTableStyleArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTableStyleArr, TBLSTYLE$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public int sizeOfTblStyleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TBLSTYLE$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public STGuid xgetDef() {
        STGuid sTGuid;
        synchronized (monitor()) {
            check_orphaned();
            sTGuid = (STGuid) get_store().find_attribute_user(DEF$2);
        }
        return sTGuid;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList
    public void xsetDef(STGuid sTGuid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEF$2;
            STGuid sTGuid2 = (STGuid) typeStore.find_attribute_user(qName);
            if (sTGuid2 == null) {
                sTGuid2 = (STGuid) get_store().add_attribute_user(qName);
            }
            sTGuid2.set(sTGuid);
        }
    }
}
