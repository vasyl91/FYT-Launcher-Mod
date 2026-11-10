package com.microsoft.schemas.office.visio.x2012.main.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.RowType;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import com.microsoft.schemas.office.visio.x2012.main.TriggerType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class SectionTypeImpl extends XmlComplexContentImpl implements SectionType {
    private static final QName CELL$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Cell");
    private static final QName TRIGGER$2 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Trigger");
    private static final QName ROW$4 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Row");
    private static final QName N$6 = new QName(FinalChip.BSP_PLATFORM_Null, "N");
    private static final QName DEL$8 = new QName(FinalChip.BSP_PLATFORM_Null, "Del");
    private static final QName IX$10 = new QName(FinalChip.BSP_PLATFORM_Null, "IX");

    public SectionTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public CellType addNewCell() {
        CellType cellTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cellTypeAdd_element_user = get_store().add_element_user(CELL$0);
        }
        return cellTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public RowType addNewRow() {
        RowType rowTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            rowTypeAdd_element_user = get_store().add_element_user(ROW$4);
        }
        return rowTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public TriggerType addNewTrigger() {
        TriggerType triggerTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            triggerTypeAdd_element_user = get_store().add_element_user(TRIGGER$2);
        }
        return triggerTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public CellType getCellArray(int i) {
        CellType cellTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cellTypeFind_element_user = get_store().find_element_user(CELL$0, i);
            if (cellTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cellTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public CellType[] getCellArray() {
        CellType[] cellTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CELL$0, arrayList);
            cellTypeArr = new CellType[arrayList.size()];
            arrayList.toArray(cellTypeArr);
        }
        return cellTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public List<CellType> getCellList() {
        1CellList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CellList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public boolean getDel() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEL$8);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public long getIX() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(IX$10);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public String getN() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(N$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public RowType getRowArray(int i) {
        RowType rowTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            rowTypeFind_element_user = get_store().find_element_user(ROW$4, i);
            if (rowTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return rowTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public RowType[] getRowArray() {
        RowType[] rowTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ROW$4, arrayList);
            rowTypeArr = new RowType[arrayList.size()];
            arrayList.toArray(rowTypeArr);
        }
        return rowTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public List<RowType> getRowList() {
        1RowList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RowList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public TriggerType getTriggerArray(int i) {
        TriggerType triggerTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            triggerTypeFind_element_user = get_store().find_element_user(TRIGGER$2, i);
            if (triggerTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return triggerTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public TriggerType[] getTriggerArray() {
        TriggerType[] triggerTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TRIGGER$2, arrayList);
            triggerTypeArr = new TriggerType[arrayList.size()];
            arrayList.toArray(triggerTypeArr);
        }
        return triggerTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public List<TriggerType> getTriggerList() {
        1TriggerList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TriggerList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public CellType insertNewCell(int i) {
        CellType cellTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cellTypeInsert_element_user = get_store().insert_element_user(CELL$0, i);
        }
        return cellTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public RowType insertNewRow(int i) {
        RowType rowTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            rowTypeInsert_element_user = get_store().insert_element_user(ROW$4, i);
        }
        return rowTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public TriggerType insertNewTrigger(int i) {
        TriggerType triggerTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            triggerTypeInsert_element_user = get_store().insert_element_user(TRIGGER$2, i);
        }
        return triggerTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public boolean isSetDel() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEL$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public boolean isSetIX() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(IX$10) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void removeCell(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CELL$0, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void removeRow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ROW$4, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void removeTrigger(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRIGGER$2, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setCellArray(int i, CellType cellType) {
        synchronized (monitor()) {
            check_orphaned();
            CellType cellTypeFind_element_user = get_store().find_element_user(CELL$0, i);
            if (cellTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cellTypeFind_element_user.set(cellType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setCellArray(CellType[] cellTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cellTypeArr, CELL$0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setDel(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEL$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setIX(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IX$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setN(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = N$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setRowArray(int i, RowType rowType) {
        synchronized (monitor()) {
            check_orphaned();
            RowType rowTypeFind_element_user = get_store().find_element_user(ROW$4, i);
            if (rowTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            rowTypeFind_element_user.set(rowType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setRowArray(RowType[] rowTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(rowTypeArr, ROW$4);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setTriggerArray(int i, TriggerType triggerType) {
        synchronized (monitor()) {
            check_orphaned();
            TriggerType triggerTypeFind_element_user = get_store().find_element_user(TRIGGER$2, i);
            if (triggerTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            triggerTypeFind_element_user.set(triggerType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void setTriggerArray(TriggerType[] triggerTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(triggerTypeArr, TRIGGER$2);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public int sizeOfCellArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CELL$0);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public int sizeOfRowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ROW$4);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public int sizeOfTriggerArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TRIGGER$2);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void unsetDel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEL$8);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void unsetIX() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(IX$10);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public XmlBoolean xgetDel() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(DEL$8);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public XmlUnsignedInt xgetIX() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(IX$10);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public XmlString xgetN() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(N$6);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void xsetDel(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEL$8;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void xsetIX(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IX$10;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SectionType
    public void xsetN(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = N$6;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
