package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCellMergeTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTTcPrInnerImpl extends CTTcPrBaseImpl implements CTTcPrInner {
    private static final QName CELLINS$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cellIns");
    private static final QName CELLDEL$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cellDel");
    private static final QName CELLMERGE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cellMerge");

    public CTTcPrInnerImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public CTTrackChange addNewCellDel() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CELLDEL$2);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public CTTrackChange addNewCellIns() {
        CTTrackChange cTTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChangeAdd_element_user = get_store().add_element_user(CELLINS$0);
        }
        return cTTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public CTCellMergeTrackChange addNewCellMerge() {
        CTCellMergeTrackChange cTCellMergeTrackChangeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCellMergeTrackChangeAdd_element_user = get_store().add_element_user(CELLMERGE$4);
        }
        return cTCellMergeTrackChangeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public CTTrackChange getCellDel() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CELLDEL$2, 0);
            if (cTTrackChangeFind_element_user == null) {
                return null;
            }
            return cTTrackChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public CTTrackChange getCellIns() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChangeFind_element_user = get_store().find_element_user(CELLINS$0, 0);
            if (cTTrackChangeFind_element_user == null) {
                return null;
            }
            return cTTrackChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public CTCellMergeTrackChange getCellMerge() {
        synchronized (monitor()) {
            check_orphaned();
            CTCellMergeTrackChange cTCellMergeTrackChangeFind_element_user = get_store().find_element_user(CELLMERGE$4, 0);
            if (cTCellMergeTrackChangeFind_element_user == null) {
                return null;
            }
            return cTCellMergeTrackChangeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public boolean isSetCellDel() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CELLDEL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public boolean isSetCellIns() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CELLINS$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public boolean isSetCellMerge() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CELLMERGE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public void setCellDel(CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CELLDEL$2;
            CTTrackChange cTTrackChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTrackChangeFind_element_user == null) {
                cTTrackChangeFind_element_user = (CTTrackChange) get_store().add_element_user(qName);
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public void setCellIns(CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CELLINS$0;
            CTTrackChange cTTrackChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTrackChangeFind_element_user == null) {
                cTTrackChangeFind_element_user = (CTTrackChange) get_store().add_element_user(qName);
            }
            cTTrackChangeFind_element_user.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public void setCellMerge(CTCellMergeTrackChange cTCellMergeTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CELLMERGE$4;
            CTCellMergeTrackChange cTCellMergeTrackChangeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCellMergeTrackChangeFind_element_user == null) {
                cTCellMergeTrackChangeFind_element_user = (CTCellMergeTrackChange) get_store().add_element_user(qName);
            }
            cTCellMergeTrackChangeFind_element_user.set(cTCellMergeTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public void unsetCellDel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CELLDEL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public void unsetCellIns() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CELLINS$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrInner
    public void unsetCellMerge() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CELLMERGE$4, 0);
        }
    }
}
