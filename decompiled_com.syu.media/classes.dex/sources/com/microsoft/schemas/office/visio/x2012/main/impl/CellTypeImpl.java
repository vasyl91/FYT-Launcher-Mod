package com.microsoft.schemas.office.visio.x2012.main.impl;

import androidx.exifinterface.media.ExifInterface;
import chip.FinalChip;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RefByType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CellTypeImpl extends XmlComplexContentImpl implements CellType {
    private static final QName REFBY$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "RefBy");
    private static final QName N$2 = new QName(FinalChip.BSP_PLATFORM_Null, "N");
    private static final QName U$4 = new QName(FinalChip.BSP_PLATFORM_Null, "U");
    private static final QName E$6 = new QName(FinalChip.BSP_PLATFORM_Null, ExifInterface.LONGITUDE_EAST);
    private static final QName F$8 = new QName(FinalChip.BSP_PLATFORM_Null, "F");
    private static final QName V$10 = new QName(FinalChip.BSP_PLATFORM_Null, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);

    public CellTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public RefByType addNewRefBy() {
        RefByType refByTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            refByTypeAdd_element_user = get_store().add_element_user(REFBY$0);
        }
        return refByTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public String getE() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(E$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public String getF() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(F$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public String getN() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(N$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public RefByType getRefByArray(int i) {
        RefByType refByTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            refByTypeFind_element_user = get_store().find_element_user(REFBY$0, i);
            if (refByTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return refByTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public RefByType[] getRefByArray() {
        RefByType[] refByTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(REFBY$0, arrayList);
            refByTypeArr = new RefByType[arrayList.size()];
            arrayList.toArray(refByTypeArr);
        }
        return refByTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public List<RefByType> getRefByList() {
        1RefByList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RefByList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public String getU() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(U$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public String getV() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(V$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public RefByType insertNewRefBy(int i) {
        RefByType refByTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            refByTypeInsert_element_user = get_store().insert_element_user(REFBY$0, i);
        }
        return refByTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public boolean isSetE() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(E$6) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public boolean isSetF() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(F$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public boolean isSetU() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(U$4) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public boolean isSetV() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(V$10) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void removeRefBy(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REFBY$0, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void setE(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = E$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void setF(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = F$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void setN(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = N$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void setRefByArray(int i, RefByType refByType) {
        synchronized (monitor()) {
            check_orphaned();
            RefByType refByTypeFind_element_user = get_store().find_element_user(REFBY$0, i);
            if (refByTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            refByTypeFind_element_user.set(refByType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void setRefByArray(RefByType[] refByTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(refByTypeArr, REFBY$0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void setU(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = U$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void setV(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = V$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public int sizeOfRefByArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(REFBY$0);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void unsetE() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(E$6);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void unsetF() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(F$8);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void unsetU() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(U$4);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void unsetV() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(V$10);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public XmlString xgetE() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(E$6);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public XmlString xgetF() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(F$8);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public XmlString xgetN() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(N$2);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public XmlString xgetU() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(U$4);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public XmlString xgetV() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(V$10);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void xsetE(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = E$6;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void xsetF(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = F$8;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void xsetN(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = N$2;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void xsetU(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = U$4;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.CellType
    public void xsetV(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = V$10;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
