package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.chart.STXstring;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTNumDataImpl extends XmlComplexContentImpl implements CTNumData {
    private static final QName FORMATCODE$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "formatCode");
    private static final QName PTCOUNT$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ptCount");
    private static final QName PT$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "pt");
    private static final QName EXTLST$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTNumDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$6);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public CTNumVal addNewPt() {
        CTNumVal cTNumVal;
        synchronized (monitor()) {
            check_orphaned();
            cTNumVal = (CTNumVal) get_store().add_element_user(PT$4);
        }
        return cTNumVal;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public CTUnsignedInt addNewPtCount() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PTCOUNT$2);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$6, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public String getFormatCode() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(FORMATCODE$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public CTNumVal getPtArray(int i) {
        CTNumVal cTNumVal;
        synchronized (monitor()) {
            check_orphaned();
            cTNumVal = (CTNumVal) get_store().find_element_user(PT$4, i);
            if (cTNumVal == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNumVal;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public CTNumVal[] getPtArray() {
        CTNumVal[] cTNumValArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PT$4, arrayList);
            cTNumValArr = new CTNumVal[arrayList.size()];
            arrayList.toArray(cTNumValArr);
        }
        return cTNumValArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public CTUnsignedInt getPtCount() {
        synchronized (monitor()) {
            check_orphaned();
            CTUnsignedInt cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PTCOUNT$2, 0);
            if (cTUnsignedInt == null) {
                return null;
            }
            return cTUnsignedInt;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public List<CTNumVal> getPtList() {
        1PtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public CTNumVal insertNewPt(int i) {
        CTNumVal cTNumVal;
        synchronized (monitor()) {
            check_orphaned();
            cTNumVal = (CTNumVal) get_store().insert_element_user(PT$4, i);
        }
        return cTNumVal;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public boolean isSetFormatCode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FORMATCODE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public boolean isSetPtCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PTCOUNT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public void removePt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PT$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$6;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public void setFormatCode(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMATCODE$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public void setPtArray(int i, CTNumVal cTNumVal) {
        synchronized (monitor()) {
            check_orphaned();
            CTNumVal cTNumVal2 = (CTNumVal) get_store().find_element_user(PT$4, i);
            if (cTNumVal2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTNumVal2.set(cTNumVal);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public void setPtArray(CTNumVal[] cTNumValArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTNumValArr, PT$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public void setPtCount(CTUnsignedInt cTUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PTCOUNT$2;
            CTUnsignedInt cTUnsignedInt2 = (CTUnsignedInt) typeStore.find_element_user(qName, 0);
            if (cTUnsignedInt2 == null) {
                cTUnsignedInt2 = (CTUnsignedInt) get_store().add_element_user(qName);
            }
            cTUnsignedInt2.set(cTUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public int sizeOfPtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PT$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public void unsetFormatCode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMATCODE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public void unsetPtCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PTCOUNT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public STXstring xgetFormatCode() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_element_user(FORMATCODE$0, 0);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData
    public void xsetFormatCode(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMATCODE$0;
            STXstring sTXstring2 = (STXstring) typeStore.find_element_user(qName, 0);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_element_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }
}
