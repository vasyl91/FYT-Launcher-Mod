package com.microsoft.schemas.office.visio.x2012.main.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import com.microsoft.schemas.office.visio.x2012.main.SheetType;
import com.microsoft.schemas.office.visio.x2012.main.TriggerType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class SheetTypeImpl extends XmlComplexContentImpl implements SheetType {
    private static final QName CELL$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Cell");
    private static final QName TRIGGER$2 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Trigger");
    private static final QName SECTION$4 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Section");
    private static final QName LINESTYLE$6 = new QName(FinalChip.BSP_PLATFORM_Null, "LineStyle");
    private static final QName FILLSTYLE$8 = new QName(FinalChip.BSP_PLATFORM_Null, "FillStyle");
    private static final QName TEXTSTYLE$10 = new QName(FinalChip.BSP_PLATFORM_Null, "TextStyle");

    public SheetTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public CellType addNewCell() {
        CellType cellTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cellTypeAdd_element_user = get_store().add_element_user(CELL$0);
        }
        return cellTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public SectionType addNewSection() {
        SectionType sectionTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sectionTypeAdd_element_user = get_store().add_element_user(SECTION$4);
        }
        return sectionTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public TriggerType addNewTrigger() {
        TriggerType triggerTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            triggerTypeAdd_element_user = get_store().add_element_user(TRIGGER$2);
        }
        return triggerTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
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

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
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

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public List<CellType> getCellList() {
        1CellList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CellList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public long getFillStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FILLSTYLE$8);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public long getLineStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LINESTYLE$6);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public SectionType getSectionArray(int i) {
        SectionType sectionTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sectionTypeFind_element_user = get_store().find_element_user(SECTION$4, i);
            if (sectionTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sectionTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public SectionType[] getSectionArray() {
        SectionType[] sectionTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SECTION$4, arrayList);
            sectionTypeArr = new SectionType[arrayList.size()];
            arrayList.toArray(sectionTypeArr);
        }
        return sectionTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public List<SectionType> getSectionList() {
        1SectionList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SectionList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public long getTextStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TEXTSTYLE$10);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
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

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
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

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public List<TriggerType> getTriggerList() {
        1TriggerList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TriggerList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public CellType insertNewCell(int i) {
        CellType cellTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cellTypeInsert_element_user = get_store().insert_element_user(CELL$0, i);
        }
        return cellTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public SectionType insertNewSection(int i) {
        SectionType sectionTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sectionTypeInsert_element_user = get_store().insert_element_user(SECTION$4, i);
        }
        return sectionTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public TriggerType insertNewTrigger(int i) {
        TriggerType triggerTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            triggerTypeInsert_element_user = get_store().insert_element_user(TRIGGER$2, i);
        }
        return triggerTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public boolean isSetFillStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLSTYLE$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public boolean isSetLineStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LINESTYLE$6) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public boolean isSetTextStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TEXTSTYLE$10) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void removeCell(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CELL$0, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void removeSection(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SECTION$4, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void removeTrigger(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRIGGER$2, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
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

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void setCellArray(CellType[] cellTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cellTypeArr, CELL$0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void setFillStyle(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLSTYLE$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void setLineStyle(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINESTYLE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void setSectionArray(int i, SectionType sectionType) {
        synchronized (monitor()) {
            check_orphaned();
            SectionType sectionTypeFind_element_user = get_store().find_element_user(SECTION$4, i);
            if (sectionTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            sectionTypeFind_element_user.set(sectionType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void setSectionArray(SectionType[] sectionTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sectionTypeArr, SECTION$4);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void setTextStyle(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTSTYLE$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
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

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void setTriggerArray(TriggerType[] triggerTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(triggerTypeArr, TRIGGER$2);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public int sizeOfCellArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CELL$0);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public int sizeOfSectionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SECTION$4);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public int sizeOfTriggerArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TRIGGER$2);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void unsetFillStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLSTYLE$8);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void unsetLineStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LINESTYLE$6);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void unsetTextStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TEXTSTYLE$10);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public XmlUnsignedInt xgetFillStyle() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(FILLSTYLE$8);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public XmlUnsignedInt xgetLineStyle() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(LINESTYLE$6);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public XmlUnsignedInt xgetTextStyle() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(TEXTSTYLE$10);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void xsetFillStyle(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLSTYLE$8;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void xsetLineStyle(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINESTYLE$6;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.SheetType
    public void xsetTextStyle(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTSTYLE$10;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }
}
