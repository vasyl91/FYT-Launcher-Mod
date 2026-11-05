package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTStrDataImpl extends XmlComplexContentImpl implements CTStrData {
    private static final QName PTCOUNT$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "ptCount");
    private static final QName PT$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "pt");
    private static final QName EXTLST$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTStrDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$4);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTStrVal addNewPt() {
        CTStrVal cTStrVal;
        synchronized (monitor()) {
            check_orphaned();
            cTStrVal = (CTStrVal) get_store().add_element_user(PT$2);
        }
        return cTStrVal;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTUnsignedInt addNewPtCount() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PTCOUNT$0);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$4, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTStrVal getPtArray(int i) {
        CTStrVal cTStrVal;
        synchronized (monitor()) {
            check_orphaned();
            cTStrVal = (CTStrVal) get_store().find_element_user(PT$2, i);
            if (cTStrVal == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStrVal;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTStrVal[] getPtArray() {
        CTStrVal[] cTStrValArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PT$2, arrayList);
            cTStrValArr = new CTStrVal[arrayList.size()];
            arrayList.toArray(cTStrValArr);
        }
        return cTStrValArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTUnsignedInt getPtCount() {
        synchronized (monitor()) {
            check_orphaned();
            CTUnsignedInt cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PTCOUNT$0, 0);
            if (cTUnsignedInt == null) {
                return null;
            }
            return cTUnsignedInt;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public List<CTStrVal> getPtList() {
        1PtList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PtList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public CTStrVal insertNewPt(int i) {
        CTStrVal cTStrVal;
        synchronized (monitor()) {
            check_orphaned();
            cTStrVal = (CTStrVal) get_store().insert_element_user(PT$2, i);
        }
        return cTStrVal;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public boolean isSetPtCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PTCOUNT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void removePt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PT$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$4;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void setPtArray(int i, CTStrVal cTStrVal) {
        synchronized (monitor()) {
            check_orphaned();
            CTStrVal cTStrVal2 = (CTStrVal) get_store().find_element_user(PT$2, i);
            if (cTStrVal2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTStrVal2.set(cTStrVal);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void setPtArray(CTStrVal[] cTStrValArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTStrValArr, PT$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void setPtCount(CTUnsignedInt cTUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PTCOUNT$0;
            CTUnsignedInt cTUnsignedInt2 = (CTUnsignedInt) typeStore.find_element_user(qName, 0);
            if (cTUnsignedInt2 == null) {
                cTUnsignedInt2 = (CTUnsignedInt) get_store().add_element_user(qName);
            }
            cTUnsignedInt2.set(cTUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public int sizeOfPtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PT$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData
    public void unsetPtCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PTCOUNT$0, 0);
        }
    }
}
