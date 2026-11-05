package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendEntry;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTLegendImpl extends XmlComplexContentImpl implements CTLegend {
    private static final QName LEGENDPOS$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "legendPos");
    private static final QName LEGENDENTRY$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "legendEntry");
    private static final QName LAYOUT$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "layout");
    private static final QName OVERLAY$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "overlay");
    private static final QName SPPR$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
    private static final QName TXPR$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "txPr");
    private static final QName EXTLST$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTLegendImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$12);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLayout addNewLayout() {
        CTLayout cTLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTLayout = (CTLayout) get_store().add_element_user(LAYOUT$4);
        }
        return cTLayout;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLegendEntry addNewLegendEntry() {
        CTLegendEntry cTLegendEntryAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLegendEntryAdd_element_user = get_store().add_element_user(LEGENDENTRY$2);
        }
        return cTLegendEntryAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLegendPos addNewLegendPos() {
        CTLegendPos cTLegendPos;
        synchronized (monitor()) {
            check_orphaned();
            cTLegendPos = (CTLegendPos) get_store().add_element_user(LEGENDPOS$0);
        }
        return cTLegendPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTBoolean addNewOverlay() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(OVERLAY$6);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$8);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTTextBody addNewTxPr() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().add_element_user(TXPR$10);
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$12, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLayout getLayout() {
        synchronized (monitor()) {
            check_orphaned();
            CTLayout cTLayout = (CTLayout) get_store().find_element_user(LAYOUT$4, 0);
            if (cTLayout == null) {
                return null;
            }
            return cTLayout;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLegendEntry getLegendEntryArray(int i) {
        CTLegendEntry cTLegendEntryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLegendEntryFind_element_user = get_store().find_element_user(LEGENDENTRY$2, i);
            if (cTLegendEntryFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLegendEntryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLegendEntry[] getLegendEntryArray() {
        CTLegendEntry[] cTLegendEntryArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LEGENDENTRY$2, arrayList);
            cTLegendEntryArr = new CTLegendEntry[arrayList.size()];
            arrayList.toArray(cTLegendEntryArr);
        }
        return cTLegendEntryArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public List<CTLegendEntry> getLegendEntryList() {
        1LegendEntryList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LegendEntryList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLegendPos getLegendPos() {
        synchronized (monitor()) {
            check_orphaned();
            CTLegendPos cTLegendPos = (CTLegendPos) get_store().find_element_user(LEGENDPOS$0, 0);
            if (cTLegendPos == null) {
                return null;
            }
            return cTLegendPos;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTBoolean getOverlay() {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBoolean = (CTBoolean) get_store().find_element_user(OVERLAY$6, 0);
            if (cTBoolean == null) {
                return null;
            }
            return cTBoolean;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTShapeProperties getSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeProperties cTShapeProperties = (CTShapeProperties) get_store().find_element_user(SPPR$8, 0);
            if (cTShapeProperties == null) {
                return null;
            }
            return cTShapeProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTTextBody getTxPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextBody cTTextBody = (CTTextBody) get_store().find_element_user(TXPR$10, 0);
            if (cTTextBody == null) {
                return null;
            }
            return cTTextBody;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLegendEntry insertNewLegendEntry(int i) {
        CTLegendEntry cTLegendEntryInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLegendEntryInsert_element_user = get_store().insert_element_user(LEGENDENTRY$2, i);
        }
        return cTLegendEntryInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public boolean isSetLayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LAYOUT$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public boolean isSetLegendPos() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEGENDPOS$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public boolean isSetOverlay() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OVERLAY$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPPR$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public boolean isSetTxPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TXPR$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void removeLegendEntry(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEGENDENTRY$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$12;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setLayout(CTLayout cTLayout) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LAYOUT$4;
            CTLayout cTLayout2 = (CTLayout) typeStore.find_element_user(qName, 0);
            if (cTLayout2 == null) {
                cTLayout2 = (CTLayout) get_store().add_element_user(qName);
            }
            cTLayout2.set(cTLayout);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setLegendEntryArray(int i, CTLegendEntry cTLegendEntry) {
        synchronized (monitor()) {
            check_orphaned();
            CTLegendEntry cTLegendEntryFind_element_user = get_store().find_element_user(LEGENDENTRY$2, i);
            if (cTLegendEntryFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLegendEntryFind_element_user.set(cTLegendEntry);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setLegendEntryArray(CTLegendEntry[] cTLegendEntryArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTLegendEntryArr, LEGENDENTRY$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setLegendPos(CTLegendPos cTLegendPos) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEGENDPOS$0;
            CTLegendPos cTLegendPos2 = (CTLegendPos) typeStore.find_element_user(qName, 0);
            if (cTLegendPos2 == null) {
                cTLegendPos2 = (CTLegendPos) get_store().add_element_user(qName);
            }
            cTLegendPos2.set(cTLegendPos);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setOverlay(CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OVERLAY$6;
            CTBoolean cTBoolean2 = (CTBoolean) typeStore.find_element_user(qName, 0);
            if (cTBoolean2 == null) {
                cTBoolean2 = (CTBoolean) get_store().add_element_user(qName);
            }
            cTBoolean2.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setSpPr(CTShapeProperties cTShapeProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPPR$8;
            CTShapeProperties cTShapeProperties2 = (CTShapeProperties) typeStore.find_element_user(qName, 0);
            if (cTShapeProperties2 == null) {
                cTShapeProperties2 = (CTShapeProperties) get_store().add_element_user(qName);
            }
            cTShapeProperties2.set(cTShapeProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setTxPr(CTTextBody cTTextBody) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TXPR$10;
            CTTextBody cTTextBody2 = (CTTextBody) typeStore.find_element_user(qName, 0);
            if (cTTextBody2 == null) {
                cTTextBody2 = (CTTextBody) get_store().add_element_user(qName);
            }
            cTTextBody2.set(cTTextBody);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public int sizeOfLegendEntryArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LEGENDENTRY$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void unsetLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LAYOUT$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void unsetLegendPos() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEGENDPOS$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void unsetOverlay() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OVERLAY$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPPR$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void unsetTxPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TXPR$10, 0);
        }
    }
}
