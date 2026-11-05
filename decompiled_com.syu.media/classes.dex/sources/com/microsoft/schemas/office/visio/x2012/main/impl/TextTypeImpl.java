package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.CpType;
import com.microsoft.schemas.office.visio.x2012.main.FldType;
import com.microsoft.schemas.office.visio.x2012.main.PpType;
import com.microsoft.schemas.office.visio.x2012.main.TextType;
import com.microsoft.schemas.office.visio.x2012.main.TpType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class TextTypeImpl extends XmlComplexContentImpl implements TextType {
    private static final QName CP$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "cp");
    private static final QName PP$2 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "pp");
    private static final QName TP$4 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "tp");
    private static final QName FLD$6 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "fld");

    public TextTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public CpType addNewCp() {
        CpType cpTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cpTypeAdd_element_user = get_store().add_element_user(CP$0);
        }
        return cpTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public FldType addNewFld() {
        FldType fldTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            fldTypeAdd_element_user = get_store().add_element_user(FLD$6);
        }
        return fldTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public PpType addNewPp() {
        PpType ppTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ppTypeAdd_element_user = get_store().add_element_user(PP$2);
        }
        return ppTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public TpType addNewTp() {
        TpType tpTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            tpTypeAdd_element_user = get_store().add_element_user(TP$4);
        }
        return tpTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public CpType getCpArray(int i) {
        CpType cpTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cpTypeFind_element_user = get_store().find_element_user(CP$0, i);
            if (cpTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cpTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public CpType[] getCpArray() {
        CpType[] cpTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CP$0, arrayList);
            cpTypeArr = new CpType[arrayList.size()];
            arrayList.toArray(cpTypeArr);
        }
        return cpTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public List<CpType> getCpList() {
        1CpList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CpList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public FldType getFldArray(int i) {
        FldType fldTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            fldTypeFind_element_user = get_store().find_element_user(FLD$6, i);
            if (fldTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return fldTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public FldType[] getFldArray() {
        FldType[] fldTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FLD$6, arrayList);
            fldTypeArr = new FldType[arrayList.size()];
            arrayList.toArray(fldTypeArr);
        }
        return fldTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public List<FldType> getFldList() {
        1FldList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FldList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public PpType getPpArray(int i) {
        PpType ppTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ppTypeFind_element_user = get_store().find_element_user(PP$2, i);
            if (ppTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ppTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public PpType[] getPpArray() {
        PpType[] ppTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PP$2, arrayList);
            ppTypeArr = new PpType[arrayList.size()];
            arrayList.toArray(ppTypeArr);
        }
        return ppTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public List<PpType> getPpList() {
        1PpList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PpList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public TpType getTpArray(int i) {
        TpType tpTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            tpTypeFind_element_user = get_store().find_element_user(TP$4, i);
            if (tpTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return tpTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public TpType[] getTpArray() {
        TpType[] tpTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TP$4, arrayList);
            tpTypeArr = new TpType[arrayList.size()];
            arrayList.toArray(tpTypeArr);
        }
        return tpTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public List<TpType> getTpList() {
        1TpList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TpList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public CpType insertNewCp(int i) {
        CpType cpTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cpTypeInsert_element_user = get_store().insert_element_user(CP$0, i);
        }
        return cpTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public FldType insertNewFld(int i) {
        FldType fldTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            fldTypeInsert_element_user = get_store().insert_element_user(FLD$6, i);
        }
        return fldTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public PpType insertNewPp(int i) {
        PpType ppTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ppTypeInsert_element_user = get_store().insert_element_user(PP$2, i);
        }
        return ppTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public TpType insertNewTp(int i) {
        TpType tpTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            tpTypeInsert_element_user = get_store().insert_element_user(TP$4, i);
        }
        return tpTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void removeCp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CP$0, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void removeFld(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FLD$6, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void removePp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PP$2, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void removeTp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TP$4, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setCpArray(int i, CpType cpType) {
        synchronized (monitor()) {
            check_orphaned();
            CpType cpTypeFind_element_user = get_store().find_element_user(CP$0, i);
            if (cpTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cpTypeFind_element_user.set(cpType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setCpArray(CpType[] cpTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cpTypeArr, CP$0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setFldArray(int i, FldType fldType) {
        synchronized (monitor()) {
            check_orphaned();
            FldType fldTypeFind_element_user = get_store().find_element_user(FLD$6, i);
            if (fldTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            fldTypeFind_element_user.set(fldType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setFldArray(FldType[] fldTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(fldTypeArr, FLD$6);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setPpArray(int i, PpType ppType) {
        synchronized (monitor()) {
            check_orphaned();
            PpType ppTypeFind_element_user = get_store().find_element_user(PP$2, i);
            if (ppTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            ppTypeFind_element_user.set(ppType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setPpArray(PpType[] ppTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ppTypeArr, PP$2);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setTpArray(int i, TpType tpType) {
        synchronized (monitor()) {
            check_orphaned();
            TpType tpTypeFind_element_user = get_store().find_element_user(TP$4, i);
            if (tpTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            tpTypeFind_element_user.set(tpType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public void setTpArray(TpType[] tpTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(tpTypeArr, TP$4);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public int sizeOfCpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CP$0);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public int sizeOfFldArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FLD$6);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public int sizeOfPpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PP$2);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.TextType
    public int sizeOfTpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TP$4);
        }
        return iCount_elements;
    }
}
